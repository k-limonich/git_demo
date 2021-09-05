package com.epam.training;

import com.epam.training.entity.Plane;
import com.epam.training.resource.Airport;

public class Runner {

	public static void main(String[] args) {
		Airport airport = new Airport(5);
		for (int i = 0; i < 10; i++) {
			new Plane(i, airport).start();
		}
	}
}
