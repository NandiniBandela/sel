package contactTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.CreateOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;
import com.crmcast.crm.generic.BaseUtility.BaseClass;

public class DeleteOrg extends BaseClass{
	@Test
	public void deleteOrg() throws Throwable {
		
		// Creating objects of GenericUtilities
				ExcelUtility eLib = new ExcelUtility();
				JavaUtility jLib = new JavaUtility();
				WebDriverUtility wLib = new WebDriverUtility();

		// maximize and wait statement
		wLib.waitForPageToLoad(driver);

		// Read TestScriptData from Excel file
		String orgName = eLib.getDataFromExcel("org", 10, 2) + jLib.getRandomNumber();

		// Navigate to Organization Module/Page and click on create org img
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.getCreateNewOrg().click();

//			// Navigate to Campaign Module
//			home.navigateToCampaignPage();

		// Enter all the details and create organization
		CreateOrganizationPage createorg = new CreateOrganizationPage(driver);
		createorg.createOrg(orgName);

		// Going back to Org page
		hp.getOrgLink().click();

		// Search for Org
		orgPage.getSearchTF().sendKeys(orgName);
		wLib.select(orgPage.getSearchDD(), "Organization Name");
		orgPage.getSearchBtn().click();

		// In dynamic web table select and delete the org
		driver.findElement(By.xpath("//a[text()='" + orgName + "']/../../td[8]/a[text()='del']")).click();

		// Handle alert popup
		wLib.switchToAlertandAccept(driver);

	
	}

}
