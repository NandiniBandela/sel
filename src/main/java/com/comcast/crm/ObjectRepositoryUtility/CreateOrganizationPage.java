package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationPage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Creating New Organization']")
	private WebElement CreateOrgHeader;

	@FindBy(name = "accountname")
	private WebElement orgNameTF;

	@FindBy(name = "industry")
	private WebElement industryDD;

	@FindBy(name = "accounttype")
	private WebElement typeDD;

	@FindBy(name = "phone")
	private WebElement phoneTF;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgHeader() {
		return CreateOrgHeader;
	}

	public void createOrg(String orgName) {
		orgNameTF.sendKeys(orgName);
		saveBtn.click();
	}

	public void createOrg(String orgName, String industry, String type) {
		orgNameTF.sendKeys(orgName);
		Select s = new Select(industryDD);
		s.selectByVisibleText(industry);
		Select s1 = new Select(typeDD);
		s1.selectByVisibleText(type);
		saveBtn.click();
	}

	public void createOrgWithPhn(String orgName, String phoneno) {
		orgNameTF.sendKeys(orgName);
		phoneTF.sendKeys(phoneno);
		saveBtn.click();
	}

}
