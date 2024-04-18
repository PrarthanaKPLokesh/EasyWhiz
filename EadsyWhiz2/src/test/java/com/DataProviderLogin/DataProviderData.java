package com.DataProviderLogin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.DataProvider;

public class DataProviderData {
	@DataProvider
	public Object[][] data1()
	{
		Object[][] Obj=new Object[2][2];
		Obj[0][0]="admin";
		Obj[0][1]="admin@Test";
		

		Obj[1][0]="admin";
		Obj[1][1]="admin@test";
		
		return Obj;
		

	}

}
	

