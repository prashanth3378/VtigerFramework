package com.crm.Generic_utility;

import static org.testng.Assert.fail;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.IListenersAnnotation;
import org.testng.internal.annotations.IListeners;
import org.testng.reporters.Files;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener implements ITestListener{
	
WebDriver driver;
ExtentReports report;
ExtentTest test;


	public void onTestStart(ITestResult result) {
		/*step:3 create a test method during the test execution start*/
		
	test=report.createTest(result.getMethod().getMethodName());
}


	public void onTestSuccess(ITestResult result) {
		/* step:4 log the pass method */
		test.log(Status.PASS,result.getMethod().getMethodName()+" is passed");
	}
	


	public void onTestFailure(ITestResult result) {
		
		/*String data = result.getMethod().getMethodName();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sDriver);
		File src=edriver.getScreenshotAs(OutputType.FILE );
	try
	{

File destFile = new File("./com.seleniumframework/screenshot/"+data+",png");
FileUtils.copyFile(src, destFile);

	}
	catch (Throwable e)
	{
		e.printStackTrace();
	}*/
		
		//step 5
		
		/* log fail method ,take screenshot ,attach screenshot to extent report ,add exception log*/
		
		test.log(Status .FAIL,result .getMethod().getMethodName());
		test.log(Status.FAIL,result .getThrowable());
		String filepath=null;
		
		try {
			filepath=new webdriver_utility().takescreenshotofpage(driver, result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
test.addScreenCaptureFromPath(filepath);
}


	public void onTestSkipped(ITestResult result) {
	//	log the skip method 
		test.log(Status.SKIP,result.getMethod().getMethodName());
		test.log(Status.SKIP,result.getThrowable());
	}


	public void onStart(ITestContext context) {
		
	System.out.println("execution of test script started");
	
	Date d=new Date();
	System.out.println(d);
	String date=d.toString().replace(" ", " ").replace(":", "-");
	
	ExtentSparkReporter htmlreport=new ExtentSparkReporter(new File("extentreporter.html"));
	htmlreport.config().setDocumentTitle("Extent Report");
	htmlreport.config().setTheme(Theme.DARK);
	htmlreport.config().setReportName("functional test");
	
	/* Attach the physical report and do the system configuration*/
	report=new ExtentReports();
	report.attachReporter(htmlreport);
	report.setSystemInfo("os", "windows 11");
	report.setSystemInfo("Enviornment", "Testing Enviornment");
	report.setSystemInfo("URL", "http://localhost:8888");
	report.setSystemInfo("Reporter name ", "prashanth");
	
}


	public void onFinish(ITestContext context) {
	report.flush();
	}
	
}






