package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fb {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("./common data .properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url2");
		String UN = pro.getProperty("un1");
		String PW = pro.getProperty("pas1");
driver.get(URL);
driver.findElement(By.id("email")).sendKeys(UN);
driver.findElement(By.id("pass")).sendKeys(PW);
driver.findElement(By .name("login")).click();
	}

}
