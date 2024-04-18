package com.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	public String ReaddatafromProperty(String Key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstant.Filepath);
		Properties Pobj = new Properties();
		Pobj.load(fis);
		String  value = Pobj.getProperty(Key);
		return value;
		
	}

}
