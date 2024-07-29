package com.orangehrm.web.pages.Admin.Organization.GeneralInformation;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;

public class GeneralInformationPage extends TestBase {
    public WebDriver driver;
    public GeneralInformationLocators generalInformationLocators;

    public GeneralInformationPage(WebDriver driver) {
        this.driver = driver;
        this.generalInformationLocators = new GeneralInformationLocators(driver);
    }

    public void validate_GeneralInformation_Header() {
        validateText(generalInformationLocators.generalInformationTitle, "General Information", "Validated general Information header", 30);
    }

    public void click_On_Edit_Button() {
        clickElement(generalInformationLocators.editSwitchButton, "Clicked on General Information edit button", true, 30);
    }

    public void enter_Organization_Name(String organizationName) {
        sendKeys(generalInformationLocators.organizationNameInputBox, organizationName, "Entered Organization Name: " + organizationName, 30);
    }

    public void enter_Registration_Number(String registrationNumber) {
        sendKeys(generalInformationLocators.registrationNumberInputBox, registrationNumber, "Entered Registration Number: " + registrationNumber, 30);
    }

    public void enter_Tax_ID(String taxId) {
        sendKeys(generalInformationLocators.taxIDInputBox, taxId, "Entered Tax ID: " + taxId, 30);
    }

    public void enter_Phone_Number(String phoneNumber) {
        sendKeys(generalInformationLocators.phoneInputBox, phoneNumber, "Entered Phone Number: " + phoneNumber, 30);
    }

    public void enter_Fax(String fax) {
        sendKeys(generalInformationLocators.faxInputBox, fax, "Entered Fax ID: " + fax, 30);
    }

    public void enter_Email_ID(String emailId) {
        sendKeys(generalInformationLocators.emailInputBox, emailId, "Entered Email ID: " + emailId, 30);
    }

    public void enter_Address_Street1(String address) {
        sendKeys(generalInformationLocators.addressStreet1InputBox, address, "Entered Address Street 1: " + address, 30);
    }

    public void enter_Address_Street2(String address) {
        sendKeys(generalInformationLocators.addressStreet2InputBox, address, "Entered address street 2: " + address, 30);
    }

    public void enter_City(String city) {
        sendKeys(generalInformationLocators.cityInputBox, city, "Entered City: " + city, 30);
    }

    public void enter_State(String state) {
        sendKeys(generalInformationLocators.stateInputBox, state, "Entered State Name: " + state, 30);
    }

    public void enter_Zip_Code(String zipCode) {
        sendKeys(generalInformationLocators.zipInputBox, zipCode, "Entered Zip Code: " + zipCode, 30);
    }

    public void selectCountry(String country) {
        selectOptionFromDropdown(generalInformationLocators.countryDropdown, country, "Selected " + country + " from dropdown", 20);
    }

    public void enterNotes(String notes) {
        sendKeys(generalInformationLocators.notesInputBox, notes, "Entered notes", 30);
    }

    public void click_On_Save_Button() {
        clickElement(generalInformationLocators.saveButton, "Clicked on Save Button", true, 30);
    }
}
