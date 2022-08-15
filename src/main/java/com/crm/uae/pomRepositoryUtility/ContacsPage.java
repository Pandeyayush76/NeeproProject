package com.crm.uae.pomRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;

public class ContacsPage extends WebDriverUtility {
	WebDriver driver;
	public ContacsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Create Contact...")
     private WebElement clickContactModule;	
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createImage;
	
	@FindBys({@FindBy(xpath="//a[text()='First Name']"),@FindBy(xpath="//a[text()='Last Name']")})
	private WebElement oneConditionSatisfy;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchFor;
	
	@FindBy(xpath="(//select[@id='bas_searchfield'])[1]")
	private WebElement iNDropDown;
	
	@FindBy(xpath="(//input[@class='crmbutton small create'])[1]")
     private WebElement searchNow;
	
	@FindBy(xpath="//span[contains(text(),'No Contact Found !')]")
	private WebElement meassageShow;
	
	public WebElement getSearchNow() {
		return searchNow;
	}

	public WebElement getClickContactModule() {
		return clickContactModule;
	}

	public WebElement getCreateImage() {
		return createImage;
	}

	public WebElement getOneConditionSatisfy() {
		return oneConditionSatisfy;
	}

	public WebElement getSearchFor() {
		return searchFor;
	}

	public WebElement getiNDropDown() {
		return iNDropDown;
	}
	//Click on Contact + button
	public void createContactPage()
	{
		mouseOverAction(driver,createImage);
		createImage.click();
	}
	//working on Search in Contact Home page
	
	public void searchForCretdCnt(String Text,String visibletext)
	{
		searchFor.sendKeys(Text);	
		dropdownHandlingByText(iNDropDown, visibletext);
		searchNow.click();
		
	}
	

	public WebElement getMeassageShow() {
		return meassageShow;
	}
   
}
