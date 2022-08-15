package SamplePackageForTestNg;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.uae.Neepro.GenericUtility.BaseClass;
import com.crm.uae.Neepro.GenericUtility.ExcelUtility;
import com.crm.uae.Neepro.GenericUtility.FileUtility;
import com.crm.uae.Neepro.GenericUtility.JavaUtility;
import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;
import com.crm.uae.pomRepositoryUtility.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAndValidateCampaign extends BaseClass {
     @Test
	public void validateCampaign() throws Throwable
	{
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		int random=jLib.randomNumber();
		
	WebElement w=driver.findElement(By.linkText("More"));
	wLib.mouseOverAction(driver, w);
	
	driver.findElement(By.linkText("Campaigns")).click();
	driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	String name=eLib.getDataFromExcelFile("Campaign", 0,1)+random;
	
	
	driver.findElement(By.name("campaignname")).sendKeys(name);
	
	driver.findElement(By.name("button")).click();
	String text=driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
	System.out.println(text);
	
	String t=driver.findElement(By.className("dvHeaderText")).getText();
	System.out.println(t);
	Assert.assertEquals(name,text);
	/*
	if(t.contains(name))
	{
		System.out.println("Campaign created successfully");
	}
	else
	{
		System.out.println("Campaign not created successfully");
	}
	*/
	WebElement e=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wLib.mouseOverAction(driver, e);

	}

}

