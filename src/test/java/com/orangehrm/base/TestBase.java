package com.orangehrm.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.orangehrm.utilities.ExtentManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static JavascriptExecutor js;
    public static ExtentReports extentReport;
    public static ExtentTest extentTest;
    public static Logger logger;

    @BeforeSuite
    public void setUp() throws IOException, InterruptedException {
        String reportPath = System.getProperty("user.dir") + "\\src\\test\\resources\\extent_report\\extent-report.html";

        if (driver == null) {
            fis = new FileInputStream(
                    System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
            config.load(fis);

            fis = new FileInputStream(
                    System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
            OR.load(fis);

            if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (config.getProperty("browser").equalsIgnoreCase("Internet Explorer")) {
                System.setProperty("webdriver.ie.driver",
                        System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }
            extentReport = ExtentManager.createInstance(reportPath, getClass().getSimpleName());
            extentTest = ExtentManager.createTest(getClass().getSimpleName());
            logger = LoggerFactory.getLogger(getClass().getSimpleName());
            js = (JavascriptExecutor) driver;
            driver.get(config.getProperty("application_url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }
    public void logInfo(String statement, boolean takeScreenshot) {
        if(takeScreenshot) {
            extentTest.log(Status.INFO, statement, MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenshot()).build());
            logger.info(statement);
        } else {
            extentTest.info(statement);
            logger.info(statement);
        }
    }

    public void logPass(String statement, boolean takeScreenshot) {
        if(takeScreenshot) {
            extentTest.pass(statement).addScreenCaptureFromBase64String(captureScreenshot());
            logger.info(statement);
        } else {
            extentTest.fail(statement);
            logger.info(statement);
        }
    }

    public void logFail(String statement, boolean takeScreenshot) {
        if(takeScreenshot) {
            extentTest.fail(statement).addScreenCaptureFromBase64String(captureScreenshot());
            logger.info(statement);
        } else {
            extentTest.fail(statement);
            logger.info(statement);
        }
    }

    public void waitForElementToBeVisible(By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement findElement(By locator) {
        try {
            waitForElementToBeVisible(locator, Duration.ofSeconds(10));
            return driver.findElement(locator);
        } catch (Exception e) {
            logFail("Element not found", true);
            return null;
        }
    }

    public void clickElement(By locator, String message) throws InterruptedException {
        try {
            waitForElementToBeClickable(locator, Duration.ofSeconds(10));
            WebElement element = findElement(locator);
            js.executeScript("arguments[0]. setAttribute('style', 'border:2px solid red;')", element);
            Thread.sleep(1000);
            element.click();
            logInfo(message, true);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendKeys(By locator, String data, String message) throws InterruptedException {
        try {
            WebElement element = findElement(locator);
            js.executeScript("arguments[0]. setAttribute('style', 'border:2px solid red;')", element);
            Thread.sleep(1000);
            element.sendKeys(data);
            logInfo(message, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTextFromElement(By locator) {
        try {
            waitForElementToBeVisible(locator, Duration.ofSeconds(10));
            WebElement element = findElement(locator);
            if (element.isDisplayed()) {
                return element.getText();
            }
        } catch (Exception e) {
            logFail("Element is not visible.", true);
            e.printStackTrace();
        }
        return null;
    }

    public void selectOptionFromDropdown(By locator, String option, String message) {

        try {
            waitForElementToBeVisible(locator, Duration.ofSeconds(10));
            WebElement element = findElement(locator);
            if (element.isDisplayed()) {
                Select dropdown = new Select(driver.findElement(locator));
                dropdown.selectByVisibleText(option);
                logInfo(message, true);
            }
        } catch (Exception e) {
            logFail("Element is not visible.", true);
            e.printStackTrace();
        }
    }

    public void switchToFrame(By frameLocator, String message) {
        try {
            WebElement frame = driver.findElement(frameLocator);
            driver.switchTo().frame(frame);
            logPass(message, false);
        }catch(Exception e) {
            e.printStackTrace();
            logFail("Cannot switch to the frame.", false);
        }
    }

    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        }catch(Exception e) {
            e.printStackTrace();
            logFail("Cannot switch to the default content", false);
        }
    }

    public void validateText(By locator, String expectedText, String message) {
        try {
            waitForElementToBeVisible(locator, Duration.ofSeconds(10));
            WebElement element = findElement(locator);
            String actualText = element.getText().trim();

            if (actualText.equals(expectedText)) {
                logPass(message, true);
            } else {
                // Handle the case where the actual text does not match the expected text
                System.err.println("Text mismatch. Expected: " + expectedText + ", Actual: " + actualText);
            }
        } catch (Exception e) {
            // Handle the exception (e.g., log an error, take a screenshot, or throw a custom exception)
            System.err.println("Error validating text with locator: " + locator + " and expected text: " + expectedText);
            e.printStackTrace();
        }
    }


    private String captureScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BASE64);
    }

    private String captureScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots" + System.currentTimeMillis() + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    @AfterMethod
    public void tearDown() {
        // Flush the Extent Report to generate the report
        extentReport.flush();
    }
}
