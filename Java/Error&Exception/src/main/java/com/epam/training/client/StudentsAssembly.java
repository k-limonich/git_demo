package com.epam.training.client;

import com.epam.training.bean.Student;

import java.util.List;

public abstract class StudentsAssembly {

	protected List<Student> students;

	protected StudentsAssembly() {
	}

	public StudentsAssembly(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	protected abstract void add(Student newStudent);
}
