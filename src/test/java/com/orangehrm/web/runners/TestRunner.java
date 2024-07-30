package com.orangehrm.web.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/featureFiles/Admin/Job/JobCategories/AddJobCategory.feature",
        glue = "com.orangehrm.web.StepDefinitions"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
