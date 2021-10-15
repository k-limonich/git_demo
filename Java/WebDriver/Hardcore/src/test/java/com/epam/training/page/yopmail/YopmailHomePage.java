package com.epam.training.page.yopmail;

import com.epam.training.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YopmailHomePage extends AbstractPage {

	private final static String HOMEPAGE_URL = "https://yopmail.com/en/";

	@FindBy(xpath = "//a[@href='email-generator']")
	private WebElement btnEmailGenerator;

	public YopmailHomePage(WebDriver driver) {
		super(driver);
	}

	public YopmailHomePage openPage() {
		driver.get(HOMEPAGE_URL);
		return this;
	}

	public EmailGeneratorPage generateRandomEmail() {
		wait.until(ExpectedConditions.elementToBeClickable(btnEmailGenerator))
				.click();
		return new EmailGeneratorPage(driver);
	}
}
