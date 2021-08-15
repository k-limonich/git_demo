package com.epam.training.client;

import com.epam.training.bean.Student;

public interface IHasStudents {

	boolean addStudent(Student newStudent);

	boolean isEmpty();
}
