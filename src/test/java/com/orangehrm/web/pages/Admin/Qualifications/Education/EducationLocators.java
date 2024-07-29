package com.orangehrm.web.pages.Admin.Qualifications.Education;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EducationLocators {
    public EducationLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/h6[text()='Education']")
    public WebElement educationTitle;

    @FindBy(xpath = "//h6[text()='Education']/following-sibling::div/button")
    public WebElement educationAddButton;

    @FindBy(xpath = "//label[text()='Level']/parent::div/following-sibling::div/input")
    public WebElement levelInputBox;

    @FindBy(xpath = "//button[@type='submit' and text()=' Save ']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@type='button' and text()=' Cancel ']")
    public WebElement cancelButton;
}
