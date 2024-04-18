package com.FileDownload;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownloadToDestination {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opts = new ChromeOptions();
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("download.default_directory", "C:\\Users\\Admin\\Desktop\\TestYantraSample");
		opts.setExperimentalOption("prefs", map);		
		WebDriver driver= new ChromeDriver(opts);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/download?sublist=0");
		driver.findElement(By.id("writeArea")).sendKeys("qwertyuiop[");
		driver.findElement(By.id("downloadButton")).click();
		Thread.sleep(2000);
		driver.close();
		
	}

}
