package com.epam.training.exception;

public class EmptyGroupException extends RuntimeException {

	public EmptyGroupException() {
	}

	public EmptyGroupException(String message) {
		super(message);
	}

	public EmptyGroupException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyGroupException(Throwable cause) {
		super(cause);
	}
}
