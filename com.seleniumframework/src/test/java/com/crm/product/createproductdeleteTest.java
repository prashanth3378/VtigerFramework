package com.crm.product;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Generic_utility.File_utility;
import com.crm.Generic_utility.excel_utility;
import com.crm.Generic_utility.java_utility;
import com.crm.Generic_utility.webdriver_utility;
import com.crm.object_repository.CreateNewProduct;
import com.crm.object_repository.Home_page;
import com.crm.object_repository.Login_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createproductdeleteTest {
@Test(groups= {"smokeTest","regressionTest"})
	public void createproductdeleteTest() throws Throwable {
		 webdriver_utility driverlib=new  webdriver_utility();
		File_utility file=new File_utility();
		java_utility jlib=new java_utility();
		excel_utility elib=new excel_utility();
		String Browser = file.getpropertyKeyvalue("browser");
		WebDriver driver;
		if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.chromedriver().setup();
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
		
/*	driver.findElement(By.name("user_name")).sendKeys(UN);	
	driver.findElement(By.name("user_password")).sendKeys(UN);
		driver.findElement(By.id("submitButton")).click();*/
		
		Home_page home=new Home_page(driver);
		home.Productslinktext();
		
	//	driver.findElement(By.linkText("Products")).click();
		CreateNewProduct cproduct=new CreateNewProduct(driver);
		cproduct.CreateProduct();
		
//driver.findElement(By.xpath("//img[@ src=\'themes/softed/images/btnL3Add.gif\']")).click();
//randnum
int rannum = jlib. getRandomnum();
//excelutility
	String data = elib.getdatafromexcel("product", 0, 0)+rannum ;
	
	cproduct.ProductNametextfield(data);
//driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(data);
	cproduct.savebutton();
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
String actmsg = driver.findElement(By.className("lvtHeaderText")).getText();
cproduct.Deletebutton();

//driver.findElement(By.xpath("//input[@title=\'Delete [Alt+D]\']")).click();
//webdriver utility
driverlib.switchToAlertandAccept(driver);
}
}