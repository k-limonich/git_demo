package com.epam.training.processor;

import com.epam.training.exceptions.NotAFolderException;
import com.epam.training.exceptions.NotAFileException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DataProcessor {

	public static void writeFolderContentToTextFile(File source, File destination) {
		if (!source.isDirectory()) {
			throw new NotAFolderException("source file is not a folder");
		}
		try (FileWriter fileWriter = new FileWriter(destination)) {
			createContentTree(source, fileWriter, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createContentTree(File folder, FileWriter fileWriter, int indent)
			throws IOException {
		if (folder.isDirectory()) {
			fileWriter.write(getIndentString(indent));
			fileWriter.write("+---");
			fileWriter.write(folder.getName() + "/\n");
			for (File file : Objects.requireNonNull(folder.listFiles())) {
				if (file.isDirectory()) {
					createContentTree(file, fileWriter, indent + 1);
				} else if (file.isFile()) {
					fileWriter.write(getIndentString(indent + 1));
					fileWriter.write("+---");
					fileWriter.write(file.getName() + "\n");
				}
			}
		}
	}

	private static String getIndentString(int indent) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < indent; i++) {
			builder.append("|	");
		}
		return builder.toString();
	}

	public static void getTreeTextFileInfoInConsole(File file) {
		if (!file.isFile()) {
			throw new NotAFileException();
		}
		try {
			System.out.println(file.getAbsolutePath());
			System.out.println("Number of folders: " + getNumberOfFolders(file));
			System.out.println("Number of files: " + getNumberOfFiles(file));
			System.out.println("Average number of files in a folder: "
					+ getAverageNumberOfFilesInFolder(file));
			System.out.println("Average file name length: "
					+ getAverageFileNameLength(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int getNumberOfFolders(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		int numberOfDirectories = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.contains("/")) {
				numberOfDirectories++;
			}
		}
		return numberOfDirectories;
	}

	private static int getNumberOfFiles(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		int numberOfFiles = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (!line.contains("/")) {
				numberOfFiles++;
			}
		}
		return numberOfFiles;
	}

	private static double getAverageNumberOfFilesInFolder(File file) throws IOException {
		List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
		int filesInAllFolders = 0;
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).contains("/")) {
				filesInAllFolders += getNumberOfFilesInFolder(lines, i);
			}
		}
		return BigDecimal.valueOf((double) filesInAllFolders / getNumberOfFolders(file))
				.setScale(1, RoundingMode.HALF_UP).doubleValue();
	}

	private static int getNumberOfFilesInFolder(List<String> lines, int index) {
		int filesInThisFolder = 0;
		int baseIndent = getIndentValue(lines.get(index));
		for (int i = index + 1; i < lines.size(); i++) {
			int currentIndent = getIndentValue(lines.get(i));
			if (currentIndent > baseIndent && !(lines.get(i).contains("/"))) {
				filesInThisFolder++;
			} else if (currentIndent == baseIndent) { break; }
		}
		return filesInThisFolder;
	}

	private static int getIndentValue(String line) {
		return StringUtils.countMatches(line, "|");
	}

	private static double getAverageFileNameLength(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		int numberOfFiles = 0;
		int sumOfFileNameLengths = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (!line.contains("/")) {
				numberOfFiles++;
				String fileName = StringUtils.replaceChars(line, "|", "");
				fileName = StringUtils.remove(fileName, "+---");
				fileName = StringUtils.replaceChars(fileName, "\n\t", "");
				sumOfFileNameLengths += fileName.length();
			}
		}
		return BigDecimal.valueOf((double) sumOfFileNameLengths / numberOfFiles)
				.setScale(1, RoundingMode.HALF_UP).doubleValue();
	}
}
