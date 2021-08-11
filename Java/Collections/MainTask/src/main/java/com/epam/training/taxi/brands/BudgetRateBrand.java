package com.epam.training.taxi.brands;

public enum BudgetRateBrand {
	SKODA("Rapid"), HYUNDAI("Solaris"), NISSAN("Almera"), VOLKSWAGEN("Polo");

	private String model;

	BudgetRateBrand(String model) { this.model = model; }

	public String getModel() { return model; }

}
