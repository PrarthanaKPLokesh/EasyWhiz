package com.ModalPopUp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleModel {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/modal/multiModal?sublist=1");
		driver.findElement(By.id("multiModalButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("multiClosemodal")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//p[text()='This is the secondary modal']"));
		String txt = ele.getText();
		System.out.println(txt);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='close']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("multiclose2")).click();
		
		driver.close();
	}

}
