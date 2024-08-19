package com.orangehrm.pages.Admin.Configuration.Modules;

import com.orangehrm.base.TestBase;
import org.openqa.selenium.WebDriver;

public class ModulesPage extends TestBase {
    public WebDriver driver;
    public ModulesLocators modulesLocators;

    public ModulesPage(WebDriver driver) {
        this.driver = driver;
        this.modulesLocators = new ModulesLocators(driver);
    }
}
