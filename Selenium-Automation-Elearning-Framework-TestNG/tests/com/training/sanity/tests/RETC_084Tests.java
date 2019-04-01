package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_084POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_084Tests {
	
	private WebDriver driver;
	private String baseUrl;
	private RETC_084POM createUserPOM3;
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
			createUserPOM3 = new RETC_084POM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			
			report = new ExtentReports("report\\RETC_084.html");
			test = report.startTest("Test Case name: Add Multiple Regions - RETC_0824");
			// open the browser 
			driver.get(baseUrl);
			test.log(LogStatus.INFO, "Pre-Condition 1:", "user should have launched the application by entering valid URL "); // print Precondition 1 in ExtentReport
			test.log(LogStatus.INFO, "Pre-Condition 2:", "admin should be logged in "); // print Precondition 2 in ExtentReport	
			test.log(LogStatus.INFO, "Pre-Condition 3:", "admin should have added property details ");
			// print Precondition 3 in ExtentReport
		}
		
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
		
		@Test(dataProvider = "excel-inputs3", dataProviderClass = LoginDataProviders.class)
		public void AddMultipleRegionTest(String Name, String password, String uName, String emails, String fName, String lName, String wSite, String pTextBox, String sRole) throws Exception {
			createUserPOM3.sendUserName(Name);
			createUserPOM3.sendPassword(password);
			createUserPOM3.clickLoginBtn();
			Thread.sleep(1000);
			
			
			createUserPOM3.clickUsersLnk();
			createUserPOM3.clickAddNewLnk();
			createUserPOM3.sendUserName1TBox(uName);
			createUserPOM3.sendEmailTBox(emails);
			createUserPOM3.sendFirstNameTBox(fName);
			createUserPOM3.sendLastNameTBox(lName);
			createUserPOM3.sendWebSiteTBox(wSite);
			createUserPOM3.clickPasswordBtn();
			Thread.sleep(3000);
			createUserPOM3.sendPasswordTBox(pTextBox);
			
			//createUserPOM3.clickUserRoleListBox();
			
			Select drproleListBox = new Select(driver.findElement(By.name("role")));
			//System.out.println(parentRegionListBox);
			drproleListBox.selectByVisibleText(sRole);
			
			screenShot.captureScreenShot("BeforeCreateNewUser");
			Thread.sleep(3000);
			
			
			createUserPOM3.clickAddNewUserBtn();
			screenShot.captureScreenShot("AfterCreateNewUser");
			
			String actualResult1= createUserPOM3.getNewUserConfirmation();
			System.out.println(actualResult1);
			
			//for extent report
			String expectedResult1="New user created. Edit user";
			
			if (expectedResult1.startsWith(actualResult1)) {
				test.log(LogStatus.PASS, "Test Passed","New User is created ");
			} else {
				test.log(LogStatus.FAIL, "Test Failed","New User is not created");
			}
			
			
			
			System.out.println(createUserPOM3.getNewUserConfirmation());
			//System.out.println("Username of newly created User is" + str);
			
			report.endTest(test);
			report.flush();

			
			
			
			
		}
}		

			
			