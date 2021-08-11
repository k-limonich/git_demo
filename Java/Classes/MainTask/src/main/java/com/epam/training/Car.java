package com.epam.training;

public class Car {
	private String vin;				//Vehicle Identification Number (VIN)
	private String brand;
	private String model;
	private int releaseYear;
	private String color;
	private int price;
	private String licencePlate;

	public Car() {
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	@Override
	public String toString() {
		return "(" +
				"VIN: " + vin +
				"; Brand: " + brand +
				"; Model: " + model +
				"; Release year: " + releaseYear +
				"; Color: " + color +
				"; Price: " + price +
				"; Licence plate: " + licencePlate +
				')';
	}
}
