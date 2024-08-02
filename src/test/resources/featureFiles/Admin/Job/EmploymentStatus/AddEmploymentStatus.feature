#Feature: Add Employment Status Feature
#
#  Background:
#    Given I am on the OrangeHRM login page
#    Then I login with valid Admin credentials and I am on the dashboard page
#    Then I navigate to Employment Status Page
#
#
#  Scenario Outline: Validating if the user is able to add a valid Employment Status
#    And I add an "<Employment Status>" and save it
#    Then I validate that after adding valid Employment status, user is redirected to Employment Status Page
##    Then I validate that the "<Employment Status> is added successfully in the table"
#
#    Examples:
#      | Employment Status |
#      | Demo              |