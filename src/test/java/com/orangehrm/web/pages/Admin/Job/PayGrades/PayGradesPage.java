package com.orangehrm.web.pages.Admin.Job.PayGrades;
import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayGradesPage extends TestBase {
    public WebDriver driver;
    public PayGradesLocators payGradesLocators;

    public PayGradesPage(WebDriver driver) {
        this.driver = driver;
        this.payGradesLocators = new PayGradesLocators(driver);
    }

    private void validate_PayGrades_Title() {
        waitForElementToBeVisible(payGradesLocators.payGradesTitle, 30, "Successfully navigated to Pay Grades Page");
    }

    private void click_On_PayGrades_AddButton() {
        clickElement(payGradesLocators.payGradesAddButton, "Successfully clicked on Pay Grades Add Button", true, 20);
    }

    private void validate_AddPayGrade_Title() {
        waitForElementToBeVisible(payGradesLocators.addPayGradeTitle, 30, "Successfully navigated to Add Pay Grades Page");
    }

    private void enter_PayGrade_Name(String payGradeName) {
        sendKeys(payGradesLocators.payGradeName_InputBox, payGradeName, "Successfully entered pay grade name", 20);
    }

    private void click_On_AddPayGrade_SaveButton() {
        clickElement(payGradesLocators.addPayGradeSaveButton, "Successfully clicked on Add Pay Grade Save button", true, 20);
    }

    private void click_On_AddPayGrade_CancelButton() {
        clickElement(payGradesLocators.addPayGradeCancelButton, "Successfully clicked on Add Pay Grade Cancel button", true, 20);
    }

    private void validate_Currencies_Title() {
        waitForElementToBeVisible(payGradesLocators.currenciesTitle, 30, "Currencies Title is displayed successfully");
    }

    private void click_On_AddCurrency_Button() {
        clickElement(payGradesLocators.currenciesAddButton, "Successfully clicked on Add Currency button", true, 30);
    }

    private void click_On_CurrencyName_Dropdown() {
        clickElement(payGradesLocators.currencyDropdown, "Successfully clicked on Currency Dropdown", true, 30);
    }

    private void select_CurrencyName_From_Dropdown(String currencyName) {
        click_On_CurrencyName_Dropdown();
        WebElement currencyOption = driver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + currencyName + "']"));
        clickElement(currencyOption, "Successfully selected " + currencyName + " from dropdown", true, 20);
    }

    private void enter_Minimum_Salary(String minimumSalary) {
        sendKeys(payGradesLocators.minimumSalaryInputBox, minimumSalary, "Successfully entered minimum salary", 30);
    }

    private void enter_Maximum_Salary(String maximumSalary) {
        sendKeys(payGradesLocators.maximumSalaryInputBox, maximumSalary, "Successfully entered maximum salary", 30);
    }

    private void click_On_AddCurrency_SaveButton() {
        clickElement(payGradesLocators.addCurrencySaveButton, "Successfully clicked on Add Currency Save Button", true, 30);
    }

    public void addPayGrades_WithValidDetails(String payGradeName) {
        validate_PayGrades_Title();
        click_On_PayGrades_AddButton();
        validate_AddPayGrade_Title();
        enter_PayGrade_Name(payGradeName);
        click_On_AddPayGrade_SaveButton();
    }

    public void addCurrency_WithValidDetails(String currencyName, String minimumSalary, String maximumSalary) {
        validate_Currencies_Title();
        click_On_AddCurrency_Button();
        select_CurrencyName_From_Dropdown(currencyName);
        enter_Minimum_Salary(minimumSalary);
        enter_Maximum_Salary(maximumSalary);
        click_On_AddCurrency_SaveButton();
    }
}
