package com.epam.training.taxi.brands;

public enum BusinessRateBrand {
	MERCEDES("E-class"), BMW("5"), AUDI("A6");

	private String model;

	BusinessRateBrand(String model) { this.model = model; }

	public String getModel() { return model; }
}
