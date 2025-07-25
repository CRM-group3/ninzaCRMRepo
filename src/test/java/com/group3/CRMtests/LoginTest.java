package com.group3.CRMtests;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;
import com.group3.CRMbasics.BaseTest;
import com.group3.CRMpages.LoginPage;
import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMutilities.ScreenShots;

public class LoginTest extends BaseTest{
	
	WebDriver driver;
	LoginPage loginpage;
	PropertiesFile prop;
	ScreenShots screen = new ScreenShots();
	
	@BeforeMethod
	public void beformethod() {
		driver = getDriver();
		prop = new PropertiesFile();
		String url = prop.getProperty("url");
		driver.get(url);
		loginpage = new LoginPage(driver);
		DOMConfigurator.configure("log4j.xml");
	}
	
	//@Test
//	public void login() {
////		Testcase 2
//		Log.startTestCase("Login Testcase");
//		String username = prop.getProperty("username");
//		loginpage.enterintoUsername(username);
//		Log.info("Successfully entered the username");
//		String password = prop.getProperty("password");
//		loginpage.enterintoPassword(password);
//		loginpage.clickLogin();
//	}
	

}
