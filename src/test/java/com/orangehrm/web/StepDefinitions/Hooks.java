package com.orangehrm.web.StepDefinitions;

import com.orangehrm.web.pages.Login.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.orangehrm.web.runners.TestRunner.browser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.time.Duration;
import java.util.Properties;

public class Hooks {
//    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static JavascriptExecutor js;
    public LoginPage loginPage;
    public String validUsername_Admin;
    public String validPassword_Admin;
    public String hubURL = "http://172.20.224.1:4444";
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public Capabilities capabilities;

    public WebDriver getDriver() {
        return driver.get();
    }

    @Before
    public void setUp() throws MalformedURLException {
        String currentDirectory = System.getProperty("user.dir");
        String configPropertyFilePath = currentDirectory + "\\src\\test\\resources\\properties\\Config.properties";
        String ORPropertyFilePath = currentDirectory + "\\src\\test\\resources\\properties\\OR.properties";
        String chromeDriverPath = currentDirectory + "\\src\\test\\resources\\executables\\chromedriver.exe";
        String edgeDriverPath = currentDirectory + "\\src\\test\\resources\\executables\\msedgedriver.exe";

        try {
            fis = new FileInputStream(configPropertyFilePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fis = new FileInputStream(ORPropertyFilePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            OR.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (browser.equalsIgnoreCase("chrome")) {
            capabilities = new ChromeOptions();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
//            try {
//                driver = new RemoteWebDriver(new URL(hubURL), options);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
////            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//
////            driver = new ChromeDriver(options);
////            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            capabilities = new EdgeOptions();
//            EdgeOptions options = new EdgeOptions();
//            options.addArguments("headless");
//            try {
//                driver = new RemoteWebDriver(new URL(hubURL), options);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            System.setProperty("webdriver.edge.driver", edgeDriverPath);
//            driver = new EdgeDriver();
        } else if(browser.equalsIgnoreCase("firefox")) {
            capabilities = new FirefoxOptions();
//            FirefoxOptions options = new FirefoxOptions();
//            options.addArguments("headless");
//            try {
//                driver = new RemoteWebDriver(new URL(hubURL), options);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
////            driver = new FirefoxDriver();
        }
        js = (JavascriptExecutor) getDriver();

        driver.set(new RemoteWebDriver(new URL(hubURL), capabilities));
        getDriver().get(config.getProperty("application_url"));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(getDriver());

        validUsername_Admin = config.getProperty("validUsername_Admin");
        validPassword_Admin = config.getProperty("validPassword_Admin");

        System.out.println("Browser Launched");

    }

    @After
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit(); // Quits the WebDriver session, closing all browser windows
//            getDriver() = null; // Sets driver to null to avoid using a terminated instance
        }
        System.out.println("Browser is quit");
    }
}
