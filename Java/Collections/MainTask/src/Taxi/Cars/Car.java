package Taxi.Cars;

import java.util.Objects;

public abstract class Car {
	private int value;
	private double gasConsumption;
	private int mileage;
	private double averageSpeed;

	public Car(int value, double gasConsumption,
			   int mileage, double averageSpeed) {
		this.value = value;
		this.gasConsumption = gasConsumption;
		this.mileage = mileage;
		this.averageSpeed = averageSpeed;
	}

	public int getValue() { return value; }

	public void setValue(int value) { this.value = value; }

	public double getGasConsumption() { return gasConsumption; }

	public void setGasConsumption(double gasConsumption) { this.gasConsumption = gasConsumption; }

	public int getMileage() { return mileage; }

	public void setMileage(int mileage) { this.mileage = mileage; }

	public double getAverageSpeed() { return averageSpeed; }

	public void setAverageSpeed(double averageSpeed) { this.averageSpeed = averageSpeed; }

	@Override
	public String toString() {
		return  "[Value: " + value + " " +
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
		return ((Double.compare(car.value, value) == 0) &&
				(Double.compare(car.gasConsumption, gasConsumption) == 0) &&
				(mileage == car.mileage) &&
				(averageSpeed == car.averageSpeed));
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, gasConsumption, mileage, averageSpeed);
	}
}
