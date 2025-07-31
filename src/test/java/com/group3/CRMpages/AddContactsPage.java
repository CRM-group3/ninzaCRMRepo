package com.group3.CRMpages;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.group3.CRMbasics.BasePage;
import com.group3.CRMutilities.ScreenShots;


public class AddContactsPage extends BasePage{
	protected ExtentTest test;
	public AddContactsPage(WebDriver driver, ExtentTest test) {
		
		super(driver);
		PageFactory.initElements(driver, this);
		this.test = test;
		
	}
	protected static Logger logger=LogManager.getLogger();
	
	
	@FindBy(xpath="//a[@href='/contacts']")
	public WebElement contacts;
	
	//@FindBy(xpath="//button[@class='btn btn-info']")
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/div/div[2]/button/span")
	public WebElement createContact;
	
	
	public boolean clickOnContacts(WebDriver driver) throws IOException {
		if (contacts.isDisplayed()) {
			contacts.click();
			test.info("contacts tab is clicked");
			return true;
		} else {
			test.fail("contacts tab is not clicked");
			test.addScreenCaptureFromPath(ScreenShots.takescreenshot(driver));
			return false;
		}
	}

	public boolean clickOnCreateContact(WebDriver driver) {
		if(createContact.isDisplayed()) {
			createContact.click();
			test.info("create contact button is clicked");
			return true;
		} 
		else {
			test.fail("create contact button is not clicked");
			test.addScreenCaptureFromPath(ScreenShots.takescreenshot(driver));
			return false;
		}
	}
}
	
  


