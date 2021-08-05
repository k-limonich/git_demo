package epamTraining;

import java.util.Scanner;

public class Optional1 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.print("Enter quantity of numbers: ");
		int quantityOfNumbers = scanner.nextInt();
		int[] numbers = new int[quantityOfNumbers];
		for (int i = 0; i < numbers.length; i++) {
			System.out.print("Enter number No." + (i + 1) + ": ");
			numbers[i] = scanner.nextInt();
		}
		switch(menu()) {
			case 1:
				solution.findShortestAndLongestNumber(numbers);
				break;

			case 2:
				solution.displayNumbersSortedByLength(numbers);
				break;

			case 3:
				solution.displayNumbersWithDifferentLengthFromAverage(numbers);
				break;

			case 4:
				solution.findNumberWithLeastAmountOfDifferentDigits(numbers);
				break;

			case 5:
				solution.findQuantityOfNumbersWithEvenDigitsOnly(numbers);
				solution.findQuantityOfNumbersWithEqualAmountOfEvenAndOddDigits(numbers);
				break;

			case 6:
				solution.findNumberWhichDigitsAreArrangedInStrictlyAscendingOrder(numbers);
				break;

			case 7:
				solution.findNumberWithOnlyDifferentDigits(numbers);
				break;

			default:
				throw new IllegalArgumentException("Invalid option");
		}
	}
	static int menu() {
		System.out.println("Choose an option:");
		System.out.println("1 - Find longest and shortest numbers");
		System.out.println("2 - Display numbers in ascending (descending) length order");
		System.out.println("3 - Display numbers with more (less) length than average");
		System.out.println("4 - Find number with the least amount of different digits");
		System.out.println("5 - Find quantity of numbers with even digits only and numbers" +
				" with equal amount of even and odd digits");
		System.out.println("6 - Find number which digits are arranged in strictly ascending order");
		System.out.println("7 - Find number with only different digits");
		System.out.print("?");
		return scanner.nextInt();
	}
}
