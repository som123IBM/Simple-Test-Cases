package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_053POM {
	private WebDriver driver;
	
	public RETC_053POM(WebDriver driver) {
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

	@FindBy(xpath="//a[@class='wp-first-item current']")
	private WebElement allPropertiesLink;
	
	@FindBy(xpath="//a[@href='edit.php?post_status=trash&post_type=property']")
	private WebElement trashLink;
	
	@FindBy(xpath="//table[1]/tbody[1]/tr[1]/td[1]/div[2]/span[1]/a[1]")
	private WebElement restoreLink;
	
	@FindBy(xpath="//p[contains(text(),'1 post restored from the Trash.')]")
	private WebElement restoreConfirmMsg;
	
	
	@FindBy(tagName="body")
	private WebElement openNewWindow;
	
	
	@FindBy(name="phrase")
	private WebElement searchBox;
	
	@FindBy(xpath="//*[@id=\"mCSBap_1_container\"]/div/div[3]/div[1]/h3/a/span")
	private WebElement searchPropertiesBtn;
	
	
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
	
	
	
	public void launchNewWindowUserSite() throws Exception { // Method for a new window where using the userURL of real state
		this.openNewWindow.sendKeys(Keys.chord(Keys.CONTROL, "n"));
		driver.get("http://realestate.upskills.in/");

	}
	
	public void sendSearchBox(String searchBox) {
		this.searchBox.clear();
		this.searchBox.sendKeys(searchBox);
	}
	
	public void clickSearchPropertiesBtn() {
		this.searchPropertiesBtn.click();
	}
	
}	