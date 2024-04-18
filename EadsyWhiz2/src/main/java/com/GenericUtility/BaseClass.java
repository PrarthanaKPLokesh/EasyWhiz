package com.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Object_Repository.Admin_LoginPage;

public class BaseClass {

	public DataBaseUtility dUtils=new DataBaseUtility();
	public FileUtility fUtils=new FileUtility();
	public ExcelUtility eUtils=new ExcelUtility();
	public WebDriverUtility wUtils=new WebDriverUtility();
	public JavaUtility jUtils=new JavaUtility();
			
	public static  WebDriver sdriver;
	public WebDriver driver;
	public void connectToDB() throws SQLException
	{
	
	//System.out.println("----DB Connected---");
	Reporter.log("------------DB Connected=-------",true);
	
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun =true)
	//pass these parameter for cross browser--> String BROWSER
	public void launchBrowser() throws IOException
	{
		String BROWSER = fUtils.ReaddatafromProperty("browser");
		//String BROWSER=System.getProperty("browser");
		//String URL=System.getProperty("adminUrl");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			Reporter.log("------------crome driver launched=-------",true);
		}
		else if(BROWSER.equalsIgnoreCase("Firfox"))
		{
			driver=new FirefoxDriver();
			Reporter.log("------------FirefoxDriver launched=-------",true);
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			Reporter.log("------------EdgeDriver launched=-------",true);
		}
		else
		{
			Reporter.log("------------invalid------",true);
		}
		sdriver=driver;
		
		wUtils.maximizeWindow(driver);
		wUtils.waitForPageLoad(driver,10);
				
	}
	@BeforeMethod(alwaysRun =true)
	public void LogoinToApp() throws IOException
	{	
		String adminUrl=fUtils.ReaddatafromProperty("adminUrl");
		String adminUsername=fUtils.ReaddatafromProperty("adminUsername");
		String adminPassword=fUtils.ReaddatafromProperty("adminPassword");
		System.out.println(adminUrl);
		driver.get(adminUrl);
		System.out.println(adminUrl);
		Admin_LoginPage lp=new Admin_LoginPage(driver);
		lp.loginToApp(adminUsername,adminPassword);
		System.out.println(adminUsername);
		System.out.println(adminPassword);
		Reporter.log("-----------Logged into application------",true);
		
	}
	@AfterMethod(alwaysRun =true)
	public void logOutFromApp()
	{//getLogOutBtnClk
		Admin_LoginPage lp=new Admin_LoginPage(driver);
		lp.logOutFromApp();
		Reporter.log("------------Logged out From application------",true);
	}
	
	@AfterClass(alwaysRun =true)
	public void closeBrowser()
	{
		//driver.quit();
		Reporter.log("-----------close the browser-----",true);
	}
//	@AfterSuite(alwaysRun =true)
//	public void DiscoonectToDB() 
//	{
//		Reporter.log("-----------Close DB Connection------",true);
//		
//	}
//

}
