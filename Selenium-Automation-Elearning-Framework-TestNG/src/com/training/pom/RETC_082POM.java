package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC_082POM {
	private WebDriver driver;
	
	public RETC_082POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,  this);
	}
	
	// Finding All Web Elements which are required in this Test cases from row # 18 to row # 54 by @FindBy. 
	@FindBy(id="user_login")
	private WebElement userName; 

	@FindBy(id="user_pass")
	private WebElement password;
	

	//@FindBy(id="formLogin_submitAuth")

	@FindBy(name="login")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement propertiesLink;
	
	//start

	@FindBy(xpath="//a[contains(text(),'Regions')]")
	private WebElement regionsLink;
	
	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement nameTextBox;
	
	@FindBy(xpath="//input[@id='tag-slug']")
	private WebElement slugTextBox;
	
	@FindBy(xpath="//select[@id='parent']")
	private WebElement parentRegionListBox;
	
	/*@FindBy(id="parent")
	private WebElement selectParentRegionListBox;*/
	
	
	@FindBy(xpath="//textarea[@id='tag-description']")
	private WebElement descriptionTextBox;
	
	@FindBy(xpath="//input[@value='Add New Region']")
	private WebElement addNewRegionBtn;
	
	
	// assigning the methods for each of the web elements as per the requirement of the Test cases from row # 58 to end.
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	} 
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
		
	}	
	public void clickPropertiesLink() {
		this.propertiesLink.click();
	}
	
	
	// start here
	
	public void clickRegionsLink() {
		this.regionsLink.click();
	}
	
	public void sendNameTextBox(String nameTextBox) {
		this.nameTextBox.clear();
		this.nameTextBox.sendKeys(nameTextBox);
	}
	
	public void sendSlugTextBox(String slugTextBox) {
		this.slugTextBox.clear();
		this.slugTextBox.sendKeys(slugTextBox);
	}
	
	/*public String getRestoreConfirmMsg() {
		
		return this.restoreConfirmMsg.getText();	
		}*/
	
	public void clickParentRegionListBox() {
		this.parentRegionListBox.click();
	}
	
	
	/*public void selectParentRegionListBox(String parentRegion) { // Method for Clicking on Add new Region link in Feature section
		Select select_region=new Select (this.selectParentRegionListBox);
		select_region.selectByVisibleText(parentRegion);
	}*/
	
	
	
	public void sendDescriptionTextBox(String descriptionTextBox) {
		this.descriptionTextBox.clear();
		this.descriptionTextBox.sendKeys(descriptionTextBox);
	}
	
	public void clickAddNewRegionBtn() {
		this.addNewRegionBtn.click();
	}
}	