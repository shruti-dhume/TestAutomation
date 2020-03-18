@all @VerifyEmployeeInfo
Feature: Search for Employees in OrangeHRM

  Background: Launch the browser
    Given The user has successfully logged in

  Scenario: Verify that the Employee is part of the organisation
  
    Then Retrieve Employee Information using folllowing data
    |Linda Anderson|0001|Full-Time Permanent|
    |Robert Craig|0006|Full-Time Permanent|
    |Steven Edwards|0004|Full-Time Permanent|
    |Thomas Fleming|0005|Full-Time Contract|
	 
    
