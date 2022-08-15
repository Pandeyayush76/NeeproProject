package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.uae.Neepro.GenericUtility.BaseClass;
import com.crm.uae.Neepro.GenericUtility.ExcelUtility;
import com.crm.uae.Neepro.GenericUtility.FileUtility;
import com.crm.uae.Neepro.GenericUtility.JavaUtility;
import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;
import com.crm.uae.pomRepositoryUtility.ContacsPage;
import com.crm.uae.pomRepositoryUtility.CreateContactPage;
import com.crm.uae.pomRepositoryUtility.HomePage;
import com.crm.uae.pomRepositoryUtility.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateandDeleteContactByPOM extends BaseClass {
	
	

	@Test(invocationCount = 2)
	public void createAndDeleteContact() throws Throwable
	{
		
		
		HomePage hp=new HomePage(driver);
		hp.contact();
		ContacsPage c=new ContacsPage(driver);
		c.createContactPage();
		CreateContactPage ccp=new CreateContactPage(driver);
		String lastname=eLib.getDataFromExcelFile("TestCase",1,1)+jLib.randomNumber();
		ccp.fillingMandatoryField(lastname) ;
		ccp.clickSave();
	/*	ccp.deleteCreatedContact();
		wLib.acceptAlert(driver);
		c.searchForCretdCnt(lastname, "Last Name");
		String t=driver.findElement(By.xpath("//span[contains(text(),'No Contact Found !')]")).getText();
		String confmMsg = c.getMeassageShow().getText();

		String msg="No Contact Found !";
		if(confmMsg.contains(msg))
		{
			System.out.println("Contact deleted");
		}
		else
		{
			System.out.println("Contacts not deleted");
		}
		
		hp.logout();
		/*
		WebElement w1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseOverAction(driver, w1);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		*/
		//driver.close();

	}
	


	}
//
//<properties>
//    <maven.compiler.source>1.8</maven.compiler.source>
//    <maven.compiler.target>1.8</maven.compiler.target>
//  </properties>
//
//
//<build>
//<plugins>
//      <plugin>
//        <groupId>org.apache.maven.plugins</groupId>
//        <artifactId>maven-compiler-plugin</artifactId>
//        <version>3.10.1</version>
//        <configuration>
//          <source>1.8</source>
//          <target>1.8</target>
//        </configuration>
//      </plugin>
//    </plugins>
//</build>


