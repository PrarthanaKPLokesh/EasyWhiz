package com.ProjectAssignment_Ugadi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Close7thWindow {
	public static void main(String[] args) throws AWTException {
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.google.com");
		//	Robot r = new Robot();
		//	for(int i=1;i<=9;i++)
		//	{
		//	r.keyPress(KeyEvent.VK_CONTROL);
		//	r.keyPress(KeyEvent.VK_T);
		//	r.keyRelease(KeyEvent.VK_CONTROL);
		//	r.keyRelease(KeyEvent.VK_T);
		//	 }
		for(int i=1;i<=9;i++)
			driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> allwindow = driver.getWindowHandles();
		System.out.println(allwindow.size());
		for(int i=1;i<=9;i++)
		{
			if(i==6)
			{

				driver.close();
				System.out.println(i);
			}
		}

		Set<String> allwindow1 = driver.getWindowHandles();
		System.out.println(allwindow1.size());
	}
}

