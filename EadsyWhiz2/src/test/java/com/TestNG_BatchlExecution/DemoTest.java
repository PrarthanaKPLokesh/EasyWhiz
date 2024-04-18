package com.TestNG_BatchlExecution;

import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

public class DemoTest 
{
	
		@Test(groups= {"Smoke"}) 
		public void CreateTest()
		{
		System.out.println("-------Demo create-----------");
		}
		@Test(groups= {"Regression"}) 
		public void DeleteTest()
		{
		System.out.println("-------Demo Delete-----------");
		}

		@Test(groups= {"Smoke"}) 
		public void EditTest()
		{
		System.out.println("-------Demo Edit-----------");
		}

}
