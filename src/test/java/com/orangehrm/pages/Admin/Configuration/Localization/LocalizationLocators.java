package com.orangehrm.pages.Admin.Configuration.Localization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LocalizationLocators {
    public LocalizationLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
