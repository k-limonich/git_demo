package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PricingEstimateBlock extends AbstractPage {

	private final String totalPriceBaseLocator = "//*[@class='md-title']/*[@class='ng-binding'" +
			" and contains(text(), '%s')]";
	private final String listItemBaseLocator = "//div[contains(@class, 'md-list-item-text ng-binding')" +
			" and contains(text(), '%s')]";

	private final String regionLocator = "Region: %s";
	private final String commitmentTermLocator = "Commitment term: %s";
	private final String vmClassLocator = "VM class: %s";
	private final String instanceTypeLocator = "Instance type: %s";
	private final String localSSDLocator = "Local SSD: %s";

	protected PricingEstimateBlock(WebDriver driver) {
		super(driver);
	}

	public boolean checkRegionEqualsTo(String region) {
		String baseLocator = String.format(listItemBaseLocator, regionLocator);
		List<WebElement> regionItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
				(By.xpath(buildLocator(baseLocator, region))));
		return !regionItems.isEmpty();
	}

	public boolean checkCommitmentTermEqualsTo(String commitmentTerm) {
		String baseLocator = String.format(listItemBaseLocator, commitmentTermLocator);
		List<WebElement> commitmentTermItems = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy
						(By.xpath(buildLocator(baseLocator, commitmentTerm))));
		return !commitmentTermItems.isEmpty();
	}

	public boolean checkVMClassEqualsTo(String vmClass) {
		String baseLocator = String.format(listItemBaseLocator, vmClassLocator);
		List<WebElement> vmClassItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
				(By.xpath(buildLocator(baseLocator, vmClass))));
		return !vmClassItems.isEmpty();
	}

	public boolean checkInstanceTypeEqualsTo(String instanceType) {
		String baseLocator = String.format(listItemBaseLocator, instanceTypeLocator);
		List<WebElement> instanceTypeItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
				(By.xpath(buildLocator(baseLocator, instanceType))));
		return !instanceTypeItems.isEmpty();
	}

	public boolean checkLocalSSDEqualsTo(String localSSD) {
		String baseLocator = String.format(listItemBaseLocator, localSSDLocator);
		List<WebElement> localSSDItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
				(By.xpath(buildLocator(baseLocator, localSSD))));
		return !localSSDItems.isEmpty();
	}

	public boolean checkTotalPriceEqualsTo(String totalPrice) {
		List<WebElement> totalPriceItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
				(By.xpath(buildLocator(totalPriceBaseLocator, totalPrice))));
		return !totalPriceItems.isEmpty();
	}

	private String buildLocator(String baseLocator, String item) {
		return String.format(baseLocator, item);
	}

	@Override
	protected AbstractPage openPage() {
		throw new RuntimeException("Pricing calculator page isn't supposed to be opened directly");
	}
}
