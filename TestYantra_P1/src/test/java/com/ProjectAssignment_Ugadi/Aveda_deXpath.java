package com.ProjectAssignment_Ugadi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Aveda_deXpath {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.get("https://www.aveda.de");
		//		Alert alt= driver.switchTo().alert();
		//		alt.accept();	
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		Thread.sleep(8000);
		driver.findElement(By.xpath("//button[text()='Akzeptieren']")).click();
		Thread.sleep(8000);
		WebElement frame =driver.findElement(By.xpath("//iframe[@class=\'ab-in-app-message  ab-html-message ab-modal-interactions\']"));
		// driver.findElement(By.xpath("//iframe[@class='ab-in-app-message  ab-html-message ab-modal-interactions']"));
		driver.switchTo().frame(frame);
		Thread.sleep(8000);
		driver.findElement(By.xpath("//button[@aria-label='Close Message']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[text()='GESICHT & KÖRPER']")).click();
		Thread.sleep(8000);
		Actions act = new Actions(driver);
		WebElement makeup =driver.findElement(By.xpath("//a[text()='makeup']"));
		act.moveToElement(makeup).click(makeup).perform();
		WebElement allProducts = driver.findElement(By.xpath("//div[@role='listitem']"));
		driver.quit();
		}
}
