package com.Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_LoginPage {
	
@FindBy(id = "inputEmail")private WebElement usernameEdtTxt1;
@FindBy(id = "inputPassword")private WebElement passwordEdtTxt;	
@FindBy(xpath = "//button[text()='Login']")private WebElement LoginBtnClk;
@FindBy(xpath="//li[@class='nav-user dropdown open']")private WebElement LogOutBtn0Clk;

@FindBy(partialLinkText = "Logout")private WebElement LogOutBtnClk;
@FindBy(xpath = "//span[@style=\\\"color:red;\\\"]")private WebElement LogOutMsgDisplay;	

//Initialization
	public Admin_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getusernameEdtTxt()
	{
		return usernameEdtTxt1;
	}

	public WebElement getPasswordEdtTxt() 
	{
		return passwordEdtTxt;
	}

	public WebElement getLoginBtnClk() 
	{
		return LoginBtnClk;
	}
	public WebElement getLogOutBtnClk() 
	{
		return LogOutBtnClk;
	}
	public WebElement getLogOutBtn0Clk() 
	{
		return LogOutBtn0Clk;
	}
	public WebElement getLogOutMsgDisplay() 
	{
		return LogOutMsgDisplay;
	}
	
	public void loginToApp(String username,String password)
	{
		usernameEdtTxt1.sendKeys(username);
		passwordEdtTxt.sendKeys(password);
		LoginBtnClk.click();
		//LogOutBtnClk.click();
	
	}
	public void logOutFromApp()
{
		//LogOutBtn0Clk.click();
	LogOutBtnClk.click();
}
}