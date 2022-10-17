package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;

public class demo2 {

	public static void main(String[] args) throws IOException, InterruptedException {
	System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	/*FileInputStream fis=new FileInputStream("./common data .properties.txt");
	Properties pro=new Properties();
	pro.load(fis);*/
	propertyfiledata pro=new propertyfiledata();
	String URL = pro.getProperty("url");
	String UN = pro.getProperty("un");
	String PW = pro.getProperty("pw");
	String org = pro.getProperty("organization_information");
	driver.get(URL);
driver.findElement(By.name("user_name")).sendKeys(UN);	
driver.findElement(By.name("user_password")).sendKeys(UN);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("accountname")).sendKeys(org);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//String page = driver.getPageSource();
String act_msg = driver.findElement(By.className("dvHeaderText")).getText();
	if(act_msg.contains(org))
	{
		System.out.println("created pass");
	}
	else
	{
		System.out.println("not created fail");
	}
	}

}
