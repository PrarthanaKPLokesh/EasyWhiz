package com.HandlingWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.webdriverUtilities.WebDriverUtility;

public class MultipleWindow {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/ui/browser/multipleWindow?sublist=2");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Click to open multiple popup windows']")).click();	

		WebDriverUtility uti=new WebDriverUtility();
		Thread.sleep(2000);
		uti.switchWindow(driver, "SignUpPage");
		driver.findElement(By.id("email")).sendKeys("Lokesh");
		Thread.sleep(2000);
		uti.switchWindow(driver, "SignUp");
		driver.findElement(By.id("email")).sendKeys("Dhanvitha");
		driver.findElement(By.id("username")).sendKeys("Chinni");
		Thread.sleep(2000);
		uti.switchWindow(driver, "Login");
		driver.findElement(By.id("username")).sendKeys("Prarthana");
	}
}


