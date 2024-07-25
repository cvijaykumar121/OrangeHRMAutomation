package com.orangehrm.web.pages.PIM.EmployeeList.ReportTo;
import org.openqa.selenium.WebDriver;

public class ReportTo {
    public WebDriver driver;
    public ReportToLocators reportToLocators;

    public ReportTo(WebDriver driver) {
        this.driver = driver;
        this.reportToLocators = new ReportToLocators(driver);
    }
}
