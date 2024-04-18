package com.TakeScreenShot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshot11 {
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.instagram.com");
		Thread.sleep(3000);
		getphoto.captureScreenshot(driver);
		driver.findElement(By.name("username")).sendKeys("hello");
		getphoto.captureScreenshot(driver);
		driver.findElement(By.name("password")).sendKeys("hello");
		getphoto.captureScreenshot(driver);
		
	}

}