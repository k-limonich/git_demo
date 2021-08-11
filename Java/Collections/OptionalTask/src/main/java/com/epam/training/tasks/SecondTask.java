package com.epam.training.tasks;

import java.util.Stack;

public class SecondTask {
	private int number;
	private Stack<Integer> digits = new Stack<>();

	public SecondTask(int number) {
		this.number = number;
		getDigit(number);
	}

	private void getDigit(int number) {
		if (number < 10) {
			digits.add(number);
		} else {
			getDigit(number / 10);
			digits.add(number % 10);
		}
	}
	public int getReverseNumber() {
		int reverseNumber = 0;

		for (int i = (int) Math.pow(10, digits.size() - 1); !digits.isEmpty(); i /= 10) {
			reverseNumber += i * digits.pop();
		}
		return reverseNumber;
	}
}
