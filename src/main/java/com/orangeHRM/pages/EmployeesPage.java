package com.orangeHRM.pages;



import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;


import com.orangeHRM.utils.InputData;
import com.orangeHRM.utils.TestBase;

public class EmployeesPage extends TestBase{
	
	WebDriver driver = null;
	
	@FindBy(how= How.XPATH,using = "//a[@id='menu_pim_viewPimModule']")
	WebElement Personal_Info_Link;
	
	@FindBy(how= How.XPATH,using = "//a[@id='menu_pim_viewEmployeeList']")
	WebElement List_Emp_MenuItem;
	
	@FindBy(how= How.XPATH,using = "//input[@id = 'empsearch_employee_name_empName']")
	WebElement Name_Employee_textbox;
	
	@FindBy(how= How.XPATH,using = "//input[@id = 'searchBtn']")
	WebElement Search_Button;
	
	@FindBy(how= How.XPATH,using = "//input[@id = 'resetBtn']")
	WebElement Reset_Button;
	
	@FindBy(how=How.XPATH,using = "//div[@id='tableWrapper']/table/tbody/tr//following::td")
	List <WebElement> Results_Table;
	

	  public EmployeesPage(){}
	 
	
	public EmployeesPage(WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }
	
	//Data Provider Annotation
	@DataProvider()
	public Iterator<Object[]> getTestData() throws Exception
	{
		 ArrayList<Object[]> data = InputData.ReadExcel();
		 return data.iterator();
	}
	
	
	
	public void retriveEmployees(String Emp_Name,String ID,String EMPLOYMNENT_Status) throws InterruptedException
	{
		Personal_Info_Link.click();
		Thread.sleep(1000);
		List_Emp_MenuItem.click();
		Thread.sleep(1000);
		Name_Employee_textbox.sendKeys(Emp_Name);
		Thread.sleep(1000);
		Search_Button.click();
		Thread.sleep(10000);
		List<WebElement> cells = Results_Table;
		for (WebElement cell : cells) {
		System.out.println("Result returned is: "+cell.getText());
		
		}
		
		
	
		
	}
}
