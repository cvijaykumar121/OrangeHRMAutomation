package com.orangehrm.testcases;

import com.orangehrm.base.TestBase;
import com.orangehrm.coreFunctions.loginFunctionality.LoginFunctions;
import org.testng.annotations.Test;

public class OHRMTEST1_TC01_Verify_Valid_Login extends TestBase {
    LoginFunctions login = new LoginFunctions();

    @Test(priority = 0)
    public void verify_valid_login() throws InterruptedException {

        //Validate the login page
        login.validateLoginPage();

        //Enter username
        login.enterUsername("Admin");

        //Enter password
        login.enterPassword("admin123");

        //Click on Login Button
        login.clickOnLoginButton();
    }
}
