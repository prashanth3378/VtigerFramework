package com.crm.campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Driver;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.Generic_utility.File_utility;
import com.crm.Generic_utility.excel_utility;
import com.crm.Generic_utility.java_utility;
import com.crm.Generic_utility.webdriver_utility;
import com.crm.object_repository.CreateNewCampaign;
import com.crm.object_repository.CreateNewProduct;
import com.crm.object_repository.Home_page;
import com.crm.object_repository.Login_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class create_product_campigonTest {


@Test(groups= {"regressionTest"})
	public void  create_product_campigonTest()throws Throwable {
		File_utility file=new File_utility();
		webdriver_utility driverlib=new  webdriver_utility();
		 excel_utility elib=new excel_utility();
		 java_utility jlib=new java_utility();
		
	String Browser = file.getpropertyKeyvalue("browser");
		WebDriver driver;
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
	
	 driverlib.waitforpagetoload(driver);
	 
	String URL = file.getpropertyKeyvalue("url");
	String UN = file.getpropertyKeyvalue("un");
	String PW = file.getpropertyKeyvalue("pw");
	driver.get(URL);
	
	Login_page log=new Login_page(driver);
	log.login(UN,PW);
	
	/*driver.findElement(By.name("user_name")).sendKeys(UN);	
	driver.findElement(By.name("user_password")).sendKeys(UN);
		driver.findElement(By.id("submitButton")).click();
		*/
	Home_page home=new Home_page(driver);
	home.Productslinktext();
	
//		driver.findElement(By.linkText("Products")).click();
	
	CreateNewProduct cproduct=new CreateNewProduct(driver);
	cproduct.CreateProduct();
	
//driver.findElement(By.xpath("//img[@ src=\'themes/softed/images/btnL3Add.gif\']")).click();
//random
int rannum = jlib. getRandomnum();

//excelutility
	String data = elib.getdatafromexcel("product", 0, 0)+rannum ;
	
	cproduct.ProductNametextfield(data);
	
//driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(data);
	
	cproduct.savebutton();
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//Campaign 
	
	  home.morelink();
	home.campignslink();
	
//driver.findElement(By.xpath("//a[@href=\'javascript:;\']")).click();
//driver.findElement(By.linkText("Campaigns")).click();
	
	CreateNewCampaign campaign=new CreateNewCampaign(driver);
	campaign.CreateCampaign();
	
//driver.findElement(By.xpath("//img[@src=\'themes/softed/images/btnL3Add.gif\']")).click();

//excelutility
	String data1 = elib.getdatafromexcel("campign", 0, 0)+rannum ;
	
	campaign.CampaignNametextfield(data);
	
	campaign.Productselect();
//driver.findElement(By.xpath("//input[@class=\'detailedViewTextBox\']")).sendKeys(data1);

//driver.findElement(By.xpath("//img[@alt='Select']")).click();

//switching window
driverlib.switchToWindow(driver, "products&action");
campaign.SearchTextfield(data);
	//driver.findElement(By.id("search_txt")).sendKeys(data);
campaign.SearchNowButton();
	//driver.findElement(By.xpath("//input[@class=\'crmbutton small create\']")).click();
	//dynamic xpath
	driver.findElement(By.xpath("//a[.='"+data+"']")).click();
	//switch back window
	driverlib.switchToWindow(driver, "campaigns&action");
	campaign.savebutton();
	//driver.findElement(By.xpath("//input[@title=\'Save [Alt+S]']")).click();
    	String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
	if(actdata.contains(data))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
home.signoutImg();

//	WebElement ele = driver.findElement(By.xpath("//img[@src=\'themes/softed/images/user.PNG\']"));
	//webdriver utility
	// driverlib.mouseoveronelement(driver, ele);
	home.signoutlink();
	driver.close();
//	driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

