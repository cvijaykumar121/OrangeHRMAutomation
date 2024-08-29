@jobTitle @regression
Feature: Edit Job Title Feature

  Background:
    Given I am on the OrangeHRM login page
    When I login with valid Admin credentials
    Then I am on the dashboard page
    And I navigate to Job Titles Page

#########################################################################################################################################################################################################

  @smoke @sanity
  Scenario: Delete all Job Titles and Employees Data
#    Delete all Job Titles
    And I delete all the Job Titles in the Job Title Table
    Then I validate there are no Job Titles present in Job Titles Table
#    Delete all employees
    And I navigate to the PIM module
    And I delete all the employees from the employee list table
    Then I validate there are no employees present in PIM

#########################################################################################################################################################################################################

  @smoke
  Scenario Outline: Editing the Job Title Info and validating if the updated Info of Job Title is displayed correctly in the table
  #    Adding a Job Title with Admin Login
    When I add a job title by entering all the valid details "<Job Title>" "<Job Description>" and "<Note>"
    And I save the details
    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>"

  #      Editing the Job Title Info
    And I click on Edit Button for the Job Title "<Job Title>"
    And I edit the Job Title Name to "<Updated Job Title>"
    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>" "<Updated Job Title>"


    Examples:
      | Job Title         | Job Description   | Note         | Job Title         | Updated Job Title |
      | Software Engineer | Develops software | Note details | Software Engineer | Edited            |

#########################################################################################################################################################################################################

  Scenario Outline: Editing the Job Title Info and validating if the updated Info is displayed in the employees profile from Admin Login

#    Adding a Job Title with Admin Login
    When I add a job title by entering all the valid details "<Job Title>" "<Job Description>" and "<Note>"
    And I save the details
    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>"

#    Adding an employee
    When I navigate to the PIM module
    And I click on the Add Employee button
    And I enter all the employee details without login details "<First Name>", "<Middle Name>", "<Last Name>", "<Employee ID>"
    And I save the details
    Then I validate that the employee is added successfully

#    Adding the job title to the above added employee
    And I navigate to Job Page
    When I open the Job Title dropdown in the Job Section
    And I select the "<Job Title>" that I added from the Admin menu
    And I save the selected Job Title
    Then I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>"

#      Editing the Job Title Name
    When I navigate to Job Titles Page
    And I click on Edit Button for the Job Title "<Job Title>"
    And I edit the Job Title Name to "<Updated Job Title>"
    And I save the details
    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>" "<Updated Job Title>"

#    Validating that the updated job title is reflected in the employee's profile
    When I navigate to the PIM module
    And I search for the same employee in PIM that I added "<Employee Name>"
    And I navigate to the employee details page "<First Name>" "<Middle Name>"
    And I navigate to Job Page
    Then I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>" "<Updated Job Title>"

    Examples:
      | Job Title           | Job Description   | Note         | First Name | Middle Name | Last Name | Employee ID | Employee Name        | Updated Job Title |
      | Software Engineer 1 | Develops software | Note details | Vijay      | Kumar       | Chadayan  | 1001        | Vijay Kumar Chadayan | QA Engineer       |

##########################################################################################################################################################################################################

  Scenario Outline: Editing the Job Title Info from Admin Login and validating if the updated Info is displayed in the employees profile from Employee Login

#    Adding a Job Title with Admin Login
    When I add a job title by entering all the valid details "<Job Title>" "<Job Description>" and "<Note>"
    And I click on Save Button
    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>"

#    Adding an employee
    When I navigate to the PIM module
    And I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "Enabled" "<Password>" "<Confirm Password>"
    And I save the details

#    Adding the job title to the above added employee
    When I navigate to Job Page
    When I open the Job Title dropdown in the Job Section
    And I select the "<Job Title>" that I added from the Admin menu
    And I save the selected Job Title
    Then I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>"

#      Editing the Job Title Name
    When I navigate to Job Titles Page
    And I click on Edit Button for the Job Title "<Job Title>"
    And I edit the Job Title Name to "<Updated Job Title>"
    And I save the details
    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>" "<Updated Job Title>"

#    Validating the updated Job Title is displayed correctly with Employee Login
    And I logout from the application
    When I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
#    And I am on the dashboard page
    And I navigate to My Info Page
    And I navigate to Job Page
    Then I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>" "<Updated Job Title>"

    Examples:
      | Job Title         | Job Description   | Note         | First Name | Middle Name | Last Name | Employee ID |  Employee Name        | Updated Job Title | Username | Status  | Password      | Confirm Password |
      | Software Engineer 2 | Develops software | Note details | Ajay      | Kumar       | Chadayan  | 1002        | Vijay Kumar Chadayan | QA Engineer       | ajay123 | Enabled | Password@1234 | Password@1234    |

##########################################################################################################################################################################################################
