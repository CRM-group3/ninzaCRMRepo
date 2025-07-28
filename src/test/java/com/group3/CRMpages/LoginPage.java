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
	}
	@FindBy(xpath="//a[normalize-space()='Quotes']")
	WebElement quotes;
	
	public void clickQuotes() {
		quotes.click();
	}
	
	
	@FindBy(xpath="//span[normalize-space()='Create Quote']")
	WebElement createQuotesButton;
	
	public void clickCreateQuote() {
		createQuotesButton.click();
	}
	
	@FindBy(xpath="(//button[@class='action-button'])[position()=1]")
	WebElement opportunity;
	
	
	public void clickOpportunity() {
		opportunity.click();
	}
}
