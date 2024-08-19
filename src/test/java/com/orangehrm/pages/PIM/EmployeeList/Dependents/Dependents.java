package com.orangehrm.pages.PIM.EmployeeList.Dependents;
import org.openqa.selenium.WebDriver;

public class Dependents {
    public WebDriver driver;
    public DependentsLocators dependentsLocators;

    public Dependents(WebDriver driver) {
        this.driver = driver;
        this.dependentsLocators = new DependentsLocators(driver);
    }
}
