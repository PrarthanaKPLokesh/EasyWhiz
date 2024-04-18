package com.MicrophoneTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MicTest {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--use-fake-ui-for-media-stream");
		WebDriver driver= new ChromeDriver(opts);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://mictests.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("mic-launcher")).click();
		
		Thread.sleep(5000);
		
		driver.close();
		
			
	}

}
