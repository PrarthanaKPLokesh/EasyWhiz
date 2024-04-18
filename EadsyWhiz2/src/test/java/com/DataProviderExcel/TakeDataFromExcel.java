package com.DataProviderExcel;

import org.testng.annotations.Test;



public class TakeDataFromExcel {
	public class DataPrividerMainClass {
		@Test(dataProviderClass= DataProviderTest.class ,dataProvider= "readDataFromExcel")
	public void getData(String Org, String Loc, String course,String Amount)
	{
		System.out.println("Organization------------>"+Org+"is located in ------>"+Loc+" with Course Name"+course+"with Fees"+Amount);
	}

	}


	
}
