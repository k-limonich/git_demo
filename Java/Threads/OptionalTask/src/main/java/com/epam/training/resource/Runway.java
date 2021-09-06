package com.epam.training.resource;

import java.util.concurrent.TimeUnit;

public class Runway {

	private int id;

	public Runway(int id) {
		this.id = id;
	}

	public void use() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "RUNWAY #" + id;
	}
}
