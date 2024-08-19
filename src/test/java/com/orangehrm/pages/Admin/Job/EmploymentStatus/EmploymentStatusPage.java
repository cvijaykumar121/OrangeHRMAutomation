package com.orangehrm.pages.Admin.Job.EmploymentStatus;

import com.orangehrm.base.TestBase;
import org.openqa.selenium.WebDriver;

public class EmploymentStatusPage extends TestBase {
    public WebDriver driver;
    public EmploymentStatusLocators employmentStatusLocators;

    public EmploymentStatusPage(WebDriver driver) {
        this.driver = driver;
        this.employmentStatusLocators = new EmploymentStatusLocators(driver);
    }

    public void validate_Employment_Status_Title() {
        validateText(employmentStatusLocators.employmentStatusTitle, "Employment Status", "Validated employment status title", 30);
    }

    public void click_On_Employment_Status_Add_Button() {
        clickElement(employmentStatusLocators.employmentStatusAddButton, "Clicked on Employment status add button", true, 30);
    }

    public void validate_Add_Employment_Status_Title() {
        validateText(employmentStatusLocators.addEmploymentStatusTitle, "Add Employment Status", "Validated Add Employment Status Title", 30);
    }

    public void enter_EmploymentStatus_Name(String employmentStatusName) {
        sendKeys(employmentStatusLocators.addEmploymentStatus_NameInputBox, employmentStatusName, "Entered " + employmentStatusName + " into Employment Status Input", 30);
    }

    public void click_On_Cancel_Button() {
        clickElement(employmentStatusLocators.cancelButton, "Clicked on Cancel button", true, 30);
    }

    public void click_On_Save_Button() {
        clickElement(employmentStatusLocators.saveButton, "Clicked on Save Button", true, 30);
    }
}
