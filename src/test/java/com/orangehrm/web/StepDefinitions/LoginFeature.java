package com.orangehrm.web.StepDefinitions;

import com.orangehrm.web.pages.Login.LoginPage;
import com.orangehrm.web.pages.SideMenu.SideMenu;
import com.orangehrm.web.pages.UserMenu.UserMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeature {

    @Then("I should see the Login Header in the Login Page")
    public void i_should_see_the_login_header_in_the_login_page() {
        Hooks hooks = new Hooks();
        LoginPage loginPage = new LoginPage(hooks.getDriver());
        loginPage.validatePresenceOfLoginPageHeader();
    }

    @Then("I should see the Username and Password Headers")
    public void i_should_see_the_username_and_password_headers() {
        Hooks hooks = new Hooks();
        LoginPage loginPage = new LoginPage(hooks.getDriver());
        loginPage.validatePresenceOfUsernameInputHeader();
        loginPage.validatePresenceOfPasswordInputHeader();
    }

    @Then("I should see the Username and Password fields")
    public void i_should_see_the_username_and_password_fields() {
        Hooks hooks = new Hooks();
        LoginPage loginPage = new LoginPage(hooks.getDriver());
        loginPage.validatePresenceOfPasswordInputHeader();
        loginPage.validatePresenceOfPasswordInputField();
    }

    @Then("I should see the Forgot Password Link and all the footer elements")
    public void i_should_see_the_forgot_password_link_and_all_the_footer_elements() {
        Hooks hooks = new Hooks();
        LoginPage loginPage = new LoginPage(hooks.getDriver());
        loginPage.validatePresenceOfForgotPasswordLink();
        loginPage.validatePresenceOfFooterElements();
    }

    @Then("I should see the Login button")
    public void i_should_see_the_Login_button() {
        Hooks hooks = new Hooks();
        LoginPage loginPage = new LoginPage(hooks.getDriver());
        loginPage.validatePresenceOfLoginButton();
    }


    @Given("I am on the OrangeHRM login page")
    public void i_am_on_the_orange_hrm_login_page() {
        Hooks hooks = new Hooks();
        LoginPage loginPage = new LoginPage(hooks.getDriver());
        loginPage.validatePresenceOfLoginPageHeader();
        loginPage.validatePresenceOfUsernameInputHeader();
        loginPage.validatePresenceOfPasswordInputHeader();
        loginPage.validatePresenceOfLoginButton();
    }

    @When("I enter username {string} and password {string} and click on login button")
    public void i_enter_username_and_password(String username, String password) {
        Hooks hooks = new Hooks();
        LoginPage loginPage = new LoginPage(hooks.getDriver());
        loginPage.validatePresenceOfUsernameInputField();
        loginPage.enterUsername(username);
        loginPage.validatePresenceOfPasswordInputField();
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
    }

    @When("I click the Login button")
    public void i_click_the_button() {
        Hooks hooks = new Hooks();
        LoginPage loginPage = new LoginPage(hooks.getDriver());
        loginPage.clickOnLoginButton();
    }

    @Then("I should see the Dashboard page")
    public void i_should_see_the_dashboard_page() {
        Hooks hooks = new Hooks();
        LoginPage loginPage = new LoginPage(hooks.getDriver());
        loginPage.validateDashboardPageHeader();
    }

    @Then("I should see the Invalid credentials error message")
    public void i_should_see_the_invalid_credentials_error_message() {
        Hooks hooks = new Hooks();
        LoginPage loginPage = new LoginPage(hooks.getDriver());
        loginPage.validateInvalidCredentialsError();
    }

    @Then("I should see the Required error message")
    public void i_should_see_the_Required_error_message() {
        Hooks hooks = new Hooks();
        LoginPage loginPage = new LoginPage(hooks.getDriver());
        loginPage.validateRequiredMessageError();
    }

    @Then("I login with valid Admin credentials and I am on the dashboard page")
    public void i_login_with_valid_admin_credentials() {
        Hooks hooks = new Hooks();
        LoginPage loginPage = new LoginPage(hooks.getDriver());

        loginPage.validatePresenceOfLoginPageHeader();
        loginPage.validatePresenceOfUsernameInputHeader();
        loginPage.validatePresenceOfUsernameInputField();
        loginPage.enterUsername("Admin");
        loginPage.validatePresenceOfPasswordInputHeader();
        loginPage.validatePresenceOfPasswordInputField();
        loginPage.enterPassword("admin123");
        loginPage.validatePresenceOfLoginButton();
        loginPage.clickOnLoginButton();
        loginPage.validateDashboardPageHeader();
    }

    @Then("I logout from the application")
    public void logout_From_Application() {
        Hooks hooks = new Hooks();
        UserMenu userMenu = new UserMenu(hooks.getDriver());
        LoginPage loginPage = new LoginPage(hooks.getDriver());

        userMenu.validateUserMenuIsPresent();
        userMenu.clickOnUserDropdown();
        userMenu.clickOnLogoutMenuOption();

        loginPage.validatePresenceOfLoginPageHeader();
    }

    @Then("I login as the same employee that I added in PIM as an Admin {string} {string}")
    public void login_as_the_same_employee_that_I_added_in_PIM_as_an_Admin(String username, String password) {
        Hooks hooks = new Hooks();
        i_enter_username_and_password(username, password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I validate that the user should be able to access only the features that an ESS user can have")
    public void validate_that_the_user_should_be_able_to_access_only_the_features_that_an_ESS_user_can_have() {
        Hooks hooks = new Hooks();
        SideMenu sideMenu = new SideMenu(hooks.getDriver());
        sideMenu.validateAdminLinkIsNotPresentInSideMenu();
        sideMenu.validatePIMLinkIsNotPresentInSideMenu();
        sideMenu.validateRecruitmentLinkIsNotPresentInSideMenu();
        sideMenu.validateMaintenanceLinkIsNotPresentInSideMenu();
    }

    @And("I login as the same employee that I changed the password and check whether I am able to login with the updated password or not {string} {string}")
    public void login_With_Same_Employee_For_Which_Password_Was_Changed(String username, String changedPassword) {
        Hooks hooks = new Hooks();
        i_enter_username_and_password(username, changedPassword);
    }

    @Then("I should get an error message that the account is disabled")
    public void validate_Account_Disabled_Error_Message() {
        Hooks hooks = new Hooks();
        LoginPage loginPage = new LoginPage(hooks.getDriver());
        loginPage.validateAccountDisabledErrorMessage();
    }

    @Then("I login as the same user that was added through User Management and validate if the user is able to login successfully {string} {string}")
    public void i_login_as_the_same_user_that_was_added_through_User_Management_and_validate_if_the_user_is_able_to_login_successfully(String username, String password) {

        i_enter_username_and_password(username, password);
        i_should_see_the_dashboard_page();
    }
}
