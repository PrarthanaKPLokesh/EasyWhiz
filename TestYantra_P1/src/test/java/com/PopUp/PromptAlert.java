package com.PopUp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PromptAlert {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://demoapps.qspiders.com/ui/alert/prompt?sublist=2");
		Thread.sleep(2000);
		//confirm alert
		driver.findElement(By.id("buttonAlert1")).click();
		Thread.sleep(2000);
		Alert alt=driver.switchTo().alert();
		Thread.sleep(2000);
		alt.sendKeys("no");
		alt.accept();
		
		 WebElement text=driver.findElement(By.xpath("//p[text()='Please reply with yes/no']"));
		String Text=text.getText();
		if(Text.contains("You selected no"))
			System.out.println("You selected no");
		else
			System.out.println("You selected yes");
		
	
				
	}

}
