package com.epam.training.exception;

public class NoStudentsWithSuchSubjectException extends RuntimeException {

	public NoStudentsWithSuchSubjectException() {
	}

	public NoStudentsWithSuchSubjectException(String message) {
		super(message);
	}

	public NoStudentsWithSuchSubjectException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoStudentsWithSuchSubjectException(Throwable cause) {
		super(cause);
	}
}
