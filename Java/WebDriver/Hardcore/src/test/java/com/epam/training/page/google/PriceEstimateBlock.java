package com.epam.training.page.google;

import com.epam.training.page.AbstractPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceEstimateBlock extends AbstractPage {

	private final static String TOTAL_COST_REGEX = "(?<=USD\\s)[0-9.]+";
	private final static String EMPTY_STRING = "";

	@FindBy(xpath = "//devsite-iframe/iframe")
	private WebElement baseCalculatorFrame;

	@FindBy(xpath = "//div[@class='cp-header']/iframe")
	private WebElement nestedCalculatorFrame;

	@FindBy(xpath = "//h2[@class='md-title']/b")
	private WebElement totalCostHeader;

	@FindBy(xpath = "//button[@id='email_quote']")
	private WebElement btnEmailEstimate;

	public PriceEstimateBlock(WebDriver driver) {
		super(driver);
	}

	public double getTotalCost() {
		try {
			switchToIFrame(baseCalculatorFrame, nestedCalculatorFrame);
			Pattern pattern = Pattern.compile(TOTAL_COST_REGEX);
			Matcher matcher = pattern.matcher(wait
					.until(ExpectedConditions.visibilityOf(totalCostHeader)).getText());
			String totalCostString = matcher.find() ? matcher.group() : EMPTY_STRING;

			switchToMainFrame();
			return Double.parseDouble(totalCostString);
		} catch (NoSuchElementException e) {
			throw new RuntimeException("Header containing total cost isn't visible [Calculator page]");
		} catch (NumberFormatException e) {
			throw new RuntimeException("Unable to parse total price [Calculator page]");
		}
	}

	public EmailEstimateForm pressEmailEstimate() {
		switchToIFrame(baseCalculatorFrame, nestedCalculatorFrame);
		wait.until(ExpectedConditions.elementToBeClickable(btnEmailEstimate))
				.click();
		switchToMainFrame();
		return new EmailEstimateForm(driver);
	}

}
