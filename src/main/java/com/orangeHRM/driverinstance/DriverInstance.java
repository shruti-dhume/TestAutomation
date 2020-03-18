package com.orangeHRM.driverinstance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class DriverInstance {

	
	//@Before("@VerifyEmployeeInfo")
	public static WebDriver getWebDriver() {
		WebDriver driver_driverinstance = null;
		try
		{
			System.out.println("Initializing Browser");
			System.setProperty("webdriver.chrome.driver", "D:\\Setup\\chromedriver.exe");
			driver_driverinstance = new ChromeDriver();
			driver_driverinstance.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			driver_driverinstance.manage().window().maximize();
			
		} 
		
		catch (Exception e) {
			System.out.println("Issue while launching Browser");
		}

		
		
		return driver_driverinstance;
	}
}
