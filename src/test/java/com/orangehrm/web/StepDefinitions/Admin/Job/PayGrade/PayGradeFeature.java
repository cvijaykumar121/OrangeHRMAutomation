package com.orangehrm.web.StepDefinitions.Admin.Job.PayGrade;

import com.orangehrm.web.StepDefinitions.Hooks;
import com.orangehrm.web.pages.Admin.AdminTopNavMenu.AdminTopNavMenu;
import com.orangehrm.web.pages.Admin.Job.PayGrades.PayGradesPage;
import com.orangehrm.web.pages.SideMenu.SideMenu;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PayGradeFeature {
    @Then("I navigate to Add Pay Grades Page")
    public void i_navigate_to_add_pay_grades_page() {
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

    @Given("I delete all the Pay Grades in the Pay Grades Table")
    public void delete_All_PayGrades_In_PayGrades_Table() {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        payGradesPage.deleteAllPayGradesFromPayGradesPage();
    }

    @When("I add a {string} by entering valid Pay Grade")
    public void add_PayGrade_By_Entering_Valid_PayGrade(String payGradeName) {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        payGradesPage.enter_PayGrade_Name(payGradeName);
    }

    @Then("I add {string} for the Pay Grade {string} {string}")
    public void add_Valid_Currency_For_PayGrade(String currencyName, String minimumSalary, String maximumSalary) {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);
        payGradesPage.select_CurrencyName_From_Dropdown(currencyName);
        payGradesPage.enter_Minimum_Salary(minimumSalary);
        payGradesPage.enter_Maximum_Salary(maximumSalary);
    }

    @Then("I validate that the Pay Grade and the associated Currency is successfully added into the system")
    public void validate_PayGrade_And_Currency_Is_Added() {
        PayGradesPage payGradesPage = new PayGradesPage(Hooks.driver);

    }
}
