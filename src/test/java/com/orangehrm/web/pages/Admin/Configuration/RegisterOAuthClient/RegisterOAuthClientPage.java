package com.orangehrm.web.pages.Admin.Configuration.RegisterOAuthClient;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;

public class RegisterOAuthClientPage extends TestBase {
    public WebDriver driver;
    public RegisterOAuthClientLocators registerOAuthClientLocators;

    public RegisterOAuthClientPage(WebDriver driver) {
        this.driver = driver;
        this.registerOAuthClientLocators = new RegisterOAuthClientLocators(driver);
    }
}
