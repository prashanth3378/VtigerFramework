package com.crm.organisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Generic_utility.BaseClass;
import com.crm.Generic_utility.File_utility;
import com.crm.Generic_utility.excel_utility;
import com.crm.Generic_utility.java_utility;
import com.crm.Generic_utility.webdriver_utility;
import com.crm.object_repository.CreatingNewOrganization;
import com.crm.object_repository.Home_page;
import com.crm.object_repository.Login_page;
import com.crm.object_repository.VarificationandValidationpage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.Generic_utility.Listener.class)
public class createorganisationTest  extends BaseClass{
@Test //(groups= {"smokeTest","regressionTest"})
	//public void main(String[] args) throws Throwable
//	{
public void createorganisationTest() throws Throwable 
{
     	 webdriver_utility driverlib=new  webdriver_utility();
		File_utility file=new File_utility();
		excel_utility elib=new excel_utility();
		java_utility jlib=new java_utility();
		driverlib.waitforpagetoload(driver);
		
		
	/*	String URL = file.getpropertyKeyvalue("url");
		String UN = file.getpropertyKeyvalue("un");
		String PW = file.getpropertyKeyvalue("pw");
		driver.get(URL);
		
		Login_page log=new Login_page(driver);
		log.login(UN,PW);*/
		
/*	driver.findElement(By.name("user_name")).sendKeys(UN);	
	driver.findElement(By.name("user_password")).sendKeys(UN);
		driver.findElement(By.id("submitButton")).click();*/
		
		Home_page home=new Home_page(driver);
		home.organisazationlink();
		Assert.assertEquals(true, false);
		
		//driver.findElement(By.linkText("Organizations")).click();
		CreatingNewOrganization neworg=new CreatingNewOrganization(driver);
		neworg.CreatingNewOrganization();
		
//	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	//randnum
	int rannum = jlib. getRandomnum();
//excelutility
String data = elib.getdatafromexcel("sheet1", 0, 0)+rannum ;
	neworg.organizationtextfield(data);
	
   //	driver.findElement(By.name("accountname")).sendKeys(data);
	
//SoftAssert soft=new SoftAssert(); 
//soft.assertEquals("A", "B");
	neworg.savebutton();
	//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//String page = driver.getPageSource();
//	String act_msg = driver.findElement(By.className("dvHeaderText")).getText();
	VarificationandValidationpage valid=new VarificationandValidationpage(driver);
	valid.organisationValidation(driver, data);
	
	
	/*	if(act_msg.contains(data))
		{
			System.out.println("created pass");
		}
		else
		{
			System.out.println("not created fail");
		}*/
	//	driver.findElement(By.xpath("//img[@src=\'themes/softed/images/user.PNG\']")).click();
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	home.signoutImg();
	//WebElement ele = driver.findElement(By.xpath("//img[@src=\'themes/softed/images/user.PNG\']"));
		//webdriver utility
		home.signoutlink();
	//	soft.assertAll();
	//	 driverlib.mouseoveronelement(driver, ele);
	//	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		}


}
