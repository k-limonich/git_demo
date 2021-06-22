package epam.training;

import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		menu();
		int choice = in.nextInt();
		switch(choice) {
			case 1:
				greetUser(args[0]);
				break;
			case 2:
				displayArgsInReverse(args);
				break;
			case 3:
				displayRandomNumbers();
				break;
			case 4:
				calculateNumbers(args);
				break;
			case 5:
				matchMonthByNumber();
				break;
			case 6:
				break;
			default:
				throw new IllegalArgumentException("invalid option");
		}
	}
	public static void menu() {
		System.out.println("Main task program");
		System.out.println("Choose an option:");
		System.out.println("1 - Greet user");
		System.out.println("2 - Display CLI args in reverse order");
		System.out.println("3 - Display fixed number of random integers");
		System.out.println("4 - Add/multiply two integers, entered as CLI args");
		System.out.println("5 - Display month by corresponding number");
		System.out.println("6 - Exit program");
		System.out.println("Note: for options 1, 2, 4 you have to pass CLI arguments into main() " +
				"otherwise an exception will be generated");
		System.out.print("\n?");
	}
	public static void greetUser(String name) {
		System.out.println("Hello, " + name);
	}
	public static void displayArgsInReverse(String[] args) {
		for (int i = args.length - 1; i >= 0; i--) {
			System.out.println(args[i]);
		}
	}
	public static void displayRandomNumbers() {
		System.out.print("Enter number of integers: ");
		int numOfIntegers = in.nextInt();
		Random number = new Random();
		for (int i = 0; i < numOfIntegers; i++) {
			if (i % 2 == 0) {
				System.out.print(number.nextInt());
				continue;
			}
			System.out.println(" " + number.nextInt());
		}
	}
	public static void calculateNumbers(String[] numbers) {
		int sum = 0;
		int product = 1;
		for (String number : numbers) {
			sum += Integer.parseInt(number);
			product *= Integer.parseInt(number);
		}
		System.out.println("The sum of numbers: " + sum);
		System.out.println("The product of numbers: " + product);
	}
	public static void matchMonthByNumber() {
		System.out.print("Enter number of the month: ");
		try {
			int monthNumber = in.nextInt();
			if (monthNumber < 1 || monthNumber > 12) {
				throw new Exception("invalid month number");
			}
			String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
					"September", "October", "November", "December"};
			System.out.println("Month number " + monthNumber + " is " + months[monthNumber - 1]);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
