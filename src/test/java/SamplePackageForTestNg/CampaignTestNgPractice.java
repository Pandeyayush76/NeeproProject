package SamplePackageForTestNg;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.uae.Neepro.GenericUtility.BaseClass;
import com.crm.uae.Neepro.GenericUtility.ExcelUtility;
import com.crm.uae.Neepro.GenericUtility.FileUtility;
import com.crm.uae.Neepro.GenericUtility.JavaUtility;
import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;
import com.crm.uae.pomRepositoryUtility.CampaignPage;
import com.crm.uae.pomRepositoryUtility.CreateNewCampaignPage;
import com.crm.uae.pomRepositoryUtility.HomePage;
import com.crm.uae.pomRepositoryUtility.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignTestNgPractice extends BaseClass 
{

	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	@Test
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
	String dev=System.getProperty("Domain");
	System.out.println(dev);
	String pagal=System.getProperty("AishwaryaPagal");
	System.out.println(pagal);
	
}
}

	


