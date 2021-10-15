package com.epam.training.page.google;

import com.epam.training.constants.DdlName;
import com.epam.training.page.AbstractPage;
import com.epam.training.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PriceCalculatorPage extends AbstractPage {

	@FindBy(xpath = "//devsite-iframe/iframe")
	protected WebElement baseCalculatorFrame;

	@FindBy(xpath = "//div[@class='cp-header']/iframe")
	protected WebElement nestedCalculatorFrame;

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

	public PriceCalculatorPage(WebDriver driver) {
		super(driver);
	}

	public PriceCalculatorPage chooseComputeEngineOption() {
		WebDriverUtils.switchToIFrame(driver, baseCalculatorFrame, nestedCalculatorFrame);
		wait.until(ExpectedConditions.elementToBeClickable(computeEngineOption))
				.click();
		WebDriverUtils.switchToMainFrame(driver);
		return this;
	}

	public PriceCalculatorPage enterNumberOfInstances(int number) {
		WebDriverUtils.switchToIFrame(driver, baseCalculatorFrame, nestedCalculatorFrame);
		wait.until(ExpectedConditions.visibilityOf(instancesInput))
				.sendKeys(String.valueOf(number));
		WebDriverUtils.switchToMainFrame(driver);
		return this;
	}

	public PriceCalculatorPage chooseDdlOption(DdlName ddlName, String option) {
		WebDriverUtils.switchToIFrame(driver, baseCalculatorFrame, nestedCalculatorFrame);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				buildDdlLocator(ddlName.toString()))))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				buildDdlOptionLocator(option))))
				.click();
		WebDriverUtils.switchToMainFrame(driver);
		return this;
	}

	private String buildDdlLocator(String ddlName) {
		return String.format(DDL_BASE_LOCATOR, ddlName);
	}

	private String buildDdlOptionLocator(String option) {
		return String.format(DDL_OPTION_BASE_LOCATOR, option);
	}

	public PriceCalculatorPage enableAddGPUsCheckbox() {
		WebDriverUtils.switchToIFrame(driver, baseCalculatorFrame, nestedCalculatorFrame);
		wait.until(ExpectedConditions.elementToBeClickable(addGPUsButton))
				.click();
		WebDriverUtils.switchToMainFrame(driver);
		return this;
	}

	public PriceEstimateBlock pressAddToEstimate() {
		WebDriverUtils.switchToIFrame(driver, baseCalculatorFrame, nestedCalculatorFrame);
		wait.until(ExpectedConditions.elementToBeClickable(addToEstimateButton))
				.click();
		WebDriverUtils.switchToMainFrame(driver);
		return new PriceEstimateBlock(driver);
	}
}
