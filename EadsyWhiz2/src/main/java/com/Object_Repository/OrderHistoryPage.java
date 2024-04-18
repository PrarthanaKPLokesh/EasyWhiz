package com.Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

//import com.GenericUtility.WebDriverUtilityCLASS;

public class OrderHistoryPage {
	public OrderHistoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr[last()]/td[last()]//a")
	private WebElement lastTrackButton;

	public WebElement getLastTrackButton() {
		return lastTrackButton;
	}
	
	/**
	 * prints order status and id,handles window popup and returns order status by tracking last order
	 * @param driver
	 * @param wUtil
	 * @return
	 */
	public String fetchTrackingDetails(WebDriver driver,WebDriverUtility wUtil)
	{
		String parentId = driver.getWindowHandle();
		lastTrackButton.click();
		wUtil.switchToWindow(driver, "Order Tracking Details");
		String orderStatus=driver.findElement(By.xpath("//b[text()='order Id:']/ancestor::tr/following-sibling::tr//td")).getText();
		String orderId=driver.findElement(By.xpath("//td[@class=\"fontkink\"]")).getText();
		System.out.println("Order Id: "+orderId);
		System.out.println("status: "+orderStatus);
		driver.close();
		System.out.println("child window closed");
		driver.switchTo().window(parentId);
		return orderStatus;
	}
	
	/**
	 * tracks the status of a given productName
	 * @param driver
	 * @param wUtil
	 * @param productName
	 * @return
	 */
	public String fetchStatusOfAProduct(WebDriver driver,WebDriverUtility wUtil, String productName)
	{
		String parentId = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[contains(text(),'"+productName+"')]/ancestor::tr/descendant::a[@title=\"Track order\"]")).click();
		wUtil.switchToWindow(driver, "Tracking");
		
		//System.out.println(driver.getTitle());
		String updatedStatus = driver.findElement(By.xpath("//b[text()='Status:']/../..//td[@class=\"fontkink\"]")).getText();
		System.out.println("Status in User module: "+updatedStatus);
		driver.close();
		driver.switchTo().window(parentId);
		return updatedStatus;
	}

}
