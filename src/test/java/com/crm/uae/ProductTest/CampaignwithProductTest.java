package com.crm.uae.ProductTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.uae.Neepro.GenericUtility.ExcelUtility;
import com.crm.uae.Neepro.GenericUtility.FileUtility;
import com.crm.uae.Neepro.GenericUtility.JavaUtility;
import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignwithProductTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		wLib.implicitWait(driver);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		int random=jLib.randomNumber();
		/*
		Random r=new Random();
		int q=r.nextInt(1000);
		FileInputStream fis=new FileInputStream("./Data/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		*/
		String browser=fLib.getPropertyFromCommonData("browser");
		String url=fLib.getPropertyFromCommonData("url");
		String username=fLib.getPropertyFromCommonData("username");
		String password=fLib.getPropertyFromCommonData("password");
		/*
		String browser=p.getProperty("browser");
		String url=p.getProperty("url");
	String u=p.getProperty("username");
	String pass=p.getProperty("password");
	*/
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	String pname=eLib.getDataFromExcelFile("Product",0,1);
	/*
	FileInputStream fis1=new FileInputStream("./Data/Practice.xlsx");
	Workbook book=WorkbookFactory.create(fis1);
	Sheet sh=book.getSheet("Product");
	String pname=sh.getRow(0).getCell(1).getStringCellValue();
	*/
	driver.findElement(By.name("productname")).sendKeys(pname+random);
	System.out.println(pname+random);
	driver.findElement(By.name("button")).click();
	WebElement w=driver.findElement(By.linkText("More"));
	wLib.mouseOverAction(driver, w);
	/*
	Actions act = new Actions(driver);
	act.moveToElement(w).perform();
	*/
	driver.findElement(By.linkText("Campaigns")).click();
	driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	String cname=eLib.getDataFromExcelFile("Campaign",0,1);
	/*
	FileInputStream f=new FileInputStream("./Data/Practice.xlsx");
	Workbook b=WorkbookFactory.create(f);
	Sheet h=b.getSheet("Campaign");
	String c=h.getRow(0).getCell(1).getStringCellValue();
	*/
	driver.findElement(By.name("campaignname")).sendKeys(cname+random);
	String currenttitle=driver.getTitle();
	System.out.println(currenttitle);
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	
//	String parentId=driver.getWindowHandle();
	//eLib.writeDataInExcelSheet("Campaign", 4, 1, currenttitle);
	//String parentWindowTitle=eLib.getDataFromExcelFile("Campaign", 4, 1);
	//driver.findElement(By.name("button")).click();
	
	wLib.windowHandle(driver, currenttitle);//it will switch from parent window to child window.
	
	/*
	String parent=driver.getWindowHandle();
	Set<String>child=driver.getWindowHandles();
	Iterator<String> itr=child.iterator();
	while(itr.hasNext()) {
		String c1=itr.next();
		driver.switchTo().window(c1);
		String title=driver.getTitle();
		if(child.contains(title))
		break;
		}
		*/
	String childtitle=driver.getTitle();
	System.out.println(childtitle);
	driver.findElement(By.name("search_text")).sendKeys(pname+random);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[@class='listFormHeaderLinks'][1]/./../../..//tr[2]//a[contains(text(),'Experience')]")).click();
	wLib.windowHandle(driver, childtitle);
	driver.findElement(By.name("button")).click();
WebElement m=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wLib.mouseOverAction(driver, m);
	driver.findElement(By.linkText("Sign Out")).click();
	driver.close();
	}

}
