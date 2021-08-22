package com.epam.training.processor;

import com.epam.training.exceptions.NotAFolderException;
import com.epam.training.exceptions.NotAFileException;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class DataProcessor extends AbstractDataProcessor {

	public DataProcessor(File file) {
		super(file);
	}

	public void writeFolderContentToTextFile() {
		if (!getSource().isDirectory()) {
			throw new NotAFolderException("source file is not a folder");
		}
		if (DESTINATION.exists()) {
			DESTINATION.delete();
		}
		createContentTree(getSource(), 0);
	}

	private void createContentTree(File folder, int indent) {
		if (folder.isDirectory()) {
			writeDataToFile(getIndentString(indent));
			writeDataToFile("+---" + folder.getName() + "/\n");
			for (File file : Objects.requireNonNull(folder.listFiles())) {
				if (file.isDirectory()) {
					createContentTree(file, indent + 1);
				} else if (file.isFile()) {
					writeDataToFile(getIndentString(indent + 1));
					writeDataToFile("+---" + file.getName() + "\n");
				}
			}
		}
	}

	private String getIndentString(int indent) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < indent; i++) {
			builder.append("|	");
		}
		return builder.toString();
	}

	public void getTreeTextFileInfoInConsole() {
		if (!getSource().isFile()) {
			throw new NotAFileException();
		}
		System.out.println(getSource().getAbsolutePath());
		System.out.println("Number of folders: " + getNumberOfFolders());
		System.out.println("Number of files: " + getNumberOfFiles());
		System.out.println("Average number of files in a folder: "
				+ getAverageNumberOfFilesInFolder());
		System.out.println("Average file name length: "
				+ getAverageFileNameLength());
	}

	private int getNumberOfFolders() {
		List<String> fileLines = readDataFromFile();
		int numberOfDirectories = 0;
		for (String line : fileLines) {
			if (line.contains("/")) {
				numberOfDirectories++;
			}
		}
		return numberOfDirectories;
	}

	private int getNumberOfFiles() {
		List<String> fileLines = readDataFromFile();
		int numberOfFiles = 0;
		for (String line : fileLines) {
			if (!line.contains("/")) {
				numberOfFiles++;
			}
		}
		return numberOfFiles;
	}

	private double getAverageNumberOfFilesInFolder() {
		List<String> fileLines = readDataFromFile();
		int filesInAllFolders = 0;
		for (int i = 0; i < fileLines.size(); i++) {
			if (fileLines.get(i).contains("/")) {
				filesInAllFolders += getNumberOfFilesInFolder(fileLines, i);
			}
		}
		return BigDecimal.valueOf((double) filesInAllFolders / getNumberOfFolders())
				.setScale(1, RoundingMode.HALF_UP).doubleValue();
	}

	private int getNumberOfFilesInFolder(List<String> lines, int index) {
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

	private int getIndentValue(String line) {
		int matches = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '|') {
				matches++;
			}
		}
		return matches;
	}

	private double getAverageFileNameLength() {
		List<String> fileLines = readDataFromFile();
		int numberOfFiles = 0;
		int sumOfFileNameLengths = 0;
		for (String line : fileLines) {
			if (!line.contains("/")) {
				numberOfFiles++;
				line = line.replace("|", "").replace("+---", "");
				line = line.replace("\n\t", "");
				sumOfFileNameLengths += line.length();
			}
		}
		return BigDecimal.valueOf((double) sumOfFileNameLengths / numberOfFiles)
				.setScale(1, RoundingMode.HALF_UP).doubleValue();
	}
}
