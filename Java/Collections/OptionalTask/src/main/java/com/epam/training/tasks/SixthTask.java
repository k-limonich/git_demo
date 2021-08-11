package com.epam.training.tasks;

import java.io.File;
import java.util.Comparator;
import java.util.List;

public class SixthTask extends FirstTask {

	public SixthTask() {
	}

	public SixthTask(File file) {
		super(file);
	}

	public void sortLinesByAlphabet(List<String> lines) {
		lines.sort(Comparator.comparingInt(o -> o.charAt(0)));
	}
}
