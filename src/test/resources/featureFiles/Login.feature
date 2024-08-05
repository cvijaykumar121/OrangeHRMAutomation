Feature: Login and Logout Feature

#######################################################################################################################################################################################################

  Scenario: Validating if all the elements in the Login Page are present correctly
    Given I am on the OrangeHRM login page
    Then I should see the Login Header in the Login Page
    And I should see the Username and Password Headers
    And I should see the Username and Password fields
    And I should see the Forgot Password Link and all the footer elements
    And I should see the Login button

##########################################################################################################################################################################################################

  Scenario Outline: Successful login with valid credentials
    Given I am on the OrangeHRM login page
    When I enter username "<username>" and password "<password>" and click on login button
    Then I should see the Dashboard page

    Examples:
      | username | password |
      | Admin    | admin123 |
      | aDMin    | admin123 |

#########################################################################################################################################################################################################

  Scenario Outline: Unsuccessful login with invalid credentials
    Given I am on the OrangeHRM login page
    When I enter username "<username>" and password "<password>" and click on login button
    Then I should see the Invalid credentials error message

    Examples:
      | username    | password    |
      | Admin       | Admin123    |
      | Invalid     | Invalid     |
      | Invalid     | admin123    |
      | Admin       | Invalid     |
      | Admin!@#    | admin123    |
      | Admin       | admin123@%$ |
      | ' OR '1'='1 | admin123    |

########################################################################################################################################################################################################


  Scenario Outline: Unsuccessful login with blank credentials
    Given I am on the OrangeHRM login page
    When I enter username "<username>" and password "<password>" and click on login button
    Then I should see the Required error message

    Examples:
      | username | password |
      | Admin    |          |
      |          | admin123 |
      |          |          |

######################################################################################################################################################################################################

  Scenario Outline: Employee Account Creation

#    Delete All Employees
    Given I login with valid Admin credentials and I am on the dashboard page
    Then I navigate to the PIM module
    And I delete all the employees from the employee list table

#    Add an employee with login credentials of an ESS user
    Then I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Status>" "<Password>" "<Confirm Password>"
    Then I logout from the application

#    Login with the ESS user
    And I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
    And I validate that the user should be able to access only the features that an ESS user can have
    Then I logout from the application

#    Delete the ESS user
    Then I login with valid Admin credentials and I am on the dashboard page
    Then I navigate to the PIM module
    Then I search for the same employee in PIM that I added "<Employee Name>"
    Then I validate that the user is displayed in the users table "<First Name>" "<Middle Name>" "<Last Name>"
    Then I delete the employee and validate that the employee is removed from PIM "<First Name>" "<Middle Name>" "<Last Name>"

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | Username | Status  | Password      | Confirm Password | Employee Name        |
      | Vijay      | Kumar       | Chadayan  | 1001        | vijay123 | Enabled | Password@1234 | Password@1234    | Vijay Kumar Chadayan |

#########################################################################################################################################################################################################

  Scenario Outline: Change Password for Employees

#    Log in
    Given I login with valid Admin credentials and I am on the dashboard page
    Then I navigate to the PIM module

#    Delete All Employees
    And I delete all the employees from the employee list table

#   Add an employee with login credentials of an ESS user
    Then I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Status>" "<Password>" "<Confirm Password>"
    Then I navigate to User Management in Admin menu

#    Search for the employee added in PIM
    And I search for the same employee in User Search by username that I added in PIM "<Username>"
    Then I click on Edit option for the employee "<Username>"

#    Change password for the employee
    And I change the password for that employee "<Changed Password>" "<Confirm Password>"

#    To check whether I am able to login with the changed password or not
    Then I logout from the application
    And I login as the same employee that I changed the password and check whether I am able to login with the updated password or not "<Username>" "<Changed Password>"

#    Deleting the employee after performing all the validations
    Then I logout from the application
    Then I login with valid Admin credentials and I am on the dashboard page
    Then I navigate to the PIM module
    Then I search for the same employee in PIM that I added "<Employee Name>"
    Then I delete the employee and validate that the employee is removed from PIM "<First Name>" "<Middle Name>" "<Last Name>"

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | Username | Status  | Password      | Confirm Password | Changed Password | Employee Name       |
      | Ajay       | Kumar       | Chadayan  | 1001        | ajay123  | Enabled | Password@1234 | Password@1234    | Password@1234    | Ajay Kumar Chadayan |

###########################################################################################################################################################################################################

  Scenario Outline: Validating if the user is getting "Account Disabled" message if the Status of the account is selected as disabled

#    Log in
    Given I login with valid Admin credentials and I am on the dashboard page
    Then I navigate to the PIM module

#    Delete All Employees
    And I delete all the employees from the employee list table

#    Add a new employee and select status as disabled
    Then I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Disabled Status>" "<Password>" "<Confirm Password>"
    Then I logout from the application
    And I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
    Then I should get an error message that the account is disabled

#    Select status as enabled
    Then I login with valid Admin credentials and I am on the dashboard page
    Then I navigate to User Management in Admin menu
    And I search for the same employee in User Search by username that I added in PIM "<Username>"
    Then I click on Edit option for the employee "<Username>"
    Then I select the status of the employee account as "<Enabled Status>" and save

    Then I logout from the application
    And I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
    And I validate that the user should be able to access only the features that an ESS user can have
    Then I should see the Dashboard page

    # Deleting the employee after performing all the validations
    Then I logout from the application
    Then I login with valid Admin credentials and I am on the dashboard page
    Then I navigate to the PIM module
    Then I search for the same employee in PIM that I added "<Employee Name>"
    Then I delete the employee and validate that the employee is removed from PIM "<First Name>" "<Middle Name>" "<Last Name>"

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | Username   | Disabled Status | Password      | Confirm Password | Enabled Status | Employee Name       |
      | Bhaskar    | Kumar       | Gupta     | 1001        | bhaskar123 | Disabled        | Password@1234 | Password@1234    | Enabled        | Bhaskar Kumar Gupta |

##########################################################################################################################################################################################################

  Scenario: Logout Functionality for Security For Admin User
    Given I login with valid Admin credentials and I am on the dashboard page
    Then I logout from the application

##########################################################################################################################################################################################################

  Scenario Outline: Logout Functionality for Security For ESS User
    Given I login with valid Admin credentials and I am on the dashboard page
    Then I add an employee in PIM along with their login credentials "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>" "<Username>" "<Disabled Status>" "<Password>" "<Confirm Password>"
    Then I logout from the application

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | Username | Disabled Status | Password      | Confirm Password |
      | Vijay      | Kumar       | Chadayan  | 1001        | vijay123 | Disabled        | Password@1234 | Password@1234    |

##########################################################################################################################################################################################################

  Scenario Outline: Adding an employee in PIM without login details and then Adding login details in User Management for the same user

#    Login
    Given I login with valid Admin credentials and I am on the dashboard page
    Then I navigate to the PIM module

#    Delete All Employees
    And I delete all the employees from the employee list table

#    Add an employee without Login details
    And I click on the Add Employee button and enter all the employee details without Login Details "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>"

#    Delete All Users
    Then I navigate to User Management in Admin menu
    And I delete all the Users from the Users List table

#    Add User with login details
    And I click on Add Button to add a User
    Then I enter all the details and add the user into the system through User Management "<User Role>" "<Employee Name>" "<Status>" "<Username>" "<Password>" "<Confirm Password>"

#    Login as the same user that was added
    And I logout from the application
    Then I login as the same user that was added through User Management and validate if the user is able to login successfully "<Username>" "<Password>"
    Then I logout from the application

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | User Role | Employee Name     | Status  | Username  | Password      | Confirm Password |
      | Rahul      | Kumar       | Gupta     | 1001        | ESS       | Rahul Kumar Gupta | Enabled | rahul1234 | Password@1234 | Password@1234    |

#########################################################################################################################################################################################################

  Scenario Outline: Admin Account Creation

#    Delete All Employees
    Given I login with valid Admin credentials and I am on the dashboard page
    Then I navigate to the PIM module
    And I delete all the employees from the employee list table

#    Add an employee with login credentials of an ESS user
    And I click on the Add Employee button and enter all the employee details without Login Details "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>"

    Then I navigate to User Management in Admin menu
    And I delete all the Users from the Users List table

    And I click on Add Button to add a User
    Then I enter all the details and add the user into the system through User Management "<User Role>" "<Employee Name>" "<Status>" "<Username>" "<Password>" "<Confirm Password>"
    Then I logout from the application

#    Login with the Admin user
    And I login as the same employee that I added in PIM as an Admin "<Username>" "<Password>"
    And I validate that the user should be able to access all the features of an Admin User
    Then I logout from the application

#    Delete the ESS user
    Then I login with valid Admin credentials and I am on the dashboard page
    Then I navigate to the PIM module
    Then I search for the same employee in PIM that I added "<Employee Name>"
    Then I validate that the user is displayed in the users table "<First Name>" "<Middle Name>" "<Last Name>"
    Then I delete the employee and validate that the employee is removed from PIM "<First Name>" "<Middle Name>" "<Last Name>"

    Examples:
      | First Name | Middle Name | Last Name | Employee ID | Username | Password      | Confirm Password | Employee Name    | User Role | Status  |
      | Ayush      | Kumar       | Saha      | 1001        | ayush123 | Password@1234 | Password@1234    | Ayush Kumar Saha | Admin     | Enabled |

