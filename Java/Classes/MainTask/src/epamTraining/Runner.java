package epamTraining;

import java.util.Scanner;

public class Runner {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int numberOfCars = enterNumberOfCars();
		Car[] carsArray = enterCarsArray(numberOfCars);
		Garage garage = new Garage(carsArray);

		switch (menu()) {
			case 'a':
				System.out.print("Enter car brand: ");
				clearInputStream();
				garage.displayCarsOfGivenBrand(scanner.nextLine());
				break;

			case 'b':
				System.out.println("Enter car brand and exploitation period (in years):");
				clearInputStream();
				garage.displayCarsOfGivenBrandAndExploitationPeriod(scanner.nextLine(),
																	  scanner.nextInt());
				break;

			case 'c':
				System.out.println("Enter release year and price:");
				clearInputStream();
				garage.displayCarsOfGivenReleaseYearAndHigherThanGivenPrice(scanner.nextInt(),
																			  scanner.nextInt());
				break;

			default:
				throw new IllegalArgumentException("Invalid option");
		}
	}

	public static int enterNumberOfCars() {
		System.out.print("Enter number of cars: ");
		return scanner.nextInt();
	}

	public static Car[] enterCarsArray(int numberOfCars) {
		Car[] carsArray = new Car[numberOfCars];

		System.out.print("\nEnter information about cars");
		for (int index = 0; index < carsArray.length; index++) {
			System.out.println("\nCar No." + (index + 1));
			carsArray[index] = new Car();
			System.out.print("VIN: ");
			carsArray[index].setVin(scanner.next());
			System.out.print("Brand: ");
			clearInputStream();
			carsArray[index].setBrand(scanner.nextLine());
			System.out.print("Model: ");
			carsArray[index].setModel(scanner.nextLine());
			System.out.print("Release year: ");
			carsArray[index].setReleaseYear(scanner.nextInt());
			System.out.print("Color: ");
			carsArray[index].setColor(scanner.next());
			System.out.print("Price: ");
			carsArray[index].setPrice(scanner.nextInt());
			System.out.print("Licence plate: ");
			carsArray[index].setLicencePlate(scanner.next());
		}
		return carsArray;
	}

	public static char menu() {
		System.out.println("Print options");
		System.out.println("a) Cars of given brand");
		System.out.println("b) Cars of given brand and exploitation period");
		System.out.println("c) Cars of given release year and higher than given price");
		System.out.print("?");
		return (scanner.next().charAt(0));
	}

	public static void clearInputStream() {
		scanner.nextLine();
	}
}
