package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	// Rule-1 : Create a separate java class
	// Rule-2 : Object creation
	@FindBy(name = "user_name")
	private WebElement usernameTF;

	@FindBy(name = "user_password")
	private WebElement passwordTF;

	@FindBy(id = "submitButton")
	private WebElement login_btn;
	
	@FindBy(xpath = "//a[text()='vtiger']")
	private WebElement loginHearderMsg;

	// Rule-3 : Object Initialization

	public WebElement getHearderMsg() {
		return loginHearderMsg;
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Rule-4 : Object Encapsulation
	public WebElement getUsername() {
		return usernameTF;
	}

	public WebElement getPassword() {
		return passwordTF;
	}

	public WebElement getLogin_btn() {
		return login_btn;
	}

	// Run-5 : Provide Action
	public void Logintoapp(String url,String username, String password) {
		driver.manage().window().maximize();
		driver.get(url);
		usernameTF.sendKeys("admin");
		passwordTF.sendKeys("password");
		login_btn.click();
	}

}
