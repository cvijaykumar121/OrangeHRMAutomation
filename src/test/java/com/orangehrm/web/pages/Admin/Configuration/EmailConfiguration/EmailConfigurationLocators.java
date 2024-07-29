package com.orangehrm.web.pages.Admin.Configuration.EmailConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmailConfigurationLocators {
    public EmailConfigurationLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
