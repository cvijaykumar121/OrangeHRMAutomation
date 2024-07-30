package com.orangehrm.web.pages.Admin.Job.Workshifts;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;

public class WorkShiftsPage extends TestBase {
    public WebDriver driver;
    public WorkShiftsLocators workShiftsLocators;

    public WorkShiftsPage(WebDriver driver) {
        this.driver = driver;
        this.workShiftsLocators = new WorkShiftsLocators(driver);
    }

    public void validate_Employment_Status_Title() {
        validateText(workShiftsLocators.workShiftsTitle, "Work Shifts", "Validated Work Shifts title", 30);
    }

    public void click_On_Employment_Status_Add_Button() {
        clickElement(workShiftsLocators.workShiftsAddButton, "Clicked on Work Shifts add button", true, 30);
    }

    public void validate_Add_Employment_Status_Title() {
        validateText(workShiftsLocators.addWorkShiftTitle, "Add Work Shift", "Validated Add Workshift Title", 30);
    }

    public void enter_WorkShift_Name(String workShiftName) {
        sendKeys(workShiftsLocators.shiftNameInputBox, workShiftName, "Entered " + workShiftName + " into Work Shift Input", 30);
    }

    public void enter_WorkingHours_From_Timing(String fromTime) {
        sendKeys(workShiftsLocators.workingHours_From, fromTime, "Entered " + fromTime + " into FROM time", 30);
    }

    public void enter_WorkingHours_To_Timing(String toTime) {
        sendKeys(workShiftsLocators.workingHours_To, toTime, "Entered " + toTime + " into TO time", 30);
    }

    public void click_On_Cancel_Button() {
        clickElement(workShiftsLocators.cancelButton, "Clicked on Cancel button", true, 30);
    }

    public void click_On_Save_Button() {
        clickElement(workShiftsLocators.saveButton, "Clicked on Save Button", true, 30);
    }
}
