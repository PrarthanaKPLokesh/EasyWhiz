package com.ProjectAssignment;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class icc_isPresent {
	public static void main(String[] args) throws InterruptedException {
		String CntryName="";
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		d.get("https://www.icc-cricket.com/rankings/team-rankings/mens/test");
		Thread.sleep(2000);
		List<WebElement> allCntry=d.findElements(By.xpath("//h3[@class='si-team-name']"));
		Thread.sleep(2000);
		for(WebElement eachCntry:allCntry)
		{
			CntryName =eachCntry.getText();
			
			if(CntryName.equals("INDIA"))
			{System.out.println(" ---------------------Is Present----------------------------------");
			}
			System.out.println(CntryName);
			
		}
		
	}

}

