package com.epam.training.page.google;

import com.epam.training.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailEstimateForm extends AbstractPage {

	@FindBy(xpath = "//devsite-iframe/iframe")
	private WebElement baseCalculatorFrame;

	@FindBy(xpath = "//div[@class='cp-header']/iframe")
	private WebElement nestedCalculatorFrame;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailField;

	@FindBy(xpath = "//button[@aria-label='Send Email']")
	private WebElement btnSend;

	protected EmailEstimateForm(WebDriver driver) {
		super(driver);
	}

	public EmailEstimateForm enterEmail(String email) {
		switchToIFrame(baseCalculatorFrame, nestedCalculatorFrame);
		wait.until(ExpectedConditions.visibilityOf(emailField))
				.sendKeys(email);
		switchToMainFrame();
		return this;
	}

	public void sendEmail() {
		switchToIFrame(baseCalculatorFrame, nestedCalculatorFrame);
		wait.until(ExpectedConditions.elementToBeClickable(btnSend))
				.click();
		switchToMainFrame();
	}
}
