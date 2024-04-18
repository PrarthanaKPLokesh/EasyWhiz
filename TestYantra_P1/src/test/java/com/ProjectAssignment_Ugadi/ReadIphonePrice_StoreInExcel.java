package com.ProjectAssignment_Ugadi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadIphonePrice_StoreInExcel {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 13"+Keys.ENTER);
		List<WebElement> allIphone13 = driver.findElements(By.xpath("//div[@class='a-section']//span[contains(.,'Apple iPhone 13')]"));
		List<WebElement> allIphone13Price = driver.findElements(By.xpath("//span[contains(.,'Apple iPhone 13')]/ancestor::div[@class='a-section']//span[@class='a-price-whole']"));
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Iphone 13 Price.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int a = 1;
		for(WebElement iphone13 : allIphone13) {
			String name = iphone13.getText();
			sh.createRow(a).createCell(0).setCellValue(name);
			a++;
		}
		int b = 1;
		for(WebElement iphone13Price : allIphone13Price) {
			String price = iphone13Price.getText();
			sh.getRow(b).createCell(1).setCellValue(price);
			b++;
		}
		FileOutputStream fOut = new FileOutputStream(".\\src\\test\\resources\\Iphone 13 Price.xlsx");
		wb.write(fOut);
		wb.close();
	}
}