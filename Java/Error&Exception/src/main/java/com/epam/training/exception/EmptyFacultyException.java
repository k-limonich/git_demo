package com.epam.training.exception;

public class EmptyFacultyException extends RuntimeException {

	public EmptyFacultyException() {
	}

	public EmptyFacultyException(String message) {
		super(message);
	}

	public EmptyFacultyException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyFacultyException(Throwable cause) {
		super(cause);
	}
}
