package com.epam.training.datareading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class DataProcessUtils {

	private DataProcessUtils() {
	}

	private static final String OUTPUT_FOLDER = "outputFiles";

	public static String readFileToString(File file) {
		StringBuilder data = new StringBuilder();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			int symbol = bufferedReader.read();
			while (symbol != -1) {
				data.append((char) symbol);
				symbol = bufferedReader.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data.toString();
	}

	public static List<String> readFileToStringList(File file) {
		List<String> lines = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				lines.add(line);
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	public static void writeTextToFile(String fileName, String data) {
		File dest = new File(OUTPUT_FOLDER + File.separator + fileName);
		dest.getParentFile().mkdir();
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dest))) {
			bufferedWriter.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeTextToFile(String fileName, List<String> lines) {
		File dest = new File(OUTPUT_FOLDER + File.separator + fileName);
		dest.getParentFile().mkdir();
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dest))) {
			for (int i = 0; i < lines.size(); i++) {
				bufferedWriter.write(lines.get(i));
				if (i != lines.size() - 1) {
					bufferedWriter.newLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeIntegersToFile(String fileName, List<Integer> integerList) {
		File dest = new File(OUTPUT_FOLDER + File.separator + fileName);
		dest.getParentFile().mkdir();
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dest))) {
			for (int i = 0; i < integerList.size(); i++) {
				if (i % 30 == 0 && i != 0) {
					bufferedWriter.newLine();
				}
				bufferedWriter.write(integerList.get(i).toString() + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
