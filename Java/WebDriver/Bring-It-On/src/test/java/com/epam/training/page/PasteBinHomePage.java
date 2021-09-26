package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.training.waits.CustomConditions;

public class PasteBinHomePage extends AbstractPage {

	private static String HOMEPAGE_URL = "https://pastebin.com";

	@FindBy(tagName = "textarea")
	private WebElement textInput;

	@FindBy(xpath = "//div[contains(@class, 'expiration')]/descendant::span[@role='presentation']")
	private WebElement expirationTimeDropDownList;

	@FindBy(xpath = "//div[contains(@class, 'format')]/descendant::span[@role='presentation']")
	private WebElement syntaxHighlightingDropDownList;

	@FindBy(xpath = "//div[@class='toggle__control']")
	private WebElement syntaxHighlightingToggle;

	@FindBy(xpath = "//input[@type='text' and contains(@id, 'name')]")
	private WebElement pasteNameInput;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement createPasteButton;

	private final String dropDownListOptionDefaultLocator = "//*[@role='option' and text()='%s']";

	public PasteBinHomePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public PasteBinHomePage openPage() {
		driver.get(HOMEPAGE_URL);
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(CustomConditions.jQueryAJAXsCompleted());
		return this;
	}

	public PasteBinHomePage enterPaste(String paste) {
		textInput.sendKeys(paste);
		return this;
	}

	public PasteBinHomePage selectSyntaxHighlighting(String highlightingLanguage) {
		scrollPage(200);
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(syntaxHighlightingDropDownList))
				.click();
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath(buildDropDownListOptionLocator(highlightingLanguage))))
				.click();
		return this;
	}

	public PasteBinHomePage enableSyntaxHighlighting() {
		scrollPage(150);
		syntaxHighlightingToggle.click();
		return this;
	}

	public PasteBinHomePage selectExpirationTime(String expirationTime) {
		scrollPage(300);
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(expirationTimeDropDownList))
				.click();
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath(buildDropDownListOptionLocator(expirationTime))))
				.click();
		return this;
	}

	private String buildDropDownListOptionLocator(String optionName) {
		return String.format(dropDownListOptionDefaultLocator, optionName);
	}

	public SuccessfulPasteCreationPage createNewPaste(String pasteName) {
		pasteNameInput.sendKeys(pasteName);
		createPasteButton.click();
		return new SuccessfulPasteCreationPage(driver, pasteName);
	}
}
