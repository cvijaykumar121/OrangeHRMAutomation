#Feature: Manage Leave Applications Notifications in Email Subscriptions
#  As an admin, I want to manage subscribers for Leave Applications notifications
#  So that employees and relevant stakeholders receive timely updates about leave applications
#
#  Background:
#    Given I am on the OrangeHRM login page
#    When I login with valid Admin credentials
#    Then I should be redirected to the Admin "dashboard"
#    And I navigate to the Email Subscriptions Page
#
#  @currentRun1
#  Scenario Outline: Add a New Subscriber to Leave Applications Notifications
#    Given I am on the Email Subscriptions Page
#    When I select the "Leave Applications" notification type
#    And I add a new subscriber with the name "<Name>" and email "<Email>"
#    Then the subscriber with the name "<Name>" and email "<Email>" should be successfully added to Leave Applications notifications
#    Examples:
#      | Name           | Email             |
#      | Charles Carter | charles@gmail.com |
#
##    Need to work on this
#  Scenario: Attempt to Add a Duplicate Subscriber
#    Given I am on the Email Subscriptions Page
#    And "charles@gmail.com" is already subscribed to Leave Applications notifications
#    When I attempt to add "charles@gmail.com" with same "<Name"> again
#    Then an error message "Already exists" should be displayed
#    And no duplicate subscription with already added name "<Name>" should be created
#
#  Scenario: Remove a Subscriber from Leave Applications Notifications
#    Given "subscriber1@example.com" is subscribed to Leave Applications notifications
#    When I remove "subscriber1@example.com" from the Leave Applications notifications
#    Then the subscriber should be successfully removed
#    And a confirmation message "Subscription removed successfully" should be displayed
#
#  Scenario: View All Subscribers for Leave Applications Notifications
#    Given I am on the Email Subscriptions Page
#    When I navigate to the Leave Applications notifications section
#    Then I should see a list of all current subscribers
#    And the list should include "subscriber1@example.com"
#
#  Scenario: Edit Subscriber's Email Address for Leave Applications Notifications
#    Given "subscriber1@example.com" is subscribed to Leave Applications notifications
#    When I update the subscriber's email address to "newemail@example.com"
#    Then the email address should be updated to "newemail@example.com"
#    And a confirmation message "Subscriber updated successfully" should be displayed
#
#  Scenario: Attempt to Edit with an Invalid Email Address
#    Given "subscriber1@example.com" is subscribed to Leave Applications notifications
#    When I attempt to update the email address to "invalidemail"
#    Then an error message "Please enter a valid email address" should be displayed
#    And the subscriber's email should remain "subscriber1@example.com"
#
#  Scenario: Add a Subscriber with Empty Email Field
#    Given I am on the Email Subscriptions Page
#    When I attempt to add a new subscriber with an empty email field
#    Then an error message "Email address cannot be empty" should be displayed
#    And the subscriber should not be added
#
#  Scenario: Cancel Adding a New Subscriber to Leave Applications Notifications
#    Given I am on the Add Subscriber form in the Leave Applications notifications section
#    When I click the Cancel button
#    Then no new subscriber should be added
#    And I should be redirected back to the Leave Applications notifications list
#
#  Scenario: Validate Error Message for Invalid Email Format
#    Given I am on the Email Subscriptions Page
#    When I attempt to add a subscriber with an invalid email format "invalidemail@"
#    Then an error message "Please enter a valid email address" should be displayed
#    And the subscriber should not be added
#
#  Scenario: Verify Persistence of Subscriptions After Page Refresh
#    Given "subscriber1@example.com" is subscribed to Leave Applications notifications
#    When I refresh the Email Subscriptions Page
#    Then "subscriber1@example.com" should still appear in the Leave Applications notifications list
#
#  Scenario: Verify Persistence of Subscriptions After Page Refresh
#    Given "subscriber1@example.com" is subscribed to Leave Applications notifications
#    When I refresh the Email Subscriptions Page
#    Then "subscriber1@example.com" should still appear in the Leave Applications notifications list
#
#  Scenario: Verify Unsubscription Persists After Logout and Login
#    Given "subscriber1@example.com" is unsubscribed from Leave Applications notifications
#    When I log out and log back in as the admin
#    Then "subscriber1@example.com" should still be unsubscribed from Leave Applications notifications
#
#
#
#
