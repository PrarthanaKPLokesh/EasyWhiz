package com.TestScripts;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtility.DataBaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.IpathConstant;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

	public class Add_to_wishlist_test {

		public static void main(String[] args) throws IOException, InterruptedException {
			FileUtility Futil=new FileUtility();
			ExcelUtility Eutil=new ExcelUtility();
			JavaUtility Jutil=new JavaUtility();
			WebDriverUtility Wutil=new WebDriverUtility();
			DataBaseUtility Dutil=new DataBaseUtility();
			
			// fetch data from property file
			    FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			    Properties pobj = new Properties();
			    pobj.load(fis1);
	            
			    
			// fetch data from excel file   
			    FileInputStream fis2 = new FileInputStream("C:\\Users\\Admin\\Downloads\\finnalTC (1).xlsx");
			             Workbook wb = WorkbookFactory.create(fis2);
			                		Sheet sh=    wb.getSheet("EWtestdata");
			               String search_for = sh.getRow(13).getCell(1).getStringCellValue();
			             //  readdatafromExcel(String SheetName,int rowno,int cellno)
			               String BILLING_ADD = sh.getRow(14).getCell(1).getStringCellValue();
			               String BILLING_STATE = sh.getRow(15).getCell(1).getStringCellValue();
			               String BILLING_CITY = sh.getRow(16).getCell(1).getStringCellValue();
			               String BILLING_PINCODE = sh.getRow(17).getCell(1).getStringCellValue();
			               String SHIPPING_ADD = sh.getRow(18).getCell(1).getStringCellValue();
			               String SHIPPING_STATE = sh.getRow(19).getCell(1).getStringCellValue();
			               String SHIPPING_CITY = sh.getRow(20).getCell(1).getStringCellValue();
			               String SHIPPING_PINCODE = sh.getRow(21).getCell(1).getStringCellValue();
			               String TO_url = sh.getRow(22).getCell(1).getStringCellValue();
			               
			               
			               
			    
			    String URL = pobj.getProperty("user_url");
			    String USERNAME = pobj.getProperty("user_username");
			    String PASSWORD = pobj.getProperty("user_password");
			    
			    WebDriver driver = new ChromeDriver();
			     driver.manage().window().maximize();
			    driver.get(IpathConstant.url);
			    
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
			   
			   // wishlist to add to cart 
			    driver.findElement(By.xpath("//a[.='Add to cart']")).click();
			    driver.findElement(By.xpath("//i[@class=\"icon fa fa-shopping-cart\"]")).click();
			    System.out.println("item moved to cart from wishlist");
			    
			    // add shipping address and billing address
			    driver.findElement(By.name("billingaddress")).sendKeys(BILLING_ADD);
			    driver.findElement(By.name("bilingstate")).sendKeys(BILLING_STATE);
			    driver.findElement(By.name("billingcity")).sendKeys(BILLING_CITY );
			    driver.findElement(By.name("billingpincode")).sendKeys(BILLING_PINCODE);
			    driver.findElement(By.name("update")).click();
			    driver.switchTo().alert().accept();
			    
			    
			    driver.findElement(By.name("shippingaddress")).sendKeys(SHIPPING_ADD);
			    driver.findElement(By.name("shippingstate")).sendKeys(SHIPPING_STATE);
			    driver.findElement(By.name("shippingcity")).sendKeys(SHIPPING_CITY);
			    driver.findElement(By.name("shippingpincode")).sendKeys(SHIPPING_PINCODE);
			    driver.findElement(By.name("shipupdate")).click();
			   driver.switchTo().alert().accept();
			   System.out.println("billing ans shipping address addedd sucessfully");
			    driver.findElement(By.name("ordersubmit")).click();
			    
			    // make payment through COD
			    driver.findElement(By.name("paymethod")).click();
			    driver.findElement(By.name("submit")).click();
			    System.out.println("order placed sucessfully");
			    
			 // track the order 
			    
			    driver.findElement(By.xpath("//tr[last()]/td[last()]//a")).click();
			    String pwind = driver.getWindowHandle();
			    Set<String> winds = driver.getWindowHandles();
			    for(String windsf:winds)
			    {
			    	driver.switchTo().window(windsf);;
			    	String TO_url_temp = driver.getCurrentUrl();
			    	if(TO_url_temp.contains(TO_url))
			    		break;
			    }
			    
			    
			    WebElement orderid = driver.findElement(By.xpath("//td[@class='fontkink']"));
			       String orderid_num = orderid.getText();
			    System.out.println(orderid.getText());
		        driver.close();
	 		    driver.switchTo().window(pwind);
	 		   sh.createRow(23).createCell(0).setCellValue("orderid");
		        sh.getRow(23).createCell(1).setCellValue(orderid_num);    
		       FileOutputStream fout = new FileOutputStream("C:\\Users\\Admin\\Downloads\\finnalTC (1).xlsx");
			    wb.write(fout);
			    wb.close();
			     Thread.sleep(3000);
			     // driver.close();
		}

	}










