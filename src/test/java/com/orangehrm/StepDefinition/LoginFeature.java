package com.orangehrm.StepDefinition;

import com.orangehrm.base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeature extends TestBase {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("The user is on the login page");
    }
    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        System.out.println("The user enters valid credentials");
    }
    @And("clicks the login button")
    public void clicks_the_login_button() {
        System.out.println("Clicks on the login button");
    }
    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        System.out.println("The user should be redirected to the home page");
    }
    @And("the user's profile should be visible")
    public void the_user_s_profile_should_be_visible() {
        System.out.println("The user profile should be visible");
    }
}
