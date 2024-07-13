package com.crmcast.crm.generic.BaseUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.generic.DatabaseUtility.DataBaseUtility;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

public class BaseClass {
	public DataBaseUtility dLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver = null;

	public HomePage hp = null;

	public static WebDriver sdriver = null;


	@BeforeSuite(groups = { "smoke test", "regression test" })
	public void configBS() {
		System.out.println("connection to Database");
		dLib.getDBConnection();

	}

	@BeforeTest(groups = { "smoke test", "regression test" })
	public void configBT() {

	}

// @Parameters("Browser")
//	@BeforeClass (groups = {"smoke test","regression test"})
//	public void configBC(String browser)  throws Throwable {
	@BeforeClass(groups = { "smoke test", "regression test" })
	public void configBC() throws Throwable {
		System.out.println("launch the browser");
		// String BROWSER = browser;
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setdriver(driver);
		wLib.waitForPageToLoad(driver);
	}

	@BeforeMethod(groups = { "smoke test", "regression test" })
	public void configBM() throws Throwable {

		System.out.println("login");
		LoginPage lp = new LoginPage(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		lp.Logintoapp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smoke test", "regression test" })
	public void configAM() {
		System.out.println("logout of the application");
		hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "smoke test", "regression test" })
	public void configAC() {
		System.out.println("Close the browser");
		driver.quit();
	}

	@AfterTest(groups = { "smoke test", "regression test" })
	public void configAT() {

	}

	@AfterSuite(groups = { "smoke test", "regression test" })
	public void configAS() {
		System.out.println("Close DB,Report Config");
		dLib.closeDBConnection();

	}

}
