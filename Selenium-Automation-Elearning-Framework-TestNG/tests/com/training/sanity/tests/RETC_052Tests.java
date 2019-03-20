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
import com.training.pom.RETC_052POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_052Tests {
	
	private WebDriver driver;
	private String baseUrl;
	private RETC_052POM deletepostPOM3;
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
			deletepostPOM3 = new RETC_052POM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			
			report = new ExtentReports("report\\RETC_052.html");
			test = report.startTest("Test Case name: Delete Post Permanently - RETC_052");
			// open the browser 
			driver.get(baseUrl);
			test.log(LogStatus.INFO, "Pre-Condition 1:", "user should have launched the application by entering valid URL "); // print Precondition 1 in ExtentReport
			test.log(LogStatus.INFO, "Pre-Condition 2:", "admin should be logged in "); // print Precondition 2 in ExtentReport	
			test.log(LogStatus.INFO, "Pre-Condition 3:", "admin should have added property details "); // print Precondition 3 in ExtentReport
		}
		
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
		
		@Test
		public void DeletePostTest() throws Exception {
			deletepostPOM3.sendUserName("admin");
			deletepostPOM3.sendPassword("admin@123");
			deletepostPOM3.clickLoginBtn();
			deletepostPOM3.clickPropertiesLink();
			deletepostPOM3.clickAllPropertiesLink();
			screenShot.captureScreenShot("Before Post Delete");
			
			// using the Mouse Action on the Properties on which will do the trash operation.
			Actions action = new Actions(driver);
			WebElement title = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/th[1]/input[1]"));
			action.moveToElement(title).build().perform();
			
			deletepostPOM3.clickTrashLink();
			Thread.sleep(1000);
			
			driver.navigate().refresh();
			
			
			deletepostPOM3.clickTrash1Link();
			screenShot.captureScreenShot("Deleted Post in trash");
			
			//using the Mouse Action on the Properties on which will do the permanent Delete operation.
			Actions action1 = new Actions(driver);
			WebElement title1 = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/th[1]/input[1]"));
			action.moveToElement(title1).build().perform();
			
			deletepostPOM3.clickPermanentDeleteLink();
			
			screenShot.captureScreenShot("Permanent Deleted Post");
			
			
			String actualResult1=deletepostPOM3.getDeleteConfirmMsg();
			String expectedResult1="1 post permanently deleted.";
			
			if (expectedResult1.startsWith(actualResult1)) {
				test.log(LogStatus.PASS, "Test Passed","Post is Deleted permanently ");
			} else {
				test.log(LogStatus.FAIL, "Test Failed","Post is not Deleted ");
			}
			
			
			
			System.out.println(deletepostPOM3.getDeleteConfirmMsg());
			
			report.endTest(test);
			report.flush();
		}
}
