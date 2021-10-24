package com.epam.training.page.yopmail;

import com.epam.training.page.AbstractPage;
import com.epam.training.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage extends AbstractPage {

	private final Logger logger = LogManager.getRootLogger();
	private final static String TOTAL_COST_REGEX = "(?<=USD\\s)[0-9.]+";

	@FindBy(id = "ifinbox")
	private WebElement iframeInbox;

	@FindBy(id = "ifmail")
	private WebElement iframeEmailContent;

	@FindBy(xpath = "//div[text()='Google Cloud Platform Price Estimate']/parent::button")
	private WebElement priceEstimateEmail;

	@FindBy(id = "refresh")
	private WebElement buttonRefresh;

	@FindBy(xpath = "//table/tbody/tr/td/h3[contains(., 'USD')]")
	private WebElement headerTotalCost;

	protected InboxPage(WebDriver driver) {
		super(driver);
	}

	public InboxPage refreshInbox() {
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(buttonRefresh))
				.click();
		return this;
	}

	public InboxPage selectPriceEstimateEmail() {
		switchToIFrame(iframeInbox);
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(priceEstimateEmail))
				.click();
		switchToMainFrame();
		return this;
	}

	public Double getTotalCost() {
		try {
			switchToIFrame(iframeEmailContent);
			String totalCostString = StringUtils
					.extractSubstring(headerTotalCost.getText(), TOTAL_COST_REGEX);
			switchToMainFrame();
			return Double.parseDouble(totalCostString);
		} catch (NoSuchElementException e) {
			logger.error("Failed to find header containing total cost on email inbox page");
		}
		return null;
	}
}
