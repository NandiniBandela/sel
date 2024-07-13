package contactTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.ObjectRepositoryUtility.ContactDetailPage;
import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationDetailPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;
import com.crmcast.crm.generic.BaseUtility.BaseClass;

public class CreateContactTest extends BaseClass {
	@Test(groups = "smoke test")
	public void CreateContactTest1() throws InterruptedException, Throwable {

		SoftAssert soft=new SoftAssert();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		//WebDriverUtility wLib = new WebDriverUtility();

		// maximize and wait statement
		//wLib.waitForPageToLoad(driver);

		// Read TestScriptData from Excel file
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
		UtilityClassObject.gettest().log(Status.INFO, "ReadData from Excel");

		// Navigate to Organization Module/Page and click on create org img
		HomePage hp = new HomePage(driver);
		String actHeader=hp.getHomeHeaderMsg().getText();
		boolean status=actHeader.contains("Home");
		soft.assertEquals(status, true);
		//Assert.assertEquals(status, true);
		hp.getContactLink().click();
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to Contact page");

		ContactPage cp = new ContactPage(driver);
		String actHeader1=cp.getContactHeaderMsg().getText();
		boolean status1=actHeader1.contains("Contacts");
		Assert.assertEquals(status1, true);
		cp.getCreateNewContact().click();
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to CreateContact page");

		// Enter all the details and create contact
		CreateContactPage ccp = new CreateContactPage(driver);
		String actHeader2=ccp.getCreateContactHeader().getText();
		boolean status2=actHeader2.contains("Creating New Contact");
		Assert.assertEquals(status2, true);
		ccp.getlastNameTF(lastName);
		ccp.getsaveBtn().click();
		UtilityClassObject.gettest().log(Status.INFO, "Create new Contact");

		// Verify Last name with expected result
		ContactDetailPage cdp = new ContactDetailPage(driver);
		String actlastname=cdp.getLastnameField().getText();
		boolean statusLstname=actlastname.contains(""+lastName);
		Assert.assertEquals(statusLstname, true);
		UtilityClassObject.gettest().log(Status.INFO, "verified new Contact");
		soft.assertAll();
	}

	@Test(groups = "regression test")
	public void CreateContactWithSupportDate() throws InterruptedException, Throwable {

		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		//WebDriverUtility wLib = new WebDriverUtility();

		// maximize and wait statement
		////wLib.waitForPageToLoad(driver);

		// Read TestScriptData from Excel file
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();
		UtilityClassObject.gettest().log(Status.INFO, "ReadData from Excel");

		// Navigate to Organization Module/Page and click on create org img
		HomePage hp = new HomePage(driver);
		String actHeader=hp.getHomeHeaderMsg().getText();
		boolean status=actHeader.contains("Home");
		Assert.assertEquals(status, true);
		hp.getContactLink().click();
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to contact page");

		ContactPage cp = new ContactPage(driver);
		String actHeader1=cp.getContactHeaderMsg().getText();
		boolean status1=actHeader1.contains("Contacts");
		Assert.assertEquals(status1, true);
		cp.getCreateNewContact().click();
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to create contact page");

		CreateContactPage ccp = new CreateContactPage(driver);
		String actHeader2=ccp.getCreateContactHeader().getText();
		boolean status2=actHeader2.contains("Creating New Contact");
		Assert.assertEquals(status2, true);
		// Set start date and end date with 30 days time period
		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);

		// Enter all the details and create contact with support date
		ccp.getlastNameTF(lastName);
		ccp.getStartDate().clear();
		ccp.getStartDate().sendKeys(startDate);
		ccp.getEndDate().clear();
		ccp.getEndDate().sendKeys(endDate);
		ccp.getsaveBtn().click();
		UtilityClassObject.gettest().log(Status.INFO, "Created new contact with support date");

		
		// Verify SupportDate with expected result
		ContactDetailPage cdp = new ContactDetailPage(driver);
		
		String actStartDate=cdp.getStartdate().getText();
		boolean statusSdate=actStartDate.contains(""+startDate);
		Assert.assertEquals(statusSdate, true);
		
		String actEnddate=cdp.getEnddate().getText();
		boolean statusEdate=actEnddate.contains(""+endDate);
		Assert.assertEquals(statusEdate, true);
		UtilityClassObject.gettest().log(Status.INFO, "Verified new contact with support date");


	}
	
	@Test(groups = "regression test")
	public void CreateContactWithOrgName() throws InterruptedException, Throwable {
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// maximize and wait statement
		//wLib.waitForPageToLoad(driver);

		// Read TestScriptData from Excel file
		String lastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();
		UtilityClassObject.gettest().log(Status.INFO, "ReadData from contact Excel");

		// Read TestScriptData from Excel file for org
		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		UtilityClassObject.gettest().log(Status.INFO, "ReadData from org Excel");

		// Navigate to Organization Module/Page and click on create org img
		HomePage hp = new HomePage(driver);
		String actHeaderhome=hp.getHomeHeaderMsg().getText();
		boolean status=actHeaderhome.contains("Home");
		Assert.assertEquals(status, true);
		hp.getOrgLink().click();
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to org page");

		OrganizationPage orgPage = new OrganizationPage(driver);
		String actHeader1=orgPage.getOrgHeaderMsg().getText();
		boolean status1=actHeader1.contains("Organization");
		Assert.assertEquals(status1, true);
		orgPage.getCreateNewOrg().click();
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to create org page");

//				// Navigate to Campaign Module
//				home.navigateToCampaignPage();

		// Enter all the details and create organization
		CreateOrganizationPage createorg = new CreateOrganizationPage(driver);
		String actHeader2=createorg.getCreateOrgHeader().getText();
		boolean status2=actHeader2.contains("Creating New Organization");
		Assert.assertEquals(status2, true);
		createorg.createOrg(orgName);
		UtilityClassObject.gettest().log(Status.INFO, "Created new org for contact");


		// Verify Header message with expected result
		OrganizationDetailPage OrgDP = new OrganizationDetailPage(driver);
		String actHeader3=OrgDP.getOrgDetailHeader().getText();
		boolean status3=actHeader3.contains("Organization Information");
		Assert.assertEquals(status3, true);
		UtilityClassObject.gettest().log(Status.INFO, "Verified new org for contact");



		// Navigate to contact Module/Page and click on create contact img
		hp.getContactLink().click();
		ContactPage cp = new ContactPage(driver);
		String actHeader4=cp.getContactHeaderMsg().getText();
		boolean status4=actHeader4.contains("Contacts");
		Assert.assertEquals(status4, true);
		cp.getCreateNewContact().click();
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to createcontact page");


		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getlastNameTF(lastName);
		ccp.getOrganizationplusbtn().click();
		wLib.switchToTabOnURL(driver, "module=Accounts");
		ccp.getOrgFrameSearchTFElement().sendKeys(orgName);
		ccp.getOrgFrameSearchbtnElement().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		wLib.switchToTabOnURL(driver, "module=Contacts");
		ccp.getsaveBtn().click();
		UtilityClassObject.gettest().log(Status.INFO, "created new contact");


		// Verify LastName and OrgName with expected result
		ContactDetailPage cdp = new ContactDetailPage(driver);
		
		String actOrgname=cdp.getOrgField().getText();
		boolean statusOrgname=actOrgname.contains(""+orgName);
		Assert.assertEquals(statusOrgname, true);
				
		String actLastName=cdp.getLastnameField().getText();
		boolean statusLstName=actLastName.contains(""+lastName);
		Assert.assertEquals(statusLstName, true);
		UtilityClassObject.gettest().log(Status.INFO, "verified new contact");


//		String headerInfo = cdp.getContactDetailHeader().getText();
//		if (headerInfo.contains(lastName)) {
//			System.out.println(lastName + " contactlastName verified==PASS");
//		} else {
//			System.out.println(lastName + " contactlastName not verified==FAIL");
//		}
//
//		String actOrgname = cdp.getOrgField().getText();
//		if (actOrgname.contains(orgName)) {
//			System.out.println(orgName + " orgName verified==PASS");
//		} else {
//			System.out.println(orgName + " orgName not verified==FAIL");
//		}
	
	}
	

}
