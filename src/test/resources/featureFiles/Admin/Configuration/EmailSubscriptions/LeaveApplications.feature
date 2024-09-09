Feature: Manage Leave Applications Notifications in Email Subscriptions
  As an admin, I want to manage subscribers for Leave Applications notifications
  So that employees and relevant stakeholders receive timely updates about leave applications

  Background:
    Given I am on the OrangeHRM login page
    When I login with valid Admin credentials
    Then I should be redirected to the Admin "dashboard"
    And I navigate to the Email Subscriptions Page
    When I select the "Leave Applications" notification type

  Scenario Outline: Add a New Subscriber to Leave Applications Notifications
    And I add a new subscriber with the email "<Email>" and name "<Name>"
    Then the subscriber with the Email "<Email>" and Name "<Name>" should be successfully added
    Examples:
      | Name           | Email               |
      | Charles Carter | charles@gmail.com   |
      | Charles&*^%$#  | charles1@gmail.com  |
      | Charles12345   | charles12@gmail.com |

  Scenario Outline: Attempt to Add a Duplicate Subscriber
    But "charles@gmail.com" is already subscribed to Leave Applications notifications
    When I attempt to add "charles@gmail.com" again with same name "Charles Carter"
    Then an error message "Already exists" should be displayed
    And no duplicate subscription with already added "<Email>" should be created
    Examples:
      | Email             |
      | charles@gmail.com |

  Scenario: View All Subscribers for Leave Applications Notifications
    Then the list should include all the below subscribers
      | Name           | Email               |
      | Charles Carter | charles@gmail.com   |
      | Charles&*^%$#  | charles1@gmail.com  |
      | Charles12345   | charles12@gmail.com |


  Scenario Outline: Add a Subscriber with Empty Email Field
    When I attempt to add a new subscriber with "<Name>" and an empty email field
    Then an error message "Required" should be displayed
    And the subscriber should with "<Name>" should not be added

    Examples:
      | Name         |
      | James Berger |

  Scenario Outline: Cancel Adding a New Subscriber to Leave Applications Notifications
    When I add a new subscriber with the email "<Email>" and name "<Name>"
    And I click the Cancel button
    Then no subscriber with "<Email>" should be added
    And I should be redirected back to the Leave Applications notifications list
    Examples:
      | Email            | Name           |
      | nikhil@gmail.com | Nikhil Mahadik |

  Scenario Outline: Validate Error Message for Invalid Email Format
    When I add a new subscriber with the email "<Invalid email format>" and name "<Name>"
    Then an error message "Expected format: admin@example.com" should be displayed
    And the subscriber with "<Invalid email format>" should not be added
    Examples:
      | Invalid email format | Name          |
      | invalidformat@       | Heather Davis |

  Scenario: Verify Persistence of Subscriptions After Page Refresh
#    Given I am on the Add Subscriber form in the Leave Applications notifications section
    And "charles@gmail.com" is subscribed to Leave Applications notifications
    When I refresh the "Email Subscriptions" Page
    Then "charles@gmail.com" should still appear in the Leave Applications notifications list

  Scenario: Verify Subscription Persists After Logout and Login
#    Given I am on the Add Subscriber form in the Leave Applications notifications section
    And "charles@gmail.com" is subscribed to Leave Applications notifications
    When I log out and log back in as the admin
    Then "charles@gmail.com" should still be subscribed from Leave Applications notifications

  Scenario: Remove a Subscriber from Leave Applications Notifications
#    Given I am on the Email Subscriptions Page
#    And I select the "Leave Applications" notification type
    And "charles@gmail.com" with name "Charles Carter" is subscribed to Leave Applications notifications
    When I remove "charles@gmail.com" from the Leave Applications notifications
    Then the subscriber "charles@gmail.com" should be successfully removed



