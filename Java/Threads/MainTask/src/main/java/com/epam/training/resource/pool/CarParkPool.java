package com.epam.training.resource.pool;

import com.epam.training.resource.CarPark;
import com.epam.training.resource.ParkingSpace;

import java.util.ArrayList;
import java.util.List;

public class CarParkPool {

	private List<CarPark> availableCarParks = new ArrayList<>();

	public List<CarPark> getAvailableCarParks() {
		return availableCarParks;
	}

	public void addCarParkToPool(CarPark carPark) {
		availableCarParks.add(carPark);
	}

	public ParkingSpace getParkingSpace(long maxWaitingMillis) {
		ParkingSpace parkingSpace = null;
		for (CarPark carPark : availableCarParks) {
			parkingSpace = carPark.takeParkingSpace(maxWaitingMillis);
			if (parkingSpace != null) {
				break;
			} else {
				System.out.println(Thread.currentThread().getName() + " waiting time at CAR PARK #"
						 + carPark.getId() + " is over. " + "Moving to other car park...");
			}
		}
		return parkingSpace;
	}

	public void leaveParkingSpace(ParkingSpace parkingSpace) {
		availableCarParks.stream().filter(carPark -> carPark.getId() == parkingSpace.getCarParkId())
				.findAny().ifPresent(carPark -> carPark.leaveParkingSpace(parkingSpace));
	}
}
