Feature: Add Work Shifts Feature

  Background:
    Given I am on the OrangeHRM login page
    When I login with valid Admin credentials
    Then I am on the dashboard page
    And I navigate to Work Shifts Page

  Scenario: Validating the Work shifts table header row elements are displayed correctly
    Then I validate all the column names of Work Shifts Table is displayed

#    Add an employee in the before tag
  @currentRun1 @failed
  Scenario Outline: Validating if the user is able to add a valid Work Shift
      # Add an employee with login credentials of an ESS user
    And I enter all the employee details without login details: "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>"
    And I save the details
    Then I validate that I am on the Personal Details Page

    When I navigate to Add Work Shift Page
    And I enter the "<Shift Name>" Shift Name
#    And I enter the Working Hours "<From>" "<To>"
    And I assign the Employees to the Working Hours
      | Employee Name        |
      | Vijay Kumar Chadayan |
    And I save the details
    Then I validate that after adding valid Work Shift, user is redirected to Work Shifts Page
#    Then I validate that the "<Employment Status> is added successfully in the table"
    Examples:
      | Shift Name | From     | To       | First Name | Middle Name | Last Name | Employee ID |
      | Demo       | 09:00 AM | 05:00 PM | Vijay      | Kumar       | Chadayan  | 1009        |