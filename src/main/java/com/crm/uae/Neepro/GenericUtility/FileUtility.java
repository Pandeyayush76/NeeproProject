package com.crm.uae.Neepro.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	/*
	It is used to read the data from external file(commondata.properties file).The value stored in this data in the form of Key and value pair.All the data are stored in this file with String data type.
	parameter1=pass the argument as key.
	parameter2=pass the return type as String.
	It will throw an FileNotFoundException exception in FileInputStream then we have to handle that exception by using Throwable which is supermost of all Exception. 
	*/
	
	public String getPropertyFromCommonData(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./Data/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}


}
