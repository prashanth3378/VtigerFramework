package com.crm.Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_utility {
	/**
	 * This method used to launch the application
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @prashanth
	 */
	public String getpropertyKeyvalue(String Key) throws Throwable
	{
	//	FileInputStream fis=new FileInputStream("./common data .properties.txt");
		FileInputStream fis=new FileInputStream(Ipathconstanent.PROPERTYFILE_PATH);
		
		Properties pro=new Properties();
		pro.load(fis);
		 String value = pro.getProperty(Key);
		
		return  value;
		
	}
	
}
