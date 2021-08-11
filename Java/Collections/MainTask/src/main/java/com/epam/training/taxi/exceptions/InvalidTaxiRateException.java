package com.epam.training.taxi.exceptions;

public class InvalidTaxiRateException extends IllegalArgumentException {

	public InvalidTaxiRateException() {
		super();
	}

	public InvalidTaxiRateException(String message) {
		super(message);
	}
}
