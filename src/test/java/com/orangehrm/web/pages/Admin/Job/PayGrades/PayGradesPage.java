package com.orangehrm.web.pages.Admin.Job.PayGrades;
import com.orangehrm.web.base.StepDefinition;
import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayGradesPage extends TestBase {
    public WebDriver driver;
    public PayGradesLocators payGradesLocators;
    public StepDefinition stepDefinition;

    public PayGradesPage(WebDriver driver) {
        this.driver = driver;
        this.payGradesLocators = new PayGradesLocators(driver);
        this.stepDefinition = new StepDefinition(driver);
    }

    public void validate_PayGrades_Title() {
        waitForElementToBeVisible(payGradesLocators.payGradesTitle, 30, "Successfully navigated to Pay Grades Page");
    }

    public void click_On_PayGrades_AddButton() {
        clickElement(payGradesLocators.payGradesAddButton, "Successfully clicked on Pay Grades Add Button", true, 20);
    }

    public void validate_AddPayGrade_Title() {
        waitForElementToBeVisible(payGradesLocators.addPayGradeTitle, 30, "Successfully navigated to Add Pay Grades Page");
    }

    public void enter_PayGrade_Name(String payGradeName) {
        sendKeys(payGradesLocators.payGradeName_InputBox, payGradeName, "Successfully entered pay grade name", 20);
    }

    public void click_On_AddPayGrade_SaveButton() {
        clickElement(payGradesLocators.addPayGradeSaveButton, "Successfully clicked on Add Pay Grade Save button", true, 20);
    }

    public void click_On_AddPayGrade_CancelButton() {
        clickElement(payGradesLocators.addPayGradeCancelButton, "Successfully clicked on Add Pay Grade Cancel button", true, 20);
    }

    public void validate_Currencies_Title() {
        waitForElementToBeVisible(payGradesLocators.currenciesTitle, 30, "Currencies Title is displayed successfully");
    }

    public void click_On_AddCurrency_Button() {
        clickElement(payGradesLocators.currenciesAddButton, "Successfully clicked on Add Currency button", true, 30);
    }

    public void click_On_CurrencyName_Dropdown() {
        clickElement(payGradesLocators.currencyDropdown, "Successfully clicked on Currency Dropdown", true, 30);
    }

    public void select_CurrencyName_From_Dropdown(String currencyName) {
        click_On_CurrencyName_Dropdown();
        WebElement currencyOption = driver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + currencyName + "']"));
        clickElement(currencyOption, "Successfully selected " + currencyName + " from dropdown", true, 20);
    }

    public void enter_Minimum_Salary(String minimumSalary) {
        sendKeys(payGradesLocators.minimumSalaryInputBox, minimumSalary, "Successfully entered minimum salary", 30);
    }

    public void enter_Maximum_Salary(String maximumSalary) {
        sendKeys(payGradesLocators.maximumSalaryInputBox, maximumSalary, "Successfully entered maximum salary", 30);
    }

    public void click_On_AddCurrency_SaveButton() {
        clickElement(payGradesLocators.addCurrencySaveButton, "Successfully clicked on Add Currency Save Button", true, 30);
    }

    public void deleteAllPayGradesFromPayGradesPage() {
        while (isElementPresent(payGradesLocators.allPayGrades)) {
            clickElement(payGradesLocators.selectAllPayGradesCheckbox, "Clicked on select all Pay Grades checkbox", true, 30);
            clickElement(payGradesLocators.deleteSelectedButton, "Clicked on delete selected button", true, 30);
            stepDefinition.handle_Delete_Pop_Up(true);

            waitForElementToBeVisible(payGradesLocators.payGradesTableHeaderRow, 30, "All Pay Grades deleted");
        }
        System.out.println("No jobs present now");
    }


//    public void addPayGrades_WithValidDetails(String payGradeName) {
//        validate_PayGrades_Title();
//        click_On_PayGrades_AddButton();
//        validate_AddPayGrade_Title();
//        enter_PayGrade_Name(payGradeName);
//        click_On_AddPayGrade_SaveButton();
//    }
//
//    public void addCurrency_WithValidDetails(String currencyName, String minimumSalary, String maximumSalary) {
//        validate_Currencies_Title();
//        click_On_AddCurrency_Button();
//        select_CurrencyName_From_Dropdown(currencyName);
//        enter_Minimum_Salary(minimumSalary);
//        enter_Maximum_Salary(maximumSalary);
//        click_On_AddCurrency_SaveButton();
//    }
}
