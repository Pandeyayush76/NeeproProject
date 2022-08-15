package SamplePackageForTestNg;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.crm.uae.Neepro.GenericUtility.BaseClass;
@Listeners(com.crm.uae.Neepro.GenericUtility.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass
{
	@Test(groups={"smoke"})
	public void organizationCreatedWithMandatoryField()
	{
		//com.crm.uae.Neepro.GenericUtility.ListenerImplementation
		
		
		System.out.println("Mandatory field is created");
	}
	@Test(groups={"regression"})
	public void organizationCreatedWithoutMandatoryField()
	{
		System.out.println("Pop-up displayed");
	}
	
    @Test(groups={"smoke"})
	public void deleteOrganizationName()
	{
		System.out.println("Organization name deleted");
	}
}
