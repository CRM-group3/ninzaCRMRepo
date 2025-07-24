package com.group3.CRMbasics;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
////-----------------------------------
//import java.io.File;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//
//import com.google.common.io.Files;





public class BaseTest {
	
WebDriver driver;
	
	public WebDriver getDriver() {
		if(driver == null) {
			WebDriverManager.chromedriver().setup();
			// 🔐 Disable password manager and breach popups
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
		driver.close();
		driver = null;
	}
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

}
