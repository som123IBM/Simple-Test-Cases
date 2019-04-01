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
import com.training.pom.RETC_081POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_081Tests {
	
	private WebDriver driver;
	private String baseUrl;
	private RETC_081POM addmultiplefeaturePOM3;
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
			addmultiplefeaturePOM3 = new RETC_081POM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			
			/*report = new ExtentReports("report\\RETC_081.html");
			test = report.startTest("Test Case name: Add Multiple Features - RETC_081");*/
			// open the browser 
			driver.get(baseUrl);
			/*test.log(LogStatus.INFO, "Pre-Condition 1:", "user should have launched the application by entering valid URL "); // print Precondition 1 in ExtentReport
			test.log(LogStatus.INFO, "Pre-Condition 2:", "admin should be logged in "); // print Precondition 2 in ExtentReport	
			test.log(LogStatus.INFO, "Pre-Condition 3:", "admin should have added property details ");*/ 
			// print Precondition 3 in ExtentReport
		}
		
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
		
		@Test(dataProvider = "db-inputs1", dataProviderClass = LoginDataProviders.class)
		public void AddMultipleRegionTest(String nametextbox, String slugtextbox, String parentfeaturelistbox, String descriptiontextbox) throws Exception {	
			addmultiplefeaturePOM3.sendUserName("admin");
			addmultiplefeaturePOM3.sendPassword("admin@123");
			addmultiplefeaturePOM3.clickLoginBtn();
			addmultiplefeaturePOM3.clickPropertiesLink();
			addmultiplefeaturePOM3.clickFeaturesLink();
			Thread.sleep(1000);
			addmultiplefeaturePOM3.sendNameTextBox(nametextbox);
			addmultiplefeaturePOM3.sendSlugTextBox(slugtextbox);
			//addmultipleregionPOM3.clickParentRegionListBox();
			
			//addmultipleregionPOM3.selectParentRegionListBox(parentRegion);
			
			
			Select drpfeatureParent = new Select(driver.findElement(By.name("parent")));
			//System.out.println(parentRegionListBox);
			drpfeatureParent.selectByVisibleText(parentfeaturelistbox);
			
			addmultiplefeaturePOM3.sendDescriptionTextBox(descriptiontextbox);
			
			
			addmultiplefeaturePOM3.clickAddNewFeatureBtn();;
			//screenShot.captureScreenShot("Before Restore Properties");
			// capturing the text of the properties which will be used for restore operation.
			//String str = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/strong[1]")).getText(); 
			
			
			// using the Mouse Over action on the property on which do the restore.
			/*Actions action = new Actions(driver);
			WebElement title = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/th[1]/input[1]"));
			action.moveToElement(title).build().perform();*/
			
			
			
			//restorepropertiesPOM3.clickRestoreLink();
			//screenShot.captureScreenShot("After Restore Properties");
			
			
			/*String actualResult1=restorepropertiesPOM3.getRestoreConfirmMsg();
			String expectedResult1="1 post restored from the Trash.";
			
			if (expectedResult1.startsWith(actualResult1)) {
				test.log(LogStatus.PASS, "Test Passed","Feature is created successfully. ");
			} else {
				test.log(LogStatus.FAIL, "Test Failed","Feature is not created.");
			}*/
			
			
			
			//System.out.println(restorepropertiesPOM3.getRestoreConfirmMsg());
			//System.out.println(str);
			
			
			/*restorepropertiesPOM3.launchNewWindowUserSite(); // launching new window opening with User Url
			Thread.sleep(3000);
			restorepropertiesPOM3.sendSearchBox(str);
			restorepropertiesPOM3.clickSearchPropertiesBtn();
			// using WindowHandles for moving to next Tab
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    //driver.close(); uncomment that if want to close the window
		    //driver.switchTo().window(tabs2.get(0)); 
*/		    // uncommented that if want to back in the first Tab of the User Url
			
			
			//screenShot.captureScreenShot("search Restored Properties");
			//Thread.sleep(3000);
			
			
			/*report.endTest(test);
			report.flush();*/
			
			
		}


}
