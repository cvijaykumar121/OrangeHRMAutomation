package com.orangehrm.web.utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.orangehrm.web.base.TestBase;

public class ExtentManager {
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }

    public static synchronized void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static synchronized void log(Status status, String message) {
        ExtentTest test = getTest();
        if (test != null) {
            test.log(status, message);
        } else {
            throw new NullPointerException("ExtentTest instance is null. Ensure that the test has been properly started.");
        }
    }

    public static synchronized void logPass(String message) {
        ExtentTest extentTest = getTest();
        if (extentTest != null) {
            extentTest.pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(TestBase.captureScreenshot()).build());
        } else {
            throw new NullPointerException("ExtentTest instance is null. Ensure that the test has been properly started.");
        }
    }

    public static synchronized void logFail(String message) {
//        getTest().log(Status.FAIL, message);
        getTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(TestBase.captureScreenshot()).build());
    }

    public static synchronized void logInfo(String message) {
        getTest().info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(TestBase.captureScreenshot()).build());
    }

    public static synchronized void logSkip(String message) {
//        getTest().log(Status.SKIP, message);
        getTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(TestBase.captureScreenshot()).build());
    }
}
