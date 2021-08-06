package epamTraining.Tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstTask {
	private File file;

	public FirstTask(File file) {
		this.file = file;
	}

	public List<String> getListOfLinesFromFile() throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		List<String> lines = new ArrayList<>();

		while (scanner.hasNextLine()) {
			lines.add(scanner.nextLine());
		}
		return lines;
	}

	public void writeLinesToFileInReverse(List<String> lines, String fileName) {
		try (Writer fileWriter = new FileWriter(fileName, false)) {
			for (int i = lines.size() - 1; i >= 0; i--) {
				fileWriter.write(lines.get(i) + System.lineSeparator());
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void printLines(List<String> lines) {
		for (String line : lines) {
			System.out.println(line);
		}
	}
}
