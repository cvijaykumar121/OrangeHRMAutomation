package com.orangehrm.pages.Admin.Configuration.Localization;

import com.orangehrm.base.TestBase;
import org.openqa.selenium.WebDriver;

public class LocalizationPage extends TestBase {
    public WebDriver driver;
    public LocalizationLocators localizationLocators;

    public LocalizationPage(WebDriver driver) {
        this.driver = driver;
        this.localizationLocators = new LocalizationLocators(driver);
    }
}
