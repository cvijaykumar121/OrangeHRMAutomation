package com.orangehrm.pages.PIM.AddEmployee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeeLocators {
    public AddEmployeeLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item' and text()='Add Employee']")
    public WebElement addEmployeeNavButton;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
    public WebElement addEmployeeHeader;

    @FindBy(xpath = "//label[@class='oxd-label oxd-input-field-required']")
    public WebElement employeeFullNameText;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-firstname']")
    public WebElement firstNameInputBox;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-middlename']")
    public WebElement middleNameInputBox;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-lastname']")
    public WebElement lastNameInputBox;

    @FindBy(xpath = "//label[text()='Employee Id']")
    public WebElement employeeIdText;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and .//../preceding-sibling::div/label[text()='Employee Id']]")
    public WebElement employeeIdInputBox;

    @FindBy(xpath = "//p[text()='Create Login Details']/parent::div//child::span")
    public WebElement createLoginDetailsCheckbox;

    @FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div/input")
    public WebElement usernameInputBox;

    @FindBy(xpath = "//div[@class='oxd-radio-wrapper']/label[text()='Enabled']/span")
    public WebElement enabledRadioButton;

    @FindBy(xpath = "//div[@class='oxd-radio-wrapper']/label[text()='Disabled']/span")
    public WebElement disabledRadioButton;

    @FindBy(xpath = "//label[text()='Password']/parent::div/following-sibling::div/input")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//label[text()='Confirm Password']/parent::div/following-sibling::div/input")
    public WebElement confirmPasswordInputBox;

    @FindBy(xpath = "//div[@class='oxd-form-actions']/button[@type='submit' and text()=' Save ']")
    public WebElement addEmployeeSaveButton;

    @FindBy(xpath = "//div[@class='oxd-form-actions']/button[@type='button' and text()=' Cancel ']")
    public WebElement addEmployeeCancelButton;
}
