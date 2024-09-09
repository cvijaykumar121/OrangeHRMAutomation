package com.orangehrm.StepDefinitions.PIM;

import com.orangehrm.StepDefinitions.Hooks.Hooks;
import com.orangehrm.pages.PIM.EmployeeList.EmployeeInformation.EmployeeInformationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EmployeeListFeature {
    @And("I click on Employee List Button")
    public void click_On_Employee_List_Button() {
        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(Hooks.driver);
        employeeInformationPage.click_On_Employee_List_Button();
    }

    @Then("I enter all details")
    public void enter_All_Details() {
        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(Hooks.driver);
        employeeInformationPage.enterEmployeeName("C Vijay Kumar");
        employeeInformationPage.enterEmployeeID("0410");
    }

    @And("click on Search button")
    public void click_On_Search_Button() {
        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(Hooks.driver);
        employeeInformationPage.clickOnSearchButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I delete all the employees from the employee list table")
    @Then("I validate there are no employees present in PIM")
    @Given("there are no employees in the employee table")
    public void delete_All_Employees_From_Employee_List_Table() {
        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(Hooks.driver);
        employeeInformationPage.deleteAllEmployeesFromPIM();
    }

    @Then("I search for the same employee in PIM that I added {string}")
    public void search_for_employee_in_PIM(String employeeFullName) {
        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(Hooks.driver);
        employeeInformationPage.enterEmployeeName(employeeFullName);
//        employeeInformationPage.enterEmployeeID(StepDefinition.employeeID);
        employeeInformationPage.clickOnSearchButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I validate that the user is displayed in the users table {string} {string} {string}")
    public void validate_that_user_is_displayed_in_users_table(String firstName, String middleName, String lastName) {
        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(Hooks.driver);
        employeeInformationPage.validate_User_Is_Displayed_After_Clicking_On_Search_Button(firstName, middleName, lastName);
    }

    @Then("I delete the employee and validate that the employee is removed from PIM {string} {string} {string}")
    public void delete_employee_from_PIM_and_validate_employee_is_removed_from_PIM(String firstName, String middleName, String lastName) {
        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(Hooks.driver);
        employeeInformationPage.delete_Employee_From_PIM(firstName, middleName, lastName);
    }

    @Then("I navigate to the employee details page {string} {string}")
    public void navigate_to_employee_details_page(String firstName, String middleName) {
        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(Hooks.driver);
        employeeInformationPage.edit_Employee_From_PIM(firstName, middleName);
    }

    @Then("I validate that the employee is added successfully")
    public void validate_Employee_Added_Successfully() {
        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(Hooks.driver);
    }

}
