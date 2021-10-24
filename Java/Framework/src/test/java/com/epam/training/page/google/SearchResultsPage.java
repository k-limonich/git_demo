package com.epam.training.page.google;

import com.epam.training.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends AbstractPage {

	private final String searchTerm;

	private final static String DEFAULT_SEARCH_RESULT_LOCATOR = "//a[@class='gs-title' and contains(., '%s')]";

	protected SearchResultsPage(WebDriver driver, String searchTerm) {
		super(driver);
		this.searchTerm = searchTerm;
	}

	public PriceCalculatorPage goToPricingCalculatorPage() {
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath(buildSearchResultLocator())))
				.click();
		return new PriceCalculatorPage(driver);
	}

	private String buildSearchResultLocator() {
		return String.format(DEFAULT_SEARCH_RESULT_LOCATOR, searchTerm);
	}
}
