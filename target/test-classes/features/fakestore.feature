#@api
#Feature: Fake Store Product API
#
#  Scenario: Get single product details
#    Given Fake Store API base URI is set
#    When user requests product details
#    Then product title should be "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
#    And product price should be 109.95

  @api
  Feature: Fake Store Create Product API

  Scenario: Create a new product
    Given Fake Store API base URI is set
    When user creates a product using API
    Then response status code should be 201
    And product title in response should be "Test Product"

