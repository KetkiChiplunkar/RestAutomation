@Rest_Assured_Student
Feature: Get all the students
  I want to get all the student
  
  Background:
   Given a user provides base URI and resources

  Scenario: Get All the student using rest
    When the user request Get method
    Then the user gets the list of all students
    And the user gets the status code as "200"

Scenario: Create a student using post request
    When user gives student first name as "ketki"
    And user gives student last name as "Chiplunkar"
    And user provides it email address as "email@abc.com"
    And user provides sets programmer as "Tester"
    And user provides its course information as "Java" and "selenium"
    When user triggers the post request
    Then user is able to create student
    And user gets the status code as "201"

Scenario: Update student information using PUT request
    When user gives student first name as "ketki"
    And user gives student last name as "Chiplunkar"
    And user provides its updated email address as "email123@abc.com"
    And user provides sets programmer as "Tester"
    And user provides its course information as "Java" , "selenium" and "Spring"
    When user triggers the put request
    Then user information is updated successfully with the status code as "200"

Scenario: Update student information using PATCH request
    When user updates the email address information for student id "101"
    Then user information is updated successfully with the status code as "200"

 Scenario: Delete student using Delete request
    When user provides id "101" and triggers Delete request
    Then user record is deleted successfully with the status code as "204"
