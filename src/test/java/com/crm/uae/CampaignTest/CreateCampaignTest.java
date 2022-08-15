package com.crm.uae.CampaignTest;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.uae.Neepro.GenericUtility.BaseClass;
import com.crm.uae.Neepro.GenericUtility.ExcelUtility;
import com.crm.uae.Neepro.GenericUtility.FileUtility;
import com.crm.uae.Neepro.GenericUtility.JavaUtility;
import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;
import com.crm.uae.pomRepositoryUtility.HomePage;
import com.crm.uae.pomRepositoryUtility.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest extends BaseClass {
@Test

	public void SimpleCampaign() throws Throwable
	{
	String Domain = System.getProperty("DOMAIN");
	System.out.println("Domain"+ Domain);
	String Application = System.getProperty("APP");
	System.out.println("Application"+Application);
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		wLib.implicitWait(driver);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		int random=jLib.randomNumber();
		//Random r=new Random();
		//int a=r.nextInt(1000);
		
	
	
//	driver.findElement(By.name("user_name")).sendKeys(username);
//	driver.findElement(By.name("user_password")).sendKeys(password);
//	driver.findElement(By.id("submitButton")).click();
	WebElement w=driver.findElement(By.linkText("More"));
	wLib.mouseOverAction( driver, w);
	/*
	Actions act=new Actions(driver);
	act.moveToElement(w).perform();
	*/
	driver.findElement(By.linkText("Campaigns")).click();
	driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	String name=eLib.getDataFromExcelFile("Campaign", 0,1);
	/*
	FileInputStream fis1=new FileInputStream("./Data/Practice.xlsx");
	Workbook book=WorkbookFactory.create(fis1);
	Sheet sh=book.getSheet("Campaign");
	String name=sh.getRow(0).getCell(1).getStringCellValue();
	*/
	driver.findElement(By.name("campaignname")).sendKeys(name+random);
	driver.findElement(By.name("button")).click();
	String t=driver.findElement(By.className("dvHeaderText")).getText();
	System.out.println(t);
	if(t.contains(name))
	{
		System.out.println("Campaign created successfully");
	}
	else
	{
		System.out.println("Campaign not created successfully");
	}
	WebElement e=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wLib.mouseOverAction(driver, e);
	/*
	act.moveToElement(e).perform();
	*/
	driver.findElement(By.linkText("Sign Out")).click();
	//driver.close();
	
	}

}
