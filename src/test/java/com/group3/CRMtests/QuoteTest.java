package com.group3.CRMtests;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.group3.CRMbasics.BaseTest;
import com.group3.CRMlogs.Logs;
import com.group3.CRMpages.LoginPage;
import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMutilities.ScreenShots;

public class QuoteTest extends BaseTest{

	WebDriver driver;
	LoginPage loginpage;
	PropertiesFile prop;
	ScreenShots screen = new ScreenShots();
	
	@BeforeMethod
	@Test
	public void login() {
		driver = getDriver();
		prop = new PropertiesFile();
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		DOMConfigurator.configure("log4j.xml");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		loginpage.enterintoUsername(username);
		loginpage.enterintoPassword(password);
		loginpage.clickSignIn();	
		Logs.info("Successfully logged in");
	}
	
	@Test
	public void createQuoteWithValid() {
		
		
	}
	
}
