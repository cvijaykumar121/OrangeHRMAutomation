package com.orangehrm.web.pages.Admin.Job.JobCategories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobCategoriesLocators {
    public JobCategoriesLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/h6[text()='Job Categories']")
    public WebElement jobCategoriesTitle;

    @FindBy(xpath = "//h6[text()='Job Categories']/following-sibling::div/button")
    public WebElement jobCategoriesAddButton;

    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6[text()='Add Job Category']")
    public WebElement addJobCategoryTitle;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement addJobCategory_NameInputBox;

    @FindBy(xpath = "//button[@type='button' and text()=' Cancel ']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[@type='submit' and text()=' Save ']")
    public WebElement saveButton;

}
