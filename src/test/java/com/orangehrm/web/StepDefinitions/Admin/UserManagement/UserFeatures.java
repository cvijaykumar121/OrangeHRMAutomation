package com.orangehrm.web.StepDefinitions.Admin.UserManagement;

import com.orangehrm.web.StepDefinitions.Hooks;
import com.orangehrm.web.pages.Admin.Job.JobTitle.JobTitlePage;
import com.orangehrm.web.pages.Admin.UserManagement.Users.UsersPage;
import com.orangehrm.web.pages.PIM.AddEmployee.AddEmployee;
import com.orangehrm.web.pages.SideMenu.SideMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class UserFeatures {
    @Then("I navigate to User Management in Admin menu")
    public void navigate_To_Users_Page_In_Admin_Menu() {
        SideMenu sideMenu = new SideMenu(Hooks.driver);
        UsersPage usersPage = new UsersPage(Hooks.driver);

        sideMenu.clickOnAdminLink();
        usersPage.click_On_Users_From_User_Management_Dropdown();
        usersPage.validate_System_Users_Header();
    }

    @And("I search for the same employee that I added in PIM {string}")
    public void search_For_Employee_In_PIM_By_Username(String username) {
        AddEmployee addEmployee = new AddEmployee(Hooks.driver);
        UsersPage usersPage = new UsersPage(Hooks.driver);

        addEmployee.enterUsername(username);
        usersPage.click_On_Search_Button();
        usersPage.validate_User_Is_Displayed_In_Table(username);
    }

    @Then("I click on Edit option for the employee {string}")
    public void click_On_Edit_Option_For_Employee(String username) {
        UsersPage usersPage = new UsersPage(Hooks.driver);
        usersPage.click_On_Edit_Button_For_Username(username);
        usersPage.validate_Edit_User_Page();
    }

    @And("I change the password for that employee {string} {string}")
    public void change_Password_For_Employee(String changedPassword, String confirmPassword) {
        UsersPage usersPage = new UsersPage(Hooks.driver);
        AddEmployee addEmployee = new AddEmployee(Hooks.driver);

        usersPage.click_On_ChangePassword_Yes_Checkbox();
        addEmployee.enterPassword(changedPassword);
        addEmployee.enterConfirmPassword(confirmPassword);
        addEmployee.clickOnSaveButton();

        usersPage.validate_System_Users_Header();
    }

    @Then("I delete the employee and validate that the employee is removed from PIM {string}")
    public void click_On_Delete_Option_For_Employee(String username) {
        UsersPage usersPage = new UsersPage(Hooks.driver);
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);

        usersPage.click_On_Delete_Button_For_Username(username);
        jobTitlePage.handle_Delete_Pop_Up(true);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I select the status of the employee account as {string} and save")
    public void select_the_status_of_the_employee_account_as_enabled_and_save(String status) {
        UsersPage usersPage = new UsersPage(Hooks.driver);
        AddEmployee addEmployee = new AddEmployee(Hooks.driver);

        usersPage.select_the_status_of_the_employee_account_from_dropdown(status);
        addEmployee.clickOnSaveButton();

        usersPage.validate_System_Users_Header();
    }
}
