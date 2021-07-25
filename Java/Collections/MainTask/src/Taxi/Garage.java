package Taxi;

import Taxi.Cars.BudgetRateCar;
import Taxi.Cars.BusinessRateCar;
import Taxi.Cars.Car;
import Taxi.Cars.ComfortRateCar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Garage {
	private List<? extends Car> cars;

	public Garage(List<? extends Car> cars) {
		this.cars = cars;
	}

	public List<? extends Car> getCars() { return cars; }

	public List<BudgetRateCar> getBudgetRateCars() {
		List<BudgetRateCar> budgetRateCars = new ArrayList<>();

		for (Car car : cars) {
			if (car instanceof BudgetRateCar) {
				budgetRateCars.add((BudgetRateCar) car);
			}
		}
		return budgetRateCars;
	}

	public List<ComfortRateCar> getComfortRateCars() {
		List<ComfortRateCar> comfortRateCars = new ArrayList<>();

		for (Car car : cars) {
			if (car instanceof ComfortRateCar) {
				comfortRateCars.add((ComfortRateCar) car);
			}
		}
		return comfortRateCars;
	}

	public List<BusinessRateCar> getBusinessRateCars() {
		List<BusinessRateCar> businessRateCars = new ArrayList<>();

		for (Car car : cars) {
			if (car instanceof BusinessRateCar) {
				businessRateCars.add((BusinessRateCar) car);
			}
		}
		return businessRateCars;
	}

	public int calculateValueOfCars() {
		int valueOfCars = 0;

		for (Car car : cars) {
			valueOfCars += car.getValue();
		}
		return valueOfCars;
	}

	public Garage sortByGasConsumption() {
		cars.sort(new Comparator<Car>() {
			@Override
			public int compare(Car o1, Car o2) {
				double gasConsumptionDelta = o1.getGasConsumption() - o2.getGasConsumption();
				if (gasConsumptionDelta > 0) { return 1; }
				if (gasConsumptionDelta < 0) { return -1; }
				return 0;
			}
		});
		return this;
	}

	public List<? extends Car> getCarsInAverageSpeedRange(double speedFrom, double speedTo) {
		List<Car> carsInAverageSpeedRange = new ArrayList<>();

		for (Car car : cars) {
			if ((car.getAverageSpeed() >= speedFrom) && (car.getAverageSpeed() <= speedTo)) {
				carsInAverageSpeedRange.add(car);
			}
		}
		return carsInAverageSpeedRange;
	}

	@Override
	public String toString() {
		return cars.toString().replace(",", "\n");
	}
}
