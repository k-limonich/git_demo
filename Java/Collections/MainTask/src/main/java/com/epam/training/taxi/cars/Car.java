package com.epam.training.taxi.cars;

import java.util.Objects;

public abstract class Car {
	private int cost;
	private double gasConsumption;
	private int mileage;
	private double averageSpeed;

	public Car(int cost, double gasConsumption,
			   int mileage, double averageSpeed) {
		this.cost = cost;
		this.gasConsumption = gasConsumption;
		this.mileage = mileage;
		this.averageSpeed = averageSpeed;
	}

	public int getCost() { return cost; }

	public double getGasConsumption() { return gasConsumption; }

	public double getAverageSpeed() { return averageSpeed; }

	@Override
	public String toString() {
		return  "[Cost: " + cost + " " +
				"| Gas consumption: " + gasConsumption + " " +
				"| Mileage: " + mileage + " " +
				"| Average speed: " + averageSpeed +
				']';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return ((Double.compare(car.cost, cost) == 0) &&
				(Double.compare(car.gasConsumption, gasConsumption) == 0) &&
				(mileage == car.mileage) &&
				(averageSpeed == car.averageSpeed));
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, gasConsumption, mileage, averageSpeed);
	}
}
