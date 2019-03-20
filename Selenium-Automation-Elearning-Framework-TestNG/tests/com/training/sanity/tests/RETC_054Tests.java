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
import com.training.pom.RETC_054POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_054Tests {
	
	private WebDriver driver;
	private String baseUrl1;
	private String baseUrl;
	private RETC_054POM viewreplycommentsPOM3;
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
			viewreplycommentsPOM3 = new RETC_054POM(driver); 
			baseUrl1 = properties.getProperty("baseURL1"); // Used the User URL ("http://realestate.upskills.in/") .... stored in others.perperties >> resources
			screenShot = new ScreenShot(driver); 
			
			report = new ExtentReports("report\\RETC_054.html");
			test = report.startTest("Test Case name: View & Reply to Comments - RETC_054");
			// open the browser 
			driver.get(baseUrl1);
			test.log(LogStatus.INFO, "Pre-Condition 1:", "user should have launched the application by entering valid URL "); // print Precondition 1 in ExtentReport
			test.log(LogStatus.INFO, "Pre-Condition 2:", "Late, admin should have the application by entering valid URL "); // print Precondition 2 in ExtentReport	
			
		}
		
		
		@AfterMethod
		public void tearDown() throws Exception {
			/*Thread.sleep(1000);
			driver.quit();*/
		}
		
		@Test
		public void ViewReplyToCommentTest() throws Exception {
			
			
			// start below actions by using User Url
			viewreplycommentsPOM3.clickBlogTab();
			viewreplycommentsPOM3.clickReadMoreLink();
			viewreplycommentsPOM3.sendCommentTextBox("Sachin2"); // must need to change this comment at each iteration
			viewreplycommentsPOM3.sendNameTextBox("Manzoor");
			viewreplycommentsPOM3.sendEmailTextBox("manzoormehadi26@gmail.com");
			Thread.sleep(1000);
			
			
			viewreplycommentsPOM3.clickPostCommentBtn();
			
			screenShot.captureScreenShot("Comment posted as an User");
			Thread.sleep(3000);
			//driver.quit();
			
			// below commented out section is also worked ........ then must comment out below driver.quit();
			/*driver = DriverFactory.getDriver(DriverNames.CHROME);
			viewreplycommentsPOM3 = new RETC_054POM(driver); 
			baseUrl = properties.getProperty("baseURL");
			driver.get(baseUrl);*/
			
			viewreplycommentsPOM3.launchNewWindowAdminSite();
			Thread.sleep(3000);
			
			viewreplycommentsPOM3.sendUserName("admin");
			viewreplycommentsPOM3.sendPassword("admin@123");
			viewreplycommentsPOM3.clickLoginBtn();
			viewreplycommentsPOM3.clickCommentsTab();
			
			
			Thread.sleep(3000);
			
			Actions action = new Actions(driver);
			WebElement reply = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[2]/p[1]"));
			action.moveToElement(reply).build().perform();
			
			
			screenShot.captureScreenShot("User Comment visiable to an Admin");
			viewreplycommentsPOM3.clickReplyIcon();
			
			viewreplycommentsPOM3.sendReplyTextBox("Hello2"); // must need to change this comment at each iteration for the same Blog .... **1
			
			
			screenShot.captureScreenShot("Reply comment posted as an Admin");
			viewreplycommentsPOM3.clickApproveAndReplyBtn();
			screenShot.captureScreenShot("Progress Bar");
			Thread.sleep(3000);
			driver.navigate().refresh();
			screenShot.captureScreenShot("Comment and Reply Comment");
			
			
			
			
			String actualResult1=viewreplycommentsPOM3.getEnteredReplydMsg();
			String expectedResult1="Hello2"; // keeping the value same as in step " viewreplycommentsPOM3.sendReplyTextBox("Hello 4"); .." ... **1 
			
			if (expectedResult1.startsWith(actualResult1)) {
				test.log(LogStatus.PASS, "Test Passed","Admin is able to view & reply to recent comments added by user in dashboard ");
			} else {
				test.log(LogStatus.FAIL, "Test Failed","Admin is not able to view & reply to recent comments added by user in dashboard");
			}
			
			
			System.out.println(viewreplycommentsPOM3.getEnteredReplydMsg());
			
			report.endTest(test);
			report.flush();
}
}