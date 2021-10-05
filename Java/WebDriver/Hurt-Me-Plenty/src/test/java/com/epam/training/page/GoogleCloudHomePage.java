package com.epam.training.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudHomePage extends AbstractPage {

	private static final String HOMEPAGE_URL = "https://cloud.google.com/";

	@FindBy(name = "q")
	private WebElement searchInput;

	public GoogleCloudHomePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public GoogleCloudHomePage openPage() {
		driver.get(HOMEPAGE_URL);
		return this;
	}

	public SearchResultsPage searchForTerm(String term) {
		searchInput.sendKeys(term + Keys.ENTER);
		return new SearchResultsPage(driver, term);
	}

}
