package com.orangehrm.listeners;

import com.orangehrm.base.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CustomListeners extends TestBase implements ITestListener {

    @Override
    public void onFinish(ITestContext context) {
        String reportPath = System.getProperty("user.dir") + "\\src\\test\\resources\\extent_report\\extent-report.html";
        //Automatically open the report as the test case ends
        try {
            File reportFile = new File(reportPath);
            Desktop.getDesktop().browse(reportFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
