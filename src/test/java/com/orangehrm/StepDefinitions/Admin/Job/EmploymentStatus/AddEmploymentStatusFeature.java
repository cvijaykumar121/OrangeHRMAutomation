package com.orangehrm.StepDefinitions.Admin.Job.EmploymentStatus;

import com.orangehrm.StepDefinitions.Hooks;
import com.orangehrm.pages.Admin.AdminTopNavMenu.AdminTopNavMenu;
import com.orangehrm.pages.Admin.Job.EmploymentStatus.EmploymentStatusPage;
import com.orangehrm.pages.SideMenu.SideMenu;
import io.cucumber.java.en.Then;

public class AddEmploymentStatusFeature {
    @Then("I navigate to Employment Status Page")
    public void i_navigate_to_employment_status_page() {
        SideMenu sideMenu = new SideMenu(Hooks.driver);
        AdminTopNavMenu adminTopNavMenu = new AdminTopNavMenu(Hooks.driver);
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);

        sideMenu.clickOnAdminLink();
        adminTopNavMenu.navigate_To_EmploymentStatus_Page();
        employmentStatusPage.validate_Employment_Status_Title();
    }

    @Then("I add an {string} and save it")
    public void i_add_an_employment_status_and_save_it(String employmentStatusName) {
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);
        employmentStatusPage.validate_Employment_Status_Title();
        employmentStatusPage.click_On_Employment_Status_Add_Button();
        employmentStatusPage.validate_Add_Employment_Status_Title();
        employmentStatusPage.enter_EmploymentStatus_Name(employmentStatusName);
        employmentStatusPage.click_On_Save_Button();
    }

    @Then("I validate that after adding valid Employment status, user is redirected to Employment Status Page")
    public void validate_Employment_Status_Page() {
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(Hooks.driver);
        employmentStatusPage.validate_Employment_Status_Title();
    }
}
