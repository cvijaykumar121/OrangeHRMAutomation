package com.orangehrm.pages.Admin.Job.EmploymentStatus;

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

    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6[text()='Add Employment Status']")
    public WebElement addEmploymentStatusTitle;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement addEmploymentStatus_NameInputBox;

    @FindBy(xpath = "//button[@type='button' and text()=' Cancel ']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[@type='submit' and text()=' Save ']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")
    public WebElement recordsFoundElement;
}
