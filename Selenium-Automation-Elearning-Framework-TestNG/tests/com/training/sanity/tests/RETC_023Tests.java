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
import com.training.pom.RETC_023POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_023Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_023POM deleteuserPOM3;
	private static Properties properties;
	private ScreenShot screenShot;
	//for extent report
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
		deleteuserPOM3 = new RETC_023POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		//for extent report
		report = new ExtentReports("report\\RETC_023.html");
		test = report.startTest("Test Case name: Delete User - RETC_023");
		
		// open the browser 
		driver.get(baseUrl);
		//for extent report
		test.log(LogStatus.INFO, "Pre-Condition 1:", "user should have launched the application by entering valid URL."); // print Precondition 1 in ExtentReport
		test.log(LogStatus.INFO, "Pre-Condition 2:", "admin should be logged in."); // print Precondition 2 in ExtentReport
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validDeleteUserTest() {
		deleteuserPOM3.sendUserName("admin");
		deleteuserPOM3.sendPassword("admin@123");
		deleteuserPOM3.clickLoginBtn(); 
		deleteuserPOM3.clickUsersLnk();
		deleteuserPOM3.clickAllUsersLnk();
		deleteuserPOM3.clickCheckBox();
		screenShot.captureScreenShot("BeforeDeleteUser");
		deleteuserPOM3.clickBulkActionsLBox();
		deleteuserPOM3.clickListBoxValue();
		deleteuserPOM3.clickApplyBtn();
		//String actualResult=deleteuserPOM.getConfirmDeletion();
		System.out.println(deleteuserPOM3.getConfirmDeletion());
		//changerolePOM.clickChangeRoleTo();
		//changerolePOM.clickListBoxValue();
		//changerolePOM.clickChangeButton();
		screenShot.captureScreenShot("AfterDeleteUser");
	
		
		deleteuserPOM3.clickBtnConfirmDeletion();
		
		String actualResult1=deleteuserPOM3.getUserDeleted();
		
		//for extent report
		String expectedResult1="User deleted.";
		if (expectedResult1.startsWith(actualResult1)) {
			test.log(LogStatus.PASS, "Test Passed","User is deleted");
		} else {
			test.log(LogStatus.FAIL, "Test Failed","User is not deleted");
		}
		
		System.out.println(deleteuserPOM3.getUserDeleted());
		screenShot.captureScreenShot("Delete Confirmation");
		
		//for extent report
		report.endTest(test);
		report.flush();
	}
}
