package com.Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodPage {
	

		public PaymentMethodPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="submit")
		private WebElement submitButton;

		public WebElement getSubmitButton() {
			return submitButton;
		}
		
		public void clickOnSubmitButton()
		{
			submitButton.click();
		}

	}


