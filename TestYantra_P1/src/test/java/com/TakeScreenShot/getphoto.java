package com.TakeScreenShot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

public class getphoto {
	public static void captureScreenshot(WebDriver driver)
	{
		Date d=new Date();
		String da=d.toString().replaceAll(":", "-");
		TakesScreenshot tss = (TakesScreenshot)driver;
		File src=tss.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Photo/"+da+".jpg");	
		//File dst=new File("C:\\Users\\Admin\\Desktop\\ScreenShot"+da+".jpg");
		try {Files.copy(src, dst);
			}catch(IOException e)	
		{
				
				System.out.println("Element not visible ");
		}
		}
	}




