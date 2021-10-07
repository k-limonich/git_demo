package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PricingEstimateBlock extends AbstractPage {

	private final static String TOTAL_PRICE_BASE_LOCATOR = "//*[@class='md-title']/*[@class='ng-binding'" +
			" and contains(text(), '%s')]";
	private final static String LIST_ITEM_BASE_LOCATOR = "//div[contains(@class, 'md-list-item-text ng-binding')" +
			" and contains(text(), '%s')]";

	private final static String REGION_LOCATOR = "Region: %s";
	private final static String COMMITMENT_TERM_LOCATOR = "Commitment term: %s";
	private final static String VM_CLASS_LOCATOR = "VM class: %s";
	private final static String INSTANCE_TYPE_LOCATOR = "Instance type: %s";
	private final static String LOCAL_SSD_LOCATOR = "Local SSD: %s";

	protected PricingEstimateBlock(WebDriver driver) {
		super(driver);
	}

	public boolean checkRegionEqualsTo(String region) {
		String baseLocator = String.format(LIST_ITEM_BASE_LOCATOR, REGION_LOCATOR);
		List<WebElement> regionItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
				(By.xpath(buildLocator(baseLocator, region))));
		return !regionItems.isEmpty();
	}

	public boolean checkCommitmentTermEqualsTo(String commitmentTerm) {
		String baseLocator = String.format(LIST_ITEM_BASE_LOCATOR, COMMITMENT_TERM_LOCATOR);
		List<WebElement> commitmentTermItems = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy
						(By.xpath(buildLocator(baseLocator, commitmentTerm))));
		return !commitmentTermItems.isEmpty();
	}

	public boolean checkVMClassEqualsTo(String vmClass) {
		String baseLocator = String.format(LIST_ITEM_BASE_LOCATOR, VM_CLASS_LOCATOR);
		List<WebElement> vmClassItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
				(By.xpath(buildLocator(baseLocator, vmClass))));
		return !vmClassItems.isEmpty();
	}

	public boolean checkInstanceTypeEqualsTo(String instanceType) {
		String baseLocator = String.format(LIST_ITEM_BASE_LOCATOR, INSTANCE_TYPE_LOCATOR);
		List<WebElement> instanceTypeItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
				(By.xpath(buildLocator(baseLocator, instanceType))));
		return !instanceTypeItems.isEmpty();
	}

	public boolean checkLocalSSDEqualsTo(String localSSD) {
		String baseLocator = String.format(LIST_ITEM_BASE_LOCATOR, LOCAL_SSD_LOCATOR);
		List<WebElement> localSSDItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
				(By.xpath(buildLocator(baseLocator, localSSD))));
		return !localSSDItems.isEmpty();
	}

	public boolean checkTotalPriceEqualsTo(String totalPrice) {
		List<WebElement> totalPriceItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
				(By.xpath(buildLocator(TOTAL_PRICE_BASE_LOCATOR, totalPrice))));
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
