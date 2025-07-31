package com.group3.CRMtests;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.group3.CRMbasics.BaseTest;
import com.group3.CRMlogs.Logs;
import com.group3.CRMpages.LoginPage;
import com.group3.CRMpages.QuotePage;
import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMutilities.ScreenShots;

public class QuoteTest extends BaseTest{

	WebDriver driver;
	LoginPage loginpage;
	PropertiesFile prop;
	ScreenShots screen = new ScreenShots();
	QuotePage quotepage;
	
	@BeforeMethod
	@Test
	public void login() throws Exception {
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
		Thread.sleep(1000);
		quotepage = new QuotePage(driver);
		quotepage.clickQuotes();
	}
	
	@Test
	public void createQuoteWithValid() throws Exception {
		quotepage.clickCreateQuote();
		quotepage.sendKeysToSubject("Winter Sale");
		quotepage.sendKeysToValidTill("10/25/2025");
		quotepage.sendKeysToQuoteStage("Planning");
		quotepage.clickOpportunity();
		Thread.sleep(2000);
		quotepage.switchOpportunityWindow(driver);
		Thread.sleep(1000);
		quotepage.clickContact();
		Thread.sleep(2000);
		quotepage.switchContactWindow(driver);
		Thread.sleep(2000);
	
	}
	
}
