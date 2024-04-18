package com.HandlingWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.webdriverUtilities.WebDriverUtility;

public class NewTabWindow {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/ui/browser/newTab?sublist=1");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Open window in new Tab']")).click();	

WebDriverUtility uti=new WebDriverUtility();
Thread.sleep(2000);
uti.switchWindow(driver, "SignUpPage");
driver.findElement(By.id("email")).sendKeys("abc");
	}
}
