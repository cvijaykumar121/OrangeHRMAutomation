package com.orangehrm.pages.Admin.Organization.GeneralInformation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralInformationLocators {
    public GeneralInformationLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/h6[text()='General Information']")
    public WebElement generalInformationTitle;

    @FindBy(xpath = "//h6[text()='Education']/following-sibling::div/button")
    public WebElement educationAddButton;

    @FindBy(xpath = "//label[text()='Edit']/parent::div//child::span")
    public WebElement editSwitchButton;

    @FindBy(xpath = "//label[text()='Organization Name']/parent::div/following-sibling::div/input")
    public WebElement organizationNameInputBox;

    @FindBy(xpath = "//label[text()='Registration Number']/parent::div/following-sibling::div/input")
    public WebElement registrationNumberInputBox;

    @FindBy(xpath = "//label[text()='Tax ID']/parent::div/following-sibling::div/input")
    public WebElement taxIDInputBox;

    @FindBy(xpath = "//label[text()='Phone']/parent::div/following-sibling::div/input")
    public WebElement phoneInputBox;

    @FindBy(xpath = "//label[text()='Fax']/parent::div/following-sibling::div/input")
    public WebElement faxInputBox;

    @FindBy(xpath = "//label[text()='Email']/parent::div/following-sibling::div/input")
    public WebElement emailInputBox;

    @FindBy(xpath = "//label[text()='Address Street 1']/parent::div/following-sibling::div/input")
    public WebElement addressStreet1InputBox;

    @FindBy(xpath = "//label[text()='Address Street 2']/parent::div/following-sibling::div/input")
    public WebElement addressStreet2InputBox;

    @FindBy(xpath = "//label[text()='City']/parent::div/following-sibling::div/input")
    public WebElement cityInputBox;

    @FindBy(xpath = "//label[text()='State/Province']/parent::div/following-sibling::div/input")
    public WebElement stateInputBox;

    @FindBy(xpath = "//label[text()='Zip/Postal Code']/parent::div/following-sibling::div/input")
    public WebElement zipInputBox;

    @FindBy(xpath = "//label[text()='Country']/parent::div/following-sibling::div//i")
    public WebElement countryDropdown;

    @FindBy(xpath = "//label[text()='Level']/parent::div/following-sibling::div/input")
    public WebElement levelInputBox;

    @FindBy(xpath = "//label[text()='Notes']/parent::div/following-sibling::div/textarea")
    public WebElement notesInputBox;

    @FindBy(xpath = "//button[@type='submit' and text()=' Save ']")
    public WebElement saveButton;
}
