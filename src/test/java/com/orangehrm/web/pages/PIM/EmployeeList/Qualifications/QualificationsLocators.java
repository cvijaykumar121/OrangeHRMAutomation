package com.orangehrm.web.pages.PIM.EmployeeList.Qualifications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QualificationsLocators {
    public QualificationsLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Work Experience']/following-sibling::button")
    public WebElement workExperienceAddButton;

    @FindBy(xpath = "//label[text()='Company']/parent::div/following-sibling::div/input")
    public WebElement companyInputBox;

    @FindBy(xpath = "//label[text()='Job Title']/parent::div/following-sibling::div/input")
    public WebElement jobTitleInputBox;

    @FindBy(xpath = "//label[text()='From']/parent::div/following-sibling::div//input")
    public WebElement fromInputBox;

    @FindBy(xpath = "//label[text()='To']/parent::div/following-sibling::div//input")
    public WebElement toInputBox;

    @FindBy(xpath = "//h6[text()='Education']/following-sibling::button")
    public WebElement educationAddButton;

    @FindBy(xpath = "//label[text()='Level']/parent::div/following-sibling::div//i")
    public WebElement levelDropdown;

    @FindBy(xpath = "//label[text()='Institute']/parent::div/following-sibling::div/input")
    public WebElement instituteInputBox;

    @FindBy(xpath = "//label[text()='Major/Specialization']/parent::div/following-sibling::div/input")
    public WebElement majorInputBox;

    @FindBy(xpath = "//label[text()='Year']/parent::div/following-sibling::div/input")
    public WebElement yearInputBox;

    @FindBy(xpath = "//label[text()='GPA/Score']/parent::div/following-sibling::div/input")
    public WebElement gpaInputBox;

    @FindBy(xpath = "//label[text()='Start Date']/parent::div/following-sibling::div//input")
    public WebElement startDateInputBox;

    @FindBy(xpath = "//label[text()='End Date']/parent::div/following-sibling::div//input")
    public WebElement endDateInputBox;

    @FindBy(xpath = "//h6[text()='Skills']/following-sibling::button")
    public WebElement skillsAddButton;

    @FindBy(xpath = "//label[text()='Skill']/parent::div/following-sibling::div//i")
    public WebElement skillDropdown;

    @FindBy(xpath = "//label[text()='Years of Experience']/parent::div/following-sibling::div/input")
    public WebElement yearsOfExperienceInputBox;

    @FindBy(xpath = "//h6[text()='Languages']/following-sibling::button")
    public WebElement languagesAddButton;

    @FindBy(xpath = "//label[text()='Language']/parent::div/following-sibling::div//i")
    public WebElement languageDropdown;

    @FindBy(xpath = "//label[text()='Fluency']/parent::div/following-sibling::div//i")
    public WebElement fluencyDropdown;

    @FindBy(xpath = "//label[text()='Competency']/parent::div/following-sibling::div//i")
    public WebElement competencyDropdown;

    @FindBy(xpath = "//h6[text()='License']/following-sibling::button")
    public WebElement licenseAddButton;

    @FindBy(xpath = "//label[text()='License Type']/parent::div/following-sibling::div//i")
    public WebElement licenseTypeDropdown;

    @FindBy(xpath = "//label[text()='License Number']/parent::div/following-sibling::div/input")
    public WebElement licenseNumberInputBox;

    @FindBy(xpath = "//label[text()='Issued Date']/parent::div/following-sibling::div//input")
    public WebElement issuedDateInputBox;

    @FindBy(xpath = "//label[text()='Expiry Date']/parent::div/following-sibling::div//input")
    public WebElement expiryDateInputBox;
}
