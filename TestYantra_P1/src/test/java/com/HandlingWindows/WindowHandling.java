package com.HandlingWindows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/ui/browser?sublist=0");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[text()='New Window']")).click();
		driver.findElement(By.xpath("//a[text()='Open in new window']")).click();
		Set<String> Child_ids = driver.getWindowHandles();
		String p_id = driver.getWindowHandle();
		for(String str:Child_ids)
		{
		
			driver.switchTo().window(str);
			String l=driver.getTitle();
			System.out.println(l);
			if(l.contains("SignUpPage"))
			{
			driver.switchTo().window("SignUpPage")	;
			break;
			}
				
		}
		
		
		driver.findElement(By.id("email")).sendKeys("abc");
		Thread.sleep(4000);
		driver.close();
	}
}
