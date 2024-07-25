package com.orangehrm.web.pages.PIM.EmployeeList.Memberships;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MembershipsLocators {
    public MembershipsLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
