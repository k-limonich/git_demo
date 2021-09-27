package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessfulPasteCreationPage extends AbstractPage {

	private String pasteTitle;

	private final By successNoticeLocator = By.xpath("//div[contains(@class, 'success')]");
	private final By highlightingLocator = By.xpath("//div[@class='top-buttons']/div[@class='left']/*");
	private final By rawPasteDataLocator = By.xpath("//*[contains(text(), 'RAW Paste Data')]/following-sibling::*");

	public SuccessfulPasteCreationPage(WebDriver driver, String pasteTitle) {
		super(driver);
		this.pasteTitle = pasteTitle;
	}

	public SuccessfulPasteCreationPage waitUntilLoaded() {
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(successNoticeLocator));
		return this;
	}

	public String determineSyntaxHighlightingLanguage() {
		return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(highlightingLocator))
				.getText();
	}

	public String getRawPasteData() {
		return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(rawPasteDataLocator))
				.getText();
	}

	@Override
	protected AbstractPage openPage() {
		throw new RuntimeException("Method openPage() is unavailable for page with created paste");
	}
}
