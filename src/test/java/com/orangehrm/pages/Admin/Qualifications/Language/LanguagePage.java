package com.orangehrm.pages.Admin.Qualifications.Language;

import com.orangehrm.base.TestBase;
import org.openqa.selenium.WebDriver;

public class LanguagePage extends TestBase {

    public WebDriver driver;
    public LanguageLocators languageLocators;

    public LanguagePage(WebDriver driver) {
        this.driver = driver;
        this.languageLocators = new LanguageLocators(driver);
    }

    public void validate_Licenses_Header() {
        validateText(languageLocators.languagesTitle, "Languages", "Validated Languages title", 30);
    }

    public void click_On_Languages_Add_Button() {
        clickElement(languageLocators.languagesAddButton, "Clicked on Languages Add Button", true, 30);
    }

    public void validate_Add_Language_Header() {
        validateText(languageLocators.addLanguageTitle, "Add Language", "Validated Add Language title", 30);
    }

    public void enter_Language_Name(String languageName) {
        sendKeys(languageLocators.languageNameInputBox, languageName, "Entered Language Name: " + languageName, 30);
    }

    public void click_On_Save_Button() {
        clickElement(languageLocators.saveButton, "Clicked on Save Button", true, 30);
    }

    public void click_On_Cancel_Button() {
        clickElement(languageLocators.cancelButton, "Clicked on Cancel Button", true, 30);
    }
}
