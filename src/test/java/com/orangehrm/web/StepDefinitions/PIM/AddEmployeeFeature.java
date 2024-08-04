package com.orangehrm.web.StepDefinitions.PIM;

import com.orangehrm.web.StepDefinitions.Hooks;
import com.orangehrm.web.base.StepDefinition;
import com.orangehrm.web.pages.PIM.AddEmployee.AddEmployee;
import com.orangehrm.web.pages.PIM.EmployeeList.EmployeeInformation.EmployeeInformationPage;
import com.orangehrm.web.pages.PIM.EmployeeList.Job.JobPage;
import com.orangehrm.web.pages.PIM.EmployeeList.PersonalDetails.PersonalDetails;
import com.orangehrm.web.pages.SideMenu.SideMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;

public class AddEmployeeFeature {
    @When("I navigate to the PIM module")
    public void navigate_To_PIM_Module() {
        SideMenu sideMenu = new SideMenu(Hooks.driver);
        sideMenu.clickOnPIMLink();
    }

    @And("I click on the Add Employee button")
    public void click_On_Add_Employee_Button() {
        AddEmployee addEmployee = new AddEmployee(Hooks.driver);
        addEmployee.clickOnAddEmployeeNavButton();
    }

    @And("I click on the Add Employee button and enter all the employee details without Login Details {string} {string} {string} {string}")
    public void enter_Add_Employee_Page_Details(String firstName, String middleName, String lastName, String employeeID) {
        AddEmployee addEmployee = new AddEmployee(Hooks.driver);
        PersonalDetails personalDetails = new PersonalDetails(Hooks.driver);

        addEmployee.clickOnAddEmployeeNavButton();
        addEmployee.enterFirstName(firstName);
        addEmployee.enterMiddleName(middleName);
        addEmployee.enterLastName(lastName);
        addEmployee.enterEmployeeID(employeeID);
        addEmployee.clickOnSaveButton();

        personalDetails.validate_Personal_Details_Header();
    }

    @Then("I add an employee in PIM along with their login credentials {string} {string} {string} {string} {string} {string} {string} {string}")
    public void add_Employee_In_PIM_With_Their_Login_Credentials(String firstName, String middleName, String lastName, String employeeId, String username, String status, String password, String confirmPassword) {
        AddEmployee addEmployee = new AddEmployee(Hooks.driver);
        PersonalDetails personalDetails = new PersonalDetails(Hooks.driver);
        StepDefinition stepDefinition = new StepDefinition(Hooks.driver);

        navigate_To_PIM_Module();
        click_On_Add_Employee_Button();

        addEmployee.enterFirstName(firstName);
        addEmployee.enterMiddleName(middleName);
        addEmployee.enterLastName(lastName);
        addEmployee.enterEmployeeID(employeeId);
        addEmployee.turnOnLoginDetailsCheckbox();
        addEmployee.enterUsername(username);
        addEmployee.selectStatus(status);
        addEmployee.enterPassword(password);
        addEmployee.enterConfirmPassword(confirmPassword);

        stepDefinition.clickOnSaveButton();

        personalDetails.validate_Personal_Details_Header();
    }

    @An("I navigate to Job Page")
    public void navigate_To_Job_page() {
        JobPage jobPage = new JobPage(Hooks.driver);
        jobPage.navigate_To_Job_Page();
    }
}
