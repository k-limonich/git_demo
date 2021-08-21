package com.epam.training.exceptions;

public class InvalidFileException extends IllegalArgumentException {

	public InvalidFileException() {
	}

	public InvalidFileException(String s) {
		super(s);
	}
}
