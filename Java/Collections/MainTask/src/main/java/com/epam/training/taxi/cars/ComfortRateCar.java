package com.epam.training.taxi.cars;

import com.epam.training.taxi.brands.ComfortRateBrand;

import java.util.Objects;

public class ComfortRateCar extends Car {
	ComfortRateBrand brand;

	public ComfortRateCar(int value, double gasConsumption, int mileage,
						  double averageSpeed, ComfortRateBrand brand) {
		super(value, gasConsumption, mileage, averageSpeed);
		this.brand = brand;
	}

	@Override
	public String toString() {
		return super.toString().replace("[",
				 "[Brand: " + brand + " " +
							"| Model: " + brand.getModel() + " " +
							"| ");
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
