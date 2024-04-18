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

import com.GenericUtility.DataBaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;
import com.Object_Repository.Admin_LoginPage;

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
		
		driver.get(ADMINURL);
		System.out.println("Navigated to the url");
		
		Admin_LoginPage admin_Page=new Admin_LoginPage(driver);
		admin_Page.loginToApp(ADMINUSERNAME, ADMINPASSWORD);
		System.out.println("Logged In");
		
			
		if(	admin_Page.getLogOutMsgDisplay().isDisplayed())
			System.out.println("Pass: Logout Succesful message is displayed");
		else
			System.out.println("Fail: Logout Succesful message is not displayed");
		
		Thread.sleep(3000);
		driver.quit();
		
		

	}
	

}
