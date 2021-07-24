package Taxi.Cars;

import Taxi.Brands.ComfortRateBrand;

import java.util.Objects;

public class ComfortRateCar extends Car{
	ComfortRateBrand brand;

	public ComfortRateCar(double value, double gasConsumption, int mileage,
						  int averageSpeed, ComfortRateBrand brand) {
		super(value, gasConsumption, mileage, averageSpeed);
		this.brand = brand;
	}

	public ComfortRateBrand getBrand() { return brand; }

	@Override
	public String toString() {
		return super.toString().replace("[",
				 "[Brand: " + brand +
							", Model: " + brand.getModel() +
							", ");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		ComfortRateCar comfortRateCar = (ComfortRateCar) o;
		return brand == comfortRateCar.brand;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), brand);
	}
}
