package com.orangehrm.web.pages.PIM.EmployeeList.EmergencyContacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmergencyContactsLocators {
    public EmergencyContactsLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Assigned Emergency Contacts']/following-sibling::button")
    public WebElement assignedEmergencyContactsAddButton;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement nameInputBox;

    @FindBy(xpath = "//label[text()='Relationship']/parent::div/following-sibling::div/input")
    public WebElement relationshipInputBox;

    @FindBy(xpath = "//label[text()='Home Telephone']/parent::div/following-sibling::div/input")
    public WebElement homeTelephoneInputBox;

    @FindBy(xpath = "//label[text()='Mobile']/parent::div/following-sibling::div/input")
    public WebElement mobileInputBox;

    @FindBy(xpath = "//label[text()='Work Telephone']/parent::div/following-sibling::div/input")
    public WebElement workTelephone;

}
