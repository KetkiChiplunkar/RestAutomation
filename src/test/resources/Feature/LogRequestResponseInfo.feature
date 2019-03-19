@Request_Response_Information
Feature: Logging Request and Response Information of Rest Service

  Background: 
    Given a user provides base URI and resources
    
  Scenario: Log the header information of a rest service
    Given the user wants to get the header information
    When the user triggers get request to see the student's information
    Then the user gets the requested information

  Scenario: Get the student information witht the given parameters
    Given the user wants to get the header information
    And the user wants to get the student with "programme" as "Financial Analysis"
    When the user triggers get request
    Then the user gets the requested information

 Scenario: Get the request information for a Post request
    When user gives student first name as "Abeer"
    And user gives student last name as "Palherkar"
    And user provides it email address as "email@abc.com"
    And user provides sets programmer as "Programmer"
    And user provides its course information as "Java" and "QA"
    When user triggers the post request
    Then user is able to create student

  Scenario: Print the log only if the test fails(In this example given a an already existing user)
    When user gives student first name as "Abeer12323"
    And user gives student last name as "Palherkar123312"
    And user provides it email address as "email@abc1323.com"
    And user provides sets programmer as "Programmer"
    And user provides its course information as "Java" and "QA"
    When user triggers the post request
    Then user is able to create student
    And user gets the status code as "201"

 Scenario: Get the student information witht the given parameters
    Given the user wants to get the header information
    And the user wants to get the student with "programme" as "Medicine"
    When the user triggers get request