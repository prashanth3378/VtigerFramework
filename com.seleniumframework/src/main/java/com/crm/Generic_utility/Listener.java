package com.crm.Generic_utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.IListenersAnnotation;
import org.testng.internal.annotations.IListeners;

public class Listener implements ITestListener{

	public void onTestFailure(ITestResult result) {
		String data = result.getMethod().getMethodName();
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
	}

}
}


