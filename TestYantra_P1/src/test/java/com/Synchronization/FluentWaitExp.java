package com.Synchronization;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitExp {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		FluentWait wait =new FluentWait<>(driver);	
		wait.pollingEvery(Duration.ofMillis(1000));
		wait.withTimeout(Duration.ofSeconds(10));
		wait.ignoring(NoSuchElementException.class);
	}

}
