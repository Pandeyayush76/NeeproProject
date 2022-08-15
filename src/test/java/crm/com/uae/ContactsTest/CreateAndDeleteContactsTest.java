package crm.com.uae.ContactsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.uae.Neepro.GenericUtility.ExcelUtility;
import com.crm.uae.Neepro.GenericUtility.FileUtility;
import com.crm.uae.Neepro.GenericUtility.JavaUtility;
import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAndDeleteContactsTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		wLib.implicitWait(driver);
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		int num=jLib.randomNumber();
		/*
		Random r=new Random();
		int num=r.nextInt(1000);
		*/
		String browser=fLib.getPropertyFromCommonData("browser");
		String url=fLib.getPropertyFromCommonData("url");
		String username=fLib.getPropertyFromCommonData("username");
		String password=fLib.getPropertyFromCommonData("password");
		/*
		FileInputStream fis=new FileInputStream("./Data/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser=p.getProperty("browser");
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		*/
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		String lastname=eLib.getDataFromExcelFile("TestCase",1,1);
		/*
		FileInputStream fis1=new FileInputStream("./Data/Practice.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sh=book.getSheet("TestCase");
		String lastname=sh.getRow(3).getCell(1).getStringCellValue();
		*/
		driver.findElement(By.name("lastname")).sendKeys(lastname+num);
		driver.findElement(By.name("button")).click();
		driver.findElement(By.name("Delete")).click();
		wLib.acceptAlert(driver);
		/*
		Alert alt=driver.switchTo().alert();
		alt.accept();
		*/
		driver.findElement(By.name("search_text")).sendKeys(lastname+num);
		WebElement w=driver.findElement(By.name("search_field"));
		
		wLib.dropdownHandlingByText(w,"Last Name");
		/*
		Select s=new Select(w);
		s.selectByVisibleText("Last Name");
		*/
		driver.findElement(By.name("submit")).click();
		String t=driver.findElement(By.xpath("//span[contains(text(),'No Contact Found !')]")).getText();
		System.out.println(t);
		String msg="No Contact Found !";
		if(t.contains(msg))
		{
			System.out.println("Contact deleted");
		}
		else
		{
			System.out.println("Contacts not deleted");
		}
		WebElement w1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseOverAction(driver, w1);
		/*
		Actions act=new Actions(driver);
		act.moveToElement(w1).perform();
		*/
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();

	}

}
