Feature: Add Job Title Feature

  Background:
    Given I am on the OrangeHRM login page
    When I login with valid Admin credentials
    Then I am on the dashboard page
    And I navigate to Job Titles Page

##########################################################################################################################################################################################################################################

  Scenario: Validating if all the elements in the Add Job Title Page are present correctly
    When I click on Add Button and navigate to Add Job Titles Page
    Then I should be able to see all the UI elements are placed correctly on the page

##########################################################################################################################################################################################################################################

  Scenario: Delete all Job Titles and Employees Data
#    Delete all Job Titles
    And I delete all the Job Titles in the Job Title Table
    Then I validate there are no Job Titles present in Job Titles Table
#    Delete all employees
    And I navigate to the PIM module
    And I delete all the employees from the employee list table
    Then I validate there are no employees present in PIM

###########################################################################################################################################################################################################################################

  Scenario Outline: Validating if the user is able to Add a Job Title by entering all the valid details

    When I add a job title by entering all the valid details "<Job Title>" "<Job Description>" and "<Note>" on the page
    And I save the details
    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>"
    Examples:
      | Job Title         | Job Description                            | Note                                 |
      | Software Engineer | Develops software                          | Note details                         |
      | QA Engineer!@#    | QA engineer                                | Note details                         |
      | Project Manager   |                                            |                                      |
      | QA Engineer 123   | Job title with numeric characters          | Sample note                          |
      | Engineer2         | Job title with alphanumeric characters     | Sample note                          |
      | Senior Developer  | Job Title with spaces                      |                                      |
      | Lead QA           | Job Title with leading and trailing spaces | Sample note                          |
      | DevOps Engineer   |                                            | Job Title with blank Job Description |

##########################################################################################################################################################################################################################################

  Scenario: Validating if the error is displayed if the user is Adding a Job Title with all empty fields
    When I click on Add Button and navigate to Add Job Titles Page
    And I click on Save Button
    Then I should see the Required error message displayed

##########################################################################################################################################################################################################################################

  Scenario Outline: Validating if the error is displayed if the user enters a Job Description of more than 400 characters
    When I add a Job Title with more characters in the different fields "<Job Title>" "<Job Description>" "<Note>"
    Then I should get an error message in the "<Error Validation Field>" that more than 400 characters are not allowed
    Examples:
      | Job Title                 | Job Description                                                                                                                                                                                                                                                                                                                                                                                                       | Note                                                                                                                                                                                                                                                                                                                                                                                                                  | Error Validation Field |
      | Software Engineer in Test | In the serene countryside, where the gentle whispers of the wind rustling through the lush, emerald-green leaves of the ancient oak trees create a symphony of natural melodies, there exists a quaint, centuries-old stone cottage, its weathered walls adorned with a tapestry of ivy and vibrant, blooming flowers, where the scent of freshly baked bread wafts through the air, enticing the senses and evolving | Note details                                                                                                                                                                                                                                                                                                                                                                                                          | Job Description        |
      | Software Engineer in Test | Very long Note validation                                                                                                                                                                                                                                                                                                                                                                                             | In the serene countryside, where the gentle whispers of the wind rustling through the lush, emerald-green leaves of the ancient oak trees create a symphony of natural melodies, there exists a quaint, centuries-old stone cottage, its weathered walls adorned with a tapestry of ivy and vibrant, blooming flowers, where the scent of freshly baked bread wafts through the air, enticing the senses and evolving | Note                   |

########################################################################################################################################################################################################################################

  Scenario Outline: Adding a job title and validating if the same job title appears in the PIM module while adding a new employee

#    Adding a valid Job Title
    When I add a job title by entering all the valid details "<Job Title>" "<Job Description>" and "<Note>" on the page
    And I click on Save Button
    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>"

#    Adding an employee
    When I navigate to the PIM module
    And I click on the Add Employee button
    And I enter all the employee details without login details "<First Name>", "<Middle Name>", "<Last Name>", "<Employee ID>"
    And I save the details
    Then I validate that I am on the Personal Details Page

#    Adding job title to the employee's profile
    Then I navigate to Job Page
    When I open the Job Title dropdown in the Job Section
    And I select the "<Job Title>" that I added from the Admin menu
    And I save the selected Job Title
    Then I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>"

    Examples:
      | First Name | Middle Name | Last Name | Job Title                 | Job Description   | Note         | Employee ID | Job Title         |
      | Vijay      | Kumar       | Chadayan  | Software Engineer Level 1 | Develops software | Note details | 1001        | Software Engineer |

#######################################################################################################################################################################################################################################

  Scenario Outline: Adding an employee with Job Title and validating if the Job Title is displayed correctly in the employee's profile

#      Adding a Job Title
    When I add a job title by entering all the valid details "<Job Title>" "<Job Description>" and "<Note>" in the page
    And I click on Save Button
    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>"

#    Adding an employee
    When I navigate to the PIM module
    And I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Disabled Status>" "<Password>" "<Confirm Password>"
    And I save the details
    Then I validate that I am on the Personal Details Page

#    Adding the job title for the above added employee
    And I navigate to Job Page
    When I open the Job Title dropdown in the Job Section
    And I select the "<Job Title>" that I added from the Admin menu
    And I save the selected Job Title
    Then I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>"
    And I logout from the application

#    Checking the Job Title displayed in employee's profile by logging in with employee's credentials
    Given I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
    And I am on the dashboard page
    And I navigate to My Info Page
    When I navigate to Job Page
    Then I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>"

    Examples:
      | Job Title                 | Job Description   | Note         | First Name | Middle Name | Last Name | Employee ID | Job Title         | Username | Disabled Status | Password      | Confirm Password |
      | Software Engineer Level 2 | Develops software | Note details | Vijay      | Kumar       | Chadayan  | 1001        | Software Engineer | vijay123 | Enabled         | Password@1234 | Password@1234    |

##########################################################################################################################################################################################################################################

  Scenario: Delete all Job Titles and Employees Data
#    Delete all Job Titles
    And I delete all the Job Titles in the Job Title Table
    Then I validate there are no Job Titles present in Job Titles Table
#    Delete all employees
    And I navigate to the PIM module
    And I delete all the employees from the employee list table
    Then I validate there are no employees present in PIM

##########################################################################################################################################################################################################################################