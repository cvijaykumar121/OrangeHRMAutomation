package com.orangehrm.web.pages.Admin.Job.PayGrades;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']/div[@class='oxd-select-text-input']")
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

}
