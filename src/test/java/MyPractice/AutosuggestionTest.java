package MyPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutosuggestionTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("salman");
	List<WebElement>autosuggestion=driver.findElements(By.xpath("//div[@class='OBMEnb']/..//ul//li[10]"));
	for(WebElement e:autosuggestion)
	{
		String all=e.getText();
		System.out.println(all);
		if(all.contains(" khan new movie"))
		{
			e.click();
			break;
		}
	}

	}

}
