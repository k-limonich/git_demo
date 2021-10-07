package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends AbstractPage {

	private final String searchTerm;

	private final static String DEFAULT_SEARCH_RESULT_LOCATOR = "//a[@class='gs-title' and contains(., '%s')]";

	public SearchResultsPage(WebDriver driver, String searchTerm) {
		super(driver);
		this.searchTerm = searchTerm;
	}

	public PricingCalculatorPage goToPricingCalculatorPage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath(buildSearchResultLocator())))
				.click();
		return new PricingCalculatorPage(driver);
	}

	private String buildSearchResultLocator() {
		return String.format(DEFAULT_SEARCH_RESULT_LOCATOR, searchTerm);
	}

	@Override
	protected AbstractPage openPage() {
		throw new RuntimeException("Search results page isn't supposed to be opened directly");
	}
}
