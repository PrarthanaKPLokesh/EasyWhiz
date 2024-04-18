package com.FileUpload;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Default
public class MultipleSelect {
	public static void main(String[] args) throws InterruptedException {
		WebDriver d=new ChromeDriver();	
		d.manage().window().maximize();
		d.get("https://demoapps.qspiders.com/ui/fileUpload/multiple?sublist=3");
		Thread.sleep(2000);
		WebElement ele = d.findElement(By.id("fileInput"));
		for(int i=0;i<=3;i++)
		ele.sendKeys("C:\\Users\\Admin\\Desktop\\TY.txt");
		WebElement ele1=d.findElement(By.className("list-decimal"));
		String str = ele1.getText();
		System.out.println("File Names are:"+str);
			}

}
