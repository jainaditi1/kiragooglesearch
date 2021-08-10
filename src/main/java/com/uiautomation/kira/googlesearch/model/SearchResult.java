package com.uiautomation.kira.googlesearch.model;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResult {
	private WebDriver driver;
	
	////cite[text()="https://kirasystems.com"]

	private By firstResult = By.xpath("(//cite)[1]");
	
	public SearchResult(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String getFirstSearchResult() {
		WebElement element = driver.findElement(firstResult);
		assertTrue(element.isDisplayed());
		String firstSearchResultValue = element.getText();
		return firstSearchResultValue;
	}
	
	
	
}
