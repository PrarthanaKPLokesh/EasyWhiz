package com.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//section[.='Mouse Actions']")).click();
		driver.findElement(By.xpath("//section[.='Drag & Drop']")).click();
		driver.findElement(By.linkText("Drag Position")).click();
		
		WebElement drag = driver.findElement(By.xpath("//div[.='Mobile Charger']"));
		WebElement drag1 = driver.findElement(By.xpath("//div[text()='Mobile Cover']"));
		WebElement drop = driver.findElement(By.xpath("//div[text()='Mobile Accessories']"));
		
		WebElement Ldrag = driver.findElement(By.xpath("//div[.='Laptop Charger']"));
		WebElement L2drag=driver.findElement(By.xpath("//div[.='Laptop Cover']"));
		WebElement Ldrop = driver.findElement(By.xpath("//div[text()='Laptop Accessories']"));
		
		Actions act= new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
		act.dragAndDrop(drag1, drop).perform();
		
		act.dragAndDrop(Ldrag, Ldrop).perform();
		act.dragAndDrop(L2drag, Ldrop).perform();
	
	}

}
