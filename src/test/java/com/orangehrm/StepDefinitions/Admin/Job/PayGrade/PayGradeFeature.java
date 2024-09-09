package com.orangehrm.StepDefinitions.Admin.Job.PayGrade;

import com.orangehrm.pages.Admin.AdminTopNavMenu.AdminTopNavMenu;
import com.orangehrm.pages.Admin.Job.PayGrades.PayGradesPage;
import com.orangehrm.StepDefinitions.Hooks.Hooks;
import com.orangehrm.base.StepDefinition;
import com.orangehrm.pages.SideMenu.SideMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PayGradeFeature {
    @Then("I navigate to Pay Grades Page")
    public void i_navigate_to_pay_grades_page() {
        SideMenu sideMenu = new SideMenu(Hooks.driver);
        AdminTopNavMenu adminTopNavMenu = new AdminTopNavMenu(Hooks.driver);

        sideMenu.clickOnAdminLink();
        adminTopNavMenu.navigate_To_PayGrades_Page();
    }

    @When("I click on Add Button and navigate to Add Pay Grades page")
    public void click_on_Add_Button_And_Navigate_to_Add_Pay_Grades_page() {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        payGradesPage.click_On_PayGrades_AddButton();
        payGradesPage.validate_AddPayGrade_Title();
    }

    @Then("I should be able to see all the UI elements are placed correctly on the Add Pay Grade Page")
    public void validate_All_UI_Elements_are_placed_correctly_on_the_Add_Pay_grades_Page() {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        payGradesPage.validate_AddPayGrade_Title();
    }

    @And("I delete all the Pay Grades")
    public void delete_All_PayGrades_In_PayGrades_Table() {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        payGradesPage.deleteAllPayGradesFromPayGradesPage();
    }

    @Given("there are no Pay Grades in the Pay Grades table")
    public void validate_No_PayGrades_Are_Present_In_Table() {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        payGradesPage.validate_No_PayGrades_Present();
    }

    @When("I add a valid {string}")
    public void add_PayGrade_By_Entering_Valid_PayGrade(String payGradeName) {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        payGradesPage.validate_PayGrades_Title();
        payGradesPage.click_On_PayGrades_AddButton();
        payGradesPage.validate_AddPayGrade_Title();
        payGradesPage.enter_PayGrade_Name(payGradeName);
    }

    @When("I add the currency {string} for the {string} with a minimum salary of {string} and a maximum salary of {string}")
    public void add_Valid_Currency_For_PayGrade(String currencyName, String payGrade, String minimumSalary, String maximumSalary) {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
//        payGradesPage.validate_Edit_PayGrade_Title();

        payGradesPage.click_On_Edit_For_PayGrade(payGrade);
        payGradesPage.click_On_AddCurrency_Button();
        payGradesPage.select_CurrencyName_From_Dropdown(currencyName);
        payGradesPage.enter_Minimum_Salary(minimumSalary);
        payGradesPage.enter_Maximum_Salary(maximumSalary);
    }

    @And("I click on Currency Save Button")
    public void click_On_Currency_Save_Button() {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        payGradesPage.click_On_AddCurrency_SaveButton();
    }

    @Then("I should see that the {string} is successfully added into the system")
    public void validate_Currency_Is_Added(String currency) {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        payGradesPage.validate_Currency_Is_Successfully_Added(currency);
    }

    @Then("I validate that the number of records is increased")
    public void validate_Number_Of_Records_Increased() {

    }

    @And("I validate that the {string} is added successfully into the system")
    public void validate_PayGrade_Is_Added(String payGrade) {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        i_navigate_to_pay_grades_page();
        payGradesPage.validate_PayGrade_Is_Successfully_Added(payGrade);
    }

    @Then("I validate the message that Pay Grade already exists")
    public void validate_Already_Exists_Message() {
        StepDefinition stepDefinition = new StepDefinition(Hooks.driver);
        stepDefinition.validate_Already_Exists_Error_Message();
    }

    @Then("I validate the error message that 'Should be higher than Minimum Salary'")
    public void validate_Error_Message_Should_be_higher_than_Minimum_Salary() {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        payGradesPage.validate_Error_Message_When_Maximum_Salary_Is_Greater_Than_Minimum_Salary();
    }

    @When("I add a Pay Grade with all fields empty")
    public void add_PayGrade_With_All_Fields_Empty() {
        click_on_Add_Button_And_Navigate_to_Add_Pay_Grades_page();
    }

    @Then("I validate that the {string} and {string} is displayed successfully into the system")
    public void validate_PayGrade_And_Currency_Displayed_In_Table(String payGrade, String currency) {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        payGradesPage.validate_Currency_And_PayGrade_Is_Displayed_In_Table();
    }

    @Then("I validate that I am on the Pay Grades Page")
    public void validate_User_Is_On_PayGrades_Page() {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        payGradesPage.validate_All_Elements_Of_PayGrades_Page();
    }
}
