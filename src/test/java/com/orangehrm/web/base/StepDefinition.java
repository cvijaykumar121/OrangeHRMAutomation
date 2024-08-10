package com.orangehrm.web.base;
import com.orangehrm.web.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class StepDefinition extends TestBase {
    public WebDriver driver;
    public Locators locators;
    public static String employeeID;

    public StepDefinition(WebDriver driver) {
        this.driver = driver;
        this.locators = new Locators(driver);
    }

    public void clickOnSaveButton() {
        clickElement(locators.saveButton, "Clicked on save button", true, 20);
        waitForElementToBeVisible(locators.toastMessage, 40, "Toast message displayed");
    }

    public void clickOnCancelButton() {
        clickElement(locators.cancelButton, "Clicked on cancel button", true, 20);
    }

    public void handle_Delete_Pop_Up(boolean clickOnDelete) {
        validateText(locators.deleteJobTitlePopUpHeader, "Are you Sure?",
                "Delete Job Title pop up header validated successfully", 10);
        validateText(locators.deleteJobTitlePopUpBody,
                "The selected record will be permanently deleted. Are you sure you want to continue?",
                "Delete Job Title pop up message body validated successfully", 10);
        if (clickOnDelete) {
            click_On_Yes_Delete_Button();
        } else {
            click_No_Cancel_Button();
        }
    }

    private void click_On_Yes_Delete_Button() {
        WebElement yesDeleteButton = locators.yesDeleteJobTitleButton;
        waitForElementToBeVisible(yesDeleteButton, 10, "Yes Delete button is displayed successfully");
        clickElement(yesDeleteButton, "Yes, Delete button is clicked successfully", true, 10);
    }

    private void click_No_Cancel_Button() {
        WebElement noCancelButton = locators.noCancelJobTitleButton;
        waitForElementToBeVisible(noCancelButton, 10, "No Cancel button is displayed successfully");
        clickElement(noCancelButton, "No Cancel button is clicked successfully", true, 10);
    }

    public static void setEmployeeID(String employeeId) {
        employeeID = employeeId;
    }

    public void uploadFile() {
        WebElement browseButton = Hooks.driver.findElement(By.xpath("//div[@class='oxd-file-button']"));
        clickElement(browseButton, "Browse button clicked", true, 10);
        try {
            Robot robot = new Robot();
            robot.delay(3000);

            StringSelection selection = new StringSelection("D:\\Project\\File Upload.pdf");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_V);
            robot.delay(1000);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(1000);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(1000);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(1000);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);

        } catch (AWTException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
