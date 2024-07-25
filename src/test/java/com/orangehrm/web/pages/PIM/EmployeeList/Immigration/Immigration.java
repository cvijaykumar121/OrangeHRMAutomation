package com.orangehrm.web.pages.PIM.EmployeeList.Immigration;
import org.openqa.selenium.WebDriver;

public class Immigration {
    public WebDriver driver;
    public ImmigrationLocators immigrationLocators;

    public Immigration(WebDriver driver) {
        this.driver = driver;
        this.immigrationLocators = new ImmigrationLocators(driver);
    }
}
