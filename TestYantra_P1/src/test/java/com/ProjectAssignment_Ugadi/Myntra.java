package com.ProjectAssignment_Ugadi;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {
	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.myntra.com/");
		WebElement home_living = driver.findElement(By.xpath("//a[.='Home & Living']"));
		Actions act = new Actions(driver);
		act.moveToElement(home_living).perform();
		List<WebElement> home_decor_list = driver.findElements(By.xpath("//a[.='Home Décor']/ancestor::ul/li/a[@class='desktop-categoryLink']"));
		System.out.println("--HOME DECOR LIST--");
		for(WebElement hd : home_decor_list) {
			String hd_text=hd.getText();
			System.out.println(hd_text);
		}
		WebElement mens = driver.findElement(By.xpath("//a[.='Men']"));
		act.moveToElement(mens).perform();
		driver.findElement(By.xpath("//a[.='Jackets' and contains(@href,'/men')]")).click();
		int jackets = driver.findElements(By.xpath("//li[@class='product-base']")).size();
		System.out.println("Total Jackets "+jackets);
		WebElement dropDown = driver.findElement(By.xpath("//span[.='Recommended']"));
		act.moveToElement(dropDown).perform();
		WebElement customerRating = driver.findElement(By.xpath("//label[.='Customer Rating']"));
		act.moveToElement(customerRating).click().perform();
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("mango men");
		List<WebElement> allSugg = driver.findElements(By.xpath("//li[@class='desktop-suggestion null']"));
		for(WebElement sugg : allSugg) {
			String suggText = sugg.getText();
			if(suggText.equals("Mango Men Shirts")) {
				sugg.click();
				break;
			}
		}
		driver.findElement(By.xpath("(//li[@class='product-base']/child::a)[6]")).click();
		Set<String> allWin = driver.getWindowHandles();
		for(String wid : allWin) {	
			String widTitle = driver.switchTo().window(wid).getTitle();
			if(widTitle.contains("Buy MANGO MAN Slim Fit Performance Shirt"))
				break;
		}
		driver.findElement(By.xpath("//p[text()='40']")).click();
		driver.findElement(By.xpath("//div[.='ADD TO BAG']")).click();
		driver.findElement(By.xpath("//span[.='Bag']")).click();
		String bagItemText = driver.findElement(By.xpath("(//div[@class='itemContainer-base-item '])[1]//div[@class='itemContainer-base-brand']")).getText();
		if(bagItemText.contains("MANGO MAN"))
			System.out.println("Item visible in first");
		else
			System.out.println("Item not visible in first");	
	}
}