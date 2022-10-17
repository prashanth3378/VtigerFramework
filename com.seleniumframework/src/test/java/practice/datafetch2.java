package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class datafetch2 {

public static void main(String[] args) throws Throwable {

System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
WebDriver driver=new ChromeDriver();
/*FileInputStream fis=new FileInputStream("./realestate.xlsx");
Workbook book=WorkbookFactory.create(fis);
Sheet sheet = book.getSheet("sheet1");
int rowcount = sheet.getLastRowNum();*/
genericworkpractice gw=new  genericworkpractice();
String data = gw.getexceldata("sheet1", 0, 0);
System.out.println(data);
}
}



	
