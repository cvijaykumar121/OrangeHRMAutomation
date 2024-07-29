package com.orangehrm.web.pages.Admin.Organization.Locations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocationsLocators {
    public LocationsLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='oxd-table-filter-header-title']/h5[text()='Locations']")
    public WebElement locationsTitle;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement locationsNameInputBox;

    @FindBy(xpath = "//label[text()='City']/parent::div/following-sibling::div/input")
    public WebElement cityInputBox;

    @FindBy(xpath = "//label[text()='Country']/parent::div/following-sibling::div//i")
    public WebElement locationsCountryDropdown;

    @FindBy(xpath = "//button[@type='submit' and text()=' Search ']")
    public WebElement searchButton;

    @FindBy(xpath = "//button[@type='button' and text()=' Add ']")
    public WebElement addButton;

    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6[text()='Add Location']")
    public WebElement addLocationTitle;

    @FindBy(xpath = "//label[text()='State/Province']/parent::div/following-sibling::div/input")
    public WebElement stateInputBox;

    @FindBy(xpath = "//label[text()='Zip/Postal Code']/parent::div/following-sibling::div/input")
    public WebElement zipInputBox;

    @FindBy(xpath = "//label[text()='Phone']/parent::div/following-sibling::div/input")
    public WebElement phoneInputBox;

    @FindBy(xpath = "//label[text()='Fax']/parent::div/following-sibling::div/input")
    public WebElement faxInputBox;

    @FindBy(xpath = "//label[text()='Address']/parent::div/following-sibling::div/textarea")
    public WebElement addressInputBox;

    @FindBy(xpath = "//label[text()='Notes']/parent::div/following-sibling::div/textarea")
    public WebElement notesInputBox;
}
