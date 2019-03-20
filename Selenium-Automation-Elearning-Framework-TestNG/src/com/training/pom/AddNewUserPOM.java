package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewUserPOM {
	private WebDriver driver; 
	
	public AddNewUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 

	@FindBy(id="user_pass")
	private WebElement password;
	

	//@FindBy(id="formLogin_submitAuth")

	@FindBy(name="login")
	private WebElement loginBtn;
	
	// For using Mouse Over Action 1 - commented out below section of code , but if use mouse over action 0 then must use
	
	/*@FindBy(xpath="//div[contains(text(),'Users')]")
	private WebElement users;*/
	
	@FindBy(xpath="//a[@href='user-new.php']")
	private WebElement addnew;
	
	
	/*
	@FindBy(xpath="//table[1]/tbody[1]/tr[3]/th[1]/input[1]")
	private WebElement checkbox;*/
	
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
	
	
	/*@FindBy(xpath="//option[contains(@value,'agent')][contains(text(),'Agent')]")
	private WebElement listboxvalue;
	
	@FindBy(id="changeit")
	private WebElement changebutton;
	
	@FindBy(xpath="//p[contains(text(),'Changed roles.')]")
	private WebElement confirmchangerole;
	
	@FindBy(xpath="//table[1]/tbody[1]/tr[3]/td[4]")
	private WebElement verifychangerole;*/

	
	
	
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
	
	// for doing the mouse over action 0 use below methods
	/*public void moveMouseToUser() {
	Actions act = new Actions(driver);
	act.moveToElement(users).build().perform();
	}*/
	
	// For using Mouse Over Action 1 and action 0 - commented out below section of code
	/*public void clickUsers() {
		this.users.click(); 
	}*/
	
	
	public void clickAddNew() {
		this.addnew.click(); 
	}
	
	/*public void clickCheckBox() {
		this.checkbox.click(); 
	}*/
	
	public void sendUserName1(String userName1) {
		this.userName1.clear(); 
		this.userName1.sendKeys(userName1);
		
	}
	
	/*public String getUserName1() {
		return this.userName1.getAttribute("value"); 
		
		
	}*/
	
	public void sendEmail(String email) {
		this.email.clear(); 
		this.email.sendKeys(email); 
	}
	
	public void sendFirstName(String firstName) {
		this.firstName.clear(); 
		this.firstName.sendKeys(firstName); 
	}
	
	public void sendLastName(String lastName) {
		this.lastName.clear(); 
		this.lastName.sendKeys(lastName); 
	}
	
	public void sendWebSite(String webSite) {
		this.webSite.clear(); 
		this.webSite.sendKeys(webSite); 
	}
	
	public void clickPasswordBtn() {
		this.passwordBtn.click(); 
	}
	
	public void sendPasswordValue(String passwordValue) {
		this.passwordValue.clear(); 
		this.passwordValue.sendKeys(passwordValue); 
	}
	
	public void clickUserRoleDDList() {
		this.userRole.click(); 
	}
	
	public void clickUserRoleSelection() {
		this.userRoleSelection.click(); 
	}
	
	public void clickAddNewUserBtn() {
		this.addNewUserBtn.click(); 
	}
	
	
	/*public void clickListBoxValue() {
		this.listboxvalue.click(); 
	}
	
	public void clickChangeButton() {
		this.changebutton.click(); 
	}
	
	public String getConfirmChangeRole() {
		
		return this.confirmchangerole.getText();	
		
	}
	
	public String getVerifyChangeRole() {
		
		return this.verifychangerole.getText();	
		
	}*/

public String getNewUserConfirmation() {
		
		return this.newUserConfirmation.getText();	
		
	}
	
}