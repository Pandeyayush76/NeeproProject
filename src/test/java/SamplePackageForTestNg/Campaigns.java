package SamplePackageForTestNg;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.uae.Neepro.GenericUtility.BaseClass;
import com.crm.uae.pomRepositoryUtility.CampaignPage;
import com.crm.uae.pomRepositoryUtility.CreateNewCampaignPage;
import com.crm.uae.pomRepositoryUtility.HomePage;
@Listeners(com.crm.uae.Neepro.GenericUtility.ListenerImplementation.class)
public class Campaigns extends BaseClass {
	@Test(dependsOnMethods = "createCampaign" )
	public void createCampaignWithProduct() throws Throwable
	{
	
		HomePage hp=new HomePage(driver);
		hp.moreLinkToCamapign();
		
		//Click on Campaign create img
		CampaignPage cp=new CampaignPage(driver);
		cp.createCampaign();
		//create mandatory field
		
		CreateNewCampaignPage cnp=new CreateNewCampaignPage(driver);
	String name=	eLib.getDataFromExcelFile("Campaign", 0, 1)+jLib.randomNumber();
		cnp.fillingCampaignText(name);
		
		//assigned To group
		cnp.groupButton();
		
		//choose from dropdown
		cnp.selectInGroup("Team Selling");
		String title = driver.getTitle();
		
		//click on look up image
		cnp.getClickOnLookUpImage().click();
wLib.windowHandle(driver, "Products&");	
		
	String msg="No Products Found";
	String expected=cnp.getVisibleText().getText();
	Assert.fail();
	//Assert.assertTrue(expected.contains(msg));
	
	System.out.println("Assertion passed");
	//
	driver.close();
	System.out.println("hii");
	
	//back to parent window
    wLib.windowHandle(driver, "Campaigns&action");
	
	//saving the details
	cnp.getClickOnSave().click();
	
	}

	@Test(groups="regression")
	public void createCampaign() throws Throwable
	{
	
	//go to home and click on Campaign module
	HomePage hp=new HomePage(driver);
	
	hp.moreLinkToCamapign();
	
	//click on create campaign +
	CampaignPage cp=new CampaignPage(driver);
	cp.createCampaign();
	
	//Taking data from Excel file
	String camapignName=eLib.getDataFromExcelFile("Campaign", 0, 0)+jLib.randomNumber();
	
	//Campaign name creating
	CreateNewCampaignPage cnp=new CreateNewCampaignPage(driver);
	cnp.fillingCampaignText(camapignName);
	
	//clicking on Group in Assigned to
	cnp.groupButton();
	
	//select through dropdown in textfield
	cnp.selectInGroup("Support Group");

	//saving page
	cnp.savePage();
	

}
}


