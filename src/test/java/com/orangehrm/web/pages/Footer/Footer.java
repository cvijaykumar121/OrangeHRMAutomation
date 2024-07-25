package com.orangehrm.web.pages.Footer;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer extends TestBase {
    public WebDriver driver;
    public FooterLocators footerLocators;

    public Footer(WebDriver driver) {
        this.driver = driver;
        this.footerLocators = new FooterLocators(driver);
    }

    public void validateFooterContainer() {
        WebElement footerContainer = footerLocators.footerContainer;
        waitForElementToBeVisible(footerContainer, 20, "Footer container is visible");
    }

    public void validate_Footer_OrangeHRM_Version() {
        WebElement orangeHRMVersion = footerLocators.footerOrangeHRMVersion;
        waitForElementToBeVisible(orangeHRMVersion, 20, "OrangeHRM version is visible");
        validateText(orangeHRMVersion, "OrangeHRM OS 5.6.1", "Successfully Validated orangehrm version", 20);
    }

    public void validate_Footer_Copyright() {
        WebElement orangeHRMCopyright = footerLocators.footerOrangeHRMCopyright;
        waitForElementToBeVisible(orangeHRMCopyright, 20, "OrangeHRM version is visible");
        validateText(orangeHRMCopyright, "OrangeHRM OS 5.6.1", "Successfully Validated orangehrm version", 20);
    }
}
