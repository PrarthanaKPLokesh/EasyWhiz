package com.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class doubleClick
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//section[text()='Button']")).click();
		driver.findElement(By.linkText("Double Click")).click();
		WebElement ele=driver.findElement(By.xpath("//button[@id='btn20']"));
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
		
	}

}
