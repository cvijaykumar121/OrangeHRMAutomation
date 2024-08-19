package com.orangehrm.pages.PIM.EmployeeList.Memberships;
import org.openqa.selenium.WebDriver;

public class Memberships {
    public WebDriver driver;
    public MembershipsLocators membershipsLocators;

    public Memberships(WebDriver driver) {
        this.driver = driver;
        this.membershipsLocators = new MembershipsLocators(driver);
    }
}
