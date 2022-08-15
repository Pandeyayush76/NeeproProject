package com.crm.uae.pomRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.uae.Neepro.GenericUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name="user_name") //we will call the attribute name=attribute value
	private WebElement user;   //In this user is working as we by own created.
	
	@FindBy(name="user_password")   //we will call the attribute name=attribute value
	private WebElement pass; //In this pass is working as me.
	@FindBy(id="submitButton")//we will call the attribute name=attribute value
	private WebElement logindone;  //In this logindone is working as me.
	
	//--->Then call the private method with the help of getter-->go to source -->click on generate getter.
	
	public WebElement getUser() {
		return user;
	}
	public WebElement getPass() {
		return pass;
	}
	public WebElement getLogindone() {
		return logindone;
	}

	   public void logInVtiger(String url,String username,String password)
	   // public void logInVtiger(String username,String password)
	    {
	    	driver.get(url);
	    	user.sendKeys(username);
	    	pass.sendKeys(password);
	    	logindone.click();
	    	
	    	
	    }
	
	
}
