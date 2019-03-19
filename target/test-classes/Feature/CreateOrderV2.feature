@Paypal_CreateOrder
Feature: Test the paypal Create Order Rest Services

  Background: 
    Given User gets the acess token
    And user gives the URI and enters the access token

  @CreateOrder
  Scenario: Create Order Using Paypal Rest Service
    When user triggers the Post request to create order
    Then user is successfully able to create order

  @GetOrder
  Scenario: Get the Order created from Paypal
    When user triggers the Get requests to get order
    Then user is successfully get the order details

  @UpdateOrder
  Scenario: Update the existing order using Patch resource
    When user triggers the Patch request to update the order
    Then user is successfully able to patch order
