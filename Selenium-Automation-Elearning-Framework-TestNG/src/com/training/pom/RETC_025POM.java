package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_025POM {
	private WebDriver driver; 
	
	public RETC_025POM(WebDriver driver) {
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
	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement propertiesLink;
	
	@FindBy(xpath="//a[contains(text(),'All Properties')]")
	private WebElement allPropertiesLink;
	
	@FindBy(id="filter-by-date")
	private WebElement allDatesListBox;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/div[1]/div[2]/select[1]/option[5]")
	private WebElement dateSelection;
	
	@FindBy(name="filter_action")
	private WebElement filterBtn;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/div[1]/div[2]/select[1]/option[5]")
	private WebElement dateValue;
	
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
	
	public void clickAllPropertiesLink() {
		this.allPropertiesLink.click();
	}
	
	public void clickAllDatesListBox() {
		this.allDatesListBox.click();
	}
	
	public void clickDateSelection() {
		this.dateSelection.click();
	}
	
	public void clickFilterBtn() {
		this.filterBtn.click();
	}
	
	public String getDateValue() {
		
		return this.dateValue.getText();	
	}
}
