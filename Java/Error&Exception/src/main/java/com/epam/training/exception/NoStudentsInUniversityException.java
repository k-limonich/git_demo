package com.epam.training.exception;

public class NoStudentsInUniversityException extends RuntimeException {

	public NoStudentsInUniversityException() {
	}

	public NoStudentsInUniversityException(String message) {
		super(message);
	}

	public NoStudentsInUniversityException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoStudentsInUniversityException(Throwable cause) {
		super(cause);
	}
}
