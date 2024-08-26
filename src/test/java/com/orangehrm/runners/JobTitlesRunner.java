package com.orangehrm.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        plugin = {"html:target/cucumber-reports/cucumber-html-report.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources/featureFiles/Admin/Job/EmploymentStatus/AddEmploymentStatus.feature",
        glue = "com.orangehrm.StepDefinitions",
        tags = "@currentRun"
)
public class JobTitlesRunner extends AbstractTestNGCucumberTests {
    public static String browser;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser) {
        JobTitlesRunner.browser = browser;
    }
}
