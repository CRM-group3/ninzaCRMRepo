package com.group3.CRMbasics;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.group3.CRMlogs.Logs;
import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMlistners.ExtentManager;
import com.group3.CRMlistners.ExtentTestManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
    public static BasePage basepage;
    public PropertiesFile prop = new PropertiesFile();
   

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
    @BeforeMethod
    public void setUpBeforeMethod(@Optional("chrome") String browser, Method method) throws Throwable {
        Logs.info(".........BeforeMethod executed---------------");
        System.out.println("Method is :" + method);
        System.out.println("Method Name  is :" + method.getName());
        // Start Extent test
        ExtentManager.startExtentCreateReport("NinzaCRMReport");
        ExtentTestManager.startTest(method.getName());
        ExtentManager.logTestInfo("Starting test: " + method.getName());

        initializeBrowser(browser);

        String url = prop.getProperty("application.properties", "url");
        System.out.println("App URL: " + url);
        baseURL(url);
        basepage.waitUntilPageLoads(20);
        driver.manage().window().maximize();
        initialSetup();
    }

    @AfterMethod
    public void tearDownAfterTestMethod() {
        try {
            driverClose();
            Logs.info("******tearDownAfterTestMethod executed***********");
        } catch (Exception e) {
            Logs.error("Error in tearDown: " + e.getMessage());
            ExtentManager.logTestfailwithException(e);
        } finally {
            ExtentTestManager.endTest(); // flushes the report
        }
    }
    
    public void initializeBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            chromePrefs.put("profile.password_manager_leak_detection", false);
            options.setExperimentalOption("prefs", chromePrefs);
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else {
            Logs.error("Unsupported browser: " + browser);
            throw new RuntimeException("Unsupported browser: " + browser);
        }
        basepage = new BasePage(driver);
        Logs.info(browser + " browser launched.");
        ExtentManager.logTestInfo(browser + " browser launched.");
    }

    public void baseURL(String url) throws Exception {
        try {
            driver.get(url);
            Logs.info(url + " is entered");
            ExtentManager.logTestInfo("Navigated to URL: " + url);
        } catch (Exception e) {
            Logs.error("Error while navigating to URL: " + e.getMessage());
            ExtentManager.logTestfailwithException(e);
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
        //options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Logs.info("Headless execution started");
        ExtentManager.logTestInfo("Successfully logged in a headless mode to Home page");
    }

    public void initialSetup() throws Throwable {
        driver.manage().window().maximize();
        basepage = new BasePage(driver);

        String username = prop.getProperty("application.properties", "username");
        String passwrd = prop.getProperty("application.properties", "password");

        WebElement emailField = driver.findElement(By.id("username"));
        basepage.waitForVisibilty(emailField, Duration.ofSeconds(30), "Email field");
        basepage.elementSendText(emailField, username, "Username");

        WebElement password = driver.findElement(By.id("inputPassword"));
        basepage.elementSendText(password, passwrd, "Password");

        WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
        basepage.waitForVisibilty(signInButton, Duration.ofSeconds(30), "Sign In button");
        basepage.buttonCheck(signInButton, "Sign In");

        Logs.info("Successfully logged in to Home page");
        ExtentManager.logTestInfo("Successfully logged in to Home page");
    }

}
