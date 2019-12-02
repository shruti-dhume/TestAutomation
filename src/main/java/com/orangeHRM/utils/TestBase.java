package com.orangeHRM.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;





public class TestBase {
	
	public static WebDriver driver;
	public static ITestContext context;
	
	
	@BeforeClass(description = "This method is used for launching the browser")
	  public static void Launch()  {
		System.out.println("Initializing Browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Setup\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		
	}
	
	@BeforeMethod
	public void setupTest(ITestContext iTestContext)
	{
		context = setContext(iTestContext, driver);
	}

    public static ITestContext setContext(ITestContext iTestContext, WebDriver driver) {
         iTestContext.setAttribute("driver", driver);
         return iTestContext;
        }
    
    @AfterClass
    public void Closedown()
    {
  	  driver.close();
  	  driver.quit();
  	  
    }
}
