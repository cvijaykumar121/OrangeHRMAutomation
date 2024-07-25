package com.orangehrm.web.rough;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExtentReportsDemo {
    @Test
    public void extentTest() throws IOException {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\src\\test\\resources\\allReport.html");

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Report Name");
        sparkReporter.config().setDocumentTitle("Document Title");

        ExtentSparkReporter failedReport = new ExtentSparkReporter(System.getProperty("user.dir") + "\\src\\test\\resources\\failed.html");
        failedReport.filter().statusFilter().as(new Status[]{Status.FAIL});
        failedReport.config().setTheme(Theme.DARK);
        failedReport.config().setReportName("Failed Cases");
        failedReport.config().setDocumentTitle("Failed test cases");
        extent.attachReporter(sparkReporter, failedReport);

        ExtentTest loginTest = extent.createTest("Login Test");     //Create a test node in the report
        loginTest.assignAuthor("Vijay");
        loginTest.assignCategory("Smoke");
        loginTest.assignDevice("Chrome");
        loginTest.pass("Login Test started successfully");         //Create a test step node in the report
        loginTest.pass("URL is loaded");
        loginTest.pass("Values entered");
        loginTest.pass("Button clicked");
        loginTest.pass("Login Test completed successfully");

        ExtentTest homePageTest = extent.createTest("Home Page Test");     //Create a test node in the report
        homePageTest.assignAuthor("Ajay");
        homePageTest.assignCategory("Regression");
        homePageTest.assignDevice("Firefox");
        homePageTest.pass("Home Page Test started successfully");         //Create a test step node in the report
        homePageTest.pass("URL is loaded");
        homePageTest.pass("Values entered");
        homePageTest.pass("Button clicked");
        homePageTest.fail("Home Page Test completed");

        extent.flush();                 //Unless you call this method, your report will bot be written with logs
    }
}
