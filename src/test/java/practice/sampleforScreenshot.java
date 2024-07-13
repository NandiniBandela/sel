package practice;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class sampleforScreenshot {

	@Test
	public void amazonTest() throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://amazon.com");
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		FileUtils .copyFile(src, new File("./Screenshots/testA.png"));
		driver.quit();
	}
	@Test
	public void FlipkartTest() throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://flipkart.com");
		TakesScreenshot Tobj=(TakesScreenshot)driver;
		File src=Tobj.getScreenshotAs(OutputType.FILE);
		FileUtils .copyFile(src, new File("./Screenshots/testF.png"));
		driver.quit();
	}
}
