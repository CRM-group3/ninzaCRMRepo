package com.group3.CRMbasics;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.time.Duration;
>>>>>>> 5a006f1636b7b4a0c5715c5bedfbf987f8d0b745
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
<<<<<<< HEAD
=======
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
>>>>>>> origin/main

=======
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.group3.CRMlogs.Logs;
import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMlistners.ExtentManager;
>>>>>>> 5a006f1636b7b4a0c5715c5bedfbf987f8d0b745
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

<<<<<<< HEAD
	public static WebDriver driver;
    public static BasePage basepage;
    public PropertiesFile prop = new PropertiesFile();
   
=======
    public static WebDriver driver;
    public BasePage basepage;
    public ExtentReports reportlog = ExtentManager.getInstance();
    public static ExtentTest testlog = ExtentManager.startExtentCreateReport("NinzaCRMReport");
    PropertiesFile prop = new PropertiesFile();
>>>>>>> 5a006f1636b7b4a0c5715c5bedfbf987f8d0b745

    public WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            Map<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            chromePrefs.put("profile.password_manager_leak_detection", false);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
<<<<<<< HEAD
<<<<<<< HEAD
			driver = new ChromeDriver(options);
		}
		return driver;
	}
	
	
	public void close() {
		driver.close();
		driver = null;
	}
<<<<<<< HEAD
//	--------------------------------------
	//protected static WebDriver driver = null;
	//protected ExtentUtility reportlog = ExtentUtility.getinstance();
=======
            driver = new ChromeDriver(options);
        }
        return driver;
    }
>>>>>>> 5a006f1636b7b4a0c5715c5bedfbf987f8d0b745

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
        WebElement loginButton = driver.findElement(By.id("Login"));
        basepage.waitForVisibilty(loginButton, Duration.ofSeconds(30), "Login button");
        basepage.buttonCheck(loginButton, "Login");
        WebElement SignInButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
        basepage.waitForVisibilty(SignInButton, Duration.ofSeconds(30), "Sign In button");
        basepage.buttonCheck(SignInButton, "Sign In");
        Logs.info("Successfully logged to the Home page");
        ExtentManager.logTestInfo("Successfully logged in to Home page");
        
    }


<<<<<<< HEAD
	// protected Alert alert;
	// protected WebDriver driver=null;
	@Parameters({ "browser" })

//	@BeforeMethod   [change if run SalesforceloginPage_Testcases)
@BeforeClass
	public void setUpBeforeMethod(@Optional("chrome") String name) throws Exception {
		/*
		 * //myBaseTestLog.info(".........BeforeMethod  executed---------------");
		 * initializeBrowser(name); //String url =
		 * PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "url");
		 * baseURL(url); waitUntilPageLoads(20); driver.manage().window().maximize();
		 */
	}

//AfterMethod
	public void tearDownAfterTestMethod() {
		//iverClose();
		//BaseTestLog.info("******tearDownAfterTestMethod executed***********");
	}

	public void initializeBrowser(String browser) {

		/*
		 * if (browser.equalsIgnoreCase("Chrome")) {
		 * 
		 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
		 * ChromeOptions(); options.addArguments("--disable-notifications");
		 * //yBaseTestLog.info("Browser instance has started"); //
		 * reportlog.logTestInfo("Browser instance has started"); // initializing the
		 * class level driver driver = new ChromeDriver(options);
		 * 
		 * } else if (browser.equalsIgnoreCase("firefox")) {
		 * 
		 * // System.setProperty("webdriver.chrome.driver", //
		 * "/Users/nitin/Downloads/Drivers/geckodriver");
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
		 * 
		 * 
		 * } else if (browser.equalsIgnoreCase("safari")) {
		 * 
		 * // System.setProperty("webdriver.chrome.driver", //
		 * "/Users/nitin/Downloads/Drivers/safaridriver");
		 * WebDriverManager.safaridriver().setup(); driver = new SafariDriver();
		 * //yBaseTestLog.info("Browser instance has started");
		 * 
		 * } else { myBaseTestLog.error("Browser is not available"+browser); }
		 * 
		 * // maximize the browser
		 */
	}

	/*public void initialSetup() {

		driver.manage().window().maximize();
		// titleCheck("Login | Salesforce");
		String username = propertyUtilityClass.readdatatofile(Constants.applicationPropertyPath, "username");
		String passwrd = propertyUtilityClass.readdatatofile(Constants.applicationPropertyPath, "password");
		WebElement email_field = driver.findElement(By.xpath("//*[@id='username']"));
		waitForVisibilty(email_field, 30, "email_field is");
		elementSendText(email_field, username, "Username");
		myBaseTestLog.info("Email is entered in a Field ");

		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		elementSendText(password, passwrd, "Password");
		myBaseTestLog.info("Password is entered in a Field ");

		WebElement loginButton = driver.findElement(By.id("Login"));
		waitForVisibilty(loginButton, 40, "Login ");
		buttonCheck(loginButton, "login  ");
		myBaseTestLog.info("Successfully logged to the Home page");
		reportlog.logTestwithPassed("Successfully logged in to Home page");

		// WebElement message_okbttn=
		// driver.findElement(By.xpath("//a[@class='continue']"));
		// if(message_okbttn.isDisplayed()) {
		// message_okbttn.click();}

	}*/

	public void headlessBrowser() {
	/*
	 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
	 * ChromeOptions(); options.addArguments("headless"); options.setHeadless(true);
	 * driver = new ChromeDriver(options); driver.manage().window().maximize();
	 * myBaseTestLog.info("Headless Excution started");
	 * 
	 * myBaseTestLog.info("Successfully logged in a headless mode to Home page");
	 * reportlog.
	 * logTestwithPassed("Successfully logged in a headless mode to Home page"); }
	 */
	}

	public void driverClose() {
		/*
		 * driver.close(); myBaseTestLog.info("browser is closed"); //
		 * reportlog.logTestInfo( "browser is closed"); driver = null;
		 * Assert.assertNull(driver);
		 */
	}

	public void takescreenshot(String filepath) {
		/*
		 * // Perform actions with the driver // System.out.println("WebDriver instance
		 * is null. Please initialize it // first."); // Other operations...
		 * 
		 * TakesScreenshot takescreenshot = (TakesScreenshot) driver; File srcFile =
		 * takescreenshot.getScreenshotAs(OutputType.FILE); File descFile = new
		 * File(filepath);
		 * 
		 * try { Files.copy(srcFile, descFile);
		 * myBaseTestLog.info("captures the screenshot");
		 * reportlog.logTestInfo("captures the screenshot"); } catch (IOException e) {
		 * // TODO Auto-generated catch block e.printStackTrace();
		 * myBaseTestLog.error("Error while capturing  the screenshot");
		 */

		}
>>>>>>> 5017ebe70f363b22d5c32dee598c9deaa0d44adb
=======
////	--------------------------------------
//	//protected static WebDriver driver = null;
//	//protected ExtentUtility reportlog = ExtentUtility.getinstance();
//
//	//protected Logger myBaseTestLog = LogManager.getLogger();
//
//	public void baseURL(String url) throws Exception {
//		/*
//		 * try { driver.get(url); myBaseTestLog.info(url + " is entered"); ///
//		 * reportlog.logTestInfo( "Valid URL is launched "); } catch (Exception e) {
//		 * myBaseTestLog.error("Error occurred while navigating to URL: " +
//		 * e.getMessage()); // myBaseTestLog.error(e); throw e; // Rethrow the exception
//		 * to propagate it further }
//		 */
//	}
//
//
//	// protected Alert alert;
//	// protected WebDriver driver=null;
//	@Parameters({ "browser" })
//
////	@BeforeMethod   [change if run SalesforceloginPage_Testcases)
//@BeforeClass
//	public void setUpBeforeMethod(@Optional("chrome") String name) throws Exception {
//		/*
//		 * //myBaseTestLog.info(".........BeforeMethod  executed---------------");
//		 * initializeBrowser(name); //String url =
//		 * PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "url");
//		 * baseURL(url); waitUntilPageLoads(20); driver.manage().window().maximize();
//		 */
//	}
//
////AfterMethod
//	public void tearDownAfterTestMethod() {
//		//iverClose();
//		//BaseTestLog.info("******tearDownAfterTestMethod executed***********");
//	}
//
//	public void initializeBrowser(String browser) {
//
//		/*
//		 * if (browser.equalsIgnoreCase("Chrome")) {
//		 * 
//		 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
//		 * ChromeOptions(); options.addArguments("--disable-notifications");
//		 * //yBaseTestLog.info("Browser instance has started"); //
//		 * reportlog.logTestInfo("Browser instance has started"); // initializing the
//		 * class level driver driver = new ChromeDriver(options);
//		 * 
//		 * } else if (browser.equalsIgnoreCase("firefox")) {
//		 * 
//		 * // System.setProperty("webdriver.chrome.driver", //
//		 * "/Users/nitin/Downloads/Drivers/geckodriver");
//		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
//		 * 
//		 * 
//		 * } else if (browser.equalsIgnoreCase("safari")) {
//		 * 
//		 * // System.setProperty("webdriver.chrome.driver", //
//		 * "/Users/nitin/Downloads/Drivers/safaridriver");
//		 * WebDriverManager.safaridriver().setup(); driver = new SafariDriver();
//		 * //yBaseTestLog.info("Browser instance has started");
//		 * 
//		 * } else { myBaseTestLog.error("Browser is not available"+browser); }
//		 * 
//		 * // maximize the browser
//		 */
//	}
//
//	/*public void initialSetup() {
//
//		driver.manage().window().maximize();
//		// titleCheck("Login | Salesforce");
//		String username = propertyUtilityClass.readdatatofile(Constants.applicationPropertyPath, "username");
//		String passwrd = propertyUtilityClass.readdatatofile(Constants.applicationPropertyPath, "password");
//		WebElement email_field = driver.findElement(By.xpath("//*[@id='username']"));
//		waitForVisibilty(email_field, 30, "email_field is");
//		elementSendText(email_field, username, "Username");
//		myBaseTestLog.info("Email is entered in a Field ");
//
//		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
//		elementSendText(password, passwrd, "Password");
//		myBaseTestLog.info("Password is entered in a Field ");
//
//		WebElement loginButton = driver.findElement(By.id("Login"));
//		waitForVisibilty(loginButton, 40, "Login ");
//		buttonCheck(loginButton, "login  ");
//		myBaseTestLog.info("Successfully logged to the Home page");
//		reportlog.logTestwithPassed("Successfully logged in to Home page");
//
//		// WebElement message_okbttn=
//		// driver.findElement(By.xpath("//a[@class='continue']"));
//		// if(message_okbttn.isDisplayed()) {
//		// message_okbttn.click();}
//
//	}*/
//
//	public void headlessBrowser() {
//	/*
//	 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
//	 * ChromeOptions(); options.addArguments("headless"); options.setHeadless(true);
//	 * driver = new ChromeDriver(options); driver.manage().window().maximize();
//	 * myBaseTestLog.info("Headless Excution started");
//	 * 
//	 * myBaseTestLog.info("Successfully logged in a headless mode to Home page");
//	 * reportlog.
//	 * logTestwithPassed("Successfully logged in a headless mode to Home page"); }
//	 */
//	}
//
//	public void driverClose() {
//		/*
//		 * driver.close(); myBaseTestLog.info("browser is closed"); //
//		 * reportlog.logTestInfo( "browser is closed"); driver = null;
//		 * Assert.assertNull(driver);
//		 */
//	}
//
//	public void takescreenshot(String filepath) {
//		/*
//		 * // Perform actions with the driver // System.out.println("WebDriver instance
//		 * is null. Please initialize it // first."); // Other operations...
//		 * 
//		 * TakesScreenshot takescreenshot = (TakesScreenshot) driver; File srcFile =
//		 * takescreenshot.getScreenshotAs(OutputType.FILE); File descFile = new
//		 * File(filepath);
//		 * 
//		 * try { Files.copy(srcFile, descFile);
//		 * myBaseTestLog.info("captures the screenshot");
//		 * reportlog.logTestInfo("captures the screenshot"); } catch (IOException e) {
//		 * // TODO Auto-generated catch block e.printStackTrace();
//		 * myBaseTestLog.error("Error while capturing  the screenshot");
//		 */
//
//		}
<<<<<<< HEAD
=======
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
>>>>>>> f769f75 (WIP: saving changes before switching to main)
=======
>>>>>>> 8de0d3dc9ea5b721173bc94b4613e164894dceff
>>>>>>> 808a7be3f63646efd797508a5d3a1145aa44cc35
=======
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

        // Start Extent test
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
>>>>>>> origin/main

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	WebDriver driver;
	
	public WebDriver getDriver()
	{
		if(driver==null)
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("");
			driver.manage().window().maximize();
		}
		return driver;
	}

	@AfterMethod
	public void teardown()
	{
		driver.close();
		driver=null;
	}
=======
>>>>>>> 5a006f1636b7b4a0c5715c5bedfbf987f8d0b745
}
