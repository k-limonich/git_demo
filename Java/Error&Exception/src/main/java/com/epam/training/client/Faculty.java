package com.epam.training.client;

import com.epam.training.bean.Student;
import com.epam.training.constants.FacultyName;

import static com.epam.training.constants.GroupNumber.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Faculty extends StudentsAssembly {

	private final FacultyName name;
	private final Group[] groups = {new Group(FIRST), new Group(SECOND),
									new Group(THIRD), new Group(FOURTH)};

	protected Faculty(FacultyName facultyName) {
		this.name = facultyName;
	}

	public FacultyName getName() {
		return name;
	}

	public Group[] getGroups() {
		return groups;
	}

	@Override
	public String toString() {
		return "Faculty{" +
				"name=" + name +
				", groups=" + Arrays.toString(groups) +
				'}';
	}

	@Override
	protected void add(Student newStudent) {
		if (students == null) {
			students = new ArrayList<>();
		}
		students.add(newStudent);
	}
}
