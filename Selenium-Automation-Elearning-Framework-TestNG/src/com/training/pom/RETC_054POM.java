package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_054POM {
	private WebDriver driver;
	
	public RETC_054POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,  this);
	}
	
	//Finding All Web Elements which are required in this Test cases from row # 18 to row # 66 by @FindBy. 
	@FindBy(xpath="//*[@id=\"menu-item-617\"]/a")
	private WebElement blogTab;
	
	// need to check first and then change xpath as per the availability ...... for which property we will do the operation as per test case
	@FindBy(xpath="//div[@id='post-2989']//a[@class='read-more'][contains(text(),'Read More')]") 
	private WebElement readMoreLink;
	
	@FindBy(xpath="//textarea[@id='comment']")
	private WebElement commentTextBox;
	
	
	@FindBy(xpath="//input[@id='author']")
	private WebElement nameTextBox;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement emailTextBox;
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement postCommentBtn;
	
	
	@FindBy(tagName="body")
	private WebElement openNewWindow;
	
	@FindBy(id="user_login")
	private WebElement userName; 

	@FindBy(id="user_pass")
	private WebElement password;
	
	//@FindBy(id="formLogin_submitAuth")

	@FindBy(name="login")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(text(),'Comments')]")
	private WebElement commentsTab;
	
	@FindBy(xpath="//a[@data-action='replyto']")
	private WebElement replyIcon;
	
	@FindBy(id="replycontent")
	private WebElement replyTextBox;
	
	@FindBy(xpath="//span[@id='replybtn']")
	private WebElement approveAndReplyBtn;
	
	@FindBy(xpath="//body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/p[1]")
	private WebElement enteredReplydMsg;
	
	
	
	
	//assigning the methods for each of the web elements as per the requirement of the Test cases from row # 72 to end.
	public void clickBlogTab() {
		this.blogTab.click(); 
		
	}
	
	public void clickReadMoreLink() {
		this.readMoreLink.click(); 
		
	}
	
	public void sendCommentTextBox(String commentTextBox) {
		this.commentTextBox.clear();
		this.commentTextBox.sendKeys(commentTextBox);
	}
	
	public void sendNameTextBox(String nameTextBox) {
		this.nameTextBox.clear();
		this.nameTextBox.sendKeys(nameTextBox);
	}
	
	public void sendEmailTextBox(String emailTextBox) {
		this.emailTextBox.clear();
		this.emailTextBox.sendKeys(emailTextBox);
	}
	
	
	
	public void clickPostCommentBtn() {
		this.postCommentBtn.click(); 
		
	}
	
	
	public void launchNewWindowAdminSite() throws Exception { // Method for entering credentials in Enter title here text box
		this.openNewWindow.sendKeys(Keys.chord(Keys.CONTROL, "n"));
		driver.get("http://realestate.upskills.in/wp-admin/");

	}
	
	
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
	
	public void clickCommentsTab() {
		this.commentsTab.click(); 
		
	}
	
	public void clickReplyIcon() {
		this.replyIcon.click(); 
		
	}
	
	public void sendReplyTextBox(String replyTextBox) {
		this.replyTextBox.clear(); 
		this.replyTextBox.sendKeys(replyTextBox); 
	}
	
	public void clickApproveAndReplyBtn() {
		this.approveAndReplyBtn.click(); 
		
	}
	
	public String getEnteredReplydMsg() {
		
		return this.enteredReplydMsg.getText();	
		}
	
	
}