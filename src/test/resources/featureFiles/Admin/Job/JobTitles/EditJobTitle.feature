Feature: Edit Job Title Feature

  Background:
    Given I am on the OrangeHRM login page
    And I login with valid Admin credentials
    Then I should be on the dashboard page
    When I navigate to Job Titles Page

#########################################################################################################################################################################################################

  Scenario Outline: Editing the Job Title Info and validating if the updated Info of Job Title is displayed correctly in the table
      #    Deleting all the Job Title that is already present
    Then I delete all the Job Titles in the Job Title Table

  #    Adding a Job Title with Admin Login
    When I add a job title by entering all the valid details "<Job Title>" "<Job Description>" and "<Note>" on the page
    And I click on Save Button
    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>"

  #      Editing the Job Title Info
    And I click on Edit Button for the Job Title "<Job Title>"
    Then I edit the Job Title Name and save it "<Updated Job Title>" "<Job Title>"

    Examples:
      | Job Title         | Job Description   | Note         | Employee ID | Job Title         | Employee Name        | Updated Job Title |
      | Software Engineer | Develops software | Note details | 1001        | Software Engineer | Vijay Kumar Chadayan | Edited            |

#########################################################################################################################################################################################################

  Scenario Outline: Editing the Job Title Info and validating if the updated Info is displayed in the employees profile from Admin Login

    #    Deleting all the Job Title that is already present
    Given I delete all the Job Titles in the Job Title Table

#    Adding a Job Title with Admin Login
    When I add a job title by entering all the valid details "<Job Title>" "<Job Description>" and "<Note>" on the page
    And I click on Save Button
    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>"

#    Adding an employee with the same Job Title
    When I navigate to the PIM module
    And I delete all the employees from the employee list table
    When I click on the Add Employee button
    And I enter all the employee details without login details: "<First Name>", "<Middle Name>", "<Last Name>", "<Employee ID>"
    When I navigate to Job Page

    When I open the Job Title dropdown in the Job Section
    And I select the "<Job Title>" that I added from the Admin menu
    And I save the selected Job Title
    Then I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>"

#      Editing the Job Title Name
    When I navigate to Job Titles Page
    And I click on Edit Button for the Job Title "<Job Title>"
    Then I edit the Job Title Name and save it "<Updated Job Title>" "<Job Title>"

    When I navigate to the PIM module
    And I search for the same employee in PIM that I added "<Employee Name>"
    Then I navigate to the employee details page "<First Name>" "<Middle Name>"
    And I navigate to Job Page
    And I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>" "<Updated Job Title>"

#    Deleting the Job Title
    Then I navigate to Job Titles Page
    And I delete all the Job Titles in the Job Title Table
    Then I navigate to the PIM module
    And I delete all the employees from the employee list table
    Examples:
      | Job Title         | Job Description   | Note         | First Name | Middle Name | Last Name | Employee ID | Job Title         | Employee Name        | Updated Job Title |
      | Software Engineer | Develops software | Note details | Vijay      | Kumar       | Chadayan  | 1001        | Software Engineer | Vijay Kumar Chadayan | QA Engineer       |

#########################################################################################################################################################################################################

  Scenario Outline: Editing the Job Title Info from Admin Login and validating if the updated Info is displayed in the employees profile from Employee Login

  #    Deleting all the Job Title that is already present
    Given I delete all the Job Titles in the Job Title Table

#    Adding a Job Title with Admin Login
    When I add a job title by entering all the valid details "<Job Title>" "<Job Description>" and "<Note>" on the page
    And I click on Save Button
    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>"

#    Adding an employee with the same Job Title along with their login details
    When I navigate to the PIM module
    And I delete all the employees from the employee list table
    And I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Status>" "<Password>" "<Confirm Password>"
    When I navigate to Job Page
    When I open the Job Title dropdown in the Job Section
    And I select the "<Job Title>" that I added from the Admin menu
    And I save the selected Job Title
    Then I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>"


#    Validate the Job Title added is properly displayed with the employee login
    Then I logout from the application
    And I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
    And I should be on the dashboard page
    Then I navigate to My Info Page
    And I navigate to Job Page
    Then I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>"

#    Login as Admin
    Then I logout from the application
    And I login with valid Admin credentials
    Then I should be on the dashboard page

#      Editing the Job Title Name
    When I navigate to Job Titles Page
    And I click on Edit Button for the Job Title "<Job Title>"
    And I edit the Job Title Name and save it "<Updated Job Title>" "<Job Title>"

#    Validating the updated Job Title is correctly displayed with Admin Login
    Then I navigate to the PIM module
    And I search for the same employee in PIM that I added "<Employee Name>"
    And I navigate to the employee details page "<First Name>" "<Middle Name>"
    And I navigate to Job Page
    Then I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>" "<Updated Job Title>"

#    Validating the updated Job Title is displayed correctly with Employee Login
    Then I logout from the application
    And I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
    And I should be on the dashboard page
    Then I navigate to My Info Page
    And I navigate to Job Page
    Then I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>" "<Updated Job Title>"

#    Deleting the Job Title
    Then I logout from the application
    And I login with valid Admin credentials
    Then I should be on the dashboard page
    When I navigate to Job Titles Page
    And I delete all the Job Titles in the Job Title Table
    Then I navigate to the PIM module
    And I delete all the employees from the employee list table
    Examples:
      | Job Title         | Job Description   | Note         | First Name | Middle Name | Last Name | Employee ID | Job Title         | Employee Name        | Updated Job Title | Username | Status  | Password      | Confirm Password |
      | Software Engineer | Develops software | Note details | Vijay      | Kumar       | Chadayan  | 1001        | Software Engineer | Vijay Kumar Chadayan | QA Engineer       | vijay123 | Enabled | Password@1234 | Password@1234    |

#########################################################################################################################################################################################################
