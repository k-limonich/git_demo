package Taxi.Exceptions;

public class InvalidTaxiRateException extends IllegalArgumentException {

	public InvalidTaxiRateException() {
		super();
	}

	public InvalidTaxiRateException(String message) {
		super(message);
	}
}
