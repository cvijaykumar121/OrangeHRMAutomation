package com.orangehrm.web.rough;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AttachScreenshots {
    public ExtentReports extent;
    /*
    1. Take a screenshot as png, jpg file --> Attach to report
    2. Take a screenshot as png, jpg file --> convert it in form of base64 --> Attach to report
    3. Take a screenshot as base64 --> Attach to report (Most recommended way)
     */

    @BeforeSuite
    public void setUp() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshotReport.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Report Name");
        spark.config().setDocumentTitle("Document Title");

        extent.attachReporter(spark);
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();

    }
}
