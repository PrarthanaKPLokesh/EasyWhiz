package com.Amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FetchColorOfIphone {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//version 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://www.amazon.in/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//launch the application
		js.executeScript("window.location=arguments[0]", "https://www.amazon.in/");
		
	WebElement ele1=driver.findElement(By.id("twotabsearchtextbox"));
	js.executeScript("arguments[0].value=arguments[1]", ele1,"iphone");
	ele1.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	Actions act =  new Actions(driver);
	Thread.sleep(2000);
	act.moveToElement(driver.findElement(By.xpath("//span[text()='Apple iPhone 14 (128 GB) - Blue']"))).click().perform();
   act.moveToElement(driver.findElement(By.xpath("//button[@class='a-button-text']")));
	Thread.sleep(2000);	
	List<WebElement> list =driver.findElements(By.xpath("//button[@class='a-button-text']//img"));
	Thread.sleep(2000);
	for(WebElement e:list)
	{
	String s=e.getAttribute("alt");
	System.out.println(s);
	}
	Thread.sleep(2000);
	driver.quit();
	/*Actions act =  new Actions(driver);
act.moveToElement(driver.findElement(By.linkText("Scans"))).click().perform();*/
	}

}
