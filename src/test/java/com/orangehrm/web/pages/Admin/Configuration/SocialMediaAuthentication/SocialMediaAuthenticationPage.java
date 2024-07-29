package com.orangehrm.web.pages.Admin.Configuration.SocialMediaAuthentication;

import com.orangehrm.web.base.TestBase;
import com.orangehrm.web.pages.Admin.Configuration.RegisterOAuthClient.RegisterOAuthClientLocators;
import org.openqa.selenium.WebDriver;

public class SocialMediaAuthenticationPage extends TestBase {
    public WebDriver driver;
    public SocialMediaAuthenticationLocators socialMediaAuthenticationLocators;

    public SocialMediaAuthenticationPage(WebDriver driver) {
        this.driver = driver;
        this.socialMediaAuthenticationLocators = new SocialMediaAuthenticationLocators(driver);
    }
}
