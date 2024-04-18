package com.ProjectAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectorsHubScrollTillElement {
	public static void main(String[] args) throws InterruptedException {
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(2000);
		//JavascriptExecutor js=(JavascriptExecutor) d;
		WebElement shadowRootEle=d.findElement(By.xpath("//input[id='kils']"));
		SearchContext ele1 = shadowRootEle.getShadowRoot();
		//js.executeScript("arguments[0].scrollIntoView()", ele1);
		((WebElement) ele1).sendKeys("Dhanvitha D L");
		Thread.sleep(2000);
		WebElement shadowRootEle2=d.findElement(By.xpath("//input[id='pizza']"));
		SearchContext ele2 = shadowRootEle.getShadowRoot();
		//js.executeScript("arguments[0].scrollIntoView()", ele2);
		((WebElement) ele2).sendKeys("Margareta");
		Thread.sleep(2000);
		WebElement shadowRootEle3=d.findElement(By.xpath("//input[id='training']"));
		SearchContext ele3 = shadowRootEle.getShadowRoot();
		//js.executeScript("arguments[0].scrollIntoView()", ele3);
		((WebElement) ele3).sendKeys("Training");
		
		Thread.sleep(2000);
		WebElement shadowRootEle4=d.findElement(By.xpath("//input[id='pwd']"));
		SearchContext ele4 = shadowRootEle.getShadowRoot();
		//js.executeScript("arguments[0].scrollIntoView()", ele4);
		((WebElement) ele4).sendKeys("Password@123");
		Thread.sleep(2000);
	}

}
