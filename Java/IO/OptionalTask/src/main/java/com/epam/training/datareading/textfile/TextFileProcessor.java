package com.epam.training.datareading.textfile;

import com.epam.training.datareading.AbstractDataProcessor;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class TextFileProcessor extends AbstractDataProcessor {

	//Task 1
	public static void createFileWithSortedRandomNumbers(int amountOfNumbers, int bound) {
		Random random = new Random();
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < amountOfNumbers; i++) {
			numbers.add(random.nextInt(bound * 2) - bound);
		}
		numbers.sort(Comparator.comparingInt(o -> o));
		writeIntegersToFile("Task1.txt", numbers);
	}

	//Task 5
	public static void toUpperCaseStudentsWithGradeAverageAbove7(String pathname) {
		File file = new File(pathname);
		List<String> fileLines = readFileToStringList(file);
		for (int i = 0; i < fileLines.size(); i++) {
			String oldLine = fileLines.get(i);
			StringBuilder newLine = new StringBuilder();
			int sumOfGrades = 0;
			int numberOfGrades = 0;
			String[] values = oldLine.split("\\p{P}");
			for (int j = 1; j < values.length; j++) {
				sumOfGrades += Integer.parseInt(values[j]);
				numberOfGrades++;
			}
			if (getGradeAverage(sumOfGrades, numberOfGrades) > 7) {
				values[0] = values[0].toUpperCase();
			}
			for (int j = 0; j < values.length; j++) {
				newLine.append(values[j]);
				if (j != values.length - 1) {
					newLine.append(",");
				}
			}
			fileLines.set(i, newLine.toString());
		}
		writeTextToFile("Task5.txt", fileLines);
	}

	//Task 5 auxiliary method
	private static double getGradeAverage(int sum, int number) {
		return (BigDecimal.valueOf((double) sum / number))
				.setScale(1, RoundingMode.HALF_UP).doubleValue();
	}

	//Task 6
	public static void defineAllDataTypes(String pathname, String[] dataTypes) {
		File file = new File(pathname);
		List<String> fileLines = readFileToStringList(file);
		Map<String, String> valuesMap = new HashMap<>();
		for (String line : fileLines) {
			String[] values = line.split("\\p{Blank}");
			for (String value : values) {
				String valueDataType = getDataTypeOf(value);
				if (arrayContains(dataTypes, valueDataType)) {
					valuesMap.put(value, valueDataType);
				}
			}
		}
		valuesMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEach(k -> System.out.println(k.getKey() + " -> " + k.getValue()));
	}

	//Task 6 auxiliary method
	private static String getDataTypeOf(String value) {
		try {
			Integer.parseInt(value);
			return "int";
		} catch (NumberFormatException e) {
			try {
				Double.parseDouble(value);
				return "double";
			} catch (NumberFormatException ex) {
				if (value.length() == 1) { return "char"; }
				else { return "String"; }
			}
		}
	}

	//Task 6 auxiliary method
	private static boolean arrayContains(String[] dataTypes, String dataType) {
		for (String element : dataTypes) {
			if (element.equals(dataType)) { return true; }
		}
		return false;
	}

	//Task 7
	public static void removeMaxEvenNumberOfWordsWith3To5Symbols(String pathname) {
		File file = new File(pathname);
		List<String> fileLines = readFileToStringList(file);
		for (int i = 0; i < fileLines.size(); i++) {
			String line = fileLines.get(i);
			StringBuilder newLine = new StringBuilder();
			String[] words = line.split("\\p{Blank}");
			int wordsToRemoveNumber = countWordsWith3To5Symbols(words);
			if (wordsToRemoveNumber % 2 != 0) { wordsToRemoveNumber--; }
			for (int j = 0, wordsToRemoveCounter = 0; j < words.length; j++) {
				String word = words[j].replaceAll("^\\p{L}", "");
				if (word.length() >= 3 && word.length() <= 5
						&& wordsToRemoveCounter != wordsToRemoveNumber) {
					words[j] = words[j].replaceAll("\\p{L}", "");
					wordsToRemoveCounter++;
				}
			}
			for (int j = 0; j < words.length; j++) {
				newLine.append(words[j]);
				if (j != words.length - 1) {
					newLine.append(" ");
				}
			}
			fileLines.set(i, newLine.toString().replaceAll("\\p{Blank}+", " ").trim());
		}
		writeTextToFile("Task7.txt", fileLines);
	}

	//Task 7 auxiliary method
	private static int countWordsWith3To5Symbols(String[] words) {
		int wordsCount = 0;
		for (String word : words) {
			word = word.replaceAll("^\\p{L}", "");
			if (word.length() >= 3 && word.length() <= 5) {
				wordsCount++;
			}
		}
		return wordsCount;
	}

	//Task 10
	public static void switchFirstAndLastWordsInEachLine(String pathname) {
		File file = new File(pathname);
		List<String> fileLines = readFileToStringList(file);
		for (int i = 0; i < fileLines.size(); i++) {
			String line = fileLines.get(i);
			String[] words = line.split("\\p{Blank}+");
			String firstWordPunctuation = getPunctuation(words[0]);
			String lastWordPunctuation = getPunctuation(words[words.length - 1]);
			String temp = words[0].replaceAll("\\p{P}", "") + lastWordPunctuation;
			words[0] = words[words.length - 1].replaceAll("\\p{P}", "") + firstWordPunctuation;
			words[words.length - 1] = temp;
			line = wordsArrayToString(words);
			fileLines.set(i, line);
		}
		writeTextToFile("Task10.txt", fileLines);
	}

	//Task 10 auxiliary method
	private static String getPunctuation(String word) {
		String punctuation = ".,;:!?";
		char lastChar = word.charAt(word.length() - 1);
		if (punctuation.contains(Character.toString(lastChar))) {
			return Character.toString(lastChar);
		}
		return "";
	}

	//Task 10 and 11 auxiliary method
	private static String wordsArrayToString(String[] words) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			stringBuilder.append(words[i]);
			if (i != words.length - 1) {
				stringBuilder.append(" ");
			}
		}
		return stringBuilder.toString();
	}

	//Task 11
	public static void leaveMLastWordsInNLastLines(String pathname, int n, int m) {
		File file = new File(pathname);
		List<String> fileLines = readFileToStringList(file);
		if (n > fileLines.size()) {
			n = 0;
		} else {
			n = fileLines.size() - n;
		}
		for (int i = fileLines.size() - 1; i >= n; i--) {
			String line = fileLines.get(i);
			String[] words = line.split("\\p{Blank}+");
			removeWords(words, m);
			line = wordsArrayToString(words).trim();
			fileLines.set(i, line);
		}
		writeTextToFile("Task11.txt", fileLines);
	}

	//Task 11 auxiliary method
	private static void removeWords(String[] words, int m) {
		if (m > words.length) {
			m = 0;
		} else {
			m = words.length - m;
		}
		for (int i = 0; i < m; i++) {
			words[i] = "";
		}
	}

	//Task 12
	public static void findPalindromes(String pathname) {
		File file = new File(pathname);
		List<String> fileLines = readFileToStringList(file);
		Set<String> palindromes = new HashSet<>();
		for (String line : fileLines) {
			String[] words = line.split("\\p{Blank}+");
			addPalindromes(palindromes, words);
		}
		writeTextToFile("Task12.txt", "Palindromes: " + palindromes);
	}

	//Task 12 auxiliary method
	private static void addPalindromes(Set<String> palindromes, String[] words) {
		for (String word : words) {
			word = word.toLowerCase().replaceAll("[.,;!?\"]", "");
			if (new StringBuilder(word.replaceAll("[\\W]", "")).reverse()
					.toString().equals(word.replaceAll("[\\W]", ""))) {
				palindromes.add(word);
			}
		}
	}

	//Task 13
	public static void findPhonesStartingWith(String pathname, int k, int j) {
		File file = new File(pathname);
		List<String> fileLines = readFileToStringList(file);
		List<String> matchingPhones = new ArrayList<>();
		for (String line : fileLines) {
			String[] values = line.split("\\p{Blank}+");
			values[0] = values[0].substring(6);
			if (values[0].charAt(0) == Character.forDigit(k, 10)
					|| values[0].charAt(0) == Character.forDigit(j, 10)) {
				matchingPhones.add(line);
			}
		}
		writeTextToFile("Task13.java", matchingPhones);
	}
}
