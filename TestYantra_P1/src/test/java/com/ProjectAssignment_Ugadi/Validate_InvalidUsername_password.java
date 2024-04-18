package com.ProjectAssignment_Ugadi;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Validate_InvalidUsername_password {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("mugilanmonish@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Qwerty");
		driver.findElement(By.name("login")).click();
		if(driver.getTitle().equals("Facebook"))
			System.out.println("Invalid Credentials");
		else
			System.out.println("Valid Credentials");
	}
}