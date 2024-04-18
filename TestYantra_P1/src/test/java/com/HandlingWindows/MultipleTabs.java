package com.HandlingWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.webdriverUtilities.WebDriverUtility;

public class MultipleTabs {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/ui/browser/multipleTabs?sublist=3");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Click to open multiple tabs']")).click();	
		driver.manage().window().maximize();
		WebDriverUtility uti=new WebDriverUtility();
		Thread.sleep(1000);
		uti.switchWindow(driver, "SignUpPage");
		driver.findElement(By.id("email")).sendKeys("Lokesh");
		driver.findElement(By.id("password")).sendKeys("asdfghjkl");
		driver.findElement(By.id("confirm-password")).sendKeys("asdfghjkl");
		
		Thread.sleep(1000);
		uti.switchWindow(driver, "SignUp");
		driver.findElement(By.id("email")).sendKeys("Dhanvitha");
		driver.findElement(By.id("password")).sendKeys("asdfghjkl");
		driver.findElement(By.id("username")).sendKeys("Chinni");
		
		Thread.sleep(1000);
		uti.switchWindow(driver, "Login");
		driver.findElement(By.id("username")).sendKeys("Prarthana");
		driver.findElement(By.id("password")).sendKeys("asdfghjkl");
		
		Thread.sleep(2000);
		driver.quit();

	}



}
