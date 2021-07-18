package epamTraining;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Car {
	private String vin;				//Vehicle Identification Number (VIN)
	private String brand;
	private String model;
	private int releaseYear;
	private String color;
	private double price;
	private String licencePlate;

	public Car() {
	}

	public Car(String vin, String brand, String model, int releaseYear,
			   String color, double price, String licencePlate) {
		this.vin = vin;
		this.brand = brand;
		this.model = model;
		this.releaseYear = releaseYear;
		this.color = color;
		this.price = BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP).doubleValue();
		this.licencePlate = licencePlate;
	}

	public String getVin() {
		return vin;
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

	public String getModel() {
		return model;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	@Override
	public String toString() {
		return "Car [" +
				"VIN: " + vin +
				"; Brand: " + brand +
				"; Model: " + model +
				"; Release year: " + releaseYear +
				"; Color: " + color +
				"; Price: " + String.format("%.2f", price) +
				"; Licence plate: " + licencePlate +
				']';
	}
}
