package practice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HotstarDynamic {

	public static void main(String[] args) throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.hotstar.com/in");
	List<WebElement>element=driver.findElements(By.xpath("//a[text()='Latest & Trending']/../../../div[2]/div/div/div/div[1]/div/div/div/article/a"));
/*
	Iterator<WebElement>itr=element.iterator();
while(itr.hasNext())
{
	Thread.sleep(1000);
	String movie=itr.next().getAttribute("to").split("/")[3];
	
	System.out.println(movie);
}
*/
	for(int i=0;i<element.size();i++)
	{
		Thread.sleep(1000);
		String movie=element.get(i).getAttribute("to").split("/")[3];
		System.out.println(movie);
	}
	/*
for(WebElement i:element)
{
	Thread.sleep(1000);
	String movie=i.getAttribute("to").split("/")[3];
	System.out.println(movie);
}
*/
System.out.println(element.size());
	}

}
