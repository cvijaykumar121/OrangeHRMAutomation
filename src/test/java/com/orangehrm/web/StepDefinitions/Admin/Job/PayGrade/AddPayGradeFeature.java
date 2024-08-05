package com.orangehrm.web.StepDefinitions.Admin.Job.PayGrade;

import com.orangehrm.web.StepDefinitions.Hooks;
import com.orangehrm.web.pages.Admin.AdminTopNavMenu.AdminTopNavMenu;
import com.orangehrm.web.pages.Admin.Job.PayGrades.PayGradesPage;
import com.orangehrm.web.pages.SideMenu.SideMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddPayGradeFeature {
    @Then("I navigate to Add Pay Grades Page")
    public void i_navigate_to_add_pay_grades_page() {
        Hooks hooks = new Hooks();
        SideMenu sideMenu = new SideMenu(hooks.getDriver());
        AdminTopNavMenu adminTopNavMenu = new AdminTopNavMenu(hooks.getDriver());

        sideMenu.clickOnAdminLink();
        adminTopNavMenu.navigate_To_PayGrades_Page();
    }

    @And("I add a {string} and save it")
    public void i_add_pay_grade_and_save_it(String payGrade) {
        Hooks hooks = new Hooks();
        PayGradesPage payGradesPage = new PayGradesPage(hooks.getDriver());

        payGradesPage.addPayGrades_WithValidDetails(payGrade);
    }

    @And("I add {string} to that Pay grade and save it {string} {string}")
    public void i_add_currency_to_payGrade_and_save_it(String currencyName, String maximumSalary, String minimumSalary) {
        Hooks hooks = new Hooks();
        PayGradesPage payGradesPage = new PayGradesPage(hooks.getDriver());
        payGradesPage.addCurrency_WithValidDetails(currencyName, maximumSalary, minimumSalary);
    }
}
