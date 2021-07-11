package epamTraining;

import java.util.*;

public class Solution {

	public static void findShortestAndLongestNumber(int[] numbers) {
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

	private static int calculateNumberLength(int number) {
		if (number == 0) {
			return 1;
		}
		return (number > 0 ? (int) (Math.log10(number) + 1) : (int) (Math.log10(Math.abs(number)) + 1));
	}

	private static void quickSort(int[] array, int leftBorder, int rightBorder) {
		int leftMarker = leftBorder;
		int rightMarker = rightBorder;
		int pivot = array[(leftMarker + rightMarker) / 2];

		do {
			while (calculateNumberLength(array[leftMarker]) < calculateNumberLength(pivot)) {
				leftMarker++;
			}
			while (calculateNumberLength(array[rightMarker]) > calculateNumberLength(pivot)) {
				rightMarker--;
			}
			if (leftMarker <= rightMarker) {
				if (leftMarker < rightMarker) {
					int temp = array[leftMarker];				//swap
					array[leftMarker] = array[rightMarker];		//
					array[rightMarker] = temp;					//
				}
				leftMarker++;
				rightMarker--;
			}
		} while (leftMarker <= rightMarker);
		if (leftMarker < rightBorder) {
			quickSort(array, leftMarker, rightBorder);
		}

		if (leftBorder < rightMarker) {
			quickSort(array, leftBorder, rightMarker);
		}
	}

	public static void displayNumbersSortedByLength(int[] numbers) {
		quickSort(numbers, 0, numbers.length - 1);
		System.out.println("Numbers in ascending order by length:");
		for (int number : numbers) {
			System.out.print(number + " ");
		}
		System.out.println("\nNumbers in descending order by length:");
		for (int i = numbers.length - 1; i >= 0; i--) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}

	private static int findAverageNumberLengthValue(int[] numbers) {
		int sumOfAverageNumberLengthValues = 0;

		for (int number : numbers) {
			sumOfAverageNumberLengthValues += calculateNumberLength(number);
		}
		return sumOfAverageNumberLengthValues / numbers.length;
	}

	public static void displayNumbersWithDifferentFromAverageLength(int[] numbers) {
		int averageNumberLength = findAverageNumberLengthValue(numbers);

		System.out.println("Numbers with more than average length:");
		for (int number : numbers) {
			int numberLength = calculateNumberLength(number);
			if (numberLength > averageNumberLength) {
				System.out.print(number + " ");
			}

		}
		System.out.println("\nNumbers with less than average length:");
		for (int number : numbers) {
			int numberLength = calculateNumberLength(number);
			if (numberLength < averageNumberLength) {
				System.out.print(number + " ");
			}
		}
	}

	public static void findNumberWithLeastAmountOfDifferentDigits(int[] numbers) {
		int leastNumberOfDifferentDigits = Integer.MAX_VALUE;
		int numberWithLeastAmountOfDifferentDigits = numbers[0];

		for (int number : numbers) {
			Stack<Integer> numberDigits = new Stack<>();
			int numberCopy = number;
			while (numberCopy != 0) {
				int digit = numberCopy % 10;
				numberDigits.push(digit);
				numberCopy /= 10;
			}
			int differentDigitsCounter = findAmountOfDifferentDigits(numberDigits);
			if (differentDigitsCounter < leastNumberOfDifferentDigits) {
				leastNumberOfDifferentDigits = differentDigitsCounter;
				numberWithLeastAmountOfDifferentDigits = number;
			}
		}
		System.out.println("Number with least amount of different digits: " + numberWithLeastAmountOfDifferentDigits);
	}

	private static int findAmountOfDifferentDigits(Stack<Integer> numberDigits) {
		int differentDigitsCounter = 1;

		Collections.sort(numberDigits);
		if (numberDigits.size() != 1) {
			int digitForComparison = numberDigits.pop();
			while (!numberDigits.isEmpty()) {
				if (digitForComparison != numberDigits.peek()) {
					differentDigitsCounter++;
				}

				if (!numberDigits.isEmpty()) {
					digitForComparison = numberDigits.pop();
				}
			}
		}
		return differentDigitsCounter;
	}

	public static void findQuantityOfNumbersWithEvenDigitsOnly(int[] numbers) {
		int quantityOfNumbersWithEvenDigitsOnly = 0;
		boolean isEvenDigit = true;

		for (int number : numbers) {
			if (number == 0) {
				quantityOfNumbersWithEvenDigitsOnly++;
				continue;
			}
			while (number != 0) {
				int digit = number % 10;
				if (digit % 2 == 0) {
					isEvenDigit = true;
				} else {
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
	public static void findQuantityOfNumbersWithEqualAmountOfEvenAndOddDigits(int[] numbers) {
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

	public static void findNumberWhichDigitsAreArrangedInStrictlyAscendingOrder(int[] numbers) {
		for (int number : numbers) {
			boolean isSearchedNumber = true;
			int previousDigit = -1;
			int numberCopy = number;
			while (numberCopy != 0) {
				boolean currentDigitIsGreaterThanPrevious = true;
				int currentDigit = numberCopy % 10;
				numberCopy /= 10;
				if (previousDigit != -1) {
					currentDigitIsGreaterThanPrevious = currentDigit < previousDigit;
				}

				if (currentDigitIsGreaterThanPrevious) {
					previousDigit = currentDigit;
				} else {
					isSearchedNumber = false;
					break;
				}
			}
			if (isSearchedNumber) {
				System.out.println("The number is: " + number);
				break;
			}
		}
	}

	public static void findNumberWithDifferentDigits(int[] numbers) {
		for (int number : numbers) {
			Stack<Integer> numberDigits = new Stack<>();
			int numberCopy = number;
			while (numberCopy != 0) {
				int digit = numberCopy % 10;
				numberDigits.push(digit);
				numberCopy /= 10;
			}
			int digitsCounter = calculateNumberLength(number);
			int differentDigitsCounter = findAmountOfDifferentDigits(numberDigits);
			if (differentDigitsCounter == digitsCounter) {
				System.out.println("Number with different digits: " + number);
				break;
			}
		}
	}
}
