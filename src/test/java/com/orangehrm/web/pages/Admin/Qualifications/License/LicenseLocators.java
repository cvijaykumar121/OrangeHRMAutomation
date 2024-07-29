package com.orangehrm.web.pages.Admin.Qualifications.License;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LicenseLocators {
    public LicenseLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/h6[text()='Licenses']")
    public WebElement licensesTitle;

    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6[text()='Add License']")
    public WebElement addLicenseHeader;

    @FindBy(xpath = "//h6[text()='Licenses']/following-sibling::div/button")
    public WebElement licenseAddButton;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement licenseNameInputBox;

    @FindBy(xpath = "//button[@type='submit' and text()=' Save ']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@type='button' and text()=' Cancel ']")
    public WebElement cancelButton;

}
