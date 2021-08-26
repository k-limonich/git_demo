package com.epam.training.datareading.javafile;

import com.epam.training.datareading.AbstractDataProcessor;

import java.io.File;
import java.util.List;

public class JavaFileProcessor extends AbstractDataProcessor {

	//Task 2
	public static void replacePublicFieldsAndMethodsWithPrivate(String pathname) {
		File javaFile = new File(pathname);
		String constructor = javaFile.getName().replace(".java", "") + "(";
		List<String> fileLines = readFileToStringList(javaFile);
		for (int i = 0; i < fileLines.size(); i++) {
			String line = fileLines.get(i);
			if (line.contains("public") && !(line.contains("class"))
					&& !(line.contains("enum")) && !(line.contains("interface"))
					&& !(line.contains(constructor))) {
				fileLines.set(i, line.replace("public", "private"));
			}
		}
		writeTextToFile("Task2.java", fileLines);
	}

	//Task 3
	public static void reverseEachLine(String pathname) {
		File javaFile = new File(pathname);
		List<String> fileLines = readFileToStringList(javaFile);
		for (int i = 0; i < fileLines.size(); i++) {
			StringBuilder line = new StringBuilder(fileLines.get(i));
			fileLines.set(i, line.reverse().toString());
		}
		writeTextToFile("Task3.java", fileLines);
	}

	//Task 4
	public static void toUpperCaseMoreThanTwoLetterWords(String pathname) {
		File javaFile = new File(pathname);
		List<String> fileLines = readFileToStringList(javaFile);
		for (int i = 0; i < fileLines.size(); i++) {
			String oldLine = fileLines.get(i);
			StringBuilder newLine = new StringBuilder();
			StringBuilder word = new StringBuilder();
			for (int j = 0; j < oldLine.length(); j++) {
				if (oldLine.charAt(j) != ' ' && oldLine.charAt(j) != ','
						&& oldLine.charAt(j) != '.' && oldLine.charAt(j) != ';'
						&& oldLine.charAt(j) != '(' && oldLine.charAt(j) != ')'
						&& oldLine.charAt(j) != '{' && oldLine.charAt(j) != '}'
						&& oldLine.charAt(j) != '[' && oldLine.charAt(j) != ']') {
					word.append(oldLine.charAt(j));
				} else {
					if (word.length() > 2) {
						word = new StringBuilder(word.toString().toUpperCase());
					}
					newLine.append(word).append(oldLine.charAt(j));
					word.setLength(0);
				}
			}
			fileLines.set(i, newLine.toString());
		}
		writeTextToFile("Task4.java", fileLines);
	}

	//Task 8
	public static void removeRedundantBlankSpaces(String pathname) {
		File javaFile = new File(pathname);
		List<String> fileLines = readFileToStringList(javaFile);
		for (int i = 0; i < fileLines.size(); i++) {
			String line = fileLines.get(i);
			line = line.replaceAll("\\p{Blank}+", " ");
			line = line.replaceAll("\\p{Blank}+(?=[\\p{P}])", "");
			line = line.replaceAll("(?<=[\\p{P}])\\p{Blank}+", "");
			fileLines.set(i, line.trim());
		}
		writeTextToFile("Task8.java", fileLines);
	}

	//Task 9
	public static void removeComments(String pathname) {
		File javaFile = new File(pathname);
		String fileLine = readFileToString(javaFile);
		fileLine = fileLine.replaceAll("(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/|[ \\t]*//.*)", "");
		writeTextToFile("Task9.java", fileLine);
	}

}
