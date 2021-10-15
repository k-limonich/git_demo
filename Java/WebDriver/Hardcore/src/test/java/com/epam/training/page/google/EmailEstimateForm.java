package com.epam.training.page.google;

import com.epam.training.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailEstimateForm extends PriceCalculatorPage {

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailField;

	@FindBy(xpath = "//button[@aria-label='Send Email']")
	private WebElement btnSend;

	protected EmailEstimateForm(WebDriver driver) {
		super(driver);
	}

	public EmailEstimateForm enterEmail(String email) {
		WebDriverUtils.switchToIFrame(driver, baseCalculatorFrame, nestedCalculatorFrame);
		wait.until(ExpectedConditions.visibilityOf(emailField))
				.sendKeys(email);
		WebDriverUtils.switchToMainFrame(driver);
		return this;
	}

	public void sendEmail() {
		WebDriverUtils.switchToIFrame(driver, baseCalculatorFrame, nestedCalculatorFrame);
		wait.until(ExpectedConditions.elementToBeClickable(btnSend))
				.click();
		WebDriverUtils.switchToMainFrame(driver);
	}
}
