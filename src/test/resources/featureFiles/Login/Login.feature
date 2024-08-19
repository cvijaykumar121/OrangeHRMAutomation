Feature: Login and Logout Feature

  Background:
    Given I am on the OrangeHRM login page
#######################################################################################################################################################################################################

  Scenario: Validating if all the elements in the Login Page are present correctly
    Then I should see the Login Header in the Login Page
    And I should see the Username and Password Headers
    And I should see the Username and Password fields
    And I should see the Forgot Password Link and all the footer elements
    And I should see the Login button

##########################################################################################################################################################################################################

  Scenario Outline: Successful login with valid credentials
    When I enter username "<Admin Username>"
    And I enter password "<Admin Password>"
    And I click the "Login" Button
    Then I should be on the "Dashboard" page

    Examples:
      | Admin Username | Admin Password |
      | Admin          | admin123       |
      | aDMin          | admin123       |

###########################################################################################################################################################################################################

  Scenario Outline: Unsuccessful login with invalid credentials
    When I enter username "<Admin Username>"
    And I enter password "<Admin Password>"
    And I click the "Login" Button
    Then I should see the "Invalid credentials" error message

    Examples:
      | Admin Username | Admin Password |
      | Admin          | Admin123       |
      | Invalid        | Invalid        |
      | Invalid        | admin123       |
      | Admin          | Invalid        |
      | Admin!@#       | admin123       |
      | Admin          | admin123@%$    |
      | ' OR '1'='1    | admin123       |

#########################################################################################################################################################################################################

  Scenario Outline: Unsuccessful login with blank credentials
    When I enter username "<Admin Username>"
    And I enter password "<Admin Password>"
    And I click the "Login" Button
    Then I should see the "Required" error message

    Examples:
      | Admin Username | Admin Password |
      | Admin          |                |
      |                | admin123       |
      |                |                |

######################################################################################################################################################################################################
