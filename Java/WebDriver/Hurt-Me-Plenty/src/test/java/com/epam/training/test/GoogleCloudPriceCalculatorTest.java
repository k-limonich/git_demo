package com.epam.training.test;

import com.epam.training.page.GoogleCloudHomePage;

import static com.epam.training.constants.DdlName.*;

import com.epam.training.page.PricingEstimateBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoogleCloudPriceCalculatorTest {

	private WebDriver driver;
	private PricingEstimateBlock pricingEstimate;

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

	private final static String EXPECTED_VM_CLASS = "regular";
	private final static String EXPECTED_INSTANCE_TYPE = "n1-standard-8";
	private final static String EXPECTED_REGION = "Frankfurt";
	private final static String EXPECTED_LOCAL_SSD = "2x375 GiB";
	private final static String EXPECTED_COMMITMENT_TERM = "1 Year";
	private final static String EXPECTED_TOTAL_PRICE = "USD 1,083.33";

	@BeforeMethod(alwaysRun = true)
	void browserSetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod(description = "Go to pricing calculator page, fill in the form, press ADD TO ESTIMATE")
	void pricingEstimateSetUp() {
		pricingEstimate = new GoogleCloudHomePage(driver)
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
	}

	@Test(description = "check VM Class")
	void testVMClassIsCorrect() {
		Assert.assertTrue(pricingEstimate.checkVMClassEqualsTo(EXPECTED_VM_CLASS),
						"VM Class item is incorrect");
	}

	@Test(description = "check Instance type")
	void testInstanceTypeIsCorrect() {
		Assert.assertTrue(pricingEstimate.checkInstanceTypeEqualsTo(EXPECTED_INSTANCE_TYPE),
						"Instance type item is incorrect");
	}

	@Test(description = "check Region")
	void testRegionIsCorrect() {
		Assert.assertTrue(pricingEstimate.checkRegionEqualsTo(EXPECTED_REGION),
						"Region item is incorrect");
	}

	@Test(description = "check Local SSD")
	void testLocalSSDIsCorrect() {
		Assert.assertTrue(pricingEstimate.checkLocalSSDEqualsTo(EXPECTED_LOCAL_SSD),
						"Local SSD item is incorrect");
	}

	@Test(description = "check Commitment term")
	void testCommitmentTerm() {
		Assert.assertTrue(pricingEstimate.checkCommitmentTermEqualsTo(EXPECTED_COMMITMENT_TERM),
						"Commitment term item is incorrect");
	}

	@Test(description = "check Total price")
	void testTotalPriceIsCorrect() {
		Assert.assertTrue(pricingEstimate.checkTotalPriceEqualsTo(EXPECTED_TOTAL_PRICE),
						"Total price item is incorrect");
	}

	@AfterMethod(alwaysRun = true)
	void browserTearDown() {
		driver.quit();
	}
}
