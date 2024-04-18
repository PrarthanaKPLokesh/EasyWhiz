package com.ProjectAssignment_Ugadi;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class maccosmetics_Xpath_ShopNow {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.maccosmetics.in/");
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='Modal Message']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//button[@id='i3uff']")).click();
		driver.quit();
	}
}