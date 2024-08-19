Feature: Remove Job Title Feature

  Background:
    Given I am on the OrangeHRM login page
    When I login with valid Admin credentials
    Then I am on the dashboard page
    And I navigate to Job Titles Page

##########################################################################################################################################################################################################

  Scenario: Delete all Job Titles and Employees Data
#    Delete all Job Titles
    And I delete all the Job Titles in the Job Title Table
    Then I validate there are no Job Titles present in Job Titles Table
#    Delete all employees
    And I navigate to the PIM module
    And I delete all the employees from the employee list table
    Then I validate there are no employees present in PIM

##########################################################################################################################################################################################################

  Scenario: Deleting all the Job Titles and validating the Job Titles table is empty
#    Deleting all the Job Title that is already present
    And I delete all the Job Titles in the Job Title Table
    Then I validate 'No Records Found' Text is displayed
    And I validate that no Job Title is displayed in the Job Titles Table

########################################################################################################################################################################################################

  Scenario Outline: Validate Empty Job Title Dropdown and "No Records Found" Message After Deleting All Job Titles
    Given there are no Job Titles present in Job Titles Table

#    Adding an employee in PIM with their login credentials
    When I navigate to the PIM module
    And I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Status>" "<Password>" "<Confirm Password>"
    And I save the details
    When I navigate to Job Page
    Then I open the Job Title dropdown in Job Section and I validate that 'No Records Found' Message is displayed

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | Username | Status  | Password      | Confirm Password |
      | Vijay      | Kumar       | Chadayan  | 1001        | vijay123 | Enabled | Password@1234 | Password@1234    |

#########################################################################################################################################################################################################

  Scenario Outline: Validate Empty Job Title Selection in Employee Profile After Admin Deletes All Job Titles

    Given there are no Job Titles present in Job Titles Table
#    Adding an employee in PIM with their login credentials
    When I navigate to the PIM module
    Then I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Status>" "<Password>" "<Confirm Password>"
    And I save the details
    Then I validate that I am on the Personal Details Page

#    Logout and login as employee
    Then I logout from the application
    And I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
    Then I am on the dashboard page

#    Validate No Job Title displayed in the Job Title Input Box
    When I navigate to My Info Page
    And I navigate to Job Page
    Then I should see that no Job Title is displayed in the Job Title Input Box

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | Username | Status  | Password      | Confirm Password |
      | Vijay      | Kumar       | Chadayan  | 1001        | vijay123 | Enabled | Password@1234 | Password@1234    |

##########################################################################################################################################################################################################################################

  Scenario Outline: Validate Job Title Text Displays 'Deleted' After Job Title is Removed by Admin
    Given there are no Job Titles present in Job Titles Table

#      Adding a Job Title
    When I add a job title by entering all the valid details "<Job Title>" "<Job Description>" and "<Note>" in the page
    And I save the details
    Then I validate that the Job Title is displayed in the Job Title table "<Job Title>"

#    Adding employee
    When I navigate to the PIM module
    And I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Disabled Status>" "<Password>" "<Confirm Password>"
    And I save the details
    Then I validate that I am on the Personal Details Page

#    Add the employee with the job title that was added above
    When I navigate to Job Page
    And I open the Job Title dropdown in the Job Section
    And I select the "<Job Title>" that I added from the Admin menu
    And I save the selected Job Title
    Then I validate that the Job Title is displayed correctly in the employee's profile "<Job Title>"

#    Delete all the Job Titles
    And I navigate to Job Titles Page
    And I delete all the Job Titles in the Job Title Table

#    Validate Delete text displayed in Job Titles Input Box by Admin login
    When I navigate to the PIM module
    And I search for the same employee in PIM that I added "<Employee Name>"
    Then I validate that the user is displayed in the users table "<First Name>" "<Middle Name>" "<Last Name>"
    And I click on Edit option for the employee "<First Name>" "<Middle Name>"
    And I navigate to Job Page
    Then I validate that the 'Deleted' text is displayed in the "<Job Title>" Input Box

    #    Validate Delete text displayed in Job Titles Input Box by Employee login
    And I logout from the application
    Then I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
    When I navigate to My Info Page
    And I navigate to Job Page
    Then I validate that the 'Deleted' text is displayed in the "<Job Title>" Input Box

    Examples:
      | Job Title         | Job Description   | Note         | First Name | Middle Name | Last Name | Employee Name        | Employee ID | Job Title         | Username | Disabled Status | Password      | Confirm Password |
      | Software Engineer | Develops software | Note details | Vijay      | Kumar       | Chadayan  | Vijay Kumar Chadayan | 1001        | Software Engineer | vijay123 | Enabled         | Password@1234 | Password@1234    |

##########################################################################################################################################################################################################################################


