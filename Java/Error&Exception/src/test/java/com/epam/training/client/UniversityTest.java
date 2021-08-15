package com.epam.training.client;

import static org.junit.jupiter.api.Assertions.*;

import com.epam.training.bean.Student;
import static com.epam.training.constants.FacultyName.*;
import static com.epam.training.constants.Subject.*;

import com.epam.training.constants.GroupNumber;
import com.epam.training.exception.InvalidGradeException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UniversityTest extends AbstractBaseTest {

	@Test
	void testAddNewStudent() {
		Student newStudent = new Student("Ilya Ivanov", COMPUTER_AIDED_DESIGN,
				GroupNumber.FIRST, Map.of(PHYSICS, 5, ENGLISH, 6));
		List<Student> expectedStudents = new ArrayList<>(university.getStudents());
		expectedStudents.add(newStudent);
		university.add(newStudent);
		assertEquals(expectedStudents, university.getStudents());
	}

	@Test
	void testAddExistingStudent() {
		Student newStudent = new Student("Boris Borisov", COMPUTER_AIDED_DESIGN,
				GroupNumber.SECOND, Map.of(PROGRAMMING, 7, ENGINEERING_DRAWING, 5));
		List<Student> expectedStudents = new ArrayList<>(university.getStudents());
		university.add(newStudent);
		assertEquals(expectedStudents, university.getStudents());
	}

	@Test
	void testGetGradeAverageForSubject() {
		double expectedGradeAverage = 6.3;
		double actualGradeAverage = university.getGradeAverageFor(PROGRAMMING);
		assertEquals(expectedGradeAverage, actualGradeAverage);
	}

	@Test
	void testGetGradeAverageForSubjectInGivenGroupAtGivenFaculty() {
		double expectedGradeAverage = 7.5;
		double actualGradeAverage = university.getGradeAverageFor(ECONOMICS, ENGINEERING_AND_ECONOMICS,
																	GroupNumber.SECOND);
		assertEquals(expectedGradeAverage, actualGradeAverage);
	}

	@Test
	void shouldThrowInvalidGradeException() {
		university.add(new Student("Boris Borisov", COMPUTER_AIDED_DESIGN,
				GroupNumber.SECOND, Map.of(PROGRAMMING, -1, ENGINEERING_DRAWING, 5)));
		assertThrows(InvalidGradeException.class, () -> university.getGradeAverageFor(PROGRAMMING));
	}
}
