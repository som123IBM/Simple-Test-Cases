package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC_083POM {
	private WebDriver driver;
	
	public RETC_083POM(WebDriver driver) {
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
	
	// Start here
	
	@FindBy(xpath="//div[contains(text(),'Posts')]")
	private WebElement postsLink;
	
	@FindBy(xpath="//a[@href='edit-tags.php?taxonomy=category']")
	private WebElement categoriesLink;
	
	@FindBy(xpath="//input[@name='tag-name']")
	private WebElement nameTextBox;
	
	@FindBy(xpath="//input[@id='tag-slug']")
	private WebElement slugTextBox;
	
	@FindBy(xpath="//select[@id='parent']")
	private WebElement parentCategoryListBox;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement descriptionTextBox;
	
	@FindBy(xpath="//input[@value='Add New Category']")
	private WebElement addNewCategoryBtn;
	
	/*@FindBy(xpath="//a[@href='post-new.php']")
	private WebElement addNewLink;*/
	
	@FindBy(xpath="//a[contains(text(),'All Posts')]")
	private WebElement allPostsLink;
	
	@FindBy(xpath="//a[@class='page-title-action']")
	private WebElement addNewBtn;
	
	@FindBy(xpath="//input[@name='post_title']")
	private WebElement titleTextBox;
	
	@FindBy(xpath="/html[1]/body[1]")
	private WebElement textClick;
	
	@FindBy(xpath="/html[1]/body[1]")
	private WebElement bodyTextBox;
	
	@FindBy(xpath="//ul[@id='categorychecklist']")
	private WebElement categoryList;
	
	@FindBy(xpath="//input[@name='post_category[]']")
	private WebElement checkCategory;
	
	@FindBy(xpath="//*[@id=\'publish\']")
	private WebElement publishBtn;
	
	/*@FindBy(xpath="//*[@id=\"message\"]/p")
	private WebElement publishConfirmMsg;*/
	
	
	
	
	
	
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
		
		public void clickPostsLink() {
			this.postsLink.click(); 
			
		}
		
		public void clickCategoriesLink() {
			this.categoriesLink.click(); 
			
		}
		
		public void sendNameTextBox(String nameTextBox) {
			this.nameTextBox.clear();
			this.nameTextBox.sendKeys(nameTextBox);
		}
		
		public void sendSlugTextBox(String slugTextBox) {
			this.slugTextBox.clear();
			this.slugTextBox.sendKeys(slugTextBox);
		}
		
		
		
		public void clickParentCategoryListBox() {
			this.parentCategoryListBox.click();
		}
		
		public void sendDescriptionTextBox(String descriptionTextBox) {
			this.descriptionTextBox.clear();
			this.descriptionTextBox.sendKeys(descriptionTextBox);
		}
		
		public void clickAddNewCategoryBtn() {
			this.addNewCategoryBtn.click();
		}
		
		public void clickAllPostsLink() {
			this.allPostsLink.click();
		}
		
		public void clickAddNewBtn() {
			this.addNewBtn.click();
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
		
		public void clickCategoryList() {
			this.categoryList.click();
		
		}
		
		public void clickCheckCategory() {
			this.checkCategory.click();
		
		}
		
		
		public void clickPublishBtn() {
			this.publishBtn.click();
		
		}
		
		/*public String getPublishConfirmMsg() {
			
			return this.publishConfirmMsg.getText();	
			}*/
		
}		
	