package com.epam.training.page.google;

import com.epam.training.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailEstimateForm extends AbstractPage {

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailField;

	@FindBy(xpath = "//button[@aria-label='Send Email']")
	private WebElement btnSend;

	protected EmailEstimateForm(WebDriver driver) {
		super(driver);
	}

	public EmailEstimateForm enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(emailField))
				.sendKeys(email);
		return this;
	}

	public PriceEstimateBlock sendEmail() {
		wait.until(ExpectedConditions.elementToBeClickable(btnSend))
				.click();
		return new PriceEstimateBlock(driver);
	}
}
