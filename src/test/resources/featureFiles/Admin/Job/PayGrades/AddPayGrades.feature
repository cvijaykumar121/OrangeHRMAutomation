Feature: Add Pay Grades Feature

  Background:
    Given I am on the OrangeHRM login page
    Then I login with valid Admin credentials
    And I should be on the dashboard page
    Then I navigate to Add Pay Grades Page

    Scenario Outline: Validating if the user is able to Add a Pay Grade by entering all the valid details
      Given I delete all the Pay Grades in the Pay Grades Table
      When I add a "<Pay Grade>" by entering valid Pay Grade
      And I click on Save Button
      Then I add "<Currency>" for the Pay Grade "<Minimum Salary>" "<Maximum Salary>"
      And I click on Save Button
      Then I validate that the Pay Grade and the associated Currency is successfully added into the system
      Examples:
        | Job Title         | Job Description                            | Note                                 |
        | Software Engineer | Develops software                          | Note details                         |
        | QA Engineer!@#    | QA engineer                                | Note details                         |
        | Project Manager   |                                            |                                      |
        | QA Engineer 123   | Job title with numeric characters          | Sample note                          |
        | Engineer2         | Job title with alphanumeric characters     | Sample note                          |
        | Senior Developer  | Job Title with spaces                      |                                      |
        | Lead QA           | Job Title with leading and trailing spaces | Sample note                          |
        | DevOps Engineer   |                                            | Job Title with blank Job Description |
