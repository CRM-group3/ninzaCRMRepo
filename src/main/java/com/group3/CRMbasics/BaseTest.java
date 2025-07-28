package com.group3.CRMbasics;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.google.common.io.Files;

import com.group3.CRMlogs.Logs;
import constants.*;
import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMlistners.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    static WebDriver driver;
    public ExtentReports reportlog = ExtentManager.getInstance();

    public WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            Map<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            chromePrefs.put("profile.password_manager_leak_detection", false);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public void close() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    @Parameters({ "browser" })
    @BeforeClass
    public void setUpBeforeMethod(@Optional("chrome") String browserName) throws Exception {
        Logs.info(".........BeforeClass executed---------------");
        initializeBrowser(browserName);
        String url = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "url");
        baseURL(url);
        waitUntilPageLoads(20);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownAfterTestMethod() {
        driverClose();
        Logs.info("******tearDownAfterTestMethod executed***********");
    }

    public void initializeBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            Logs.info("Chrome browser instance has started");
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            Logs.info("Firefox browser instance has started");
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            Logs.info("Safari browser instance has started");
        } else {
            Logs.error("Browser is not available: " + browser);
        }
    }

    public void baseURL(String url) throws Exception {
        try {
            driver.get(url);
            Logs.info(url + " is entered");
            ExtentManager.logTestInfo("Valid URL is launched");
        } catch (Exception e) {
            Logs.error("Error occurred while navigating to URL: " + e.getMessage());
            throw e;
        }
    }

    public void driverClose() {
        if (driver != null) {
            driver.close();
            Logs.info("Browser is closed");
            ExtentManager.logTestInfo("Browser is closed");
            driver = null;
            Assert.assertNull(driver);
        }
    }

    public void headlessBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Logs.info("Headless execution started");
        ExtentManager.logTestInfo("Successfully logged in a headless mode to Home page");
    }

    public void initialSetup() {
        driver.manage().window().maximize();
        String username = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "username");
        String passwrd = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "password");

        WebElement emailField = driver.findElement(By.xpath("//*[@id='username']"));
        waitForVisibility(emailField, 30, "Email field");
        elementSendText(emailField, username, "Username");

        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        elementSendText(password, passwrd, "Password");

        WebElement loginButton = driver.findElement(By.id("Login"));
        waitForVisibility(loginButton, 40, "Login button");
        buttonCheck(loginButton, "Login");

        Logs.info("Successfully logged to the Home page");
        ExtentManager.logTestInfo("Successfully logged in to Home page");
    }

    public void waitUntilPageLoads(int timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
    }

    public void waitForVisibility(WebElement element, int timeout, String elementName) {
        // Placeholder for WebDriverWait/ExpectedConditions
        Logs.info("Waited for visibility: " + elementName);
    }

    public void elementSendText(WebElement element, String text, String fieldName) {
        element.clear();
        element.sendKeys(text);
        Logs.info(text + " entered into " + fieldName);
    }

    public void buttonCheck(WebElement element, String buttonName) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
            Logs.info(buttonName + " clicked");
        } else {
            Logs.error(buttonName + " is not clickable");
        }
    }

    public void takeScreenshot(String filepath) {
        TakesScreenshot takescreenshot = (TakesScreenshot) driver;
        File srcFile = takescreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filepath);
        try {
            Files.copy(srcFile, destFile);
            Logs.info("Captured the screenshot");
            ExtentManager.logTestInfo("Captured the screenshot");
        } catch (IOException e) {
            e.printStackTrace();
            Logs.error("Error while capturing the screenshot: " + e.getMessage());
        }
    }
}
