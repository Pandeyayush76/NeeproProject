package com.crm.uae.pomRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	WebDriver driver;
	public CreateContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement mandatoryField;
		
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']/./../..//td[2]/img")
	private WebElement orgName;
	
	@FindBy(xpath="//input[@name='button']/../../../../tr[1]//div/input[@class='crmButton small save']")
	private WebElement saveButton;
	
   @FindBy(name="Delete")
   private WebElement deletingContact;
	

	public WebElement getDeletingContact() {
	return deletingContact;
}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getMandatoryField() {
		return mandatoryField;
	}

	public WebElement getOrgName() {
		return orgName;
	}
	
	//filling mandatory field in contact
	public void fillingMandatoryField(String lastname)
	{
		mandatoryField.sendKeys(lastname);
	}
//click on save button	
  public void clickSave()
  {
	  saveButton.click();
  }
  
  //delete the contact
  public void deleteCreatedContact()
  {
	  deletingContact.click();  
  }
}
