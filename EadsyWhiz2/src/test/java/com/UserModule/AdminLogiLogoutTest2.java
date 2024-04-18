package com.UserModule;

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

import com.GenericUtility.DataBaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

public class AdminLogiLogoutTest2 {
	static WebDriver driver;
	

	public static void main(String[] args) throws IOException, InterruptedException {
		JavaUtility javaUtil=new com.GenericUtility.JavaUtility();
		FileUtility fileUtil= new FileUtility();
		ExcelUtility excelUtil= new ExcelUtility();
		WebDriverUtility webDrUtil= new WebDriverUtility();
		DataBaseUtility dbUtil = new DataBaseUtility();
		
	
		//read the data from property file
		String BROWSER = fileUtil.ReaddatafromProperty("browser");		
		String ADMINURL = fileUtil.ReaddatafromProperty("adminUrl");
		String ADMINUSERNAME = fileUtil.ReaddatafromProperty("adminUsername");
		String ADMINPASSWORD = fileUtil.ReaddatafromProperty("adminPassword");
		System.out.println(ADMINUSERNAME);
		System.out.println(ADMINPASSWORD);
		if(BROWSER.equals("chrome"))
			driver=new ChromeDriver();
		else if(BROWSER.equals("edge"))
			driver=new EdgeDriver();
		else if(BROWSER.equals("firefox"))
			driver=new FirefoxDriver();
		else
			System.out.println("INVALID!!!!");
		System.out.println("Browser Launched");
			
		//maximize the window
		webDrUtil.maximizeWindow(driver);
		System.out.println("Window Maximized");
		
		//implicitlyWait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//webDrUtil.implicitWait(driver, 10);
		
		driver.get(ADMINURL);
		System.out.println("Navigated to the url");
		
		driver.findElement(By.id("inputEmail")).sendKeys(ADMINUSERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(ADMINPASSWORD);
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
	

}
