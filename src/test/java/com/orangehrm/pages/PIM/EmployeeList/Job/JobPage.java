package com.orangehrm.pages.PIM.EmployeeList.Job;

import com.orangehrm.base.TestBase;
import com.orangehrm.base.StepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobPage extends TestBase {
    public WebDriver driver;
    public JobPageLocators jobPageLocators;
    public StepDefinition stepDefinition;

    public JobPage(WebDriver driver) {
        this.driver = driver;
        this.jobPageLocators = new JobPageLocators(driver);
        this.stepDefinition = new StepDefinition(driver);
    }

    public void navigate_To_Job_Page() {
        clickElement(jobPageLocators.jobSideMenu, "Successfully clicked on Job menu", true, 20);
    }

    private WebElement validate_Job_Title_Dropdown_Is_Present() {
        WebElement jobTitleDropdown = jobPageLocators.jobTitleDropdown;
        waitForElementToBeVisible(jobTitleDropdown, 30, "Job Title Dropdown is clickable");
        return jobTitleDropdown;
    }

    public void click_On_JobTitle_Dropdown() {
        WebElement jobTitleDropdown = validate_Job_Title_Dropdown_Is_Present();
        waitForElementToBeVisible(jobTitleDropdown, 40, "Job Title Dropdown is clickable");
        clickElement(jobTitleDropdown, "Job Title Dropdown clicked successfully", true, 20);
    }

    public void select_Option_From_JobTitle_Dropdown(String option) {
        WebElement optionFromDropdown = driver.findElement(By.xpath("//div[@role='listbox']/div/span[text()='" + option + "']"));
        waitForElementToBeClickable(optionFromDropdown, 20, option + " is visible in the job title dropdown");
        clickElement(optionFromDropdown, option + " from the job title dropdown is clicked", true, 20);
    }

    public void validate_Job_Title_Displayed_In_JobTitle_TextBox(String jobTitle) {
        WebElement jobTitleTextInBox = driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div//div[text()='" + jobTitle + "']"));
        validateText(jobTitleTextInBox, jobTitle, "Validated Job Title in Job Page", 40);
    }

    public void validate_No_Records_Found_Is_Displayed_In_JobTitle_Dropdown() {
        click_On_JobTitle_Dropdown();
        WebElement noRecordsFoundText = jobPageLocators.noRecordsFoundTextInDropdown;
        validateText(noRecordsFoundText, "No Records Found", "No Records found validated in Job Title dropdown", 30);
    }

    public void validate_No_Job_Title_Displayed_In_JobTitle_InputBox() {
        WebElement jobTitleInputBox = jobPageLocators.jobTitleDropdown;
        String jobText = jobTitleInputBox.getText();
        System.out.println("Job Title Input box text: " + jobText);
        if(jobText.equals("-- Select --")) {
            logPass("No Job Title displayed in the Job Title Input Box", true);
        } else {
            logFail("Job Title: " + jobText + " is displayed in the Job Title Input box", true);
        }
    }

    public void validate_JobTitle_Deleted_Text_Is_Displayed_In_JobTitle_InputBox(String jobTitle) {
        WebElement jobTitleInputBox = driver.findElement(By.xpath("//label[text()='Job Title']/../following-sibling::div//div[text()='" + jobTitle + " (Deleted)" + "']"));
        String textFromJobTitleInputBox = getTextFromElement(jobTitleInputBox, 30);
        System.out.println("Actual Text: " + textFromJobTitleInputBox);
        String expectedText = jobTitle + " (Deleted)";
        System.out.println("Expected Text: " + expectedText);

        validateText(jobTitleInputBox, expectedText, textFromJobTitleInputBox, 30);
    }
}
