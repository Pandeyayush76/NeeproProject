package MyPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyData {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
	FileInputStream fis=new FileInputStream("./Data/commondata.properties");
	Properties p=new Properties();
	p.load(fis);
	String browser=p.getProperty("browser");
	String url=p.getProperty("url");
	String username=p.getProperty("username");
	String password=p.getProperty("password");
	WebDriver driver=new ChromeDriver();
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();

	}

}
