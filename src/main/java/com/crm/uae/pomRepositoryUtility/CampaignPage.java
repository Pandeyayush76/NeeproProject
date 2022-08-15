package com.crm.uae.pomRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;

public class CampaignPage extends WebDriverUtility {
	WebDriver driver;
	public CampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Click on CreateCampaign
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement clickOnCreateCampaign;
	
	public WebElement getClickOnCreateCampaign() {
		return clickOnCreateCampaign;
	}
	
//--------------------------------------->
	//click on create campaign +
	public void createCampaign()
	{
		clickOnCreateCampaign.click();
	}


}
