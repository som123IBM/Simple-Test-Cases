package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.AddNewUserPOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddNewUserTests {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private AddNewUserPOM addnewuserPOM;
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
		addnewuserPOM = new AddNewUserPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		
		report = new ExtentReports("report\\AddNewUser.html");
		test = report.startTest("Test Case name: Add New User - RETC_024");
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
	public void AddNewUserTest() throws Exception {
		addnewuserPOM.sendUserName("admin");
		addnewuserPOM.sendPassword("admin@123");
		addnewuserPOM.clickLoginBtn();
		//addnewuserPOM.moveMouseToUser();  ... do using for MouseOver Action 0 and comment out the below code
		//addnewuserPOM.clickUsers();
		// for Mouse Over Action 1, use below set of code and comment out the above code
				Actions action = new Actions(driver);
				WebElement users = driver.findElement(By.xpath("//div[contains(text(),'Users')]"));
				action.moveToElement(users).build().perform();
		
		screenShot.captureScreenShot("BeforeCreateNewUser");
		addnewuserPOM.clickAddNew();
		addnewuserPOM.sendUserName1("Sachin134");
		String str = driver.findElement(By.id("user_login")).getAttribute("value");
		addnewuserPOM.sendEmail("sachin20@in.abc.com");
		addnewuserPOM.sendFirstName("SACHIN");
		addnewuserPOM.sendLastName("JAIN");
		addnewuserPOM.sendWebSite("www.google.com");
		Thread.sleep(1000);
		addnewuserPOM.clickPasswordBtn();
		Thread.sleep(1000);
		addnewuserPOM.sendPasswordValue("Shin#1234556739");
		addnewuserPOM.clickUserRoleDDList();
		addnewuserPOM.clickUserRoleSelection();
		screenShot.captureScreenShot("FillupFormCreateNewUser");
		addnewuserPOM.clickAddNewUserBtn();
		//changerolePOM.clickCheckBox();
		screenShot.captureScreenShot("AfterCreateNewUser");
		/*changerolePOM.clickChangeRoleTo();
		changerolePOM.clickListBoxValue();
		changerolePOM.clickChangeButton();
		screenShot.captureScreenShot("AfterChangeRole");*/
		
		
		String actualResult1=addnewuserPOM.getNewUserConfirmation();
		
		//for extent report
		String expectedResult1="New user created. Edit user";
		
		if (expectedResult1.startsWith(actualResult1)) {
			test.log(LogStatus.PASS, "Test Passed","New User is created ");
		} else {
			test.log(LogStatus.FAIL, "Test Failed","New User is not created");
		}
		
		
		
		System.out.println(addnewuserPOM.getNewUserConfirmation());
		System.out.println(str);
		
		
		
		report.endTest(test);
		report.flush();
	}
}
