package com.orangehrm.web.StepDefinitions.Admin.UserManagement;

import com.orangehrm.web.StepDefinitions.Hooks;
import com.orangehrm.web.base.StepDefinition;
import com.orangehrm.web.pages.Admin.Job.JobTitle.JobTitlePage;
import com.orangehrm.web.pages.Admin.UserManagement.Users.UsersPage;
import com.orangehrm.web.pages.PIM.AddEmployee.AddEmployee;
import com.orangehrm.web.pages.PIM.EmployeeList.EmployeeInformation.EmployeeInformationPage;
import com.orangehrm.web.pages.SideMenu.SideMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.commons.math3.geometry.partitioning.Side;

public class UserFeatures {
    @Then("I navigate to User Management in Admin menu")
    public void navigate_To_Users_Page_In_Admin_Menu() {
        Hooks hooks = new Hooks();
        SideMenu sideMenu = new SideMenu(hooks.getDriver());
        UsersPage usersPage = new UsersPage(hooks.getDriver());

        sideMenu.clickOnAdminLink();
        usersPage.click_On_Users_From_User_Management_Dropdown();
        usersPage.validate_System_Users_Header();
    }

    @And("I search for the same employee in User Search by username that I added in PIM {string}")
    public void search_For_Employee_In_User_Search_By_Username(String username) {
        Hooks hooks = new Hooks();
        AddEmployee addEmployee = new AddEmployee(hooks.getDriver());
        UsersPage usersPage = new UsersPage(hooks.getDriver());

        addEmployee.enterUsername(username);
        usersPage.click_On_Search_Button();
        usersPage.validate_User_Is_Displayed_In_Table(username);
    }

    @Then("I click on Edit option for the employee {string}")
    public void click_On_Edit_Option_For_Employee(String username) {
        Hooks hooks = new Hooks();
        UsersPage usersPage = new UsersPage(hooks.getDriver());
        usersPage.click_On_Edit_Button_For_Username(username);
        usersPage.validate_Edit_User_Page();
    }

    @And("I change the password for that employee {string} {string}")
    public void change_Password_For_Employee(String changedPassword, String confirmPassword) {
        Hooks hooks = new Hooks();
        UsersPage usersPage = new UsersPage(hooks.getDriver());
        AddEmployee addEmployee = new AddEmployee(hooks.getDriver());

        usersPage.click_On_ChangePassword_Yes_Checkbox();
        addEmployee.enterPassword(changedPassword);
        addEmployee.enterConfirmPassword(confirmPassword);
        addEmployee.clickOnSaveButton();

        usersPage.validate_System_Users_Header();
    }

    @Then("I delete the employee and validate that the employee is removed from PIM {string}")
    public void click_On_Delete_Option_For_Employee(String username) {
        Hooks hooks = new Hooks();
        UsersPage usersPage = new UsersPage(hooks.getDriver());
        JobTitlePage jobTitlePage = new JobTitlePage(hooks.getDriver());
        SideMenu sideMenu = new SideMenu(hooks.getDriver());
        StepDefinition stepDefinition = new StepDefinition(hooks.getDriver());

        sideMenu.clickOnPIMLink();
        usersPage.click_On_Delete_Button_For_Username(username);
        stepDefinition.handle_Delete_Pop_Up(true);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I select the status of the employee account as {string} and save")
    public void select_the_status_of_the_employee_account_as_enabled_and_save(String status) {
        Hooks hooks = new Hooks();
        UsersPage usersPage = new UsersPage(hooks.getDriver());
        AddEmployee addEmployee = new AddEmployee(hooks.getDriver());

        usersPage.select_the_status_of_the_employee_account_from_dropdown(status);
        addEmployee.clickOnSaveButton();

        usersPage.validate_System_Users_Header();
    }

    @And("I click on Add Button to add a User")
    public void click_on_Add_Button_In_User_Management_Page() {
        Hooks hooks = new Hooks();
        UsersPage usersPage = new UsersPage(hooks.getDriver());
        usersPage.click_on_Add_Button();
        usersPage.validate_Add_User_Title();
    }

    @Then("I enter all the details and add the user into the system through User Management {string} {string} {string} {string} {string} {string}")
    public void enter_all_details_and_add_user_into_the_system_through_User_Management(String userRole, String employeeName, String status, String username, String password, String confirmPassword) {
        Hooks hooks = new Hooks();
        UsersPage usersPage = new UsersPage(hooks.getDriver());

        usersPage.selectUserRole(userRole);
        usersPage.enterEmployeeName(employeeName);
        usersPage.select_the_status_of_the_employee_account_from_dropdown(status);
        usersPage.enterUsername(username);
        usersPage.enterPassword(password);
        usersPage.enterConfirmPassword(confirmPassword);
        usersPage.click_On_Save_Button();

        usersPage.validate_System_Users_Header();
    }

    @And("I delete all the Users from the Users List table")
    public void delete_all_users_from_users_list_table() {
        Hooks hooks = new Hooks();
        UsersPage usersPage = new UsersPage(hooks.getDriver());
        usersPage.deleteAllUsersFromUsersTable();
    }
}
