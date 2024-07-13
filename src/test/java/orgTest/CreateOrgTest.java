package orgTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.ObjectRepositoryUtility.CreateOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationDetailPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;
import com.crmcast.crm.generic.BaseUtility.BaseClass;
@Listeners(com.comcast.crm.listenerUtility.ListImpClass.class)
public class CreateOrgTest extends BaseClass {

	@Test(groups = "smoke test")
	public void CreateOrgTest1() throws InterruptedException, Throwable {

		// Creating objects of GenericUtilities
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// maximize and wait statement
		wLib.waitForPageToLoad(driver);

		// Read TestScriptData from Excel file
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		UtilityClassObject.gettest().log(Status.INFO, "ReadData from Excel");

		// Navigate to Organization Module/Page and click on create org img
		HomePage hp = new HomePage(driver);
		String actHeader = hp.getHomeHeaderMsg().getText();
		boolean status = actHeader.contains("Home");
		Assert.assertEquals(status, true);
		hp.getOrgLink().click();
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to Org Page");

		OrganizationPage orgPage = new OrganizationPage(driver);
		String actHeader1 = orgPage.getOrgHeaderMsg().getText();
		boolean status1 = actHeader1.contains("Organization");
		Assert.assertEquals(status1, true);
		orgPage.getCreateNewOrg().click();
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to Create new Org Page");

//		// Navigate to Campaign Module
//		home.navigateToCampaignPage();

		// Enter all the details and create organization
		CreateOrganizationPage createorg = new CreateOrganizationPage(driver);
		String actHeader2 = createorg.getCreateOrgHeader().getText();
		boolean status2 = actHeader2.contains("Creating New Organization");
		Assert.assertEquals(status2, true);
		createorg.createOrg(orgName);
		UtilityClassObject.gettest().log(Status.INFO, "Create new org");

		// Verify Header message with expected result
		OrganizationDetailPage OrgDP = new OrganizationDetailPage(driver);
		String actHeader3 = OrgDP.getOrgDetailHeader().getText();
		boolean status3 = actHeader3.contains(orgName + " - " + "Organization Information");
		Assert.assertEquals(status3, true, "Org name verified");
		UtilityClassObject.gettest().log(Status.INFO, orgName + "verified new org");

	}

	@Test(groups = "regression test")
	public void createOrgWithPhoneNumber() throws InterruptedException, Throwable {

		// Creating objects of GenericUtilities
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// maximize and wait statement
		wLib.waitForPageToLoad(driver);

		// Read TestScriptData from Excel file
		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneno = eLib.getDataFromExcel("org", 7, 3);
		UtilityClassObject.gettest().log(Status.INFO, "ReadData from Excel");

		// Navigate to Org Page and Create new org
		HomePage hp = new HomePage(driver);
		String actHeader = hp.getHomeHeaderMsg().getText();
		boolean status = actHeader.contains("Home");
		Assert.assertEquals(status, true);
		hp.getOrgLink().click();
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to Org Page");

		OrganizationPage orgPage = new OrganizationPage(driver);
		String actHeader1 = orgPage.getOrgHeaderMsg().getText();
		boolean status1 = actHeader1.contains("Organization");
		Assert.assertEquals(status1, true);
		orgPage.getCreateNewOrg().click();
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to Create new Org Page");

		// Enter all the details and create organization
		CreateOrganizationPage createorg = new CreateOrganizationPage(driver);
		String actHeader2 = createorg.getCreateOrgHeader().getText();
		boolean status2 = actHeader2.contains("Creating New Organization");
		Assert.assertEquals(status2, true);
		createorg.createOrgWithPhn(orgName, phoneno);
		UtilityClassObject.gettest().log(Status.INFO, orgName + "Created new org with phno");

		// Verify Header message with expected result
		OrganizationDetailPage OrgDP = new OrganizationDetailPage(driver);
		String actHeader3 = OrgDP.getOrgDetailHeader().getText();
		boolean status3 = actHeader3.contains("Organization Information");
		Assert.assertEquals(status3, true);

		// Verify Phone number with expected result
		String actphnno = OrgDP.getPhnoField().getText();
		boolean statuspn = actphnno.contains("" + phoneno + "");
		Assert.assertEquals(statuspn, true);
		UtilityClassObject.gettest().log(Status.INFO, orgName + "verified new org with phno");

	}

	@Test(groups = "regression test")
	public void CreateOrgWithIndustryAndType() throws InterruptedException, Throwable {
		// Creating objects of GenericUtilities
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// maximize and wait statement
		wLib.waitForPageToLoad(driver);

		// Read TestScriptData from Excel file
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);
		UtilityClassObject.gettest().log(Status.INFO, "ReadData from Excel");

		// Navigate to Org Page and Create new org
		HomePage hp = new HomePage(driver);
		String actHeader = hp.getHomeHeaderMsg().getText();
		boolean status = actHeader.contains("Home");
		Assert.assertEquals(status, true);
		hp.getOrgLink().click();
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to Org Page");

		OrganizationPage orgPage = new OrganizationPage(driver);
		String actHeader1 = orgPage.getOrgHeaderMsg().getText();
		boolean status1 = actHeader1.contains("Organization");
		Assert.assertEquals(status1, true);
		orgPage.getCreateNewOrg().click();
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to Create new Org Page");

		// Enter all the details and create organization
		CreateOrganizationPage createorg = new CreateOrganizationPage(driver);
		String actHeader2 = createorg.getCreateOrgHeader().getText();
		boolean status2 = actHeader2.contains("Creating New Organization");
		Assert.assertEquals(status2, true);
		createorg.createOrg(orgName, industry, type);
		UtilityClassObject.gettest().log(Status.INFO, orgName + "Created new org with Industry and type");


		// Verify Industry with expected result
		OrganizationDetailPage OrgDP = new OrganizationDetailPage(driver);

		String actindustry = OrgDP.getIndutryField().getText();
		boolean statusind = actindustry.contains("" + industry + "");
		Assert.assertEquals(statusind, true);

		// Verify IndustryType with expected result

		String acttype = OrgDP.getTypeField().getText();
		boolean statustype = acttype.contains("" + type + "");
		Assert.assertEquals(statustype, true);
		UtilityClassObject.gettest().log(Status.INFO, orgName + "verified new org with Industry and type");


	}

}
