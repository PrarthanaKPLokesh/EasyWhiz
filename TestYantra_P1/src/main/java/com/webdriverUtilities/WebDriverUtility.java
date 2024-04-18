package com.webdriverUtilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {

	public void switchWindow(WebDriver driver,String url)
	{
		Set<String> wid = driver.getWindowHandles();
		for(String str:wid)
		{
			driver.switchTo().window(str);
			String txturl = driver.getCurrentUrl();
			if(txturl.contains(url))
			{
				break;
			}
		}
		
	}

}
