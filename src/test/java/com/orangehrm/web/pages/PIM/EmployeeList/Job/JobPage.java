package com.orangehrm.web.pages.PIM.EmployeeList.Job;

import com.orangehrm.web.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobPage extends TestBase {
    public WebDriver driver;
    public JobPageLocators jobPageLocators;

    public JobPage(WebDriver driver) {
        this.driver = driver;
        this.jobPageLocators = new JobPageLocators(driver);
    }

    public void navigate_To_Job_Page() {
        clickElement(jobPageLocators.jobSideMenu, "Successfully clicked on Job menu", true, 20);
    }

    private WebElement validate_Job_Title_Dropdown_Is_Present() {
        WebElement jobTitleDropdown = jobPageLocators.jobTitleDropdown;
        waitForElementToBeClickable(jobTitleDropdown, 20, "Job Title Dropdown is clickable");
        return jobTitleDropdown;
    }

    private void click_On_JobTitle_Dropdown() {
        WebElement jobTitleDropdown = validate_Job_Title_Dropdown_Is_Present();
        clickElement(jobTitleDropdown, "Job Title Dropdown clicked successfully", true, 20);
    }

    public void select_Option_From_JobTitle_Dropdown(String option) {
        validate_Job_Title_Dropdown_Is_Present();
        click_On_JobTitle_Dropdown();
        WebElement optionFromDropdown = driver.findElement(By.xpath("//div[@role='listbox']/div/span[text()='" + option + "']"));
        waitForElementToBeClickable(optionFromDropdown, 20, option + " is visible in the job title dropdown");
        clickElement(optionFromDropdown, option + " from the job title dropdown is clicked", true, 20);
    }
}
