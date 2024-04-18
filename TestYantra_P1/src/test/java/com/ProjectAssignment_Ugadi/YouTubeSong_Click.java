package com.ProjectAssignment_Ugadi;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YouTubeSong_Click {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.youtube.com/");
		WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));
		searchBar.sendKeys(Keys.chord("song "));
		Thread.sleep(500);
		searchBar.sendKeys(Keys.SPACE);
		List<WebElement> songSugg = driver.findElements(By.xpath("//li/div/div[@class='sbqs_c']/b"));
		for(WebElement song : songSugg) {
			String suggText = song.getText();
			if(suggText.contains("new")) {
				song.click();
				break;
			}
		}
	}
}