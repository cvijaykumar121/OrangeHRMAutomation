package com.orangehrm.web.StepDefinitions.Admin.Job.JobTitle;

import com.orangehrm.web.StepDefinitions.Hooks;
import com.orangehrm.web.pages.Admin.Job.JobTitle.JobTitlePage;
import io.cucumber.java.en.And;

public class EditJobTitleFeature {
    @And("I click on Edit Button for the Job Title {string}")
    public void click_on_edit_button_for_job_title(String jobTitle) {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        jobTitlePage.click_On_Edit_Icon_In_Job_Titles_Table(jobTitle);
    }

    @And("I edit the Job Title Name and save it {string}")
    public void edit_job_title_and_save_it(String updatedJobTitle) {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        jobTitlePage.enterJobTitle(updatedJobTitle, true);
        jobTitlePage.click_On_Save_Button();
        jobTitlePage.validate_Job_Title_Is_Present_In_JobTitle_Table(updatedJobTitle);
    }
}
