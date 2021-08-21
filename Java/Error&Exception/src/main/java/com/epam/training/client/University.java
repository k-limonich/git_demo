package com.epam.training.client;

import com.epam.training.bean.Student;
import com.epam.training.constants.FacultyName;
import com.epam.training.constants.GroupNumber;
import com.epam.training.exception.*;
import com.epam.training.constants.Subject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static com.epam.training.constants.FacultyName.*;

public class University extends StudentsAssembly {

	private final Faculty[] faculties = {
			new Faculty(COMPUTER_AIDED_DESIGN), new Faculty(INFORMATION_TECHNOLOGIES_AND_CONTROL),
			new Faculty(RADIOENGINEERING_AND_ELECTRONICS), new Faculty(COMPUTER_SYSTEMS_AND_NETWORKS),
			new Faculty(INFOCOMMUNICATIONS), new Faculty(ENGINEERING_AND_ECONOMICS)};

	public University(List<Student> students) {
		super(students);
	}

	public Faculty[] getFaculties() {
		return faculties;
	}

	@Override
	public String toString() {
		return "University{" +
				"faculties=" + Arrays.toString(faculties) +
				'}';
	}

	@Override
	public void add(Student newStudent) {
		if (!students.contains(newStudent)) {
			students.add(newStudent);
			int facultyOrdinal = newStudent.getFaculty().ordinal();
			faculties[facultyOrdinal].add(newStudent);
			int groupOrdinal = newStudent.getGroupNumber().ordinal();
			faculties[facultyOrdinal].getGroups()[groupOrdinal].add(newStudent);
		}
	}

	public void distributeStudentsByFacultiesAndGroups() {
		if ((students == null) || (students.isEmpty())) {
			throw new NoStudentsInUniversityException();
		}
		for (Student student : students) {
			int facultyOrdinal = student.getFaculty().ordinal();
			faculties[facultyOrdinal].add(student);
			int groupOrdinal = student.getGroupNumber().ordinal();
			faculties[facultyOrdinal].getGroups()[groupOrdinal].add(student);
		}
	}

	public double getGradeAverageFor(Subject subject) {
		double gradesSum = 0;
		int numberOfStudentsWithSubject = 0;
		for (Student student : students) {
			if ((student.getGrades() == null) || (student.getGrades().isEmpty())) {
				throw new StudentWithNoSubjectsException();
			}
			if (student.getGrades().containsKey(subject)) {
				if ((student.getGrades().get(subject) < 0) || (student.getGrades().get(subject) > 10)) {
					throw new InvalidGradeException();
				}
				gradesSum += student.getGrades().get(subject);
				numberOfStudentsWithSubject++;
			}
		}
		if (numberOfStudentsWithSubject == 0) {
			throw new NoStudentsWithSuchSubjectException();
		}
		return (BigDecimal.valueOf(gradesSum / numberOfStudentsWithSubject)
				.setScale(1, RoundingMode.HALF_UP).doubleValue());
	}

	public double getGradeAverageFor(Subject subject, FacultyName faculty, GroupNumber group) {
		if (faculties[faculty.ordinal()].getStudents().isEmpty()) {
			throw new EmptyFacultyException();
		}
		if (faculties[faculty.ordinal()].getGroups()[group.ordinal()].getStudents().isEmpty()) {
			throw new EmptyGroupException();
		}
		double gradesSum = 0;
		int numberOfStudentsWithSubject = 0;
		for (Student student : students) {
			if ((student.getGrades() == null) || (student.getGrades().isEmpty())) {
				throw new StudentWithNoSubjectsException();
			}
			if ((student.getFaculty().equals(faculty))
					&& (student.getGroupNumber().equals(group))
					&& (student.getGrades().containsKey(subject))) {
				if ((student.getGrades().get(subject) < 0) || (student.getGrades().get(subject) > 10)) {
					throw new InvalidGradeException();
				}
				gradesSum += student.getGrades().get(subject);
				numberOfStudentsWithSubject++;
			}
		}
		if (numberOfStudentsWithSubject == 0) {
			throw new NoStudentsWithSuchSubjectException();
		}
		return (BigDecimal.valueOf(gradesSum / numberOfStudentsWithSubject)
				.setScale(1, RoundingMode.HALF_UP).doubleValue());
	}
}
