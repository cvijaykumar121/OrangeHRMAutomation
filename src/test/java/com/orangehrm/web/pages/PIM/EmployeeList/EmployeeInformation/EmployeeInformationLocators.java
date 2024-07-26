package com.orangehrm.web.pages.PIM.EmployeeList.EmployeeInformation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeInformationLocators {
    public EmployeeInformationLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[text()='Employee Name']/parent::div/following-sibling::div//child::input")
    public WebElement employeeNameInputBox;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item' and text()='Employee List']")
    public WebElement employeeListNavButton;

    @FindBy(xpath = "//h5[text()='Employee Information']")
    public WebElement employeeInformationTitle;
}
