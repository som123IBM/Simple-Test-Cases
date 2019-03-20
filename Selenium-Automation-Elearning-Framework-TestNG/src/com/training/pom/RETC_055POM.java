package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_055POM {
	private WebDriver driver;
	
	public RETC_055POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,  this);
	}
	
	
	//Finding All Web Elements which are required in this Test cases from row # 18 to row # 57 by @FindBy.
	@FindBy(id="user_login")
	private WebElement userName; 

	@FindBy(id="user_pass")
	private WebElement password;
	
	//@FindBy(id="formLogin_submitAuth")
	@FindBy(name="login")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[@href='post-new.php']")
	private WebElement addNewLink;
	
	@FindBy(partialLinkText="+ Add New Catego")
	private WebElement addNewCategoryLink;
	
	@FindBy(xpath="//input[@value='New Category Name']")
	private WebElement addNewCategoryTextBox;
	
	
	@FindBy(id="category-add-submit")
	private WebElement addNewCategoryBtn;
	
	@FindBy(xpath="//input[@name='post_title']")
	private WebElement titleTextBox;
	
	@FindBy(xpath="/html[1]/body[1]")
	private WebElement textClick;
	
	@FindBy(xpath="/html[1]/body[1]")
	private WebElement bodyTextBox;
	
	@FindBy(xpath="//*[contains(text(),'Som3')][1]") // Need to change as per the value ('Add New Text1') given in Tests Class ...... 
	private WebElement checkNewCategory;
	
	@FindBy(xpath="//*[@id=\'publish\']")
	private WebElement publishBtn;
	
	@FindBy(xpath="//*[@id=\"message\"]/p")
	private WebElement publishConfirmMsg;
	
	
	
	
	//assigning the methods for each of the web elements as per the requirement of the Test cases from row # 63 to end.
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
	
	public void clickAddNewLink() {
		this.addNewLink.click(); 
	}
	
	
	public void clickAddNewCategoryLink() {
			this.addNewCategoryLink.click();
		
	}
	
	public void sendAddNewCategoryTextBox(String addNewCategoryTextBox) {
		this.addNewCategoryTextBox.clear(); 
		this.addNewCategoryTextBox.sendKeys(addNewCategoryTextBox); 
	} 
	
	public void clickAddNewCategoryBtn() {
		this.addNewCategoryBtn.click();
	
	}
	
	public void sendTitleTextBox(String titleTextBox) {
		this.titleTextBox.clear(); 
		this.titleTextBox.sendKeys(titleTextBox); 
	} 
	
	public void clickTextClick() {
		this.textClick.click();
	
	}
	
	
	
	public void sendBodyTextBox(String bodyTextBox) {
		this.bodyTextBox.clear(); 
		this.bodyTextBox.sendKeys(bodyTextBox); 
	}
	
	public void clickCheckNewCategory() {
		this.checkNewCategory.click();
	
	}
	
	public void clickPublishBtn() {
		this.publishBtn.click();
	
	}
	
	public String getPublishConfirmMsg() {
		
		return this.publishConfirmMsg.getText();	
		}
}