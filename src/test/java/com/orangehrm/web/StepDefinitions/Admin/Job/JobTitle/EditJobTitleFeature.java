package com.orangehrm.web.StepDefinitions.Admin.Job.JobTitle;

import com.orangehrm.web.StepDefinitions.Hooks;
import com.orangehrm.web.pages.Admin.Job.JobTitle.JobTitlePage;
import io.cucumber.java.en.And;

public class EditJobTitleFeature {
    @And("I click on Edit Button for the Job Title {string}")
    public void click_on_edit_button_for_job_title(String jobTitle) {
        Hooks hooks = new Hooks();
        JobTitlePage jobTitlePage = new JobTitlePage(hooks.getDriver());
        jobTitlePage.click_On_Edit_Icon_In_Job_Titles_Table(jobTitle);
    }

    @And("I edit the Job Title Name and save it {string}")
    public void edit_job_title_and_save_it(String updatedJobTitle) {
        Hooks hooks = new Hooks();
        JobTitlePage jobTitlePage = new JobTitlePage(hooks.getDriver());
        jobTitlePage.enterJobTitle(updatedJobTitle);
        jobTitlePage.click_On_Save_Button();
        jobTitlePage.validate_Job_Title_Is_Present_In_JobTitle_Table(updatedJobTitle);
    }
}
