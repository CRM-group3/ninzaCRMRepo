package com.group3.CRMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.group3.CRMbasics.BasePage;

public class LoginPage extends BasePage {
	

		@FindBy(id="username") 
		 public WebElement username;
		
		@FindBy(name="password")
		public WebElement password;
		
		@FindBy(xpath="//button[@type='submit']")
		public WebElement signin;
	

	
	

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);

        // Use your base method:
        clickElement(signin, "Signin button");
    }
}
