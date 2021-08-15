package com.epam.training.client;

import com.epam.training.bean.Student;
import static com.epam.training.constants.FacultyName.*;
import static com.epam.training.constants.Subject.*;

import com.epam.training.constants.GroupNumber;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AbstractBaseTest {
	protected University university;

	@BeforeEach
	protected void setUp() {
		university = new University(getAllStudents());
		university.distributeStudentsByFacultiesAndGroups();
	}

	protected List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Boris Borisov", 18, 1,
				COMPUTER_AIDED_DESIGN, GroupNumber.SECOND,
				Map.of(PROGRAMMING, 7, ENGINEERING_DRAWING, 5, ENGLISH, 8)));
		students.add(new Student("Maria Ivanova", 21, 4,
				INFORMATION_TECHNOLOGIES_AND_CONTROL, GroupNumber.FIRST,
				Map.of(INFORMATION_SECURITY, 6, PROGRAMMING, 5)));
		students.add(new Student("Ivan Ivanov", 22, 4,
				RADIOENGINEERING_AND_ELECTRONICS, GroupNumber.FOURTH,
				Map.of(PHYSICS, 6, ENGLISH, 4)));
		students.add(new Student("Roman Romanov", 19, 2,
				COMPUTER_SYSTEMS_AND_NETWORKS, GroupNumber.FIRST,
				Map.of(PHYSICS, 8, MATHEMATICS, 7)));
		students.add(new Student("Yulia Sergeeva", 17, 1,
				INFOCOMMUNICATIONS, GroupNumber.THIRD,
				Map.of(ENGLISH, 10, PROGRAMMING, 7)));
		students.add(new Student("Denis Denisov", 20, 3,
				ENGINEERING_AND_ECONOMICS, GroupNumber.SECOND,
				Map.of(ECONOMICS, 9, MATHEMATICS, 7)));
		students.add(new Student("Anna Denisova", 20, 3,
				ENGINEERING_AND_ECONOMICS, GroupNumber.SECOND,
				Map.of(STATISTICS, 6, ECONOMICS, 6)));
		return students;
	}
}
