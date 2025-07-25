package com.group3.CRMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.group3.CRMbasics.BasePage;
import com.group3.CRMbasics.BaseTest;
import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMutilities.ScreenShots;

public class TestPage extends BasePage{
	
	


	public TestPage(WebDriver driver) {
		super(driver);
	}
	WebDriver driver;
	 static TestPage testPage;
	 
	
	 @FindBy(xpath="//a[@aria-label='Gmail ']")  // example locator
	 WebElement gmail;

	 public void clickOnGmail() {
	     clickElement(gmail, "gmail Field");
	 }


	public static void main(String[] args) throws InterruptedException {
		       
		        WebDriver driver = new ChromeDriver();
		        driver.get("https://www.google.com/");
		        testPage = new TestPage(driver);
		        
		        BasePage basePage = new BasePage(driver); // Pass driver here
		        System.out.println("Page Title: " + basePage.getPagetitle());
		        
		        String currentURL = driver.getCurrentUrl();
		        System.out.println("Current URL: " + currentURL);
		        testPage.clickOnGmail();
		        Thread.sleep(3000);
		        
//		        String usernameLabel = testPage.getText(testPage.usernameLabel);
//		        System.out.println("Username Label text is: " + usernameLabel);
		        
		       
		        driver.quit();

		  }
		
	}

