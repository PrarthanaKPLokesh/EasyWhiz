package com.UserModule.copy.ExtendsBaseClass;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.Object_Repository.Admin_Create_CategoryPage;
import com.Object_Repository.Admin_Create_SubcategoryPage;

@Listeners(com.GenericUtility.ListnerImplimentationClass.class)
public class ChangeStatusOfAnOrderedProduct2Test extends BaseClass{
	static WebDriver driver;
@Test(retryAnalyzer =  com.GenericUtility.RetryImplementationClass.class)
public void ChangeStatusOfAnOrderedProductTest() throws IOException
{
	/*public static void main(String[] args) throws IOException, InterruptedException {
		JavaUtility javaUtil=new com.GenericUtility.JavaUtility();
		FileUtility fileUtil= new FileUtility();
		ExcelUtility excelUtil= new ExcelUtility();
		WebDriverUtilityCLASS webDrUtil= new WebDriverUtilityCLASS();
		DataBaseUtility dbUtil = new DataBaseUtility();
		
		Random r=new Random();
		int rn=r.nextInt(1000);
		*/String browser=fetchDataFromPropertyFile("browser");
		String adminUrl=fetchDataFromPropertyFile("adminUrl");
		String adminUsername=fetchDataFromPropertyFile("adminUsername");
		String adminPassword=fetchDataFromPropertyFile("adminPassword");
		String userUrl=fetchDataFromPropertyFile("userUrl");
		String userEmail=fetchDataFromPropertyFile("userEmail");
		String userPassword=fetchDataFromPropertyFile("userPassword");
		String category=fetchDataFromExcelSheet("InsertProduct", 1, 0)+jUtils.RandomNo();
		String subCategory=fetchDataFromExcelSheet("InsertProduct", 1, 1)+jUtils.RandomNo();
		String productName=fetchDataFromExcelSheet("InsertProduct", 1, 2)+jUtils.RandomNo();
		String productCompany=fetchDataFromExcelSheet("InsertProduct", 1, 3);
		String productPriceBD=fetchDataFromExcelSheet("InsertProduct", 1, 4);
		String productPriceAD=fetchDataFromExcelSheet("InsertProduct", 1, 5);
		String shippingCharge=fetchDataFromExcelSheet("InsertProduct", 1, 6);
		String productAvailability=fetchDataFromExcelSheet("InsertProduct", 1, 7);
		/*
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		else if(browser.equals("edge"))
			driver=new EdgeDriver();
		else if(browser.equals("firefox"))
			driver=new FirefoxDriver();
		else
			System.out.println("INVALID!!!!");
		System.out.println("Browser Launched");
			
		webDrUtil.maximizeWindow(driver);
//		driver.manage().window().maximize();
		System.out.println("Window Maximized");
		WebDriverUtility webutil=new WebDriverUtility();
		webutil.implicite(driver);
		
		driver.get(adminUrl);
		System.out.println("Navigated to the admin url");
		Admin_LoginPage admin_Page=new Admin_LoginPage(driver);
		admin_Page.loginToApp(adminUsername, adminPassword);
		System.out.println("Logged In");
		*/
		Admin_Create_CategoryPage create_cat=new Admin_Create_CategoryPage(driver);
		create_cat.CreateCategory(category);
//		driver.findElement(By.xpath("//a[contains(text(),'Create Category')]")).click();
//		driver.findElement(By.name("category")).sendKeys(category);
//		driver.findElement(By.name("description")).sendKeys("Useful");
//		driver.findElement(By.name("submit")).click();
		
		Admin_Create_SubcategoryPage create_subcat=new Admin_Create_SubcategoryPage(driver);
		create_cat.CreateCategory(category);

		
		//		driver.findElement(By.xpath("//a[contains(text(),'Sub Category')]")).click();
	//	WebElement ctDropdown = driver.findElement(By.xpath("//select[@name=\"category\"]"));
		Select sl;
		
			sl = new Select(create_subcat.getCtDropdown());
		
		sl.selectByVisibleText(category);
	
	//	driver.findElement(By.xpath("//input[@placeholder='Enter SubCategory Name']")).sendKeys(subCategory);
	//	driver.findElement(By.name("submit")).click();
		
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Insert Product')]")).click();
		WebElement iCtDropdown = driver.findElement(By.xpath("//select[@name=\"category\"]"));
		Select isl1=new Select(create_subcat.getCtDropdown());
		isl1.selectByVisibleText(category);
		WebElement iSctDropdown = driver.findElement(By.xpath("//select[@name=\"subcategory\"]"));
		Select isl2=new Select(iSctDropdown);
		isl2.selectByVisibleText(subCategory);
		driver.findElement(By.name("productName")).sendKeys(productName);
		driver.findElement(By.name("productCompany")).sendKeys(productCompany);
		driver.findElement(By.name("productpricebd")).sendKeys(productPriceBD);
		driver.findElement(By.name("productprice")).sendKeys(productPriceAD);
		driver.findElement(By.name("productShippingcharge")).sendKeys(shippingCharge);
		WebElement availabilityDropdown = driver.findElement(By.xpath("//select[@name=\"productAvailability\"]"));
		Select isl3=new Select(availabilityDropdown);
		isl3.selectByVisibleText(productAvailability);
		//driver.findElement(By.id("productimage1")).sendKeys(".\\src\\test\\resources\\pictures\\pic1.jpeg");
		//driver.findElement(By.name("productimage2")).sendKeys(".src\\test\\resources\\pictures\\pic2.jpeg");
		//driver.findElement(By.name("productimage3")).sendKeys(ue.select_Excel("image"));
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.partialLinkText("Logout")).click();
		
		driver.navigate().to(userUrl);
		System.out.println("Navigated to the user url");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(userEmail);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(userPassword);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys(productName);
		driver.findElement(By.xpath("//button[@class='search-button']")).click();
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		driver.switchTo().alert().accept();
		String parentId = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//tr[last()]/td[last()]//a")).click();
		Set<String> ids = driver.getWindowHandles();
		String orderStatus=null;
		String orderId=null;
		for(String id:ids)
		{
			driver.switchTo().window(id);
			String title = driver.getTitle();
			if(title.contains("Order Tracking Details"))
			{
				orderId=driver.findElement(By.xpath("//td[@class=\"fontkink\"]")).getText();
				orderStatus=driver.findElement(By.xpath("//b[text()='order Id:']/ancestor::tr/following-sibling::tr//td")).getText();
				driver.close();
			}
		}
		System.out.println("Order Id: "+orderId);
		System.out.println("status: "+orderStatus);
		driver.switchTo().window(parentId);
		driver.findElement(By.linkText("Logout")).click();
		
		driver.navigate().to(adminUrl);
		System.out.println("Navigated to the admin url");
		driver.findElement(By.id("inputEmail")).sendKeys(adminUsername);
		driver.findElement(By.id("inputPassword")).sendKeys(adminPassword);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Logged In");
		
		driver.findElement(By.xpath("//a[@href=\"#togglePages\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"pending-orders.php\"]")).click();
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(productName);
		driver.findElement(By.xpath("//a[@title=\"Update order\"]")).click();
		String adminWindow = driver.getWindowHandle();
		
		switchWindows(driver, "Update");
		new Select(driver.findElement(By.name("status"))).selectByValue("Delivered");
		driver.findElement(By.name("remark")).sendKeys("Enjoy");
		driver.findElement(By.name("submit2")).click();
		driver.switchTo().alert().accept();
		String status = driver.findElement(By.xpath("//b[text()='Status:']/../..//td[@class=\"fontkink\"]")).getText();
		System.out.println("Status changed by admin to: "+status);
		driver.close();
		
		driver.switchTo().window(adminWindow);
		driver.navigate().to(userUrl);
		System.out.println("Navigated to the user url");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(userEmail);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(userPassword);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Order History")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+productName+"')]/ancestor::tr/descendant::a[@title=\"Track order\"]")).click();
		switchWindows(driver, "Tracking");
		System.out.println(driver.getTitle());
		String updatedStatus = driver.findElement(By.xpath("//b[text()='Status:']/../..//td[@class=\"fontkink\"]")).getText();
		System.out.println("Status in User module: "+updatedStatus);
		if(updatedStatus.equals(status))
			System.out.println("Pass");
		else
			System.out.println("False");
		
		//Thread.sleep(3000);
		//driver.quit();

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
	public static void switchWindows(WebDriver driver,String title)
	{
		Set<String> ids = driver.getWindowHandles();
		for(String id:ids)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(title))
				break;
		}
	}

}
