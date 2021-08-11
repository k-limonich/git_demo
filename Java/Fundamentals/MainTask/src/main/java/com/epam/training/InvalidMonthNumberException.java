package com.epam.training;

public class InvalidMonthNumberException extends RuntimeException {

	public InvalidMonthNumberException() {
		super();
	}

	public InvalidMonthNumberException(String message) {
		super(message);
	}

	public InvalidMonthNumberException(String message, Throwable cause) {
		super(message, cause);
	}
}
