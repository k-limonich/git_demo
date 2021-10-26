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
	private SuccessfulPasteCreationPage createdPastePage;

	private static final String EXPECTED_RAW_PASTE_DATA = "git config --global user.name  \"New Sheriff in Town\"\n" +
			"git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
			"git push origin master --force";
	private static final String EXPECTED_SYNTAX_HIGHLIGHTING_LANGUAGE = "Bash";
	private static final String EXPECTED_EXPIRATION_TIME = "10 Minutes";
	private static final String PASTE_TITLE = "how to gain dominance among developers";

	@BeforeClass(description = "Chrome browser setup", alwaysRun = true)
	public void browserSetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeClass(description = "Transition to page after paste creation", alwaysRun = true)
	public void pageSetUp() {
		createdPastePage = new PasteBinHomePage(driver)
				.openPage()
				.enterPaste(EXPECTED_RAW_PASTE_DATA)
				.enableSyntaxHighlighting()
				.selectSyntaxHighlighting(EXPECTED_SYNTAX_HIGHLIGHTING_LANGUAGE)
				.selectExpirationTime(EXPECTED_EXPIRATION_TIME)
				.createNewPaste(PASTE_TITLE)
				.waitUntilLoaded();
	}

	@Test(description = "Page title is correct test")
	public void testNewPasteTitleIsCorrect() {
		Assert.assertEquals(driver.getTitle(),
						PASTE_TITLE + " - Pastebin.com",
						"Title of page with created paste doesn't match paste title");
	}

	@Test(description = "Bash syntax highlighting is enabled test")
	public void testSyntaxHighlightingIsBash() {
		Assert.assertEquals(createdPastePage.determineSyntaxHighlightingLanguage(),
				EXPECTED_SYNTAX_HIGHLIGHTING_LANGUAGE,
						"Paste syntax highlighting isn't Bash");
	}

	@Test(description = "Raw paste data is correct test")
	public void testRawPasteDataIsCorrect() {
		Assert.assertEquals(createdPastePage.getRawPasteData(),
				EXPECTED_RAW_PASTE_DATA,
						"Raw paste data doesn't match the data, which was entered" +
								" while creating the paste");
	}

	@AfterClass(description = "Chrome browser teardown", alwaysRun = true)
	public void browserTearDown() {
		driver.quit();
		driver = null;
	}
}
