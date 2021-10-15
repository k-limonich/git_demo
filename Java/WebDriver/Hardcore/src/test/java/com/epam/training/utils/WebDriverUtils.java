package com.epam.training.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

	private static final int WAIT_TIMEOUT_SECONDS = 10;

	/**
	 * Switches to a single or nested iframe element
	 *
	 * @param driver WebDriver object
	 * @param frames iframe elements array, driver will switch to the last element in the array
	 */
	public static void switchToIFrame(WebDriver driver, WebElement ...frames) {
		for (WebElement frame : frames) {
			new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
					.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		}
	}

	public static void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static void openBlankTab(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(webDriver -> webDriver.getWindowHandles().size() > 1);
	}

	public static void switchTab(WebDriver driver) {
		String originalHandle = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalHandle.equals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				return;
			}
		}
	}
}
