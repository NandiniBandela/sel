package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailPage  {

	WebDriver driver;

	public ContactDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath =  "//span[@class='dvHeaderText']")
	private WebElement ContactDetailHeader;
	
	@FindBy(id =  "dtlview_Last Name")
	private WebElement lastnameField;
	
	@FindBy(id =  "mouseArea_Organization Name")
	private WebElement orgField;
	
	@FindBy(id =  "dtlview_Support Start Date")
	private WebElement startdate;
	
	@FindBy(id =  "dtlview_Support End Date")
	private WebElement enddate;


	public WebElement getContactDetailHeader() {
		return ContactDetailHeader;
	}


	public WebElement getLastnameField() {
		return lastnameField;
	}


	public WebElement getOrgField() {
		return orgField;
	}


	public WebElement getStartdate() {
		return startdate;
	}


	public WebElement getEnddate() {
		return enddate;
	}

	
	

}

