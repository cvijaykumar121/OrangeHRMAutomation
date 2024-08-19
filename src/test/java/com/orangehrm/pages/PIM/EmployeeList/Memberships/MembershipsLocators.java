package com.orangehrm.pages.PIM.EmployeeList.Memberships;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MembershipsLocators {
    public MembershipsLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Assigned Memberships']/following-sibling::button")
    public WebElement assignedMembershipsAddButton;

    @FindBy(xpath = "//h6[text()='Add Membership']")
    public WebElement addMembershipHeader;

    @FindBy(xpath = "//label[text()='Membership']/parent::div/following-sibling::div//i")
    public WebElement membershipDropdown;

    @FindBy(xpath = "//label[text()='Subscription Paid By']/parent::div/following-sibling::div//i")
    public WebElement subscriptionPaidByDropdown;

    @FindBy(xpath = "//label[text()='Subscription Amount']/parent::div/following-sibling::div/input")
    public WebElement subscriptionAmountInputBox;

    @FindBy(xpath = "//label[text()='Currency']/parent::div/following-sibling::div//i")
    public WebElement currencyDropdown;

    @FindBy(xpath = "//label[text()='Subscription Commence Date']/parent::div/following-sibling::div//input")
    public WebElement subscriptionCommenceDateInputBox;

    @FindBy(xpath = "//label[text()='Subscription Renewal Date']/parent::div/following-sibling::div//input")
    public WebElement subscriptionRenewalDateInputBox;



}
