package com.uiautomation.kira.googlesearch.model;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search {
	private WebDriver driver;

	private By input = By.xpath("//form[@role='search']/descendant::input");
	private By searchButton = By.xpath("//input[@value='Google Search']");
	
	public Search(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement enterSearchString() {
		WebElement element = driver.findElement(input);
		assertTrue(element.isEnabled());
		return element;
	}
	
	public WebElement clickSearchButton() {
		WebElement element = driver.findElement(searchButton);
		assertTrue(element.isEnabled());
		return element;
	}
	
}
