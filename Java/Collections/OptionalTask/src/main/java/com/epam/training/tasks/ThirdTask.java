package com.epam.training.tasks;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ThirdTask {
	private List<File> listOfDirectoryFiles = new ArrayList<>();

	public List<File> getListOfDirectoryFiles() {
		return listOfDirectoryFiles;
	}

	public void createListOfFilesInDirectoryAndItsSubdirectories(File directory) {
		if (directory.isDirectory()) {
			for (File element : Objects.requireNonNull(directory.listFiles())) {
				if (element.isFile()) {
					listOfDirectoryFiles.add(element.getAbsoluteFile());
				} else if (element.isDirectory()) {
					createListOfFilesInDirectoryAndItsSubdirectories(new File(element.getAbsolutePath()));
				}
			}
		}
	}

	public void printListOfFilesInDirectoryAndItsSubdirectories() {
		for (File file : listOfDirectoryFiles) {
			System.out.println("[" + file.getParentFile() + "] " + file.getName());
		}
	}
}
