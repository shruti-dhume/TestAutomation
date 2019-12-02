package com.orangeHRM.tests;




import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.pages.EmployeesPage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.utils.TestBase;







public class NewTest extends TestBase{
	
	  @Test(priority = 1, description = "This method is used for logging into the browser")
	  public void Login() throws InterruptedException
	  {
		  	LoginPage lp = new LoginPage(driver);
			lp.logintoapplication();
			Thread.sleep(1000);
	  }
	  
	  @Test(priority = 2,description = "This method is used for verifying title")
	  public void VerifyPageTitle()
	  {
		  	String PageTitle = driver.getTitle();
			Assert.assertEquals(PageTitle, "OrangeHRM");
	  }
	  
		
	 @Test(priority = 3, description = "This method is used for the results of employee search",dataProvider="getTestData",dataProviderClass = com.orangeHRM.pages.EmployeesPage.class) 
	 public void VerifyEmployeeInformation(String EmpName,String ID,String EMPLOYMNENTStatus) throws InterruptedException 
	{ 
			 
			 EmployeesPage seEMP = new EmployeesPage(driver); 
		     seEMP.retriveEmployees(EmpName,ID,EMPLOYMNENTStatus);
		  
	}

	
	 
  
  
}
