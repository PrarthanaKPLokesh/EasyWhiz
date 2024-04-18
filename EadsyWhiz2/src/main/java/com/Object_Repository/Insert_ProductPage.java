package com.Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Insert_ProductPage {
	@FindBy(xpath = "//a[contains(text(),'Insert Product')]")private WebElement InsertProduct;
	public Insert_ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement InsertProduct() 
	{
		return InsertProduct;
	}
	public void InsertProductsInto(String username,String password)
	{
		InsertProduct.click();
		
	
	}
	
	
	/*	
@FindBy(id = "inputEmail")private WebElement usernameEdtTxt1;
@FindBy(id = "inputPassword")private WebElement passwordEdtTxt;	

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
	public WebElement getLogOutMsgDisplay() 
	{
		return LogOutMsgDisplay;
	}
	
	public void loginToApp(String username,String password)
	{
		usernameEdtTxt1.sendKeys(username);
		passwordEdtTxt.sendKeys(password);
		LoginBtnClk.click();
		LogOutBtnClk.click();
	
	}
	public void logOutFromApp()
{
	LogOutBtnClk.click();
}
*/
	
/*driver.findElement(By.xpath("//a[contains(text(),'Insert Product')]")).click();
		WebElement iCtDropdown = driver.findElement(By.xpath("//select[@name=\"category\"]"));
		Select isl1=new Select(create_subcat.getCtDropdown());
		isl1.selectByVisibleText(category);
		WebElement iSctDropdown = driver.findElement(By.xpath("//select[@name=\"subcategory\"]"));
		Select isl2=new Select(iSctDropdown);
		isl2.selectByVisibleText(subCategory);
		driver.findElement(By.name("productName")).sendKeys(productName);
		driver.findElement(By.name("productCompany")).sendKeys(productCompany);
		driver.findElement(By.name("productpricebd")).sendKeys(productPriceBD);
		driver.findElement(By.name("productprice")).sendKeys(productPriceAD);
		driver.findElement(By.name("productShippingcharge")).sendKeys(shippingCharge);
		WebElement availabilityDropdown = driver.findElement(By.xpath("//select[@name=\"productAvailability\"]"));*/	
}
