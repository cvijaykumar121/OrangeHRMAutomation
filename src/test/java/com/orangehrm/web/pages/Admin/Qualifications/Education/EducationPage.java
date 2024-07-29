package com.orangehrm.web.pages.Admin.Qualifications.Education;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;

public class EducationPage extends TestBase {

    public WebDriver driver;
    public EducationLocators educationLocators;

    public EducationPage(WebDriver driver) {
        this.driver = driver;
        this.educationLocators = new EducationLocators(driver);
    }

    public void validate_Education_Header() {
        validateText(educationLocators.educationTitle, "Education", "Validated Education title", 30);
    }

    public void click_On_Skills_Add_Button() {
        clickElement(educationLocators.educationAddButton, "Clicked on Education Add Button", true, 30);
    }

    public void enter_Education_Level(String educationLevel) {
        sendKeys(educationLocators.levelInputBox, educationLevel, "Entered Education Level: " + educationLevel, 30);
    }

    public void click_On_Save_Button() {
        clickElement(educationLocators.saveButton, "Clicked on Save Button ", true, 30);
    }

    public void click_On_Cancel_Button() {
        clickElement(educationLocators.cancelButton, "Clicked on Cancel Button", true, 30);
    }
}
