package com.epam.training.client;

import static com.epam.training.constants.FacultyName.*;

import com.epam.training.bean.Student;
import com.epam.training.constants.GroupNumber;

import static com.epam.training.constants.Subject.*;
import static com.epam.training.constants.Subject.ENGINEERING_DRAWING;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FacultyTest extends AbstractBaseTest {

	@Test
	void testAddNewStudent() {
		Faculty faculty = university.getFaculties()[COMPUTER_AIDED_DESIGN.ordinal()];
		Student newStudent = new Student("Ilya Ivanov", 19, 2,
				COMPUTER_AIDED_DESIGN, GroupNumber.FIRST,
				Map.of(PHYSICS, 5, ENGLISH, 6));
		List<Student> expectedStudents = new ArrayList<>(faculty.getStudents());
		expectedStudents.add(newStudent);
		university.addStudent(newStudent);
		assertEquals(expectedStudents, faculty.getStudents());
	}

	@Test
	void testAddExistingStudent() {
		Faculty faculty = university.getFaculties()[COMPUTER_AIDED_DESIGN.ordinal()];
		Student newStudent = new Student("Boris Borisov", 18, 1,
				COMPUTER_AIDED_DESIGN, GroupNumber.SECOND,
				Map.of(PROGRAMMING, 7, ENGINEERING_DRAWING, 5, ENGLISH, 8));
		List<Student> expectedStudents = new ArrayList<>(faculty.getStudents());
		university.addStudent(newStudent);
		assertEquals(expectedStudents, faculty.getStudents());
	}
}
