package com.orangehrm.pages.Footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterLocators {
    public FooterLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='oxd-layout-footer']")
    public WebElement footerContainer;

    @FindBy(xpath = "(//p[@class='oxd-text oxd-text--p orangehrm-copyright'])[1]")
    public WebElement footerOrangeHRMVersion;

    @FindBy(xpath = "(//p[@class='oxd-text oxd-text--p orangehrm-copyright'])[2]")
    public WebElement footerOrangeHRMCopyright;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-copyright']/a")
    public WebElement footerOrangeHRMLink;
}
