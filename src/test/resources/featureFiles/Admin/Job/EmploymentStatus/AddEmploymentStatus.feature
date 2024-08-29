@regression @employmentStatus
Feature: Add Employment Status Feature

  Background:
    Given I am on the OrangeHRM login page
    When I login with valid Admin credentials
    Then I am on the dashboard page
    And I navigate to Employment Status Page

#******************************************************************************************************************************************************************************************************************

  @smoke @sanity
  Scenario: Delete all Employment Status and Employees Data
      #    Delete all Employment Status
    And I delete all the Employment Status from the Employment Status Table
    Then I validate there are no Employment Status present in Employment Status Table
    And I validate 'No Records Found' Text is displayed
#    Delete all employees
    And I navigate to the PIM module
    And I delete all the employees from the employee list table
    Then I validate there are no employees present in PIM
#    And I validate '1 Record Found' Text is displayed

##******************************************************************************************************************************************************************************************************************

  @smoke
  Scenario Outline: Validate Employment Status Input Field with Various Data Types
    Given I am on the Employment Status Page
    When I click on Add Button
    And I navigate to the Add Employment Status Page
    And I enter a valid "<Employment Status>" into the Employment Status field
    And I save the details
    Then the "<Employment Status>" should be successfully saved and displayed in the Employment Status Table
##    And the number of records displayed should also be increased
#
    Examples:
      | Employment Status        |
      | Full-Time                |
      | Consultant               |
      | 12345                    |
      | Project-Based Employment |
      | A                        |
      | Full-Time123             |

###******************************************************************************************************************************************************************************************************************

  Scenario Outline: Validate Error Message for Duplicate Employment Status Entry
    Given I am on the Add Employment Status Page
    And I enter an "<Employment Status>" that already exists
    Then I should get an "<error message>"

    Examples:
      | Employment Status | error message  |
      | Full-Time         | Already exists |

##******************************************************************************************************************************************************************************************************************

  Scenario Outline: Validate Error Message for Maximum Character Limit in Employment Status Field
    Given I am on the Add Employment Status Page
    And I enter an "<Employment Status>" of more than the permissible characters
    Then I should get an "<error message>"

    Examples:
      | Employment Status                                                                         | error message                   |
      | Temporary Employment Contract (if there's a known character limit, use that exact number) | Should not exceed 50 characters |

###******************************************************************************************************************************************************************************************************************

  Scenario Outline: Validate Employment Status Is Not Saved When Cancel Button Is Pressed
    Given I am on the Add Employment Status Page
    When I enter a valid "<Employment Status>" into the Employment Status field
    And I click on Cancel Button
    Then the "<Employment Status>" should not be added in the table

    Examples:
      | Employment Status |
      | Contract          |
###******************************************************************************************************************************************************************************************************************

  Scenario Outline: Adding an employment status and validating if the same appears in the PIM module while adding a new employee

    Given I am on the Add Employment Status Page
#    Adding a valid Employment Status
    When I enter a valid "<Employment Status>" into the Employment Status field
    And I save the details
    Then the "<Employment Status>" should be successfully saved and displayed in the Employment Status Table

#    Adding an employee
    When I navigate to the PIM module
    And I click on the Add Employee button
    And I enter all the employee details without login details "<First Name>", "<Middle Name>", "<Last Name>", "<Employee ID>"
    And I save the details
    Then I validate that I am on the Personal Details Page

#    Adding Employment status to the employee's profile
    Then I navigate to Job Page
    When I open the Employment Status dropdown in the Job Section
    And I select the "<Employment Status>" that I added from the Admin menu
    And I save the details
    Then I validate that the Employment Status "<Employment Status>" is displayed correctly in the employee's profile

    Examples:
      | First Name | Middle Name | Last Name | Employment Status | Employee ID |
      | Ajay       | Kumar       | Chadayan  | Part-Time         | 1001        |

