package com.orangehrm.pages.Admin.Job.Workshifts;

import com.orangehrm.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WorkShiftsPage extends TestBase {
    public WebDriver driver;
    public WorkShiftsLocators workShiftsLocators;

    public WorkShiftsPage(WebDriver driver) {
        this.driver = driver;
        this.workShiftsLocators = new WorkShiftsLocators(driver);
    }

    public void validate_WorkShifts_Title() {
        validateText(workShiftsLocators.workShiftsTitle, "Work Shifts", "Validated Work Shifts title", 30);
    }

    public void click_On_WorkShifts_Add_Button() {
        clickElement(workShiftsLocators.workShiftsAddButton, "Clicked on Work Shifts add button", true, 30);
    }

    public void validate_Add_WorkShift_Title() {
        validateText(workShiftsLocators.addWorkShiftTitle, "Add Work Shift", "Validated Add Work shift Title", 30);
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

    public void enter_Assigned_Employees(String employeeName) {
        sendKeys(workShiftsLocators.assignedEmployeesInputBox, employeeName, "Entered employee name", 40);
        String firstName = employeeName.split(" ")[0];
        selectOptionFromDropdown(employeeName, "Selected " + firstName + " from the list");
    }

    public void click_On_Cancel_Button() {
        clickElement(workShiftsLocators.cancelButton, "Clicked on Cancel button", true, 30);
    }

    public void click_On_Save_Button() {
        clickElement(workShiftsLocators.saveButton, "Clicked on Save Button", true, 30);
    }

    public void validate_Checkbox_Column_Header() {
        waitForElementToBeVisible(workShiftsLocators.tableHeader, 40, "Work shifts table header checkbox is visible");
    }

    public void validate_Name_Column_Header() {
        waitForElementToBeVisible(workShiftsLocators.nameHeader, 30, "Work shifts table name header is visible");
    }

    public void validate_From_Column_Header() {
        waitForElementToBeVisible(workShiftsLocators.fromHeader, 30, "Work shifts From header is visible");
    }

    public void validate_To_Column_Header() {
        waitForElementToBeVisible(workShiftsLocators.toHeader, 30, "Work shifts To header is visible");
    }

    public void validate_HoursPerDay_Column_Header() {
        waitForElementToBeVisible(workShiftsLocators.hoursPerDayHeader, 30, "Work shifts hours per day header is visible");
    }

    public void validate_Actions_Column_Header() {
        waitForElementToBeVisible(workShiftsLocators.actionsHeader, 30, "Work shifts table Actions header is visible");
    }

    public void validateEmployeeAdded(String employeeName) {
        WebElement assignedEmployeesInWorkShift = workShiftsLocators.assignedEmployeesInWorkShift(employeeName);
        validateText(assignedEmployeesInWorkShift, employeeName, "Validated Employee added to work shift", 30);
    }
}
