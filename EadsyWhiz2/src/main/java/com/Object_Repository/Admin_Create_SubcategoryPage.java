package com.Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Admin_Create_SubcategoryPage {
	
	/*driver.findElement(By.xpath("//a[contains(text(),'Sub Category')]")).click();
		WebElement ctDropdown = driver.findElement(By.xpath("//select[@name=\"category\"]"));
	
		driver.findElement(By.xpath("//input[@placeholder='Enter SubCategory Name']")).sendKeys(subCategory);
		driver.findElement(By.name("submit")).click();*/
	@FindBy(xpath = "//a[contains(text(),'Sub Category')]")private WebElement Create_SubCategory;
	@FindBy(xpath = "//input[@placeholder='Enter SubCategory Name']")private WebElement SubCategory;
	@FindBy(xpath = "//select[@name=\\\"category\\\"]")private WebElement ctDropdown;
	@FindBy(name = "submit")private WebElement Submit;
	
	
	public Admin_Create_SubcategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getCreate_Category() {
		return Create_SubCategory;
	}


	public WebElement getSubCategory() {
		return SubCategory;
	}


	public WebElement getSubmit() {
		return Submit;
	}
	
	
	//Utilization

	public WebElement getCtDropdown() {
		return ctDropdown;
	}


	public void CreateCategory(String category)
	{
		Create_SubCategory.click();
		SubCategory.sendKeys(category);
	
		Submit.click();
	
	}
	
}
