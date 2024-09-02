package com.orangehrm.StepDefinitions.Admin.Job.WorkShifts;

import com.orangehrm.StepDefinitions.Hooks;
import com.orangehrm.pages.Admin.AdminTopNavMenu.AdminTopNavMenu;
import com.orangehrm.pages.Admin.Job.Workshifts.WorkShiftsPage;
import com.orangehrm.pages.SideMenu.SideMenu;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class AddWorkShiftFeature {
    @Then("I navigate to Work Shifts Page")
    public void i_navigate_to_Work_Shifts_Page() {
        AdminTopNavMenu adminTopNavMenu = new AdminTopNavMenu(Hooks.driver);
        WorkShiftsPage workShiftsPage = new WorkShiftsPage(Hooks.driver);
        SideMenu sideMenu = new SideMenu(Hooks.driver);

        sideMenu.clickOnAdminLink();
        adminTopNavMenu.navigate_To_WorkShifts_Page();
    }

    @When("I navigate to Add Work Shift Page")
    public void navigate_To_Add_Work_Shift_Page() {
        WorkShiftsPage workShiftsPage = new WorkShiftsPage(Hooks.driver);
        workShiftsPage.click_On_WorkShifts_Add_Button();
        workShiftsPage.validate_Add_WorkShift_Title();
    }

    @Then("I validate Work Shifts Page")
    @Then("I validate that after adding valid Work Shift, user is redirected to Work Shifts Page")
    public void validate_WorkShifts_Page() {
        WorkShiftsPage workShiftsPage = new WorkShiftsPage(Hooks.driver);
        workShiftsPage.validate_WorkShifts_Title();
    }

    @Then("I validate all the column names of Work Shifts Table is displayed")
    public void validate_Column_Names_Of_Work_Shifts_Table() {
        WorkShiftsPage workShiftsPage = new WorkShiftsPage(Hooks.driver);
        workShiftsPage.validate_Checkbox_Column_Header();
        workShiftsPage.validate_Name_Column_Header();
        workShiftsPage.validate_From_Column_Header();
        workShiftsPage.validate_To_Column_Header();
        workShiftsPage.validate_HoursPerDay_Column_Header();
        workShiftsPage.validate_Actions_Column_Header();
    }

    @And("I enter the {string} Shift Name")
    public void enterShiftName(String shiftName) {
        WorkShiftsPage workShiftsPage = new WorkShiftsPage(Hooks.driver);
        workShiftsPage.enter_WorkShift_Name(shiftName);
    }

    @And("I enter the Working Hours {string} {string}")
    public void enterWorkingHours(String from, String to) {
        WorkShiftsPage workShiftsPage = new WorkShiftsPage(Hooks.driver);
        workShiftsPage.enter_WorkingHours_From_Timing(from);
        workShiftsPage.enter_WorkingHours_To_Timing(to);
    }

    @And("I assign the Employees to the Working Hours")
    public void assignEmployeesToWorkingHours(DataTable dataTable) {
        WorkShiftsPage workShiftsPage = new WorkShiftsPage(Hooks.driver);
        List<Map<String, String>> shifts = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> shift : shifts) {
            String employeeName = shift.get("Employee Name");
            workShiftsPage.enter_Assigned_Employees(employeeName);
            workShiftsPage.validateEmployeeAdded(employeeName);
        }
    }
}
