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
import com.training.pom.RETC_022POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_022Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_022POM changerolePOM3;
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
		changerolePOM3 = new RETC_022POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		
		report = new ExtentReports("report\\RETC_022.html");
		test = report.startTest("Test Case name: Change Role - RETC_022");
		// open the browser 
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Pre-Condition 1:", "user should have launched the application by entering valid URL."); // Print the Precondition 1 in the ExtentReport
		test.log(LogStatus.INFO, "Pre-Condition 2:", "admin should be logged in."); // Print the Precondition 2 in the ExtentReport
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validChangeRoleTest() {
		changerolePOM3.sendUserName("admin");
		changerolePOM3.sendPassword("admin@123");
		changerolePOM3.clickLoginBtn(); 
		changerolePOM3.clickUsersLnk();
		changerolePOM3.clickAllUsersLnk();
		changerolePOM3.clickCheckBox();
		String str = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[3]/td[1]/strong[1]/a[1]")).getText(); // fetching the username of the user for which role is changing
		screenShot.captureScreenShot("BeforeChangeRole");
		changerolePOM3.clickChangeRoleToLBox();
		changerolePOM3.clickListBoxValue();
		changerolePOM3.clickChangeButton();
		screenShot.captureScreenShot("AfterChangeRole");
		
		String actualResult1=changerolePOM3.getConfirmChangeRole();
		
		//for extent report
		String expectedResult1="Changed roles.";
		if (expectedResult1.startsWith(actualResult1)) {
			test.log(LogStatus.PASS, "Test Passed","User Role is changed ");
		} else {
			test.log(LogStatus.FAIL, "Test Failed","User Role is not changed");
		}
		
		
		
		System.out.println(changerolePOM3.getConfirmChangeRole());
		System.out.println("Role Changed to " + changerolePOM3.getVerifyChangeRole() + " for the user of Username "+ str );
		
		report.endTest(test);
		report.flush();
	}
}
