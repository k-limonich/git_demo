package com.epam.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

	private static final int WAIT_TIMEOUT_SECONDS = 10;

	protected WebDriver driver;
	protected WebDriverWait wait;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Switches to a single or nested iframe element
	 *
	 * @param frames iframe elements array, driver will switch to the last element in the array
	 */
	protected void switchToIFrame(WebElement...frames) {
		for (WebElement frame : frames) {
			new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
					.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		}
	}

	protected void switchToMainFrame() {
		driver.switchTo().defaultContent();
	}
}
