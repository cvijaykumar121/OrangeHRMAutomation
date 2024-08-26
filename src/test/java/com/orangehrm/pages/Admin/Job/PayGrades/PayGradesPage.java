package com.orangehrm.pages.Admin.Job.PayGrades;
import com.orangehrm.base.TestBase;
import com.orangehrm.base.Locators;
import com.orangehrm.base.StepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayGradesPage extends TestBase {
    public WebDriver driver;
    public PayGradesLocators payGradesLocators;
    public StepDefinition stepDefinition;
    public Locators locators;

    public PayGradesPage(WebDriver driver) {
        this.driver = driver;
        this.payGradesLocators = new PayGradesLocators(driver);
        this.stepDefinition = new StepDefinition(driver);
        this.locators = new Locators(driver);
    }

    public void validate_PayGrades_Title() {
        waitForElementToBeVisible(payGradesLocators.payGradesTitle, 30, "Successfully navigated to Pay Grades Page");
    }

    public void click_On_PayGrades_AddButton() {
        clickElement(payGradesLocators.payGradesAddButton, "Successfully clicked on Pay Grades Add Button", true, 20);
    }

    private void validate_AddPayGrade_Button() {
        waitForElementToBeVisible(payGradesLocators.payGradesAddButton,30, "Pay Grades Add Button is present");
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

    public void validate_Edit_PayGrade_Title() {
        validateText(payGradesLocators.editPayGradeTitle, "Edit Pay Grade", "Successfully validated Edit Pay Grades Title", 30);
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

            while (isElementPresent(payGradesLocators.allPayGrades)) {
                clickElement(payGradesLocators.selectAllPayGradesCheckbox, "Clicked on select all Pay Grades checkbox", true, 30);
                clickElement(payGradesLocators.deleteSelectedButton, "Clicked on delete selected button", true, 30);
                stepDefinition.handle_Delete_Pop_Up(true);

                waitForElementToBeVisible(locators.tableHeader, 30);
            }
            System.out.println("No Pay Grades present now");
        }
    }

    public void validate_Currency_Is_Successfully_Added(String currency) {
        // Find the position of the hyphen ("-")
        int hyphenIndex = currency.indexOf("-");
        System.out.println("Index of hyphen: " + hyphenIndex);

        // Extract the part after the hyphen and trim any leading or trailing spaces
        String expectedCurrencyInTable = currency.substring(hyphenIndex + 1).trim();
        System.out.println("Expected Currency Name: " + expectedCurrencyInTable);

        WebElement currencyInTableElement = payGradesLocators.getCurrencyElement(expectedCurrencyInTable);

        //Actual Currency Name from table
        waitForElementToBeVisible(currencyInTableElement, 30, "Validated Currency in table");
        validateText(currencyInTableElement, expectedCurrencyInTable, "Validated Currency Added", 30);
    }

    public WebElement validate_PayGrade_Is_Successfully_Added(String payGrade) {
        WebElement payGradeInTable = payGradesLocators.getPayGradeElement(payGrade);
        waitForElementToBeVisible(payGradeInTable, 30, payGrade + " Pay grade is added successfully");
        return payGradeInTable;
    }

    public void click_On_Edit_For_PayGrade(String payGrade) {
        WebElement requiredPayGrade = validate_PayGrade_Is_Successfully_Added(payGrade);
        WebElement editIconForRequiredPayGrade = requiredPayGrade.findElement(By.xpath("//ancestor::div[@class='oxd-table-card']//button/i[@class='oxd-icon bi-pencil-fill']"));
        clickElement(editIconForRequiredPayGrade, "Successfully clicked on edit icon of " + payGrade, true, 30);
    }

    public void validate_Error_Message_When_Maximum_Salary_Is_Greater_Than_Minimum_Salary() {
        WebElement errorMessage = payGradesLocators.minSalaryGreaterThanMaxSalaryError;
        waitForElementToBeVisible(errorMessage, 20);
        validateText(errorMessage, "Should be higher than Minimum Salary", "Validated the error message 'Should be higher than Minimum Salary'", 20);
    }

    public void validate_No_PayGrades_Present() {
        if(isElementPresent(payGradesLocators.allPayGrades)) {
            deleteAllPayGradesFromPayGradesPage();
        } else {
            logInfo("No Pay Grades are present", true);
        }
    }

    private void validate_Name_Header_Is_Present() {
        waitForElementToBeVisible(payGradesLocators.nameHeaderInTable, 30, "Name Header in table is present");
    }

    private void validate_Currency_Header_Is_Present() {
        waitForElementToBeVisible(payGradesLocators.currencyHeaderInTable, 30, "Currency Header in table is present");
    }

    private void validate_Actions_Header_Is_Present() {
        waitForElementToBeVisible(payGradesLocators.actionsHeaderInTable, 30, "Actions Header in table is present");
    }

    private void validate_Table_Header_Elements_Are_Present() {
//        stepDefinition.validate_Table_Header_Checkbox_Is_Present();
        validate_Name_Header_Is_Present();
        validate_Currency_Header_Is_Present();
        validate_Actions_Header_Is_Present();
    }

    public void validate_All_Elements_Of_PayGrades_Page() {
        validate_PayGrades_Title();
        validate_AddPayGrade_Button();
        stepDefinition.validate_Table_Header_Is_Present();
        validate_Table_Header_Elements_Are_Present();
    }

    public void validate_Currency_And_PayGrade_Is_Displayed_In_Table() {

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
