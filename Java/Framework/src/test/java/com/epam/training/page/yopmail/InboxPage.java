package com.epam.training.page.yopmail;

import com.epam.training.page.AbstractPage;
import com.epam.training.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InboxPage extends AbstractPage {

	private final static String TOTAL_COST_REGEX = "(?<=USD\\s)[0-9.]+";

	@FindBy(id = "ifinbox")
	private WebElement iframeInbox;

	@FindBy(id = "ifmail")
	private WebElement iframeEmailContent;

	@FindBy(id = "refresh")
	private WebElement buttonRefresh;

	@FindBy(xpath = "//table/tbody/tr/td/h3[contains(., 'USD')]")
	private WebElement headerTotalCost;

	private static final By BY_TOTAL_COST_EMAIL_LOCATOR = By
			.xpath("//div[text()='Google Cloud Platform Price Estimate']/parent::button");

	protected InboxPage(WebDriver driver) {
		super(driver);
	}

	public InboxPage selectTotalCostEmail() {
		for (int refreshCounter = 0; refreshCounter < 10; refreshCounter++) {
			switchToIFrame(iframeInbox);
			List<WebElement> totalCostEmail = driver.findElements(BY_TOTAL_COST_EMAIL_LOCATOR);
			if (totalCostEmail.isEmpty()) {
				switchToMainFrame();
				refreshInbox();
			} else {
				totalCostEmail.get(0).click();
				break;
			}
		}
		switchToMainFrame();
		return this;
	}

	private void refreshInbox() {
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(buttonRefresh))
				.click();
	}

	public double getTotalCost() {
		switchToIFrame(iframeEmailContent);
		String totalCostString = StringUtils
				.extractSubstring(headerTotalCost.getText(), TOTAL_COST_REGEX);
		switchToMainFrame();
		return Double.parseDouble(totalCostString);
	}
}
