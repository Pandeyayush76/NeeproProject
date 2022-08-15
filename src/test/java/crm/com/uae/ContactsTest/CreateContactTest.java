package crm.com.uae.ContactsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Random r=new Random();
		int num=r.nextInt(1000);
		FileInputStream fis=new FileInputStream("./Data/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser=p.getProperty("browser");
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		FileInputStream fis1=new FileInputStream("./Data/Practice.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sh=book.getSheet("TestCase");
		String lastname=sh.getRow(3).getCell(1).getStringCellValue();
		driver.findElement(By.name("lastname")).sendKeys(lastname+num);
		driver.findElement(By.name("button")).click();
		String t=driver.findElement(By.xpath("//span[contains(text(),'Raman')]")).getText();
		System.out.println(t);
		if(t.contains(lastname))
		{
			System.out.println("Contact created successfully");
		}
		else
		{
			System.out.println("Contact not created successfully");
		}
		WebElement w=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(w).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();

	}

}
