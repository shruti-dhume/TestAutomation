package com.orangeHRM.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.qameta.allure.Step;




public class LoginPage {
	
	
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement Password;
	
	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement LoginButton;

	WebDriver driver;
	
	public LoginPage(WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }
	
	@Step("Logging into application with username: {0} and password: {1}...")
	public void logintoapplication(String username, String password)
	{
		Username.sendKeys(username);
		Password.sendKeys(password);
		LoginButton.click();
		
		
	}
	
	@Step("Verify Page title after successfull login...")
	public void VerifyPageTitle()
	  {
		  	String PageTitle = driver.getTitle();
			Assert.assertEquals(PageTitle, "OrangeHRM");
	  }
	
	
	

}
