@Login_to_Gmail
Feature: Login to Gmail
  Login to Gmail as a user

  Before: 
    Given Navigate to Amazon Account
    And Enter valid username "chiplunkar.k1@gmail.com"
    And Enter valid password "ket190785"

  Scenario: Login to Amazon with valid username and password
    Then user is successfully LoggedIn
     And the user sign out from Amazon
  Scenario: Search for Product in Amazon
    When user selects a Category and search with SearchText
      | Category       | SearchText    |
      | Amazon Devices | fire stick    |
      | Amazon Pantry  | baby shampoos |
    And the user click on SearchGlass
    Then the user gets search result
