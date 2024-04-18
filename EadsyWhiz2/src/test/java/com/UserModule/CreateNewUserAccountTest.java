package com.UserModule;



import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateNewUserAccountTest {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		Random r=new Random();
		int rn=r.nextInt(1000);
		String browser=fetchDataFromPropertyFile("browser");
		String userUrl=fetchDataFromPropertyFile("userUrl");
		String fullName=fetchDataFromExcelSheet("CreateAccount", 1, 0)+rn;
		String emailAdd=fetchDataFromExcelSheet("CreateAccount", 1, 1)+rn+"@gmail.com";
		String contactNo=fetchDataFromExcelSheet("CreateAccount", 1, 2);
		String password=fetchDataFromExcelSheet("CreateAccount", 1, 3);
		String cPassword=fetchDataFromExcelSheet("CreateAccount", 1, 4);
//		System.out.println(browser);
//		System.out.println(userUrl);
//		System.out.println(fullName);
//		System.out.println(emailAdd);
//		System.out.println(contactNo);
//		System.out.println(password);
//		System.out.println(cPassword);
		
		
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		else if(browser.equals("edge"))
			driver=new EdgeDriver();
		else if(browser.equals("firefox"))
			driver=new FirefoxDriver();
		else
			System.out.println("INVALID!!!!");
		System.out.println("Browser Launched");
		
		driver.manage().window().maximize();
		System.out.println("Window Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(userUrl);
		System.out.println("Navigated to the url");
		
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("fullname")).sendKeys(fullName);
		driver.findElement(By.id("email")).sendKeys(emailAdd);
		driver.findElement(By.id("contactno")).sendKeys(contactNo);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("confirmpassword")).sendKeys(cPassword);
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message: "+alert.getText());
		alert.accept();
		System.out.println("Alert handled");
		
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(emailAdd);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("logged in");
		
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("logged out");
		
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Browser closed");

	}
	public static String fetchDataFromExcelSheet(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestDataEW.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}
	public static String fetchDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

}
