package com.FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//Default
public class DefaultFileUpload {
	public static void main(String[] args) throws InterruptedException {
		WebDriver d=new ChromeDriver();	
		d.manage().window().maximize();
		d.get("https://demoapps.qspiders.com/ui/fileUpload?sublist=0");
		Thread.sleep(2000);
		d.findElement(By.id("fileInput")).sendKeys("C:\\Users\\Admin\\Desktop\\TY.txt");}

}
