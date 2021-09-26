package com.epam.training.test;

import com.epam.training.page.PasteBinHomePage;
import com.epam.training.page.SuccessfulPasteCreationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PasteBinTest {

	private WebDriver driver;
	private SuccessfulPasteCreationPage page;

	private static String expectedRawPasteData = "git config --global user.name  \"New Sheriff in Town\"\n" +
			"git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
			"git push origin master --force";
	private static String expectedSyntaxHighlightingLanguage = "Bash";
	private static String expectedExpirationTime = "10 Minutes";
	private static String pasteTitle = "how to gain dominance among developers";

	@BeforeClass(alwaysRun = true)
	public void browserSetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeClass(alwaysRun = true)
	public void pageSetUp() {
		page = new PasteBinHomePage(driver)
				.openPage()
				.enterPaste(expectedRawPasteData)
				.enableSyntaxHighlighting()
				.selectSyntaxHighlighting(expectedSyntaxHighlightingLanguage)
				.selectExpirationTime(expectedExpirationTime)
				.createNewPaste(pasteTitle)
				.waitUntilLoaded();
	}

	@Test(description = "Page title test")
	public void testNewPasteTitleIsCorrect() {
		String expectedPageTitle = pasteTitle + " - Pastebin.com";
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
	}

	@Test(description = "Bash syntax highlighting test")
	public void testBashSyntaxHighlightingIsOn() {
		String actualSyntaxHighlightingLanguage = page.determineSyntaxHighlightingLanguage();
		Assert.assertEquals(actualSyntaxHighlightingLanguage, expectedSyntaxHighlightingLanguage);
	}

	@Test(description = "Raw paste data test")
	public void testRawPasteDataIsCorrect() {
		String actualRawPasteData = page.getRawPasteData();
		Assert.assertEquals(actualRawPasteData, expectedRawPasteData);
	}

	@AfterClass(alwaysRun = true)
	public void browserTearDown() {
		driver.quit();
		driver = null;
	}
}
