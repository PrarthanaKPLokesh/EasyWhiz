package com.ProjectAssignment_Ugadi;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipKart_xpathOfSamsung {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//span/span[.='Appliances']")).click();
		WebElement tvAndAppli = driver.findElement(By.xpath("//span[.='TVs & Appliances']"));
		Actions act = new Actions(driver);
		act.moveToElement(tvAndAppli).perform();
		WebElement samsung = driver.findElement(By.xpath("//a[.='Samsung']"));
		act.moveToElement(samsung).click().perform();
	}
}