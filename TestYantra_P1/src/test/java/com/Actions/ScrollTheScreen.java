package com.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollTheScreen
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
		//****OR****
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		
//		for(int i=1;i<=3;i++)
//		{
//			js.executeScript("window.scrollBy(0,300)");
//		}
		
		//***Using Action Class****
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Back to top' )]"));
//		Point loc = ele.getLocation();
//		int x=loc.getX();
//		int y=loc.getY();
//		
		Actions act = new Actions(driver);
//		act.scrollByAmount(x,y).perform();
		act.scrollToElement(ele).perform();
		
		//***or directly will use scroll to element method
		
		//act.scrollToElement(ele);
		
		
	}

}
