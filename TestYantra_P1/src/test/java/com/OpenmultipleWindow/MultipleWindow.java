package com.OpenmultipleWindow;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindow {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver d= new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://www.amazon.com/");
		d.switchTo().newWindow(WindowType.WINDOW);
		d.get("https://www.zomato.com/");
		d.switchTo().newWindow(WindowType.WINDOW);
		d.get("https://www.youtube.com/");
		d.switchTo().newWindow(WindowType.WINDOW);
		d.get("https://www.flipkart.com/");
		
		
		
	}
}
