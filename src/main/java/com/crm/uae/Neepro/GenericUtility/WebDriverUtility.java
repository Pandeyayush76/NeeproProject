package com.crm.uae.Neepro.GenericUtility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * It is present inside Generic utility Libraries
	 *  WebDriver utility  contains all the reusable actions..
 * @Author-Ayush.
 */


public class WebDriverUtility   {
WebDriver driver;
public void implicitWait(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
	/*
	 *  --->Inside WebDriver Utility i have created Implicit Wait method which is used to handle the Synchronization.
	 * --> For implicitWait it will check the conditions upto the particular unit time.
	 * --->It always wait for element in DOM document and release the control if element is available.
	 * parameter-->WebDriver driver
	 */
	
	/*
	 * --->it is an Explicitly wait ,it will check upto the condition that we pass is satisfied or not.
	 * @parameter-->WebDriver driver
	 * @parameter-->WebElement element
	 */
	/*
	public void explicitWait(By locator,long timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	*/
	/*
	 * This method is used to handle the synchronization issue by using explicit wait and it will for the title of web page is matching.
	 */
	public void waitForElementTillTitleSatisfies(WebDriver driver,String actualTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(actualTitle));
	}
	/*
	 * -->It is used to switch any window based on title.
	 * @Parameter-->WebDriver Driver
	 * @parameter-->parentWindowTitle
	 */
	public void windowHandle(WebDriver driver,String parentWindowTitle)
	{
		Set<String>s=driver.getWindowHandles();
		Iterator<String> itr= s.iterator();
		while(itr.hasNext())
		{
			String winId=itr.next();
			driver.switchTo().window(winId);
			String title=driver.getTitle();
			if(title.contains(parentWindowTitle));
			{
			continue;
			}
			
		}
		
		
	}
	
	/*--->It is used to handle the alert pop up and also accept.
	 * @Parameter-->driver
	 * @Parameter-->expectedMsg
	 */
	public void acceptAlert(WebDriver driver)
	{
		 Alert alt = driver.switchTo().alert();
		
		 alt.accept();
	}
	/*
	 * -->It is used to handle the alert pop up and also dismiss. 
	 * @parameter-->driver
	 * @parameter-->expectedText
	 */
	public void dismissAlert(String expectedText)
	{
		Alert alt=driver.switchTo().alert();
		/*
		if(alt.getText().equals(expectedText))
		{
			System.out.println("Alert message is verified");
		}
		else
		{
			System.out.println("Alert message is not verified");
	}
	*/
	alt.dismiss();
}
	/*
	 * -->It is used to place the cursor on Specified Element.
	 * @parameter-->driver
	 * @parameter-->element
	 */
	public void mouseOverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/*
	 * -->It is used to right click on Specified element.
	 * @parameter-->driver
	 * @parameter-->element
	 */
	public void rightClickByMouse(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void scrollWindowHandling(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(int vertical,int horizontal)");
	}
	public void switchToFrameByIndex(int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrameByElement(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void dropdownHandlingByText(WebElement element,String Text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(Text);
		
	}
	public void dropdownHandlingByIndex(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public String getScreenshot(String failedTestName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)BaseClass.listenerdriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./FolderName/"+failedTestName+".png");
		FileUtils.copyFile(src, trg);
		return trg.getAbsolutePath();
	}
	/*
	public void calendarHandle() 
	{
		Calendar cal=new Calendar();
		
	}
	*/
}
