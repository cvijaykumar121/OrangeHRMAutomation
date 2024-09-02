package com.orangehrm.pages.Admin.Job.Workshifts;

import com.orangehrm.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WorkShiftsLocators {
    public WorkShiftsLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/h6[text()='Work Shifts']")
    public WebElement workShiftsTitle;

    @FindBy(xpath = "//h6[text()='Work Shifts']/following-sibling::div/button")
    public WebElement workShiftsAddButton;

    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6[text()='Add Work Shift']")
    public WebElement addWorkShiftTitle;

    @FindBy(xpath = "//label[text()='Shift Name']/parent::div/following-sibling::div/input")
    public WebElement shiftNameInputBox;

    @FindBy(xpath = "//label[text()='From']/parent::div/following-sibling::div//input")
    public WebElement workingHours_From;

    @FindBy(xpath = "//label[text()='To']/parent::div/following-sibling::div//input")
    public WebElement workingHours_To;

    @FindBy(xpath = "//label[text()='Duration Per Day']")
    public WebElement durationPerDayText;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-workshift-duration']")
    public WebElement workShiftDurationTime;

    @FindBy(xpath = "//label[text()='Assigned Employees']/parent::div/following-sibling::div//input")
    public WebElement assignedEmployeesInputBox;

    public WebElement assignedEmployeesInWorkShift(String employeeName) {
        return Hooks.driver.findElement(By.xpath("//div[@class='oxd-autocomplete-chips-area']//span[text()='" + employeeName + " ']"));
    }

    @FindBy(xpath = "//div[@class='oxd-table-header']")
    public WebElement tableHeader;

    @FindBy(xpath = "//div[@class='oxd-table-header']//span")
    public WebElement workShiftsTableHeaderCheckbox;

    @FindBy(xpath = "//div[@role='row']/div[@role='columnheader' and text()='Name']")
    public WebElement nameHeader;

    @FindBy(xpath = "//div[@role='row']/div[@role='columnheader' and text()='From']")
    public WebElement fromHeader;

    @FindBy(xpath = "//div[@role='row']/div[@role='columnheader' and text()='To']")
    public WebElement toHeader;

    @FindBy(xpath = "//div[@role='row']/div[@role='columnheader' and text()='Hours Per Day']")
    public WebElement hoursPerDayHeader;

    @FindBy(xpath = "//div[@role='row']/div[@role='columnheader' and text()='Actions']")
    public WebElement actionsHeader;

    @FindBy(xpath = "//button[@type='button' and text()=' Cancel ']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[@type='submit' and text()=' Save ']")
    public WebElement saveButton;
}
