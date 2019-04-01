package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC_085POM {
	private WebDriver driver;
	
	public RETC_085POM(WebDriver driver) {
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
	
	//start

	@FindBy(xpath="//a[contains(text(),'Regions')]")
	private WebElement regionsLink;
	
	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement nameTextBox;
	
	@FindBy(xpath="//input[@id='tag-slug']")
	private WebElement slugTextBox;
	
	@FindBy(xpath="//select[@id='parent']")
	private WebElement parentRegionListBox;
	
	/*@FindBy(id="parent")
	private WebElement selectParentRegionListBox;*/
	
	
	@FindBy(xpath="//textarea[@id='tag-description']")
	private WebElement descriptionTextBox;
	
	@FindBy(xpath="//input[@value='Add New Region']")
	private WebElement addNewRegionBtn;
	
	
	@FindBy(xpath="//a[@href='post-new.php?post_type=property']")
	private WebElement addNewLink;
	
	@FindBy(xpath="//input[@name='post_title']")
	private WebElement titleTextBox;
	
	@FindBy(xpath="/html[1]/body[1]")
	private WebElement textClick;
	
	@FindBy(xpath="/html[1]/body[1]")
	private WebElement bodyTextBox;
	
	@FindBy(xpath="//*[contains(text(),'Electronic1')]") // Need to change as per the value ('Electronic') given in Tests Class ...... 
	private WebElement checkNewRegion;
	
	@FindBy(xpath="//*[@id=\'publish\']")
	private WebElement publishBtn;
	
	@FindBy(xpath="//a[@class='ab-item'][contains(text(),'Log Out')]")
	private WebElement logOutLink;
	
	
	@FindBy(xpath="//a[@title='Real Estate']")
	private WebElement realEstateIcon;
	
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
	
	
	// start here
	
	public void clickRegionsLink() {
		this.regionsLink.click();
	}
	
	public void sendNameTextBox(String nameTextBox) {
		this.nameTextBox.clear();
		this.nameTextBox.sendKeys(nameTextBox);
	}
	
	public void sendSlugTextBox(String slugTextBox) {
		this.slugTextBox.clear();
		this.slugTextBox.sendKeys(slugTextBox);
	}
	
	/*public String getRestoreConfirmMsg() {
		
		return this.restoreConfirmMsg.getText();	
		}*/
	
	public void clickParentRegionListBox() {
		this.parentRegionListBox.click();
	}
	
	
	/*public void selectParentRegionListBox(String parentRegion) { // Method for Clicking on Add new Region link in Feature section
		Select select_region=new Select (this.selectParentRegionListBox);
		select_region.selectByVisibleText(parentRegion);
	}*/
	
	
	
	public void sendDescriptionTextBox(String descriptionTextBox) {
		this.descriptionTextBox.clear();
		this.descriptionTextBox.sendKeys(descriptionTextBox);
	}
	
	public void clickAddNewRegionBtn() {
		this.addNewRegionBtn.click();
	}
	
	public void clickAddNewLink() {
		this.addNewLink.click();
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
	
	
	public void clickCheckNewRegion() {
		this.checkNewRegion.click();
	
	}
	
	public void clickPublishBtn() {
		this.publishBtn.click();
	
	}
	
	
	
	public void clickLogOutLink() {
		this.logOutLink.click();
	
	}
	
	public void clickRealEstateIcon() {
		this.realEstateIcon.click();
	
	}
	
	public void sendSearchBox(String searchBox) {
		this.searchBox.clear();
		this.searchBox.sendKeys(searchBox);
	}
	
	public void clickSearchPropertiesBtn() {
		this.searchPropertiesBtn.click();
	}
}	