package com.PopUp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfirmAlert {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://demoapps.qspiders.com/ui/alert?sublist=0");
		//default alert
		driver.findElement(By.id("buttonAlert2")).click();
		Thread.sleep(2000);
		Alert alt=driver.switchTo().alert();
		String txt=alt.getText();
		System.out.println(txt);
		alt.accept();  
		
	}

}
