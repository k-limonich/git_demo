package com.epam.training.tasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SeventhTaskTest {
	private static SeventhTask seventhTask;

	@BeforeAll
	static void setUp() {
		seventhTask = new SeventhTask();
	}

	@Test
	void testBracketsAreBalanced() {
		seventhTask.setBracketsString("({[]})");
		assertTrue(seventhTask.bracketsAreBalanced());
	}

	@Test
	void testBracketsAreNotBalanced() {
		seventhTask.setBracketsString("(()[]{})]");
		assertFalse(seventhTask.bracketsAreBalanced());
	}
}
