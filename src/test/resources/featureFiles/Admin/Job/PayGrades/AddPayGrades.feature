#Feature: Add Pay Grades Feature
#
#  Background:
#    Given I am on the OrangeHRM login page
#    When I login with valid Admin credentials
#    Then I am on the dashboard page
#    And I navigate to Pay Grades Page
#
############################################################################################################################################################################################################################################
##    Pre condition to delete all the Pay Grades from the system
#  Scenario: Delete All Pay Grades from system
#    And I delete all the Pay Grades
#
############################################################################################################################################################################################################################################
#
#  Scenario: Validate if no Pay Grades are present, then 'No Records Found' text is displayed
#    Given there are no Pay Grades in the Pay Grades table
#    Then I validate 'No Records Found' Text is displayed
#
############################################################################################################################################################################################################################################
#
#  Scenario Outline: Validating if the user is able to Add a Pay Grade by entering all the valid details
##    PreCondition
#    Given there are no Pay Grades in the Pay Grades table
#
##    Add valid PayGrade
#    When I add a valid "<Pay Grade>"
#    And I click on Save Button
#    Then I validate that the "<Pay Grade>" is added successfully into the system
#
##    Add valid currency
#    When I add the currency "<Currency>" for the "<Pay Grade>" with a minimum salary of "<Minimum Salary>" and a maximum salary of "<Maximum Salary>"
#    And I click on Currency Save Button
#    Then I should see that the "<Currency>" is successfully added into the system
#
##    Validate Pay Grade and Currency are properly reflected into the table
#    And I navigate to Pay Grades Page
##    Then I validate that the "<Pay Grade>" and "<Currency>" is displayed successfully into the system
#
#    Examples:
#      | Pay Grade  | Currency                   | Minimum Salary | Maximum Salary |
#      | Grade 1    | INR - Indian Rupee         | 1000           | 2000           |
#      | Grade!@#$  | BBD - Barbados Dollar      | 2000           | 4000           |
#      | 1234567    | CUP - Cuban Peso           | 2000           | 5000           |
#      | GRADE 2    | ANG - NL Antillian Guilder | 3000           | 6000           |
#      | grade 3    | ANG - NL Antillian Guilder | 3000           | 6000           |
#      | Grade グレード | CUP - Cuban Peso           | 2000           | 5000           |
#
###########################################################################################################################################################################################################################################
#
#  Scenario Outline: Validating the error while Adding a Pay Grade with the same name
#    When I add a valid "<Pay Grade>"
#    And I click on Save Button
#    Then I navigate to Pay Grades Page
#    Then I validate the message that Pay Grade already exists
#    Examples:
#      | Pay Grade |
#      | Grade 1   |
#
##########################################################################################################################################################################################################################################
#
#  Scenario Outline: Validating the error when Maximum Salary is smaller than Minimum Salary
#    # PreCondition
#    Given there are no Pay Grades in the Pay Grades table
#
##    Add valid PayGrade
#    When I add a valid "<Pay Grade>"
#    And I click on Save Button
#    Then I validate that the "<Pay Grade>" is added successfully into the system
#
##    Add valid currency
#    When I add the currency "<Currency>" for the "<Pay Grade>" with a minimum salary of "<Minimum Salary>" and a maximum salary of "<Maximum Salary>"
#    Then I validate the error message that 'Should be higher than Minimum Salary'
#    Examples:
#      | Pay Grade | Currency           | Minimum Salary | Maximum Salary |
#      | Grade 4   | INR - Indian Rupee | 3000           | 1000           |
#
##########################################################################################################################################################################################################################################
#
#  Scenario: Validating if the error is displayed if the user is Adding a Pay Grade with all empty fields
#    When I add a Pay Grade with all fields empty
#    And I click on Save Button
#    Then I should see the Required error message displayed
#
##########################################################################################################################################################################################################################################
#
##    Post condition to delete all the Pay Grades from the system
#  Scenario: Delete All Pay Grades from system
#    And I delete all the Pay Grades
#
##########################################################################################################################################################################################################################################

#  Scenario: Validate the Number of Records Displayed on the Page

###########################################################################################################################################################################################################################################
