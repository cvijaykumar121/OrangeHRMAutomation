package com.orangehrm.web.StepDefinitions.Admin.Job.JobCategories;

import com.orangehrm.web.StepDefinitions.Hooks;
import com.orangehrm.web.pages.Admin.AdminTopNavMenu.AdminTopNavMenu;
import com.orangehrm.web.pages.Admin.Job.JobCategories.JobCategoriesPage;
import com.orangehrm.web.pages.SideMenu.SideMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddJobCategoriesFeature {
    @Then("I navigate to Job Categories Page")
    public void i_navigate_to_job_categories_page() {
        AdminTopNavMenu adminTopNavMenu = new AdminTopNavMenu(Hooks.driver);
        JobCategoriesPage jobCategoriesPage = new JobCategoriesPage(Hooks.driver);
        SideMenu sideMenu = new SideMenu(Hooks.driver);

        sideMenu.clickOnAdminLink();
        adminTopNavMenu.navigate_To_JobCategories_Page();
        jobCategoriesPage.validate_Job_Categories_Title();
}

    @And("I add a valid Job Category and save it {string}")
    public void i_add_a_valid_job_category_and_save_it(String jobCategory) {
        JobCategoriesPage jobCategoriesPage = new JobCategoriesPage(Hooks.driver);
        jobCategoriesPage.validate_Job_Categories_Title();
        jobCategoriesPage.click_On_Job_Categories_Add_Button();
        jobCategoriesPage.validate_Add_Job_Category_Title();

        jobCategoriesPage.enter_Job_Category_Name(jobCategory);
        jobCategoriesPage.click_On_Save_Button();
    }

    @Then("I validate that after adding valid Job Category, user is redirected to Job Categories Page")
    public void validate_Job_Categories_Page() {
        JobCategoriesPage jobCategoriesPage = new JobCategoriesPage(Hooks.driver);
        jobCategoriesPage.validate_Job_Categories_Title();
    }
}
