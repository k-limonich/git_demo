package com.epam.training;

import com.epam.training.entity.Car;
import com.epam.training.resource.pool.CarParkPool;
import com.epam.training.resource.CarPark;

import java.util.Random;

public class Runner {

	public static void main(String[] args) {
		CarParkPool carParkPool = setUpPool();
		displayPoolInfo(carParkPool);
		for (int i = 0; i < 150; i++) {
			new Car(i, carParkPool).start();
		}
	}

	public static CarParkPool setUpPool() {
		CarParkPool carParkPool = new CarParkPool();
		for (int i = 0; i < 3; i++) {
			int carParkSize = new Random().nextInt(5) + 7;
			carParkPool.addCarParkToPool(new CarPark(i, carParkSize));
		}
		return carParkPool;
	}

	public static void displayPoolInfo(CarParkPool carParkPool) {
		System.out.println("-------CAR PARK POOL INFORMATION-------");
		for (CarPark carPark : carParkPool.getAvailableCarParks()) {
			System.out.println(carPark);
		}
		System.out.println("\n");
	}
}
