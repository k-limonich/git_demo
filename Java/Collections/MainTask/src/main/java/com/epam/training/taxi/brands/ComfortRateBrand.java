package com.epam.training.taxi.brands;

public enum ComfortRateBrand {
	TOYOTA("Camry"), KIA("Optima"), HYUNDAI("Sonata");

	private String model;

	ComfortRateBrand(String model) { this.model = model; }

	public String getModel() { return model; }
}
