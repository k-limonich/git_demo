package com.epam.training.taxi.cars;

import com.epam.training.taxi.brands.BusinessRateBrand;

import java.util.Objects;

public class BusinessRateCar extends Car {
	private BusinessRateBrand brand;

	public BusinessRateCar(int value, double gasConsumption, int mileage,
						   double averageSpeed, BusinessRateBrand brand) {
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
		BusinessRateCar businessRateCar = (BusinessRateCar) o;
		return brand == businessRateCar.brand;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), brand);
	}
}
