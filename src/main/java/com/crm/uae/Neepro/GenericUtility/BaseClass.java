package com.crm.uae.Neepro.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.uae.pomRepositoryUtility.HomePage;
import com.crm.uae.pomRepositoryUtility.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//create object for all generic utilities
	
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public DataBaseUtility dLib=new DataBaseUtility();
	public WebDriverUtility wLib=new WebDriverUtility();

	
	//make WebDriver as public and make that as global also.
	public WebDriver driver;
	public static WebDriver listenerdriver;
	@BeforeSuite(alwaysRun=true)
	public void configBS()
	{
	System.out.println("Connect to DATA BASE");
		
	}
	//launching the browser
	//@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void configBC()
	{
		System.out.println("Launch the browser");
/*
	if(browser.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
	}
	else if(browser.equals("edge"))
	{
		WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();	
	}
	*/
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		listenerdriver=driver;
		 driver.manage().window().maximize();
		wLib.implicitWait(driver);
	}
	//login the application
@BeforeMethod(alwaysRun=true)
	public void configBM() throws Throwable
	{
		System.out.println("Login the application");
		String url=fLib.getPropertyFromCommonData("url");
		String username=fLib.getPropertyFromCommonData("username");
		String password=fLib.getPropertyFromCommonData("password");
		LoginPage lp=new LoginPage(driver);
		lp.logInVtiger(url,username, password);
		
		
	}
          //logout the application
@AfterMethod(alwaysRun=true)
public void configAM() {
	
	 HomePage hp=new HomePage(driver);
	hp.logout();
}
        //logout from browser
@AfterClass(alwaysRun=true)
       public void configAC()
       {
    	   driver.close();
       }
       @AfterSuite(alwaysRun=true)
       public void configAS()
       {
    	   System.out.println("Close data base connection");
       }

}
