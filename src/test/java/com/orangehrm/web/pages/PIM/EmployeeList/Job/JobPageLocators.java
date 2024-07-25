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

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Joined Date']")
    public WebElement joinedDateDropdownText;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Job Title']")
    public WebElement jobTitleDropdownText;

    @FindBy(xpath = "//label[text()='Job Title']/parent::div/following-sibling::div//child::*[@class='oxd-select-text-input']")
    public WebElement jobTitleDropdown;

    @FindBy(xpath = "//div[@role='listbox']/div/span")
    public List<WebElement> allJobTitles;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Job Specification']")
    public WebElement jobSpecificationDropdownText;

    @FindBy(xpath = "//label[text()='Job Category']/parent::div/following-sibling::div//child::*[@class='oxd-select-text-input']")
    public WebElement jobCategoryDropdown;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Job Category']")
    public WebElement jobCategoryDropdownText;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Sub Unit']")
    public WebElement subUnitDropdownText;

    @FindBy(xpath = "//label[text()='Sub Unit']/parent::div/following-sibling::div//child::*[@class='oxd-select-text-input']")
    public WebElement subunitDropdown;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Location']")
    public WebElement locationDropdownText;

    @FindBy(xpath = "//label[text()='Location']/parent::div/following-sibling::div//child::*[@class='oxd-select-text-input']")
    public WebElement locationDropdown;

    @FindBy(xpath = "//label[text()='Employment Status']/parent::div/following-sibling::div//child::*[@class='oxd-select-text-input']")
    public WebElement employmentStatusDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//label[@class='oxd-label'")
    public WebElement allInputTextHeaders;

//    @FindBy(xpath = "")

}
