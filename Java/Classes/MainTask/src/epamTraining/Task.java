package epamTraining;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Task {
	private Car[] carsArray;

	public Task(Car[] carsArray) {
		this.carsArray = carsArray;
	}

	private void printCarsArray(Car[] carsArray) {
		for (var car : carsArray) {
			System.out.println(car);
		}
	}

	public void findCarsOfGivenBrand(String brand) {
		ArrayList<Car> searchedCars = new ArrayList<>();
		brand = brand.toLowerCase();
		boolean carsAreFound = false;

		for (var car : carsArray) {
			if (car.getBrand().toLowerCase().compareTo(brand) == 0) {
				searchedCars.add(car);
				carsAreFound = true;
			}
		}
		if (carsAreFound) {
			printCarsArray(searchedCars.toArray(Car[]::new));
		} else {
			System.out.println("\nCars of given brand are not found");
		}
	}

	public void findCarsOfGivenBrandAndReleaseYear(String brand, int releaseYear) {
		ArrayList<Car> searchedCars = new ArrayList<>();
		brand = brand.toLowerCase();
		boolean carsAreFound = false;

		for (var car : carsArray) {
			if ((car.getBrand().toLowerCase().compareTo(brand) == 0)
					&& (car.getReleaseYear() == releaseYear)) {
				searchedCars.add(car);
				carsAreFound = true;
			}
		}
		if (carsAreFound) {
			printCarsArray(searchedCars.toArray(Car[]::new));
		} else {
			System.out.println("\nCars of given brand and release year are not found");
		}
	}

	public void findCarsOfGivenReleaseYearAndHigherThanGivenPrice(int releaseYear, double price) {
		ArrayList<Car> searchedCars = new ArrayList<>();
		price = BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP).doubleValue();
		boolean carsAreFound = false;

		for (var car : carsArray) {
			if ((car.getReleaseYear() == releaseYear)
					&& (car.getPrice() > price)) {
				searchedCars.add(car);
				carsAreFound = true;
			}
		}
		if (carsAreFound) {
			printCarsArray(searchedCars.toArray(Car[]::new));
		} else {
			System.out.println("\nCars of given brand and higher price than given  are not found");
		}
	}
}
