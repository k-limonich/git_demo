package com.epam.training.model;

import java.util.Objects;

public class CalculatorForm {

	private int numberOfInstances;
	private String operatingSystem;
	private String machineClass;
	private String series;
	private String machineType;
	private boolean needGPUs;
	private int numberOfGPUs;
	private String gpuType;
	private String localSSD;
	private String datacenterLocation;
	private String committedUsage;

	public String getNumberOfInstances() {
		return String.valueOf(numberOfInstances);
	}

	public void setNumberOfInstances(int numberOfInstances) {
		this.numberOfInstances = numberOfInstances;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getMachineClass() {
		return machineClass;
	}

	public void setMachineClass(String machineClass) {
		this.machineClass = machineClass;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	public boolean needGPUs() {
		return needGPUs;
	}

	public void setNeedGPUs(boolean needGPUs) {
		this.needGPUs = needGPUs;
	}

	public String getNumberOfGPUs() {
		return String.valueOf(numberOfGPUs);
	}

	public void setNumberOfGPUs(int numberOfGPUs) {
		this.numberOfGPUs = numberOfGPUs;
	}

	public String getGpuType() {
		return gpuType;
	}

	public void setGpuType(String gpuType) {
		this.gpuType = gpuType;
	}

	public String getLocalSSD() {
		return localSSD;
	}

	public void setLocalSSD(String localSSD) {
		this.localSSD = localSSD;
	}

	public String getDatacenterLocation() {
		return datacenterLocation;
	}

	public void setDatacenterLocation(String datacenterLocation) {
		this.datacenterLocation = datacenterLocation;
	}

	public String getCommittedUsage() {
		return committedUsage;
	}

	public void setCommittedUsage(String committedUsage) {
		this.committedUsage = committedUsage;
	}

	@Override
	public String toString() {
		return "CalculatorForm{" +
				"numberOfInstances=" + numberOfInstances +
				", operatingSystem='" + operatingSystem + '\'' +
				", machineClass='" + machineClass + '\'' +
				", series='" + series + '\'' +
				", machineType='" + machineType + '\'' +
				", addGPUs=" + needGPUs +
				", numberOfGPUs=" + numberOfGPUs +
				", gpuType='" + gpuType + '\'' +
				", localSSD='" + localSSD + '\'' +
				", datacenterLocation='" + datacenterLocation + '\'' +
				", committedUsage='" + committedUsage + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CalculatorForm that = (CalculatorForm) o;
		return numberOfInstances == that.numberOfInstances && needGPUs == that.needGPUs
				&& numberOfGPUs == that.numberOfGPUs && Objects.equals(operatingSystem, that.operatingSystem)
				&& Objects.equals(machineClass, that.machineClass) && Objects.equals(series, that.series)
				&& Objects.equals(machineType, that.machineType) && Objects.equals(gpuType, that.gpuType)
				&& Objects.equals(localSSD, that.localSSD) && Objects.equals(datacenterLocation, that.datacenterLocation)
				&& Objects.equals(committedUsage, that.committedUsage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numberOfInstances, operatingSystem, machineClass, series, machineType, needGPUs,
				numberOfGPUs, gpuType, localSSD, datacenterLocation, committedUsage);
	}
}
