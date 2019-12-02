package com.orangeHRM.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




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
	
	
	public void logintoapplication()
	{
		Username.sendKeys("Admin");
		Password.sendKeys("admin123");
		LoginButton.click();
		
		
	}
	
	
	

}
