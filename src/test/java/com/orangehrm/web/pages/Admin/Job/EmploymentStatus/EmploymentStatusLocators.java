package com.orangehrm.web.pages.Admin.Job.EmploymentStatus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmploymentStatusLocators {
    public EmploymentStatusLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/h6[text()='Employment Status']")
    public WebElement employmentStatusTitle;

    @FindBy(xpath = "//h6[text()='Employment Status']/following-sibling::div/button")
    public WebElement employmentStatusAddButton;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement addEmploymentStatus_NameInputBox;
}
