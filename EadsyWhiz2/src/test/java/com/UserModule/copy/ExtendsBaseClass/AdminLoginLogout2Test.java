package com.UserModule.copy.ExtendsBaseClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

@Listeners(com.GenericUtility.ListnerImplimentationClass.class)
public class AdminLoginLogout2Test extends BaseClass {
	
	

	//public static void main(String[] args) throws IOException, InterruptedException {
	@Test
	public void AdminLogiLogoutTest()
	{
		System.out.println("Executed");
	/*	JavaUtility javaUtil=new com.GenericUtility.JavaUtility();
		FileUtility fileUtil= new FileUtility();
		ExcelUtility excelUtil= new ExcelUtility();
		WebDriverUtilityCLASS webDrUtil= new WebDriverUtilityCLASS();
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
	*/
	
	}
}
