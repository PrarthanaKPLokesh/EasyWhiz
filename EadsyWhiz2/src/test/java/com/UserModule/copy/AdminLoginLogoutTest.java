package com.UserModule.copy;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdminLoginLogoutTest {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String browser=fetchDataFromPropertyFile("browser");
		String adminUrl=fetchDataFromPropertyFile("adminUrl");
		String adminUsername=fetchDataFromPropertyFile("adminUsername");
		String adminPassword=fetchDataFromPropertyFile("adminPassword");
		System.out.println(adminUsername);
		System.out.println(adminPassword);
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		else if(browser.equals("edge"))
			driver=new EdgeDriver();
		else if(browser.equals("firefox"))
			driver=new FirefoxDriver();
		else
			System.out.println("INVALID!!!!");
		System.out.println("Browser Launched");
		
		driver.manage().window().maximize();
		System.out.println("Window Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(adminUrl);
		System.out.println("Navigated to the url");
		driver.findElement(By.id("inputEmail")).sendKeys(adminUsername);
		driver.findElement(By.id("inputPassword")).sendKeys(adminPassword);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Logged In");
		
		driver.findElement(By.partialLinkText("Logout")).click();
		
		WebElement logoutSucMsg = driver.findElement(By.xpath("//span[@style=\"color:red;\"]"));
		if(logoutSucMsg.isDisplayed())
			System.out.println("Pass: Logout Succesful message is displayed");
		else
			System.out.println("Fail: Logout Succesful message is not displayed");
		
		Thread.sleep(3000);
		driver.quit();
		
		

	}
	public static String fetchDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

}
