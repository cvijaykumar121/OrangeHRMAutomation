package com.orangehrm.web.pages.Admin.UserManagement.Users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPageLocators {
    public UsersPageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//nav[@aria-label='Topbar Menu']//span[text()='User Management ']")
    public WebElement userManagementNavButton;

    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li/a[text()='Users']")
    public WebElement usersLink;

    @FindBy(xpath = "//h5[text()='System Users']")
    public WebElement systemUsersHeader;

    @FindBy(xpath = "//button[@type='submit' and text()=' Search ']")
    public WebElement searchButton;

    @FindBy(xpath = "//h6[text()='Edit User']")
    public WebElement editUserHeader;

//    @FindBy(xpath = "//div[@class='oxd-input-group__label-wrapper' and ./child::label[contains(text(),'Change')]]/following-sibling::div//input[@type='checkbox']")
//    public WebElement changePasswordCheckbox;

    @FindBy(xpath = "//*[text()='Yes']")
    public WebElement changePasswordCheckbox;

    @FindBy(xpath = "//div[@class='oxd-table']")
    public WebElement usersTable;

    @FindBy(xpath = "//label[text()='Status']/parent::div/following-sibling::div//i")
    public WebElement userStatusDropdown;
}
