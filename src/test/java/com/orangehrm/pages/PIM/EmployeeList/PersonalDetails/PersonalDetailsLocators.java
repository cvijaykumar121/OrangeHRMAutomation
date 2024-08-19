package com.orangehrm.pages.PIM.EmployeeList.PersonalDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PersonalDetailsLocators {
    public PersonalDetailsLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' and text()='Personal Details']")
    public WebElement personalDetailsHeader;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 --strong']")
    public WebElement nameOfUser;

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

    @FindBy(xpath = "//label[text()='Other Id']")
    public WebElement otherIdInputText;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and .//../preceding-sibling::div/label[text()='Other Id']]")
    public WebElement otherIdInputBox;

    @FindBy(xpath = "//label[text()=\"Driver's License Number\"]")
    public WebElement driverLicenseNumberInputText;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and .//../preceding-sibling::div/label[text()=\"Driver's License Number\"]]")
    public WebElement driverLicenseNumberInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//label[text()='Nationality']")
    public WebElement nationalityInputText;

    @FindBy(xpath = "//div[@class='oxd-select-text-input' and .//../../../preceding-sibling::div/label[text()='Nationality']]")
    public WebElement nationalityDropdown;

    @FindBy(xpath = "//label[text()='Marital Status']")
    public WebElement maritalStatusInputText;

    @FindBy(xpath = "//div[@class='oxd-select-text-input' and .//../../../preceding-sibling::div/label[text()='Marital Status']]")
    public WebElement maritalStatusDropdown;

    @FindBy(xpath = "//div[@role='listbox']/*")
    public List<WebElement> dropdownListElements;

    @FindBy(xpath = "//label[text()='License Expiry Date']")
    public WebElement licenseExpiryDateInputText;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and .//../../../preceding-sibling::div/label[text()='License Expiry Date']]")
    public WebElement licenseExpiryDateInputBox;

    @FindBy(xpath = "//label[text()='Date of Birth']")
    public WebElement dateOfBirthInputText;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and .//../../../preceding-sibling::div/label[text()='Date of Birth']]")
    public WebElement dateOfBirthInputBox;

    @FindBy(xpath = "//label[text()='Gender']")
    public WebElement genderInputText;

    @FindBy(xpath = "//input[@type='radio' and ./parent::label[text()='Male']]")
    public WebElement maleRadioButton;

    @FindBy(xpath = "//input[@type='radio' and ./parent::label[text()='Female']]")
    public WebElement femaleRadioButton;

    @FindBy(xpath = "(//div[@class='oxd-radio-wrapper'])[1]/label[text()='Male']")
    public WebElement maleRadioButtonText;

    @FindBy(xpath = "(//div[@class='oxd-radio-wrapper'])[1]/label[text()='Female']")
    public WebElement femaleRadioButtonText;

    @FindBy(xpath = "//p[text()=' * Required']")
    public WebElement requiredText;

    @FindBy(xpath = "//h6[text()='Custom Fields']")
    public WebElement customFieldsText;

    @FindBy(xpath = "//h6[text()='Attachments']")
    public WebElement attachmentsHeader;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--text' and ./preceding-sibling::h6[text()='Attachments']]")
    public WebElement attachmentsAddButton;

    @FindBy(xpath = "//label[text()='Select File']")
    public WebElement selectFileInputText;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-input-hint' and text()='Accepts upto 1 MB']")
    public WebElement acceptsUpTo1MBText;

    @FindBy(xpath = "//label[text()='Comment']")
    public WebElement commentInputText;

    @FindBy(xpath = "//div[@class='oxd-file-button' and text()='Browse']")
    public WebElement browseButton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-upload oxd-file-input-icon']")
    public WebElement uploadIcon;

    @FindBy(xpath = "//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
    public WebElement commentBox;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost' and text()=' Cancel ']")
    public WebElement cancelButton;
}
