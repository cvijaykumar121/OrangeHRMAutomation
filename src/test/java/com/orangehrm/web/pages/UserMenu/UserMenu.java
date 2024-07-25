package com.orangehrm.web.pages.UserMenu;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserMenu extends TestBase {
    public WebDriver driver;
    public UserMenuLocators userMenuLocators;

    public UserMenu(WebDriver driver) {
        this.driver = driver;
        this.userMenuLocators = new UserMenuLocators(driver);
    }

    public void validateUserMenuIsPresent() {
        WebElement userMenu = userMenuLocators.userMenu;
        waitForElementToBeClickable(userMenu, 20, "User Menu is validated successfully");
    }

    public void validateProfilePictureIsPresent() {
        WebElement profilePic = userMenuLocators.profilePicture;
        waitForElementToBeVisible(profilePic, 20, "Profile pic is validated successfully");
    }

    public void validateUserDropdownIsPresent() {
        WebElement userDropdown = userMenuLocators.userDropdown;
        waitForElementToBeClickable(userDropdown, 20, "User dropdown is validated successfully");
    }

    public void clickOnUserDropdown() {
        WebElement userDropdown = userMenuLocators.userDropdown;
        clickElement(userDropdown, "User dropdown is clicked successfully", true, 10);
    }

//    public void validateDropdownMenus() {
//        List<WebElement> userDropdownItems = userMenuLocators.userDropdownMenuItems;
//        System.out.println("Size of user dropdown menu: " + userDropdownItems.size());
//        for(int i=0; i<userDropdownItems.size(); i++) {
//            WebElement menu = userDropdownItems.get(i);
//            switch (i) {
//                case 0 -> validateText(menu, "About", "About link validated successfully", 5);
//                case 1 -> validateText(menu, "Support", "Support link validated successfully", 5);
//                case 2 -> validateText(menu, "Change Password", "Change Password link validated successfully", 5);
//                case 3 -> validateText(menu, "Logout", "Logout link validated successfully", 5);
//                default -> System.out.println("Failed");
//            }
//        }
//    }

    public void clickOnLogoutMenuOption() {
        WebElement logoutLink = userMenuLocators.logoutLink;
        waitForElementToBeClickable(logoutLink, 5, "Logout option is displayed successfully");
        clickElement(logoutLink, "Logout option is clicked successfully", true, 5);
    }
}
