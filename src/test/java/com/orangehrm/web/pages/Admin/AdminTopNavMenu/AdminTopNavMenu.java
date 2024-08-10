package com.orangehrm.web.pages.Admin.AdminTopNavMenu;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;

public class AdminTopNavMenu extends TestBase {
    public WebDriver driver;
    public AdminTopNavMenuLocators adminTopNavMenuLocators;

    public AdminTopNavMenu(WebDriver driver) {
        this.driver = driver;
        this.adminTopNavMenuLocators = new AdminTopNavMenuLocators(driver);
    }

    private void click_On_Job_Nav_Button() {
        clickElement(adminTopNavMenuLocators.jobNavButton, "Clicked on job nav button", true, 30);
    }

    public void navigate_To_JobTitles_Page() {
        click_On_Job_Nav_Button();
        clickElement(adminTopNavMenuLocators.jobTitlesLink, "Clicked on Job titles link", true, 30);
    }

    public void navigate_To_PayGrades_Page() {
        click_On_Job_Nav_Button();
        clickElement(adminTopNavMenuLocators.payGradesLink, "Clicked on Pay Grades link", true, 30);
    }

    public void navigate_To_EmploymentStatus_Page() {
        click_On_Job_Nav_Button();
        clickElement(adminTopNavMenuLocators.employmentStatusLink, "Clicked on Employment Status link", true, 30);
    }

    public void navigate_To_JobCategories_Page() {
        click_On_Job_Nav_Button();
        clickElement(adminTopNavMenuLocators.jobCategoriesLink, "Clicked on Job Categories link", true, 30);
    }

    public void navigate_To_WorkShifts_Page() {
        click_On_Job_Nav_Button();
        clickElement(adminTopNavMenuLocators.workShiftsLink, "Clicked on Work Shifts link", true, 30);
    }

    private void click_On_Organization_Nav_Button() {
        clickElement(adminTopNavMenuLocators.organizationNavButton, "Clicked on Organization Nav Button", true, 30);
    }

    public void navigate_To_General_Information_Page() {
        click_On_Organization_Nav_Button();
        clickElement(adminTopNavMenuLocators.generalInformationLink, "Clicked on General information link", true, 30);
    }

    public void navigate_To_Locations_Page() {
        click_On_Organization_Nav_Button();
        clickElement(adminTopNavMenuLocators.locationsLink, "Clicked on Locations link", true, 30);
    }

    public void navigate_To_Structure_Page() {
        click_On_Organization_Nav_Button();
        clickElement(adminTopNavMenuLocators.structureLink, "Clicked on Structure link", true, 30);
    }

    private void click_On_Qualifications_Nav_Button() {
        clickElement(adminTopNavMenuLocators.qualificationsNavButton, "Clicked on Qualifications Nav button", true, 30);
    }

    public void navigate_To_Skills_Page() {
        click_On_Qualifications_Nav_Button();
        clickElement(adminTopNavMenuLocators.skillsLink, "Clicked on Skills Link", true, 30);
    }

    public void navigate_To_Education_Page() {
        click_On_Qualifications_Nav_Button();
        clickElement(adminTopNavMenuLocators.educationLink, "Clicked on Education Link", true, 30);
    }

    public void navigate_To_Licenses_Page() {
        click_On_Qualifications_Nav_Button();
        clickElement(adminTopNavMenuLocators.licensesLink, "Clicked on Licenses Link", true, 30);
    }

    public void navigate_To_Languages_Page() {
        click_On_Qualifications_Nav_Button();
        clickElement(adminTopNavMenuLocators.languagesLink, "Clicked on Languages Link", true, 30);
    }

    public void navigate_To_Memberships_Page() {
        click_On_Qualifications_Nav_Button();
        clickElement(adminTopNavMenuLocators.membershipsLink, "Clicked on Memberships Link", true, 30);
    }

    public void navigate_To_Nationalities_Page() {
        clickElement(adminTopNavMenuLocators.nationalitiesNavButton, "Clicked on Nationalities nav button", true, 30);
    }

    public void navigate_To_Corporate_Branding_Page() {
        clickElement(adminTopNavMenuLocators.corporateBrandingNavButton, "Clicked on Corporate Branding page", true, 30);
    }

    private void click_On_Configuration_Nav_Button() {
        clickElement(adminTopNavMenuLocators.configurationNavButton, "Clicked on Configuration Nav Button", true, 30);
    }

    public void navigate_To_Email_Subscription_Page() {
        click_On_Configuration_Nav_Button();
        clickElement(adminTopNavMenuLocators.emailSubscriptionsLink, "Clicked on Email Subscription link", true, 30);
    }

    public void navigate_To_Localization_Page() {
        click_On_Configuration_Nav_Button();
        clickElement(adminTopNavMenuLocators.localizationLink, "Clicked on Localization link", true, 30);
    }

    public void navigate_To_Language_Packages_Page() {
        click_On_Configuration_Nav_Button();
        clickElement(adminTopNavMenuLocators.languagePackagesLink, "Clicked on Language Packages link", true, 30);
    }

    public void navigate_To_Modules_Page() {
        click_On_Configuration_Nav_Button();
        clickElement(adminTopNavMenuLocators.modulesLink, "Clicked on Modules link", true, 30);
    }

    public void navigate_To_Social_Media_Authentication_Page() {
        click_On_Configuration_Nav_Button();
        clickElement(adminTopNavMenuLocators.socialMediaAuthenticationLink, "Clicked on Social Media Authentication link", true, 30);
    }

    public void navigate_To_Register_OAuth_Client_Page() {
        click_On_Configuration_Nav_Button();
        clickElement(adminTopNavMenuLocators.registerOauthClientLink, "Clicked on Register OAuth Client link", true, 30);
    }

    public void navigate_To_LDAP_Configuration_Page() {
        click_On_Configuration_Nav_Button();
        clickElement(adminTopNavMenuLocators.ldapConfigurationLink, "Clicked on LDAP Configuration link", true, 30);
    }
}
