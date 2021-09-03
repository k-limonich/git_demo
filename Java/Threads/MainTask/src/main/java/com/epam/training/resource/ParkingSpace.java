package com.epam.training.resource;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ParkingSpace {

	private final int carParkId;
	private final int parkingSpaceId;

	public ParkingSpace(int carParkId, int parkingSpaceId) {
		this.carParkId = carParkId;
		this.parkingSpaceId = parkingSpaceId;
	}

	public int getCarParkId() {
		return carParkId;
	}

	public int getParkingSpaceId() {
		return parkingSpaceId;
	}

	public void use() {
		try {
			TimeUnit.MILLISECONDS.sleep(new Random().nextInt(300));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "PARKING SPACE #" + parkingSpaceId +
				" at CAR PARK #" + carParkId;
	}
}
