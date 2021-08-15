package com.epam.training.client;

import com.epam.training.bean.Student;
import com.epam.training.constants.FacultyName;
import com.epam.training.exception.InitializationException;

import static com.epam.training.constants.GroupNumber.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Faculty implements IHasStudents {

	private final FacultyName name;
	private final Group[] groups = {new Group(FIRST), new Group(SECOND),
									new Group(THIRD), new Group(FOURTH)};
	private List<Student> students;

	public Faculty(FacultyName facultyName) {
		this.name = facultyName;
	}

	public FacultyName getName() {
		return name;
	}

	public Group[] getGroups() {
		return groups;
	}

	public List<Student> getStudents() {
		if (students == null) {
			throw new InitializationException();
		}
		return students;
	}

	@Override
	public String toString() {
		return "Faculty{" +
				"name=" + name +
				", groups=" + Arrays.toString(groups) +
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
