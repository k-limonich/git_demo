package com.epam.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

	protected abstract AbstractPage openPage();
}
