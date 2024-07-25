package com.orangehrm.web.pages.Dashboard;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends TestBase {
    public WebDriver driver;
    public DashboardLocators dashboardLocators;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.dashboardLocators = new DashboardLocators(driver);
    }

    public void validateDashboardPageHeader() {
        WebElement dashboardPageHeader = dashboardLocators.dashboardPageHeader;
        waitForElementToBeVisible(dashboardPageHeader, 20, "Validated Login Page header");
        validateText(dashboardPageHeader, "Dashboard", "Dashboard Page Header Text validated successfully", 5);
    }
}
