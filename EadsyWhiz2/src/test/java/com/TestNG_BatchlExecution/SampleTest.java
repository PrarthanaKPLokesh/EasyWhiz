package com.TestNG_BatchlExecution;

import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

public class SampleTest {
	@Test(groups= {"Smoke"}) 
	public void Sample1Test()
	{
	System.out.println("-------Sample1Test-----------");
	}
	@Test(groups= {"Smoke"}) 
	public void Sample2Test()
	{
	System.out.println("-------Sample2Test-----------");
	}

	@Test(groups= {"Smoke"}) 
	public void Sample3Test()
	{
	System.out.println("-------Sample3Test----------");
	}

}
