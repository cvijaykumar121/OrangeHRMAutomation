package com.orangehrm.web.pages.Admin.Configuration.Modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ModulesLocators {
    public ModulesLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
