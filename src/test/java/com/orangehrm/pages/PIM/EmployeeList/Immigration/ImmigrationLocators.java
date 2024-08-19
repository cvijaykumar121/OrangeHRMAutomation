package com.orangehrm.pages.PIM.EmployeeList.Immigration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImmigrationLocators {
    public ImmigrationLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Assigned Immigration Records']/following-sibling::button")
    public WebElement assignedImmigrationRecordsAddButton;

    @FindBy(xpath = "//div[@class='oxd-radio-wrapper']/label[text()='Passport']/span")
    public WebElement passportRadioButton;

    @FindBy(xpath = "//div[@class='oxd-radio-wrapper']/label[text()='Visa']/span")
    public WebElement visaRadioButton;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and .//../preceding-sibling::div/label[text()='Number']]")
    public WebElement numberInputBox;

    @FindBy(xpath = "//label[text()='Issued Date']/parent::div/following-sibling::div//input")
    public WebElement issuedDateInputBox;

    @FindBy(xpath = "//label[text()='Expiry Date']/parent::div/following-sibling::div//input")
    public WebElement expiryDateInputBox;

    @FindBy(xpath = "//label[text()='Eligible Status']/parent::div/following-sibling::div/input")
    public WebElement eligibleStatusInputBox;

    @FindBy(xpath = "//label[text()='Eligible Review Date']/parent::div/following-sibling::div//input")
    public WebElement eligibleReviewDateInputBox;

    @FindBy(xpath = "//label[text()='Comments']/parent::div/following-sibling::div/textarea")
    public WebElement commentsInputBox;
}
