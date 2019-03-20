package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_055POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_055Tests {
	
	private WebDriver driver;
	private String baseUrl;
	private RETC_055POM addnewCategoryPOM3;
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
			addnewCategoryPOM3 = new RETC_055POM(driver); 
			baseUrl = properties.getProperty("baseURL"); // using Admin Url ("http://realestate.upskills.in/wp-admin/"), stored in others.properties >> resources
			screenShot = new ScreenShot(driver); 
			
			report = new ExtentReports("report\\RETC_055.html");
			test = report.startTest("Test Case name: Add New Category with New Post - RETC_055");
			// open the browser 
			driver.get(baseUrl);
			test.log(LogStatus.INFO, "Pre-Condition 1:", "user should have launched the application by entering valid URL "); // print Precondition 1 in ExtentReport
			test.log(LogStatus.INFO, "Pre-Condition 2:", "admin should have added New Launch Post "); // print Precondition 2 in ExtentReport	
			
		}
		
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
		
		@Test
		public void RestoredPropertySearchTest() throws Exception {
			addnewCategoryPOM3.sendUserName("admin");
			addnewCategoryPOM3.sendPassword("admin@123");
			addnewCategoryPOM3.clickLoginBtn();
			// Mouse Over Action on the Posts Tab
			Actions action = new Actions(driver);
			WebElement posts = driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
			action.moveToElement(posts).build().perform();
			
			addnewCategoryPOM3.clickAddNewLink();
			
			addnewCategoryPOM3.clickAddNewCategoryLink();
			
			addnewCategoryPOM3.sendAddNewCategoryTextBox("Som3"); // same Test data will not allow more than one time under same Parent Category. need to change the Test Data and use the same in POM
			
			// using selectByVisibleText command to select the value from the dropdown list box
			Select drpcategoryParent = new Select(driver.findElement(By.name("newcategory_parent")));
			drpcategoryParent.selectByVisibleText("New Launch");
			
			addnewCategoryPOM3.clickAddNewCategoryBtn();
			Thread.sleep(1000);
			
			driver.navigate().refresh(); // for refreshing the web page
			screenShot.captureScreenShot("created new Category");
			
			
			addnewCategoryPOM3.sendTitleTextBox("IBM");
			
			driver.switchTo().frame("content_ifr"); // Body text box is inside an iframe, hence used the iframe command to enter inside the ifram
			
			addnewCategoryPOM3.clickTextClick(); // use the click operation for focusing inside the body text box.
			
			addnewCategoryPOM3.sendBodyTextBox("Manipal");
			Thread.sleep(3000);
			
			
			// now coming out from the iframe, for the rest of the operations where the web elements are present out side of the iframe
			driver.switchTo().parentFrame();
			addnewCategoryPOM3.clickCheckNewCategory();
			screenShot.captureScreenShot("selected new Category");
			Thread.sleep(3000);
			
			addnewCategoryPOM3.clickPublishBtn();
			screenShot.captureScreenShot("After Post");
			
			
			String actualResult1=addnewCategoryPOM3.getPublishConfirmMsg();
			String expectedResult1="Post published. View post";
			
			if (expectedResult1.startsWith(actualResult1)) {
				test.log(LogStatus.PASS, "Test Passed","Admin is added new Category while added new Post ");
			} else {
				test.log(LogStatus.FAIL, "Test Failed","Admin is not added new Category while added new Post");
			}
			
			
			
			
			report.endTest(test);
			report.flush();
			
			
		}

}