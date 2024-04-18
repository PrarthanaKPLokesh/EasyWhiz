package com.TestScripts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3 {
	static WebDriver driver = null ;
	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/index.php");
		System.out.println("User login page is displayed"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='My Account']")).click();
		System.out.println("User Signin Page is displayed");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("shopper@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("password");
		driver.findElement(By.xpath("//button[.='Login']")).click();
		System.out.println("My Account page is displayed");
		driver.findElement(By.xpath("//a[.='My Account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Shipping / Billing Address']")).click();
		WebElement billingaddress = driver.findElement(By.name("billingaddress"));
		billingaddress.clear();
		billingaddress.sendKeys("Laggere, Bangalore");
		driver.findElement(By.id("bilingstate")).sendKeys("Karnataka");
		driver.findElement(By.id("billingcity")).sendKeys("Bangalore");
		driver.findElement(By.id("billingpincode")).sendKeys("560068");
		driver.findElement(By.xpath("//button[.='Update']")).click();
		Alert  alt= driver.switchTo().alert();
		alt.accept();
		driver.findElement(By.xpath("//a[.='Shipping / Billing Address']")).click();
		
	}

}
