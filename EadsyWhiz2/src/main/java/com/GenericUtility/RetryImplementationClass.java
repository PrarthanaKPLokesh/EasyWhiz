package com.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer
{
int lowerCount=0;
int upperCount=3;
public boolean retry(ITestResult resul) 
{
	
	if(lowerCount<upperCount)
	{
		lowerCount++;
		
		return true;
	}
	return false;
	
	}



}
