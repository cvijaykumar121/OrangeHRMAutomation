package com.orangehrm.pages.Admin.CorporateBranding;

import com.orangehrm.base.TestBase;
import org.openqa.selenium.WebDriver;

public class CorporateBrandingPage extends TestBase {
    public WebDriver driver;
    public CorporateBrandingLocators corporateBrandingLocators;

    public CorporateBrandingPage(WebDriver driver) {
        this.driver = driver;
        this.corporateBrandingLocators = new CorporateBrandingLocators(driver);
    }

}
