package com.crm.uae.pomRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;

/*
 * @author-Ayush
 */
public class OrganizationPage extends WebDriverUtility {
	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
     private WebElement createNewOrganizationimage;
	
	@FindBy(xpath="//a[@class='listFormHeaderLinks']/../../..//tr[2]/td/a")
	private WebElement organPageSearching;

	public WebElement getCreateNewOrganizationimage() {
		return createNewOrganizationimage;
	}
	
	public WebElement getOrganPageSearching() {
		return organPageSearching;
	}

	public void clickOnCreateOrgImage()
	{
		createNewOrganizationimage.click();
	}
	
	//searching on organization page for rows
	public void selectFromOrgTable()
	{
		organPageSearching.click();
	}
}
