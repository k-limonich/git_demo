package com.epam.training.tasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FourthTaskTest {
	static private FourthTask fourthTask;

	@BeforeAll
	static void setUp() {
		fourthTask = new FourthTask();
	}

	@Test
	void testSortLinesByLength() {
		List<String> expectedList = Arrays.asList("first line", "second line",
													"another line", "one more line");
		List<String> lines = Arrays.asList("second line", "one more line",
				"first line", "another line");
		fourthTask.sortLinesByLength(lines);
		assertEquals(expectedList, lines);
	}
}
