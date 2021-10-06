package com.epam.training.test;

import com.epam.training.page.GoogleCloudHomePage;

import static com.epam.training.constants.DdlName.*;

import com.epam.training.page.PricingEstimateBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleCloudPriceCalculatorTest {

	private WebDriver driver;
	private PricingEstimateBlock pricingEstimate;

	private final String term = "Google Cloud Platform Pricing Calculator";
	private final int numberOfInstances = 4;
	private final String operatingSystemOption = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL";
	private final String machineClassOption = "Regular";
	private final String seriesOption = "N1";
	private final String machineTypeOption = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
	private final String numberOfGPUsOption = "1";
	private final String GPUTypeOption = "NVIDIA Tesla V100";
	private final String localSSDOption = "2x375 GB";
	private final String datacenterLocationOption = "Frankfurt (europe-west3)";
	private final String committedUsageOption = "1 Year";

	private final String expectedVMClass = "regular";
	private final String expectedInstanceType = "n1-standard-8";
	private final String expectedRegion = "Frankfurt";
	private final String expectedLocalSSD = "2x375 GiB";
	private final String expectedCommitmentTerm = "1 Year";
	private final String expectedTotalPrice = "USD 1,083.33";

	@BeforeClass(alwaysRun = true)
	void browserSetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeClass(description = "Go to pricing calculator page, fill in the form, press ADD TO ESTIMATE")
	void pricingEstimateSetUp() {
		pricingEstimate = new GoogleCloudHomePage(driver)
				.openPage()
				.searchForTerm(term)
				.goToPricingCalculatorPage()
				.switchToCalculatorFrame()
				.chooseComputeEngineOption()
				.enterNumberOfInstances(numberOfInstances)
				.chooseDdlOption(OPERATING_SYSTEM, operatingSystemOption)
				.chooseDdlOption(MACHINE_CLASS, machineClassOption)
				.chooseDdlOption(SERIES, seriesOption)
				.chooseDdlOption(MACHINE_TYPE, machineTypeOption)
				.enableAddGPUsCheckbox()
				.chooseDdlOption(NUMBER_OF_GPUS, numberOfGPUsOption)
				.chooseDdlOption(GPU_TYPE, GPUTypeOption)
				.chooseDdlOption(LOCAL_SSD, localSSDOption)
				.chooseDdlOption(DATACENTER_LOCATION, datacenterLocationOption)
				.chooseDdlOption(COMMITTED_USAGE, committedUsageOption)
				.pressAddToEstimate();
	}

	@Test(description = "check VM Class")
	void testVMClassIsCorrect() {
		Assert.assertTrue(pricingEstimate.checkVMClassEqualsTo(expectedVMClass),
						"VM Class item is incorrect");
	}

	@Test(description = "check Instance type")
	void testInstanceTypeIsCorrect() {
		Assert.assertTrue(pricingEstimate.checkInstanceTypeEqualsTo(expectedInstanceType),
						"Instance type item is incorrect");
	}

	@Test(description = "check Region")
	void testRegionIsCorrect() {
		Assert.assertTrue(pricingEstimate.checkRegionEqualsTo(expectedRegion),
						"Region item is incorrect");
	}

	@Test(description = "check Local SSD")
	void testLocalSSDIsCorrect() {
		Assert.assertTrue(pricingEstimate.checkLocalSSDEqualsTo(expectedLocalSSD),
						"Local SSD item is incorrect");
	}

	@Test(description = "check Commitment term")
	void testCommitmentTerm() {
		Assert.assertTrue(pricingEstimate.checkCommitmentTermEqualsTo(expectedCommitmentTerm),
						"Commitment term item is incorrect");
	}

	@Test(description = "check Total price")
	void testTotalPriceIsCorrect() {
		Assert.assertTrue(pricingEstimate.checkTotalPriceEqualsTo(expectedTotalPrice),
						"Total price item is incorrect");
	}

	@AfterClass(alwaysRun = true)
	void browserTearDown() {
		driver.quit();
	}
}
