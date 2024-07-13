package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	WebDriver driver;
	@FindBy (xpath="//img[@title='Create Organization...']")
	private WebElement CreateNewOrg;
	
	@FindBy (name="search_text")
	private WebElement searchTF;
	
	@FindBy (name="search_field")
	private WebElement searchDD;
	
	@FindBy (name="submit")
	private WebElement searchBtn;
	
	@FindBy (xpath="//a[@class='hdrLink']")
	private WebElement OrgHeaderMsg;
	
	
	
//	@FindBy (xpath="//a[text()='" + orgName + "']/../../td[8]/a[text()='del']")
//	WebElement deleteBtn;


	
	
	public OrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderMsg() {
		return OrgHeaderMsg;
	}

	public WebElement getCreateNewOrg() {
		return CreateNewOrg;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
//	public WebElement getDeleteBtn() {
//		return deleteBtn;
//	}
}
