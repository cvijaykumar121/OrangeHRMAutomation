package com.orangehrm.web.pages.Admin.Qualifications.Memberships;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;

public class MembershipsPage extends TestBase {
    public WebDriver driver;
    public MembershipsLocators membershipsLocators;

    public MembershipsPage(WebDriver driver) {
        this.driver = driver;
        this.membershipsLocators = new MembershipsLocators(driver);
    }

    public void validate_Memberships_Header() {
        validateText(membershipsLocators.membershipTitle, "Memberships", "Validated Memberships title", 30);
    }

    public void click_On_Memberships_Add_Button() {
        clickElement(membershipsLocators.membershipAddButton, "Clicked on Memberships Add Button", true, 30);
    }

    public void validate_Add_Memberships_Header() {
        validateText(membershipsLocators.addMembershipHeader, "Add Membership", "Validated Add Membership title", 30);
    }

    public void enter_Membership_Name(String membershipName) {
        sendKeys(membershipsLocators.membershipNameInputBox, membershipName, "Entered Membership Name: " + membershipName, 30);
    }

    public void click_On_Save_Button() {
        clickElement(membershipsLocators.saveButton, "Clicked on Save Button", true, 30);
    }

    public void click_On_Cancel_Button() {
        clickElement(membershipsLocators.cancelButton, "Clicked on Cancel Button", true, 30);
    }
}
