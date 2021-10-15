package com.epam.training.test;

import com.epam.training.page.google.GoogleCloudHomePage;
import com.epam.training.page.google.PriceCalculatorPage;
import com.epam.training.page.google.PriceEstimateBlock;
import com.epam.training.page.yopmail.EmailGeneratorPage;
import com.epam.training.page.yopmail.YopmailHomePage;
import com.epam.training.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.training.constants.DdlName.*;

public class GoogleCloudPriceCalculatorTest {

	private WebDriver driver;
	private PriceEstimateBlock priceEstimatePage;
	private EmailGeneratorPage emailGeneratorPage;

	private double calculatorTotalCost;
	private double emailTotalCost;

	private final static String TERM = "Google Cloud Platform Pricing Calculator";
	private final static int NUMBER_OF_INSTANCES = 4;
	private final static String OPERATING_SYSTEM_OPTION = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL";
	private final static String MACHINE_CLASS_OPTION = "Regular";
	private final static String SERIES_OPTION = "N1";
	private final static String MACHINE_TYPE_OPTION = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
	private final static String NUMBER_OF_GPUS_OPTION = "1";
	private final static String GPU_TYPE_OPTION = "NVIDIA Tesla V100";
	private final static String LOCAL_SSD_OPTION = "2x375 GB";
	private final static String DATACENTER_LOCATION_OPTION = "Frankfurt (europe-west3)";
	private final static String COMMITTED_USAGE_OPTION = "1 Year";

	@BeforeMethod(alwaysRun = true)
	void browserSetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod(description = "Go to pricing calculator page, fill in the form, press ADD TO ESTIMATE")
	void priceEstimateSetUp() {
		priceEstimatePage = new GoogleCloudHomePage(driver)
				.openPage()
				.searchForTerm(TERM)
				.goToPricingCalculatorPage()
				.switchToCalculatorFrame()
				.chooseComputeEngineOption()
				.enterNumberOfInstances(NUMBER_OF_INSTANCES)
				.chooseDdlOption(OPERATING_SYSTEM, OPERATING_SYSTEM_OPTION)
				.chooseDdlOption(MACHINE_CLASS, MACHINE_CLASS_OPTION)
				.chooseDdlOption(SERIES, SERIES_OPTION)
				.chooseDdlOption(MACHINE_TYPE, MACHINE_TYPE_OPTION)
				.enableAddGPUsCheckbox()
				.chooseDdlOption(NUMBER_OF_GPUS, NUMBER_OF_GPUS_OPTION)
				.chooseDdlOption(GPU_TYPE, GPU_TYPE_OPTION)
				.chooseDdlOption(LOCAL_SSD, LOCAL_SSD_OPTION)
				.chooseDdlOption(DATACENTER_LOCATION, DATACENTER_LOCATION_OPTION)
				.chooseDdlOption(COMMITTED_USAGE, COMMITTED_USAGE_OPTION)
				.pressAddToEstimate();

		calculatorTotalCost = priceEstimatePage.getTotalCost();

		WebDriverUtils.openBlankTab(driver);
		WebDriverUtils.switchTab(driver);

		emailGeneratorPage = new YopmailHomePage(driver)
				.openPage()
				.generateRandomEmail();
		String email = emailGeneratorPage.copyEmailAddress();

		WebDriverUtils.switchTab(driver);

		new PriceCalculatorPage(driver)
				.switchToEstimateBlock()
				.pressEmailEstimate()
				.enterEmail(email)
				.sendEmail();

		WebDriverUtils.switchTab(driver);

		emailTotalCost = emailGeneratorPage
				.checkInbox()
				.refreshInbox()
				.selectPriceEstimateEmail()
				.getTotalCost();
	}

//	@BeforeMethod
//	void emailEstimate() {
//
//	}

	@Test
	void test() {
		Assert.assertEquals(calculatorTotalCost, emailTotalCost,
						"Total cost is different (calculator: " + calculatorTotalCost +
							',' + " email: " + emailTotalCost + ')');
	}

	@AfterMethod(alwaysRun = true)
	void browserTearDown() {
		driver.quit();
	}
}
