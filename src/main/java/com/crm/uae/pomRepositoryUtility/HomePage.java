package com.crm.uae.pomRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText= "Organizations")
	private WebElement organizationModule;
	
	@FindBy(linkText="Contacts")
	private WebElement contactModule;
	
	@FindBy(linkText="Opportunities")
	private WebElement oppurtunityModule;
	
	@FindBy(linkText="Products")
	private WebElement productModule;
	
	@FindBy(linkText="Documents")
	private WebElement documentModule;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseModule;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorModule;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignModule;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImage;
	
	@FindBy(linkText="Sign Out")
	private  WebElement logoutLink;
	
	//Purchase order page
		@FindBy(linkText="More")
		private WebElement goToMore;
		
		//Click on Purchase
		@FindBy(xpath="//a[text()='Purchase Order']")
		private WebElement goToPurchase;
//------------------------------------------------------------------------->
	public WebElement getGoToMore() {
			return goToMore;
		}

		public WebElement getGoToPurchase() {
			return goToPurchase;
		}

	public WebElement getAdministratorImage() {
		return administratorImage;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getOrganizationModule() {
		return organizationModule;
	}

	public WebElement getContactModule() {
		return contactModule;
	}

	public WebElement getOppurtunityModule() {
		return oppurtunityModule;
	}

	public WebElement getProductModule() {
		return productModule;
	}

	public WebElement getDocumentModule() {
		return documentModule;
	}

	public WebElement getPurchaseModule() {
		return purchaseModule;
	}

	public WebElement getVendorModule() {
		return vendorModule;
	}
	
	public WebElement getCampaignModule() {
		return campaignModule;
	}

	//------------------------------------------------------------->
	//Click on Organization home page
	public void organizationModules()
	{
		mouseOverAction(driver,organizationModule);
		organizationModule.click();
	}
	//mouse hover action for contact module
	public void contact()
	{
		mouseOverAction(driver, contactModule);
		contactModule.click();
	}
	//logout from homepage
	public void logout()
	{
		mouseOverAction(driver, administratorImage);
		logoutLink.click();
		
	}
//mouse hover more module
	public void moreLinkToPurchase()
	{
		mouseOverAction(driver, goToMore);
		purchaseModule.click();
	}
	public void moreLinkToCamapign()
	{
		mouseOverAction(driver, goToMore);
		campaignModule.click();
	}

	}


