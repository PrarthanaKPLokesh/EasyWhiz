package com.TestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Create_cat_subcat_TC1_test 
{
	    public static  WebDriver driver = null ;
        public static void main(String[] args) throws IOException, InterruptedException
        {
        	
        	
			Random r = new Random();
			int ran = r.nextInt(500);
			   
			    // get data from excel
			    FileInputStream fis2 = new FileInputStream("C:\\Users\\Dell\\Downloads\\finnalTC.xlsx");
			    Workbook wb = WorkbookFactory.create(fis2);
			        Sheet sh = wb.getSheet("EWtestdata");
			        String cat_name = sh.getRow(0).getCell(1).getStringCellValue()+ran;
			        String desc = sh.getRow(1).getCell(1).getStringCellValue()+ran;
			        String exp_confmsg = sh.getRow(2).getCell(1).getStringCellValue();
			        String subcat_name = sh.getRow(3).getCell(1).getStringCellValue()+ran;
			          String exp_confmsg2 = sh.getRow(4).getCell(1).getStringCellValue();
			          String product_name =  sh.getRow(5).getCell(1).getStringCellValue()+ran;
			          String prod_company = sh.getRow(6).getCell(1).getStringCellValue()+ran;
			          String price_Bdiscount = sh.getRow(7).getCell(1).getStringCellValue();
			          String price_Adiscount = sh.getRow(8).getCell(1).getStringCellValue();
			          String pro_desc = sh.getRow(9).getCell(1).getStringCellValue();
			          String ship_charge = sh.getRow(10).getCell(1).getStringCellValue();
			          String pro_available1 =  sh.getRow(11).getCell(1).getStringCellValue();
			          String exp_confmsg3 = sh.getRow(12).getCell(1).getStringCellValue();
			                
			          
			          // get data from property file
			          FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commomdata.properties");
					  Properties pobj = new Properties();
					  pobj.load(fis);
			          String BROWSER = pobj.getProperty("browser");
			          String ADMIN_URL = pobj.getProperty("admin_url");
        	          String ADMIN_USERNAME =  pobj.getProperty("admin_usernmae");
        	          String ADMIN_PASSWORD = pobj.getProperty("admin_password");
        	          
        	                  	          
        	          if(BROWSER.contains("chrome"))
        	          {
        	        	  driver = new ChromeDriver();
        	          }
        	          
        	          driver.manage().window().maximize();
        	          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        	          driver.get(ADMIN_URL);
        	          System.out.println("admin login page is displayed"); 
        	          driver.findElement(By.id("inputEmail")).sendKeys(ADMIN_USERNAME);
        	          driver.findElement(By.id("inputPassword")).sendKeys(ADMIN_PASSWORD);
        	          driver.findElement(By.xpath("//button[.='Login']")).click();
        	          System.out.println("Admin home page is displayed");
        	          		
        	          driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();
        	          System.out.println("create category page is displayed");
        	          driver.findElement(By.name("category")).sendKeys(cat_name);
        	          Thread.sleep(1000);
        	          driver.findElement(By.xpath("//textarea[@name=\"description\"]")).sendKeys(desc);
        	          driver.findElement(By.xpath("//button[text()='Create']")).click();
        	          System.out.println("category is created");
        	          Thread.sleep(2000);
        	                  	          
        	          WebElement msg1 = driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]"));
        	                String act_confmsg = msg1.getText();
        	                 //  System.out.println(act_confmsg);
                      if(act_confmsg.contains(exp_confmsg))
                      {
                    	  System.out.println("confirmation message matched !!!!!!!!");
                      }
                      else
                    	  System.out.println("fail");
        	          
        	            
                //  ________________________________________________________________________________________________    
                      
                      driver.findElement(By.xpath("//a[.=\"Sub Category \"]")).click();
                      System.out.println("create sub category page is displayed ");
                      WebElement catdd = driver.findElement(By.name("category"));
                      Select s = new Select(catdd);
                      s.selectByVisibleText(cat_name);
                       Thread.sleep(2000);
                      driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys(subcat_name);
                      driver.findElement(By.name("submit")).click();
                      System.out.println("subcategory created");
                      
                      WebElement msg2 = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
  	                  String act_confmsg2 = msg2.getText();
  	                 //  System.out.println(act_confmsg2);
                      if(act_confmsg2.contains(exp_confmsg2))
                     {
                 	  System.out.println("confirmation message2 matched !!!!!!!!");
                      }
                     else
              	     System.out.println("fail");
                      
                      
                      
                      //____________________________________________________________________________________________
                      
                      driver.findElement(By.xpath("//a[.='Insert Product ']")).click();
                      System.out.println("insert product page is displayed");
                        WebElement catdd2 = driver.findElement(By.xpath("//select[@name=\"category\"]"));
                        Select s2 = new Select(catdd2);
                        s2.selectByVisibleText(cat_name);
                     WebElement subcatdd = driver.findElement(By.xpath("//select[@name=\"subcategory\"]"));
                     Select s3 = new Select(subcatdd);
                     s3.selectByVisibleText(subcat_name);
                      driver.findElement(By.name("productName")).sendKeys(product_name);
                      driver.findElement(By.name("productCompany")).sendKeys(prod_company);
                      driver.findElement(By.name("productpricebd")).sendKeys(price_Bdiscount);
                      driver.findElement(By.name("productprice")).sendKeys(price_Adiscount);
                      driver.findElement(By.name("productDescription")).sendKeys(pro_desc);
                      driver.findElement(By.name("productShippingcharge")).sendKeys(ship_charge);
                      WebElement pro_avidd = driver.findElement(By.name("productAvailability"));
                      Select s4 = new Select(pro_avidd);
                      s4.selectByVisibleText(pro_available1);
                      
           driver.findElement(By.id("productimage1")).sendKeys("D:\\eclipse_works\\com.Easy_whiz.www\\src\\test\\resources\\1355180.jpeg");                    
           driver.findElement(By.name("productimage2")).sendKeys("D:\\eclipse_works\\com.Easy_whiz.www\\src\\test\\resources\\1355180.jpeg");
           driver.findElement(By.name("productimage3")).sendKeys("D:\\eclipse_works\\com.Easy_whiz.www\\src\\test\\resources\\1355180.jpeg");
           driver.findElement(By.name("submit")).click();
           
                      
           WebElement msg3 = driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]"));
                  String act_confmsg3=  msg3.getText();
                   //  System.out.println(act_confmsg3);
                  
                  if(act_confmsg3.contains(exp_confmsg3))
                  {
                	  System.out.println("item inserted sucessfully");
                  }
                  else
                    System.out.println("failed");
                 
                  
                  wb.close();
                  
           
		}
}










