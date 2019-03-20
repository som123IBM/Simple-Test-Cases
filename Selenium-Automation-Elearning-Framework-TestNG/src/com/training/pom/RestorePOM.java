package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestorePOM {
	private WebDriver driver;
	
	public RestorePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,  this);
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
	
	@FindBy(xpath="//a[@class='wp-first-item current']")
	private WebElement allPropertiesLink;
	
	@FindBy(xpath="//a[@href='edit.php?post_status=trash&post_type=property']")
	private WebElement trashLink;
	
	@FindBy(xpath="//table[1]/tbody[1]/tr[1]/td[1]/div[2]/span[1]/a[1]")
	private WebElement restoreLink;
	
	@FindBy(xpath="//p[contains(text(),'1 post restored from the Trash.')]")
	private WebElement restoreConfirmMsg;
	
	
	
	
	
	
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/p[1]")
	private WebElement restoreConfirm;
	
	
	
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
	
	public void clickRestoreLink() {
		this.restoreLink.click();
	}
		
		 
		
			
		
		
		
		public String getRestoreConfirmMsg() {
			
			return this.restoreConfirmMsg.getText();	
			
		
		}	
		
		
	}


