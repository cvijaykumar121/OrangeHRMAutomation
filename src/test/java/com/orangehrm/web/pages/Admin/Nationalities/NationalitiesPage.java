package com.orangehrm.web.pages.Admin.Nationalities;
import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;

public class NationalitiesPage extends TestBase {
    public WebDriver driver;
    public NationalitiesLocators nationalitiesLocators;

    public NationalitiesPage(WebDriver driver) {
        this.driver = driver;
        this.nationalitiesLocators = new NationalitiesLocators(driver);
    }
}
