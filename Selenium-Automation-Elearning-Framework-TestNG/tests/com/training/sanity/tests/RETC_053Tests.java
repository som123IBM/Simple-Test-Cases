package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_053POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_053Tests {
	
	private WebDriver driver;
	private String baseUrl;
	private RETC_053POM restorepropertiesPOM3;
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
		
		@Test(priority=1)
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			restorepropertiesPOM3 = new RETC_053POM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			
			report = new ExtentReports("report\\RETC_053.html");
			test = report.startTest("Test Case name: Restore Properties & Search - RETC_053");
			// open the browser 
			driver.get(baseUrl);
			test.log(LogStatus.INFO, "Pre-Condition 1:", "user should have launched the application by entering valid URL "); // print Precondition 1 in ExtentReport
			test.log(LogStatus.INFO, "Pre-Condition 2:", "admin should be logged in "); // print Precondition 2 in ExtentReport	
			test.log(LogStatus.INFO, "Pre-Condition 3:", "admin should have added property details "); // print Precondition 3 in ExtentReport
		}
		
		
		@AfterClass
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			//driver.quit();
		}
		
		@Test(priority=2)
		public void RestoredPropertySearchTest() throws Exception {
			restorepropertiesPOM3.sendUserName("admin");
			restorepropertiesPOM3.sendPassword("admin@123");
			restorepropertiesPOM3.clickLoginBtn();
			restorepropertiesPOM3.clickPropertiesLink();
			restorepropertiesPOM3.clickAllPropertiesLink();
			restorepropertiesPOM3.clickTrashLink();
			Thread.sleep(1000);
			screenShot.captureScreenShot("Before Restore Properties");
			// capturing the text of the properties which will be used for restore operation.
			String str = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/strong[1]")).getText(); 
			// using the Mouse Over action on the property on which do the restore.
			Actions action = new Actions(driver);
			WebElement title = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/th[1]/input[1]"));
			action.moveToElement(title).build().perform();
			
			
			
			restorepropertiesPOM3.clickRestoreLink();
			screenShot.captureScreenShot("After Restore Properties");
			
			
			String actualResult1=restorepropertiesPOM3.getRestoreConfirmMsg();
			String expectedResult1="1 post restored from the Trash.";
			
			if (expectedResult1.startsWith(actualResult1)) {
				test.log(LogStatus.PASS, "Test Passed","Property is removed from Trash list and Restored and finding that ");
			} else {
				test.log(LogStatus.FAIL, "Test Failed","Property is not removed from Trash list and not Restored");
			}
			
			
			
			System.out.println(restorepropertiesPOM3.getRestoreConfirmMsg());
			System.out.println(str);
			
			
			restorepropertiesPOM3.launchNewWindowUserSite(); // launching new window opening with User Url
			Thread.sleep(3000);
			restorepropertiesPOM3.sendSearchBox(str);
			restorepropertiesPOM3.clickSearchPropertiesBtn();
			// using WindowHandles for moving to next Tab
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    //driver.close(); uncomment that if want to close the window
		    //driver.switchTo().window(tabs2.get(0)); // uncommented that if want to back in the first Tab of the User Url
			
			
			screenShot.captureScreenShot("search Restored Properties");
			Thread.sleep(3000);
			
			
			report.endTest(test);
			report.flush();
			
			
		}

}
