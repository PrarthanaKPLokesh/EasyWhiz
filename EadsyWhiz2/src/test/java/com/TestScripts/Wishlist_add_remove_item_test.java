package com.TestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wishlist_add_remove_item_test {
	
	

	public static void main(String[] args) throws IOException, InterruptedException {
		// fetch data from property file
	    FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\commomdata.properties");
	    Properties pobj = new Properties();
	    pobj.load(fis1);
        
	    
	// fetch data from excel file   
	    FileInputStream fis2 = new FileInputStream("C:\\Users\\Dell\\Downloads\\finnalTC(1).xlsx");
	             Workbook wb = WorkbookFactory.create(fis2);
	                		Sheet sh=    wb.getSheet("EWtestdata");
	                		String search_for = sh.getRow(13).getCell(1).getStringCellValue();
	                		
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
	            		    
	            		 // add to wishlist 
	            		    driver.findElement(By.className("search-field")).sendKeys(search_for);
	            		    driver.findElement(By.className("search-button")).click();
	            		    driver.findElement(By.xpath("//a[.='Apple iPhone 6 (Silver, 16 GB)']")).click();
	            		    driver.findElement(By.xpath("//a[@data-original-title=\"Wishlist\"]")).click();
	            		    System.out.println("item addedd to wishlist sucessfully");
	            		    Thread.sleep(5000);
	            		    
	            		    
	            		 // remove from wishlist
	            		    driver.findElement(By.xpath("//i[@class=\"fa fa-times\"]")).click();
	            		    Thread.sleep(5000);
	            		   Alert al = driver.switchTo().alert();
	            		   Thread.sleep(5000);
	            		   String msg = al.getText();
	            		   System.out.println(msg);
//	            		   if(msg.equalsIgnoreCase("ok"))
//	            		   {
//	            			   al.accept();
//	            		   }
//	            		   else if(msg.equalsIgnoreCase("cancel"))
//	            		   {
//	            			   al.dismiss();
//	            		   }
	            		   Thread.sleep(5000);
	            		    al.accept();
	            		  //   al.dismiss();
                            System.out.println("item removed finally from wishlist ");
                            driver.close();
	}

}
