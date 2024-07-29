package com.orangehrm.web.pages.Admin.Nationalities;
import com.orangehrm.web.base.TestBase;
import com.orangehrm.web.pages.Admin.Organization.GeneralInformation.GeneralInformationLocators;
import org.openqa.selenium.WebDriver;

public class NationalitiesPage extends TestBase {
    public WebDriver driver;
    public NationalitiesLocators nationalitiesLocators;

    public NationalitiesPage(WebDriver driver) {
        this.driver = driver;
        this.nationalitiesLocators = new NationalitiesLocators(driver);
    }

    public void validate_Nationalities_Header() {
        validateText(nationalitiesLocators.nationalitiesHeader, "Nationalities", "Validated Nationalities header", 30);
    }

    public void click_On_Add_Nationalities_Button() {
        clickElement(nationalitiesLocators.nationalitiesAddButton, "Clicked on Nationalities Add button", true, 30);
    }

    public void validate_Add_Nationality_Header() {
        validateText(nationalitiesLocators.addNationalityHeader, "Add Nationality", "Validated Add Nationality Header", 30);
    }

    public void enter_Nationality_Name(String nationalityName) {
        sendKeys(nationalitiesLocators.nationalityNameInputBox, nationalityName, "Entered Nationality Name: " + nationalityName, 30);
    }

    public void click_On_Save_Button() {
        clickElement(nationalitiesLocators.saveButton, "Clicked on Save Button", true, 30);
    }

    public void click_On_Cancel_Button() {
        clickElement(nationalitiesLocators.cancelButton, "Clicked on Cancel Button", true, 30);
    }
}
