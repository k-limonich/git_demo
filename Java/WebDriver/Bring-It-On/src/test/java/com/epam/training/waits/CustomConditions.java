package com.epam.training.waits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

public class CustomConditions {

	public static ExpectedCondition<Boolean> jQueryAJAXsCompleted() {
		return driver -> (Boolean) ((JavascriptExecutor)
				driver).executeScript("return (window.jQuery != null) && (jQuery.active == 0);");
	}
}
