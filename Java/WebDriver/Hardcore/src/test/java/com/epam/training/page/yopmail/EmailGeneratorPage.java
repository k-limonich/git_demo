package com.epam.training.page.yopmail;

import com.epam.training.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailGeneratorPage extends AbstractPage {

	@FindBy(id = "egen")
	private WebElement generatedEmail;

	@FindBy(xpath = "//span[text()='Check Inbox']")
	private WebElement btnCheckInbox;

	public EmailGeneratorPage(WebDriver driver) {
		super(driver);
	}

	public String copyEmailAddress() {
		return generatedEmail.getText();
	}

	public InboxPage checkInbox() {
		wait.until(ExpectedConditions.elementToBeClickable(btnCheckInbox))
				.click();
		return new InboxPage(driver);
	}

}
