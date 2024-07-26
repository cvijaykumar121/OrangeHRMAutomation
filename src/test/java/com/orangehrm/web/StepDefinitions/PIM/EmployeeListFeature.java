package com.orangehrm.web.StepDefinitions.PIM;

import com.orangehrm.web.StepDefinitions.Hooks;
import com.orangehrm.web.pages.PIM.EmployeeList.EmployeeInformation.EmployeeInformationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EmployeeListFeature {
    @And("I click on Employee List Button")
    public void click_On_Employee_List_Button() {
        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(Hooks.driver);
        employeeInformationPage.click_On_Employee_List_Button();
    }

    @Then("I enter all details")
    public void enter_All_Details() {
        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(Hooks.driver);
        employeeInformationPage.enterEmployeeName("C Vijay Kumar");
        employeeInformationPage.enterEmployeeID("0410");
    }

    @And("click on Search button")
    public void click_On_Search_Button() {
        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(Hooks.driver);
        employeeInformationPage.clickOnSearchButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
