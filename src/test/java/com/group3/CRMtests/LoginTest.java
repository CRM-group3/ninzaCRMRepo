package com.group3.CRMtests;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.group3.CRMbasics.BaseTest;
import com.group3.CRMlistners.ExtentManager;
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
	public void login() throws Exception {
<<<<<<< HEAD
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
		
		System.out.println("login successfull");

>>>>>>> 1ccf402 (did some changes to conacttest and basetest to resolve the conflict of multiple driver instacnce and generation of extent reports)
	}	

	
}
