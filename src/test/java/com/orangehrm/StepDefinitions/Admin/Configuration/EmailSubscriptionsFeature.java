package com.orangehrm.StepDefinitions.Admin.Configuration;

import com.orangehrm.StepDefinitions.Hooks.Hooks;
import com.orangehrm.base.StepDefinition;
import com.orangehrm.pages.Admin.AdminTopNavMenu.AdminTopNavMenu;
import com.orangehrm.pages.Admin.Configuration.EmailSubscriptions.EmailSubscriptionsPage;
import com.orangehrm.pages.SideMenu.SideMenu;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class EmailSubscriptionsFeature {

    @Given("I am on the Email Subscriptions Page")
    public void validate_Email_Subscriptions_Page() {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.validate_Email_Subscription_Page();
    }

    @And("I navigate to the Email Subscriptions Page")
    public void navigate_To_Email_Subscription_Page() {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        AdminTopNavMenu adminTopNavMenu = new AdminTopNavMenu(Hooks.driver);
        SideMenu sideMenu = new SideMenu(Hooks.driver);

        sideMenu.clickOnAdminLink();
        adminTopNavMenu.navigate_To_Email_Subscription_Page();
        emailSubscriptionsPage.validate_Email_Subscription_Page();
    }

    @When("I select the {string} notification type")
    public void click_On_Add_User_For_Leave_Application_Type(String leaveApplications) {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.click_On_Add_User(leaveApplications);
        if(leaveApplications.equalsIgnoreCase("Leave Applications")) {
            emailSubscriptionsPage.validate_Leave_Applications_Subscribers_Page();
        } else if(leaveApplications.equalsIgnoreCase("Leave Approvals")) {
            emailSubscriptionsPage.validate_Leave_Approvals_Subscriber_Page();
        }
    }

    @When("I attempt to add {string} again with same name {string}")
    @And("I add a new subscriber with the email {string} and name {string}")
    public void add_New_Subscriber(String email, String name) {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.click_On_Add_Button();
        emailSubscriptionsPage.enterName(name);
        emailSubscriptionsPage.enterEmail(email);
        emailSubscriptionsPage.click_On_Save_Button();
    }

    @And("I should be redirected back to the Leave Applications notifications list")
    public void validate_Leave_Applications_Notifications_Page() {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.validate_Leave_Applications_Subscribers_Page();
    }

    @And("I should be redirected back to the Leave Approvals notifications list")
    public void validate_Leave_Approvals_Notifications_Page() {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.validate_Leave_Approvals_Subscriber_Page();
    }

    @Given("I am on the Add Subscriber form in the Leave Applications notifications section")
    public void navigateTo_Add_Subscriber_Form_In_Leave_Applications_Notifications_Section() {
        click_On_Add_User_For_Leave_Application_Type("Leave Applications");
    }

    @Given("I am on the Add Subscriber form in the Leave Approvals notifications section")
    public void navigateTo_Add_Subscriber_Form_In_Leave_Approvals_Notifications_Section() {
        click_On_Add_User_For_Leave_Application_Type("Leave Approvals");
    }


    @Then("the subscriber with the Email {string} and Name {string} should be successfully added")
    @Given("{string} with name {string} is subscribed to Leave Applications notifications")
    public void validate_Subscriber_Added_To_Leave_Applications_Notifications(String name, String email) {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.validate_Name_Added_Into_The_Table(name);
        emailSubscriptionsPage.validate_Email_Added_Into_The_Table(email);
    }

    @Given("{string} is already subscribed to Leave Applications notifications")
    @And("the list should include {string}")
    @And("{string} is subscribed to Leave Applications notifications")
    @Then("{string} should still appear in the Leave Applications notifications list")
    public void validate_Subscriber_Added_To_Leave_Applications_Notifications(String email) {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.validate_Email_Added_Into_The_Table(email);
    }

    @Then("an error message {string} should be displayed")
    public void validate_Error_Message(String errorMessage) {
        StepDefinition stepDefinition = new StepDefinition(Hooks.driver);
        stepDefinition.validate_Error_Message(errorMessage);
        stepDefinition.clickOnCancelButton();
    }

    @And("no duplicate subscription with already added {string} should be created")
    public void validate_No_Duplicate_Subscription_Should_Be_Created(String email) {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.validate_No_Duplicate_Entries_In_Table(email);
    }

    @When("I remove {string} from the Leave Applications notifications")
    public void remove_User_From_Leave_Applications_Notifications(String email) {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.delete_User_From_Leave_Applications_Notifications(email);
    }

    @Then("the subscriber {string} should be successfully removed")
    @Then("no subscriber with {string} should be added")
    @And("the subscriber with {string} should not be added")
    public void validate_Subscriber_Is_Removed(String email) {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
//        emailSubscriptionsPage.validate_Leave_Applications_Subscribers_Page();
        emailSubscriptionsPage.validate_No_User_Present(email);
    }

    @When("I update the subscriber's email address to {string}")
    public void update_Subscriber_Email_Address(String updatedEmailAddress) {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.update_Email_Address(updatedEmailAddress);
//        emailSubscriptionsPage.click_On_Save_Button();
    }

    @When("I attempt to add a new subscriber with {string} and an empty email field")
    public void add_Subscriber_With_Empty_Email_Field(String name) {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.click_On_Add_Button();
        emailSubscriptionsPage.enterName(name);
        emailSubscriptionsPage.click_On_Save_Button();
    }

    @And("the subscriber should with {string} should not be added")
    public void validate_Subscriber_Not_Added(String name) {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.validate_No_User_Present(name);
    }

    @When("I click the Cancel button")
    public void click_On_Cancel_Button() {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.click_On_Cancel_Button();
    }

    @When("I refresh the {string} Page")
    public void refreshPage(String pageName) {
        StepDefinition stepDefinition = new StepDefinition(Hooks.driver);
        stepDefinition.refreshPage();
    }

    @Then("{string} should still be subscribed from Leave Applications notifications")
    public void user_Still_Subscribed_In_Leave_Application_Notifications(String email) {
        navigate_To_Email_Subscription_Page();
        navigateTo_Add_Subscriber_Form_In_Leave_Applications_Notifications_Section();
        validate_Subscriber_Added_To_Leave_Applications_Notifications(email);
    }

    @Then("{string} should still be subscribed from Leave Approvals notifications")
    public void user_Still_Subscribed_In_Leave_Subscriber_Notifications(String email) {
        navigate_To_Email_Subscription_Page();
        navigateTo_Add_Subscriber_Form_In_Leave_Approvals_Notifications_Section();
        validate_Subscriber_Added_To_Leave_Applications_Notifications(email);
    }

    @Then("the list should include all the below subscribers")
    public void theListShouldIncludeAllTheBelowSubscribers(DataTable dataTable) {
        // Convert DataTable to a List of Maps
        List<Map<String, String>> subscribers = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> subscriber : subscribers) {
            String name = subscriber.get("Name");
            String email = subscriber.get("Email");
            validate_Subscriber_Added_To_Leave_Applications_Notifications(name, email);
        }
    }
}
