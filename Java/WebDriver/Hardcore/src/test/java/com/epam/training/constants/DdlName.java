package com.epam.training.constants;

public enum DdlName {

	OPERATING_SYSTEM("Operating System"),
	MACHINE_CLASS("Machine Class"),
	SERIES("Series"),
	MACHINE_TYPE("Machine type"),
	NUMBER_OF_GPUS("Number of GPUs"),
	GPU_TYPE("GPU type"),
	LOCAL_SSD("Local SSD"),
	DATACENTER_LOCATION("Datacenter location"),
	COMMITTED_USAGE("Committed usage");

	private final String name;

	DdlName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
