package com.TestScripts;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trackordertest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		// read data from excel
		FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\Downloads\\finnalTC.xlsx");
		Sheet sh = WorkbookFactory.create(fis).getSheet("EWtestdata");
		String order_ID = sh.getRow(23).getCell(1).getStringCellValue();
		
		
		// fetch data from property file
	    FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\commomdata.properties");
	    Properties pobj = new Properties();
	    pobj.load(fis1);
		
	    String URL = pobj.getProperty("user_url");
	    String USERNAME = pobj.getProperty("user_username");
	    String PASSWORD = pobj.getProperty("user_password");
	    
	    ChromeDriver driver = new ChromeDriver();
	     driver.manage().window().maximize();
	    driver.get(URL);
	    
	    //user login 
	    driver.findElement(By.xpath("//a[.='My Account']")).click();
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
	    driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
	    driver.findElement(By.name("login")).click();
	    System.out.println("user login sucessfully");
	    
	    
	    
		// track the order 
	    
	    driver.findElement(By.xpath("//span[.='Track Order']")).click();
	    System.out.println("track order page is displayed");
		driver.findElement(By.id("exampleOrderId1")).sendKeys(order_ID);
		driver.findElement(By.id("exampleBillingEmail1")).sendKeys(USERNAME);
		driver.findElement(By.name("submit")).click();
		System.out.println("track ststus page is displayed");
		
		
		
	}

}
