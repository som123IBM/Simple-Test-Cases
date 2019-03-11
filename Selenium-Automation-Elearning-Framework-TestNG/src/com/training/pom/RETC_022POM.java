package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_022POM {
	private WebDriver driver; 
	
	public RETC_022POM(WebDriver driver) {
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
	
	@FindBy(xpath="//div[contains(text(),'Users')]")
	private WebElement users;
	
	@FindBy(xpath="//a[@class='wp-first-item current']")
	private WebElement allusers;
	
	@FindBy(xpath="//table[1]/tbody[1]/tr[3]/th[1]/input[1]")
	private WebElement checkbox;
	
	@FindBy(id="new_role")
	private WebElement changeroleto;
	
	@FindBy(xpath="//option[contains(@value,'agent')][contains(text(),'Agent')]")
	private WebElement listboxvalue;
	
	@FindBy(id="changeit")
	private WebElement changebutton;
	
	@FindBy(xpath="//p[contains(text(),'Changed roles.')]")
	private WebElement confirmchangerole;
	
	@FindBy(xpath="//table[1]/tbody[1]/tr[3]/td[4]")
	private WebElement verifychangerole;

	
	
	
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
	
	public void clickUsersLnk() {
		this.users.click(); 
	}
	
	public void clickAllUsersLnk() {
		this.allusers.click(); 
	}
	
	public void clickCheckBox() {
		this.checkbox.click(); 
	}
	
	public void clickChangeRoleToLBox() {
		this.changeroleto.click(); 
	}
	
	public void clickListBoxValue() {
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
		
	}
	
}
