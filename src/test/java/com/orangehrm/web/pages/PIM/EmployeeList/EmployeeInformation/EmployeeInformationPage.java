package com.orangehrm.web.pages.PIM.EmployeeList.EmployeeInformation;

import com.orangehrm.web.base.TestBase;
import com.orangehrm.web.pages.Admin.UserManagement.Users.UsersPage;
import com.orangehrm.web.pages.PIM.AddEmployee.AddEmployee;
import org.openqa.selenium.WebDriver;

public class EmployeeInformationPage extends TestBase {
    public WebDriver driver;
    public EmployeeInformationLocators employeeInformationLocators;
    public AddEmployee addEmployee;
    public UsersPage usersPage;

    public EmployeeInformationPage(WebDriver driver) {
        this.driver = driver;
        this.employeeInformationLocators = new EmployeeInformationLocators(driver);
        this.addEmployee = new AddEmployee(driver);
        this.usersPage = new UsersPage(driver);
    }

    public void click_On_Employee_List_Button() {
        clickElement(employeeInformationLocators.employeeListNavButton, "Clicked on Employee list nav button", true, 30);
    }

    public void validate_Employee_Information_Title() {
        validateText(employeeInformationLocators.employeeInformationTitle, "Employee Information", "Validated Employee Information Page", 30);
    }

    public void enterEmployeeName(String employeeName) {
        sendKeys(employeeInformationLocators.employeeNameInputBox, employeeName, "Successfully entered " + employeeName + " into employee name input box", 30);
    }

    public void enterEmployeeID(String employeeID) {
        addEmployee.enterEmployeeID(employeeID);
    }

    public void clickOnSearchButton() {
        usersPage.click_On_Search_Button();
    }
}
