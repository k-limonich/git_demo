package com.epam.training.exception;

public class StudentWithNoSubjectsException extends RuntimeException {

	public StudentWithNoSubjectsException() {
	}

	public StudentWithNoSubjectsException(String message) {
		super(message);
	}

	public StudentWithNoSubjectsException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentWithNoSubjectsException(Throwable cause) {
		super(cause);
	}
}
