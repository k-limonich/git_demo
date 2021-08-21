package com.epam.training.exceptions;

public class EmptyCommandLineArgumentsException extends IllegalArgumentException {

	public EmptyCommandLineArgumentsException() {
	}

	public EmptyCommandLineArgumentsException(String s) {
		super(s);
	}
}
