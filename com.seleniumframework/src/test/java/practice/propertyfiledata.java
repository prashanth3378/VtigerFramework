package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class propertyfiledata {

	public String data(String key) throws Throwable
	{
		FileInputStream fis2=new FileInputStream("./common data .properties.txt");
		Properties pro=new Properties();
		pro.load(fis2);
		String data = pro.getProperty(key);
		return data;
	}

	public String getProperty(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
