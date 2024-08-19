package com.orangehrm.pages.PIM.EmployeeList.Salary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalaryLocators {
    public SalaryLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Assigned Salary Components']/following-sibling::button")
    public WebElement assignedSalaryComponentsAddButton;

    @FindBy(xpath = "//label[text()='Salary Component']/parent::div/following-sibling::div//input")
    public WebElement salaryComponentInputBox;

    @FindBy(xpath = "//label[text()='Pay Grade']/parent::div/following-sibling::div//i")
    public WebElement payGradesDropdown;

    @FindBy(xpath = "//label[text()='Pay Frequency']/parent::div/following-sibling::div//i")
    public WebElement payFrequencyDropdown;

    @FindBy(xpath = "//label[text()='Currency']/parent::div/following-sibling::div//i")
    public WebElement currencyDropdown;

    @FindBy(xpath = "//label[text()='Amount']/parent::div/following-sibling::div//input")
    public WebElement amountInputBox;

    @FindBy(xpath = "//label[text()='Comments']/parent::div/following-sibling::div/textarea")
    public WebElement commentsInputBox;

    @FindBy(xpath = "//p[text()='Include Direct Deposit Details']/parent::div//child::span")
    public WebElement includeDirectDepositDetailsCheckbox;

    @FindBy(xpath = "//label[text()='Account Number']/parent::div/following-sibling::div//input")
    public WebElement accountNumberInputBox;

    @FindBy(xpath = "//label[text()='Account Type']/parent::div/following-sibling::div//i")
    public WebElement accountTypeDropdown;

    @FindBy(xpath = "//label[text()='Routing Number']/parent::div/following-sibling::div//input")
    public WebElement routingNumberInputBox;

    @FindBy(xpath = "//div[@class='oxd-form-row directdeposit-form-header']/following-sibling::div[@class='oxd-form-row']//label[text()='Amount']/parent::div/following-sibling::div//input")
    public WebElement directDepositAmountInputBox;





}
