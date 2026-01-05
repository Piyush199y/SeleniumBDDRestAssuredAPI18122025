Feature: API Basic Validation


  Scenario: Validate POST request
    Given API base URI is set
    When user sends POST request
    Then response status code should be 200
