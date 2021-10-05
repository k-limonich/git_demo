package com.epam.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PricingCalculatorPage extends AbstractPage {

	@FindBy(xpath = "//devsite-iframe/iframe")
	private WebElement baseCalculatorFrame;

	@FindBy(xpath = "//div[@class='cp-header']/iframe")
	private WebElement nestedCalculatorFrame;

	protected PricingCalculatorPage(WebDriver driver) {
		super(driver);
	}

	public PricingCalculatorFrame switchToCalculatorFrame() {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(baseCalculatorFrame));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nestedCalculatorFrame));
		return new PricingCalculatorFrame(driver);
	}

	@Override
	protected AbstractPage openPage() {
		throw new RuntimeException("Pricing calculator page isn't supposed to be opened directly");
	}
}
