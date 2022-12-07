package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.asn1.ASN1Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProvider {
	
@Test(dataProvider="dataprovider_test")
	public void SalesOrder(String name,String deptname,String title) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("./common data .properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL =pro.getProperty("url");
		String UN = pro.getProperty("un");
		String PW = pro.getProperty("pw");
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(UN);	
		driver.findElement(By.name("user_password")).sendKeys(UN);
			driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href=\'javascript:;\']")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("firstname")).sendKeys(name);
	driver.findElement(By.id("department")).sendKeys(deptname);
	driver.findElement(By.id("title")).sendKeys(title);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	driver.quit();
	Thread.sleep(2000);
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] dataprovider_test()
	{
		Object[][] objarr = new Object[3] [3];
		objarr[0] [0]="helloo";
		objarr[0] [1]="civil";
		objarr[0] [2]="helloo";
		
		objarr[1] [0]="helloo";
		objarr[1] [1]="civil";
		objarr[1] [2]="helloo";
		
		objarr[2] [0]="helloo";
		objarr[2] [1]="civil";
		objarr[2] [2]="helloo";
		return objarr;
		
		
		
		
	}
	}
