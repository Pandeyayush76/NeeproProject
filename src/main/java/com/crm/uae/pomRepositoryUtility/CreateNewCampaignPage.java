package com.crm.uae.pomRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;

public class CreateNewCampaignPage extends WebDriverUtility {
	WebDriver driver;
	public CreateNewCampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//Create mandatory field
	@FindBy(name="campaignname")
	private WebElement createMandatoryField;
	
	//click radio button of user
	@FindBy(xpath="//input[@value='U']")
	private WebElement clickOnUserButton;
	
	//Click on radio button of group
	@FindBy(xpath="//input[@value='T']")
	private WebElement clickOnGroupButton;
	
	//Click on Group DropDown
	@FindBy(name="assigned_group_id")
	private WebElement drophandleByText;
	
	//Select date
	@FindBy(id="jscal_field_closingdate")
	private WebElement date;
	
	//Click on lookup image
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement clickOnLookUpImage;
	
	//new window will come searching in that
	@FindBy(id="search_txt")
	private WebElement searchinProductPage;
	
	//handle drop down in Text field
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement searchAndSelect;
	 
	//searching 
	@FindBy(xpath="//input[@type='button']")
	private WebElement searchNow;
	
	@FindBy(xpath =  "//span[contains(text(),'No Products Found')]")
	private WebElement visibleText;
	
	//click on save
	@FindBy(name = "button")
	private WebElement clickOnSave;
	
	public WebElement getCreateMandatoryField() {
		return createMandatoryField;
	}

	public WebElement getClickOnUserButton() {
		return clickOnUserButton;
	}

	public WebElement getClickOnLookUpImage() {
		return clickOnLookUpImage;
	}

	public WebElement getSearchinProductPage() {
		return searchinProductPage;
	}

	public WebElement getSearchAndSelect() {
		return searchAndSelect;
	}

	public WebElement getSearchNow() {
		return searchNow;
	}
	
	public WebElement getClickOnGroupButton() {
		return clickOnGroupButton;
	}

	public WebElement getDrophandleByText() {
		return drophandleByText;
	}

	public WebElement getClickOnSave() {
		return clickOnSave;
	}

	public WebElement getVisibleText() {
		return visibleText;
	}

	//Type on mandatory field
	public void fillingCampaignText(String Text)
	{
		createMandatoryField.sendKeys(Text);
	}
	
	//Clicking on group button radio
	public void groupButton()
	{
		clickOnGroupButton.click();
	}
	//Select from Group
	public void selectInGroup(String text)
	{
		dropdownHandlingByText(drophandleByText, text);
	}
	

	
	//saving the page
	public void savePage()
	{
		clickOnSave.click();
	}
	
}
