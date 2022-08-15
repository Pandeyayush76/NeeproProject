package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.uae.Neepro.GenericUtility.ExcelUtility;
import com.crm.uae.Neepro.GenericUtility.FileUtility;
import com.crm.uae.Neepro.GenericUtility.JavaUtility;
import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;
import com.crm.uae.pomRepositoryUtility.CampaignPage;
import com.crm.uae.pomRepositoryUtility.CreateNewCampaignPage;
import com.crm.uae.pomRepositoryUtility.HomePage;
import com.crm.uae.pomRepositoryUtility.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignByPOM {
	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Login to app
		String url=fLib.getPropertyFromCommonData("url");
		String username=fLib.getPropertyFromCommonData("username");
		String password=fLib.getPropertyFromCommonData("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.logInVtiger(url, username, password);
		
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
		//logout
		hp.logout();
		
		
		
	}
}
