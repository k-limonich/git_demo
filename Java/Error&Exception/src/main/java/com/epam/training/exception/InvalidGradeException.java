package com.epam.training.exception;

public class InvalidGradeException extends RuntimeException {

	public InvalidGradeException() {
	}

	public InvalidGradeException(String message) {
		super(message);
	}

	public InvalidGradeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidGradeException(Throwable cause) {
		super(cause);
	}
}
