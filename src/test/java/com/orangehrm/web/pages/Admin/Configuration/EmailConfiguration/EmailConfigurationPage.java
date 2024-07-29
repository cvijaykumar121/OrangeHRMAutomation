package com.orangehrm.web.pages.Admin.Configuration.EmailConfiguration;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;

public class EmailConfigurationPage extends TestBase {
    public WebDriver driver;
    public EmailConfigurationLocators emailConfigurationLocators;

    public EmailConfigurationPage(WebDriver driver) {
        this.driver = driver;
        this.emailConfigurationLocators = new EmailConfigurationLocators(driver);
    }
}
