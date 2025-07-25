package com.group3.CRMbasics;
import static org.testng.Assert.assertEquals;
import com.group3.CRMlogs.Logs;
import com.group3.CRMutilities.ScreenShots;
import com.group3.CRMlistners.ExtentTestManager;
import com.group3.CRMlistners.ExtentManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;



public class BasePage {
	
WebDriver driver;
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
	}

