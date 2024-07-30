package com.orangehrm.web.pages.Admin.Job.JobTitle;

import com.orangehrm.web.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JobTitleLocators {
    public JobTitleLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' or text()='Job Titles']")
    public WebElement jobTitlesHeader;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary' or text()=' Add ']")
    public WebElement jobTitleAddButton;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' and text()='Add Job Title']")
    public WebElement addJobTitleHeader;

    @FindBy(xpath = "//form[@class='oxd-form']/div[@class='oxd-form-row']//label[text()='Job Title']")
    public WebElement jobTitleInputHeader;

    @FindBy(xpath = "//form[@class='oxd-form']/div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']")
    public WebElement jobTitleInput;

    @FindBy(xpath = "//form[@class='oxd-form']/div[@class='oxd-form-row']//label[text()='Job Description']")
    public WebElement jobDescriptionInputHeader;

    @FindBy(xpath = "(//form[@class='oxd-form']/div[@class='oxd-form-row']//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical'])[1]")
    public WebElement jobDescriptionInput;

    @FindBy(xpath = "//form[@class='oxd-form']/div[@class='oxd-form-row']//label[text()='Job Specification']")
    public WebElement jobSpecificationInputHeader;

    @FindBy(xpath = "//div[@class='oxd-file-button']")
    public WebElement jobSpecificationBrowseButton;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-input-hint' or text()='Accepts up to 1MB ']")
    public WebElement jobSpecificationHint;

    @FindBy(xpath = "//form[@class='oxd-form']/div[@class='oxd-form-row']//label[text()='Note']")
    public WebElement noteInputHeader;

    @FindBy(xpath = "//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical' and @placeholder='Add note']")
    public WebElement addNoteTextBox;

    @FindBy(xpath = "//div[@class='oxd-form-row' and .//label[text()='Job Title']]//span[text()='Required']")
    public WebElement jobTitleRequiredErrorMessage;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost' or text()='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='oxd-table']")
    public WebElement jobTitlesTable;

    @FindBy(xpath = "(//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th'])[1]")
    public WebElement checkboxHeader;

    @FindBy(xpath = "//div[@class='oxd-table']//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th' and text()='Job Description']")
    public WebElement jobDescriptionTableHeader;

    @FindBy(xpath = "//div[@class='oxd-table']//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th' and text()='Actions']")
    public WebElement actionsTableHeader;

    @FindBy(xpath = "//div[@class='oxd-table-body']/*")
    public List<WebElement> jobTitlesTableRows;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--card-title']")
    public WebElement deleteJobTitlePopUpHeader;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--card-body']")
    public WebElement deleteJobTitlePopUpBody;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    public WebElement yesDeleteJobTitleButton;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin']")
    public WebElement noCancelJobTitleButton;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']")
    public WebElement allJobTitles;

    @FindBy(xpath = "//div[@class='oxd-table-header']//input[@type='checkbox']")
    public WebElement selectAllJobTitlesCheckbox;

    @FindBy(xpath = "//button[@type='button' and text()=' Delete Selected ']")
    public WebElement deleteSelectedButton;

    public WebElement getMaximumCharactersErrorMessageXpath(String fieldHeader) {
        String requiredXpath = "//div[@class='oxd-form-row' and .//label='" + fieldHeader + "']//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";
        return Hooks.driver.findElement(By.xpath(requiredXpath));
    }
}
