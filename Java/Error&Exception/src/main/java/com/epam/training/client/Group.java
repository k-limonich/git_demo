package com.epam.training.client;

import com.epam.training.bean.Student;
import com.epam.training.constants.GroupNumber;
import com.epam.training.exception.InitializationException;

import java.util.ArrayList;
import java.util.List;

public class Group implements IHasStudents {

	private final GroupNumber groupNumber;
	private List<Student> students;

	public Group(GroupNumber groupNumber) {
		this.groupNumber = groupNumber;
	}

	public GroupNumber getGroupNumber() {
		return groupNumber;
	}

	public List<Student> getStudents() {
		return students;
	}

	@Override
	public String toString() {
		return "Group{" +
				"groupNumber=" + groupNumber +
				", students=" + students +
				'}';
	}

	@Override
	public boolean addStudent(Student newStudent) {
		if (students == null) {
			students = new ArrayList<>();
		}
		return students.add(newStudent);
	}

	@Override
	public boolean isEmpty() {
		if (students == null) {
			throw new InitializationException();
		}
		return students.isEmpty();
	}
}
