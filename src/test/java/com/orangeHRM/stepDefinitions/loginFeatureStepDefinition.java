package com.orangeHRM.stepDefinitions;




import java.util.List;

import org.testng.annotations.Test;

import com.orangeHRM.pages.Common;

import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class loginFeatureStepDefinition extends Common{
	
private Common common;
	
	public loginFeatureStepDefinition(Common comm)
	{
		this.common = comm;
	}
	
	/*
	 * @Given("The user is on the Login Page") public void
	 * the_user_is_on_the_Login_Page() throws Exception {
	 * common.lpg.logintoapplication(); }
	 */

	@Test(description = "Logging into the application")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify whether user is able to login with valid credentials")
    @Story("Login to application")
	@When("^User successfully logs in$")
	public void user_successfully_logs_in(DataTable dt) throws Exception {
		System.out.println("Logging into application");
		List<String> Credentials = dt.asList();
		common.lpg.logintoapplication(Credentials.get(0),Credentials.get(1));  
	}

	@Test(description = "Verify Page Title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify whether the user is on correct page after login")
    @Story("Verify Page title of Page after successful login")
	@Then("Verify the title of the Page")
	public void verify_the_title_of_the_Page() {
	
		System.out.println("Verifying the title of the page");
		common.lpg.VerifyPageTitle();   
	}
	
	
	
}
