package com.epam.training.exceptions;

public class NotAFolderException extends IllegalArgumentException {

	public NotAFolderException() {
	}

	public NotAFolderException(String s) {
		super(s);
	}
}
