package com.epam.training.taxi;

import com.epam.training.taxi.cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Garage {
	private List<Car> cars;

	public Garage(List<Car> cars) {
		this.cars = cars;
	}

	public int calculateCostOfCars() {
		int valueOfCars = 0;

		for (Car car : cars) {
			valueOfCars += car.getCost();
		}
		return valueOfCars;
	}

	public Garage sortByGasConsumption() {
		cars.sort((o1, o2) -> {
			double gasConsumptionDelta = o1.getGasConsumption() - o2.getGasConsumption();
			if (gasConsumptionDelta > 0) { return 1; }
			if (gasConsumptionDelta < 0) { return -1; }
			return 0;
		});
		return this;
	}

	public List<Car> getCarsInAverageSpeedRange(double speedFrom, double speedTo) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Garage garage = (Garage) o;
		return Objects.equals(cars, garage.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars);
	}
}
