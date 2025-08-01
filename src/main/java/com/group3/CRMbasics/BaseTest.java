package com.group3.CRMbasics;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.group3.CRMlogs.Logs;
import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMlistners.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static WebDriver driver;
    public BasePage basepage;
    public ExtentReports reportlog = ExtentManager.getInstance();
    public static ExtentTest testlog = ExtentManager.startExtentCreateReport("NinzaCRMReport");
    PropertiesFile prop = new PropertiesFile();

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
    public void setUpBeforeMethod(@Optional("chrome") String browserName) throws Throwable {
        Logs.info(".........BeforeClass executed---------------");
        initializeBrowser(browserName);
        //String url = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "url");
        String url = prop.getProperty("application.properties","url");
        System.out.println("Appln url:" +url);
        baseURL(url);
        
        basepage.waitUntilPageLoads(20);
        driver.manage().window().maximize();
        initialSetup();
       
        
    }
    

    @AfterMethod
    public void tearDownAfterTestMethod() {
//        driverClose();
//        Logs.info("******tearDownAfterTestMethod executed***********");
    	
    	try {
            driver.quit();
            Logs.info("******tearDownAfterTestMethod executed***********");
        }
        catch (Exception e) {
            Logs.error("Error in tearDown: " + e.getMessage());
        }
    }
    
    @AfterSuite
    public void flushReport() {
        if (reportlog != null) {
            reportlog.flush();
            Logs.info("Extent Report flushed successfully.");
        }
    }

    public void initializeBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-notifications");
//            driver = new ChromeDriver(options);
        	WebDriverManager.chromedriver().setup();
            Map<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            chromePrefs.put("profile.password_manager_leak_detection", false);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            driver = new ChromeDriver(options);
            basepage = new BasePage(driver);
            Logs.info("Chrome browser instance has started");
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            basepage = new BasePage(driver);
            Logs.info("Firefox browser instance has started");
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            basepage = new BasePage(driver);
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
        //options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Logs.info("Headless execution started");
        ExtentManager.logTestInfo("Successfully logged in a headless mode to Home page");
    }

    public void initialSetup() throws Throwable {
        driver.manage().window().maximize();
        basepage = new BasePage(driver); 
        String username = prop.getProperty("application.properties","username");
        String passwrd = prop.getProperty("application.properties","password");
       // WebElement emailField = driver.findElement(By.xpath("//*[@id='username']"));
        WebElement emailField = driver.findElement(By.id("username"));
        //basepage.waitForVisibilty(emailField, Duration.ofSeconds(30), "Email field");
        basepage.elementSendText(emailField, username, "Username");
       // WebElement password = driver.findElement(By.xpath("//*[@id='inputPassword']"));
        WebElement password = driver.findElement(By.id("inputPassword"));
        basepage.elementSendText(password, passwrd, "Password");
        WebElement SignInButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
        basepage.waitForVisibilty(SignInButton, Duration.ofSeconds(30), "Sign In button");
        basepage.buttonCheck(SignInButton, "Sign In");
        Logs.info("Successfully logged to the Home page");
        ExtentManager.logTestInfo("Successfully logged in to Home page");
        
    }


}