package com.DataProviderLogin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Object_Repository.Admin_LoginPage;

public class DataPrividerMainClass {
	@Test(dataProviderClass= DataProviderData.class ,dataProvider= "data1")
	public void getData(String username, String password)
	{

		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/index.php");
		Admin_LoginPage Login=new Admin_LoginPage(driver);
		Login.loginToApp(username,password);




	}

}
