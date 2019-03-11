package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_021POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_021Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_021POM deletetagPOM3;
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
		deletetagPOM3 = new RETC_021POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = new ExtentReports("report\\RETC_021.html");
		test = report.startTest("Test Case name: Delete Tag - RETC_021");
		
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
	public void validDeleteTagTest() {
		deletetagPOM3.sendUserName("admin");
		deletetagPOM3.sendPassword("admin@123");
		deletetagPOM3.clickLoginBtn(); 
		deletetagPOM3.clickPostsLnk();
		deletetagPOM3.clickTagsLnk();
		deletetagPOM3.clickCheckBox();
		String str = driver.findElement(By.xpath("//form[1]/table[1]/tbody[1]/tr[1]/td[1]/strong[1]/a[1]")).getText();
		screenShot.captureScreenShot("TagBeforeDelete");
		deletetagPOM3.clickBulkActionsLBox();
		deletetagPOM3.clickDelete();
		deletetagPOM3.clickApplyBtn();
		screenShot.captureScreenShot("TagAfterDelete");
		
		String actualResult1=deletetagPOM3.getTagDeleted();
		
		//for extent report
		String expectedResult1="Tags deleted.";
		if (expectedResult1.startsWith(actualResult1)) {
			test.log(LogStatus.PASS, "Test Passed","Tag is deleted");
		} else {
			test.log(LogStatus.FAIL, "Test Failed","Tag is not deleted");
		}
		
		System.out.println(str + " " + deletetagPOM3.getTagDeleted());
		
		report.endTest(test);
		report.flush();
	}
}
