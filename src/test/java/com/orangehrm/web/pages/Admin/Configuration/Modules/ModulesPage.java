package com.orangehrm.web.pages.Admin.Configuration.Modules;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;

public class ModulesPage extends TestBase {
    public WebDriver driver;
    public ModulesLocators modulesLocators;

    public ModulesPage(WebDriver driver) {
        this.driver = driver;
        this.modulesLocators = new ModulesLocators(driver);
    }
}
