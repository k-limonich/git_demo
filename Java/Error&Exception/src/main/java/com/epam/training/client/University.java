package com.epam.training.client;

import com.epam.training.bean.Student;
import com.epam.training.constants.FacultyName;
import com.epam.training.constants.GroupNumber;
import com.epam.training.exception.*;
import com.epam.training.constants.Subject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static com.epam.training.constants.FacultyName.*;

public class University implements IHasStudents {

	private final Faculty[] faculties = {
			new Faculty(COMPUTER_AIDED_DESIGN), new Faculty(INFORMATION_TECHNOLOGIES_AND_CONTROL),
			new Faculty(RADIOENGINEERING_AND_ELECTRONICS), new Faculty(COMPUTER_SYSTEMS_AND_NETWORKS),
			new Faculty(INFOCOMMUNICATIONS), new Faculty(ENGINEERING_AND_ECONOMICS)};
	private List<Student> students;

	public University(List<Student> students) {
		this.students = students;
	}

	public Faculty[] getFaculties() {
		return faculties;
	}

	public List<Student> getStudents() {
		return students;
	}

	@Override
	public boolean addStudent(Student newStudent) {
		if (students.contains(newStudent)) {
			return false;
		}
		students.add(newStudent);
		int facultyOrdinal = newStudent.getFaculty().ordinal();
		faculties[facultyOrdinal].addStudent(newStudent);
		int groupOrdinal = newStudent.getGroupNumber().ordinal();
		faculties[facultyOrdinal].getGroups()[groupOrdinal].addStudent(newStudent);
		return true;
	}

	@Override
	public boolean isEmpty() {
		return students.isEmpty();
	}

	public void distributeStudentsByFacultiesAndGroups() {
		if (students == null) {
			throw new InitializationException();
		}
		if (students.isEmpty()) {
			throw new NoStudentsInUniversityException();
		}
		for (Student student : students) {
			int facultyOrdinal = student.getFaculty().ordinal();
			faculties[facultyOrdinal].addStudent(student);
			int groupOrdinal = student.getGroupNumber().ordinal();
			faculties[facultyOrdinal].getGroups()[groupOrdinal].addStudent(student);
		}
	}

	public double getGradeAverageFor(Subject subject) {
		double gradesSum = 0;
		int numberOfStudentsWithSubject = 0;
		for (Student student : students) {
			if (student.getGrades() == null) {
				throw new InitializationException();
			}
			if (student.getGrades().isEmpty()) {
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
		return (BigDecimal.valueOf(gradesSum / numberOfStudentsWithSubject)
				.setScale(1, RoundingMode.HALF_UP).doubleValue());
	}

	public double getGradeAverageFor(Subject subject, FacultyName faculty, GroupNumber group) {
		if (faculties[faculty.ordinal()].isEmpty()) {
			throw new EmptyFacultyException();
		}
		if (faculties[faculty.ordinal()].getGroups()[group.ordinal()].isEmpty()) {
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
		return (BigDecimal.valueOf(gradesSum / numberOfStudentsWithSubject)
				.setScale(1, RoundingMode.HALF_UP).doubleValue());
	}
}
