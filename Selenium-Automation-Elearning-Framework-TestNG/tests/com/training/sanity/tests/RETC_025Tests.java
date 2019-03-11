package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_025POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_025Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_025POM filterpropertiesPOM3;
	private static Properties properties;
	private ScreenShot screenShot;
	private ExtentTest test;
	private ExtentReports report;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		filterpropertiesPOM3 = new RETC_025POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		
		report = new ExtentReports("report\\RETC_025.html");
		test = report.startTest("Test Case name: Filter Properties - RETC_025");
		// open the browser 
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Pre-Condition 1:", "user should have launched the application by entering valid URL."); // print Precondition 1 in ExtentReport
		test.log(LogStatus.INFO, "Pre-Condition 2:", "admin should be logged in."); // print Precondition 2 in ExtentReport
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void FilterPropertiesTest() {
		filterpropertiesPOM3.sendUserName("admin");
		filterpropertiesPOM3.sendPassword("admin@123");
		filterpropertiesPOM3.clickLoginBtn();
		filterpropertiesPOM3.clickPropertiesLink();
		filterpropertiesPOM3.clickAllPropertiesLink();
		screenShot.captureScreenShot("BeforeFilterSearch");
		filterpropertiesPOM3.clickAllDatesListBox();
		filterpropertiesPOM3.clickDateSelection();
		filterpropertiesPOM3.clickFilterBtn();
		screenShot.captureScreenShot("AfterFilterSearch");
		
		String actualResult1=filterpropertiesPOM3.getDateValue();
		
		//for extent report
		String expectedResult1="March 2018";
		
		if (expectedResult1.startsWith(actualResult1)) {
			test.log(LogStatus.PASS, "Test Passed","Properties details matching filter criteria is displaying ");
		} else {
			test.log(LogStatus.FAIL, "Test Failed","Properties details matching filter criteria is not displaying ");
		}
		
		
		
		System.out.println("Searching Properties filter by DATE :- " +filterpropertiesPOM3.getDateValue());
		
		
		report.endTest(test);
		report.flush();
	}
}
