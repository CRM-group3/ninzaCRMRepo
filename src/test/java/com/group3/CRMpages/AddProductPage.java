package com.group3.CRMpages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.group3.CRMbasics.BasePage;
import com.group3.CRMlistners.ExtentManager;
import com.group3.CRMlogs.Logs;
import com.group3.CRMutilities.PropertiesFile;

public class AddProductPage {
	WebDriver driver;

	public AddProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li//a[contains(text(),'Products')]")
	public WebElement productsPage;

	@FindBy(xpath = "//button[@class='btn btn-info']")
	public WebElement addProductElement;

	@FindBy(xpath = "//h3[contains(text(),'Add Product')]")
	public WebElement addProductText;

	@FindBy(xpath = "//input[@name='productName']")
	public WebElement productName;

	@FindBy(xpath = "//input[@name='quantity']")
	public WebElement quantity;

	@FindBy(xpath = "//input[@name='price']")
	public WebElement pricePerUnit;

	@FindBy(xpath = "//select[@name='productCategory']")
	public WebElement selectCategory;

	@FindBy(xpath = "//select[@name='vendorId']")
	public WebElement selectVendor;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement saveButton;

	@FindBy(xpath = "//select[@class='form-control']")
	public WebElement searchForProdect;

	@FindBy(xpath = "//div[@class='col-sm-6']//input[@class='form-control']")
	public WebElement addTextToSearchBox;

	@FindBy(xpath = "//table[@class='table table-striped table-hover']")
	public WebElement productTable;

	@FindBy(xpath = "//input[@name='productId']")
	public WebElement productIdFiled;

	public static String generateUniqueProductName(String baseName) {
		return baseName + UUID.randomUUID().toString().substring(0, 4);

	}

	public String getProductIdFromTable(String productName) {
		try {
			WebElement row = driver.findElement(By.xpath("//table//tr[td[text()='" + productName + "']]"));
			return row.findElement(By.xpath("./td[1]")).getText(); // assuming ID is in first column
		} catch (Exception e) {
			return null;
		}
	}

	public void preConditionMethod() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a[text()='Products']")));
		productsPage.click();
		addProductElement.click();
		String expectedTitle = "Add Product";
		String actualTitle = addProductText.getText();
		assertEquals(actualTitle, expectedTitle);
		ExtentManager.logTestwithPassed("inside Add Product page");
		Logs.info("inside Add Product page");
	}

	public boolean verifyProductIdReadOnly(WebElement element, String fieldName) {
		try {
			String readonlyAttr = element.getAttribute("readonly");
			boolean isReadOnly = "true".equalsIgnoreCase(readonlyAttr);
			Assert.assertTrue(isReadOnly, fieldName + " should be readonly but found: " + readonlyAttr);
			ExtentManager.logTestwithPassed(fieldName + " is readonly.");
			return true;
		} catch (Exception e) {
			ExtentManager.logTestwithFailed("Failed to verify readonly for " + fieldName + ": " + e.getMessage());
			Assert.fail("Exception occurred while checking readonly attribute.");
			return false;
		}
	}

	public boolean isFieldClickable(WebElement element, String fieldName) {
		boolean clickable = element.isDisplayed() && element.isEnabled();
		if (clickable) {
			ExtentManager.logTestwithFailed(fieldName + " is clickable but should NOT be.");
			Assert.fail(fieldName + " should NOT be clickable");
		} else {
			ExtentManager.logTestwithPassed(fieldName + " is NOT clickable as expected.");
		}
		return !clickable;
	}

	public boolean verifyFieldDoesNotAcceptInput(WebElement element, String fieldName) {
		String originalValue = element.getAttribute("value");

		try {
			element.clear();
			element.sendKeys("testInput");
		} catch (Exception e) {
			ExtentManager.logTestwithPassed(fieldName + " did not accept input (exception thrown): " + e.getMessage());
			return true;
		}

		String valueAfterInput = element.getAttribute("value");

		if (!originalValue.equals(valueAfterInput)) {
			ExtentManager.logTestwithFailed(fieldName + " accepted input! Value changed from '" + originalValue
					+ "' to '" + valueAfterInput + "'");
			Assert.fail(fieldName + " should NOT accept any input");
			return false;
		} else {
			ExtentManager.logTestwithPassed(fieldName + " did not accept any input, value unchanged.");
			return true;
		}

	}

	public boolean isElementDisplayed(WebElement element, String elementName) {
		try {
			boolean result = element.isDisplayed();
			if (result) {
				ExtentManager.logTestwithPassed(elementName + " is displayed...");
				Logs.info(elementName + " is displayed");
			} else {
				ExtentManager.logTestwithFailed(elementName + " is not disaplyed");
				Logs.info(elementName + " is not disaplyed");
			}
			return result;

		} catch (NoSuchElementException e) {
			Logs.info("EXCEPTION: " + elementName + " not found.");
			ExtentManager.logTestwithFailed("Element not found: " + elementName);
			return false;
		}
	}

	public boolean isElementEnable(WebElement element, String elementName) {
		try {
			boolean result = element.isEnabled();
			if (result) {
				ExtentManager.logTestwithPassed(elementName + " is Enabled...");
				Logs.info(elementName + " is Enabled");
			} else {
				ExtentManager.logTestwithFailed(elementName + " is not Enabled");
				Logs.info(elementName + " is not Enabled");
			}
			return result;

		} catch (NoSuchElementException e) {
			Logs.info("EXCEPTION: " + elementName + " not found.");
			ExtentManager.logTestwithFailed("Element not found: " + elementName);
			return false;
		}
	}

	// Returns the validation message shown by the browser if the field is invalid.
	// Returns the browser's built-in validation message if the field is invalid
	public String getValidationMessage(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", element);
			ExtentManager.logTestInfo("Validation message returned: " + validationMessage);
			System.out.println(validationMessage);
			return validationMessage;
		} catch (Exception e) {
			ExtentManager.logTestwithFailed("Could not get validation message: " + e.getMessage());
			return null;
		}
	}

	public boolean checkifDropDownHaveValues(WebElement element, String ElementName) {
		boolean result;
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			if (options.size() > 0) {
				ExtentManager.logTestwithPassed(ElementName + " dropdown options found");
				Logs.info(ElementName + " dropdown options found");
				result = true;
			} else {
				ExtentManager.logTestwithFailed(ElementName + " dropdown options not found");
				Logs.info(ElementName + " dropdown options not found");
				result = false;
			}
		} catch (Exception e) {
			ExtentManager.logTestwithFailed(ElementName + " dropdown options not found");
			Logs.info(ElementName + " dropdown options not found");
			result = false;

		}
		return result;
	}

	// Replace regular sendKeys with this
	public void setTxtForNumericFiledWithJS(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
		        "arguments[0].value='" + value + "';" +
		                "arguments[0].dispatchEvent(new Event('input'));" +
		                "arguments[0].dispatchEvent(new Event('change'));", element
		            );
	}

	public boolean verifyThatProductIsAddedWithExistingProductNameMessage() {

		boolean isCreatedVerified = false;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toast = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));

		String toastText = toast.getText();
		System.out.println(toastText);
		isCreatedVerified = true;

		return isCreatedVerified;
	}

	public String findProductIDOnTheProductTable(String ProductName) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Locate the search input box (update locator if different)

		BasePage basePage = new BasePage(driver);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//select[@class='form-control']//option[@value='productName']")));
		basePage.selectByValueWebElement(searchForProdect, "productName");
		// basePage.elementSendText(prodPage.addTextToSearchBox,
		// prop.getProperty("addproduct.proprties", "testcase1.productName"),
		// "addproduct.proprties");
		addTextToSearchBox.sendKeys(ProductName);

		// Wait until the filtered row appears
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table//tr[td[contains(text(),'" + ProductName + "')]]")));

		// Locate the filtered row
		WebElement row = driver.findElement(By.xpath("//table//tr[td[contains(text(),'" + ProductName + "')]]"));

		// Get the Product ID cell (assuming first column)
		WebElement productIdCell = row.findElement(By.xpath("./td[1]"));

		// Extract and trim the product ID text
		String generatedProductId = productIdCell.getText().trim();

		return generatedProductId;
	}

	public String addProduct() throws Exception {
		BasePage basePage = new BasePage(driver);
		PropertiesFile prop = new PropertiesFile();
		String uniqueProductName1 = AddProductPage.generateUniqueProductName("Prod");
		productName.sendKeys(uniqueProductName1);
		basePage.elementSendText(quantity, prop.getProperty("addproduct.proprties", "testcase1.quantity"),
				"addproduct.proprties");
		basePage.elementSendText(pricePerUnit, prop.getProperty("addproduct.proprties", "testcase1.pricePerUnit"),
				"addproduct.proprties");
		basePage.selectByVisibleTextWebElement(selectCategory,
				prop.getProperty("addproduct.proprties", "testcase1.selectCategory"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//select[@name='vendorId']/option[@value='VID_004']")));
		basePage.selectByValueWebElement(selectVendor,
				prop.getProperty("addproduct.proprties", "testcase1.selectVendor"));
		// basePage.selectByIndex(prodPage.selectVendor,
		// Integer.parseInt(prop.getProperty("addproduct.proprties","testcase1.selectVendor")));
		basePage.clickbutton(saveButton, "Save");
		return uniqueProductName1;
	}

}
