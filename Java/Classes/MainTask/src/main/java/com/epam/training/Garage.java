package com.epam.training;

import java.time.Year;
import java.util.ArrayList;

public class Garage {
	private Car[] cars;

	public Garage(Car[] cars) {
		this.cars = cars;
	}

	public void displayCarsOfGivenBrand(String brand) {
		ArrayList<Car> searchedCars = new ArrayList<>();
		brand = brand.toLowerCase();

		for (Car car : cars) {
			if (car.getBrand().toLowerCase().compareTo(brand) == 0) {
				searchedCars.add(car);
			}
		}
		if (!searchedCars.isEmpty()) {
			System.out.println(searchedCars.toString().replace(",", "\n"));
		} else {
			System.out.println("\nCars of given brand are not found");
		}
	}

	public void displayCarsOfGivenBrandAndExploitationPeriod(String brand, int givenExploitationPeriod) {
		ArrayList<Car> searchedCars = new ArrayList<>();
		brand = brand.toLowerCase();

		for (Car car : cars) {
			int exploitationPeriod = Year.now().getValue() - car.getReleaseYear();
			if ((car.getBrand().toLowerCase().compareTo(brand) == 0)
					&& (exploitationPeriod == givenExploitationPeriod)) {
				searchedCars.add(car);
			}
		}
		if (!searchedCars.isEmpty()) {
			System.out.println(searchedCars.toString().replace(",", "\n"));
		} else {
			System.out.println("\nCars of given brand and release year are not found");
		}
	}

	public void displayCarsOfGivenReleaseYearAndHigherThanGivenPrice(int releaseYear, int price) {
		ArrayList<Car> searchedCars = new ArrayList<>();

		for (Car car : cars) {
			if ((car.getReleaseYear() == releaseYear)
					&& (car.getPrice() > price)) {
				searchedCars.add(car);
			}
		}
		if (!searchedCars.isEmpty()) {
			System.out.println(searchedCars.toString().replace(",", "\n"));
		} else {
			System.out.println("\nCars of given brand and higher price than given  are not found");
		}
	}
}
