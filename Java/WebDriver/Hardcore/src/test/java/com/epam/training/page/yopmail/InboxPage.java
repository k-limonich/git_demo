package com.epam.training.page.yopmail;

import com.epam.training.page.AbstractPage;
import com.epam.training.utils.WebDriverUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InboxPage extends AbstractPage {

	private final static String TOTAL_COST_REGEX = "(?<=USD\\s)[0-9.]+";
	private final static String EMPTY_STRING = "";

	@FindBy(id = "ifinbox")
	private WebElement inboxFrame;

	@FindBy(id = "ifmail")
	private WebElement emailContentFrame;

	@FindBy(xpath = "//div[text()='Google Cloud Platform Price Estimate']/parent::button")
	private WebElement priceEstimateEmail;

	@FindBy(id = "refresh")
	private WebElement btnRefresh;

	@FindBy(xpath = "//table/tbody/tr/td/h3[contains(., 'USD')]")
	private WebElement totalCostHeader;

	protected InboxPage(WebDriver driver) {
		super(driver);
	}

	public InboxPage refreshInbox() {
		wait.until(ExpectedConditions.elementToBeClickable(btnRefresh))
				.click();
		return this;
	}

	public InboxPage selectPriceEstimateEmail() {
		WebDriverUtils.switchToIFrame(driver, inboxFrame);
		wait.until(ExpectedConditions.elementToBeClickable(priceEstimateEmail))
				.click();
		priceEstimateEmail.click();
		WebDriverUtils.switchToMainFrame(driver);
		return this;
	}

	public double getTotalCost() {
		try {
			WebDriverUtils.switchToIFrame(driver, emailContentFrame);
			Pattern pattern = Pattern.compile(TOTAL_COST_REGEX);
			Matcher matcher = pattern.matcher(wait
					.until(ExpectedConditions.visibilityOf(totalCostHeader)).getText());
			String totalCostString = matcher.find() ? matcher.group() : EMPTY_STRING;

			WebDriverUtils.switchToMainFrame(driver);
			return Double.parseDouble(totalCostString);
		} catch (NoSuchElementException e) {
			throw new RuntimeException("Header containing total cost isn't visible [Email Inbox page]");
		} catch (NumberFormatException e) {
			throw new RuntimeException("Unable to parse total price [Email Inbox page]");
		}
	}
}
