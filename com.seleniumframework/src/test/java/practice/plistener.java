package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.Generic_utility.BaseClass;
import com.github.dockerjava.api.model.Driver;

public class plistener implements ITestListener {

	public void onTestFailure(ITestResult result) {
		String data = result.getMethod().getMethodName();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sDriver);
				File src = edriver.getScreenshotAs(OutputType.FILE);
				File dst = new File ("./com.seleniumframework/screenshot/"+data+",png");
				try {
					FileUtils.copyFile(src, dst);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	
		
	}