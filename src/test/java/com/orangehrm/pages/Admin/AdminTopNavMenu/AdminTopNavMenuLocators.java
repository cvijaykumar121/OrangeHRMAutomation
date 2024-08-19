package com.orangehrm.pages.Admin.AdminTopNavMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminTopNavMenuLocators {
    public AdminTopNavMenuLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//nav[@aria-label='Topbar Menu']//span[text()='User Management ']")
    public WebElement userManagementNavButton;

    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li/a[text()='Users']")
    public WebElement usersLink;

    @FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item' and text()='Job ']")
    public WebElement jobNavButton;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Job Titles']")
    public WebElement jobTitlesLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Pay Grades']")
    public WebElement payGradesLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Employment Status']")
    public WebElement employmentStatusLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Job Categories']")
    public WebElement jobCategoriesLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Work Shifts']")
    public WebElement workShiftsLink;

    @FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item' and text()='Organization ']")
    public WebElement organizationNavButton;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='General Information']")
    public WebElement generalInformationLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Locations']")
    public WebElement locationsLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Structure']")
    public WebElement structureLink;

    @FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item' and text()='Qualifications ']")
    public WebElement qualificationsNavButton;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Skills']")
    public WebElement skillsLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Education']")
    public WebElement educationLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Licenses']")
    public WebElement licensesLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Languages']")
    public WebElement languagesLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Memberships']")
    public WebElement membershipsLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item' and text()='Nationalities']")
    public WebElement nationalitiesNavButton;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item' and text()='Corporate Branding']")
    public WebElement corporateBrandingNavButton;

    @FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item' and text()='Configuration ']")
    public WebElement configurationNavButton;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Email Configuration']")
    public WebElement emailConfigurationLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Email Subscriptions']")
    public WebElement emailSubscriptionsLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Localization']")
    public WebElement localizationLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Language Packages']")
    public WebElement languagePackagesLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Modules']")
    public WebElement modulesLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Social Media Authentication']")
    public WebElement socialMediaAuthenticationLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Register OAuth Client']")
    public WebElement registerOauthClientLink;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='LDAP Configuration']")
    public WebElement ldapConfigurationLink;
}
