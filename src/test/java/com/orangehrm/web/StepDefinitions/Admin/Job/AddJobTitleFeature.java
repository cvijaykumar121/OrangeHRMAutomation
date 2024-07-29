package com.orangehrm.web.StepDefinitions.Admin.Job;

import com.orangehrm.web.StepDefinitions.Hooks;
import com.orangehrm.web.pages.Admin.AdminTopNavMenu.AdminTopNavMenu;
import com.orangehrm.web.pages.Admin.Job.JobTitle.JobTitlePage;
import com.orangehrm.web.pages.PIM.EmployeeList.Job.JobPage;
import com.orangehrm.web.pages.SideMenu.SideMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class AddJobTitleFeature {
    @Then("I navigate to Add Job Titles Page")
    public void i_navigate_to_add_job_titles_page() {
        SideMenu sideMenu = new SideMenu(Hooks.driver);
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        AdminTopNavMenu adminTopNavMenu = new AdminTopNavMenu(Hooks.driver);

        sideMenu.clickOnAdminLink();
        adminTopNavMenu.navigate_To_JobTitles_Page();
        jobTitlePage.validate_Add_Button();
        jobTitlePage.click_on_Add_Button();
        jobTitlePage.validate_Add_Job_Titles_Page_Header();
    }

    @And("I should be able to see all the UI elements are placed correctly on the page")
    public void validate_All_Elements_Present_In_Add_JobTitle_Page() {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        jobTitlePage.validate_Add_Job_Titles_Page_Header();
        jobTitlePage.validate_Job_Title_Input_Text_Is_Present();
        jobTitlePage.validate_Job_Title_Input_Box_Is_Present();
        jobTitlePage.validate_Job_Description_Input_Text_Is_Present();
        jobTitlePage.validate_Job_Title_Description_Box_Is_Present();
        jobTitlePage.validate_Job_Specification_Input_Text_Is_Present();
        jobTitlePage.validate_Job_Specification_Browse_Button_Is_Present();
        jobTitlePage.validate_Job_Specification_Hint_Text_Is_Present();
        jobTitlePage.validate_Note_Input_Text_Is_Present();
        jobTitlePage.validate_Note_Input_Box_Is_Present();
        jobTitlePage.validate_Cancel_Button_Is_Present();
        jobTitlePage.validate_Save_Button_Is_Present();
//        jobTitle.validate_Required_Text_Is_Present_At_Bottom_Of_Page();
    }

//    @Then("I should be able to add a job title successfully by entering all the valid details in the page")
//    public void Add_Job_Title_By_Entering_All_Valid_Data_In_All_Fields(io.cucumber.datatable.DataTable dataTable) {
//        JobTitle jobTitle = new JobTitle(Hooks.driver);
//        List<Map<String, String>> data = dataTable.asMaps();
//        Map<String, String> row1 = data.get(0);
//
//        String titleOfJob = row1.get("Job Title");
//        String jobDescription = row1.get("Job Description");
//        String note = row1.get("Note");
//
//        jobTitle.enterJobTitle(titleOfJob);
//        jobTitle.enter_Job_Description(jobDescription);
//        jobTitle.enterNote(note);
//        jobTitle.uploadFile();
//        jobTitle.click_On_Save_Button();
//    }

    @Then("I should be able to add a job title successfully by entering all the valid details {string} {string} and {string} in the page")
    public void i_should_be_able_to_add_a_job_title_successfully_by_entering_all_the_valid_details_and_note_in_the_page(String titleOfJob, String jobDescription, String note) {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);

        jobTitlePage.enterJobTitle(titleOfJob);
        jobTitlePage.enter_Job_Description(jobDescription);
        jobTitlePage.enterNote(note);
//        jobTitle.uploadFile();
        jobTitlePage.click_On_Save_Button();
    }

    @Then("I should be able to add a job title successfully by entering only the required details in the page")
    public void Add_Job_Title_By_Entering_Only_Required_Fields(io.cucumber.datatable.DataTable dataTable) {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        List<Map<String, String>> data = dataTable.asMaps();
        Map<String, String> row1 = data.get(0);

        String titleOfJob = row1.get("Job Title");
        jobTitlePage.enterJobTitle(titleOfJob);
        jobTitlePage.click_On_Save_Button();
    }

    @Then("I should see the Required error message displayed in the Job Titles Text Field")
    public void validate_Required_Error_Message_Is_Present_At_Bottom_Of_Job_Title_Field() {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        jobTitlePage.click_On_Save_Button();
        jobTitlePage.validate_Required_Error_Message_Is_Present_At_Bottom_Of_Job_Title_Field();
    }

    @Then("I should get an error message in the {string} that more than 400 characters are not allowed {string} {string} and {string}")
    public void validate_error_message_for_maximum_characters(String errorValidationField, String titleOfJob, String jobDescription, String note) {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        i_should_be_able_to_add_a_job_title_successfully_by_entering_all_the_valid_details_and_note_in_the_page(titleOfJob, jobDescription, note);
        if(errorValidationField.equalsIgnoreCase("job description")) {
            jobTitlePage.validate_error_message_displayed_while_entering_more_than_400_characters("Job Description");
        } else if(errorValidationField.equalsIgnoreCase("note")) {
            jobTitlePage.validate_error_message_displayed_while_entering_more_than_400_characters("Note");
        }
    }

    @And("I open the Job Title dropdown in Job Section and I select the same {string} that I added from Admin menu")
    public void open_Job_Title_Dropdown_In_Job_Section(String jobTitle) {
        JobPage jobPage = new JobPage(Hooks.driver);
        jobPage.navigate_To_Job_Page();
        jobPage.select_Option_From_JobTitle_Dropdown(jobTitle);
    }
}
