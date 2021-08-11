package com.epam.training.tasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ThirdTaskTest {
	private static ThirdTask thirdTask;

	@BeforeAll
	static void setUp() {
		thirdTask = new ThirdTask();
	}

	@Test
	void testCreateListOfFilesInDirectoryAndItsSubdirectories() {
		File directory = new File("testFiles\\testDirectory");
		List<File> expectedList = Arrays.asList(
				new File("testFiles\\testDirectory\\fileInTestDirectory.txt").getAbsoluteFile(),
				new File("testFiles\\testDirectory\\subTestDirectory\\fileInSubTestDirectory.txt").getAbsoluteFile());
		thirdTask.createListOfFilesInDirectoryAndItsSubdirectories(directory);
		assertEquals(expectedList, thirdTask.getListOfDirectoryFiles());
	}
}
