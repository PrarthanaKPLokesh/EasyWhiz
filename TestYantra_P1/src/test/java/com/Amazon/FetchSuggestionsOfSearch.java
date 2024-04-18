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

public class FetchSuggestionsOfSearch {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//version 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://www.amazon.in/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//launch the application
		js.executeScript("window.location=arguments[0]", "https://www.flipkart.com/");
		
	WebElement ele1=driver.findElement(By.name("q"));
	js.executeScript("arguments[0].value=arguments[1]", ele1,"shirt");
	List<WebElement> ele2=driver.findElements(By.xpath("//input[@title='Search for products, brands and more']/../../following-sibling::ul//div/a/div/following-sibling::div/span"));
	for(WebElement e:ele2)
	{
		String s=e.getText();
		System.out.println(s);
	}
	
	
	
		//input[@title='Search for products, brands and more']
	}

}
