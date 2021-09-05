package com.epam.training.resource;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Airport {

	private BlockingQueue<Runway> availableRunways;
	private Semaphore semaphore;

	public Airport(int runwaysNumber) {
		availableRunways = new LinkedBlockingQueue<>(runwaysNumber);
		for (int i = 0; i < runwaysNumber; i++) {
			availableRunways.add(new Runway(i));
		}
		semaphore = new Semaphore(runwaysNumber, true);
	}

	public Runway enterRunway() {
		Runway runway = null;
		try {
			semaphore.acquire();
			runway = availableRunways.poll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return runway;
	}

	public void takeOff(Runway runway) {
		availableRunways.add(runway);
		semaphore.release();
	}
}
