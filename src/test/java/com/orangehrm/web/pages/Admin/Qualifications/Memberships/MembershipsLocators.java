package com.orangehrm.web.pages.Admin.Qualifications.Memberships;

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

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement membershipNameInputBox;
}
