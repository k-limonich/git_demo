package com.epam.training.tasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SecondTaskTest {
	private static SecondTask secondTask;

	@BeforeAll
	static void setUp() {
		secondTask = new SecondTask(123);
	}

	@Test
	void testGetReverseNumber() {
		assertEquals(321, secondTask.getReverseNumber());
	}
}
