package com.epam.training.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.training.page.PasteBinHomePage;

public class PasteBinTest {

	private WebDriver driver;

	private final String rawPasteData = "Hello from WebDriver";
	private final String expirationTimeOption = "10 Minutes";
	private final String pasteName = "helloweb";

	@BeforeMethod
	public void browserSetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void shouldCreateNewPaste() {
		boolean newPasteIsCreated = new PasteBinHomePage(driver)
				.openPage()
				.enterPaste(rawPasteData)
				.selectExpirationTime(expirationTimeOption)
				.enterPasteName(pasteName)
				.createNewPaste();
		Assert.assertTrue(newPasteIsCreated);
	}

	@AfterMethod
	public void browserTearDown() {
		driver.quit();
	}
}
