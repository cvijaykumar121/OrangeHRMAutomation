package com.orangehrm.web.pages.Admin.Qualifications.Skills;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;

public class SkillsPage extends TestBase {
    public WebDriver driver;
    public SkillsLocators skillsLocators;

    public SkillsPage(WebDriver driver) {
        this.driver = driver;
        this.skillsLocators = new SkillsLocators(driver);
    }


}
