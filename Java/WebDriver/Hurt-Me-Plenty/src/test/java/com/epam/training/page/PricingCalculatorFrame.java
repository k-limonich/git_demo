package com.epam.training.page;

import com.epam.training.constants.DdlName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PricingCalculatorFrame extends AbstractPage {

	@FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
	private WebElement computeEngineOption;

	@FindBy(xpath = "//label[contains(., 'Number of instances')]/following-sibling::input")
	private WebElement instancesInput;

	@FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
	private WebElement addGPUsButton;

	@FindBy(xpath = "//button[@aria-label='Add to Estimate']")
	private WebElement addToEstimateButton;

	private final String ddlBaseLocator = "//label[contains(., '%s')]/parent::*/descendant::span[@class='md-select-icon']";
	private final String ddlOptionBaseLocator = "//div[@aria-hidden='false']/descendant::md-option/div[contains(@class, 'md-text') and contains(., '%s')]";

	public PricingCalculatorFrame(WebDriver driver) {
		super(driver);
	}

	public PricingCalculatorFrame chooseComputeEngineOption() {
		boolean computeEngineEnabled = wait
				.until(ExpectedConditions.elementToBeClickable(computeEngineOption))
				.isEnabled();
		if (!computeEngineEnabled) {
			computeEngineOption.click();
		}
		return this;
	}

	public PricingCalculatorFrame enterNumberOfInstances(int number) {
		instancesInput.sendKeys(String.valueOf(number));
		return this;
	}

	public PricingCalculatorFrame chooseDdlOption(DdlName ddlName, String option) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				buildDdlLocator(ddlName.toString()))))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				buildDdlOptionLocator(option))))
				.click();
		return this;
	}

	private String buildDdlLocator(String ddlName) {
		return String.format(ddlBaseLocator, ddlName);
	}

	private String buildDdlOptionLocator(String option) {
		return String.format(ddlOptionBaseLocator, option);
	}

	public PricingCalculatorFrame enableAddGPUsCheckbox() {
		addGPUsButton.click();
		return this;
	}

	public PricingEstimateBlock pressAddToEstimate() {
		addToEstimateButton.click();
		return new PricingEstimateBlock(driver);
	}

	@Override
	protected AbstractPage openPage() {
		throw new RuntimeException("Pricing calculator page isn't supposed to be opened directly");
	}
}
