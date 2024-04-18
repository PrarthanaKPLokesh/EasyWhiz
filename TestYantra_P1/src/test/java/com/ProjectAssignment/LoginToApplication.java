package com.ProjectAssignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class LoginToApplication {
public static void main(String[] args) throws InterruptedException, SQLException {
	System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
	WebDriver driver=new FirefoxDriver();Random rm = new Random();
	int random = rm.nextInt(500);
	String pro="TY_Proj_1"+random;
	
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.get("http://rmgtestingserver:8084/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Projects")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	Thread.sleep(2000);
	driver.findElement(By.name("projectName")).sendKeys(pro);
	driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("LokeshDN");
	WebElement ele = driver.findElement(By.xpath("//label[text()='Project Status ']/../select[@name='status']"));
    Select sel=new Select(ele);
    sel.selectByVisibleText("Created");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@type='submit']")).submit();
    Thread.sleep(5000);

    Driver d = new Driver();
	DriverManager.registerDriver(d);
	Thread.sleep(2000);
	Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	Statement state = con.createStatement();
	String query="select * from project where lower(project_name)='"+pro+"';";
	ResultSet result = state.executeQuery(query);
	while(result.next())
	{
		String actual=result.getString(4);
		if(actual.equals(pro)) {
		System.out.println("data is present");
		}
		else
		{
			System.out.println("data is not present");
		}
	}
	con.close();
}
}