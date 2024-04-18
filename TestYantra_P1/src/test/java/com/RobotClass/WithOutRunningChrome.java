package com.RobotClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WithOutRunningChrome {
	public static void main(String[] args) throws InterruptedException {
		//run the script with out opening the chrome browser, the script should run in background
		ChromeOptions option=new ChromeOptions();
		//option.addArguments("--headless");
		//option.addArguments("--incognito");
		//option.addArguments("--lang=kn");
		WebDriver d=new ChromeDriver(option);
		d.get("https://www.facebook.com/");
		System.out.println(d.getCurrentUrl());
		Thread.sleep(2000);
		d.quit();
	}

}
