package com.orangehrm.web.StepDefinitions.Admin.Job.JobTitle;

import com.orangehrm.web.StepDefinitions.Hooks;
import com.orangehrm.web.base.StepDefinition;
import com.orangehrm.web.pages.Admin.AdminTopNavMenu.AdminTopNavMenu;
import com.orangehrm.web.pages.Admin.Job.JobTitle.JobTitlePage;
import com.orangehrm.web.pages.PIM.EmployeeList.EmployeeInformation.EmployeeInformationPage;
import com.orangehrm.web.pages.PIM.EmployeeList.Job.JobPage;
import com.orangehrm.web.pages.PIM.EmployeeList.PersonalDetails.PersonalDetails;
import com.orangehrm.web.pages.SideMenu.SideMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;

import java.util.List;
import java.util.Map;

public class JobTitleFeature {
    @Then("I navigate to Job Titles Page")
    public void i_navigate_to_add_job_titles_page() {
        SideMenu sideMenu = new SideMenu(Hooks.driver);
        AdminTopNavMenu adminTopNavMenu = new AdminTopNavMenu(Hooks.driver);

        sideMenu.clickOnAdminLink();
        adminTopNavMenu.navigate_To_JobTitles_Page();
    }

    @Then("I click on Add Button and navigate to Add Job Titles Page")
    public void i_navigate_to_add_job_title_page() {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
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
    }

    @Then("I add a job title by entering all the valid details {string} {string} and {string} on the page")
    public void i_add_a_job_title_by_entering_all_the_valid_details_and_note_in_the_page(String titleOfJob, String jobDescription, String note) {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        StepDefinition stepDefinition = new StepDefinition(Hooks.driver);

        jobTitlePage.click_on_Add_Button();
        jobTitlePage.enterJobTitle(titleOfJob);
        jobTitlePage.enter_Job_Description(jobDescription);
        jobTitlePage.enterNote(note);
        stepDefinition.uploadFile();
    }

    @And("I validate that the Job Title is displayed in the Job Title table {string}")
    public void validate_job_title_displayed_in_job_title_table(String jobTitle) {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        jobTitlePage.validate_Job_Title_Page_Header();
        jobTitlePage.validate_Job_Title_Is_Present_In_JobTitle_Table(jobTitle);
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

    @When("I add a job title by entering all the valid details {string} {string} and {string} in the page")
    public void add_JobTitle_By_Entering_All_Valid_Details(String jobTitle, String jobDescription, String note) {
        i_add_a_job_title_by_entering_all_the_valid_details_and_note_in_the_page(jobTitle, jobDescription, note);
    }

    @Then("I should see the Required error message displayed in the Job Titles Text Field")
    public void validate_Required_Error_Message_Is_Present_At_Bottom_Of_Job_Title_Field() {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        jobTitlePage.click_On_Save_Button();
        jobTitlePage.validate_Required_Error_Message_Is_Present_At_Bottom_Of_Job_Title_Field();
    }

    @And("I click on Save Button")
    public void click_On_Save_Button() {
        StepDefinition stepDefinition = new StepDefinition(Hooks.driver);
        stepDefinition.clickOnSaveButton();
    }

    @Then("I should get an error message in the {string} that more than 400 characters are not allowed")
    public void validate_error_message_for_maximum_characters(String errorValidationField) {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        if (errorValidationField.equalsIgnoreCase("job description")) {
            jobTitlePage.validate_error_message_displayed_while_entering_more_than_400_characters("Job Description");
        } else if (errorValidationField.equalsIgnoreCase("note")) {
            jobTitlePage.validate_error_message_displayed_while_entering_more_than_400_characters("Note");
        }
    }

    @When("I add a Job Title with more characters in the different fields {string} {string} {string}")
    public void add_Job_Title_with_more_characters_in_different_fields(String jobTitle, String jobDescription, String note) {
        i_add_a_job_title_by_entering_all_the_valid_details_and_note_in_the_page(jobTitle, jobDescription, note);
    }

    @And("I open the Job Title dropdown in Job Section and I select the same {string} that I added from Admin menu and save it")
    public void open_Job_Title_Dropdown_In_Job_Section(String jobTitle) {
        JobPage jobPage = new JobPage(Hooks.driver);
        jobPage.select_Option_From_JobTitle_Dropdown(jobTitle);
    }

    @When("I open the Job Title dropdown in the Job Section")
    public void i_open_jobTitle_dropdown_in_job_section() {
        JobPage jobPage = new JobPage(Hooks.driver);
        jobPage.click_On_JobTitle_Dropdown();
    }

    @And("I select the {string} that I added from the Admin menu")
    public void i_select_job_title_that_I_added_from_admin_menu(String jobTitle) {
        JobPage jobPage = new JobPage(Hooks.driver);
        jobPage.select_Option_From_JobTitle_Dropdown(jobTitle);
    }

    @And("I save the selected Job Title")
    public void i_save_jobTitle() {
        StepDefinition stepDefinition = new StepDefinition(Hooks.driver);
        stepDefinition.clickOnSaveButton();
    }

    @Then("I validate that the Job Title is displayed correctly in the {string} Input Box")
    public void validate_JobTitle_displayed_correctly_In_JobTitle_InputBox(String jobTitle) {
        JobPage jobPage = new JobPage(Hooks.driver);
        jobPage.validate_Job_Title_Displayed_In_JobTitle_TextBox(jobTitle);
    }

    @Then("I delete all the Job Titles that I added {string}")
    public void delete_job_titles_from_job_title_table(String jobTitle) {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        StepDefinition stepDefinition = new StepDefinition(Hooks.driver);

        jobTitlePage.delete_Job_Title_From_Table(jobTitle);
//        stepDefinition.click
    }

    @Then("I delete all the Job Titles in the Job Title Table")
    public void delete_all_job_titles_from_job_title_table() {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        jobTitlePage.deleteAllJobTitlesFromJobTitlePage();
    }

    @And("I validate that the Job Title is displayed correctly in the employee's profile {string} {string}")
    public void validate_Job_Title_Is_Displayed_In_Employee_Profile(String jobTitle, String updatedJobTitle) {
        JobPage jobPage = new JobPage(Hooks.driver);
        jobPage.validate_Job_Title_Displayed_In_JobTitle_TextBox(jobTitle + updatedJobTitle);
    }

    @And("I click on Edit Button for the Job Title {string}")
    public void click_on_edit_button_for_job_title(String jobTitle) {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        jobTitlePage.click_On_Edit_Icon_In_Job_Titles_Table(jobTitle);
    }

    @And("I edit the Job Title Name and save it {string} {string}")
    public void edit_job_title_and_save_it(String updatedJobTitle, String jobTitle) {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        String newJobTitle = jobTitle + updatedJobTitle;

        jobTitlePage.enterJobTitle(updatedJobTitle);
        jobTitlePage.click_On_Save_Button();
        jobTitlePage.validate_Job_Title_Is_Present_In_JobTitle_Table(newJobTitle);
    }

    @Then("I validate No Records Found Text is displayed above the Job Titles table")
    public void validate_No_Records_Found_Text_Displayed_above_Job_Titles_Table() {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        jobTitlePage.validate_No_Records_Found_Text_Displayed();
    }

    @And("I validate that no Job Title is displayed in the Job Titles Table")
    public void validate_No_JobTitle_Displayed_In_Job_Titles_Table() {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        jobTitlePage.validate_No_Records_Found_In_Table();
    }


    //    These are Job Page methods PIM -> Job
    @And("I open the Job Title dropdown in Job Section and I validate that 'No Records Found' Message is displayed")
    public void validate_No_Records_Found_Text_Displayed_In_JobTitles_Dropdown() {
        JobPage jobPage = new JobPage(Hooks.driver);
        jobPage.validate_No_Records_Found_Is_Displayed_In_JobTitle_Dropdown();
    }

    @And("I navigate to My Info Page")
    public void navigate_To_MyInfo_Page() {
        SideMenu sideMenu = new SideMenu(Hooks.driver);
        PersonalDetails personalDetails = new PersonalDetails(Hooks.driver);

        sideMenu.clickOnMyInfoLink();
        personalDetails.validate_Personal_Details_Header();
    }

    @And("I validate that the Job Title is displayed correctly in the employee's profile {string}")
    public void validate_Job_Title_Is_Displayed_In_Employee_Profile(String jobTitle) {
        JobPage jobPage = new JobPage(Hooks.driver);
        jobPage.validate_Job_Title_Displayed_In_JobTitle_TextBox(jobTitle);
    }

    @Then("I should see that no Job Title is displayed in the Job Title Input Box")
    public void validate_No_Job_Title_Displayed_In_Job_Title_Input_Box() {
        JobPage jobPage = new JobPage(Hooks.driver);
        jobPage.validate_No_Job_Title_Displayed_In_JobTitle_InputBox();
    }

    @Then("I validate that the 'Deleted' text is displayed in the {string} Input Box")
    public void validate_JobTitle_Deleted_Text_Is_Displayed_In_JobTitle_InputBox(String jobTitle) {
        JobPage jobPage = new JobPage(Hooks.driver);
        jobPage.validate_JobTitle_Deleted_Text_Is_Displayed_In_JobTitle_InputBox(jobTitle);
    }

    @And("I click on Edit option for the employee {string} {string}")
    public void click_on_Edit_Button_For_Employee(String firstName, String middleName) {
        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(Hooks.driver);
        employeeInformationPage.click_On_Edit_Button_For_Employee_Name(firstName, middleName);
    }
}
