@all @LogintoorangeHRM
Feature: Login to OrangeHRM

  Background: Launch the browser
#    Given The user is on the Login Page

  Scenario: User is able to login into the application
    When User successfully logs in
    |Admin|admin123|
    Then Verify the title of the Page
  
