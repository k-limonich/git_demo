package com.epam.training.exceptions;

public class NotAFileException extends IllegalArgumentException {

	public NotAFileException() {
	}

	public NotAFileException(String s) {
		super(s);
	}
}
