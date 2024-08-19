package com.orangehrm.pages.Admin.Job.JobCategories;

import com.orangehrm.base.TestBase;
import org.openqa.selenium.WebDriver;

public class JobCategoriesPage extends TestBase {
    public WebDriver driver;
    public JobCategoriesLocators jobCategoriesLocators;

    public JobCategoriesPage(WebDriver driver) {
        this.driver = driver;
        this.jobCategoriesLocators = new JobCategoriesLocators(driver);
    }

    public void validate_Job_Categories_Title() {
        validateText(jobCategoriesLocators.jobCategoriesTitle, "Job Categories", "Validated Job Categories Title", 30);
    }

    public void click_On_Job_Categories_Add_Button() {
        clickElement(jobCategoriesLocators.jobCategoriesAddButton, "Clicked on Job Categories Add Button", true, 30);
    }

    public void validate_Add_Job_Category_Title() {
        validateText(jobCategoriesLocators.addJobCategoryTitle, "Add Job Category", "Validated Add Job Category Title", 30);
    }

    public void enter_Job_Category_Name(String jobCategory) {
        sendKeys(jobCategoriesLocators.addJobCategory_NameInputBox, jobCategory, "Entered " + jobCategory + " in Job Category Input box", 30);
    }

    public void click_On_Cancel_Button() {
        clickElement(jobCategoriesLocators.cancelButton, "Clicked on Cancel button", true, 30);
    }

    public void click_On_Save_Button() {
        clickElement(jobCategoriesLocators.saveButton, "Clicked on Save Button", true, 30);
    }
}
