package com.crm.uae.pomRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgName;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement memberOf;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchinOrg;
	
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement inOrganization;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchnowclick;
	
	
	@FindBy(name="button")
	private WebElement save;
	
	@FindBy(linkText="Creating New Organization")
	private WebElement text;
	
	public WebElement getText() {
		return text;
	}


	@FindBy(xpath="//td[@style='width:50px']")
	private WebElement homePage;


	@FindBy(xpath="//input[@value='U']")
	private WebElement clickUserRadioBtn;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement clickGroupRadioBtn;
	
	@FindBy(name="assigned_user_id")
	private WebElement assignedTo;
	
	@FindBy(name="assigned_group_id")
	private WebElement assignedGroupTextBox;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement description;
	
	public WebElement getDescription() {
		return description;
	}

	public WebElement getAssignedGroupTextBox() {
		return assignedGroupTextBox;
	}

	public WebElement getClickUserRadioBtn() {
		return clickUserRadioBtn;
	}

	public WebElement getClickGroupRadioBtn() {
		return clickGroupRadioBtn;
	}

	public WebElement getAssignedTo() {
		return assignedTo;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getMemberOf() {
		return memberOf;
	}

	public WebElement getSave() {
		return save;
	}
	
	
	public WebElement getSearchinOrg() {
		return searchinOrg;
	}

	public WebElement getInOrganization() {
		return inOrganization;
	}

	public WebElement getSearchnowclick() {
		return searchnowclick;
	}

	public WebElement getHomePage() {
		return homePage;
	}

	// organization created 
	public void createMandatoryField(String value)
	{
		orgName.sendKeys(value);;
		
	}
	//member of created
	
	public void membersOf()
	{
		memberOf.click();
	
	}
	
	//window handling in member of
	
public void enteringOrgdetails(String title, String text,String txtvalue)
{
	windowHandle(driver, title);
	implicitWait(driver);
	searchinOrg.sendKeys(text);
	dropdownHandlingByText(inOrganization, txtvalue);
	searchnowclick.click();
}
/*
//text contains for save button
public void handlingExplicitWaitByElement()
{
	explicitWait(driver, text);
}
*/
//DropDown handle
public void user(String txtvalue)
{
	dropdownHandlingByText(assignedTo, txtvalue);
}
public void group(String textValue)
{
	dropdownHandlingByText(assignedGroupTextBox, textValue);
}
//save button
public void saveButton()
{
	save.click();
}
//back to home page
public void backToHome()
{
	homePage.click();
}
public void writeInDescription(String Text)
{
	description.sendKeys(Text);
}

}
