package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.github.dockerjava.api.model.Driver;

public class Redbus {

	public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver","./geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.get("https://www.");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	/*driver.findElement(By.id("src")).sendKeys("bangalore");
	driver.findElement(By.xpath("//div[contains(text(),'Bangalore, Karnataka, India']")).click();
	driver.findElement(By.id("dest")).sendKeys("mumbai");
	//driver.findElement(By.xpath("//input[@placeholder='DD/MY']")).click();
	//driver.findElement(By.id("date-box")).click();
	driver.findElement(By.xpath("//div[text()='SEARCH']")).click();
	//driver.findElement(/descendent::div[@class='DatePicker__DoubleCalendar-sc-1x9sb82-2 dwWaPy']/*/

	}
}
