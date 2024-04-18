package com.KeyboardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendSomeData {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d=new ChromeDriver()	;
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://demoapps.qspiders.com/ui/keyboard?sublist=0");
		Thread.sleep(1000);
		d.findElement(By.id("email")).sendKeys("Hello123@gmail.com",Keys.CONTROL+"AC");
		Thread.sleep(1000);
		d.findElement(By.id("password")).sendKeys(Keys.CONTROL+"V");
		d.findElement(By.id("confirmPassword")).sendKeys(Keys.CONTROL+"V",Keys.ENTER);

//		WebElement ele = d.findElement(By.id("email"));
//				ele.sendKeys("Hello123@gmail.com",Keys.CONTROL+"AC",Keys.TAB,Keys.CONTROL+"V",Keys.TAB,Keys.CONTROL+"V",Keys.ENTER);
		Thread.sleep(2000);
		d.quit();
		
	}
}
