package com.orangehrm.web.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrm.web.utilities.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;

public class CustomListener implements ITestListener {
    private static ExtentReports extent;

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\src\\test\\resources\\reports\\extent-report.html");

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Report Name");
        sparkReporter.config().setDocumentTitle("Document Title");

        ExtentSparkReporter failedReport = new ExtentSparkReporter(System.getProperty("user.dir") + "\\src\\test\\resources\\reports\\failed-report.html");
        failedReport.filter().statusFilter().as(new Status[]{Status.FAIL});
        failedReport.config().setTheme(Theme.DARK);
        failedReport.config().setReportName("Failed Cases");
        failedReport.config().setDocumentTitle("Failed test cases");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter, failedReport);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        ExtentManager.setTest(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentManager.getTest().pass("Test case ---->" + methodName + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentManager.getTest().fail("Test case ---> " + methodName + "\nError---> " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentManager.getTest().skip("Test case ---> " + methodName + " got skipped" + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
