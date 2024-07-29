package com.orangehrm.web.pages.Admin.Qualifications.License;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;

public class LicensePage extends TestBase {
    public WebDriver driver;
    public LicenseLocators licenseLocators;

    public LicensePage(WebDriver driver) {
        this.driver = driver;
        this.licenseLocators = new LicenseLocators(driver);
    }

    public void validate_Licenses_Header() {
        validateText(licenseLocators.licensesTitle, "Licenses", "Validated Licenses title", 30);
    }

    public void click_On_Licenses_Add_Button() {
        clickElement(licenseLocators.licenseAddButton, "Clicked on Licenses Add Button", true, 30);
    }

    public void validate_Add_Licenses_Header() {
        validateText(licenseLocators.addLicenseHeader, "Add License", "Validated Add Licenses title", 30);
    }

    public void enter_License_Name(String licenseName) {
        sendKeys(licenseLocators.licenseNameInputBox, licenseName, "Entered License Name: " + licenseName, 30);
    }

    public void click_On_Save_Button() {
        clickElement(licenseLocators.saveButton, "Clicked on Save Button", true, 30);
    }

    public void click_On_Cancel_Button() {
        clickElement(licenseLocators.cancelButton, "Clicked on Cancel Button", true, 30);
    }
}
