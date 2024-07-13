package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Creating New Contact']")
	private WebElement CreateContactHeader;

	@FindBy(name = "lastname")
	private WebElement lastNameTF;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement organizationplusbtn;

	@FindBy(name = "support_start_date")
	private WebElement startDate;

	@FindBy(name = "support_end_date")
	private WebElement endDate;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;	

	@FindBy(name = "search_text")
	private WebElement OrgFrameSearchTFElement;
	
	@FindBy(name = "search_field")
	private WebElement OrgFrameSearchDDElement;
	
	@FindBy(name = "search")
	private WebElement OrgFrameSearchbtnElement;
	

	public WebElement getOrgFrameSearchTFElement() {
		return OrgFrameSearchTFElement;
	}

	
	public WebElement getOrgFrameSearchbtnElement() {
		return OrgFrameSearchbtnElement;
	}

	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactHeader() {
		return CreateContactHeader;
	}

	public void getlastNameTF(String lastname) {
		lastNameTF.sendKeys(lastname);

	}

	public WebElement getOrganizationplusbtn() {
		return organizationplusbtn;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getsaveBtn() {
		 return saveBtn;
	}

	
	
	

}
