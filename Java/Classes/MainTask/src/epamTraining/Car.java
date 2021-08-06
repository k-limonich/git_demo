package epamTraining;

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

	public Car(String vin, String brand, String model, int releaseYear,
			   String color, int price, String licencePlate) {
		this.vin = vin;
		this.brand = brand;
		this.model = model;
		this.releaseYear = releaseYear;
		this.color = color;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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
