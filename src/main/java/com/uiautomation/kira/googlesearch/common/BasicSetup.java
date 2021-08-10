package com.uiautomation.kira.googlesearch.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.uiautomation.kira.googlesearch.model.Search;
import com.uiautomation.kira.googlesearch.model.SearchResult;

public class BasicSetup {
	public WebDriver driver;
	public String username = "";
	public String password = "";

	private String browser = "";

	public Search search;
	public SearchResult results;

	public Wait wait;
	public Utility utility = new Utility();
	public Report report;
	public TakesScreenshot screenshot;

	public BasicSetup() {

		String url = utility.getProperty(Constants.RUN_CONFIGURATION, "url");
		setup(url);

		screenshot = ((TakesScreenshot) driver);

		wait = new Wait(driver);
		wait.implicitlyFor(10);

		search = new Search(driver);
		results = new SearchResult(driver);

		report = new Report(utility.getProperty(Constants.RUN_CONFIGURATION, "OS"), browser);
		report.startReport();
	}

	public void setup(String url) {

		driverSetup();
		driver.get(url);

	}

	private void driverSetup() {
		browser = utility.getProperty(Constants.RUN_CONFIGURATION, "browser");

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			// Save firefox driver under /UpgradeUIAutomation/src/resources/drivers
		} else if (browser.equalsIgnoreCase("Safari")) {
			// Save Safari driver under /UpgradeUIAutomation/src/resources/drivers
		} else if (browser.equalsIgnoreCase("IE")) {
			// Save IE driver under /UpgradeUIAutomation/src/resources/drivers
		}

		driver.manage().window().maximize();

	}

	public void takeScreenshot() {
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/searchResult.png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(srcFile, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
