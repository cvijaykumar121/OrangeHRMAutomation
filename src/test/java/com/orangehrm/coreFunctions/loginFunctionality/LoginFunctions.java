package com.orangehrm.coreFunctions.loginFunctionality;

import com.orangehrm.base.TestBase;
import org.openqa.selenium.By;

import static com.orangehrm.coreFunctions.loginFunctionality.LoginLocators.*;

public class LoginFunctions extends TestBase {
    public void validateLoginPage() throws InterruptedException {
        validateText(By.xpath(LOGIN_HEADING), "Login", "Successfully validated login page");
    }

    public void enterUsername(String username) throws InterruptedException {
        sendKeys(By.xpath(USERNAME_FIELD), username, "Successfully entered " + username + " in the username field");
    }

    public void enterPassword(String password) throws InterruptedException {
        sendKeys(By.xpath(PASSWORD_FIELD), "admin123", "Successfully entered " + password + " in the password field");
    }

    public void clickOnLoginButton() throws InterruptedException {
        clickElement(By.xpath(LOGIN_BUTTON), "Successfully clicked on Login Button");
    }
}
