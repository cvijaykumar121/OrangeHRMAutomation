package com.orangehrm.StepDefinitions.Admin.Job.WorkShifts;

import com.orangehrm.StepDefinitions.Hooks;
import com.orangehrm.pages.Admin.AdminTopNavMenu.AdminTopNavMenu;
import com.orangehrm.pages.Admin.Job.Workshifts.WorkShiftsPage;
import com.orangehrm.pages.SideMenu.SideMenu;
import io.cucumber.java.en.Then;

public class AddWorkShiftFeature {
    @Then("I navigate to Work Shifts Page")
    public void i_navigate_to_Work_Shifts_Page() {
        AdminTopNavMenu adminTopNavMenu = new AdminTopNavMenu(Hooks.driver);
        WorkShiftsPage workShiftsPage = new WorkShiftsPage(Hooks.driver);
        SideMenu sideMenu = new SideMenu(Hooks.driver);

        sideMenu.clickOnAdminLink();
        adminTopNavMenu.navigate_To_WorkShifts_Page();

    }
}
