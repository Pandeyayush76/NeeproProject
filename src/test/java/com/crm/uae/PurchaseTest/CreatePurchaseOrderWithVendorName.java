package com.crm.uae.PurchaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

import com.crm.uae.Neepro.GenericUtility.ExcelUtility;
import com.crm.uae.Neepro.GenericUtility.FileUtility;
import com.crm.uae.Neepro.GenericUtility.JavaUtility;
import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreatePurchaseOrderWithVendorName {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	wLib.implicitWait(driver);
	
	int num=jLib.randomNumber();
	String browser=fLib.getPropertyFromCommonData("browser");
	String url=fLib.getPropertyFromCommonData("url");
	String username=fLib.getPropertyFromCommonData("username");
	String password=fLib.getPropertyFromCommonData("password");
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	WebElement more=driver.findElement(By.linkText("More"));
	wLib.mouseOverAction(driver, more);
	
	driver.findElement(By.linkText("Vendors")).click();
	driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
	String vname=eLib.getDataFromExcelFile("Vendor",0,1);
	
	driver.findElement(By.name("vendorname")).sendKeys(vname+num);
	driver.findElement(By.name("button")).click();
	String text=driver.findElement(By.className("lvtHeaderText")).getText();
	if(text.contains(vname))
	{
		System.out.println("Vendor created successfully");
	}
	else
	{
		System.out.println("Vendor not created successfully");
	}

	WebElement more1=driver.findElement(By.linkText("More"));
	wLib.mouseOverAction(driver, more1);

driver.findElement(By.name("Purchase Order")).click();
driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
String pname=eLib.getDataFromExcelFile("PurchaseOrder",0,1);

driver.findElement(By.name("subject")).sendKeys(pname+num);
String currenttitle=driver.getTitle();
System.out.println(currenttitle);
driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
Thread.sleep(20);
    wLib.windowHandle(driver, "Vendors&action");
Thread.sleep(20);

driver.findElement(By.id("search_txt")).sendKeys(vname+num);
driver.findElement(By.name("search")).click();
driver.findElement(By.xpath("//a[contains(text(),'TataMotors')]")).click();
wLib.windowHandle(driver, "Administrator-");
driver.findElement(By.xpath("//input[@name='contact_name']/..//img")).click();

wLib.windowHandle(driver, "Contacts&action");

System.out.println(driver.getTitle());

String msg="No Contacts Found !";
System.out.println(msg);
WebElement amsg=driver.findElement(By.xpath("//span[text()='No Contacts Found !']"));
  String alertmsg= amsg.getText();
if(msg.contains(alertmsg))
{
	System.out.println("Contact not created");
}
driver.close();

wLib.windowHandle(driver, "Administrator-");
System.out.println(driver.getTitle());
WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
wLib.mouseOverAction(driver, element);
driver.findElement(By.linkText("Sign Out")).click();
driver.close();
}
}
