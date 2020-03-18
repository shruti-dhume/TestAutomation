package com.orangeHRM.stepDefinitions;





import java.io.ByteArrayInputStream;
//import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

//import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.orangeHRM.pages.Common;
import com.orangeHRM.pages.EmployeesPage;
import com.orangeHRM.pages.LeavePage;
import com.orangeHRM.pages.LoginPage;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
//import io.qameta.allure.Attachment;

public class Hook extends Common{
	
	private Common common;
	//public String URL = "http://10.44.122.10:8090/wd/hub";
	//public static ITestContext context;
	
	//using browserstack
	public static final String USERNAME = "shrutidhume1";
	  public static final String AUTOMATE_KEY = "xYyEzyjezs4boxgRgVgz";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	public Hook(Common comm)
	{
		this.common = comm;
	}

	
	
	
	@Before
	@Test
	public void InitializeTest(Scenario scenario)
	{
		
		try
		{
			System.out.println("Initializing Browser");
//			//Using BrowserStack
//			DesiredCapabilities caps = new DesiredCapabilities();
//		    caps.setCapability("browserName", "android");
//		    caps.setCapability("device", "Samsung Galaxy S8");
//		    caps.setCapability("realMobile", "true");
//		    caps.setCapability("os_version", "7.0");
//		    caps.setCapability("name", "Bstack-[Java] Sample Test");
//
//		    common.driver_Common = new RemoteWebDriver(new URL(URL), caps);
//		    common.lpg = new LoginPage(common.driver_Common);
//			common.emp = new EmployeesPage(common.driver_Common);
//			common.driver_Common.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			
			
			
			
			
			
			
			
			//Code to use Remotedriver 
//			System.setProperty("webdriver.chrome.driver", "D:\\Setup\\chromedriver.exe");
//			DesiredCapabilities cap = new DesiredCapabilities();
//			cap.setBrowserName("chrome");
//			//cap.setCapability("browser", "CHROME");
//			//cap.setCapability("platform", "windows");	
//			common.driver_Common = new RemoteWebDriver(new URL(URL), cap);
//			common.lpg = new LoginPage(common.driver_Common);
//			common.emp = new EmployeesPage(common.driver_Common);
//			common.driver_Common.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			
			
			
			
			
			//Code to use Chrome drive to run the automation
			System.setProperty("webdriver.chrome.driver", "D:\\Setup\\chromedriver.exe");
			common.driver_Common = new ChromeDriver();
			common.lpg = new LoginPage(common.driver_Common);
			common.emp = new EmployeesPage(common.driver_Common);
			common.leapg = new LeavePage(common.driver_Common);
			common.driver_Common.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			//common.driver_Common.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			
			System.out.println(scenario.getName() +" test case started");
		} 
		
		catch (Exception e) {
			System.out.println("Issue while launching Browser");
			e.printStackTrace();
		}
		
	}
	
	
	@After
	public void TearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			System.out.println("The name of the testcase that failed is :"+scenario.getName() + " - AllureListener");
			takesnapshot(scenario);
			  
		}
		common.driver_Common.close();
		common.driver_Common.quit();
		
	}
	
	//@Attachment(type ="image/jpg")
	public void takesnapshot(Scenario scenario) 
	{
		
		Allure.addAttachment(scenario.getName(),new ByteArrayInputStream( ((TakesScreenshot)common.driver_Common).getScreenshotAs(OutputType.BYTES)));
	}
	
	
	
	
	
    
}
