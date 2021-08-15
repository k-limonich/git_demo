package com.epam.training.client;

import com.epam.training.bean.Student;
import com.epam.training.constants.GroupNumber;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.epam.training.constants.FacultyName.COMPUTER_AIDED_DESIGN;
import static com.epam.training.constants.Subject.*;
import static com.epam.training.constants.Subject.ENGINEERING_DRAWING;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupTest extends AbstractBaseTest {

	@Test
	void testAddNewStudent() {
		Group group = university.getFaculties()[COMPUTER_AIDED_DESIGN.ordinal()].getGroups()[1];
		Student newStudent = new Student("Ilya Ivanov", COMPUTER_AIDED_DESIGN,
				GroupNumber.SECOND, Map.of(PHYSICS, 5, ENGLISH, 6));
		List<Student> expectedStudents = new ArrayList<>(group.getStudents());
		expectedStudents.add(newStudent);
		university.add(newStudent);
		assertEquals(expectedStudents, group.getStudents());
	}

	@Test
	void testAddExistingStudent() {
		Group group = university.getFaculties()[COMPUTER_AIDED_DESIGN.ordinal()].getGroups()[1];
		Student newStudent = new Student("Boris Borisov", COMPUTER_AIDED_DESIGN,
				GroupNumber.SECOND, Map.of(PROGRAMMING, 7, ENGINEERING_DRAWING, 5));
		List<Student> expectedStudents = new ArrayList<>(group.getStudents());
		university.add(newStudent);
		assertEquals(expectedStudents, group.getStudents());
	}
}
