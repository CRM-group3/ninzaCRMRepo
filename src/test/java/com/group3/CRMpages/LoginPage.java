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
	
	
	public void enterintoUsername() {
		username.sendKeys("rmgyantra");
	}
	
	public void enterintoPassword() {
		password.sendKeys("rmgy@9999");
	}
	
	public void clickSignIn() {
		signIn.click();
	}
	
	

}
