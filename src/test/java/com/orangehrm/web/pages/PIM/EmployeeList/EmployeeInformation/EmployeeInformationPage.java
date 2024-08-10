package com.orangehrm.web.pages.PIM.EmployeeList.EmployeeInformation;

import com.orangehrm.web.base.StepDefinition;
import com.orangehrm.web.base.TestBase;
import com.orangehrm.web.pages.Admin.Job.JobTitle.JobTitlePage;
import com.orangehrm.web.pages.Admin.UserManagement.Users.UsersPage;
import com.orangehrm.web.pages.PIM.AddEmployee.AddEmployee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EmployeeInformationPage extends TestBase {
    public WebDriver driver;
    public EmployeeInformationLocators employeeInformationLocators;
    public AddEmployee addEmployee;
    public UsersPage usersPage;
    public JobTitlePage jobTitlePage;
    public StepDefinition stepDefinition;

    public EmployeeInformationPage(WebDriver driver) {
        this.driver = driver;
        this.employeeInformationLocators = new EmployeeInformationLocators(driver);
        this.addEmployee = new AddEmployee(driver);
        this.usersPage = new UsersPage(driver);
        this.jobTitlePage = new JobTitlePage(driver);
        this.stepDefinition = new StepDefinition(driver);
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

    public void validate_User_Is_Displayed_After_Clicking_On_Search_Button(String firstName, String middleName, String lastName) {
        List<WebElement> users = employeeInformationLocators.searchUsersList;
        String halfName = firstName + " " + middleName;
        System.out.println("Half Name: " + halfName);
        int numberOfUsers = users.size();
        System.out.println("Users list size: " + numberOfUsers);
        if (numberOfUsers > 0) {
            WebElement row1 = users.get(0);
            WebElement firstNameInTable = row1.findElement(By.xpath("//div[text()='" + halfName + "']"));
            System.out.println("First Name: " + firstNameInTable.getText());
            validateText(firstNameInTable, halfName, "Validated First Name in PIM Table", 30);

            WebElement lastNameInTable = row1.findElement(By.xpath("//div[text()='" + lastName + "']"));
            System.out.println("Last Name: " + lastNameInTable.getText());
            validateText(lastNameInTable, lastName, "Validated Last Name in PIM Table", 30);
        }
    }

    public void click_On_Edit_Button_For_Employee_Name(String firstName, String middleName) {
        String fullName = firstName + " " + middleName;
        WebElement editButton = driver.findElement(By.xpath("//div[@role='table']//div[@class='oxd-table-card']/div//div[text()='" + fullName + "']/parent::div/following-sibling::div/div[@class='oxd-table-cell-actions']//i[@class='oxd-icon bi-pencil-fill']" ));
        clickElement(editButton, "Edit button for " + fullName + " is clicked", true, 20);
    }


    public void delete_Employee_From_PIM(String firstName, String middleName, String lastName) {

        List<WebElement> users = employeeInformationLocators.searchUsersList;
        String halfName = firstName + " " + middleName;
        System.out.println("Half Name: " + halfName);
        int numberOfUsers = users.size();
        System.out.println("Users list size: " + numberOfUsers);
        if (numberOfUsers > 0) {
            for (int i = 0; i < users.size(); i++) {
                WebElement currentUser = users.get(i);
                WebElement trashIcon = currentUser.findElement(By.xpath("//button/i[@class='oxd-icon bi-trash']"));
                clickElement(trashIcon, "Clicked on delete icon", true, 30);
                stepDefinition.handle_Delete_Pop_Up(true);
            }
        }
    }

    public void edit_Employee_From_PIM(String firstName, String middleName) {
        List<WebElement> users = employeeInformationLocators.searchUsersList;
        waitForElementToBeVisible(users.get(0), 40, "Users table is displayed");
        String halfName = firstName + " " + middleName;
        System.out.println("Half Name: " + halfName);
        int numberOfUsers = users.size();
        System.out.println("Users list size: " + numberOfUsers);
        if (numberOfUsers > 0) {
            for (int i = 0; i < users.size(); i++) {
                WebElement currentUser = users.get(i);
                WebElement editIcon = currentUser.findElement(By.xpath("//button/i[@class='oxd-icon bi-pencil-fill']"));
                clickElement(editIcon, "Clicked on Edit icon", true, 30);
            }
        }
    }

    public void deleteAllEmployeesFromPIM() {
        while (isElementPresent(employeeInformationLocators.allEmployeesListInTable)) {
            if (employeeInformationLocators.allEmployeesListInTable.size() > 1) {
                clickElement(employeeInformationLocators.selectAllEmployeesCheckbox, "Clicked on select all employee checkbox", true, 30);
                clickElement(employeeInformationLocators.deleteSelectedButton, "Clicked on delete selected button", true, 30);
                stepDefinition.handle_Delete_Pop_Up(true);

                try {
                    Thread.sleep(5000);  // Waiting for deletion to complete, consider using explicit wait instead
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                logInfo("Only 1 job present, cannot be deleted further", true);
                break;
            }
        }
    }

}

