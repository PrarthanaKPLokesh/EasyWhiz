package com.OpenmultipleWindow;

import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabs {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver d= new ChromeDriver();
		d.manage().window().maximize();
		
		for(int i=0;i<4;i++)
			d.switchTo().newWindow(WindowType.TAB);
		
		
		
		Set<String> all_id=d.getWindowHandles();
		ArrayList<String> arr_id=new ArrayList(all_id);
		Thread.sleep(2000);
		int count=arr_id.size();
		System.out.println(count);
		
		String id0=arr_id.get(0);
		String id1=arr_id.get(1);
		String id2=arr_id.get(2);
		String id3=arr_id.get(3);
		d.switchTo().window(id0);
		d.get("https://www.amazon.com");
		d.switchTo().window(id1);
		d.get("https://www.flipkart.com");
		d.switchTo().window(id2);
		d.get("https://www.zomato.com");
		d.switchTo().window(id3);
		d.get("https://www.youtube.com");
		
		
	}
}
