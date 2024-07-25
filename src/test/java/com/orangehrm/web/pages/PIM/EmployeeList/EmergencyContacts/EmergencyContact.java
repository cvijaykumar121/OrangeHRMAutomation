package com.orangehrm.web.pages.PIM.EmployeeList.EmergencyContacts;
import org.openqa.selenium.WebDriver;

public class EmergencyContact {
    public WebDriver driver;
    public EmergencyContactsLocators emergencyContactsLocators;

    public EmergencyContact(WebDriver driver) {
        this.driver = driver;
        this.emergencyContactsLocators = new EmergencyContactsLocators(driver);
    }
}
