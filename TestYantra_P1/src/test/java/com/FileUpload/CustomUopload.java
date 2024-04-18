package com.FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Default
public class CustomUopload {
	public static void main(String[] args) throws InterruptedException {
		WebDriver d=new ChromeDriver();	
		d.manage().window().maximize();
		d.get("https://demoapps.qspiders.com/ui/fileUpload/custom?sublist=1");
		Thread.sleep(2000);
		WebElement ele = d.findElement(By.xpath("//div[text()='Upload File']"));
		
		ele.sendKeys(System.getProperty("user.dir")+"C:\\Users\\Admin\\Desktop\\TY.txt");
//		ele.click();
//		Thread.sleep(500);
//		ele.sendKeys("C:\\Users\\Admin\\Desktop\\TY.txt");
////		
//		JavascriptExecutor executor = (JavascriptExecutor)d;
//		executor.executeScript("arguments[0].click()", ele);
//		ele.sendKeys("C:\\Users\\Admin\\Desktop\\TY.txt");
		
			 
	}
}
