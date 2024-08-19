package com.orangehrm.pages.Admin.UserManagement.Users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UsersPageLocators {
    public UsersPageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[text()='System Users']")
    public WebElement systemUsersHeader;

    @FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div/input")
    public WebElement usernameInputBox;

    @FindBy(xpath = "//label[text()='User Role']/parent::div/following-sibling::div//i")
    public WebElement userRoleDropdown;

    @FindBy(xpath = "//label[text()='Employee Name']/parent::div/following-sibling::div//input")
    public WebElement employeeNameInputBox;

    @FindBy(xpath = "//label[text()='Status']/parent::div/following-sibling::div//i")
    public WebElement statusDropdown;

    @FindBy(xpath = "//button[@type='button' and text()=' Reset ']")
    public WebElement resetButton;

    @FindBy(xpath = "//button[@type='submit' and text()=' Search ']")
    public WebElement searchButton;

    @FindBy(xpath = "//button[@type='button' and text()=' Add ']")
    public WebElement addButton;

    @FindBy(xpath = "//button[@type='button' and text()=' Add ']")
    public WebElement usersAddButton;

    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6[text()='Add User']")
    public WebElement addUserTitle;

    @FindBy(xpath = "//label[text()='Password']/parent::div/following-sibling::div//input")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//label[text()='Confirm Password']/parent::div/following-sibling::div//input")
    public WebElement confirmPasswordInputBox;

    @FindBy(xpath = "//h6[text()='Edit User']")
    public WebElement editUserHeader;

    @FindBy(xpath = "//*[text()='Yes']")
    public WebElement changePasswordCheckbox;

    @FindBy(xpath = "//div[@class='oxd-table']")
    public WebElement usersTable;

    @FindBy(xpath = "//div[@role='row' and .//ancestor::div[@class='oxd-table-body']]")
    public List<WebElement> allUsersListInTable;

    @FindBy(xpath = "//div[@class='oxd-table-header']//div[@class='oxd-checkbox-wrapper']")
    public WebElement selectAllUsersCheckbox;

    @FindBy(xpath = "//button[@type='button' and text()=' Delete Selected ']")
    public WebElement deleteSelectedButton;

    @FindBy(xpath = "//div[@class='oxd-table-header']")
    public WebElement usersTableHeaderRow;

    @FindBy(xpath = "//label[text()='Status']/parent::div/following-sibling::div//i")
    public WebElement userStatusDropdown;

    @FindBy(xpath = "//button[@type='button' and text()=' Cancel ']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[@type='submit' and text()=' Save ']")
    public WebElement saveButton;
}
