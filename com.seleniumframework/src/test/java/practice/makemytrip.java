package practice;

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

public class makemytrip {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("./common data .properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url1");
driver.get(URL);
driver.findElement(By.id("fromCity")).click();
FileInputStream fis1=new FileInputStream("./Book.xlsx");
Workbook book=WorkbookFactory.create(fis1);
Sheet sheet = book.getSheet("sheet1");
Row row = sheet.getRow(1);
Cell cell = row.getCell(0);
String data = cell.getStringCellValue();
driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(data);
driver.findElement(By.xpath("//p[contains(text(),'Mumbai, India')]")).click();
driver.findElement(By.xpath("//span[.='To']")).click();

FileInputStream fis2=new FileInputStream("./Book.xlsx");
Workbook book1=WorkbookFactory.create(fis2);
Sheet sh = book.getSheet("sheet1");
Row row1 = sheet.getRow(1);
Cell cell1 = row1.getCell(1);
String data2 = cell1.getStringCellValue();
driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(data2);
driver.findElement(By.xpath("//p[contains(text(),'Bengaluru, India')]")).click();
driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
	String month = "october 2022";
	String date = "30";
	Thread.sleep(2000);
	//Dynamic xpath
driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendent::p[text()='"+date+"']")).click();
	}

}
