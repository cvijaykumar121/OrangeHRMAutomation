package com.orangehrm.StepDefinitions;
import com.orangehrm.StepDefinitions.Hooks.Hooks;
import com.orangehrm.pages.Login.LoginPage;
import com.orangehrm.pages.SideMenu.SideMenu;
import com.orangehrm.pages.Dashboard.DashboardPage;
import com.orangehrm.pages.UserMenu.UserMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeature {

    @Then("I should see the Login Header in the Login Page")
    public void i_should_see_the_login_header_in_the_login_page() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.validatePresenceOfLoginPageHeader();
    }

    @Then("I should see the Username and Password Headers")
    public void i_should_see_the_username_and_password_headers() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.validatePresenceOfUsernameInputHeader();
        loginPage.validatePresenceOfPasswordInputHeader();
    }

    @Then("I should see the Username and Password fields")
    public void i_should_see_the_username_and_password_fields() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.validatePresenceOfPasswordInputHeader();
        loginPage.validatePresenceOfPasswordInputField();
    }

    @Then("I should see the Forgot Password Link and all the footer elements")
    public void i_should_see_the_forgot_password_link_and_all_the_footer_elements() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.validatePresenceOfForgotPasswordLink();
        loginPage.validatePresenceOfFooterElements();
    }

    @Then("I should see the Login button")
    public void i_should_see_the_Login_button() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.validatePresenceOfLoginButton();
    }


    @Given("I am on the OrangeHRM login page")
    public void i_am_on_the_orange_hrm_login_page() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.validatePresenceOfLoginPageHeader();
        loginPage.validatePresenceOfUsernameInputHeader();
        loginPage.validatePresenceOfPasswordInputHeader();
        loginPage.validatePresenceOfLoginButton();
    }

    @When("I enter username {string}")
    public void enterUsername(String username) {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.enterUsername(username);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.enterPassword(password);
    }

    @And("I click the {string} Button")
    public void clickOnLoginButton(String button) {
        if(button.equalsIgnoreCase("Login")) {
            LoginPage loginPage = new LoginPage(Hooks.driver);
            loginPage.clickOnLoginButton();
        }
    }

    @Then("I should be on the {string} page")
    @Then("I should be redirected to the Admin {string}")
    public void validateDashboardPage(String pageName) {
        if(pageName.equalsIgnoreCase("dashboard")) {
            DashboardPage dashboardPage = new DashboardPage(Hooks.driver);
            dashboardPage.validateDashboardPageHeader();
        }
    }

    @When("I enter username {string} and password {string} and click on login button")
    public void i_enter_username_and_password(String username, String password) {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.validatePresenceOfUsernameInputField();
        loginPage.enterUsername(username);
        loginPage.validatePresenceOfPasswordInputField();
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
    }

    @When("I click the Login button")
    public void i_click_the_button() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.clickOnLoginButton();
    }

    @Then("I should be on the dashboard page")
    public void i_should_see_the_dashboard_page() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.validateDashboardPageHeader();
    }

    @Then("I validate whether I am able to login with the updated password or not")
    @Then("I am on the dashboard page")
    public void validate_dashboard_page() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.validateDashboardPageHeader();
    }

    @Then("I should see the {string} error message")
    public void i_should_see_the_invalid_credentials_error_message(String errorMessage) {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        if(errorMessage.equalsIgnoreCase("Invalid Credentials")) {
            loginPage.validateInvalidCredentialsError();
        } else if(errorMessage.equalsIgnoreCase("Required")) {
            loginPage.validateRequiredMessageError();
        }
    }

//    @Then("I should see the Required error message")
//    public void i_should_see_the_Required_error_message() {
//        LoginPage loginPage = new LoginPage(Hooks.driver);
//        loginPage.validateRequiredMessageError();
//    }

    @Then("I login with valid Admin credentials")
    public void i_login_with_valid_admin_credentials() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        UserMenu userMenu = new UserMenu(Hooks.driver);

        i_enter_username_and_password("Admin", "admin123");
        userMenu.validateUserMenuIsPresent();
    }

    @Then("I logout from the application")
    public void logout_From_Application() {
        UserMenu userMenu = new UserMenu(Hooks.driver);
        LoginPage loginPage = new LoginPage(Hooks.driver);

        userMenu.validateUserMenuIsPresent();
        userMenu.clickOnUserDropdown();
        userMenu.clickOnLogoutMenuOption();
    }

    @And("I log out and log back in as the admin")
    public void logOutAndLoginAsAdmin() {
        logout_From_Application();
        i_am_on_the_orange_hrm_login_page();
        i_enter_username_and_password("Admin","admin123");
        validate_user_is_able_to_login();
    }

    @Then("I login as the same employee that I added in PIM as an Admin {string} {string}")
    public void login_as_the_same_employee_that_I_added_in_PIM_as_an_Admin(String username, String password) {
        i_enter_username_and_password(username, password);
    }

    @And("I validate that the user should be able to access only the features that an ESS user can have")
    public void validate_that_the_user_should_be_able_to_access_only_the_features_that_an_ESS_user_can_have() {
        SideMenu sideMenu = new SideMenu(Hooks.driver);
        sideMenu.validateAdminLinkIsNotPresentInSideMenu();
        sideMenu.validatePIMLinkIsNotPresentInSideMenu();
        sideMenu.validateRecruitmentLinkIsNotPresentInSideMenu();
        sideMenu.validateMaintenanceLinkIsNotPresentInSideMenu();
    }

    @And("I validate that the user should be able to access all the features of an Admin User")
    public void validate_that_the_user_should_be_able_to_access_all_the_features_that_an_Admin_user() {
        SideMenu sideMenu = new SideMenu(Hooks.driver);
        sideMenu.validateAdminMenuIsPresent();
        sideMenu.validatePIMMenuIsPresent();
        sideMenu.validateRecruitmentMenuIsPresent();
    }

    @And("I login as the same employee that I changed the password {string} {string}")
    public void login_With_Same_Employee_For_Which_Password_Was_Changed(String username, String changedPassword) {
        i_enter_username_and_password(username, changedPassword);
    }

    @Then("I should get an error message that the account is disabled")
    public void validate_Account_Disabled_Error_Message() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.validateAccountDisabledErrorMessage();
    }

//    @Then("I login as the same user that was added through User Management and validate if the user is able to login successfully {string} {string}")
//    public void i_login_as_the_same_user_that_was_added_through_User_Management_and_validate_if_the_user_is_able_to_login_successfully(String username, String password) {
//
//        i_enter_username_and_password(username, password);
//    }

    @When("I login as the same user that was added through User Management {string} {string}")
    public void login_as_same_user_that_was_added_through_User_Management(String username, String changedPassword) {
        i_enter_username_and_password(username, changedPassword);
    }

    @Then("I validate if the user is able to login successfully")
    public void validate_user_is_able_to_login() {
        validate_dashboard_page();
    }
}
