package com.orangehrm.web.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locators {
    public Locators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@type='submit' and text()=' Save ']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@type='button' and text()=' Cancel ']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    public WebElement yesDeleteJobTitleButton;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin']")
    public WebElement noCancelJobTitleButton;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--card-title']")
    public WebElement deleteJobTitlePopUpHeader;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--card-body']")
    public WebElement deleteJobTitlePopUpBody;

}
