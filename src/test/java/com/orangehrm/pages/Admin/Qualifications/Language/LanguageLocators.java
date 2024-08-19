package com.orangehrm.pages.Admin.Qualifications.Language;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LanguageLocators {
    public LanguageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/h6[text()='Languages']")
    public WebElement languagesTitle;

    @FindBy(xpath = "//h6[text()='Languages']/following-sibling::div/button")
    public WebElement languagesAddButton;

    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6[text()='Add Language']")
    public WebElement addLanguageTitle;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement languageNameInputBox;

    @FindBy(xpath = "//button[@type='submit' and text()=' Save ']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@type='button' and text()=' Cancel ']")
    public WebElement cancelButton;

}
