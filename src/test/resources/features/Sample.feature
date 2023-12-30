Feature: Login functionality

  Scenario: Successful login
    Given the user is on the login page
    When the user enters valid credentials
    And clicks the login button
    Then the user should be redirected to the home page
    And the user's profile should be visible
