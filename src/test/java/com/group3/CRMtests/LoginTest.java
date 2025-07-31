package com.group3.CRMtests;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.group3.CRMbasics.BaseTest;
import com.group3.CRMpages.LoginPage;
import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMutilities.ScreenShots;
import com.group3.CRMlogs.Logs;

public class LoginTest extends BaseTest{
	
	WebDriver driver;
	LoginPage loginpage;
	PropertiesFile prop;
	ScreenShots screen = new ScreenShots();
	
	@Test
<<<<<<< HEAD
	public void login() throws Exception {
	driver = getDriver();
	prop = new PropertiesFile();
	String url = prop.getProperty("application.properties","url");
	driver.get(url);
	driver.manage().window().maximize();
	loginpage = new LoginPage(driver);
	DOMConfigurator.configure("log4j.xml");
	String username = prop.getProperty("application.properties","username");
	String password = prop.getProperty("application.properties","password");
	loginpage.enterintoUsername(username);
	loginpage.enterintoPassword(password);
	loginpage.clickSignIn();	
	Logs.info("Successfully logged in");
	Thread.sleep(10000);
=======
	public WebDriver login() {
	driver = getDriver();
	driver.get("http://49.249.28.218:8098/");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterintoUsername();
	loginpage.enterintoPassword();
	loginpage.clickSignIn();
	return driver;
	
>>>>>>> 7227cfa (before pulling the main branch)
	}	

	
}
