package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_052POM {
	private WebDriver driver;
	
	public RETC_052POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,  this);
	}
	
	
	//Finding All Web Elements which are required in this Test cases from row # 18 to row # 51 by @FindBy.
	@FindBy(id="user_login")
	private WebElement userName; 

	@FindBy(id="user_pass")
	private WebElement password;
	

	//@FindBy(id="formLogin_submitAuth")

	@FindBy(name="login")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement propertiesLink;
	
	@FindBy(xpath="//a[@class='wp-first-item current']")
	private WebElement allPropertiesLink;
	
	@FindBy(xpath="//table[1]/tbody[1]/tr[1]/td[1]/div[3]/span[3]/a[1]")
	private WebElement trashLink;
	
	@FindBy(xpath="//a[@href='edit.php?post_status=trash&post_type=property']")
	private WebElement trash1Link;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/span[2]/a[1]")
	private WebElement permanentDeleteLink;
	
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/p[1]")
	private WebElement deleteConfirmMsg;
	
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/p[1]")
	private WebElement restoreConfirm;
	
	//assigning the methods for each of the web elements as per the requirement of the Test cases from row # 54 to end.
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
	
	public void clickTrashLink() {
		this.trashLink.click();
	}
	
	public void clickTrash1Link() {
		this.trash1Link.click();
	}
	
	public void clickPermanentDeleteLink() {
		this.permanentDeleteLink.click();
	}
	
	
	public String getDeleteConfirmMsg() {
			return this.deleteConfirmMsg.getText();	
	}	
		
}


