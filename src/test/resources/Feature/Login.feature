
Feature: Login functionality


  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user enters valid user name and password
    And user clicks on the login button
    Then user is navigated to the dashboard
    

  