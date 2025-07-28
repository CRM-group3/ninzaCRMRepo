package com.group3.CRMpages;

<<<<<<< Updated upstream
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.group3.CRMbasics.BasePage;

public class AddContactsPage extends BasePage{

	protected ExtentTest test;

	public AddContactsPage(WebDriver driver, ExtentTest test) {
		super(driver);
	
		PageFactory.initElements(driver, this);
		this.test = test;
	}
	
	
	



	
//	public static void main(String[] args) {
//		
//       
//	}

=======
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddContactsPage {
	
	public static String username = "rmgyantra" ;
	public static String password = "rmgy@9999";
	public static WebDriver driver;
	
    @BeforeMethod
    public void launchApp() {
//        WebDriverManager.firefoxdriver().setup();
//        FirefoxOptions options = new FirefoxOptions();
//        options.addPreference("signon.rememberSignons", false);
//        options.addPreference("signon.autofillForms", false);
//        options.addPreference("security.insecure_field_warning.contextual.enabled", false);
//        options.addPreference("security.password_lifetime", 0);
//        options.addPreference("signon.management.page.breach-alerts.enabled", false); // <- Important
//
//        driver = new FirefoxDriver(options);
    	
    	//WebDriverManager.chromedriver().setup();
    	
    	driver = new ChromeDriver();
        driver.get("http://49.249.28.218:8098");
        driver.manage().window().maximize();
    }
	
	@Test
	void login() throws InterruptedException {
		
		
		driver.findElement(By.id("username")).sendKeys(username);
		Thread.sleep(3000);
		
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		Thread.sleep(10000);
	 }
	 @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
>>>>>>> Stashed changes
}
//	public static void main(String[] args) throws InterruptedException {
//		
//		launchApp();
//		login();
//	}



