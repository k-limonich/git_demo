package epamTraining;

import java.util.*;

public class Solution {

	public void findShortestAndLongestNumber(int[] numbers) {
		int shortestNumber = 0;
		int shortestNumberLength = Integer.MAX_VALUE;
		int longestNumber = 0;
		int longestNumberLength = 0;

		for (int number : numbers) {
			int numberLength = calculateNumberLength(number);
			if (numberLength > longestNumberLength) {
				longestNumberLength = numberLength;
				longestNumber = number;
			}

			if (numberLength < shortestNumberLength) {
				shortestNumberLength = numberLength;
				shortestNumber = number;
			}
		}
		System.out.println("The shortest number: " + shortestNumber + ", length: " +
				shortestNumberLength + " digit(-s)");
		System.out.println("The longest number: " + longestNumber + ", length: " +
				longestNumberLength + " digit(-s)");
	}

	private int calculateNumberLength(int number) {
		if (number == 0) {
			return 1;
		}
		return (number > 0 ? (int) (Math.log10(number) + 1) : (int) (Math.log10(Math.abs(number)) + 1));
	}

	public void displayNumbersSortedByLength(int[] numbers) {
		Arrays.sort(numbers);
		System.out.println("Numbers in ascending order by length:\n" + Arrays.toString(numbers));
		System.out.println("\nNumbers in descending order by length:");
		for (int i = numbers.length - 1; i >= 0; i--) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}

	private int findAverageNumberLengthValue(int[] numbers) {
		int sumOfAverageNumberLengthValues = 0;

		for (int number : numbers) {
			sumOfAverageNumberLengthValues += calculateNumberLength(number);
		}
		return (sumOfAverageNumberLengthValues / numbers.length);
	}

	public void displayNumbersWithDifferentLengthFromAverage(int[] numbers) {
		int averageNumberLength = findAverageNumberLengthValue(numbers);

		System.out.println("Numbers with more than average length:");
		for (int number : numbers) {
			if (calculateNumberLength(number) > averageNumberLength) {
				System.out.print(number + " ");
			}
		}
		System.out.println("\nNumbers with less than average length:");
		for (int number : numbers) {
			if (calculateNumberLength(number) < averageNumberLength) {
				System.out.print(number + " ");
			}
		}
	}

	public void findNumberWithLeastAmountOfDifferentDigits(int[] numbers) {
		int leastNumberOfDifferentDigits = findAmountOfDifferentDigits(numbers[0]);
		int numberWithLeastAmountOfDifferentDigits = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			int differentDigitsCounter = findAmountOfDifferentDigits(numbers[i]);
			if (differentDigitsCounter < leastNumberOfDifferentDigits) {
				leastNumberOfDifferentDigits = differentDigitsCounter;
				numberWithLeastAmountOfDifferentDigits = numbers[i];
			}
		}
		System.out.println("Number with least amount of different digits: " + numberWithLeastAmountOfDifferentDigits);
	}

	private int findAmountOfDifferentDigits(int number) {
		int numberOfDifferentDigits = 0;
		int[] numbersOfOccurrencesOfEachDigit = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int numberCopy = number;

		if (number == 0) {
			return 1;
		}
		while(numberCopy != 0) {
			int digit = numberCopy % 10;
			numbersOfOccurrencesOfEachDigit[digit]++;
			numberCopy /= 10;
		}
		for (int numberOfOccurrences : numbersOfOccurrencesOfEachDigit) {
			if (numberOfOccurrences != 0) {
				numberOfDifferentDigits++;
			}
		}
		return numberOfDifferentDigits;
	}

	public void findQuantityOfNumbersWithEvenDigitsOnly(int[] numbers) {
		int quantityOfNumbersWithEvenDigitsOnly = 0;
		boolean isEvenDigit = true;

		for (int number : numbers) {
			if (number == 0) {
				quantityOfNumbersWithEvenDigitsOnly++;
				continue;
			}
			while (number != 0) {
				int digit = number % 10;
				if (digit % 2 != 0) {
					isEvenDigit = false;
					break;
				}
				number /= 10;
			}
			if (isEvenDigit) {
				quantityOfNumbersWithEvenDigitsOnly++;
			}
		}
		System.out.println("Quantity of numbers with even digits: " + quantityOfNumbersWithEvenDigitsOnly);
	}
	public void findQuantityOfNumbersWithEqualAmountOfEvenAndOddDigits(int[] numbers) {
		int quantityOfNumbersWithEqualAmountOfEvenAndOddDigits = 0;

		for (int number : numbers) {
			int amountOfEvenDigits = 0;
			int amountOfOddDigits = 0;
			while (number != 0) {
				int digit = number % 10;
				if (digit % 2 == 0) {
					amountOfEvenDigits++;
				} else {
					amountOfOddDigits++;
				}
				number /= 10;
			}
			if (amountOfEvenDigits == amountOfOddDigits) {
				quantityOfNumbersWithEqualAmountOfEvenAndOddDigits++;
			}
		}
		System.out.println("Quantity of numbers with equal amount of even and odd digits: " +
				quantityOfNumbersWithEqualAmountOfEvenAndOddDigits);
	}

	public void findNumberWhichDigitsAreArrangedInStrictlyAscendingOrder(int[] numbers) {
		for (int number : numbers) {
			boolean numberIsFound = true;
			int numberCopy = number;
			int[] digits = new int[calculateNumberLength(number)];
			int i = 0;
			while (numberCopy != 0) {
				int digit = numberCopy % 10;
				digits[i] = digit;
				numberCopy /= 10;
				i++;
			}
			int previousDigit = digits[0];
			for (int j = 1; j < digits.length; j++) {
				if (digits[j] < previousDigit) {
					previousDigit = digits[j];
					numberIsFound = true;
				} else {
					numberIsFound = false;
					break;
				}
			}
			if (numberIsFound) {
				System.out.println("The number is: " + number);
				break;
			}
		}
	}

	public void findNumberWithOnlyDifferentDigits(int[] numbers) {
		for (int number : numbers) {
			if (hasOnlyDifferentDigits(number)) {
				System.out.println("Number with different digits: " + number);
				break;
			}
		}
	}

	private boolean hasOnlyDifferentDigits(int number) {
		int[] numbersOfOccurrencesOfEachDigit = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int numberCopy = number;

		if (number == 0) {
			return true;
		}
		while(numberCopy != 0) {
			int digit = numberCopy % 10;
			numbersOfOccurrencesOfEachDigit[digit]++;
			numberCopy /= 10;
		}
		for (int numberOfOccurrences : numbersOfOccurrencesOfEachDigit) {
			if (numberOfOccurrences != 0 && numberOfOccurrences != 1) {
				return false;
			}
		}
		return true;
	}
}
