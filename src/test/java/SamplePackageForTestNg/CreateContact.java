package SamplePackageForTestNg;

	import org.testng.annotations.Test;
	import org.testng.annotations.Test;
	import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
	import org.testng.annotations.Test;
	import org.testng.annotations.Test;
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
	@Listeners(com.crm.uae.Neepro.GenericUtility.ListenerImplementation.class)
	public class CreateContact extends BaseClass {

		@Test(groups="regression")
		public void createContactTest() throws Throwable 
		{
		
			FileUtility fLib=new FileUtility();
			ExcelUtility eLib=new ExcelUtility();
			WebDriverUtility wLib=new WebDriverUtility();
			JavaUtility jLib=new JavaUtility();
			
		
			HomePage hp=new HomePage(driver);
			hp.contact();
			ContacsPage cp=new ContacsPage(driver);
			cp.createContactPage();
			String lastname=eLib.getDataFromExcelFile("Contacts", 0, 1)+jLib.randomNumber();
			System.out.println(lastname);
			CreateContactPage ccp=new CreateContactPage(driver);
			ccp.fillingMandatoryField(lastname);
			ccp.clickSave();
			
			
		}
		


		}





