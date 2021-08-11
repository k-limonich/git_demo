package com.epam.training;

import com.epam.training.tasks.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		switch (menu()) {
			case 1:
				FirstTask firstTask = new FirstTask(new File("taskFiles\\file.txt"));
				try {
					List<String> lines = firstTask.getListOfLinesFromFile();
					firstTask.writeLinesToFileInReverse(lines, "taskFiles\\reverseFile.txt");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;

			case 2:
				SecondTask secondTask = new SecondTask(123);
				System.out.println(secondTask.getReverseNumber());
				break;

			case 3:
				ThirdTask thirdTask = new ThirdTask();
				thirdTask.createListOfFilesInDirectoryAndItsSubdirectories(new File("directory"));
				thirdTask.printListOfFilesInDirectoryAndItsSubdirectories();
				break;

			case 4:
				FourthTask fourthTask = new FourthTask(new File("taskFiles\\poem.txt"));
				try {
					List<String> lines = fourthTask.getListOfLinesFromFile();
					fourthTask.sortLinesByLength(lines);
					fourthTask.printLines(lines);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;

			case 5:
				FifthTask fifthTask = new FifthTask(Arrays.asList(-6, -5, 1, -4, 2, 3));
				fifthTask.placeNegativeNumbersAtTheEndAndPositiveNumbersAtTheBeginning();
				System.out.println(fifthTask.getIntegerList());
				break;

			case 6:
				SixthTask sixthTask = new SixthTask(new File("taskFiles\\poem.txt"));
				try {
					List<String> lines = sixthTask.getListOfLinesFromFile();
					sixthTask.sortLinesByAlphabet(lines);
					sixthTask.printLines(lines);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;

			case 7:
				SeventhTask seventhTask = new SeventhTask("([{}()]({[]}))");
				System.out.println(seventhTask.getBracketsString() + "\n" +
						"balanced: " + seventhTask.bracketsAreBalanced() + "\n");
				seventhTask.setBracketsString("[[({[]()})]}");
				System.out.println(seventhTask.getBracketsString() + "\n" +
						"balanced: " + seventhTask.bracketsAreBalanced());
				break;

			case 8:
				EighthTask eighthTask = new EighthTask(new File("taskFiles\\someEnglishText.txt"));
				try {
					HashSet<String> wordsInFile = eighthTask.getSetOfDifferentWordsInFile();
					System.out.println(wordsInFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;

			default:
				throw new IllegalArgumentException("Invalid option");
		}
	}

	public static int menu() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("1 - Print file contents in reverse");
		System.out.println("2 - Print number in reverse");
		System.out.println("3 - Create list of files in a directory and its subdirectory");
		System.out.println("4 - Read poem from file into list and sort its lines by length");
		System.out.println("5 - Move positive and negative elements of list to the" +
							" beginning and to the end respectively");
		System.out.println("6 - Read lines from file into list and sort them");
		System.out.println("7 - Assert true/false placement of brackets");
		System.out.println("8 - Distinguish all different words in a file");
		System.out.print("?");
		return scanner.nextInt();
	}
}
