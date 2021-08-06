package epamTraining;

import java.time.Year;
import java.util.ArrayList;

public class Task {
	private Car[] carsArray;

	public Task(Car[] carsArray) {
		this.carsArray = carsArray;
	}

	public void displayCarsOfGivenBrand(String brand) {
		ArrayList<Car> searchedCars = new ArrayList<>();
		brand = brand.toLowerCase();

		for (Car car : carsArray) {
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

		for (Car car : carsArray) {
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

		for (Car car : carsArray) {
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
