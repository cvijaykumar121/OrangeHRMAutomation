package com.orangehrm.web.pages.PIM.EmployeeList.Qualifications;
import org.openqa.selenium.WebDriver;

public class Qualifications {
    public WebDriver driver;
    public QualificationsLocators qualificationsLocators;

    public Qualifications(WebDriver driver) {
        this.driver = driver;
        this.qualificationsLocators = new QualificationsLocators(driver);
    }
}
