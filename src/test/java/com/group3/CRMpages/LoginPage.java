package com.group3.CRMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//<<<<<<< HEAD
import org.openqa.selenium.support.PageFactory;

import com.group3.CRMbasics.BasePage;

//public class LoginPage extends BasePage {
	

//		@FindBy(id="username") 
//		 public WebElement username;
//		
//		@FindBy(name="password")
//		public WebElement password;
//		
//		@FindBy(xpath="//button[@type='submit']")
//		public WebElement signin;
//	
//
//	
//	
//
//    public LoginPage(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(driver, this);
//    }
//    
//    public void login(String user, String pass) {
//        username.sendKeys(user);
//        password.sendKeys(pass);
//
//        // Use your base method:
//        clickElement(signin, "Signin button");
//    }
//=======

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
	
	

//>>>>>>> 8de0d3dc9ea5b721173bc94b4613e164894dceff
}
