package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.training.waits.CustomConditions;

import java.util.List;

public class PasteBinHomePage {

	private static int WAIT_TIMEOUT_SECONDS = 10;
	private static String HOMEPAGE_URL = "https://pastebin.com";

	private WebDriver driver;

	@FindBy(tagName = "textarea")
	private WebElement textInput;

	@FindBy(xpath = "//div[contains(@class, 'expiration')]/descendant::span[@role='presentation']")
	private WebElement expirationTimeDropDownList;

	@FindBy(xpath = "//input[@type='text' and contains(@id, 'name')]")
	private WebElement pasteNameInput;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement createPasteButton;

	private final String expirationTimeDefaultLocator = "//*[@role='listbox']/*[contains(., '%s')]";
	private final String successNoticeLocator = "//div[contains(@class, 'success')]";

	public PasteBinHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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

	public PasteBinHomePage selectExpirationTime(String expirationTimeOption) {
		expirationTimeDropDownList.click();
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath(buildExpirationTimeLocator(expirationTimeOption))))
				.click();
		return this;
	}

	private String buildExpirationTimeLocator(String expirationTimeOption) {
		return String.format(expirationTimeDefaultLocator, expirationTimeOption);
	}

	public PasteBinHomePage enterPasteName(String pasteName) {
		pasteNameInput.sendKeys(pasteName);
		return this;
	}

	public boolean createNewPaste() {
		createPasteButton.click();
		List<WebElement> successNotice = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(successNoticeLocator)));
		return !successNotice.isEmpty();
	}
}
