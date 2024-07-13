package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	WebDriver driver;
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateContactbtn;

	@FindBy(name = "search_text")
	private WebElement searchTF;

	@FindBy(name = "search_field")
	private WebElement searchDD;

	@FindBy(name = "submit")
	private WebElement searchBtn;

//		@FindBy (xpath="//a[text()='"+lastName+"']/../../td[10]/a[text()='del']")
//		WebElement deleteBtn;

	@FindBy(xpath = "//a[@class='hdrLink']")
	private WebElement ContactHeaderMsg;

	public WebElement getContactHeaderMsg() {
		return ContactHeaderMsg;
	}

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewContact() {
		return CreateContactbtn;
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

//		public WebElement getDeleteBtn() {
//			return deleteBtn;
//		}
}
