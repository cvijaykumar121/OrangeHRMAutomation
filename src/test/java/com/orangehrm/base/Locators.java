package com.orangehrm.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locators {
    public Locators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@type='submit' and text()=' Save ']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@type='button' and text()=' Cancel ']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    public WebElement yesDeleteJobTitleButton;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin']")
    public WebElement noCancelJobTitleButton;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--card-title']")
    public WebElement deleteJobTitlePopUpHeader;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--card-body']")
    public WebElement deleteJobTitlePopUpBody;

    @FindBy(xpath = "//div[@id='oxd-toaster_1']")
    public WebElement toastMessage;

    @FindBy(xpath = "//span[text()='Already exists']")
    public WebElement alreadyExistsMessage;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']")
    public WebElement allPayGrades;

    @FindBy(xpath = "//div[@class='oxd-table-header']//div[@class='oxd-checkbox-wrapper']")
    public WebElement selectAllPayGradesCheckbox;

    @FindBy(xpath = "//button[@type='button' and text()=' Delete Selected ']")
    public WebElement deleteSelectedButton;

    @FindBy(xpath = "//div[@class='oxd-table-header']")
    public WebElement payGradesTableHeaderRow;

    @FindBy(xpath = "//span[text()='No Records Found']")
    public WebElement noRecordsFoundText;

    @FindBy(xpath = "//div[@class='oxd-table-header']")
    public WebElement tableHeader;

    @FindBy(xpath = "//div[@class='oxd-table-header']//div[@role='columnheader']//input[@type='checkbox']")
    public WebElement tableHeaderCheckbox;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    public WebElement errorMessage;

}
