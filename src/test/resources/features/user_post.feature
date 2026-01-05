@postapi
Feature: Create User API

  Scenario: Create a user with address
    Given User API base URI is set
    When user creates a user using POST API
    Then response status code should be 201
    And response id should not be null


