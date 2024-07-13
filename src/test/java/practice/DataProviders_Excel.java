package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.FileUtility.ExcelUtility;

public class DataProviders_Excel {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandname, String productname) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://amazon.in");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname, Keys.ENTER);
		String x = "//span[contains(text(),'"+productname+"')]/../../../../descendant::span[text()='19,999']";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();

	}

	@DataProvider
	public Object[][] getData() throws Throwable {

		ExcelUtility elib = new ExcelUtility();
		int rowcount = elib.getRowCount("dataproviders");
		Object[][] objarr = new Object[rowcount][2];
		for (int i = 0; i < rowcount; i++) {
			objarr[i][0] = elib.getDataFromExcel("dataproviders", i + 1, 0);
			objarr[i][1] = elib.getDataFromExcel("dataproviders", i + 1, 1);

		}

		return objarr;
	}

}
