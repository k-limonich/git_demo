package com.epam.training.tasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FifthTaskTest {
	private static FifthTask fifthTask;

	@BeforeAll
	static void setUp() {
		fifthTask = new FifthTask(Arrays.asList(-1, -2, 3, 4));
	}

	@Test
	void testPlaceNegativeNumbersAtTheEndAndPositiveNumbersAtTheBeginning() {
		List<Integer> expectedList = Arrays.asList(3, 4, -1, -2);
		fifthTask.placeNegativeNumbersAtTheEndAndPositiveNumbersAtTheBeginning();
		assertEquals(expectedList, fifthTask.getIntegerList());
	}

}
