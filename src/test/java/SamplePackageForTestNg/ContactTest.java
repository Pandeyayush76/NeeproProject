package SamplePackageForTestNg;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.crm.uae.Neepro.GenericUtility.BaseClass;
@Listeners(com.crm.uae.Neepro.GenericUtility.ListenerImplementation.class)
public class ContactTest extends BaseClass
{
	@Test
	public void clickOnCreateImage()
	{
		System.out.println("Create image clicked");
	}
	@Test
	public void createContactWithLastName()
	{
		System.out.println("Mandatory field created");
	}
	@Test
	public void clickOnLookImage()
	{
		System.out.println("Look Up image clicked successfully");
	}
	@Test
	public void selectOrganizationInNewWindow()
	{
		System.out.println("New window handled successfully");
	}
	

}
