package com.PopUp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptPopups {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://demoapps.qspiders.com/ui/alert/confirm?sublist=1");
		Thread.sleep(2000);
		//confirm alert
		driver.findElement(By.id("buttonAlert5")).click();
	
		Alert alt=driver.switchTo().alert();
		Thread.sleep(2000);
	String txt=alt.getText();
	System.out.println(txt);
	alt.accept();
	Thread.sleep(2000);
	WebElement ele = driver.findElement(By.id("buttonAlert5"));
	ele.click();
	alt.dismiss();
	
	
		
		
		
	}

}
