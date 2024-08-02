#Feature: Add Job Category Feature
#
#  Background:
#    Given I am on the OrangeHRM login page
#    Then I login with valid Admin credentials and I am on the dashboard page
#    Then I navigate to Job Categories Page
#
#
#  Scenario Outline: Validating if the user is able to add a valid Job Category
#    And I add a valid Job Category and save it "<Job Category>"
#    Then I validate that after adding valid Job Category, user is redirected to Job Categories Page
##    Then I validate that the "<Job Category> is added successfully in the table"
#
#    Examples:
#      | Job Category |
#      | Demo         |