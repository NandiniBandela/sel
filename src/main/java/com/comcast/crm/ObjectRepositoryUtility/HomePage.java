package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	// Rule-1 : Create a separate java class
	// Rule-2 : Object creation
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement HomeHeaderMsg;
	
	public WebElement getHomeHeaderMsg() {
		return HomeHeaderMsg;
	}

	// Rule-3 : Object Initialization
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Rule-4 : Object Encapsulation

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public void navigateToCampaignPage() {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();
	}
	
	public void logout() {
		Actions act=new Actions(driver);
		act.moveToElement(adminIcon).perform();
		signOut.click();
	}
	

	


}
