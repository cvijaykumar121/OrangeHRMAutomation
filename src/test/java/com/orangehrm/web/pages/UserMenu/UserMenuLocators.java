package com.orangehrm.web.pages.UserMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserMenuLocators {
    public UserMenuLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    public WebElement userMenu;

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']/img[@alt='profile picture']")
    public WebElement profilePicture;

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']/p[@class='oxd-userdropdown-name']")
    public WebElement nameOfUser;

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']/i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    public WebElement userDropdown;

    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']")
    public WebElement userDropdownMenu;

    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/*")
    public List<WebElement> userDropdownMenuItems;

    @FindBy(xpath = "//a[@class='oxd-userdropdown-link' and text()='Logout']")
    public WebElement logoutLink;
}
