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
		DataProcessor dataProcessor = new DataProcessor(source);
		if (source.isDirectory()) {
			dataProcessor.writeFolderContentToTextFile();
		} else if (source.isFile()) {
			dataProcessor.getTreeTextFileInfoInConsole();
		} else {
			throw new InvalidFileException();
		}
	}
}
