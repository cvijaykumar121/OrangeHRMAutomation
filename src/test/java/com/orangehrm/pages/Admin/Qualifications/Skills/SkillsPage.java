package com.orangehrm.pages.Admin.Qualifications.Skills;

import com.orangehrm.base.TestBase;
import org.openqa.selenium.WebDriver;

public class SkillsPage extends TestBase {
    public WebDriver driver;
    public SkillsLocators skillsLocators;

    public SkillsPage(WebDriver driver) {
        this.driver = driver;
        this.skillsLocators = new SkillsLocators(driver);
    }

    public void validate_Skills_Header() {
        validateText(skillsLocators.skillsTitle, "Skills", "Validated Skills title", 30);
    }

    public void click_On_Skills_Add_Button() {
        clickElement(skillsLocators.skillsAddButton, "Clicked on Skills Add Button", true, 30);
    }

    public void enter_Skill_Name(String skillName) {
        sendKeys(skillsLocators.skillsNameInputBox, skillName, "Entered Skill Name: " + skillName, 30);
    }

    public void enter_Skill_Description(String skillDescription) {
        sendKeys(skillsLocators.descriptionTextBox, skillDescription, "Entered Skill Description: " + skillDescription, 30);
    }

    public void click_On_Save_Button() {
        clickElement(skillsLocators.saveButton, "Clicked on Save Button", true, 30);
    }

    public void click_On_Cancel_Button() {
        clickElement(skillsLocators.cancelButton, "Clicked on Cancel Button", true, 30);
    }
}
