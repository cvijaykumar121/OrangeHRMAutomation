package com.orangehrm.pages.Admin.Configuration.SocialMediaAuthentication;

import com.orangehrm.base.TestBase;
import org.openqa.selenium.WebDriver;

public class SocialMediaAuthenticationPage extends TestBase {
    public WebDriver driver;
    public SocialMediaAuthenticationLocators socialMediaAuthenticationLocators;

    public SocialMediaAuthenticationPage(WebDriver driver) {
        this.driver = driver;
        this.socialMediaAuthenticationLocators = new SocialMediaAuthenticationLocators(driver);
    }
}
