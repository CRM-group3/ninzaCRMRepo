package com.group3.CRMbasics;

import static org.testng.Assert.assertEquals;
import com.group3.CRMlogs.Logs;
import com.group3.CRMutilities.ScreenShots;
import com.group3.CRMlistners.ExtentTestManager;
import com.group3.CRMlistners.ExtentManager;
import static org.testng.Assert.fail;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import com.group3.CRMlistners.ExtentTestManager;
//import com.salesforce.utility.ExtentUtility;
import com.group3.CRMlogs.Logs;
//@Listeners(com.salesforce.utility.SalesforceListenerUtility.class)
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.group3.CRMlistners.ExtentTestManager;
import com.group3.CRMlistners.ExtentManager;




public class BasePage {
	
WebDriver driver;
protected Alert alert;
protected Actions action;
public ExtentReports reportlog = ExtentManager.getInstance();
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

//<<<<<<< HEAD
	public void clickElement(WebElement element, String objectName) {
		try {
			assertEquals(true, element.isEnabled());//enabled to interact with like buttons 

			element.click();
			Logs.info(objectName + "button is clicked");
			ExtentManager.logTestInfo(objectName +  "button is clicked");
		
		}catch(AssertionError e) {
			Logs.error(objectName + " is not enabled :Please  check");

	throw e;
		}
	
	}
	
	public void isSelectedElement(WebElement element, String objectName) {
		try {

		assertEquals(true, element.isSelected());
		element.click();
		Logs.info(objectName + "Is selected – Assert passed");
		ExtentManager.logTestInfo(objectName + "Is selected – Assert passed");


		}catch(AssertionError e) {
			Logs.info(objectName + "Element is not selected ");
			throw e;
		}
	}

	public void elementTextVerify(WebElement element, String expText) {
		String expTexts = expText;
		String actText=""; // Initialize actText with a default value

		try {
	assertEquals(true, element.isDisplayed());// Verifies that element is displayes
	Logs.info(element.toString() + "Is enabled and clicked");
	ExtentManager.logTestwithPassed("Is selected – Assert passed");
	 actText = element.getAttribute("value");

		assertEquals(actText, expTexts);
		Logs.info(actText+"Expected value matches the actual value" + expTexts);
		ExtentManager.logTestwithPassed(actText+"Expected value matches the actual value" + expTexts);

		}catch(AssertionError e) {
			Logs.error(actText+"Expected value do not matches the actual value" + expTexts);
		// if (expText.equals(actText)) {
throw e;
	}}

	
	public String getPagetitle() {

		String actualTitle = driver.getTitle();
		Logs.info("Page title= " + actualTitle);
		return actualTitle;

	}

	public void getCurrentURL(String expURL) {

		String actURL = driver.getCurrentUrl();
		Logs.info("Current URL is = " + actURL);
		try {
			Assert.assertEquals(actURL, expURL);
			Logs.info(actURL + "  matched with " + expURL);
			ExtentManager.logTestwithPassed(actURL + "  matched with " + expURL);

		} catch (AssertionError e) {
			Logs.error(actURL + "not   matched with " + expURL);

			ExtentManager.logTestfailwithException(e);
			throw e;
		}
		
	}

	public String getText(WebElement element) {
		String actual = element.getText();
		Logs.info("Element extracted text is = " + actual);

		return actual;
		}
	

//=======
	public void waitForElement(WebElement element, Duration time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	ExtentTest test = ExtentTestManager.getTest();
	}
	//----------------------------------------------------------------------------------
	
	public void getTextCheck(WebElement element, String expectedTxt) {
		//Ban Code
		String actualTxt= element.getText().trim();
		if(actualTxt.equals(actualTxt.trim())) {
			Logs.info("Text Matched   "+ actualTxt);
			ExtentManager.logTestwithPassed("Text Matched   "+ actualTxt);
			//test.pass("Text Matched   "+ actualTxt);
		}
		else {
			Logs.error("Text Mismatch   Expected  "+ expectedTxt+"  Found "+ actualTxt);
			//test.fail("Text Mismatch   Expected  "+ expectedTxt+"  Found "+ actualTxt);
			ExtentManager.logTestwithFailed("Text Mismatch   Expected  "+ expectedTxt+"  Found "+ actualTxt);
			Assert.fail("Text MisMatch");
		}
		
		
		
		/* Chitra code
		 * String expectedTxt = exp; String actualTxt = ele.getText(); try {
		 * assertEquals(actualTxt, expectedTxt); log.info(actualTxt + "  matched with "
		 * + expectedTxt); // mybasePagelog.error(actualTxt + " matched with " +
		 * expectedTxt);
		 * 
		 * //reportlog.logTestwithPassed(actualTxt + "  matched with " + expectedTxt);
		 * 
		 * } catch (AssertionError e) { log.error(actualTxt + "not   matched with " +
		 * expectedTxt);
		 * 
		 * // reportlog.logTestfailwithException(e); throw e; }
		 */
	}
	
	// }

	/*
	 * if (expected.equals(actual) || (actual.contains(expected)))// it returns true
	 * if one of the condition is true
	 * 
	 * { mybasePagelog.info("Match found  " + object + exp); } else {
	 * mybasePagelog.info("Match not found " + object + exp); }
	 * 
	 * }
	 */

	public void switchToAlert() {

		alert = driver.switchTo().alert();
		Logs.info("Now focus is on Alert Dialog box");
	}

	public void acceptAlert() {
		alert.accept();
		Logs.info("ok button is clicked");
	}

	public String getAlertlabelText() {
		String text = alert.getText();
		Logs.info("Alert text is retrieved");
		return text;
	}

	public void sendtoAlertText(String obj) {
		alert.sendKeys(obj);
		Logs.info("Prompt text is:" + obj);

	}

	public void dismiss() {
		alert.dismiss();
		Logs.info("Alert is dismissed");
		//reportlog.logTestInfo("Alert is dismissed");

	}

	public String getTextFromElement(WebElement element, String objectName) {
		String text = element.getText();
		Logs.info("text is extracted from " + objectName);
		//reportlog.logTestInfo("text is extracted from \" + objectName");
		return text;
	}

	

	
}

