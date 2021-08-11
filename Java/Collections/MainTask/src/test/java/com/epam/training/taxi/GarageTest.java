package com.epam.training.taxi;

import static com.epam.training.taxi.brands.BudgetRateBrand.*;
import static com.epam.training.taxi.brands.BusinessRateBrand.*;
import static com.epam.training.taxi.brands.ComfortRateBrand.*;
import com.epam.training.taxi.cars.BudgetRateCar;
import com.epam.training.taxi.cars.BusinessRateCar;
import com.epam.training.taxi.cars.Car;
import com.epam.training.taxi.cars.ComfortRateCar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GarageTest {
	private List<Car> cars = Arrays.asList(
			new BudgetRateCar(10_000, 9.1, 129390, 80.4, NISSAN),
			new BusinessRateCar(30_000, 10.9, 290346, 100.5, AUDI),
			new BudgetRateCar(12_000, 8.9, 340998, 89.9, SKODA),
			new ComfortRateCar(20_000, 9.7, 254809, 95.8, TOYOTA)
	);
	private Garage garage;

	@BeforeEach
	void setUp() {
		garage = new Garage(cars);
	}

	@Test
	void testCalculateCostOfCars() {
		assertEquals(72_000, garage.calculateCostOfCars());
	}

	@Test
	void testSortByGasConsumption() {
		Garage sortedByGasConsumptionGarage = new Garage(Arrays.asList(
				new BudgetRateCar(12_000, 8.9, 340998, 89.9, SKODA),
				new BudgetRateCar(10_000, 9.1, 129390, 80.4, NISSAN),
				new ComfortRateCar(20_000, 9.7, 254809, 95.8, TOYOTA),
				new BusinessRateCar(30_000, 10.9, 290346, 100.5, AUDI)
		));
		assertEquals(sortedByGasConsumptionGarage, garage.sortByGasConsumption());
	}

	@Test
	void testGetCarsInAverageSpeedRange() {
		List<Car> carsInAverageSpeedRange = Arrays.asList(
				new BudgetRateCar(12_000, 8.9, 340998, 89.9, SKODA),
				new ComfortRateCar(20_000, 9.7, 254809, 95.8, TOYOTA)
		);
		double speedFrom = 85.0;
		double speedTo = 100.0;
		assertEquals(carsInAverageSpeedRange, garage.getCarsInAverageSpeedRange(speedFrom, speedTo));
	}
}
