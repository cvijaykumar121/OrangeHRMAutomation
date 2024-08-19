package com.orangehrm.pages.PIM.EmployeeList.ContactDetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsLocators {
    public ContactDetailsLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Street 1']")
    public WebElement street1InputHeader;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and ./../preceding-sibling::div/label[text()='Street 1']]")
    public WebElement street1Input;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Street 2']")
    public WebElement street2InputHeader;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and ./../preceding-sibling::div/label[text()='Street 2']]")
    public WebElement street2Input;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='City']")
    public WebElement cityInputHeader;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and ./../preceding-sibling::div/label[text()='City']]")
    public WebElement cityInput;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='State/Province']")
    public WebElement stateInputHeader;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and ./../preceding-sibling::div/label[text()='State/Province']]")
    public WebElement stateInput;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Zip/Postal Code']")
    public WebElement zipInputHeader;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and ./../preceding-sibling::div/label[text()='Zip/Postal Code']]")
    public WebElement zipInput;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Country']")
    public WebElement countryInputHeader;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and ./../preceding-sibling::div/label[text()='Country']]")
    public WebElement countryInput;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Home']")
    public WebElement homeInputHeader;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and ./../preceding-sibling::div/label[text()='Home']]")
    public WebElement homeInput;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Mobile']")
    public WebElement mobileInputHeader;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and ./../preceding-sibling::div/label[text()='Mobile']]")
    public WebElement mobileInput;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Work']")
    public WebElement workInputHeader;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and ./../preceding-sibling::div/label[text()='Work']]")
    public WebElement workInput;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Work Email']")
    public WebElement workEmailInputHeader;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and ./../preceding-sibling::div/label[text()='Work Email']]")
    public WebElement workEmailInput;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Other Email']")
    public WebElement otherEmailInputHeader;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and ./../preceding-sibling::div/label[text()='Other Email']]")
    public WebElement otherEmailInput;

}
