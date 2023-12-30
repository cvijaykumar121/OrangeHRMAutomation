package com.orangehrm.cucumber_runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        glue = "com.orangehrm.StepDefinition",
        plugin = {"pretty", "html:src/test/resources/cucumber-reports/report.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RunCuke extends AbstractTestNGCucumberTests {
}
