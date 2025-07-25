package com.group3.CRMtests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.group3.CRMbasics.BaseTest;
import com.group3.CRMpages.LoginPage;

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
	
}
