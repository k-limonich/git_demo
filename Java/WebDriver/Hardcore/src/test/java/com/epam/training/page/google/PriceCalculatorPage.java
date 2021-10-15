package com.epam.training.page.google;

import com.epam.training.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PriceCalculatorPage extends AbstractPage {

	@FindBy(xpath = "//devsite-iframe/iframe")
	private WebElement baseCalculatorFrame;

	@FindBy(xpath = "//div[@class='cp-header']/iframe")
	private WebElement nestedCalculatorFrame;

	public PriceCalculatorPage(WebDriver driver) {
		super(driver);
	}

	public PriceCalculatorFrame switchToCalculatorFrame() {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(baseCalculatorFrame));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nestedCalculatorFrame));
		return new PriceCalculatorFrame(driver);
	}

	public PriceEstimateBlock switchToEstimateBlock() {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(baseCalculatorFrame));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nestedCalculatorFrame));
		return new PriceEstimateBlock(driver);
	}
}
