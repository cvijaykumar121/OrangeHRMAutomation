package com.orangehrm.pages.Admin.UserManagement.Users;

import com.orangehrm.base.TestBase;
import com.orangehrm.pages.Admin.AdminTopNavMenu.AdminTopNavMenuLocators;
import com.orangehrm.pages.Admin.Job.JobTitle.JobTitlePage;
import com.orangehrm.base.Locators;
import com.orangehrm.base.StepDefinition;
import com.orangehrm.pages.PIM.AddEmployee.AddEmployeeLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsersPage extends TestBase {
    public WebDriver driver;
    public UsersPageLocators usersPageLocators;
    public AddEmployeeLocators addEmployeeLocators;
    public AdminTopNavMenuLocators adminTopNavMenuLocators;
    public Locators locators;
    public JobTitlePage jobTitlePage;
    public StepDefinition stepDefinition;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        this.usersPageLocators = new UsersPageLocators(driver);
        this.addEmployeeLocators = new AddEmployeeLocators(driver);
        this.adminTopNavMenuLocators = new AdminTopNavMenuLocators(driver);
        this.locators = new Locators(driver);
        this.jobTitlePage = new JobTitlePage(driver);
        this.stepDefinition = new StepDefinition(driver);
    }

    private void click_On_UserManagement_NavButton() {
        clickElement(adminTopNavMenuLocators.userManagementNavButton, "Successfully clicked on Users link", true, 20);
    }

    public void click_On_Users_From_User_Management_Dropdown() {
        click_On_UserManagement_NavButton();
        clickElement(adminTopNavMenuLocators.usersLink, "Successfully clicked on Users link", true, 20);
    }

    public void validate_System_Users_Header() {
        validateText(usersPageLocators.systemUsersHeader, "System Users", "Successfully validated System user header", 20);
    }

    public void selectUserRole(String userRole) {
        selectOptionFromDropdown(usersPageLocators.userRoleDropdown, userRole, "Selected " + userRole + " from User role dropdown", 30);
    }

    public void enterEmployeeName(String employeeName) {
        sendKeys(usersPageLocators.employeeNameInputBox, employeeName, "Entered employee name: " + employeeName, 30);
        selectOptionFromDropdown(employeeName, "Employee Name selected");
    }

    public void enterUsername(String username) {
        sendKeys(usersPageLocators.usernameInputBox, username, "Entered username: " + username, 30);
    }

    public void enterPassword(String password) {
        sendKeys(usersPageLocators.passwordInputBox, password, "Entered password: " + password, 30);
    }

    public void enterConfirmPassword(String confirmPassword) {
        sendKeys(usersPageLocators.confirmPasswordInputBox, confirmPassword, "Entered confirm password: " + confirmPassword, 30);
    }

    public void click_On_Save_Button() {
        clickElement(locators.saveButton, "Clicked on save button", true, 30);
    }

    public void click_On_Cancel_Button() {
        clickElement(locators.cancelButton, "Clicked on Cancel button", true, 30);
    }

    public void click_On_Search_Button() {
        clickElement(usersPageLocators.searchButton, "Successfully clicked on search button", true, 20);
    }

    public void validate_User_Is_Displayed_In_Table(String username) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement user = driver.findElement(By.xpath("//div[@role='table']//div[@class='oxd-table-card']/div//div[text()='" + username + "']" ));
        validateText(user, username, "Successfully validated user in the table", 30);
    }

    public void click_On_Edit_Button_For_Username(String username) {
        WebElement editButton = driver.findElement(By.xpath("//div[@role='table']//div[@class='oxd-table-card']/div//div[text()='" + username + "']/parent::div/following-sibling::div/div[@class='oxd-table-cell-actions']//i[@class='oxd-icon bi-pencil-fill']" ));
        clickElement(editButton, "Edit button for " + username + " is clicked", true, 20);
    }

    public void validate_Edit_User_Page() {
        validateText(usersPageLocators.editUserHeader, "Edit User", "Successfully validated Edit User Page", 50);
    }

    public void click_On_ChangePassword_Yes_Checkbox() {
        clickElement(usersPageLocators.changePasswordCheckbox, "Successfully clicked on Change Password Checkbox", true, 30);
    }

    public void click_On_Delete_Button_For_Username(String username) {
        WebElement deleteButton = driver.findElement(By.xpath("//div[@role='table']//div[@class='oxd-table-card']/div//div[text()='" + username + "']/parent::div/following-sibling::div/div[@class='oxd-table-cell-actions']//i[@class='oxd-icon bi-trash']" ));
        clickElement(deleteButton, "Delete button for " + username + " is clicked", true, 20);
        waitForElementToBeVisible(usersPageLocators.usersTable, 50);
    }

    public void select_the_status_of_the_employee_account_from_dropdown(String status) {
        selectOptionFromDropdown(usersPageLocators.userStatusDropdown, status, "Successfully selected the status", 30);
    }

    public void click_on_Add_Button() {
        clickElement(usersPageLocators.addButton, "Clicked on Add User button", true, 30);
    }

    public void validate_Add_User_Title() {
        validateText(usersPageLocators.addUserTitle, "Add User", "Validated Add User Title", 30);
    }

    public void deleteAllUsersFromUsersTable() {
        while (isElementPresent(usersPageLocators.allUsersListInTable)) {
            if (usersPageLocators.allUsersListInTable.size() > 1) {
                clickElement(usersPageLocators.selectAllUsersCheckbox, "Clicked on select all users checkbox", true, 30);
                clickElement(usersPageLocators.deleteSelectedButton, "Clicked on delete selected button", true, 30);
                stepDefinition.handle_Delete_Pop_Up(true);

                try {
                    Thread.sleep(5000);  // Waiting for deletion to complete, consider using explicit wait instead
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                logInfo("Only 1 user present, cannot be deleted further", true);
                break;
            }
        }
    }
}
