Feature: Login functionality

  @ui
  Scenario: Successful login with valid credentials
    Given user is on login page
    When user enters username "tomsmith" and password "SuperSecretPassword!"
    And user clicks on login button
    Then user should see successful login message
