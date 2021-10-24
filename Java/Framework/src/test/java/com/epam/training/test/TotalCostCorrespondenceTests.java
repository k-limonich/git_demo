package com.epam.training.test;

import com.epam.training.model.CalculatorForm;
import com.epam.training.page.google.GoogleCloudHomePage;
import com.epam.training.page.google.PriceCalculatorPage;
import com.epam.training.page.yopmail.EmailGeneratorPage;
import com.epam.training.page.yopmail.YopmailHomePage;
import com.epam.training.service.CalculatorFormFiller;
import com.epam.training.service.SearchTerm;
import com.epam.training.util.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalCostCorrespondenceTests extends CommonConditions {

	@Test(description = "Compare total cost from calculator to total cost from email (should be equal)")
	void calculatorAndEmailTotalCostsAreEqual() {
		CalculatorForm form = CalculatorFormFiller.withDataFromProperty();
		PriceCalculatorPage priceCalculatorPage = new GoogleCloudHomePage(driver)
				.openPage()
				.searchForTerm(SearchTerm.fromProperty())
				.goToPricingCalculatorPage()
				.fillInForm(form)
				.pressAddToEstimate();
		Double calculatorTotalCost = priceCalculatorPage.getTotalCost();
		WebDriverUtils.openBlankTab(driver);
		WebDriverUtils.switchTab(driver);
		String email = new YopmailHomePage(driver)
				.openPage()
				.generateRandomEmail()
				.copyEmailAddress();
		WebDriverUtils.switchTab(driver);
		priceCalculatorPage
				.pressEmailEstimate()
				.enterEmail(email)
				.sendEmail();
		WebDriverUtils.switchTab(driver);
		Double emailTotalCost = new EmailGeneratorPage(driver)
				.checkInbox()
				.refreshInbox()
				.selectPriceEstimateEmail()
				.getTotalCost();
		Assert.assertEquals(calculatorTotalCost, emailTotalCost,
						"Total cost differs " + '[' +
								"calculator: " + calculatorTotalCost + ',' +
								" email: " + emailTotalCost + ']');
	}
}
