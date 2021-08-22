package com.epam.training.processor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDataProcessor {

	private File source;
	protected final File DESTINATION = new File("tree.txt");

	public AbstractDataProcessor(File source) {
		this.source = source;
	}

	public AbstractDataProcessor(String fileName) {
		source = new File(fileName);
	}

	public File getSource() {
		return source;
	}

	protected List<String> readDataFromFile() {
		List<String> lines = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
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

	protected void writeDataToFile(String data) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DESTINATION, true))) {
			bufferedWriter.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
