@login @regression
Feature: Login End To End Testing

  Background:
    Given I am on the OrangeHRM login page
    And I login with valid Admin credentials
    Then I should be on the "dashboard" page
    When I navigate to the PIM module

    @smoke @sanity
  Scenario: Delete all employees from PIM
    And I delete all the employees from the employee list table
    Then I validate there are no employees present in PIM
    When I navigate to User Management in Admin menu
    And I delete all the Users from the Users List table

  @smoke
  Scenario Outline: Employee Account Creation

  # Add an employee with login credentials of an ESS user
    And I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Status>" "<Password>" "<Confirm Password>"
    And I save the details
    Then I validate that I am on the Personal Details Page
    And I logout from the application

# Login with the ESS user
    When I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
#    And I validate that I am on the Personal Details Page
    Then I validate that the user should be able to access only the features that an ESS user can have
    And I logout from the application

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | Username | Status  | Password      | Confirm Password |
      | Vijay      | Kumar       | Chadayan  | 1001        | vijay123 | Enabled | Password@1234 | Password@1234    |

#########################################################################################################################################################################################################

  @currentRun
  Scenario Outline: Change Password for Employees

# Add an employee with login credentials of an ESS user
    When I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Status>" "<Password>" "<Confirm Password>"
    And I save the details
    Then I validate that I am on the Personal Details Page
    And I navigate to User Management in Admin menu

# Search for the employee added in PIM
    Then I search for the same employee in User Search by username that I added in PIM "<Username>"
    And I click on Edit option for the employee "<Username>"

# Change password for the employee
    And I change the password for that employee "<Changed Password>" "<Confirm Password>"

# Check login with the changed password
    And I logout from the application
    When I login as the same employee that I changed the password "<Username>" "<Changed Password>"
    Then I validate whether I am able to login with the updated password or not

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | Username | Status  | Password      | Confirm Password | Changed Password | Employee Name       |
      | Ajay       | Kumar       | Chadayan  | 1001        | ajay123  | Enabled | Password@1234 | Password@1234    | Password@1234    | Ajay Kumar Chadayan |

#########################################################################################################################################################################################################

  Scenario Outline: Validating if the user is getting "Account Disabled" message if the Status of the account is selected as disabled

# Add a new employee and select status as disabled
    When I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "Disabled" "<Password>" "<Confirm Password>"
    And I save the details
    Then I validate that I am on the Personal Details Page

#    Login with the same employee and validate if "disabled" error message is displayed
    And I logout from the application
    And I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
    Then I should get an error message that the account is disabled

# Select status as enabled
    When I login with valid Admin credentials
    Then I am on the dashboard page
    When I navigate to User Management in Admin menu
    Then I search for the same employee in User Search by username that I added in PIM "<Username>"
    And I click on Edit option for the employee "<Username>"
    And I select the status of the employee account as "Enabled" and save

#  Login with the same employee and validate if the user is able to login successfully
    When I logout from the application
    And I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
    And I am on the dashboard page
    Then I validate that the user should be able to access only the features that an ESS user can have

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | Username   | Password      | Confirm Password | Employee Name       |
      | Bhaskar    | Kumar       | Gupta     | 1001        | bhaskar123 | Password@1234 | Password@1234    | Bhaskar Kumar Gupta |

########################################################################################################################################################################################################

  @smoke
  Scenario: Logout Functionality for Security For Admin User
    And I logout from the application
    Then I am on the OrangeHRM login page

##########################################################################################################################################################################################################

  @smoke
  Scenario Outline: Logout Functionality for Security For ESS User
#    Adding an employee and log out
    And I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "Enabled" "<Password>" "<Confirm Password>"
    And I save the details
    Then I validate that I am on the Personal Details Page
    And I logout from the application

#    Login with same employee and validate that the user is able to logout
    When I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
    And I logout from the application
    Then I am on the OrangeHRM login page

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | Username   | Password      | Confirm Password |
      | Bhavesh    | Kumar       | Sahu      | 1001        | bhavesh123 | Password@1234 | Password@1234    |

##########################################################################################################################################################################################################

  Scenario Outline: Adding an employee in PIM without login details and then Adding login details in User Management for the same user

# Add an employee without Login details
    When I click on the Add Employee button
    And I enter all the employee details without login details: "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>"
    And I save the details
    Then I validate that I am on the Personal Details Page

# Add User with login details
    And I navigate to User Management in Admin menu
    And I click on Add Button to add a User
    And I enter all the details and add the user into the system through User Management "<User Role>" "<Employee Name>" "<Status>" "<Username>" "<Password>" "<Confirm Password>"
    And I save the details
    Then I validate that I am on the System Users Page

# Login as the same user that was added
    And I logout from the application
    When I login as the same user that was added through User Management "<Username>" "<Password>"
    Then I validate if the user is able to login successfully
    And I logout from the application

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | User Role | Employee Name     | Status  | Username  | Password      | Confirm Password |
      | Rahul      | Kumar       | Gupta     | 1001        | ESS       | Rahul Kumar Gupta | Enabled | rahul1234 | Password@1234 | Password@1234    |

##########################################################################################################################################################################################################

  @smoke
  Scenario Outline: Admin Account Creation

# Add an employee without the login credentials
    When I click on the Add Employee button
    And I enter all the employee details without login details: "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>"
    And I save the details
    Then I validate that I am on the Personal Details Page

    ## Add User with login details
    And I navigate to User Management in Admin menu
    And I click on Add Button to add a User
    Then I enter all the details and add the user into the system through User Management "<User Role>" "<Employee Name>" "<Status>" "<Username>" "<Password>" "<Confirm Password>"
    And I save the details
    Then I validate that I am on the System Users Page
    And I logout from the application

# Login with the Admin user that was created above
    When I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
    And I am on the dashboard page
    Then I validate that the user should be able to access all the features of an Admin User
    And I logout from the application

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | Username | Password      | Confirm Password | Employee Name    | User Role | Status  |
      | Ayush      | Kumar       | Saha      | 1001        | ayush123 | Password@1234 | Password@1234    | Ayush Kumar Saha | Admin     | Enabled |
