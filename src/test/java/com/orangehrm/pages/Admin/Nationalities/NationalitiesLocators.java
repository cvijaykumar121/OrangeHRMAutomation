package com.orangehrm.pages.Admin.Nationalities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NationalitiesLocators {
    public NationalitiesLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/h6[text()='Nationalities']")
    public WebElement nationalitiesHeader;

    @FindBy(xpath = "//h6[text()='Nationalities']/following-sibling::div/button")
    public WebElement nationalitiesAddButton;

    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6[text()='Add Nationality']")
    public WebElement addNationalityHeader;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement nationalityNameInputBox;

    @FindBy(xpath = "//button[@type='submit' and text()=' Save ']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@type='button' and text()=' Cancel ']")
    public WebElement cancelButton;
}
