package com.epam.training.page.google;

import com.epam.training.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {

	private final Logger logger = LogManager.getRootLogger();
	private static final String HOMEPAGE_URL = "https://cloud.google.com/";

	@FindBy(name = "q")
	private WebElement searchInput;

	public GoogleCloudHomePage(WebDriver driver) {
		super(driver);
	}

	public GoogleCloudHomePage openPage() {
		driver.get(HOMEPAGE_URL);
		logger.info("Google Cloud homepage opened");
		return this;
	}

	public SearchResultsPage searchForTerm(String term) {
		searchInput.sendKeys(term + Keys.ENTER);
		return new SearchResultsPage(driver, term);
	}

}
