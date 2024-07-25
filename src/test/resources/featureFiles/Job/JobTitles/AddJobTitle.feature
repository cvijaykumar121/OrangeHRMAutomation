Feature: Add Job Title Feature

  Background:
    Given I am on the OrangeHRM login page
    Then I login with valid Admin credentials and I am on the dashboard page
    Then I navigate to Add Job Titles Page


  Scenario: Validating if all the elements in the Add Job Title Page are present correctly
    And I should be able to see all the UI elements are placed correctly on the page


  Scenario Outline: Validating if the user is able to Add a Job Title by entering all the valid details
    Then I should be able to add a job title successfully by entering all the valid details "<Job Title>" "<Job Description>" and "<Note>" in the page
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


  Scenario: Validating if the error is displayed if the user is Adding a Job Title with all empty fields
    Then I should see the Required error message displayed in the Job Titles Text Field

  Scenario Outline: Validating if the error is displayed if the user enters a Job Description of more than 400 characters
    Then I should get an error message in the "<Error Validation Field>" that more than 400 characters are not allowed "<Job Title>" "<Job Description>" and "<Note>"
    Examples:
      | Job Title         | Job Description                                                                                                                                                                                                                                                                                                                                                                                                       | Note                                                                                                                                                                                                                                                                                                                                                                                                                  | Error Validation Field |
      | Software Engineer | In the serene countryside, where the gentle whispers of the wind rustling through the lush, emerald-green leaves of the ancient oak trees create a symphony of natural melodies, there exists a quaint, centuries-old stone cottage, its weathered walls adorned with a tapestry of ivy and vibrant, blooming flowers, where the scent of freshly baked bread wafts through the air, enticing the senses and evolving | Note details                                                                                                                                                                                                                                                                                                                                                                                                          | Job Description        |
      | Software Engineer | Very long Note validation                                                                                                                                                                                                                                                                                                                                                                                             | In the serene countryside, where the gentle whispers of the wind rustling through the lush, emerald-green leaves of the ancient oak trees create a symphony of natural melodies, there exists a quaint, centuries-old stone cottage, its weathered walls adorned with a tapestry of ivy and vibrant, blooming flowers, where the scent of freshly baked bread wafts through the air, enticing the senses and evolving | Note                   |

  Scenario Outline: Adding a job title and validating if the same job title appears in the PIM module while adding a new employee
    Then I should be able to add a job title successfully by entering all the valid details "<Job Title>" "<Job Description>" and "<Note>" in the page
    When I navigate to the PIM module
    And I click on the Add Employee button and enter all the employee details without Login Details "<First Name>" "<Middle Name>" "<Last Name>" "<Employee ID>"
    And I navigate to Job Page
    And I open the Job Title dropdown in Job Section and I select the same "<Job Title>" that I added from Admin menu
    Examples:
      | Job Title         | Job Description   | Note         | First Name | Middle Name | Last Name | Employee ID | Job Title         |
      | Software Engineer | Develops software | Note details | Vijay      | Kumar       | Chadayan  | 1001        | Software Engineer |






