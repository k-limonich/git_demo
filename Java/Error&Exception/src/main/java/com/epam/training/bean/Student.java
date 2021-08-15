package com.epam.training.bean;

import com.epam.training.constants.GroupNumber;
import com.epam.training.exception.InitializationException;
import com.epam.training.exception.InvalidGradeException;
import com.epam.training.exception.StudentWithNoSubjectsException;
import com.epam.training.constants.FacultyName;
import com.epam.training.constants.Subject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Objects;

public class Student {

	private String fullName;
	private int age;
	private int yearOfStudy;
	private FacultyName faculty;
	private GroupNumber groupNumber;
	private Map<Subject, Integer> grades;

	public Student(String fullName, int age, int yearOfStudy, FacultyName faculty,
				   GroupNumber groupNumber, Map<Subject, Integer> grades) {
		this.fullName = fullName;
		this.age = age;
		this.yearOfStudy = yearOfStudy;
		this.faculty = faculty;
		this.groupNumber = groupNumber;
		this.grades = grades;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public FacultyName getFaculty() {
		return faculty;
	}

	public void setFaculty(FacultyName faculty) {
		this.faculty = faculty;
	}

	public GroupNumber getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(GroupNumber groupNumber) {
		this.groupNumber = groupNumber;
	}

	public Map<Subject, Integer> getGrades() {
		return grades;
	}

	public void setGrades(Map<Subject, Integer> grades) {
		this.grades = grades;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return age == student.age && yearOfStudy == student.yearOfStudy && Objects.equals(fullName, student.fullName) && faculty == student.faculty && Objects.equals(groupNumber, student.groupNumber) && Objects.equals(grades, student.grades);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fullName, age, yearOfStudy, faculty, groupNumber, grades);
	}

	@Override
	public String toString() {
		return "Student{" +
				"fullName='" + fullName + '\'' +
				", age=" + age +
				", yearOfStudy=" + yearOfStudy +
				", faculty=" + faculty +
				", groupNumber='" + groupNumber + '\'' +
				", grades=" + grades +
				'}';
	}

	public double getGradeAverage() {
		if (grades == null) {
			throw new InitializationException();
		}
		if (grades.isEmpty()) {
			throw new StudentWithNoSubjectsException();
		}
		double gradesSum = 0;
		int numberOfGrades = grades.size();
		for (Map.Entry<Subject, Integer> grade : grades.entrySet()) {
			if ((grade.getValue() < 0) || (grade.getValue() > 10)) {
				throw new InvalidGradeException("Invalid grade: " + grade.getValue());
			}
			gradesSum += grade.getValue();
		}
		return (BigDecimal.valueOf(gradesSum / numberOfGrades)
				.setScale(1, RoundingMode.HALF_UP).doubleValue());
	}
}
