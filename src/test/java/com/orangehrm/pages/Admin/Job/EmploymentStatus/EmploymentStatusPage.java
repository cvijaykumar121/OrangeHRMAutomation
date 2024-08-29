package com.orangehrm.pages.Admin.Job.EmploymentStatus;

import com.orangehrm.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

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

    public void validate_EmploymentStatus_Is_Displayed_In_Table(String employmentStatus) {
        waitForElementToBeVisible(employmentStatusLocators.employmentStatusTitle, 40);
        WebElement employmentStatusElement = driver.findElement(By.xpath("//div[@role='cell']/div[text()='" + employmentStatus + "']"));
        waitForElementToBeVisible(employmentStatusElement, 40, "Employment Status: " + employmentStatus + " is found in the table");
    }

    public void validate_Number_Records_Increased(int numberOfRecords) {
        int increasedNumberOfRecords = numberOfRecords + 1;
        WebElement recordsFoundElement = employmentStatusLocators.recordsFoundElement;
        String recordsFoundText = recordsFoundElement.getText();
        String[] parts = recordsFoundText.split(" ");
        String number = parts[0].replaceAll("[()]", ""); // Removes parentheses;
        System.out.println("Number part: " + number);
        int numberInt = Integer.parseInt(number);
        System.out.println("Number in Integer: " + numberInt);

        Assert.assertEquals(numberOfRecords, increasedNumberOfRecords);
    }

    public void validate_EmploymentStatus_Is_Not_Displayed_In_Table(String employmentStatus) {
        List<WebElement> employmentStatusElement = driver.findElements(By.xpath("//div[@role='cell']/div[text()='" + employmentStatus + "']"));
        if(isElementPresent(employmentStatusElement)) {
            logFail("Employment Status is displayed", true);
        } else {
            logPass("Employment Status is not displayed", true);
        }
    }

    public void validate_EmploymentStatus_Displayed_In_EmploymentStatus_TextBox(String employmentStatus) {
//        waitForElementToBeVisible(saveButton, 30);
        WebElement employmentStatusTextInBox = driver.findElement(By.xpath("//label[text()='Employment Status']/parent::div/following-sibling::div//div[text()='" + employmentStatus + "']"));
        waitForElementToBeVisible(employmentStatusTextInBox, 30);
        validateText(employmentStatusTextInBox, employmentStatus, "Validated Employment Status in Job Page", 40);
    }

    private WebElement validate_Employment_Status_Dropdown_Is_Present() {
        WebElement employmentStatusDropdown = employmentStatusLocators.employmentStatusDropdown;
        waitForElementToBeVisible(employmentStatusDropdown, 30, "Employment Status Dropdown is clickable");
        return employmentStatusDropdown;
    }

    public void click_On_Employment_Status_Dropdown() {
        WebElement jobTitleDropdown = validate_Employment_Status_Dropdown_Is_Present();
        waitForElementToBeVisible(jobTitleDropdown, 40, "Job Title Dropdown is clickable");
        clickElement(jobTitleDropdown, "Job Title Dropdown clicked successfully", true, 20);
    }

    public void validate_Job_Title_Displayed_In_JobTitle_TextBox(String employmentStatus) {
//        waitForElementToBeVisible(jobPageLocators.saveButton, 30);
        WebElement employmentStatusTextInBox = driver.findElement(By.xpath("//label[text()='Employment Status']/parent::div/following-sibling::div//div[text()='" + employmentStatus + "']"));
        waitForElementToBeVisible(employmentStatusTextInBox, 30);
        validateText(employmentStatusTextInBox, employmentStatus, "Validated Employment Status in Job Page", 40);
    }
}
