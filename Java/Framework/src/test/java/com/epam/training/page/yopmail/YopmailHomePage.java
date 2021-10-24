package com.epam.training.page.yopmail;

import com.epam.training.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopmailHomePage extends AbstractPage {

	private final Logger logger = LogManager.getRootLogger();
	private final static String HOMEPAGE_URL = "https://yopmail.com/en/";

	@FindBy(xpath = "//a[@href='email-generator']")
	private WebElement buttonEmailGenerator;

	public YopmailHomePage(WebDriver driver) {
		super(driver);
	}

	public YopmailHomePage openPage() {
		driver.get(HOMEPAGE_URL);
		logger.info("yopmail.com homepage opened");
		return this;
	}

	public EmailGeneratorPage generateRandomEmail() {
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(buttonEmailGenerator))
				.click();
		return new EmailGeneratorPage(driver);
	}
}
