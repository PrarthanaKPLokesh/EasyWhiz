package com.Actions;

import java.time.Duration;

//import org.apache.commons.math3.ode.events.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//section[text()='Button']")).click();
		WebElement ele = driver.findElement(By.xpath("//button[@id='btn']"));
		Actions act= new Actions(driver);
		Thread.sleep(1000);
		act.click(ele).perform();
		WebElement ele1 = driver.findElement(By.xpath("//span[text()='You selected \"Yes\"']"));
		String text = ele1.getText();
		
		if(text.contains("Yes"))
        {
			System.out.println("you selected yes");
		}
		else
		{
			System.out.println("you selected no");
		}
		
	}

}
