package com.orangehrm.pages.PIM.AddEmployee;
import com.orangehrm.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEmployee extends TestBase {
    public WebDriver driver;
    public AddEmployeeLocators addEmployeeLocators;

    public AddEmployee(WebDriver driver) {
        this.driver = driver;
        this.addEmployeeLocators = new AddEmployeeLocators(driver);
    }

    public WebElement validate_Add_Employee_Nav_Button() {
        WebElement addEmployeeNavButton = addEmployeeLocators.addEmployeeNavButton;
        waitForElementToBeClickable(addEmployeeNavButton, 5, "Add Employee Nav button is clickable");
        return addEmployeeNavButton;
    }

    public void clickOnAddEmployeeNavButton() {
        WebElement addEmployeeNavButton = validate_Add_Employee_Nav_Button();
        clickElement(addEmployeeNavButton, "Add Employee Nav button clicked successfully", true, 5);
    }

    public void validate_Add_Employee_Title_Page_Header() {
        WebElement addEmployeeHeader = addEmployeeLocators.addEmployeeHeader;
        waitForElementToBeVisible(addEmployeeHeader, 20);
        validateText(addEmployeeHeader, "Add Employee", "Validated Add Employee Heading successfully", 10);
    }

    public WebElement validate_First_Name_Input_Box_Is_Present() {
        WebElement workEmailInput = addEmployeeLocators.firstNameInputBox;
        waitForElementToBeVisible(workEmailInput, 10, "Validated First Name Input Box successfully");
        return workEmailInput;
    }

    public void enterFirstName(String firstName) {
//        WebElement firstNameInputBox = validate_First_Name_Input_Box_Is_Present();
        WebElement firstNameInputBox = addEmployeeLocators.firstNameInputBox;
        sendKeys(firstNameInputBox, firstName, "Successfully entered " + firstName + " into text box", 10);
    }

    public WebElement validate_Middle_Name_Input_Box_Is_Present() {
        WebElement workEmailInput = addEmployeeLocators.middleNameInputBox;
        waitForElementToBeVisible(workEmailInput, 10, "Validated Middle Name Input Box successfully");
        return workEmailInput;
    }

    public void enterMiddleName(String middleName) {
        WebElement middleNameInputBox = validate_Middle_Name_Input_Box_Is_Present();
        sendKeys(middleNameInputBox, middleName, "Successfully entered " + middleName + " into text box", 10);
    }

    public WebElement validate_Last_Name_Input_Box_Is_Present() {
        WebElement workEmailInput = addEmployeeLocators.lastNameInputBox;
        waitForElementToBeVisible(workEmailInput, 10, "Validated Last Name Input Box successfully");
        return workEmailInput;
    }

    public void enterLastName(String lastName) {
        WebElement lastNameInputBox = validate_Last_Name_Input_Box_Is_Present();
        sendKeys(lastNameInputBox, lastName, "Successfully entered " + lastName + " into text box", 10);
    }

    public void validate_Employee_ID_Input_Text_Is_Present() {
        WebElement otherEmailInputText = addEmployeeLocators.employeeIdText;
        waitForElementToBeVisible(otherEmailInputText, 10);
        validateText(otherEmailInputText, "Employee Id", "Validated Employee ID input header successfully", 5);
    }

    public WebElement validate_Employee_ID_Input_Box_Is_Present() {
        WebElement workEmailInput = addEmployeeLocators.employeeIdInputBox;
        waitForElementToBeVisible(workEmailInput, 10, "Validated Work Email Input Box successfully");
        return workEmailInput;
    }

    public void enterEmployeeID(String employeeId) {
        WebElement employeeIdInputBox = validate_Employee_ID_Input_Box_Is_Present();
        employeeIdInputBox.clear();
        sendKeys(employeeIdInputBox, employeeId, "Successfully entered " + employeeId + " into text box", 10);
    }

    public void turnOnLoginDetailsCheckbox() {
        clickElement(addEmployeeLocators.createLoginDetailsCheckbox, "Create Login Details Checkbox is on", true, 30);
    }

    public void enterUsername(String username) {
        sendKeys(addEmployeeLocators.usernameInputBox, username, "Successfully entered username " + username, 30);
    }

    public void selectStatus(String status) {
        if(status.equalsIgnoreCase("enabled")) {
            clickElement(addEmployeeLocators.enabledRadioButton, "Successfully checked enabled", true, 30);
        } else if(status.equalsIgnoreCase("disabled")) {
            clickElement(addEmployeeLocators.disabledRadioButton, "Successfully checked disabled", true, 30);
        } else {
            logFail("Incorrect data provided", true);
        }
    }

    public void enterPassword(String password) {
        sendKeys(addEmployeeLocators.passwordInputBox, password, "Successfully entered password " + password, 30);
    }

    public void enterConfirmPassword(String confirmPassword) {
        sendKeys(addEmployeeLocators.confirmPasswordInputBox, confirmPassword, "Successfully entered confirm password " + confirmPassword, 30);
    }

    public void clickOnSaveButton() {
        clickElement(addEmployeeLocators.addEmployeeSaveButton, "Clicked on save button", true, 20);
    }

    public void clickOnCancelButton() {
        clickElement(addEmployeeLocators.addEmployeeCancelButton, "Clicked on Cancel button", true, 20);
    }

}
