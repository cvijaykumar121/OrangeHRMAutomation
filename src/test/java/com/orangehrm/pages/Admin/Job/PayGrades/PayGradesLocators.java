package com.orangehrm.pages.Admin.Job.PayGrades;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.orangehrm.StepDefinitions.Hooks.driver;

public class PayGradesLocators {
    public PayGradesLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/h6[text()='Pay Grades']")
    public WebElement payGradesTitle;

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/div/button[@type='button' and text()=' Add ']")
    public WebElement payGradesAddButton;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' and text()='Add Pay Grade']")
    public WebElement addPayGradeTitle;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and .//parent::div/preceding-sibling::div/label[text()='Name']]")
    public WebElement payGradeName_InputBox;

    @FindBy(xpath = "//div[@class='orangehrm-card-container' and .//h6[text()='Add Pay Grade']]//button[@type='submit']")
    public WebElement addPayGradeSaveButton;

    @FindBy(xpath = "//div[@class='orangehrm-card-container' and .//h6[text()='Add Pay Grade']]//button[@type='button']")
    public WebElement addPayGradeCancelButton;

    @FindBy(xpath = "//div[@class='orangehrm-action-header']/h6[text()='Currencies']")
    public WebElement currenciesTitle;

    @FindBy(xpath = "//div[@class='orangehrm-action-header']/button[@type='button' and text()=' Add ']")
    public WebElement currenciesAddButton;

    @FindBy(xpath = "//label[text()='Currency']/parent::div/following-sibling::div//i")
    public WebElement currencyDropdown;

    @FindBy(xpath = "//label[text()='Minimum Salary']/parent::div/following-sibling::div/input")
    public WebElement minimumSalaryInputBox;

    @FindBy(xpath = "//label[text()='Maximum Salary']/parent::div/following-sibling::div/input")
    public WebElement maximumSalaryInputBox;

    @FindBy(xpath = "//div[@class='orangehrm-card-container' and .//h6[text()='Add Currency']]//div[@class='oxd-form-actions']/button[@type='submit' and text()=' Save ']")
    public WebElement addCurrencySaveButton;

    @FindBy(xpath = "//div[@class='orangehrm-card-container' and .//h6[text()='Add Currency']]//div[@class='oxd-form-actions']/button[@type='submit' and text()=' Cancel ']")
    public WebElement addCurrencyCancelButton;

    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6[text()='Edit Pay Grade']")
    public WebElement editPayGradeTitle;

    @FindBy(xpath = "//div[@class='orangehrm-card-container' and .//h6[text()='Edit Pay Grade']]//button[@type='submit']")
    public WebElement editPayGradeSaveButton;

    @FindBy(xpath = "//div[@class='orangehrm-card-container' and .//h6[text()='Edit Pay Grade']]//button[@type='button']")
    public WebElement editPayGradeCancelButton;

    @FindBy(xpath = "//div[@class='oxd-table']/div[@class='oxd-table-header']/div")
    public WebElement currencyTableHeaders;

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

    public WebElement getCurrencyElement(String currency) {
        String xpath = "//div[@class='oxd-table']//div[@class='oxd-table-body']//div[@role='row']//div[text()='" + currency + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getPayGradeElement(String payGrade) {
        String xpath = "//div[@class='oxd-table']//div[@class='oxd-table-body']//div[@role='row']//div[text()='" + payGrade + "']";
        return driver.findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//span[text()='Should be higher than Minimum Salary']")
    public WebElement minSalaryGreaterThanMaxSalaryError;

    @FindBy(xpath = "//div[@class='oxd-table-header']//div[@role='columnheader' and text()='Name']")
    public WebElement nameHeaderInTable;

    @FindBy(xpath = "//div[@class='oxd-table-header']//div[@role='columnheader' and text()='Currency']")
    public WebElement currencyHeaderInTable;

    @FindBy(xpath = "//div[@class='oxd-table-header']//div[@role='columnheader' and text()='Actions']")
    public WebElement actionsHeaderInTable;

}
