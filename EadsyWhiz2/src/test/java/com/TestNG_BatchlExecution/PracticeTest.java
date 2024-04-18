package com.TestNG_BatchlExecution;

import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

public class PracticeTest {
	@Test(groups= {"Smoke"}) 
	public void Practice1Test()
	{
	System.out.println("-------Practice1Test-----------");
	}
	@Test(groups= {"Smoke"}) 
	public void Practice2Test()
	{
	System.out.println("-------Practice2Test-----------");
	}

	@Test(groups= {"Regression"}) 
	public void Practice3Test()
	{
	System.out.println("-------Practice3Test----------");
	}

}
