package com.orangehrm.pages.Admin.Configuration.EmailSubscriptions;

import com.orangehrm.base.StepDefinition;
import com.orangehrm.base.TestBase;
import com.orangehrm.pages.Admin.AdminTopNavMenu.AdminTopNavMenuLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EmailSubscriptionsPage extends TestBase {
    public WebDriver driver;
    public EmailSubscriptionsLocators emailSubscriptionsLocators;
    public StepDefinition stepDefinition;
    public AdminTopNavMenuLocators adminTopNavMenuLocators;

    public EmailSubscriptionsPage(WebDriver driver) {
        this.driver = driver;
        this.emailSubscriptionsLocators = new EmailSubscriptionsLocators(driver);
        adminTopNavMenuLocators = new AdminTopNavMenuLocators(driver);
        this.stepDefinition = new StepDefinition(driver);
    }

    public void validate_Email_Subscription_Page() {
        waitForElementToBeVisible(emailSubscriptionsLocators.emailSubscriptionsHeader, 40, "Validated Email Subscription Page");
    }

    private void click_On_Add_User_For_Leave_Applications() {
        clickElement(emailSubscriptionsLocators.addUserButtonForLeaveApplications, "Clicked on Add user icon for leave applications", true, 40);
    }

    public void click_On_Add_User(String notificationType) {
        switch (notificationType) {
            case "Leave Applications":
                click_On_Add_User_For_Leave_Applications();
                break;

            case "Leave Approvals":
                click_On_Add_User_For_Leave_Approvals();
                break;

            case "Leave Assignments":
                click_On_Add_User_For_Leave_Assignments();
                break;

            case "Leave Cancellations":
                click_On_Add_User_For_Leave_Cancellations();
                break;

            case "Leave Rejections":
                click_On_Add_User_For_Leave_Rejections();
                break;
        }
    }

    public void validate_Leave_Applications_Subscribers_Page() {
        validateText(emailSubscriptionsLocators.leaveApplicationsSubscribersHeader, "Subscribers: Leave Applications", "Validated Subscribers: Leave Applications header", 50);
    }

    public void click_On_Add_Button() {
        stepDefinition.click_On_Add_Button();
    }

    public void enterName(String name) {
        sendKeys(emailSubscriptionsLocators.nameInput, name, "Entered name", 30);
    }

    public void enterEmail(String email) {
        sendKeys(emailSubscriptionsLocators.emailInput, email, "Entered email", 40);
    }

    public void click_On_Save_Button() {
        stepDefinition.clickOnSaveButton();
    }

    public void validate_Name_Added_Into_The_Table(String name) {
        validateText(emailSubscriptionsLocators.valueInTable(name), name, "Validated Name in table", 30);
    }

    public void validate_Email_Added_Into_The_Table(String email) {
        validateText(emailSubscriptionsLocators.valueInTable(email), email, "Validated Email in table", 30);
    }

    public void click_On_Cancel_Button() {
        stepDefinition.clickOnCancelButton();
    }

    private void click_On_Add_User_For_Leave_Approvals() {
        clickElement(emailSubscriptionsLocators.addUserButtonForLeaveApprovals, "Clicked on Add user icon for leave approvals", true, 40);
    }
    private void click_On_Add_User_For_Leave_Cancellations() {
        clickElement(emailSubscriptionsLocators.addUserButtonForLeaveCancellations, "Clicked on Add user icon for leave cancellations", true, 40);
    }
    private void click_On_Add_User_For_Leave_Assignments() {
        clickElement(emailSubscriptionsLocators.addUserButtonForLeaveAssignments, "Clicked on Add user icon for leave assignments", true, 40);
    }
    private void click_On_Add_User_For_Leave_Rejections() {
        clickElement(emailSubscriptionsLocators.addUserButtonForLeaveRejections, "Clicked on Add user icon for leave rejections", true, 40);
    }

    public void delete_User_From_Leave_Applications_Notifications(String emailOfUser) {
        clickElement(emailSubscriptionsLocators.deleteButtonForSpecificUser(emailOfUser), "Clicked on delete button for user", true, 40);
        stepDefinition.handle_Delete_Pop_Up(true);
        stepDefinition.validate_Table_Header_Is_Present();
    }

    private void click_On_User_Edit_Option(String emailOfUser) {
        clickElement(emailSubscriptionsLocators.editButtonForSpecificUser(emailOfUser), "Clicked on edit button for user", true, 40);
    }

    public void update_Email_Address(String email) {
        click_On_User_Edit_Option(email);
        waitForElementToBeVisible(emailSubscriptionsLocators.editSubscriberHeader, 40);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        emailSubscriptionsLocators.emailInput.clear();
        enterEmail(email);
    }

    public void validate_No_Duplicate_Entries_In_Table(String email) {
        List<WebElement> usersInTable = emailSubscriptionsLocators.usersInTable(email);
        System.out.println("Total users with email: " + usersInTable.size());
        if(usersInTable.size() == 1) {
            logPass("PASS: No duplicate entry", true);
        } else {
            logFail("FAIL: Duplicate entries are present", true);
        }
    }

    public void validate_No_User_Present(String email) {
        List<WebElement> usersInTable = emailSubscriptionsLocators.usersInTable(email);
        System.out.println("Total users with email: " + usersInTable.size());
        if(usersInTable.size() == 0) {
            logPass("PASS: No entry with email: " + email + " present", true);
        } else {
            logFail("FAIL: Entry with email: " + email + " is present", true);
        }
    }

    public void validate_Users_Present_In_Table() {
        stepDefinition.validate_Table_Header_Is_Present();
        List<WebElement> allUsersInTable = emailSubscriptionsLocators.allUsersInTable;
        if(allUsersInTable.size() > 1) {
            logPass("Users present in table", true);
        } else {
            logFail("Users are not present in table", true);
        }
    }

    public void validate_Leave_Approvals_Subscriber_Page() {
        validateText(emailSubscriptionsLocators.leaveApprovalsSubscriberHeader, "Subscribers: Leave Approvals", "Validated Subscribers: Leave Approvals header", 50);
    }
}
