package com.epam.training.client;

import com.epam.training.bean.Student;
import com.epam.training.constants.GroupNumber;

public class Group extends StudentsAssembly {

	private final GroupNumber groupNumber;

	protected Group(GroupNumber groupNumber) {
		this.groupNumber = groupNumber;
	}

	public GroupNumber getGroupNumber() {
		return groupNumber;
	}

	@Override
	public String toString() {
		return "Group{" +
				"groupNumber=" + groupNumber +
				", students=" + students +
				'}';
	}

	@Override
	protected void add(Student newStudent) {
		if (!students.contains(newStudent)) {
			students.add(newStudent);
		}
	}
}
