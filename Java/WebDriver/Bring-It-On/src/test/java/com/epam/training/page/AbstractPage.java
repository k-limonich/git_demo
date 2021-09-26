package com.epam.training.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

	protected WebDriver driver;

	protected static int WAIT_TIMEOUT_SECONDS = 10;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected abstract AbstractPage openPage();

	protected void scrollPage(int y) {
		String script = String.format("window.scrollBy(0,%d)", y);
		((JavascriptExecutor) driver).executeScript(script);
	}
}
