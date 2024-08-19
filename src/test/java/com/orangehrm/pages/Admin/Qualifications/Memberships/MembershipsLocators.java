package com.orangehrm.pages.Admin.Qualifications.Memberships;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MembershipsLocators {
    public MembershipsLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/h6[text()='Memberships']")
    public WebElement membershipTitle;

    @FindBy(xpath = "//h6[text()='Memberships']/following-sibling::div/button")
    public WebElement membershipAddButton;

    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6[text()='Add Membership']")
    public WebElement addMembershipHeader;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement membershipNameInputBox;

    @FindBy(xpath = "//button[@type='submit' and text()=' Save ']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@type='button' and text()=' Cancel ']")
    public WebElement cancelButton;

}
