package com.epam.training.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

	private static final int WAIT_TIMEOUT_SECONDS = 10;

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
				break;
			}
		}
	}
}
