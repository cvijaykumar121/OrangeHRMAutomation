package com.orangehrm.pages.Admin.Job.JobTitle;

import com.orangehrm.base.StepDefinition;
import com.orangehrm.base.TestBase;
import com.orangehrm.pages.Admin.AdminTopNavMenu.AdminTopNavMenuLocators;
import com.orangehrm.pages.Login.LoginPage;
import com.orangehrm.pages.SideMenu.SideMenu;
import org.openqa.selenium.*;

import java.util.List;

public class JobTitlePage extends TestBase {
    public WebDriver driver;
    public JobTitleLocators jobTitleLocators;
    public SideMenu sideMenu;
    public LoginPage loginPage;
    public StepDefinition stepDefinition;
    public AdminTopNavMenuLocators adminTopNavMenuLocators;

    public JobTitlePage(WebDriver driver) {
        this.driver = driver;
        this.jobTitleLocators = new JobTitleLocators(driver);
        sideMenu = new SideMenu(driver);
        loginPage = new LoginPage(driver);
        adminTopNavMenuLocators = new AdminTopNavMenuLocators(driver);
        this.stepDefinition = new StepDefinition(driver);
    }

    public void validate_Job_Title_Page_Header() {
        WebElement jobTitleHeader = jobTitleLocators.jobTitlesHeader;
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForElementToBeVisible(jobTitleHeader, 20);
        validateText(jobTitleHeader, "Job Titles", "Validated Job Title successfully", 10);
    }

    public void validate_Job_Title_Input_Text_Is_Present() {
        WebElement jobTitleInputText = jobTitleLocators.jobTitleInputHeader;
        waitForElementToBeVisible(jobTitleInputText, 10);
        validateText(jobTitleInputText, "Job Title", "Validated Job Title input header successfully", 5);
    }

    public WebElement validate_Job_Title_Input_Box_Is_Present() {
        WebElement jobTitleInput = jobTitleLocators.jobTitleInput;
        waitForElementToBeVisible(jobTitleInput, 10, "Validated Job Title Input Box successfully");
        return jobTitleInput;
    }

    public void enterJobTitle(String jobTitle) {
        WebElement jobTitleInput = jobTitleLocators.jobTitleInput;
        jobTitleInput.clear();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sendKeys(jobTitleInput, jobTitle, "Successfully entered " + jobTitle + " into text box", 10);
    }

    public void validate_Job_Description_Input_Text_Is_Present() {
        WebElement jobDescriptionInputHeader = jobTitleLocators.jobDescriptionInputHeader;
        waitForElementToBeVisible(jobDescriptionInputHeader, 10);
        validateText(jobDescriptionInputHeader, "Job Description", "Validated Job Description input header successfully", 5);
    }

    public WebElement validate_Job_Title_Description_Box_Is_Present() {
        WebElement jobTitleDescription = jobTitleLocators.jobDescriptionInput;
        waitForElementToBeVisible(jobTitleDescription, 10, "Validated Job Title description box successfully");
        return jobTitleDescription;
    }

    public void enter_Job_Description(String jobDescription) {
        WebElement jobDescriptionTextBox = validate_Job_Title_Description_Box_Is_Present();
        sendKeys(jobDescriptionTextBox, jobDescription, "Successfully entered " + jobDescription + " into job description text box", 10);
    }


    public void validate_Job_Specification_Input_Text_Is_Present() {
        WebElement jobSpecificationInputHeader = jobTitleLocators.jobSpecificationInputHeader;
        waitForElementToBeVisible(jobSpecificationInputHeader, 10);
        validateText(jobSpecificationInputHeader, "Job Specification", "Validated Job Specification input header successfully", 5);
    }

    public void validate_Job_Specification_Browse_Button_Is_Present() {
        WebElement jobSpecificationBrowseButton = jobTitleLocators.jobSpecificationBrowseButton;
        waitForElementToBeVisible(jobSpecificationBrowseButton, 10, "Job specification browse button is visible");
    }


    public void validate_Job_Specification_Hint_Text_Is_Present() {
        WebElement jobSpecificationHintText = jobTitleLocators.jobSpecificationHint;
        waitForElementToBeVisible(jobSpecificationHintText, 10);
//        validateText(jobSpecificationHintText, "Accepts upto 1MB", "Validated Job Specification hint successfully", 5);
    }

    public void validate_Note_Input_Text_Is_Present() {
        WebElement noteInputHeader = jobTitleLocators.noteInputHeader;
        waitForElementToBeVisible(noteInputHeader, 10);
        validateText(noteInputHeader, "Note", "Validated Note input header successfully", 5);
    }

    public WebElement validate_Note_Input_Box_Is_Present() {
        WebElement noteInputBox = jobTitleLocators.addNoteTextBox;
        waitForElementToBeVisible(noteInputBox, 10, "Validated add note input box successfully");
        return noteInputBox;
    }

    public void enterNote(String note) {
        sendKeys(jobTitleLocators.addNoteTextBox, note, "Entered note into note input box", 10);
    }


    public void validate_Cancel_Button_Is_Present() {
        WebElement cancelButton = jobTitleLocators.cancelButton;
        waitForElementToBeClickable(cancelButton, 10, "Validated cancel button successfully");
    }

    public WebElement validate_Save_Button_Is_Present() {
        WebElement saveButton = jobTitleLocators.saveButton;
        waitForElementToBeClickable(saveButton, 10, "Validated Save button successfully");
        return saveButton;
    }

    public void click_On_Save_Button() {
        WebElement saveButton = validate_Save_Button_Is_Present();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        clickElement(saveButton, "Save button clicked successfully", true, 30);
//        try {
//            Thread.sleep(12000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public void validate_Required_Error_Message_Is_Present() {
        WebElement requiredText = jobTitleLocators.jobTitleRequiredErrorMessage;
        waitForElementToBeVisible(requiredText, 10);
        String requiredTextContent = requiredText.getText();
        System.out.println("Required Text Displayed: " + requiredTextContent);
        validateText(requiredText, "Required", "Required Text Validated successfully", 30);
    }

    public WebElement validate_Add_Button() {
        WebElement addButton = jobTitleLocators.jobTitleAddButton;
        waitForElementToBeClickable(addButton, 10, "Add button is clickable");
        return addButton;
    }

    public void click_on_Add_Button() {
        clickElement(jobTitleLocators.jobTitleAddButton, "Clicked on Add button in job titles page", true, 5);
    }

    public void validate_Add_Job_Titles_Page_Header() {
        WebElement requiredText = jobTitleLocators.addJobTitleHeader;
        waitForElementToBeVisible(requiredText, 15);
        validateText(requiredText, "Add Job Title", "Validated Add Job Title header successfully", 5);
    }

    private void validateTableIsPresent() {
        WebElement jobTitleTable = jobTitleLocators.jobTitlesTable;
        waitForElementToBeVisible(jobTitleTable, 10, "Job Title table is visible");
    }

    private void validateTableHeaders() {
        WebElement checkboxHeader = jobTitleLocators.checkboxHeader;
        WebElement jobTitlesHeader = jobTitleLocators.jobTitlesHeader;
        WebElement jobDescriptionHeader = jobTitleLocators.jobDescriptionTableHeader;
        WebElement actionsHeader = jobTitleLocators.actionsTableHeader;

        waitForElementToBeClickable(checkboxHeader, 10, "Checkbox header is visible and clickable");
        waitForElementToBeVisible(jobTitlesHeader, 10, "Job Titles Header is visible");
        waitForElementToBeVisible(jobDescriptionHeader, 10, "Job Description header is visible");
        waitForElementToBeVisible(actionsHeader, 10, "Actions header is visible");
    }

    public WebElement validate_Job_Title_Is_Present_In_JobTitle_Table(String jobTitle) {
        waitForElementToBeVisible(jobTitleLocators.jobTitlesTable, 50, "Job Titles page is visible");
        WebElement requiredJobTitle = jobTitleLocators.allJobTitles.findElement(By.xpath("//div[text()='" + jobTitle + "']"));
        waitForElementToBeVisible(requiredJobTitle, 20, "Validated " + requiredJobTitle + " in the Job Titles Table");
        return requiredJobTitle;
    }

    public void delete_Job_Title_From_Table(String jobTitle) {
        WebElement requiredJobTitle = validate_Job_Title_Is_Present_In_JobTitle_Table(jobTitle);
        WebElement trashIconForRequiredJobTitle = requiredJobTitle.findElement(By.xpath("//ancestor::div[@class='oxd-table-card']//button/i[@class='oxd-icon bi-trash']"));
        clickElement(trashIconForRequiredJobTitle, "Successfully deleted " + jobTitle, true, 30);
        stepDefinition.handle_Delete_Pop_Up(true);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllJobTitlesFromJobTitlePage() {
        while (isElementPresent(jobTitleLocators.allJobTitles)) {
            clickElement(jobTitleLocators.selectAllJobTitlesCheckbox, "Clicked on select all Job Title checkbox", true, 30);
            clickElement(jobTitleLocators.deleteSelectedButton, "Clicked on delete selected button", true, 30);
            stepDefinition.handle_Delete_Pop_Up(true);

            waitForElementToBeVisible(jobTitleLocators.jobTitlesTableHeaderRow, 30, "All Job Titles deleted");
        }
        System.out.println("No jobs present now");
    }

    private void validateJobTitleRequiredErrorMessage(String fieldName) {
        WebElement jobTitleRequiredErrorMessage = driver.findElement(By.xpath("//div[@class='oxd-form-row' and .//label[text()='" + fieldName + "']]//span[text()='Required']"));
        waitForElementToBeVisible(jobTitleRequiredErrorMessage, 10, "Required error message in job title field is displayed correctly");
    }

    public void click_On_Trash_Icon_In_Job_Titles_Table(String jobTitle) {
        List<WebElement> jobTitleRows = jobTitleLocators.jobTitlesTableRows;
        for (WebElement currentRow : jobTitleRows) {
            WebElement jobTitleElement = currentRow.findElement(By.xpath("//div[text()='" + jobTitle + "']"));
            if (getTextFromElement(jobTitleElement, 10).equalsIgnoreCase(jobTitle)) {
                logInfo("Successfully validated job title in the table", true);
                WebElement trashIcon = currentRow.findElement(By.xpath("//i[@class='oxd-icon bi-trash']"));
                waitForElementToBeVisible(trashIcon, 10, "Delete icon is visible");
                clickElement(trashIcon, "Trash Icon for the " + jobTitle + " is clicked successfully", true, 10);
                break;
            }
        }
    }

    public void click_On_Edit_Icon_In_Job_Titles_Table(String jobTitle) {
        WebElement editIconForJobTitle = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@role='row' and .//div[text()='" + jobTitle + "']]//i[@class='oxd-icon bi-pencil-fill']"));
        clickElement(editIconForJobTitle, "Edit Icon for the " + jobTitle + " is clicked successfully", true, 10);
    }

//    public void handle_Delete_Pop_Up(boolean clickOnDelete) {
//        validateText(jobTitleLocators.deleteJobTitlePopUpHeader, "Are you Sure?",
//                "Delete Job Title pop up header validated successfully", 10);
//        validateText(jobTitleLocators.deleteJobTitlePopUpBody,
//                "The selected record will be permanently deleted. Are you sure you want to continue?",
//                "Delete Job Title pop up message body validated successfully", 10);
//        if (clickOnDelete) {
//            click_On_Yes_Delete_Button();
//        } else {
//            click_No_Cancel_Button();
//        }
//    }
//
//    private void click_On_Yes_Delete_Button() {
//        WebElement yesDeleteButton = jobTitleLocators.yesDeleteJobTitleButton;
//        waitForElementToBeVisible(yesDeleteButton, 10, "Yes Delete button is displayed successfully");
//        clickElement(yesDeleteButton, "Yes, Delete button is clicked successfully", true, 10);
//    }
//
//    private void click_No_Cancel_Button() {
//        WebElement noCancelButton = jobTitleLocators.noCancelJobTitleButton;
//        waitForElementToBeVisible(noCancelButton, 10, "No Cancel button is displayed successfully");
//        clickElement(noCancelButton, "No Cancel button is clicked successfully", true, 10);
//    }

    public void validateJobTitleAlreadyExistsErrorMessage(String fieldName) {
        WebElement jobTitleRequiredErrorMessage = driver.findElement(By.xpath("//div[@class='oxd-form-row' and .//label[text()='" + fieldName + "']]//span[text()='Already exists']"));
        waitForElementToBeVisible(jobTitleRequiredErrorMessage, 10, "Already exists error message in job title field is displayed correctly");
    }

    public void validate_error_message_displayed_while_entering_more_than_400_characters(String fieldName) {
        WebElement errorElement = jobTitleLocators.getMaximumCharactersErrorMessageXpath(fieldName);
        waitForElementToBeVisible(errorElement, 10, "Error message of maximum characters is displayed in the job description field");
        validateText(errorElement, "Should not exceed 400 characters", "Successfully validated the content of the error message", 10);
    }

    public void validate_No_Records_Found_Text_Displayed() {
        validateText(jobTitleLocators.noRecordsFoundText, "No Records Found", "Validated No Records Found text successfully", 30);
    }

    public void validate_No_Records_Found_In_Table() {
        List<WebElement> recordsList = jobTitleLocators.jobTitlesTableRows;
        if(recordsList.size() == 0) {
            logPass("No Records found in the table", true);
        } else {
            logFail("Records are found in the table", true);
        }
    }
}
