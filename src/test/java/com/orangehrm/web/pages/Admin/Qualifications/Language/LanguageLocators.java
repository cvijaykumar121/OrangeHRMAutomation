package com.orangehrm.web.pages.Admin.Qualifications.Language;

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

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement languageNameInputBox;
}
