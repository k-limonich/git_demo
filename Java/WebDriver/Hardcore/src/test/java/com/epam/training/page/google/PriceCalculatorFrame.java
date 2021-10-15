package com.epam.training.page.google;

import com.epam.training.constants.DdlName;
import com.epam.training.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PriceCalculatorFrame extends AbstractPage {

	@FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
	private WebElement computeEngineOption;

	@FindBy(xpath = "//label[contains(., 'Number of instances')]/following-sibling::input")
	private WebElement instancesInput;

	@FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
	private WebElement addGPUsButton;

	@FindBy(xpath = "//button[@aria-label='Add to Estimate']")
	private WebElement addToEstimateButton;

	private final static String DDL_BASE_LOCATOR = "//label[contains(., '%s')]/parent::*/descendant::span[@class='md-select-icon']";
	private final static String DDL_OPTION_BASE_LOCATOR = "//div[@aria-hidden='false']/descendant::md-option/div[contains(@class, 'md-text') and contains(., '%s')]";

	public PriceCalculatorFrame(WebDriver driver) {
		super(driver);
	}

	public PriceCalculatorFrame chooseComputeEngineOption() {
		wait.until(ExpectedConditions.elementToBeClickable(computeEngineOption))
				.click();
		return this;
	}

	public PriceCalculatorFrame enterNumberOfInstances(int number) {
		instancesInput.sendKeys(String.valueOf(number));
		return this;
	}

	public PriceCalculatorFrame chooseDdlOption(DdlName ddlName, String option) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				buildDdlLocator(ddlName.toString()))))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				buildDdlOptionLocator(option))))
				.click();
		return this;
	}

	private String buildDdlLocator(String ddlName) {
		return String.format(DDL_BASE_LOCATOR, ddlName);
	}

	private String buildDdlOptionLocator(String option) {
		return String.format(DDL_OPTION_BASE_LOCATOR, option);
	}

	public PriceCalculatorFrame enableAddGPUsCheckbox() {
		addGPUsButton.click();
		return this;
	}

	public PriceEstimateBlock pressAddToEstimate() {
		addToEstimateButton.click();
		return new PriceEstimateBlock(driver);
	}
}
