package com.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginUsingActionsSendKeys 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@class,'poppins')]")).click();
		
		WebElement email = driver.findElement(By.id("email"));
		WebElement pass = driver.findElement(By.id("password"));
		WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
		Actions act = new Actions(driver);
		act.sendKeys(email, "mounikaakkiraju@gmail.com");
		act.sendKeys(pass, "Mounika@123");
		act.click(login).perform();
		
	}

}
