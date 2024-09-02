package com.orangehrm.StepDefinitions.Admin.Configuration;

import com.orangehrm.StepDefinitions.Hooks;
import com.orangehrm.base.StepDefinition;
import com.orangehrm.pages.Admin.AdminTopNavMenu.AdminTopNavMenu;
import com.orangehrm.pages.Admin.Configuration.EmailSubscriptions.EmailSubscriptionsPage;
import com.orangehrm.pages.SideMenu.SideMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmailSubscriptionsFeature {
    @And("I navigate to the Email Subscriptions Page")
    @Given("I am on the Email Subscriptions Page")
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
        emailSubscriptionsPage.validate_Leave_Applications_Subscribers_Page();
    }

    @When("I attempt to add {string} with same {string} again")
    @And("I add a new subscriber with the name {string} and email {string}")
    public void add_New_Subscriber(String name, String email) {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.click_On_Add_Button();
        emailSubscriptionsPage.enterName(name);
        emailSubscriptionsPage.enterEmail(email);
        emailSubscriptionsPage.click_On_Save_Button();
    }

    @Then("the subscriber with the name {string} and email {string} should be successfully added to Leave Applications notifications")
    public void validate_Subscriber_Added_To_Leave_Applications_Notifications(String name, String email) {
        EmailSubscriptionsPage emailSubscriptionsPage = new EmailSubscriptionsPage(Hooks.driver);
        emailSubscriptionsPage.validate_Name_Added_Into_The_Table(name);
        emailSubscriptionsPage.validate_Email_Added_Into_The_Table(email);
    }

    @Given("{string} is already subscribed to Leave Applications notifications")
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

    @And("no duplicate subscription with already added name {string} should be created")
    public void validate_No_Duplicate_Subscription_Should_Be_Created() {

    }
}
