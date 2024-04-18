package com.Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Create_CategoryPage {
	/* 
		driver.findElement(By.xpath("//a[contains(text(),'Create Category')]")).click();
		driver.findElement(By.name("category")).sendKeys(category);
		driver.findElement(By.name("description")).sendKeys("Useful");
		driver.findElement(By.name("submit")).click();  */
	@FindBy(xpath = "//a[contains(text(),'Create Category')]")private WebElement Create_Category;
	@FindBy(name = "category")private WebElement Category;
	@FindBy(name = "description")private WebElement Description;
	@FindBy(name = "submit")private WebElement Submit;
	
	
	public Admin_Create_CategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getCreate_Category() {
		return Create_Category;
	}


	public WebElement getCategory() {
		return Category;
	}


	public WebElement getDescription() {
		return Description;
	}


	public WebElement getSubmit() {
		return Submit;
	}
	
	//Utilization

	public void CreateCategory(String category)
	{
		Create_Category.click();
		Category.sendKeys(category);
		Description.sendKeys("Useful");
		Submit.click();
	
	}
	
}
