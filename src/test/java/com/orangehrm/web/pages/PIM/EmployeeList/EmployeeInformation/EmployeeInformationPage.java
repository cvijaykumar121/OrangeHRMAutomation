package com.orangehrm.web.pages.PIM.EmployeeList.EmployeeInformation;

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

    public EmployeeInformationPage(WebDriver driver) {
        this.driver = driver;
        this.employeeInformationLocators = new EmployeeInformationLocators(driver);
        this.addEmployee = new AddEmployee(driver);
        this.usersPage = new UsersPage(driver);
        this.jobTitlePage = new JobTitlePage(driver);
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
        if(numberOfUsers > 0) {
            WebElement row1 = users.get(0);
            WebElement firstNameInTable = row1.findElement(By.xpath("//div[text()='" + halfName + "']"));
            System.out.println("First Name: " + firstNameInTable.getText());
            validateText(firstNameInTable, halfName, "Validated First Name in PIM Table", 30);

            WebElement lastNameInTable = row1.findElement(By.xpath("//div[text()='" + lastName + "']"));
            System.out.println("Last Name: " + lastNameInTable.getText());
            validateText(lastNameInTable, lastName, "Validated Last Name in PIM Table", 30);
        }
    }

    public void delete_Employee_From_PIM(String firstName, String middleName, String lastName) {

        List<WebElement> users = employeeInformationLocators.searchUsersList;
        String halfName = firstName + " " + middleName;
        System.out.println("Half Name: " + halfName);
        int numberOfUsers = users.size();
        System.out.println("Users list size: " + numberOfUsers);
        if(numberOfUsers > 0) {
            for(int i=0; i<users.size(); i++) {
                WebElement currentUser = users.get(i);
                WebElement trashIcon = currentUser.findElement(By.xpath("//button/i[@class='oxd-icon bi-trash']"));
                clickElement(trashIcon, "Clicked on delete icon", true, 30);
                jobTitlePage.handle_Delete_Pop_Up(true);
            }
        }
    }



    public void pagination() {
        List<WebElement> paginationNumbers = employeeInformationLocators.paginationNumbers;
        if(paginationNumbers.isEmpty()) {
            System.out.println("Pagination not found");
        }
        int totalPages = paginationNumbers.size();
        for (int i = 0; i < totalPages; i++) {
            WebElement currentPaginationNumber = paginationNumbers.get(i);
            System.out.println(currentPaginationNumber.getText());
            clickElement(paginationNumbers.get(i), "Clicked on page number", true, 30);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==0) {
                i=i+1;
            }
        }
    }
}
