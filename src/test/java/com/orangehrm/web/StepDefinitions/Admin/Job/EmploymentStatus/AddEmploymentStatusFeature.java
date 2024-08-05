package com.orangehrm.web.StepDefinitions.Admin.Job.EmploymentStatus;

import com.orangehrm.web.StepDefinitions.Hooks;
import com.orangehrm.web.pages.Admin.AdminTopNavMenu.AdminTopNavMenu;
import com.orangehrm.web.pages.Admin.Job.EmploymentStatus.EmploymentStatusPage;
import com.orangehrm.web.pages.SideMenu.SideMenu;
import io.cucumber.java.en.Then;

public class AddEmploymentStatusFeature {
    @Then("I navigate to Employment Status Page")
    public void i_navigate_to_employment_status_page() {
        Hooks hooks = new Hooks();
        SideMenu sideMenu = new SideMenu(hooks.getDriver());
        AdminTopNavMenu adminTopNavMenu = new AdminTopNavMenu(hooks.getDriver());
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(hooks.getDriver());

        sideMenu.clickOnAdminLink();
        adminTopNavMenu.navigate_To_EmploymentStatus_Page();
        employmentStatusPage.validate_Employment_Status_Title();
    }

    @Then("I add an {string} and save it")
    public void i_add_an_employment_status_and_save_it(String employmentStatusName) {
        Hooks hooks = new Hooks();
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(hooks.getDriver());
        employmentStatusPage.validate_Employment_Status_Title();
        employmentStatusPage.click_On_Employment_Status_Add_Button();
        employmentStatusPage.validate_Add_Employment_Status_Title();
        employmentStatusPage.enter_EmploymentStatus_Name(employmentStatusName);
        employmentStatusPage.click_On_Save_Button();
    }

    @Then("I validate that after adding valid Employment status, user is redirected to Employment Status Page")
    public void validate_Employment_Status_Page() {
        Hooks hooks = new Hooks();
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(hooks.getDriver());
        employmentStatusPage.validate_Employment_Status_Title();
    }
}
