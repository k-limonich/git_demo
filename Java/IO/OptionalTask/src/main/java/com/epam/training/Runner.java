package com.epam.training;

import com.epam.training.datareading.javafile.JavaFileProcessor;
import com.epam.training.datareading.textfile.TextFileProcessor;

import java.io.File;
import java.util.Scanner;

public class Runner {

	static final String INPUT_FOLDER = "inputFiles" + File.separator;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter task number (1-13): ");
		switch (scanner.nextInt()) {
			case 1:
				System.out.print("Amount of numbers? ");
				int amountOfNumbers = scanner.nextInt();
				System.out.print("Random numbers bound? ");
				int bound = scanner.nextInt();
				TextFileProcessor.createFileWithSortedRandomNumbers(amountOfNumbers, bound);
				break;

			case 2:
				JavaFileProcessor.replacePublicFieldsAndMethodsWithPrivate(INPUT_FOLDER + "Task2.java");
				break;

			case 3:
				JavaFileProcessor.reverseEachLine(INPUT_FOLDER + "Task3.java");
				break;

			case 4:
				JavaFileProcessor.toUpperCaseMoreThanTwoLetterWords(INPUT_FOLDER + "Task4.java");
				break;

			case 5:
				TextFileProcessor.toUpperCaseStudentsWithGradeAverageAbove7(INPUT_FOLDER + "Task5.txt");
				break;

			case 6:
				TextFileProcessor.defineAllDataTypes(INPUT_FOLDER + "Task6.txt", args);
				break;

			case 7:
				TextFileProcessor.removeMaxEvenNumberOfWordsWith3To5Symbols(INPUT_FOLDER + "Task7.txt");
				break;

			case 8:
				JavaFileProcessor.removeRedundantBlankSpaces(INPUT_FOLDER + "Task8.java");
				break;

			case 9:
				JavaFileProcessor.removeComments(INPUT_FOLDER + "Task9.java");
				break;

			case 10:
				TextFileProcessor.switchFirstAndLastWordsInEachLine(INPUT_FOLDER + "Task10.txt");
				break;

			case 11:
				System.out.print("Value of n? ");
				int n = scanner.nextInt();
				System.out.print("Value of m? ");
				int m = scanner.nextInt();
				TextFileProcessor.leaveMLastWordsInNLastLines(INPUT_FOLDER + "Task11.txt", n, m);
				break;

			case 12:
				TextFileProcessor.findPalindromes(INPUT_FOLDER + "Task12.txt");
				break;

			case 13:
				System.out.print("Value of k? ");
				int k = scanner.nextInt();
				System.out.print("Value of j? ");
				int j = scanner.nextInt();
				TextFileProcessor.findPhonesStartingWith(INPUT_FOLDER + "Task13.txt", k, j);
				break;

			default:
				throw new IllegalArgumentException("invalid option");
		}
	}
}
