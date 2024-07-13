package practice;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.crmcast.crm.generic.BaseUtility.BaseClass;
@Listeners(com.comcast.crm.listenerUtility.ListImpClass.class)
public class SampleReportTest extends BaseClass{
	public void createleadtest() {
		System.out.println("login");
		System.out.println("navigate to Leads page");
		System.out.println("Lead lead");
		if ("HDFC".equals("HDFC")) {
			System.out.println("Lead is created");
		} else {
			System.out.println("Lead is not created");
		}
		System.out.println("logout");
	}

	@Test
	public void createContacttest() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http:localhost:8888");
		TakesScreenshot edriver=(TakesScreenshot)BaseClass.sdriver;
		String filepath=edriver.getScreenshotAs(OutputType.BASE64);
			
//		// Configuration of the report
//		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report.html");
//		spark.config().setDocumentTitle("CRM Suite Results");
//		spark.config().setReportName("CRM Report");
//		spark.config().setTheme(Theme.DARK);
//
//		// Add environment info and create test
//		ExtentReports report = new ExtentReports();
//		report.attachReporter(spark);
//		report.setSystemInfo("OS", "Windows-10");
//		report.setSystemInfo("BROWSER", "Chrome-117");
		
//		report=new ExtentReports();
//		ExtentTest test = report.createTest("createContacttest");
//		test.log(Status.INFO, "Login to app");
//		test.log(Status.INFO, "navigate to contact page");
//		test.log(Status.INFO, "Create contact");
//		if ("HDFC1".equals("HDFC")) {
//			test.log(Status.PASS, "contact created");
//		} else {
//			test.addScreenCaptureFromBase64String(filepath,"ErrorFile");
//		}
	driver.close();

	}

}
