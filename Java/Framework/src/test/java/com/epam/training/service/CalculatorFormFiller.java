package com.epam.training.service;

import com.epam.training.model.CalculatorForm;

public class CalculatorFormFiller {

	private static final String TESTDATA_CALCULATOR_FORM_NUMBER_OF_INSTANCES = "testdata.calculator.form.numberOfInstances";
	private static final String TESTDATA_CALCULATOR_FORM_OPERATING_SYSTEM = "testdata.calculator.form.operatingSystem";
	private static final String TESTDATA_CALCULATOR_FORM_MACHINE_CLASS = "testdata.calculator.form.machineClass";
	private static final String TESTDATA_CALCULATOR_FORM_SERIES = "testdata.calculator.form.series";
	private static final String TESTDATA_CALCULATOR_FORM_MACHINE_TYPE = "testdata.calculator.form.machineType";
	private static final String TESTDATA_CALCULATOR_FORM_ADD_GPUS = "testdata.calculator.form.needGPUs";
	private static final String TESTDATA_CALCULATOR_FORM_NUMBER_OF_GPUS = "testdata.calculator.form.numberOfGPUs";
	private static final String TESTDATA_CALCULATOR_FORM_GPU_TYPE = "testdata.calculator.form.gpuType";
	private static final String TESTDATA_CALCULATOR_FORM_LOCAL_SSD = "testdata.calculator.form.localSSD";
	private static final String TESTDATA_CALCULATOR_FORM_DATACENTER_LOCATION = "testdata.calculator.form.datacenterLocation";
	private static final String TESTDATA_CALCULATOR_FORM_COMMITTED_USAGE = "testdata.calculator.form.committedUsage";

	public static CalculatorForm withDataFromProperty() {
		CalculatorForm calculatorForm = new CalculatorForm();
		calculatorForm.setNumberOfInstances(Integer.parseInt(TestDataReader
				.getTestData(TESTDATA_CALCULATOR_FORM_NUMBER_OF_INSTANCES)));
		calculatorForm.setOperatingSystem(TestDataReader
				.getTestData(TESTDATA_CALCULATOR_FORM_OPERATING_SYSTEM));
		calculatorForm.setMachineClass(TestDataReader
				.getTestData(TESTDATA_CALCULATOR_FORM_MACHINE_CLASS));
		calculatorForm.setSeries(TestDataReader
				.getTestData(TESTDATA_CALCULATOR_FORM_SERIES));
		calculatorForm.setMachineType(TestDataReader
				.getTestData(TESTDATA_CALCULATOR_FORM_MACHINE_TYPE));
		calculatorForm.setNeedGPUs(Boolean.parseBoolean(TestDataReader
				.getTestData(TESTDATA_CALCULATOR_FORM_ADD_GPUS)));
		calculatorForm.setNumberOfGPUs(Integer.parseInt(TestDataReader
				.getTestData(TESTDATA_CALCULATOR_FORM_NUMBER_OF_GPUS)));
		calculatorForm.setGpuType(TestDataReader
				.getTestData(TESTDATA_CALCULATOR_FORM_GPU_TYPE));
		calculatorForm.setLocalSSD(TestDataReader
				.getTestData(TESTDATA_CALCULATOR_FORM_LOCAL_SSD));
		calculatorForm.setDatacenterLocation(TestDataReader
				.getTestData(TESTDATA_CALCULATOR_FORM_DATACENTER_LOCATION));
		calculatorForm.setCommittedUsage(TestDataReader
				.getTestData(TESTDATA_CALCULATOR_FORM_COMMITTED_USAGE));
		return calculatorForm;
	}

}
