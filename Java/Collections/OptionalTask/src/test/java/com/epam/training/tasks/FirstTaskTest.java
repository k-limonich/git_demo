package com.epam.training.tasks;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FirstTaskTest {
	static private FirstTask firstTask;

	@BeforeAll
	static void setUp() {
		firstTask = new FirstTask(new File("testFiles\\file.txt"));
	}

	@Test
	void testGetListOfLinesFromFile() throws FileNotFoundException {
		List<String> expectedList = Arrays.asList("first line", "second line",
													"another line", "one more line");
		assertEquals(expectedList, firstTask.getListOfLinesFromFile());
	}

	@Test
	void testWriteLinesToFileInReverse() throws IOException {
		List<String> lines = Arrays.asList("first line", "second line", "another line", "one more line");
		firstTask.writeLinesToFileInReverse(lines,"testFiles\\actualReverseFile.txt");
		File expectedFile = new File("testFiles\\expectedReverseFile.txt");
		File actualFile = new File("testFiles\\actualReverseFile.txt");
		FileUtils.contentEquals(expectedFile, actualFile);
	}
}
