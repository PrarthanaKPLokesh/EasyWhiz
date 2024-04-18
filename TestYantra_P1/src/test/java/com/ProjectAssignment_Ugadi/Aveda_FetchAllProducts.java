package com.ProjectAssignment_Ugadi;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Aveda_FetchAllProducts {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.aveda.de/");
		driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']")).click();
		WebElement face_body = driver.findElement(By.xpath("//div[@id='node-6656']//a[.='GESICHT & KÖRPER']"));
		Actions act = new Actions(driver);
		act.moveToElement(face_body).perform();
		Thread.sleep(2000);
		WebElement makeup = driver.findElement(By.xpath("//div[@id='node-6656']//a[.='makeup']"));
		act.moveToElement(makeup).click(makeup).perform();
		WebElement allProducts = driver.findElement(By.xpath("//div[@role='listitem']"));
		driver.quit();
	}
}
