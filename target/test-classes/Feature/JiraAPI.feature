@JiraAPI
Feature: Working with Jira Rest APIs
  I want to use this template for my feature file
  
    @Login_to_login
  Scenario: Login to the Jira using session id
    Given user enters its username and password
    When the user triggers post request
    Then the user gets the session id
    

  @CreateIssue_UsingSessionCookies
  Scenario: Create an issue in Jira using session information
    Given user enters the URI and path value
    When user provides cookies for the session and enter issue related information
    Then the user is successfully able to create issue
