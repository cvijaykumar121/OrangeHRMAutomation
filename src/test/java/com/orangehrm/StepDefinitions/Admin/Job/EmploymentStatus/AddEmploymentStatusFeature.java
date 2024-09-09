package com.orangehrm.StepDefinitions.Admin.Job.EmploymentStatus;

import com.orangehrm.StepDefinitions.Hooks.Hooks;
import com.orangehrm.base.StepDefinition;
import com.orangehrm.pages.Admin.AdminTopNavMenu.AdminTopNavMenu;
import com.orangehrm.pages.Admin.Job.EmploymentStatus.EmploymentStatusPage;
import com.orangehrm.pages.Admin.Job.JobTitle.JobTitlePage;
import com.orangehrm.pages.SideMenu.SideMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmploymentStatusFeature {
    public static int numberOfRecords = 0;

    @Then("I navigate to Employment Status Page")
    public void i_navigate_to_employment_status_page() {
        SideMenu sideMenu = new SideMenu(Hooks.driver);
        AdminTopNavMenu adminTopNavMenu = new AdminTopNavMenu(Hooks.driver);
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);

        sideMenu.clickOnAdminLink();
        adminTopNavMenu.navigate_To_EmploymentStatus_Page();
        employmentStatusPage.validate_Employment_Status_Title();
    }

    @And("I am on the Employment Status Page")
    public void validate_Employment_Status_Page() {
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);
        employmentStatusPage.validate_Employment_Status_Title();
    }

    @And("I delete all the Employment Status from the Employment Status Table")
    @Then("I validate there are no Employment Status present in Employment Status Table")
    @Given("there are no Employment Status present in the Employment Status Table")
    public void delete_All_Employment_Status_From_Employment_Status_Table() {
        StepDefinition stepDefinition = new StepDefinition(Hooks.driver);
        stepDefinition.deleteAllPayGradesFromPayGradesPage();
    }

    @And("I navigate to the Add Employment Status Page")
    public void navigate_To_Add_Employment_Status_Page() {
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);
        employmentStatusPage.click_On_Employment_Status_Add_Button();
        employmentStatusPage.validate_Add_Employment_Status_Title();
    }

    @When("I enter an {string} of more than the permissible characters")
    @And("I enter a valid {string} into the Employment Status field")
    @When("I enter an {string} that already exists")
    public void enter_Employment_Status(String employmentStatus) {
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);
        employmentStatusPage.enter_EmploymentStatus_Name(employmentStatus);
    }

    @Then("the {string} should be successfully saved and displayed in the Employment Status Table")
    public void employment_Status_Should_Be_Saved_Successfully(String employmentStatus) {
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);
        employmentStatusPage.validate_EmploymentStatus_Is_Displayed_In_Table(employmentStatus);
    }

    @And("the number of records displayed should also be increased")
    public void validate_Number_Of_Records_Displayed_Is_Increased() {
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);
        employmentStatusPage.validate_Number_Records_Increased(numberOfRecords);
    }

    @Given("I am on the Add Employment Status Page")
    public void validate_Add_Employment_Status_Page() {
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);

        employmentStatusPage.click_On_Employment_Status_Add_Button();
        employmentStatusPage.validate_Add_Employment_Status_Title();
    }

    @Then("I should get an {string}")
    public void validate_Error_Message(String errorMessage) {
        StepDefinition stepDefinition = new StepDefinition(Hooks.driver);
        stepDefinition.validate_Error_Message(errorMessage);
    }

    @And("I click on Cancel Button")
    public void click_On_Cancel_Button() {
        StepDefinition stepDefinition = new StepDefinition(Hooks.driver);
        stepDefinition.clickOnCancelButton();
    }

    @Then("the {string} should not be added in the table")
    public void validate_Employment_Status_Is_Not_Added(String employmentStatus) {
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);
        employmentStatusPage.validate_EmploymentStatus_Is_Not_Displayed_In_Table(employmentStatus);
    }

    @And("I open the Employment Status dropdown in the Job Section")
    public void open_Employment_Status_Dropdown() {
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);
        employmentStatusPage.click_On_Employment_Status_Dropdown();
    }

    @And("I validate that the Employment Status {string} is displayed correctly in the employee's profile")
    public void validate_Job_Title_Is_Displayed_In_Employee_Profile(String employmentStatus) {
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);
        employmentStatusPage.validate_EmploymentStatus_Displayed_In_EmploymentStatus_TextBox(employmentStatus);
    }

    @And("I click on Edit Button for the Employment Status {string}")
    public void click_On_Edit_Button_For_EmploymentStatus(String employmentStatus) {
        JobTitlePage jobTitlePage = new JobTitlePage(Hooks.driver);
        jobTitlePage.click_On_Edit_Icon_In_Job_Titles_Table(employmentStatus);
    }

    @And("I edit the Employment Status Name to {string}")
    public void edit_Employment_Status_Name(String updatedEmploymentStatus) {
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);
        employmentStatusPage.enter_EmploymentStatus_Name(updatedEmploymentStatus);
    }

    @Then("I validate that the Employment Status is displayed in the Employment Status table {string} {string}")
    public void validate_Updated_Employment_Status_Displayed_In_Table(String employmentStatus, String updatedEmploymentStatus) {
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);
        employmentStatusPage.validate_Employment_Status_Title();
        employmentStatusPage.validate_EmploymentStatus_Is_Displayed_In_Table(employmentStatus + updatedEmploymentStatus);
    }
}
