package com.orangehrm.pages.PIM.EmployeeList.ReportTo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportToLocators {
    public ReportToLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Report to']")
    public WebElement reportToHeader;

    @FindBy(xpath = "//h6[text()='Assigned Supervisors']/following-sibling::button")
    public WebElement assignedSupervisorAddButton;

    @FindBy(xpath = "//label[text()='Reporting Method']/parent::div/following-sibling::div//i")
    public WebElement reportingMethodDropdown;

    @FindBy(xpath = "//h6[text()='Assigned Subordinates']/following-sibling::button")
    public WebElement assignedSubordinatesAddButton;




}
