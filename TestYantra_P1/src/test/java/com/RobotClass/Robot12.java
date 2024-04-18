package com.RobotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Robot12 {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://demoapps.qspiders.com/ui/keyboard?sublist=0");
		Thread.sleep(1000);
		//d.findElement(By.id("email")).sendKeys("Hello123@gmail.com");
		//	Robot r = new Robot();
		//	r.keyPress(KeyEvent.VK_C);
		//	r.keyRelease(KeyEvent.VK_V);
		d.findElement(By.id("email")).click();
		String str = "helloHI12345gmail.com";
		Robot r = new Robot();
		for(char c:str.toCharArray())
		{
			int ftext=KeyEvent.getExtendedKeyCodeForChar(c);
			r.keyPress(ftext);
			r.keyRelease(ftext);
		}
	}
}




