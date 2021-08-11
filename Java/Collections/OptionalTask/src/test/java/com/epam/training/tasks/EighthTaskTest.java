package com.epam.training.tasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;

public class EighthTaskTest {
	private static EighthTask eighthTask;

	@BeforeAll
	static void setUp() {
		eighthTask = new EighthTask(new File("testFiles\\file.txt"));
	}

	@Test
	void testGetSetOfDifferentWordsInFile() throws FileNotFoundException {
		HashSet<String> expectedSet = new HashSet<>(Arrays.asList("first", "line", "second",
																	"another", "one", "more"));
		assertEquals(expectedSet, eighthTask.getSetOfDifferentWordsInFile());
	}
}
