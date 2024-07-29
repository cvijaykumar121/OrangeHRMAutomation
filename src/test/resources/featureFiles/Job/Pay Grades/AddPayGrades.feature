Feature: Add Pay Grades Feature

  Background:
    Given I am on the OrangeHRM login page
    Then I login with valid Admin credentials and I am on the dashboard page
    Then I navigate to Add Job Titles Page


  Scenario Outline: Validating if the user is able to add a valid PayGrade with valid Currency details
    Given I login with valid Admin credentials and I am on the dashboard page
    Then I navigate to Add Pay Grades Page
    And I add a "<Pay grade>" and save it
    Then I add "<Currency>" to that Pay grade and save it "<Minimum Salary>" "<Maximum Salary>"

    Examples:
      | Pay grade | Currency           | Minimum Salary | Maximum Salary |
      | Grade 8   | INR - Indian Rupee | 2000           | 5000           |

