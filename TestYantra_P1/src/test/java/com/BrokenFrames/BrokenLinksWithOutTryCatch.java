package com.BrokenFrames;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.net.HttpURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrokenLinksWithOutTryCatch {
	public static void main(String[] args) throws Exception {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.passportindia.gov.in/AppOnlineProject/welcomeLink");
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		System.out.println(alllinks.size());
		for(WebElement eachlink:alllinks)
		{
				String link = eachlink.getAttribute("href");
			try {				
				URL url=new URL(link);
				HttpURLConnection httpConn=(HttpURLConnection) url.openConnection();
				int statuscode = httpConn.getResponseCode();
System.out.print(httpConn);
				if((statuscode>=400) && (statuscode!=0))
				{
					System.out.println(link+"---->"+statuscode);
				}
				}catch(Exception e)
				{
//			System.out.println("----------------------------------");
//					System.out.println("Exception:"+e);
//				System.out.println("----------------------------------");/				}
			}
		}
	}
}
