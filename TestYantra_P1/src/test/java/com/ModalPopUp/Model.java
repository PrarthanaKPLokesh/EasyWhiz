package com.ModalPopUp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Model {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/modal?sublist=0");
		driver.findElement(By.id("modal1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("closeModal")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
