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
import com.training.pom.RETC_051POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_051Tests {
	
	private WebDriver driver;
	private String baseUrl;
	private RETC_051POM restorePOM3;
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
			restorePOM3 = new RETC_051POM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			
			report = new ExtentReports("report\\RETC_051.html");
			test = report.startTest("Test Case name: Restore Property - RETC_051");
			// open the browser 
			driver.get(baseUrl);
			test.log(LogStatus.INFO, "Pre-Condition 1:", "user should have launched the application by entering valid URL "); // print Precondition 1 in ExtentReport
			test.log(LogStatus.INFO, "Pre-Condition 2:", "admin should be logged in "); // print Precondition 2 in ExtentReport	
			test.log(LogStatus.INFO, "Pre-Condition 3:", "admin should have added property details in trash "); // print Precondition 3 in ExtentReport
		}
		
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
		
		@Test
		public void RestoreTest() throws Exception {
			restorePOM3.sendUserName("admin");
			restorePOM3.sendPassword("admin@123");
			restorePOM3.clickLoginBtn();
			restorePOM3.clickPropertiesLink();
			restorePOM3.clickAllPropertiesLink();
			restorePOM3.clickTrashLink();
			Thread.sleep(1000);
			screenShot.captureScreenShot("Before Restore");
			
			//Using Mouse Over Action on the Properties on which do the restore operation
			
			Actions action = new Actions(driver);
			WebElement title = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/th[1]/input[1]"));
			action.moveToElement(title).build().perform();
			
			restorePOM3.clickRestoreLink();
			screenShot.captureScreenShot("complete Restore");
			
			
			String actualResult1=restorePOM3.getRestoreConfirmMsg();
			String expectedResult1="1 post restored from the Trash.";
			
			if (expectedResult1.startsWith(actualResult1)) {
				test.log(LogStatus.PASS, "Test Passed","Property is removed from Trash list and Restored and shown under All list ");
			} else {
				test.log(LogStatus.FAIL, "Test Failed","Property is not removed from Trash list and not Restored");
			}
			
			Thread.sleep(3000);
			
			System.out.println(restorePOM3.getRestoreConfirmMsg());
			
			restorePOM3.clickAllLink();
			driver.navigate().refresh(); // using to refresh the web page
			screenShot.captureScreenShot("After Restore");
			
			
			report.endTest(test);
			report.flush();
		}

}
