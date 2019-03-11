package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_021POM {
	private WebDriver driver; 
	
	public RETC_021POM(WebDriver driver) {
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
	
	@FindBy(xpath="//div[contains(text(),'Posts')]")
	private WebElement posts;
	
	@FindBy(xpath="//a[@href='edit-tags.php?taxonomy=post_tag']")
	private WebElement tags;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[3]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/th[1]/input[1]")
	private WebElement checkbox;
	
	@FindBy(id="bulk-action-selector-top")
	private WebElement bulkactions;
	
	@FindBy(xpath="//option[@value='delete'][contains(text(),'Delete')]")
	private WebElement delete;
	
	@FindBy(id="doaction")
	private WebElement apply;
	
	@FindBy(xpath="//p[contains(text(),'Tags deleted.')]")
	private WebElement tagdeleted;
	
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
	
	public void clickPostsLnk() {
		this.posts.click(); 
	}
	
	public void clickTagsLnk() {
		this.tags.click(); 
	}
	
	public void clickCheckBox() {
		this.checkbox.click(); 
	}
	
	public void clickBulkActionsLBox() {
		this.bulkactions.click(); 
	}
	
	public void clickDelete() {
		this.delete.click(); 
	}
	
	public void clickApplyBtn() {
		this.apply.click(); 
	}
	
	public String getTagDeleted() {
		
		return this.tagdeleted.getText();
	}
}