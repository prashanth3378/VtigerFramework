package com.crm.Generic_utility;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class webdriver_utility
{
	private static final By Element = null;
	private Object SECONDS;
	private TimeUnit Timeunit;
	/**
	 * wait for page to load before identifying any synchronized in Dom
	 * @param driver
	 * @prashanth
	 */
public void waitforpagetoload(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
/**
 * use to place mouse cursor on specified element 
 * @param driver
 * @param element
 * @prashanth
 */
public void mouseoveronelement(WebDriver driver,WebElement element)

{
Actions ac=new Actions(driver);	
ac.moveToElement(element).perform();
}
/**
 * used to switch to any window based on the window title
 * @param driver
 * @param partialWindowTitle
 * @prashanth
 */
public void switchToWindow(WebDriver driver,String partialWindowTitle)
{
Set<String> allid1 = driver.getWindowHandles();
 Iterator<String> it1 = allid1.iterator();
while(it1.hasNext())
{
String wid = it1.next();
driver.switchTo().window(wid);
if(driver.getTitle().contains(partialWindowTitle))
{
   break;
}}
}
/**
 * used to switch to alert window and click on ok 
 * @param driver
 * @prashanth
 */
public void switchToAlertandAccept (WebDriver driver)
{
		driver.switchTo().alert().accept();
}
/**
 * used to switch to alert window and click on cancel
 * @param driver
 * @prashanth
 */
public void switchToAlertandDismiss (WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

/**
 * used to select the value from  dropdown based on text
 * @param element
 * @param text
 * @prashanth
 */
public void selectdropdown (WebElement element,String text)
{
	Select sel=new Select(element);
	sel.selectByVisibleText(text);			
}

/**
 * used to right click on specific element 
 * @prashanth
 */
public void rightclickOnElement(WebDriver driver,WebElement element)
{
	Actions ac=new Actions(driver);	
	ac.moveToElement(element).perform();
}

public void MoveByoffset(WebDriver driver,int x,int y)
{
	Actions act=new Actions(driver);	
	act.moveByOffset(x,y).click().perform();
}
/**
 *  used to select the value from  dropdown based on index
 * @param element
 * @param index
 * @prashanth
 */
public void selectdropdown (WebElement element,int index)
{
	Select sel=new Select(element);
	sel.selectByIndex(index);			
}

/**
 * used to switch to frame window based on id or name attribute 
 * @return 
 * @prashanth
 */
	public   void SwitchToFrame (WebDriver driver ,String id_name_Attribute)
	{
		driver.switchTo().frame( id_name_Attribute);
	}
	
	/**
	 * used to switch to frame window based on index
	 * @prashanth
	 */
	public   void SwitchToFrame (WebDriver driver ,int index)
	{
		driver.switchTo().frame( index);
	}
	
	/**
	 * used to wait for element to be clickable in Gui and check for specific element for specific element for every 500 miliseconds
	 * 
	 * @prashanth
	 */
	public  void waitforElementwithCustomTimeout(WebDriver driver,WebElement element,int pollingTime)
	{
		FluentWait wait =new FluentWait(driver);
		wait.pollingEvery(Duration. ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	/**
	 * After every action it will wait for next action to perform
	 * @param driver
	 * @prashanth
	 */
	public void ScriptTimeout(WebDriver driver)	
	{
		driver.manage().timeouts().setScriptTimeout(20, Timeunit.SECONDS);
	}
public String takescreenshotofpage(	WebDriver driver ,String screenshotName ) throws Throwable
{
    	 Date d =new java.util.Date();
	String date = d.toString().replace(" ", " -").replace(" :", " -");
	TakesScreenshot ts=(TakesScreenshot) driver; 
   File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/" + screenshotName +" " + ".png");
		FileUtils.copyFile(src, dst);
		System.out.println("screenshot taken succesfully");
		
			return dst.getAbsolutePath();
		}
	}
