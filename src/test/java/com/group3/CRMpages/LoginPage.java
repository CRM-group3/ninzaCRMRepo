package com.group3.CRMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.group3.CRMbasics.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="inputPassword")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	WebElement signIn;
	
	

	public void enterintoUsername(String userName) {
		username.sendKeys(userName);
	}
	
	public void enterintoPassword(String passWord) {
		password.sendKeys(passWord);

	}
	
	public void clickSignIn() {
		signIn.click();
		
		driver.manage().window().maximize();
		
		
	}
}
