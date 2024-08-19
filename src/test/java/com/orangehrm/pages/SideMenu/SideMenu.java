package com.orangehrm.pages.SideMenu;

import com.orangehrm.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenu extends TestBase {
    public WebDriver driver;
    public SideMenuLocators sideMenuLocators;

    public SideMenu(WebDriver driver) {
        this.driver = driver;
        this.sideMenuLocators = new SideMenuLocators(driver);
    }

    public void validateAdminLinkIsNotPresentInSideMenu() {
        if (!isElementPresent(sideMenuLocators.adminLink)) {
            logPass("Admin Link is not displayed", true);
        } else {
            logFail("Admin Link is displayed", true);
        }
    }

    public void clickOnAdminLink() {
        WebElement adminLink = sideMenuLocators.adminLink;
        clickElement(adminLink, "Admin link clicked successfully", true, 5);
    }

    public void validatePIMLinkIsNotPresentInSideMenu() {
        if (!isElementPresent(sideMenuLocators.pimLink)) {
            logPass("PIM Link is not displayed", true);
        } else {
            logFail("PIM Link is displayed", true);
        }
    }

    public void clickOnPIMLink() {
        WebElement pimLink = sideMenuLocators.pimLink;
        waitForElementToBeClickable(pimLink, 10, "PIM menu link found successfully");
        clickElement(pimLink, "PIM link clicked successfully", true, 5);
    }

    public void clickOnLeaveLink() {
        WebElement leaveLink = sideMenuLocators.leaveLink;
        waitForElementToBeClickable(leaveLink, 10, "Leave menu link found successfully");
        clickElement(leaveLink, "Leave link clicked successfully", true, 5);
    }

    public void clickOnTimeLink() {
        WebElement timeLink = sideMenuLocators.timeLink;
        waitForElementToBeClickable(timeLink, 10, "Time menu link found successfully");
        clickElement(timeLink, "Time link clicked successfully", true, 5);
    }

    public void clickOnRecruitmentLink() {
        WebElement recruitmentLink = sideMenuLocators.recruitmentLink;
        waitForElementToBeClickable(recruitmentLink, 10, "Recruitment menu link found successfully");
        clickElement(recruitmentLink, "Recruitment link clicked successfully", true, 5);
    }

    public void validateRecruitmentLinkIsNotPresentInSideMenu() {
        if (!isElementPresent(sideMenuLocators.recruitmentLink)) {
            logPass("Recruitment Link is not displayed", true);
        } else {
            logFail("Recruitment Link is displayed", true);
        }
    }

    public void clickOnMyInfoLink() {
        WebElement myInfoLink = sideMenuLocators.myInfoLink;
        waitForElementToBeClickable(myInfoLink, 10, "My Info menu link found successfully");
        clickElement(myInfoLink, "My Info link clicked successfully", true, 5);
    }

    public void clickOnPerformanceLink() {
        WebElement performanceLink = sideMenuLocators.performanceLink;
        waitForElementToBeClickable(performanceLink, 10, "Performance menu link found successfully");
        clickElement(performanceLink, "Performance link clicked successfully", true, 5);
    }

    public void clickOnDashboardLink() {
        WebElement dashboardLink = sideMenuLocators.dashboardLink;
        waitForElementToBeClickable(dashboardLink, 10, "Dashboard menu link found successfully");
        clickElement(dashboardLink, "Dashboard link clicked successfully", true, 5);
    }

    public void clickOnDirectoryLink() {
        WebElement directoryLink = sideMenuLocators.directoryLink;
        waitForElementToBeClickable(directoryLink, 10, "Directory menu link found successfully");
        clickElement(directoryLink, "Directory link clicked successfully", true, 5);
    }

    public void clickOnMaintenanceLink() {
        WebElement maintenanceLink = sideMenuLocators.maintenanceLink;
        waitForElementToBeClickable(maintenanceLink, 10, "Maintenance menu link found successfully");
        clickElement(maintenanceLink, "Maintenance link clicked successfully", true, 5);
    }

    public void validateMaintenanceLinkIsNotPresentInSideMenu() {
        if (!isElementPresent(sideMenuLocators.maintenanceLink)) {
            logPass("Maintenance Link is not displayed", true);
        } else {
            logFail("Maintenance Link is displayed", true);
        }
    }

    public void clickOnClaimLink() {
        WebElement claimLink = sideMenuLocators.claimLink;
        waitForElementToBeClickable(claimLink, 10, "Claim menu link found successfully");
        clickElement(claimLink, "Claim link clicked successfully", true, 5);
    }

    public void clickOnBuzzLink() {
        WebElement buzzLink = sideMenuLocators.buzzLink;
        waitForElementToBeClickable(buzzLink, 10, "Buzz menu link found successfully");
        clickElement(buzzLink, "Buzz link clicked successfully", true, 5);
    }

    public void validateAdminMenuIsPresent() {
        waitForElementToBeClickable(sideMenuLocators.adminLink, 40, "Validated Admin Link successfully");
    }

    public void validatePIMMenuIsPresent() {
        waitForElementToBeClickable(sideMenuLocators.pimLink, 40, "Validated PIM Link successfully");
    }

    public void validateRecruitmentMenuIsPresent() {
        waitForElementToBeClickable(sideMenuLocators.recruitmentLink, 40, "Validated Recruitment Link successfully");
    }

    public void validateMaintenanceMenuIsPresent() {
        waitForElementToBeClickable(sideMenuLocators.maintenanceLink, 40, "Validated Maintenance Link successfully");
    }
}
