package com.comcast.crm.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;
import com.crmcast.crm.generic.BaseUtility.BaseClass;

public class ListImpClass implements ISuiteListener, ITestListener {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("===>" + result.getMethod().getMethodName() + "==START===>");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.settest(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("===>" + result.getMethod().getMethodName() + "==COMPLETED===>");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();
		TakesScreenshot Tobj = (TakesScreenshot) BaseClass.sdriver;
		String filepath = Tobj.getScreenshotAs(OutputType.BASE64);
		// File src = Tobj.getScreenshotAs(OutputType.FILE);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
//		try {
//			FileUtils.copyFile(src, new File("./Screenshots/" + testName + "_" + time + ".png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		test.addScreenCaptureFromBase64String(filepath, testName + "_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "===FAIL==>");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report config");
		// Configuration of the report
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./Advance_Reports/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// Add environment info and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome-117");

	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
