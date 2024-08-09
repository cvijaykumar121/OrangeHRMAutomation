package com.orangehrm.web.pages.PIM.EmployeeList.Job;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JobPageLocators {
    public JobPageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-tabs-wrapper' and @role='tab']/a[text()='Job']")
    public WebElement jobSideMenu;

    @FindBy(xpath = "//h6[text()='Job Details']")
    public WebElement jobDetailsPageTitle;

    @FindBy(xpath = "//label[text()='Joined Date']/parent::div/following-sibling::div//input")
    public WebElement joinedDateInputBox;

    @FindBy(xpath = "//label[text()='Job Title']/parent::div/following-sibling::div//child::*[@class='oxd-select-text-input']")
    public WebElement jobTitleDropdown;

    @FindBy(xpath = "//div[@role='listbox']/div/span")
    public List<WebElement> allJobTitles;

    @FindBy(xpath = "//label[text()='Job Category']/parent::div/following-sibling::div//child::*[@class='oxd-select-text-input']")
    public WebElement jobCategoryDropdown;

    @FindBy(xpath = "//label[text()='Sub Unit']/parent::div/following-sibling::div//child::*[@class='oxd-select-text-input']")
    public WebElement subunitDropdown;

    @FindBy(xpath = "//label[text()='Location']/parent::div/following-sibling::div//child::*[@class='oxd-select-text-input']")
    public WebElement locationDropdown;

    @FindBy(xpath = "//label[text()='Employment Status']/parent::div/following-sibling::div//child::*[@class='oxd-select-text-input']")
    public WebElement employmentStatusDropdown;

    @FindBy(xpath = "//p[text()='Include Employment Contract Details']/parent::div//child::span")
    public WebElement includeEmploymentContractDetailsCheckbox;

    @FindBy(xpath = "//label[text()='Contract Start Date']/parent::div/following-sibling::div//input")
    public WebElement contractStartDateInputBox;

    @FindBy(xpath = "//label[text()='Contract End Date']/parent::div/following-sibling::div//input")
    public WebElement contractDateEndInputBox;

    @FindBy(xpath = "//h6[text()='Employee Termination / Activiation ']/following-sibling::button")
    public WebElement terminateEmploymentButton;

    @FindBy(xpath = "//label[text()='Termination Date']/parent::div/following-sibling::div//input")
    public WebElement terminateDateInputBox;

    @FindBy(xpath = "//label[text()='Note']/parent::div/following-sibling::div/textarea")
    public WebElement noteInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//label[@class='oxd-label'")
    public WebElement allInputTextHeaders;

    @FindBy(xpath = "//div[@role='listbox']/div[text()='No Records Found']")
    public WebElement noRecordsFoundTextInDropdown;
}
