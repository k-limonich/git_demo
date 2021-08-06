package Taxi;

import Taxi.Brands.BudgetRateBrand;
import Taxi.Brands.BusinessRateBrand;
import Taxi.Brands.ComfortRateBrand;
import Taxi.Cars.BudgetRateCar;
import Taxi.Cars.BusinessRateCar;
import Taxi.Cars.Car;
import Taxi.Cars.ComfortRateCar;
import Taxi.Exceptions.InvalidTaxiRateException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Runner {
	static List<Car> cars = new ArrayList<>();

	public static void getDataFromFile()
			throws FileNotFoundException, InvalidTaxiRateException, InputMismatchException {
		File file = new File("C:\\temp\\git_demo\\Java\\Collections\\MainTask\\data.txt");
		Scanner scanner = new Scanner(file);

		while (scanner.hasNext()) {
			String rate = scanner.next().replace(":", "");
			String brand = scanner.next().toUpperCase();
			int value = scanner.nextInt();
			double gasConsumption = scanner.nextDouble();
			int mileage = scanner.nextInt();
			double averageSpeed = scanner.nextDouble();

			switch (rate) {
				case "BUDGET":
					cars.add(new BudgetRateCar(value, gasConsumption, mileage,
							 averageSpeed, BudgetRateBrand.valueOf(brand)));
					break;

				case "COMFORT":
					cars.add(new ComfortRateCar(value, gasConsumption, mileage,
							 averageSpeed, ComfortRateBrand.valueOf(brand)));
					break;

				case "BUSINESS":
					cars.add(new BusinessRateCar(value, gasConsumption, mileage,
							 averageSpeed, BusinessRateBrand.valueOf(brand)));
					break;

				default:
					throw new InvalidTaxiRateException("Invalid taxi rate: " + rate);
			}
		}
	}

	public static void main(String[] args) {
		try {
			getDataFromFile();
			Garage taxiGarage = new Garage(cars);

			switch (menu()) {
				case 1:
					System.out.println("Value of cars: " + taxiGarage.calculateValueOfCars());
					break;

				case 2:
					System.out.println("Cars sorted by gas consumption:\n" +
							taxiGarage.sortByGasConsumption().toString());
					break;

				case 3:
					Scanner scanner = new Scanner(System.in);
					System.out.println("Enter range bounds:");
					double speedFrom = scanner.nextDouble();
					double speedTo = scanner.nextDouble();
					System.out.println(taxiGarage.getCarsInAverageSpeedRange(speedFrom, speedTo)
										.toString().replace(',', '\n'));
					break;

				default:
					throw new IllegalArgumentException("Invalid option");
			}
		} catch (FileNotFoundException | InputMismatchException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static int menu() throws InputMismatchException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("1 - Calculate value of cars");
		System.out.println("2 - Sort cars by gas consumption");
		System.out.println("3 - Find cars in given average speed range");
		System.out.print("?");
		return (scanner.nextInt());
	}
}
