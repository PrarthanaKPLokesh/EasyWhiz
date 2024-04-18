package com.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleDragAndDrop
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		
		Actions act  = new Actions(driver);
		
		
		
		driver.findElement(By.xpath("//section[.='Mouse Actions']")).click();
		driver.findElement(By.xpath("//section[.='Drag & Drop']")).click();
		
		driver.findElement(By.linkText("Drag Multiple")).click();
		
		//drag and drop for mobile
		
		 driver.findElement(By.xpath("//div[.='Mobile Charger']")).click();
		 WebElement drag1=driver.findElement(By.xpath("//div[text()='Mobile Cover']"));
		 drag1.click();
		 WebElement drop1 = driver.findElement(By.xpath("//div[text()='Mobile Accessories']"));
		 
		 act.dragAndDrop(drag1, drop1).perform();
		 
		 Thread.sleep(2000);
		 
		 //drag and drop for Laptop
		 driver.findElement(By.xpath("//div[.='Laptop Charger']")).click();
	     WebElement drag2=driver.findElement(By.xpath("//div[.='Laptop Cover']"));
		 drag2.click();
		 WebElement drop2 = driver.findElement(By.xpath("//div[text()='Laptop Accessories']"));
			
		 act.dragAndDrop(drag2, drop2).perform();
		 
	}

}
