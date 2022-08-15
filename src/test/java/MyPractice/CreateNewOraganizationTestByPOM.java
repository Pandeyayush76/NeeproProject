package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.uae.Neepro.GenericUtility.ExcelUtility;
import com.crm.uae.Neepro.GenericUtility.FileUtility;
import com.crm.uae.Neepro.GenericUtility.JavaUtility;
import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;
import com.crm.uae.pomRepositoryUtility.CreateNewOrganizationPage;
import com.crm.uae.pomRepositoryUtility.HomePage;
import com.crm.uae.pomRepositoryUtility.LoginPage;
import com.crm.uae.pomRepositoryUtility.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOraganizationTestByPOM {

	public static void main(String[] args) throws Throwable {
		//create all objects for generic library
	 FileUtility fLib=new FileUtility();
	 ExcelUtility eLib=new ExcelUtility();
	 WebDriverUtility wLib=new WebDriverUtility();
	 JavaUtility jLib=new JavaUtility();
	 
	 
	 
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver= new ChromeDriver();
	 driver.manage().window().maximize();
	 
	 //using implicit wait
	 wLib.implicitWait(driver);
	 
	 //call for login
	 String browser=fLib.getPropertyFromCommonData("browser");
	String url= fLib.getPropertyFromCommonData("url");
	String username=fLib.getPropertyFromCommonData("username");
	String password=fLib.getPropertyFromCommonData("password");
	driver.get(url);
	LoginPage lp=new LoginPage(driver);
	lp.logInVtiger(url, username, password);
	
	//going to organization module
	
	HomePage hp=new HomePage(driver);
hp.organizationModules();
	

	//click on create img on orgmodule
	
	OrganizationPage o= new OrganizationPage(driver);
	o.clickOnCreateOrgImage();

	//Filling Mandatory field
	CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);	
	String mandatorydetails=eLib.getDataFromExcelFile("Organization", 0, 1)+jLib.randomNumber();
	 cnp.createMandatoryField(mandatorydetails);
	 
	 //Create organization and then save..
	 cnp.saveButton();
	 
	 Thread.sleep(2000);

	 //come to home page
	 cnp.backToHome();
	 
	 //again go to organization
	 hp.organizationModules();
	 
	 //again click on create organization
	 o.clickOnCreateOrgImage();

	 //again fill mandatory field
	 String title = driver.getTitle();
	 cnp.createMandatoryField(mandatorydetails+jLib.randomNumber());
	 cnp.membersOf();
	 
	 //Switching window
	 cnp.enteringOrgdetails("Popup&popuptype",mandatorydetails,"Organization Name" );
	
	 //selecting from table of organization
	 o.selectFromOrgTable();
	 
	 //accept alert
	 o.acceptAlert(driver);
	// driver.switchTo().window(title);
	 //need to wait
	Thread.sleep(1000);
	// wLib.explicitWait(By.xpath("(//a[text()='Organizations'])[2]"), 10);
	 //String currentTitle=driver.getTitle();
	//wLib.waitForElementTillTitleSatisfies(driver,currentTitle);
//	wLib.waitForElementTillTitleSatisfies(driver, "DetailView&parenttab");
	
	 //Switching again window
     wLib.windowHandle(driver, "DetailView&parenttab=Marketing");
	 
	 driver.findElement(By.id("phone")).sendKeys("8058856");
	 //click on group radio button
	 cnp.getClickGroupRadioBtn().click();
	 
	 //click on dropDown and select any one
	 cnp.group("Team Selling");
	 
	 // write something in description
	 cnp.writeInDescription("I Love Lucknow");
	 
	 
	 //click on save button 
	 cnp.saveButton();
	
	 
	}

}
