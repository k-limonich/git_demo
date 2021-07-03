package epamTraining;

import java.util.Scanner;

public class Optional1 {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.print("Enter quantity of numbers: ");
		int quantityOfNumbers = in.nextInt();
		int[] numbers = new int[quantityOfNumbers];
		for (int i = 0; i < numbers.length; i++) {
			System.out.print("Enter number No." + (i + 1) + ": ");
			numbers[i] = in.nextInt();
		}
		int choice = menu();
		switch(choice) {
			case 1:
				Solution.findShortestAndLongestNumber(numbers);
				break;

			case 2:
				Solution.displayNumbersSortedByLength(numbers);
				break;

			case 3:
				Solution.displayNumbersWithDifferentFromAverageLength(numbers);
				break;

			case 4:
				Solution.findNumberWithLeastAmountOfDifferentDigits(numbers);
				break;

			case 5:
				Solution.findQuantityOfNumbersWithEvenDigitsOnly(numbers);
				Solution.findQuantityOfNumbersWithEqualAmountOfEvenAndOddDigits(numbers);
				break;

			case 6:
				Solution.findNumberWhichDigitsAreArrangedInStrictlyAscendingOrder(numbers);
				break;

			case 7:
				Solution.findNumberWithDifferentDigits(numbers);
				break;

			default:
				throw new IllegalStateException("Unexpected value: " + choice);
		}
	}
	static int menu() {
		System.out.println("Optional Task 1");
		System.out.println("Choose an option:");
		System.out.println("1 - Find longest and shortest numbers");
		System.out.println("2 - Display numbers in ascending (descending) length order");
		System.out.println("3 - Display numbers with more (less) length than average");
		System.out.println("4 - Find number with the least amount of different digits");
		System.out.println("5 - Find quantity of numbers with even digits only and numbers" +
				" with equal amount of even and odd digits");
		System.out.println("6 - Find number which digits are arranged in strictly ascending order");
		System.out.println("7 - Find number with different digits");
		System.out.print("?");
		return in.nextInt();
	}
}
