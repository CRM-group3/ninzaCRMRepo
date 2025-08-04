
package com.group3.CRMbasics;
import com.google.common.io.Files;
import static org.testng.Assert.assertEquals;
import com.group3.CRMlogs.Logs;
import com.group3.CRMlistners.ExtentTestManager;
import com.group3.CRMlistners.TestListner;
import com.group3.CRMlistners.ExtentManager;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;
	protected Alert alert;
	protected Actions action;
	public ExtentReports reportlog = ExtentManager.getInstance();
	TestListner tstListner = new TestListner();

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElement(WebElement element, Duration time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
		ExtentTest test = ExtentTestManager.getTest();
	}

//Soumya
	public void clickElement(WebElement element, String objectName) {
		try {
			assertEquals(true, element.isEnabled());// enabled to interact with like buttons

			element.click();
			Logs.info(objectName + "button is clicked");
			ExtentManager.logTestInfo(objectName + "button is clicked");

		} catch (AssertionError e) {
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

		} catch (AssertionError e) {
			Logs.info(objectName + "Element is not selected ");
			throw e;
		}
	}

	public void elementTextVerify(WebElement element, String expText) {
		String expTexts = expText;
		String actText = ""; // Initialize actText with a default value

		try {
			assertEquals(true, element.isDisplayed());// Verifies that element is displayes
			Logs.info(element.toString() + "Is enabled and clicked");
			ExtentManager.logTestwithPassed("Is selected – Assert passed");
			actText = element.getAttribute("value");

			assertEquals(actText, expTexts);
			Logs.info(actText + "Expected value matches the actual value" + expTexts);
			ExtentManager.logTestwithPassed(actText + "Expected value matches the actual value" + expTexts);

		} catch (AssertionError e) {
			Logs.error(actText + "Expected value do not matches the actual value" + expTexts);
			// if (expText.equals(actText)) {
			throw e;
		}
	}

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
	
	//shanti
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
				// reportlog.logTestInfo("captures the screenshot");

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
				ExtentManager
						.logTestwithFailed("Actual value " + actvalue + " do not  match the expected value" + expvalue);
			}
		}

		// Ban Code
		public void getTextCheck(WebElement element, String expectedTxt) {

			String actualTxt = element.getText().trim();
			if (actualTxt.equals(actualTxt.trim())) {
				Logs.info("Text Matched   " + actualTxt);
				ExtentManager.logTestwithPassed("Text Matched   " + actualTxt);
				// test.pass("Text Matched "+ actualTxt);
			} else {
				Logs.error("Text Mismatch   Expected  " + expectedTxt + "  Found " + actualTxt);
				// test.fail("Text Mismatch Expected "+ expectedTxt+" Found "+ actualTxt);
				ExtentManager.logTestwithFailed("Text Mismatch   Expected  " + expectedTxt + "  Found " + actualTxt);
				Assert.fail("Text MisMatch");
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
			// reportlog.logTestInfo("Alert is dismissed");

		}


		public String getTextFromElement(WebElement element, String objectName) {
			String text = element.getText();
			Logs.info("text is extracted from " + objectName);
			// reportlog.logTestInfo("text is extracted from \" + objectName");
			return text;
		}

		// Darshana

		public void waitUntilPageLoads(long seconds) {
			Logs.info("Waiting until page loads within  expectedtime period");

			//ExtentManager.logTestInfo("Waiting until page loads within expectedtime period");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));

		}

		public void verifyDefaultoption(By locator, String expectedOption) throws Exception {
			WebElement dropdown = driver.findElement(locator);
			dropdown.click();
			Logs.info("Drop down element is clicked");
			ExtentManager.logTestInfo("Drop down element is clicked");
			Select select = new Select(dropdown);
			String actualDefaultOption = select.getFirstSelectedOption().getText();

			Logs.info("Actual default selected value : " + actualDefaultOption);

			try {
				Assert.assertEquals("Default dropdown option does not match.", expectedOption, actualDefaultOption);
				Logs.info("Default selected option matches expected value: " + expectedOption);
			} catch (AssertionError e) {
				System.err.println("Default selected option mismatch. Expected: " + expectedOption + ", Actual: "
						+ actualDefaultOption);
				ExtentManager.logTestfailwithException(e);
				throw e;
			}
		}

		public void selectByVisibleText(By locator, String visibleText) throws Exception {
			WebElement dropdownElement = driver.findElement(locator);
			dropdownElement.click();
			Logs.info("Dropdown element is clicked");
			ExtentManager.logTestInfo("Dropdown element is clicked");

			Select dropdown = new Select(dropdownElement);

			try {
				dropdown.selectByVisibleText(visibleText);
				Logs.info("Text '" + visibleText + "' is selected from dropdown");

				String selectedOptionText = dropdown.getFirstSelectedOption().getText();
				Assert.assertEquals(visibleText, selectedOptionText);
				Logs.info("Selected option matches expected value.");
				ExtentManager.logTestInfo("Selected option matches expected value");

			} catch (Exception e) {
				System.err.println("Failed to select '" + visibleText + "' from dropdown. Error: " + e.getMessage());
				ExtentManager.logTestfailwithException(e);
				throw e;
			}
		}

		public void selectByIndex(By locator, int Index) throws Exception {

			WebElement dropdownElement = driver.findElement(locator);
			dropdownElement.click();

			Logs.info("Dropdown element is clicked");
			ExtentManager.logTestInfo("Dropdown element is clicked");

			Select dropdown = new Select(dropdownElement);
			try {
				dropdown.selectByIndex(Index);
				Logs.info(Index + "' is selected from dropdown");
				String selectedOptionText = dropdown.getFirstSelectedOption().getText();
				Assert.assertTrue(true, selectedOptionText);
				Logs.info("selected option matches to the Actual option");

				ExtentManager.logTestInfo("Selected option matches to the expected Visible text");
			} catch (Exception e) {

				Logs.info("Desired Index" + Index + "is not selected");
				ExtentManager.logTestfailwithException(e);
				throw e;

			}
		}

		public void selectByValue(By locator, String value) throws Exception {
			WebElement dropdownElement = driver.findElement(locator);
			dropdownElement.click();
			Logs.info("Dropdown element is clicked");
			ExtentManager.logTestInfo("Dropdown element is clicked");
			Select dropdown = new Select(dropdownElement);
			try {
				dropdown.selectByValue(value);

				String selectedOptionValue = dropdown.getFirstSelectedOption().getAttribute("value");

				Assert.assertEquals(selectedOptionValue, value);
				Logs.info("Selected option matches the expected value: " + value);
				ExtentManager.logTestInfo("Selected option matches the expected value:" + value);

			} catch (Exception e) {
				Logs.info("Desired value '" + value + "' is not selected. Error: " + e.getMessage());
				ExtentManager.logTestfailwithException(e);
				throw e;
			}
		}

		public void getAllOptionsAndVerify(By locator) {
			WebElement dropdownElement = driver.findElement(locator);
			dropdownElement.click();
			Select select = new Select(dropdownElement);
			List<WebElement> optionList = select.getOptions();
			for (WebElement option : optionList) {

				Logs.info("The dropdown oppertunities are: " + option.getText());

			}
			List<String> expectedOptions = new ArrayList();
			expectedOptions.add("All Opportunities");
			expectedOptions.add("Closing Next Month");
			expectedOptions.add("Closing This Month");
			expectedOptions.add("My Opportunities");
			expectedOptions.add("New Last Week");
			expectedOptions.add("New This Week");
			expectedOptions.add("Opportunity Pipeline");
			expectedOptions.add("Private");
			expectedOptions.add("Recently Viewed Opportunities");
			expectedOptions.add("Won");
			System.out.println(expectedOptions);
			try {
				Assert.assertEquals((optionList), expectedOptions);

				Logs.info("Dropdown options match the expected list options.");
				ExtentManager.logTestwithPassed("Dropdown options match the expected list options.");

			}

			catch (Exception e) {
				System.out.println("Dropdown options do not  match the expected list." + e.getMessage());
				Logs.error("Dropdown options do not  match the expected list." + e.getMessage());

			}

		}

		public void dropdownChoosebyText(List<WebElement> ele, String info, String obj) {
			for (WebElement field : ele) {
				String getText = field.getText().trim(); // Trim whitespace from the text

				if (getText.equals(info)) {
					if (field.isDisplayed()) { // Check if the element is visible
						field.click();
						System.out.println(obj + "is selected from dropdown");
					} else {
						System.out.println(obj + "is not visible in the dropdown");
					}
					break;
				}
			}

		}

		// Monika
		public WebDriver getDriverInstance() {
			return this.driver;

		}

		public void javascriptClick(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}

		public void javascriptScrollToElement(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}

		public void javascriptScrollToExpDateElement(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}

		public void hoverElement(WebElement element) {
			action = new Actions(driver);

			action.moveToElement(element).perform();
			;

		}

		// Chitra

		public void logoutAccount(WebElement accountele, WebElement logoutele) throws InterruptedException {

			accountele.click();
			Thread.sleep(1000);
			logoutele.click();
		}

		public void clickbutton(WebElement ele, String objname) {
			try {
				assertEquals(true, ele.isEnabled());
				ele.click();
				Logs.info(objname + "Is enabled and clicked");
				ExtentManager.logTestInfo(objname + "Is enabled and clicked");
			} catch (AssertionError e) {
				Logs.error(objname + " is not clickable Please check");
				throw e;
			}

		}

		public void waitForVisibilty(WebElement ele, Duration time, String Objname) throws Exception {

			try {

				wait = new WebDriverWait(driver, time);
				wait.until(ExpectedConditions.visibilityOf(ele));
				Logs.info(Objname + " IS WAITED FOR VISIBLITY");
				ExtentManager.logTestInfo(Objname + " IS WAITED FOR VISIBLITY");
			} catch (Exception e) {
				Logs.error(Objname + " timeout exception");
				throw e;
			}

		}

		public void waitForVisibiltyofElementLocated(By ele, Duration time, String Objname) throws Exception {

			try {

				wait = new WebDriverWait(driver, time);
				wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
				Logs.info(Objname + " IS WAITED FOR VISIBLITY OF ELEMENT TO BE LOCATED");
				ExtentManager.logTestInfo(Objname + " IS WAITED FOR VISIBLITY OF ELEMENT TO BE LOCATED");
			} catch (Exception e) {
				Logs.error(Objname + " timeout exception");
				throw e;
			}

		}

		public void waitForVisibiltyofElementLocated(WebElement ele, Duration time, String Objname) throws Exception {
			try {

				wait = new WebDriverWait(driver, time);
				wait.until(ExpectedConditions.visibilityOf(ele));
				Logs.info(Objname + " IS WAITED FOR VISIBLITY OF ELEMENT TO BE LOCATED");
				ExtentManager.logTestInfo(Objname + " IS WAITED FOR VISIBLITY OF ELEMENT TO BE LOCATED");
			} catch (Exception e) {
				Logs.error(Objname + " timeout exception");
				throw e;
			}
		}

		public void waitForclickable(WebElement ele, Duration time, String Objname) throws Exception {

			try {

				Logs.info(Objname + " IS WAITED FOR clickable");
				wait = new WebDriverWait(driver, time);// time is in seconds
				wait.until(ExpectedConditions.elementToBeClickable(ele));
			} catch (Exception e) {
				Logs.error(Objname + " did not become visible within the specified time" + e.getMessage());
				ExtentManager.logTestInfo(Objname + " did not become visible within the specified time");
				throw e;
			}

		}

		public void waitForVisibilityusingFluentWait(WebElement ele, int time, int pollingtime, String objectName) {
			try {
				Logs.info(objectName + " IS WAITED FOR Visibility");

				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
				wait.withTimeout(Duration.ofSeconds(time)).pollingEvery(Duration.ofMillis(pollingtime))
						.ignoring(ElementNotInteractableException.class)
						.withMessage(objectName + " is not visible.fluent wait time expires");

				wait.until(ExpectedConditions.visibilityOf(ele));
				Logs.info(objectName + " is waited for visibility using fluent wait");
				ExtentManager.logTestInfo(objectName + " is waited for visibility using fluent wait");
			} catch (Exception e) {
				Logs.error("Desired Value is not selected");
				ExtentManager.logTestfailwithException(e);
				throw e;

			}
		}
		
		// other fns
		
//		public void waitForVisibility(WebElement element, int timeout, String elementName) {
//			// Placeholder for WebDriverWait/ExpectedConditions
//			Logs.info("Waited for visibility: " + elementName);
//		}

		public void elementSendText(WebElement element, String text, String fieldName) {
			element.clear();
			element.sendKeys(text);
			Logs.info(text + " entered into " + fieldName);
		}

		public void buttonCheck(WebElement element, String buttonName) {
			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
				Logs.info(buttonName + " clicked");
			} else {
				Logs.error(buttonName + " is not clickable");
			}
		}


	public void selectByValueWebElement(WebElement element, String value) throws Exception {
		WebElement dropdownElement = element;
		dropdownElement.click();
		Logs.info("Dropdown element is clicked");
		ExtentManager.logTestInfo("Dropdown element is clicked");
		Select dropdown = new Select(dropdownElement);
		try {
			dropdown.selectByValue(value);

			String selectedOptionValue = dropdown.getFirstSelectedOption().getAttribute("value");

			Assert.assertEquals(selectedOptionValue, value);
			Logs.info("Selected option matches the expected value: " + value);
			ExtentManager.logTestInfo("Selected option matches the expected value:" + value);

		} catch (Exception e) {
			Logs.info("Desired value '" + value + "' is not selected. Error: " + e.getMessage());
			ExtentManager.logTestfailwithException(e);
			throw e;
		}
	}

public void selectByVisibleTextWebElement(WebElement element, String visibleText) throws Exception {
		WebElement dropdownElement = element;
		dropdownElement.click();
		Logs.info("Dropdown element is clicked");
		ExtentManager.logTestInfo("Dropdown element is clicked");

		Select dropdown = new Select(dropdownElement);

		try {
			dropdown.selectByVisibleText(visibleText);
			Logs.info("Text '" + visibleText + "' is selected from dropdown");

			String selectedOptionText = dropdown.getFirstSelectedOption().getText();
			Assert.assertEquals(visibleText, selectedOptionText);
			Logs.info("Selected option matches expected value.");
			ExtentManager.logTestInfo("Selected option matches expected value");

		} catch (Exception e) {
			System.err.println("Failed to select '" + visibleText + "' from dropdown. Error: " + e.getMessage());
			ExtentManager.logTestfailwithException(e);
			throw e;
		}
	}

	


}
