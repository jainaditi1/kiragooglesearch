package com.uiautomation.kira.googlesearch;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.uiautomation.kira.googlesearch.common.BasicSetup;
import com.uiautomation.kira.googlesearch.common.Constants;


public class GoogleSearchTest extends BasicSetup {
	
	@Test
	public void testSearchGoogleForKira() {

		String searchText = utility.getProperty(Constants.DATA, "searchString");
		search.enterSearchString().sendKeys(searchText);
		search.clickSearchButton().click();
		String firstResult = results.getFirstSearchResult();
		String resultText = utility.getProperty(Constants.DATA, "resultString");
		
		assertEquals(firstResult, resultText);
		assertTrue(firstResult.equalsIgnoreCase(resultText), "First search result is not Kira Website!");
		
		takeScreenshot();
		
		report.testcase = report.extent.createTest("testSearchGoogleForKira", "PASSED");
		
	}

	
	@AfterClass
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		report.extent.flush();

	}
	
	@AfterMethod
    public void getResult(ITestResult result) {
		report.getResult(result);
    }

}
