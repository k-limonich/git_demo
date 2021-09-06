package com.epam.training.entity;

import com.epam.training.resource.Airport;
import com.epam.training.resource.Runway;

public class Plane extends Thread {

	private int id;
	private Airport airport;

	public Plane(int id, Airport airport) {
		this.id = id;
		this.setName("PLANE #" + id);
		this.airport = airport;
	}

	public void run() {
		System.out.println(this.getName() + " is searching for available runway...");
		Runway runway = null;
		while (runway == null) {
			runway = airport.enterRunway();
		}
		System.out.println(this.getName() + " has entered " + runway);
		runway.use();
		System.out.println(this.getName() + " has taken off the " + runway);
		airport.takeOff(runway);
	}
}
