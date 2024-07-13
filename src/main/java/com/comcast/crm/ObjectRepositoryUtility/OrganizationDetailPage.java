package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationDetailPage {

	WebDriver driver;

	public OrganizationDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath =  "//span[@class='dvHeaderText']")
	private WebElement OrgDetailHeader;
	
	public WebElement getOrgDetailHeader() {
		return OrgDetailHeader;
	}

	@FindBy(id =  "dtlview_Industry")
	private WebElement indutryField;
	
	@FindBy(id =  "dtlview_Type")
	private WebElement typeField;
	
	@FindBy(id =  "mouseArea_Phone")
	private WebElement phnoField;

	

	public WebElement getIndutryField() {
		return indutryField;
	}

	public WebElement getTypeField() {
		return typeField;
	}

	public WebElement getPhnoField() {
		return phnoField;
	}
	
	

}
