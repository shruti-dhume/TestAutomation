package com.orangeHRM.utils;



import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.orangeHRM.pages.Common;






public class TestBase {
	
	
	public static ITestContext context;
	//public static Map<String, WebDriver> driverInstances = new HashMap<>();
	Common common = null;
	public static WebDriver driver_TestBase;
	
	
	
	  //public void Launch()  {
		
		 // WebDriver driver = driverInstances.get(context.getName());
//		
//		 if (driver_TestBase == null) {
//			    
//			    driver_TestBase = com.orangeHRM.driverinstance.DriverInstance.getWebDriver();
//				getCommon(context).launchUrl();
//				driver_TestBase.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
//		 }
//		 else
//			 System.out.println("driver initialized");
//			 //driverInstances.put(context.getName(), driver);
//			 
//		 	
//	}
//
//	  public WebDriver getdriver(ITestContext context)  {
//		  
//		  
//			if (context.getName() == null) {
//				System.out.println("Unable to connect with remote device");
//			}
//		
//			return driver_TestBase;
//		}
	  
	  
	
	public void setupTest(ITestContext iTestContext)
	{
		context = setContext(iTestContext, driver_TestBase);
		
	}

    public static ITestContext setContext(ITestContext iTestContext, WebDriver driver) {
         iTestContext.setAttribute("driver", driver);
         return iTestContext;
        }
    

    @Test(description = "This method is used for killing all the browser sessions")
    public static void Closedown()
    {
  	  //driver.close();
  	  //driver.quit();
  	  
    }
    
//    public Common getCommon(ITestContext context) {
//		if (common == null) {
//			common = new Common(driver_TestBase);
//			setupTest(context);
//		}
//		return common;
//	}

	  }
