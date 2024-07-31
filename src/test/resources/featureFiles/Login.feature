Feature: Login and Logout Feature

#  Scenario: Test Scenario
#    Given I login with valid Admin credentials and I am on the dashboard page
#    Then I navigate to the PIM module
#    And I click on the Employee List button
#    And I delete all the employees from the employee list table

#########################################################################################################################################################################################################
#
  Scenario: Validating if all the elements in the Login Page are present correctly
    Given I am on the OrangeHRM login page
    Then I should see the Login Header in the Login Page
    And I should see the Username and Password Headers
    And I should see the Username and Password fields
    And I should see the Forgot Password Link and all the footer elements
    And I should see the Login button

###########################################################################################################################################################################################################
#
#  Scenario Outline: Successful login with valid credentials
#    Given I am on the OrangeHRM login page
#    When I enter username "<username>" and password "<password>" and click on login button
#    Then I should see the Dashboard page
#
#    Examples:
#      | username | password |
#      | Admin    | admin123 |
#      | aDMin    | admin123 |
#
###########################################################################################################################################################################################################
#
#  Scenario Outline: Unsuccessful login with invalid credentials
#    Given I am on the OrangeHRM login page
#    When I enter username "<username>" and password "<password>" and click on login button
#    Then I should see the Invalid credentials error message
#
#    Examples:
#      | username    | password    |
#      | Admin       | Admin123    |
#      | Invalid     | Invalid     |
#      | Invalid     | admin123    |
#      | Admin       | Invalid     |
#      | Admin!@#    | admin123    |
#      | Admin       | admin123@%$ |
#      | ' OR '1'='1 | admin123    |
#
##########################################################################################################################################################################################################
#
#
#  Scenario Outline: Unsuccessful login with blank credentials
#    Given I am on the OrangeHRM login page
#    When I enter username "<username>" and password "<password>" and click on login button
#    Then I should see the Required error message
#
#    Examples:
#      | username | password |
#      | Admin    |          |
#      |          | admin123 |
#      |          |          |
#
#########################################################################################################################################################################################################
#
#  Scenario Outline: Employee Account Creation
#    Given I login with valid Admin credentials and I am on the dashboard page
#    Then I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Status>" "<Password>" "<Confirm Password>"
#    Then I logout from the application
#    And I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
##    And I validate that the user should be able to access only the features that an ESS user can have
#    Then I logout from the application
#    Then I login with valid Admin credentials and I am on the dashboard page
#    Then I navigate to the PIM module
#    Then I search for the same employee in PIM that I added "<Employee Name>" "<Employee ID>"
##    And I search for the same employee in User Search by username that I added in PIM "<Username>"
#    Then I validate that the user is displayed in the users table "<First Name>" "<Middle Name>" "<Last Name>"
#    Then I delete the employee and validate that the employee is removed from PIM "<First Name>" "<Middle Name>" "<Last Name>"
#
#    Examples:
#      | First Name | Middle Name | Last Name | Employee ID | Username | Status  | Password      | Confirm Password | Employee Name        |
#      | Vijay      | Kumar       | Chadayan  | 1001        | vijay123 | Enabled | Password@1234 | Password@1234    | Vijay Kumar Chadayan |
#
##########################################################################################################################################################################################################
#
#  Scenario Outline: Change Password for Employees
#    Given I login with valid Admin credentials and I am on the dashboard page
#    Then I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Status>" "<Password>" "<Confirm Password>"
#    Then I navigate to User Management in Admin menu
#    And I search for the same employee in User Search by username that I added in PIM "<Username>"
#    Then I click on Edit option for the employee "<Username>"
#    And I change the password for that employee "<Changed Password>" "<Confirm Password>"
#
##    To check whether I am able to login with the changed password or not
#    Then I logout from the application
#    And I login as the same employee that I changed the password and check whether I am able to login with the updated password or not "<Username>" "<Changed Password>"
#
##    Deleting the employee after performing all the validations
#    Then I logout from the application
#    Then I login with valid Admin credentials and I am on the dashboard page
#    Then I navigate to the PIM module
#    Then I search for the same employee in PIM that I added "<Employee Name>" "<Employee ID>"
#    Then I delete the employee and validate that the employee is removed from PIM "<First Name>" "<Middle Name>" "<Last Name>"
#
#    Examples:
#      | First Name | Middle Name | Last Name | Employee ID | Username | Status  | Password      | Confirm Password | Changed Password | Employee Name        |
#      | Vijay      | Kumar       | Chadayan  | 1001        | vijay123 | Enabled | Password@1234 | Password@1234    | Password@1234    | Vijay Kumar Chadayan |
#
##########################################################################################################################################################################################################
#
#  Scenario Outline: Validating if the user is getting "Account Disabled" message if the Status of the account is selected as disabled
#    Given I login with valid Admin credentials and I am on the dashboard page
#    Then I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Disabled Status>" "<Password>" "<Confirm Password>"
#    Then I logout from the application
#    And I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
#    Then I should get an error message that the account is disabled
#
#    Then I login with valid Admin credentials and I am on the dashboard page
#    Then I navigate to User Management in Admin menu
#    And I search for the same employee in User Search by username that I added in PIM "<Username>"
#    Then I click on Edit option for the employee "<Username>"
#    Then I select the status of the employee account as "<Enabled Status>" and save
#
#    Then I logout from the application
#    And I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
##    And I validate that the user should be able to access only the features that an ESS user can have
#    Then I should see the Dashboard page
#
#    # Deleting the employee after performing all the validations
#    Then I logout from the application
#    Then I login with valid Admin credentials and I am on the dashboard page
#    Then I navigate to the PIM module
#    Then I search for the same employee in PIM that I added "<Employee Name>" "<Employee ID>"
#    Then I delete the employee and validate that the employee is removed from PIM "<First Name>" "<Middle Name>" "<Last Name>"
#
#    Examples:
#      | First Name | Middle Name | Last Name | Employee ID | Username | Disabled Status | Password      | Confirm Password | Enabled Status | Employee Name        |
#      | Vijay      | Kumar       | Chadayan  | 1001        | vijay123 | Disabled        | Password@1234 | Password@1234    | Enabled        | Vijay Kumar Chadayan |
#
###########################################################################################################################################################################################################
#
#  Scenario: Logout Functionality for Security For Admin User
#    Given I login with valid Admin credentials and I am on the dashboard page
#    Then I logout from the application
#
#  Scenario Outline: Logout Functionality for Security For ESS User
#    Given I login with valid Admin credentials and I am on the dashboard page
#    Then I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Disabled Status>" "<Password>" "<Confirm Password>"
#    Then I logout from the application
#
#    Examples:
#      | First Name | Middle Name | Last Name | Employee ID | Username | Disabled Status | Password      | Confirm Password |
#      | Vijay      | Kumar       | Chadayan  | 1001        | vijay123 | Disabled        | Password@1234 | Password@1234    |
#
###########################################################################################################################################################################################################
#
