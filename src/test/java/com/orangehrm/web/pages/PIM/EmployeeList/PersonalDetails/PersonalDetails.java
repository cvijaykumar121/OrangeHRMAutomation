package com.orangehrm.web.pages.PIM.EmployeeList.PersonalDetails;
import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class PersonalDetails extends TestBase {
    public WebDriver driver;
    public PersonalDetailsLocators personalDetailsLocators;

    public PersonalDetails(WebDriver driver) {
        this.driver = driver;
        this.personalDetailsLocators = new PersonalDetailsLocators(driver);
    }

    public void validate_Personal_Details_Header() {
        waitForElementToBeVisible(personalDetailsLocators.personalDetailsHeader, 50, "Successfully navigated to Personal Details Page");
    }

    public void validate_All_Headers_And_Input_Boxes_In_Personal_Details_Page() {
        Map<WebElement, String> inputHeaders = new HashMap<>();
        inputHeaders.put(personalDetailsLocators.employeeFullNameText, "Employee Full Name");
        inputHeaders.put(personalDetailsLocators.employeeIdText, "Employee Id");
        inputHeaders.put(personalDetailsLocators.otherIdInputText, "Other Id");
        inputHeaders.put(personalDetailsLocators.driverLicenseNumberInputText, "Driver's License Number");
        inputHeaders.put(personalDetailsLocators.licenseExpiryDateInputText, "License Expiry Date");
        inputHeaders.put(personalDetailsLocators.nationalityInputText, "Nationality");
        inputHeaders.put(personalDetailsLocators.maritalStatusInputText, "Marital Status");
        inputHeaders.put(personalDetailsLocators.dateOfBirthInputText, "Date of Birth");
        inputHeaders.put(personalDetailsLocators.genderInputText, "Gender");
        inputHeaders.put(personalDetailsLocators.maleRadioButtonText, "Male Radio Button");
        inputHeaders.put(personalDetailsLocators.femaleRadioButtonText, "Female Radio Button");
        inputHeaders.put(personalDetailsLocators.requiredText, " * Required");
        inputHeaders.put(personalDetailsLocators.customFieldsText, "Custom Fields");
        inputHeaders.put(personalDetailsLocators.attachmentsHeader, "Attachments");
        inputHeaders.put(personalDetailsLocators.selectFileInputText, "Select File");
        inputHeaders.put(personalDetailsLocators.acceptsUpTo1MBText, "Accepts upto 1 MB");


        for (Map.Entry<WebElement, String> entry : inputHeaders.entrySet()) {
            validateText(entry.getKey(), entry.getValue(), "Validated " + entry.getValue() + " Header Text successfully", 20);
        }

        Map<WebElement, String> inputBoxes = new HashMap<>();
        inputBoxes.put(personalDetailsLocators.firstNameInputBox, "First Name Input Box");
        inputBoxes.put(personalDetailsLocators.middleNameInputBox, "Middle Name Input Box");
        inputBoxes.put(personalDetailsLocators.lastNameInputBox, "Last Name Input Box");
        inputBoxes.put(personalDetailsLocators.employeeIdInputBox, "Employee Id Input Box");
        inputBoxes.put(personalDetailsLocators.otherIdInputBox, "Other ID input box");
        inputBoxes.put(personalDetailsLocators.driverLicenseNumberInputBox, "Driver's license number input box");
        inputBoxes.put(personalDetailsLocators.nationalityDropdown, "Nationality Dropdown");
        inputBoxes.put(personalDetailsLocators.maritalStatusDropdown, "Marital Status Dropdown");
        inputBoxes.put(personalDetailsLocators.dateOfBirthInputBox, "Date Of Birth Input Box");
        inputBoxes.put(personalDetailsLocators.maleRadioButton, "Male Radio Button");
        inputBoxes.put(personalDetailsLocators.femaleRadioButton, "Female Radio Button");
        inputBoxes.put(personalDetailsLocators.saveButton, "Save button");
        inputBoxes.put(personalDetailsLocators.browseButton, "Browse button");
        inputBoxes.put(personalDetailsLocators.uploadIcon, "Upload icon");
        inputBoxes.put(personalDetailsLocators.commentBox, "Comment Input Box");


        for (Map.Entry<WebElement, String> entry : inputBoxes.entrySet()) {
            waitForElementToBeVisible(entry.getKey(), 20, entry.getValue() + " is visible");
        }
    }

    public void validate_Name_Of_User_Is_Shown_Correctly() {
        String nameOfUser = personalDetailsLocators.nameOfUser.getText();
        String firstName = personalDetailsLocators.firstNameInputBox.getText();
        String lastName = personalDetailsLocators.lastNameInputBox.getText();

        String fullName = firstName + lastName;
        if(nameOfUser.equals(fullName)) {
            logInfo("Name of the user is shown correctly in the Personal details page", true);
        } else {
            logFail("Name of the user is not shown correctly in the Personal details page", true);
        }
    }

    public void enterEmployeeFullName(String firstName, String middleName, String lastName) {
        sendKeys(personalDetailsLocators.firstNameInputBox, firstName, "Entered first name successfully", 10);
        sendKeys(personalDetailsLocators.middleNameInputBox, middleName, "Entered middle name successfully", 10);
        sendKeys(personalDetailsLocators.lastNameInputBox, lastName, "Entered last name successfully", 10);
    }

    public void enterEmployeeId(String employeeId) {
        sendKeys(personalDetailsLocators.employeeIdInputBox, employeeId, "Entered Employee ID successfully", 10);
    }

    public void enterOtherID(String otherId) {
        sendKeys(personalDetailsLocators.otherIdInputBox, otherId, "Entered Other ID successfully", 10);
    }

    public void enterDriverLicenseNumber(String licenseNumber) {
        sendKeys(personalDetailsLocators.otherIdInputBox, licenseNumber, "Entered License Number successfully", 10);
    }

    public void enterLicenseExpiryDate(String licenseExpiryDate) {
        sendKeys(personalDetailsLocators.otherIdInputBox, licenseExpiryDate, "Entered License Expiry Date successfully", 10);
    }

    public void select_Nationality_Option_From_Dropdown(String nationality) {
        selectOptionFromDropdown(personalDetailsLocators.nationalityDropdown, nationality, "Nationality " + nationality + " selected successfully", 20);
    }

    public void select_Marital_Status_From_Dropdown(String maritalStatus) {
        selectOptionFromDropdown(personalDetailsLocators.maritalStatusDropdown, maritalStatus, "Marital Status " + maritalStatus + " selected successfully", 20);
    }

    public void selectGender(String gender) {
        if(gender.equalsIgnoreCase("Male")) {
            clickElement(personalDetailsLocators.maleRadioButton, "Male Option selected successfully", true, 20);
        } else if(gender.equalsIgnoreCase("Female")) {
            clickElement(personalDetailsLocators.femaleRadioButton, "Female Option selected successfully", true, 20);
        }
    }

    public void clickOnSaveButton() {
        clickElement(personalDetailsLocators.saveButton, "Save Button clicked successfully", true, 20);
    }

    public void clickOnCancelButton() {
        clickElement(personalDetailsLocators.cancelButton, "Cancel Button clicked successfully", true, 20);
    }

    public void clickOnAddAttachmentButton() {
        clickElement(personalDetailsLocators.attachmentsAddButton, "Add attachment button clicked successfully", true, 20);
    }

    public void enterComment(String comment) {
        sendKeys(personalDetailsLocators.commentBox, comment, "Comment entered successfully", 20);
    }
}
