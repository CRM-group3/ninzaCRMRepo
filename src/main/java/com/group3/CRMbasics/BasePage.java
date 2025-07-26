package com.group3.CRMbasics;

import com.google.common.io.Files;

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

import com.group3.CRMlogs.Logs;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.group3.CRMlistners.ExtentTestManager;
import com.group3.CRMlistners.ExtentManager;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.google.common.io.Files;
import com.aventstack.extentreports.ExtentReports;
import com.group3.CRMlogs.Logs;
import com.group3.CRMlistners.ExtentManager;


public class BasePage {
	
WebDriver driver;

public ExtentReports reportlog = ExtentManager.getInstance();
protected Actions action;

protected Alert alert;
protected Actions action;
public ExtentReports reportlog = ExtentManager.getInstance();

	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	


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
	


	public void waitForElement(WebElement element, Duration time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	ExtentTest test = ExtentTestManager.getTest();
	}
	
	
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


	public void mouseHover_Interaction(WebElement ele) {
		action = new Actions(driver);

		action.moveToElement(ele, 10, 10).click().build().perform();
		Logs.info("Cursor hovered to the desired element");
		ExtentManager.logTestInfo("Cursor hovered to the desired element");
		action.moveToElement(ele, 10, 10).click().build().perform();
		Logs.info("Cursor hovered to the desired element");
		ExtentManager.logTestInfo("Cursor hovered to the desired element");
	}

	public void ContextClickOnElement(WebElement ele, String objName) {
		Actions action = new Actions(driver);
		action.contextClick(ele).build().perform();
		Logs.info("right click persormed on web element " + objName);
		ExtentManager.logTestInfo("right click persormed on web element " + objName);
		Logs.info("right click persormed on web element " + objName);
		ExtentManager.logTestInfo("right click persormed on web element " + objName);
	}

	public void actionCall() {
		action = new Actions(driver);
		Logs.info("Action object created");
		ExtentManager.logTestInfo("Action object created");		
		Logs.info("Action object created");
		ExtentManager.logTestInfo("Action object created");		
	}

	public void actionDragandDropCall(WebElement ele1, WebElement ele2) {
		action.dragAndDrop(ele1, ele2).build().perform();
		Logs.info("Dragand drop action is performed successfully....");
		ExtentManager.logTestInfo("Dragand drop action is performed successfully.");
		Logs.info("Dragand drop action is performed successfully....");
		ExtentManager.logTestInfo("Dragand drop action is performed successfully.");
		;
	}

	public void toolTip(WebElement ele, WebElement tooltipele) {
		action.moveToElement(ele).build().perform();
		;
		driver.switchTo().activeElement();

		String str = tooltipele.getText();
		Logs.info("tooltiptext ---> " + str);
		ExtentManager.logTestInfo("tooltiptext ---> " + str);
		Logs.info("tooltiptext ---> " + str);
		ExtentManager.logTestInfo("tooltiptext ---> " + str);
	}

	public void screenshotWebElement(WebElement ele, String filepath) {

		File srcFile = ele.getScreenshotAs(OutputType.FILE);
		File descFile = new File(filepath);
		try {
			Files.copy(srcFile, descFile);
			Logs.info("captures the screenshot");
			Logs.info("captures the screenshot");
			//reportlog.logTestInfo("captures the screenshot");

		} catch (IOException e) {

			Logs.error("Error while capturing  the screenshot" + e.getMessage());
			Logs.error("Error while capturing  the screenshot" + e.getMessage());

		}
	}

	public void twoStringVerify(String actvalue, String expvalue) {

		try {
			Assert.assertEquals((actvalue).replaceAll("\\s+", ""), (expvalue.replaceAll("\\s+", "")));
			// Assert.assertTrue(actvalue.trim().equals(expvalue), "Strings are not equal
			// after trimming whitespace");

			Logs.info("Actual value " + actvalue + " match the expected value" + expvalue);
			ExtentManager.logTestwithPassed("Actual value " + actvalue + " match the expected value" + expvalue);
			Logs.info("Actual value " + actvalue + " match the expected value" + expvalue);
			ExtentManager.logTestwithPassed("Actual value " + actvalue + " match the expected value" + expvalue);
		} catch (Exception e) {

			Logs.error("Actual value " + actvalue + " do not  match the expected value" + expvalue);
			ExtentManager.logTestwithFailed("Actual value " + actvalue + " do not  match the expected value" + expvalue);
		}
	}	
			Logs.error("Actual value " + actvalue + " do not  match the expected value" + expvalue);
			ExtentManager.logTestwithFailed("Actual value " + actvalue + " do not  match the expected value" + expvalue);
		}
	}	


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

