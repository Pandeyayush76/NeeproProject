package com.crm.uae.pomRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;

public class PurchaseOrderPage extends WebDriverUtility {
	WebDriver driver;
	public PurchaseOrderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Purchase order page
	@FindBy(xpath="//img[@title='Create Purchase Order...']")
	private WebElement createPurchaseOrder;
	
	public WebElement getCreatePurchaseOrder() {
		return createPurchaseOrder;
	}
	
	
}
