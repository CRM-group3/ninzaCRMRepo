package com.group3.CRMbasics;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.group3.CRMlogs.Logs;
import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMlistners.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	protected static final Logger log = Logger.getLogger(BaseTest.class);//added
    protected WebDriver driver; //changes to protected from static
   //protected Logger myBaseTestLog = LogManager.getLogger();
    
    public BasePage basepage;
    public ExtentReports reportlog = ExtentManager.getInstance();
    PropertiesFile prop = new PropertiesFile();
    protected static ExtentReports extent;// 
    protected ExtentTest test;//added by me tms
    

    @BeforeSuite
    public void setupReport() {
        ExtentManager.getInstance(); // creates the report
    }

    @AfterSuite
    public void flushReport() {
        ExtentManager.getInstance().flush(); // writes it to index.html
    }

   	public WebDriver getDriver() {
		if(driver == null) {
			WebDriverManager.chromedriver().setup();
//			// 🔐 Disable password manager and breach popups

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
    
//here i changed from beforemethod to beforeclass Each test method is 
//running independently and creating its own WebDriver instance. 
//   If you want one browser for the whole class, then change beforemthod to beforeclass
   
    @Parameters({ "browser" })
    @BeforeClass
    public void setUpBeforeClass(@Optional("chrome") String browserName) throws Exception {
    	
    	ExtentManager.testlog = ExtentManager.getInstance().createTest("Test: " + browserName);
    	
    	test = ExtentManager.testlog;
    	
    	
    	
    	Logs.info(".........BeforeClass executed---------------");
        initializeBrowser(browserName);
       
        String url = prop.getProperty("application.properties","url");
        System.out.println("Appln url:" +url);
        //String url = prop.getProperty("url"); //tms changed
        baseURL(url);
       // basepage.waitUntilPageLoads(20);
        driver.manage().window().maximize();
        
        try {
			initialSetup();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

 

	@AfterClass
    public void tearDownAfterTestClass() {
    	try {
        driverClose();
        Logs.info("******tearDownAfterTestMethod executed***********");
    }
    catch (Exception e) {
        Logs.error("Error in tearDown: " + e.getMessage());
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
        	try { //added
            driver.quit();//added
            Logs.info("Browser is closed");
            ExtentManager.logTestInfo("Browser is closed");
        	}
        	catch (Exception e) { 
                Logs.error("Error while closing browser: " + e.getMessage());
            } finally {
            driver = null;
            //Assert.assertNull(driver); //removed
            }
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
        String username = prop.getProperty("application.properties","username"); //changed
        String passwrd = prop.getProperty("application.properties","password"); //changed
        
        WebElement emailField = driver.findElement(By.id("username"));
        //basepage.waitForVisibilty(emailField, Duration.ofSeconds(30), "Email field");
        basepage.elementSendText(emailField, username, "Username");
       // WebElement password = driver.findElement(By.xpath("//*[@id='inputPassword']"));
        WebElement password = driver.findElement(By.id("inputPassword"));
        basepage.elementSendText(password, passwrd, "Password");
        WebElement SignInButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
        //basepage.waitForVisibilty(SignInButton, Duration.ofSeconds(30), "Sign In button");
        basepage.buttonCheck(SignInButton, "Sign In");
        Logs.info("Successfully logged to the Home page");
        ExtentManager.logTestInfo("Successfully logged in to Home page");
        
    }
}

