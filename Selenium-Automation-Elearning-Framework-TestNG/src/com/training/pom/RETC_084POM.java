package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC_084POM {
	private WebDriver driver;
	
	public RETC_084POM(WebDriver driver) {
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
	
	//Start here
	
	@FindBy(xpath="//div[contains(text(),'Users')]")
	private WebElement users;
	
	@FindBy(xpath="//a[@href='user-new.php']")
	private WebElement addnew;
	
	@FindBy(name="user_login")
	private WebElement userName1;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="url")
	private WebElement webSite;
	
	@FindBy(xpath="//button[contains(text(),'Show password')]")
	private WebElement passwordBtn;
	
	@FindBy(id="pass1-text")
	private WebElement passwordValue;
	
	@FindBy(xpath="//select[@id='role']")
	private WebElement userRole;
	
	@FindBy(xpath="//option[@value='agent']")
	private WebElement userRoleSelection;
	
	@FindBy(xpath="//input[@value='Add New User']")
	private WebElement addNewUserBtn;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/p[1]")
	private WebElement newUserConfirmation;
	

	
	
	
	
	
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
	
	
	// start here
	
	public void clickUsersLnk() {
		this.users.click(); 
	}
	
	
	public void clickAddNewLnk() {
		this.addnew.click(); 
	}
	
	
	public void sendUserName1TBox(String userName1) {
		this.userName1.clear(); 
		this.userName1.sendKeys(userName1);
		
	}
	
	public void sendEmailTBox(String email) {
		this.email.clear(); 
		this.email.sendKeys(email); 
	}
	
	public void sendFirstNameTBox(String firstName) {
		this.firstName.clear(); 
		this.firstName.sendKeys(firstName); 
	}
	
	public void sendLastNameTBox(String lastName) {
		this.lastName.clear(); 
		this.lastName.sendKeys(lastName); 
	}
	
	public void sendWebSiteTBox(String webSite) {
		this.webSite.clear(); 
		this.webSite.sendKeys(webSite); 
	}
	
	public void clickPasswordBtn() {
		this.passwordBtn.click(); 
	}
	
	public void sendPasswordTBox(String passwordValue) {
		this.passwordValue.clear(); 
		this.passwordValue.sendKeys(passwordValue); 
	}
	
	public void clickUserRoleListBox() {
		this.userRole.click(); 
	}
	
	/*public void clickUserRoleSelection() {
		this.userRoleSelection.click(); 
	}*/
	
	public void clickAddNewUserBtn() {
		this.addNewUserBtn.click(); 
	}
	

	public String getNewUserConfirmation() {
		
		return this.newUserConfirmation.getText();	
		
	}
	
	
	
}	