package com.group3.CRMtests;

//<<<<<<< HEAD
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;
import com.group3.CRMbasics.BaseTest;
import com.group3.CRMpages.LoginPage;
import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMutilities.ScreenShots;
//=======
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.group3.CRMbasics.BaseTest;
import com.group3.CRMpages.LoginPage;
//>>>>>>> 8de0d3dc9ea5b721173bc94b4613e164894dceff

public class LoginTest extends BaseTest{
	
	WebDriver driver;
	
	@Test
	public void login() {
	driver = getDriver();
	driver.get("http://49.249.28.218:8098/");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterintoUsername();
	loginpage.enterintoPassword();
	loginpage.clickSignIn();
	
	}	
////<<<<<<< HEAD
//	LoginPage loginpage;
//	PropertiesFile prop;
//	ScreenShots screen = new ScreenShots();
//	
//	@BeforeMethod
//	public void beformethod() {
//		driver = getDriver();
//		prop = new PropertiesFile();
//		String url = prop.getProperty("url");
//		driver.get(url);
//		loginpage = new LoginPage(driver);
//		DOMConfigurator.configure("log4j.xml");
//	}
	
}
	