package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_023POM {
	private WebDriver driver; 
	
	public RETC_023POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 

	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Users')]")
	private WebElement users;
	
	@FindBy(xpath="//a[@class='wp-first-item current']")
	private WebElement allusers;
	
	@FindBy(xpath="//table[1]/tbody[1]/tr[3]/th[1]/input[1]")
	private WebElement checkbox;
	
	@FindBy(id="bulk-action-selector-top")
	private WebElement bulkactions;
	
	@FindBy(xpath="//option[@value='delete'][contains(text(),'Delete')]")
	private WebElement listboxvalue;
	
	@FindBy(id="doaction")
	private WebElement apply;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/ul[1]/li[1]")
	private WebElement confirmdeletion;
	
	@FindBy(xpath="//p[contains(text(),'User deleted.')]")
	private WebElement userdeleted;
	
	@FindBy(id="submit")
	private WebElement btnconfirmdeletion;
	


	//@FindBy(id="formLogin_submitAuth")

	@FindBy(name="login")
	private WebElement loginBtn;
	
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
	
	public void clickBulkActionsLBox() {
		this.bulkactions.click(); 
	}
	
	public void clickListBoxValue() {
		this.listboxvalue.click(); 
	}
	
	public void clickApplyBtn() {
		this.apply.click(); 
	}
	
	public String getConfirmDeletion() {
	
		return this.confirmdeletion.getText();	
		
	}
	
	public void clickBtnConfirmDeletion() {
		this.btnconfirmdeletion.click(); 
	}
	
	public String getUserDeleted() {
		
		return this.userdeleted.getText();	
		
	}
	
}
