package com.epam.training.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class EighthTask {
	private File file;

	public EighthTask(File file) {
		this.file = file;
	}

	public HashSet<String> getSetOfDifferentWordsInFile() throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		HashSet<String> wordsInFile = new HashSet<>();

		while (scanner.hasNext()) {
			wordsInFile.add(scanner.next().toLowerCase()
						.replaceAll("[1234567890%.,;:?-]", ""));
		}
		wordsInFile.removeAll(Collections.singletonList(""));
		return wordsInFile;
	}
}
