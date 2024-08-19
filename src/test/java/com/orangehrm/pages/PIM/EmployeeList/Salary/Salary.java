package com.orangehrm.pages.PIM.EmployeeList.Salary;
import org.openqa.selenium.WebDriver;

public class Salary {
    public WebDriver driver;
    public SalaryLocators salaryLocators;

    public Salary(WebDriver driver) {
        this.driver = driver;
        this.salaryLocators = new SalaryLocators(driver);
    }
}
