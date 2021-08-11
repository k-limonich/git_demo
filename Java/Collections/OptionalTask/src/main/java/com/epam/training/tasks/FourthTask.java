package com.epam.training.tasks;

import java.io.File;
import java.util.Comparator;
import java.util.List;

public class FourthTask extends FirstTask {

	public FourthTask() {
	}

	public FourthTask(File file) {
		super(file);
	}

	public void sortLinesByLength(List<String> lines) {
		lines.sort(Comparator.comparingInt(String::length));
	}
}
