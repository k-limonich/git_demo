package com.epam.training.taxi.cars;

import com.epam.training.taxi.brands.BudgetRateBrand;

import java.util.Objects;

public class BudgetRateCar extends Car {
	private BudgetRateBrand brand;

	public BudgetRateCar(int cost, double gasConsumption, int mileage,
						 double averageSpeed, BudgetRateBrand brand) {
		super(cost, gasConsumption, mileage, averageSpeed);
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
		BudgetRateCar budgetRateCar = (BudgetRateCar) o;
		return brand == budgetRateCar.brand;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), brand);
	}
}
