package com.orangehrm.web.pages.SideMenu;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenu extends TestBase {
    public WebDriver driver;
    public SideMenuLocators sideMenuLocators;

    public SideMenu(WebDriver driver) {
        this.driver = driver;
        this.sideMenuLocators = new SideMenuLocators(driver);
    }

//    public WebElement validateAdminLinkIsPresentInSideMenu() {
//        WebElement adminLink = sideMenuLocators.adminLink;
//        if(waitForElementToBeClickable(adminLink, 20)) {
//            logPass("Admin ");
//        }
//        return null;
//    }

    public void validateAdminLinkIsNotPresentInSideMenu() {
//        if (!(waitForElementToBeClickable(sideMenuLocators.adminLink, 10, false))) {
//            logPass("PASS: Admin Link is not present in the page", true);
//        } else {
//            logFail("FAIL: Admin Link is present in the page", true);
//        }

        if(!(sideMenuLocators.adminLink.isDisplayed())) {
            logPass("FAIL: Admin Link is not present in the page", true);
        } else {
            logFail("PASS: Admin Link is present in the page", true);
        }
    }

    public void clickOnAdminLink() {
//        WebElement adminLink = validateAdminLinkIsPresentInSideMenu();
        WebElement adminLink = sideMenuLocators.adminLink;
        clickElement(adminLink, "Admin link clicked successfully", true, 5);
    }

    public WebElement validatePIMLinkIsPresentInSideMenu() {
        WebElement pimLink = sideMenuLocators.pimLink;
        waitForElementToBeClickable(pimLink, 30, "PIM link is visible");
        return pimLink;
    }

    public void validatePIMLinkIsNotPresentInSideMenu() {
        if (!(waitForElementToBeClickable(sideMenuLocators.pimLink, 10, false))) {
            logPass("PASS: PIM Link is not present in the page", true);
        } else {
            logFail("FAIL: PIM Link is present in the page", true);
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
        if (!(waitForElementToBeClickable(sideMenuLocators.recruitmentLink, 10, false))) {
            logPass("PASS: Recruitment Link is not present in the page", true);
        } else {
            logFail("FAIL: Recruitment Link is present in the page", true);
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
        if (!(waitForElementToBeClickable(sideMenuLocators.maintenanceLink, 20, false))) {
            logPass("PASS: Maintenance Link is not present in the page", true);
        } else {
            logFail("FAIL: Maintenance Link is present in the page", true);
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
}
