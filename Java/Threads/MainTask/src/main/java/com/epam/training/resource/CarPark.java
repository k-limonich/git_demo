package com.epam.training.resource;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CarPark {

	private final int id;
	private BlockingQueue<ParkingSpace> availableParkingSpaces;
	private Semaphore semaphore;

	public CarPark(int id, int size) {
		this.id = id;
		availableParkingSpaces = new LinkedBlockingQueue<>(size);
		for (int i = 0; i < size; i++) {
			availableParkingSpaces.add(new ParkingSpace(id, i));
		}
		semaphore = new Semaphore(size, true);
	}

	public int getId() {
		return id;
	}

	public ParkingSpace takeParkingSpace(long maxWaitingMillis) {
		ParkingSpace parkingSpace = null;
		try {
			if (semaphore.tryAcquire(maxWaitingMillis, TimeUnit.MILLISECONDS)) {
				parkingSpace = availableParkingSpaces.poll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return parkingSpace;
	}

	public void leaveParkingSpace(ParkingSpace parkingSpace) {
		availableParkingSpaces.add(parkingSpace);
		semaphore.release();
	}

	@Override
	public String toString() {
		return "CAR PARK #" + id +
				", AVAILABLE PARKING SPACES: " + availableParkingSpaces.size();
	}
}
