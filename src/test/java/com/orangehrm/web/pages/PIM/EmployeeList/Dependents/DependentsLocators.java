package com.orangehrm.web.pages.PIM.EmployeeList.Dependents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DependentsLocators {
    public DependentsLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Assigned Dependents']/following-sibling::button")
    public WebElement assignedDependentsAddButton;

    @FindBy(xpath = "//label[text()='Relationship']/parent::div/following-sibling::div//i")
    public WebElement relationshipDropdown;

    @FindBy(xpath = "//label[text()='Date of Birth']/parent::div/following-sibling::div//input")
    public WebElement dateOfBirthInputBox;
}
