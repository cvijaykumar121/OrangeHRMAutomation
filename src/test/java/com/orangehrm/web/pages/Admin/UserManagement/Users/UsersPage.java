package com.orangehrm.web.pages.Admin.UserManagement.Users;
import com.orangehrm.web.StepDefinitions.Admin.Job.JobTitles.AddJobTitleFeature;
import com.orangehrm.web.base.TestBase;
import com.orangehrm.web.pages.PIM.AddEmployee.AddEmployeeLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsersPage extends TestBase {
    public WebDriver driver;
    public UsersPageLocators usersPageLocators;
    public AddEmployeeLocators addEmployeeLocators;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        this.usersPageLocators = new UsersPageLocators(driver);
        this.addEmployeeLocators = new AddEmployeeLocators(driver);
    }

    private void click_On_UserManagement_NavButton() {
        clickElement(usersPageLocators.userManagementNavButton, "Successfully clicked on Users link", true, 20);
    }

    public void click_On_Users_From_User_Management_Dropdown() {
        click_On_UserManagement_NavButton();
        clickElement(usersPageLocators.usersLink, "Successfully clicked on Users link", true, 20);
    }

    public void validate_System_Users_Header() {
        validateText(usersPageLocators.systemUsersHeader, "System Users", "Successfully validated System user header", 20);
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
        WebElement user = driver.findElement(By.xpath("//div[@role='table']//div[@class='oxd-table-card']/div//div[text()='" + username + "']"));
        validateText(user, username, "Successfully validated user in the table", 30);
    }

    public void click_On_Edit_Button_For_Username(String username) {
        WebElement editButton = driver.findElement(By.xpath("//div[@role='table']//div[@class='oxd-table-card']/div//div[text()='" + username + "']/parent::div/following-sibling::div/div[@class='oxd-table-cell-actions']//i[@class='oxd-icon bi-pencil-fill']"));
        clickElement(editButton, "Edit button for " + username + " is clicked", true, 20);
    }

    public void validate_Edit_User_Page() {
        validateText(usersPageLocators.editUserHeader, "Edit User", "Successfully validated Edit User Page", 50);
    }

    public void click_On_ChangePassword_Yes_Checkbox() {
        clickElement(usersPageLocators.changePasswordCheckbox, "Successfully clicked on Change Password Checkbox", true, 30);
    }

    public void click_On_Delete_Button_For_Username(String username) {
        WebElement deleteButton = driver.findElement(By.xpath("//div[@role='table']//div[@class='oxd-table-card']/div//div[text()='" + username + "']/parent::div/following-sibling::div/div[@class='oxd-table-cell-actions']//i[@class='oxd-icon bi-trash']"));
        clickElement(deleteButton, "Delete button for " + username + " is clicked", true, 20);
        waitForElementToBeVisible(usersPageLocators.usersTable, 50);
    }

    public void select_the_status_of_the_employee_account_from_dropdown(String status) {
        selectOptionFromDropdown(usersPageLocators.userStatusDropdown, status, "Successfully selected the status", 30);
    }

}
