package com.HandlingPopUps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender3 {
	public static void main(String[] args) {
		int date=20;
		String monthAndYear="March 2025";
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();		
		for(;;)
		{
			try {
				driver.findElement(By.xpath("//div[text()="+"monthAndYear"+"]/../..//p[text()="+"date"+"]")).click();		
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).clear();
			}

		}


	}

}
