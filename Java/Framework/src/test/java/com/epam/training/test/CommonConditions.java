package com.epam.training.test;

import com.epam.training.driver.DriverSingleton;
import com.epam.training.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class CommonConditions {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = DriverSingleton.getDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void stopBrowser() {
		DriverSingleton.closeDriver();
	}
}
