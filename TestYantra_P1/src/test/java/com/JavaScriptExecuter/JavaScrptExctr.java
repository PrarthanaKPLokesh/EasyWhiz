package com.JavaScriptExecuter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScrptExctr {
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "./Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//version 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://www.amazon.in/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//launch the application
		js.executeScript("window.location=arguments[0]", "https://www.amazon.in/");
		
		//scroll down till the bottom of page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
	//scroll to the top of the page
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		//scroll Till element
		WebElement ele=driver.findElement(By.xpath("//a[text()='China']"));
		js.executeScript("arguments[0].scrollIntoView()", ele);
		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		//sendKeys
	WebElement ele1=driver.findElement(By.id("twotabsearchtextbox"));
	js.executeScript("arguments[0].value=arguments[1]", ele1,"iphone");
	
	
	
	
	}

}
