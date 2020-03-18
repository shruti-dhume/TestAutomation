package com.orangeHRM.stepDefinitions;

import org.testng.annotations.Test;

import com.orangeHRM.pages.Common;

import io.cucumber.java.en.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class leaveEntitlementStepDefinition extends Common{
private Common common;
	
	public leaveEntitlementStepDefinition(Common comm)
	{
		this.common = comm;
	}
	  
	
	   @Test(description = "Verify user is able Add Leave Entitlement")
	   @Severity(SeverityLevel.NORMAL)
	   @Description("Verify whether user is able to Add Leave Entitlement")
       @Story("Add Leave Entitlement")
	   @Then("^Navigate to Add Leave Entitlement$")
	    public void navigate_to_add_leave_entitlement() throws Exception  {
		   common.leapg.navigate_to_add_entitlement();
		   Thread.sleep(1000);
		   common.leapg.add_leave_entitlement();
		   Thread.sleep(1000);
		   common.leapg.verify_entitlement_submitted();
	        
		   
	    }

	

}
