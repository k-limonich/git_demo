package com.epam.training.entity;

import com.epam.training.resource.pool.CarParkPool;
import com.epam.training.resource.ParkingSpace;

public class Car extends Thread {

	private final long MAX_WAITING_MILLIS = 500;

	private int id;
	private boolean isParked;
	private CarParkPool carParkPool;

	public Car(int id, CarParkPool carParkPool) {
		this.id = id;
		this.setName("Car-" + id);
		this.carParkPool = carParkPool;
	}

	public void run() {
		System.out.println(this.getName() + " is searching for parking space...");
		ParkingSpace parkingSpace = null;
		while (parkingSpace == null) {
			parkingSpace = carParkPool.getParkingSpace(MAX_WAITING_MILLIS);
		}
		System.out.println(this.getName() + " has parked at " + parkingSpace);
		isParked = true;
		parkingSpace.use();
		carParkPool.leaveParkingSpace(parkingSpace);
		isParked = false;
		System.out.println(this.getName() + " has left " + parkingSpace);
	}
}
