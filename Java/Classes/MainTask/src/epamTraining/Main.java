package epamTraining;

import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int numberOfCars = enterNumberOfCars();
		Car[] carsArray = enterCarsArray(numberOfCars);
		Task mainTask = new Task(carsArray);

		switch (menu()) {
			case 'a':
				System.out.print("Enter car brand: ");
				clearInputStream();
				mainTask.findCarsOfGivenBrand(input.nextLine());
				break;

			case 'b':
				System.out.println("Enter car brand and release year:");
				clearInputStream();
				mainTask.findCarsOfGivenBrandAndReleaseYear(input.nextLine(), input.nextInt());
				break;

			case 'c':
				System.out.println("Enter release year and price:");
				clearInputStream();
				mainTask.findCarsOfGivenReleaseYearAndHigherThanGivenPrice(input.nextInt(),
																			input.nextDouble());
				break;

			default:
				throw new IllegalArgumentException("Invalid option. Try again");
		}
	}

	public static int enterNumberOfCars() {
		System.out.print("Enter number of cars: ");
		return input.nextInt();
	}

	public static Car[] enterCarsArray(int numberOfCars) {
		Car[] carsArray = new Car[numberOfCars];

		System.out.print("\nEnter information about cars");
		for (int index = 0; index < carsArray.length; index++) {
			System.out.println("\nCar No." + (index + 1));
			carsArray[index] = new Car();
			System.out.print("VIN: ");
			carsArray[index].setVin(input.next());
			System.out.print("Brand: ");
			clearInputStream();
			carsArray[index].setBrand(input.nextLine());
			System.out.print("Model: ");
			carsArray[index].setModel(input.nextLine());
			System.out.print("Release year: ");
			carsArray[index].setReleaseYear(input.nextInt());
			System.out.print("Color: ");
			carsArray[index].setColor(input.next());
			System.out.print("Price: ");
			carsArray[index].setPrice(input.nextDouble());
			System.out.print("Licence plate: ");
			carsArray[index].setLicencePlate(input.next());
		}
		return carsArray;
	}

	public static char menu() {
		System.out.println("Print options");
		System.out.println("a) Cars of given brand");
		System.out.println("b) Cars of given brand and release year");
		System.out.println("c) Cars of given release year and higher than given price");
		System.out.print("?");
		return (input.next().charAt(0));
	}

	public static void clearInputStream() {
		input.nextLine();
	}
}
