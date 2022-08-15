package com.crm.uae.pomRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPurchaseOrderPage {
	WebDriver driver;
	
public CreateNewPurchaseOrderPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
//Filing Mandatory fields


}
      

