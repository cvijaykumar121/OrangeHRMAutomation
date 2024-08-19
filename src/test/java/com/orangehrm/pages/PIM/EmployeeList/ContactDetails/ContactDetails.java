package com.orangehrm.pages.PIM.EmployeeList.ContactDetails;
import com.orangehrm.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactDetails extends TestBase {
    public WebDriver driver;
    public ContactDetailsLocators contactDetailsLocators;

    public ContactDetails(WebDriver driver) {
        this.driver = driver;
        this.contactDetailsLocators = new ContactDetailsLocators(driver);
    }

    public void validate_Street1_Input_Text_Is_Present() {
        WebElement street1InputText = contactDetailsLocators.street1InputHeader;
        waitForElementToBeVisible(street1InputText, 10);
        validateText(street1InputText, "Street1", "Validated Street1 input header successfully", 5);
    }

    public WebElement validate_Street1_Input_Box_Is_Present() {
        WebElement street1Input = contactDetailsLocators.street1Input;
        waitForElementToBeVisible(street1Input, 10, "Validated Street1 Input Box successfully");
        return street1Input;
    }

    public void validate_Street2_Input_Text_Is_Present() {
        WebElement street2InputText = contactDetailsLocators.street2InputHeader;
        waitForElementToBeVisible(street2InputText, 10);
        validateText(street2InputText, "Street2", "Validated Street2 input header successfully", 5);
    }

    public WebElement validate_Street2_Input_Box_Is_Present() {
        WebElement street2Input = contactDetailsLocators.street2Input;
        waitForElementToBeVisible(street2Input, 10, "Validated Street2 Input Box successfully");
        return street2Input;
    }

    public void validate_City_Input_Text_Is_Present() {
        WebElement cityInputText = contactDetailsLocators.cityInputHeader;
        waitForElementToBeVisible(cityInputText, 10);
        validateText(cityInputText, "City", "Validated City input header successfully", 5);
    }

    public WebElement validate_City_Input_Box_Is_Present() {
        WebElement cityInput = contactDetailsLocators.cityInput;
        waitForElementToBeVisible(cityInput, 10, "Validated City Input Box successfully");
        return cityInput;
    }

    public void validate_State_Input_Text_Is_Present() {
        WebElement stateInputText = contactDetailsLocators.stateInputHeader;
        waitForElementToBeVisible(stateInputText, 10);
        validateText(stateInputText, "State/Province", "Validated State input header successfully", 5);
    }

    public WebElement validate_State_Input_Box_Is_Present() {
        WebElement stateInput = contactDetailsLocators.stateInput;
        waitForElementToBeVisible(stateInput, 10, "Validated State Input Box successfully");
        return stateInput;
    }

    public void validate_Zip_Input_Text_Is_Present() {
        WebElement zipInputText = contactDetailsLocators.zipInputHeader;
        waitForElementToBeVisible(zipInputText, 10);
        validateText(zipInputText, "Zip/Postal Code", "Validated Zip input header successfully", 5);
    }

    public WebElement validate_Zip_Input_Box_Is_Present() {
        WebElement zipInput = contactDetailsLocators.zipInput;
        waitForElementToBeVisible(zipInput, 10, "Validated Zip Input Box successfully");
        return zipInput;
    }

    public void validate_Country_Input_Text_Is_Present() {
        WebElement countryInputText = contactDetailsLocators.countryInputHeader;
        waitForElementToBeVisible(countryInputText, 10);
        validateText(countryInputText, "Country", "Validated Country input header successfully", 5);
    }

    public WebElement validate_Country_Input_Box_Is_Present() {
        WebElement countryInput = contactDetailsLocators.countryInput;
        waitForElementToBeVisible(countryInput, 10, "Validated Country Input Box successfully");
        return countryInput;
    }

    public void validate_Home_Input_Text_Is_Present() {
        WebElement homeInputText = contactDetailsLocators.homeInputHeader;
        waitForElementToBeVisible(homeInputText, 10);
        validateText(homeInputText, "Home", "Validated Home input header successfully", 5);
    }

    public WebElement validate_Home_Input_Box_Is_Present() {
        WebElement homeInput = contactDetailsLocators.homeInput;
        waitForElementToBeVisible(homeInput, 10, "Validated Home Input Box successfully");
        return homeInput;
    }

    public void validate_Mobile_Input_Text_Is_Present() {
        WebElement mobileInputText = contactDetailsLocators.mobileInputHeader;
        waitForElementToBeVisible(mobileInputText, 10);
        validateText(mobileInputText, "Mobile", "Validated Mobile input header successfully", 5);
    }

    public WebElement validate_Mobile_Input_Box_Is_Present() {
        WebElement mobileInput = contactDetailsLocators.mobileInput;
        waitForElementToBeVisible(mobileInput, 10, "Validated Mobile Input Box successfully");
        return mobileInput;
    }

    public void validate_Work_Input_Text_Is_Present() {
        WebElement workInputText = contactDetailsLocators.workInputHeader;
        waitForElementToBeVisible(workInputText, 10);
        validateText(workInputText, "Work", "Validated Work input header successfully", 5);
    }

    public WebElement validate_Work_Input_Box_Is_Present() {
        WebElement workInput = contactDetailsLocators.workInput;
        waitForElementToBeVisible(workInput, 10, "Validated Work Input Box successfully");
        return workInput;
    }

    public void validate_Work_Email_Input_Text_Is_Present() {
        WebElement workEmailInputText = contactDetailsLocators.workEmailInputHeader;
        waitForElementToBeVisible(workEmailInputText, 10);
        validateText(workEmailInputText, "Work Email", "Validated Work Email input header successfully", 5);
    }

    public WebElement validate_Work_Email_Input_Box_Is_Present() {
        WebElement workEmailInput = contactDetailsLocators.workEmailInput;
        waitForElementToBeVisible(workEmailInput, 10, "Validated Work Email Input Box successfully");
        return workEmailInput;
    }

    public void validate_Other_Email_Input_Text_Is_Present() {
        WebElement otherEmailInputText = contactDetailsLocators.otherEmailInputHeader;
        waitForElementToBeVisible(otherEmailInputText, 10);
        validateText(otherEmailInputText, "Other Email", "Validated Other Email input header successfully", 5);
    }

    public void clickOnSaveButton() {

    }

    public WebElement validate_Other_Email_Input_Box_Is_Present() {
        WebElement otherEmailInput = contactDetailsLocators.otherEmailInput;
        waitForElementToBeVisible(otherEmailInput, 10, "Validated Other Email Input Box successfully");
        return otherEmailInput;
    }

}
