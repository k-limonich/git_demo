package com.epam.training.tasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SixthTaskTest {
	private static SixthTask sixthTask;

	@BeforeAll
	static void setUp() {
		sixthTask = new SixthTask();
	}

	@Test
	void testSortLinesByAlphabet() {
		List<String> expectedList = Arrays.asList("first", "fourth", "second", "third");
		List<String> lines = Arrays.asList("first", "second", "third", "fourth");
		sixthTask.sortLinesByAlphabet(lines);
		assertEquals(expectedList, lines);
	}
}
