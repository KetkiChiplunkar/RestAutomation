@Paypal_RestAssured
Feature: Login to Paypal using rest assured credentials
  I want to login to Paypal using rest assured

  @ExtractAccessToken
  Scenario: Get the access token from paypal
    Given user provide rest uri
    And the user enter key as "grant_type" and value as "client_credentials"
    When user sends the Post request
    Then the user gets the access token in the response

  @CreatePayment
  Scenario: Create Payment using paypal api
    Given user provides rest uri for create payment
    And user provides the "Content-Type" as "application/json" and its "Authorization"
    When the user provides the message body for create payment
    Then the user is successfully able to create payment

  @CreatePayment_usingPojo
  Scenario: Create Payment using paypal api
    Given user provides rest uri for create payment
    And user provides the "Content-Type" as "application/json" and its "Authorization"
    When the user provides the intent as "sale"
    And the user provides payer information
    And the user provides transactions information
    And the user provides note to payer as "Contact us for any questions on your order."
    And the user provides redirect urls as "https://example.com/return" and "https://example.com/cancel"
    And the user provides the request to create payment
    Then the user is successfully able to create payment

  @GetPaymentDetails
  Scenario: Get the Payment details
    Given user provides rest uri for create payment
    And user provides the "Content-Type" as "application/json" and its "Authorization"
    When the user provides Payment id
    Then the user gets the Payment information
