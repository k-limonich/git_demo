package com.epam.training.page.google;

import com.epam.training.constants.Fields;
import com.epam.training.model.CalculatorForm;
import com.epam.training.page.AbstractPage;
import com.epam.training.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PriceCalculatorPage extends AbstractPage {

	@FindBy(xpath = "//devsite-iframe/iframe")
	private WebElement iframeFormBase;

	@FindBy(xpath = "//div[@class='cp-header']/iframe")
	private WebElement iframeFormNested;

	@FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
	private WebElement computeEngineTab;

	@FindBy(xpath = "//label[contains(., 'Number of instances')]/following-sibling::input")
	private WebElement inputNumberOfInstances;

	@FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
	private WebElement checkboxAddGPUs;

	@FindBy(xpath = "//button[@aria-label='Add to Estimate']")
	private WebElement buttonAddToEstimate;

	@FindBy(xpath = "//h2[@class='md-title']/b")
	private WebElement headerTotalCost;

	@FindBy(xpath = "//button[@id='email_quote']")
	private WebElement buttonEmailEstimate;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement inputEmail;

	@FindBy(xpath = "//button[@aria-label='Send Email']")
	private WebElement buttonSend;

	private final static String DDL_BASE_LOCATOR = "//label[contains(., '%s')]/parent::*/descendant::span[@class='md-select-icon']";
	private final static String DDL_OPTION_BASE_LOCATOR = "//div[@aria-hidden='false']/descendant::md-option/div[contains(@class, 'md-text') and contains(., '%s')]";

	private final static String TOTAL_COST_REGEX = "(?<=USD\\s)[0-9.]+";

	public PriceCalculatorPage(WebDriver driver) {
		super(driver);
	}

	public PriceCalculatorPage fillInForm(CalculatorForm form) {
		switchToIFrame(iframeFormBase, iframeFormNested);
		computeEngineTab.click();
		inputNumberOfInstances.sendKeys(form.getNumberOfInstances());
		chooseOption(Fields.OPERATING_SYSTEM, form.getOperatingSystem());
		chooseOption(Fields.MACHINE_CLASS, form.getMachineClass());
		chooseOption(Fields.SERIES, form.getSeries());
		chooseOption(Fields.MACHINE_TYPE, form.getMachineType());
		if (form.needGPUs()) {
			checkboxAddGPUs.click();
			chooseOption(Fields.NUMBER_OF_GPUS, form.getNumberOfGPUs());
			chooseOption(Fields.GPU_TYPE, form.getGpuType());
		}
		chooseOption(Fields.LOCAL_SSD, form.getLocalSSD());
		chooseOption(Fields.DATACENTER_LOCATION, form.getDatacenterLocation());
		chooseOption(Fields.COMMITTED_USAGE, form.getCommittedUsage());
		switchToMainFrame();
		return this;
	}

	private void chooseOption(String field, String option) {
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						StringUtils.buildLocator(DDL_BASE_LOCATOR, field))))
				.click();
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						StringUtils.buildLocator(DDL_OPTION_BASE_LOCATOR, option))))
				.click();
	}

	public PriceCalculatorPage pressAddToEstimate() {
		switchToIFrame(iframeFormBase, iframeFormNested);
		buttonAddToEstimate.click();
		switchToMainFrame();
		return this;
	}

	public double getTotalCost() {
		switchToIFrame(iframeFormBase, iframeFormNested);
		String totalCostString = StringUtils
				.extractSubstring(headerTotalCost.getText(), TOTAL_COST_REGEX);
		switchToMainFrame();
		return Double.parseDouble(totalCostString);
	}

	public PriceCalculatorPage pressEmailEstimate() {
		switchToIFrame(iframeFormBase, iframeFormNested);
		buttonEmailEstimate.click();
		switchToMainFrame();
		return this;
	}

	public PriceCalculatorPage enterEmail(String email) {
		switchToIFrame(iframeFormBase, iframeFormNested);
		inputEmail.sendKeys(email);
		switchToMainFrame();
		return this;
	}

	public PriceCalculatorPage sendEmail() {
		switchToIFrame(iframeFormBase, iframeFormNested);
		buttonSend.click();
		switchToMainFrame();
		return this;
	}
}
