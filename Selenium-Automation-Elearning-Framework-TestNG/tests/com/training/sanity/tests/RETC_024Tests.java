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
import com.training.pom.RETC_024POM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_024Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_024POM addnewuserPOM3;
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
		addnewuserPOM3 = new RETC_024POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		
		// For ExtentReport purpose
		report = new ExtentReports("report\\RETC_024.html");
		test = report.startTest("Test Case name: Add New User - RETC_024");
		// open the browser 
		driver.get(baseUrl);
		// log used in ExtentReport
		test.log(LogStatus.INFO, "Pre-Condition 1:", "user should have launched the application by entering valid URL."); // print Precondition 1 in ExtentReport
		test.log(LogStatus.INFO, "Pre-Condition 2:", "admin should be logged in."); // print Precondition 2 in ExtentReport
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void AddNewUserTest() throws Exception {
		addnewuserPOM3.sendUserName("admin");
		addnewuserPOM3.sendPassword("admin@123");
		addnewuserPOM3.clickLoginBtn();
		addnewuserPOM3.clickUsersLnk();
		screenShot.captureScreenShot("BeforeCreateNewUser");
		addnewuserPOM3.clickAddNewLnk();
		addnewuserPOM3.sendUserName1TBox("Sachin133");
		String str = driver.findElement(By.id("user_login")).getAttribute("value"); // print the username which is newly creating
		addnewuserPOM3.sendEmailTBox("sachin19@in.abc.com");
		addnewuserPOM3.sendFirstNameTBox("SACHIN");
		addnewuserPOM3.sendLastNameTBox("JAIN");
		addnewuserPOM3.sendWebSiteTBox("www.google.com");
		Thread.sleep(3000);
		addnewuserPOM3.clickPasswordBtn();
		Thread.sleep(1000);
		addnewuserPOM3.sendPasswordTBox("Shin#123436956789");
		addnewuserPOM3.clickUserRoleListBox();
		addnewuserPOM3.clickUserRoleSelection();
		screenShot.captureScreenShot("FillupFormCreateNewUser");
		addnewuserPOM3.clickAddNewUserBtn();
		screenShot.captureScreenShot("AfterCreateNewUser");
		
		
		
		String actualResult1=addnewuserPOM3.getNewUserConfirmation();
		
		//for extent report
		String expectedResult1="New user created. Edit user";
		
		if (expectedResult1.startsWith(actualResult1)) {
			test.log(LogStatus.PASS, "Test Passed","New User is created ");
		} else {
			test.log(LogStatus.FAIL, "Test Failed","New User is not created");
		}
		
		
		
		System.out.println(addnewuserPOM3.getNewUserConfirmation());
		System.out.println("Username of newly created User is" + str);
		
		report.endTest(test);
		report.flush();
	}
}
