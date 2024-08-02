#Feature: Edit Job Title Feature
#
#  Background:
#    Given I am on the OrangeHRM login page
#    Then I login with valid Admin credentials and I am on the dashboard page
#    Then I navigate to Job Titles Page
#
#  Scenario Outline: Editing the Job Title Name and validating if the updated Job Title Name is displayed in the PIM Job title dropdown
#
##    #    Deleting all the Job Title that is already present
##    Then I delete all the Job Titles in the Job Title Table
##
###    Adding a Job Title with Admin Login
##    Then I should be able to add a job title successfully by entering all the valid details "<Job Title>" "<Job Description>" and "<Note>" in the page
##    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>"
##
###    Adding an employee with the same Job Title
##    When I navigate to the PIM module
##    And I click on the Add Employee button and enter all the employee details without Login Details "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>"
##
###      Editing the Job Title Name
##    Then I navigate to Job Titles Page
#    Then I click on Edit Button for the Job Title "<Job Title>"
#    And I edit the Job Title Name and save it "<Updated Job Title>"
#
##    Then I navigate to the PIM module
##    And I search for the same employee in PIM that I added "<Employee Name>" "<Employee ID>"
##    Then I navigate to the employee details page "<First Name>" "<Middle Name>" "<Last Name>"
##    Then I navigate to Job Page
##    And I open the Job Title dropdown in Job Section and I select the same "<Updated Job Title>" that I added from Admin menu
##
###    Deleting the Job Title
##    Then I navigate to Job Titles Page
##    And I delete all the Job Titles in the Job Title Table
#    Examples:
#      | Job Title         | Job Description   | Note         | First Name | Middle Name | Last Name | Employee ID | Job Title         | Employee Name        | Updated Job Title|
#      | Software Engineer | Develops software | Note details | Vijay      | Kumar       | Chadayan  | 1001        | Software Engineer | Vijay Kumar Chadayan | QA Engineer      |
#
