package com.orangehrm.pages.Admin.Configuration.EmailSubscriptions;

import com.orangehrm.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailSubscriptionsLocators {
    public EmailSubscriptionsLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Email Subscriptions']")
    public WebElement emailSubscriptionsHeader;

    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-table-cell-action-space' and ./ancestor::div[@role='row']//div[text()='Leave Applications']]")
    public WebElement addUserButtonForLeaveApplications;

    @FindBy(xpath = "//h6[text()='Subscribers: Leave Applications']")
    public WebElement leaveApplicationsSubscribersHeader;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement nameInput;

    @FindBy(xpath = "//label[text()='Email']/parent::div/following-sibling::div/input")
    public WebElement emailInput;

    public WebElement valueInTable(String value) {
        return Hooks.driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@role='row']//div[text()='" + value + "']"));
    }

    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-table-cell-action-space' and ./ancestor::div[@role='row']//div[text()='Leave Approvals']]")
    public WebElement addUserButtonForLeaveApprovals;

    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-table-cell-action-space' and ./ancestor::div[@role='row']//div[text()='Leave Assignments']]")
    public WebElement addUserButtonForLeaveAssignments;

    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-table-cell-action-space' and ./ancestor::div[@role='row']//div[text()='Leave Cancellations']]")
    public WebElement addUserButtonForLeaveCancellations;

    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-table-cell-action-space' and ./ancestor::div[@role='row']//div[text()='Leave Rejections']]")
    public WebElement addUserButtonForLeaveRejections;
}
