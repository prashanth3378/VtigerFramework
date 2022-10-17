package com.crm.Generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.object_repository.Login_page;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass
{
	public static WebDriver sDriver;
	public WebDriver driver;
@BeforeSuite(groups= {"smokeTest","regressionTest"})
public void BS()
{
	System.out.println("DataBase Connection");
}
@BeforeTest(groups= {"smokeTest","regressionTest"})
public void BT()
{
	System.out.println("EXecute in parallel mode");
}
@Parameters("BROWSER") //this is only for cross browser
@BeforeClass(groups= {"smokeTest","regressionTest"})
//public void BC(String BROWSER ) throws Throwable //this is for the common browser
public void BC() throws Throwable
{
	File_utility file=new File_utility();
	java.lang.String BROWSER = file.getpropertyKeyvalue("browser");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	sDriver=driver;
	System.out.println("Launching the Browser");
}

@BeforeMethod(groups= {"smokeTest","regressionTest"})
public void BM() throws Throwable
{
	File_utility file=new File_utility();
	String URL = file.getpropertyKeyvalue("url");
	String UN = file.getpropertyKeyvalue("un");
	String PW = file.getpropertyKeyvalue("pw");
	driver.get(URL);
	
	Login_page log=new Login_page(driver);
	log.login(UN,PW);
	System.out.println("Login the application");
}
@AfterMethod(groups= {"smokeTest","regressionTest"})
public void AM()
{
	System.out.println("Logout the application");
}
@AfterClass(groups= {"smokeTest","regressionTest"})
public void AC()
{
	System.out.println("Close the Browser");
}
@AfterTest(groups= {"smokeTest","regressionTest"})
public void AT()
{
	System.out.println("Executed Succesfully");
}
@AfterSuite(groups= {"smokeTest","regressionTest"})
public void AS()
{
	System.out.println("Database Close");
}
}
