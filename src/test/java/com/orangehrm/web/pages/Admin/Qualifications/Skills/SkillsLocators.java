package com.orangehrm.web.pages.Admin.Qualifications.Skills;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillsLocators {
    public SkillsLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/h6[text()='Skills']")
    public WebElement skillsTitle;

    @FindBy(xpath = "//h6[text()='Skills']/following-sibling::div/button")
    public WebElement skillsAddButton;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement skillsNameInputBox;

    @FindBy(xpath = "//label[text()='Description']/parent::div/following-sibling::div/textarea")
    public WebElement descriptionTextBox;
}
