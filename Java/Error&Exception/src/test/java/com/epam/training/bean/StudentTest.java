package com.epam.training.bean;

import static com.epam.training.constants.FacultyName.*;

import com.epam.training.constants.GroupNumber;
import com.epam.training.exception.InvalidGradeException;
import com.epam.training.exception.StudentWithNoSubjectsException;
import static com.epam.training.constants.Subject.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class StudentTest {

	private Student student;

	@BeforeEach
	void setUp() {
		student = new Student("John Peters", 18, 2,
								COMPUTER_AIDED_DESIGN, GroupNumber.FIRST, new HashMap<>());
	}

	@Test
	void testGetGradeAverage() {
		student.getGrades().put(MATHEMATICS, 8);
		student.getGrades().put(PHYSICS, 6);
		student.getGrades().put(ENGLISH, 9);
		assertEquals(7.7, student.getGradeAverage());
	}

	@Test
	void shouldThrowInvalidGradeException() {
		student.getGrades().put(INFORMATION_SECURITY, 11);
		assertThrows(InvalidGradeException.class, () -> student.getGradeAverage());
	}

	@Test
	void shouldThrowStudentWithNoSubjectsException() {
		assertThrows(StudentWithNoSubjectsException.class, () -> student.getGradeAverage());
	}
}
