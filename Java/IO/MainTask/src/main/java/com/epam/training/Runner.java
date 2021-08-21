package com.epam.training;

import com.epam.training.exceptions.EmptyCommandLineArgumentsException;
import com.epam.training.exceptions.InvalidFileException;
import com.epam.training.processor.DataProcessor;

import java.io.File;

public class Runner {

	public static void main(String[] args) {
		if (args.length == 0) {
			throw new EmptyCommandLineArgumentsException();
		}
		File source = new File(args[0]);
		if (source.isDirectory()) {
			DataProcessor.writeFolderContentToTextFile(source, new File("tree.txt"));
		} else if (source.isFile()) {
			DataProcessor.getTreeTextFileInfoInConsole(source);
		} else {
			throw new InvalidFileException();
		}
	}
}
