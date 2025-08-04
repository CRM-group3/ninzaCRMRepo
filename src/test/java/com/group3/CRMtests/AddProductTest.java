package com.group3.CRMtests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.group3.CRMbasics.BasePage;
import com.group3.CRMbasics.BaseTest;
import com.group3.CRMlistners.ExtentManager;
import com.group3.CRMlogs.Logs;
import com.group3.CRMpages.AddProductPage;
import com.group3.CRMutilities.PropertiesFile;

public class AddProductTest extends BaseTest {

	AddProductPage prodPage;
	PropertiesFile prop = new PropertiesFile();

	/*
	 * verify system generated auto product ID and unique
	 */
	@Test
	public void product_TC001() throws Exception {

		prodPage = new AddProductPage(driver);
		prodPage.preConditionMethod();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		basepage.waitForVisibilty(prodPage.productName, Duration.ofSeconds(2000), "Product Name");
		String uniqeProductName=prodPage.addProduct();
		// Wait for the product table to be visible
		wait.until(ExpectedConditions.visibilityOf(prodPage.productTable));
		String generatedProductId= prodPage.findProductIDOnTheProductTable(uniqeProductName);
		if (generatedProductId != null && !generatedProductId.isEmpty()) {
			ExtentManager.logTestwithPassed("System generated Product ID: " + generatedProductId);
			AssertJUnit.assertFalse(generatedProductId.isBlank());
		} else {
			ExtentManager.logTestwithFailed("Product ID is missing");
			AssertJUnit.fail("Product ID was not generated");
		}

	}
	@Test
	public void product_TC002() throws Exception {
		prodPage = new AddProductPage(driver);
		prodPage.preConditionMethod();
		String productName1=prodPage.addProduct();
		String productID1=prodPage.findProductIDOnTheProductTable(productName1);
		Logs.info(productID1+ " able to find first product ID ");
		Thread.sleep(3000);
		prodPage.preConditionMethod();
		String productName2=prodPage.addProduct();
		String productID2=prodPage.findProductIDOnTheProductTable(productName2);
		Logs.info(productID2+ " able to find second product ID ");
		Assert.assertNotEquals(productID1,productID2,"System generated same product IDs" );
		ExtentManager.logTestwithPassed(productID2+ " is not equal to  "+ productID1 +" System generate uniqe product ID");
		
	}
	/*
	 * product ID field is read only and not accept any input
	 */

	@Test
	public void product_TC003() throws Exception {
		prodPage = new AddProductPage(driver);
		prodPage.preConditionMethod();
		prodPage.verifyProductIdReadOnly(prodPage.productIdFiled, "Product ID");
		prodPage.verifyFieldDoesNotAcceptInput(prodPage.productIdFiled, "Product ID");

	}

	/*
	 * verify product name is blank
	 */
	@Test
	public void product_TC005() throws Exception {
		prodPage = new AddProductPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prodPage.preConditionMethod();
		prodPage.pricePerUnit.sendKeys(prop.getProperty("addproduct.proprties", "testcase5.pricePerUnit"));
		prodPage.quantity.sendKeys(prop.getProperty("addproduct.proprties", "testcase5.quantity"));
		basepage.selectByVisibleTextWebElement(prodPage.selectCategory,
				prop.getProperty("addproduct.proprties", "testcase1.selectCategory"));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//select[@name='vendorId']/option[@value='VID_006']")));
		basepage.selectByValueWebElement(prodPage.selectVendor,
				prop.getProperty("addproduct.proprties", "testcase5.selectVendor"));
		prodPage.saveButton.click();
		prodPage.getValidationMessage(prodPage.productName);

	}

	/*
	 * verify Select Category is blank
	 */
	@Test
	public void product_TC006() throws Exception {
		prodPage = new AddProductPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prodPage.preConditionMethod();
		String uniqueProductName = AddProductPage.generateUniqueProductName("keyboard");
		prodPage.productName.sendKeys(uniqueProductName);
		prodPage.pricePerUnit.sendKeys(prop.getProperty("addproduct.proprties", "testcase5.pricePerUnit"));
		prodPage.quantity.sendKeys(prop.getProperty("addproduct.proprties", "testcase5.quantity"));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//select[@name='vendorId']/option[@value='VID_006']")));
		basepage.selectByValueWebElement(prodPage.selectVendor,
				prop.getProperty("addproduct.proprties", "testcase5.selectVendor"));
		prodPage.saveButton.click();
		String actualErrorMessage = prodPage.getValidationMessage(prodPage.selectCategory);
		Assert.assertEquals(actualErrorMessage, prop.getProperty("addproduct.proprties", "error.message"),
				"messages should be matches");
	}
	
/**
 * test case description check if select category is dropdown
 * @throws Exception
 */
	@Test
	public void product_007() throws Exception {
		prodPage = new AddProductPage(driver);
		prodPage.preConditionMethod();
		Assert.assertTrue(prodPage.isElementEnable(prodPage.selectCategory, "Select Category"),"Dropdown is not enabled");
		boolean disaplayedElemnt = prodPage.isElementDisplayed(prodPage.selectCategory, "Select Category");
		Assert.assertTrue(disaplayedElemnt, "Dropdrown is not displayed");
		prodPage.selectCategory.click();
		Assert.assertTrue(prodPage.checkifDropDownHaveValues(prodPage.selectCategory, "Select Category"),"Select Category do not have any options");
		}

	/**
	 * test case description: check quantity field blank
	 * @throws Exception
	 */
	@Test
	public void product_008() throws Exception {
		prodPage = new AddProductPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prodPage.preConditionMethod();
		String uniqueProductName = AddProductPage.generateUniqueProductName("keyboard");
		prodPage.productName.sendKeys(uniqueProductName);
		prodPage.pricePerUnit.sendKeys(prop.getProperty("addproduct.proprties", "testcase5.pricePerUnit"));
		basepage.selectByVisibleTextWebElement(prodPage.selectCategory,
				prop.getProperty("addproduct.proprties", "testcase1.selectCategory"));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//select[@name='vendorId']/option[@value='VID_006']")));
		basepage.selectByValueWebElement(prodPage.selectVendor,
				prop.getProperty("addproduct.proprties", "testcase5.selectVendor"));
		prodPage.saveButton.click();
		String actualErrorMessage = prodPage.getValidationMessage(prodPage.quantity);
		Assert.assertEquals(actualErrorMessage, prop.getProperty("addproduct.proprties", "numeric.error.message"),
				"messages not matches");
		
	}
	
	/**
	 * test case description: check quantity field does not accept text
	 * @throws Exception
	 */
	@Test
	public void product_009() throws Exception {
		prodPage = new AddProductPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prodPage.preConditionMethod();
		String uniqueProductName = AddProductPage.generateUniqueProductName("keyboard");
		prodPage.productName.sendKeys(uniqueProductName);
		prodPage.pricePerUnit.clear();
		prodPage.pricePerUnit.sendKeys(prop.getProperty("addproduct.proprties", "testcase5.pricePerUnit"));
		basepage.selectByVisibleTextWebElement(prodPage.selectCategory,
				prop.getProperty("addproduct.proprties", "testcase1.selectCategory"));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//select[@name='vendorId']/option[@value='VID_006']")));
		basepage.selectByValueWebElement(prodPage.selectVendor,
				prop.getProperty("addproduct.proprties", "testcase5.selectVendor"));
		prodPage.setTxtForNumericFiledWithJS(prodPage.quantity, prop.getProperty("addproduct.proprties", "testcase9.quantity"));
		prodPage.saveButton.click();
		String actualErrorMessage = prodPage.getValidationMessage(prodPage.quantity);
		Assert.assertEquals(actualErrorMessage, prop.getProperty("addproduct.proprties", "txtToNumericFiled.error.message"),
				"messages not matches");
	}
	
	
	/* TestCase description verify product added with quantity positive number
	 * **/
	
	@Test
	public void product_TC010() throws Exception {
		prodPage = new AddProductPage(driver);
		prodPage.preConditionMethod();
		basepage.waitForVisibilty(prodPage.productName, Duration.ofSeconds(2000), "Product Name");
		prodPage.addProduct();
		Assert.assertTrue(prodPage.verifyThatProductIsAddedWithExistingProductNameMessage());
		ExtentManager.logTestwithPassed("Quantity Field accept posative numbers......");
		
	}
	
	/**
	 * test case description: check quantity field not accept negative numbers
	 * @throws Exception
	 */
	@Test
	public void product_011() throws Exception {
		prodPage = new AddProductPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prodPage.preConditionMethod();
		String uniqueProductName = AddProductPage.generateUniqueProductName("keyboard");
		prodPage.productName.sendKeys(uniqueProductName);
		prodPage.pricePerUnit.sendKeys(prop.getProperty("addproduct.proprties", "testcase5.pricePerUnit"));
		basepage.selectByVisibleTextWebElement(prodPage.selectCategory,
				prop.getProperty("addproduct.proprties", "testcase1.selectCategory"));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//select[@name='vendorId']/option[@value='VID_006']")));
		basepage.selectByValueWebElement(prodPage.selectVendor,
				prop.getProperty("addproduct.proprties", "testcase5.selectVendor"));
		prodPage.quantity.clear();
		prodPage.quantity.sendKeys( prop.getProperty("addproduct.proprties", "testcase10.quantity"));
		prodPage.saveButton.click();
		String actualErrorMessage = prodPage.getValidationMessage(prodPage.quantity);
		Assert.assertEquals(actualErrorMessage, prop.getProperty("addproduct.proprties", "numeric.error.message"),
				"messages not matches");
	
	}
	/*TestCase Descriptions verify Quantity field 0 by default
	 * */
	@Test
	public void product_TC012() throws Exception {
		prodPage = new AddProductPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prodPage.preConditionMethod();
		Assert.assertEquals(prodPage.quantity.getAttribute("value"), "0"," Quantity Defult Value not equal to 0");
		ExtentManager.logTestwithPassed(" Quantity Defult Value equal to 0");
		
	}
	
	/**
	 * test case description: check Price per unit field blank
	 * @throws Exception
	 */
	@Test
	public void product_013() throws Exception {
		prodPage = new AddProductPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prodPage.preConditionMethod();
		String uniqueProductName = AddProductPage.generateUniqueProductName("keyboard");
		prodPage.productName.sendKeys(uniqueProductName);
		prodPage.quantity.clear();
		prodPage.quantity.sendKeys(prop.getProperty("addproduct.proprties", "testcase5.quantity"));
		
		basepage.selectByVisibleTextWebElement(prodPage.selectCategory,
				prop.getProperty("addproduct.proprties", "testcase1.selectCategory"));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//select[@name='vendorId']/option[@value='VID_010']")));
		basepage.selectByValueWebElement(prodPage.selectVendor,
				prop.getProperty("addproduct.proprties", "testcase13.selectVendor"));
		prodPage.pricePerUnit.clear();
		Thread.sleep(6000);
		prodPage.saveButton.click();
		String actualErrorMessage = prodPage.getValidationMessage(prodPage.pricePerUnit);
		Assert.assertEquals(actualErrorMessage, prop.getProperty("addproduct.proprties", "txtToNumericFiled.error.message"),
				"messages not matches");
		
	}
	
	/**
	 * test case description: check Price per unit field not accept text
	 * @throws Exception
	 */
	@Test
	public void product_TC014() throws Exception {
		prodPage = new AddProductPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prodPage.preConditionMethod();
		String uniqueProductName = AddProductPage.generateUniqueProductName("keyboard");
		prodPage.productName.sendKeys(uniqueProductName);
		prodPage.quantity.clear();
		prodPage.quantity.sendKeys(prop.getProperty("addproduct.proprties", "testcase14.quantity"));
		basepage.selectByVisibleTextWebElement(prodPage.selectCategory,
				prop.getProperty("addproduct.proprties", "testcase1.selectCategory"));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//select[@name='vendorId']/option[@value='VID_006']")));
		basepage.selectByValueWebElement(prodPage.selectVendor,
				prop.getProperty("addproduct.proprties", "testcase5.selectVendor"));
		prodPage.pricePerUnit.clear();
		//prodPage.pricePerUnit.sendKeys(prop.getProperty("addproduct.proprties", "testcase14.pricePerUnit"));
		Thread.sleep(2000);
		prodPage.setTxtForNumericFiledWithJS(prodPage.pricePerUnit, "bhj");
		prodPage.saveButton.click();
		String actualErrorMessage = prodPage.getValidationMessage(prodPage.pricePerUnit);
		Assert.assertEquals(actualErrorMessage, prop.getProperty("addproduct.proprties", "txtToNumericFiled.error.message"),
				"messages not matches");
		
	}
	/**
	 * test case description: check Price per unit field not accept negative number
	 * @throws Exception
	 */
	@Test
	public void product_015() throws Exception {
		prodPage = new AddProductPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prodPage.preConditionMethod();
		String uniqueProductName = AddProductPage.generateUniqueProductName("keyboard");
		prodPage.productName.sendKeys(uniqueProductName);
		prodPage.pricePerUnit.sendKeys(prop.getProperty("addproduct.proprties", "testcase5.pricePerUnit"));
		basepage.selectByVisibleTextWebElement(prodPage.selectCategory,
				prop.getProperty("addproduct.proprties", "testcase1.selectCategory"));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//select[@name='vendorId']/option[@value='VID_006']")));
		basepage.selectByValueWebElement(prodPage.selectVendor,
				prop.getProperty("addproduct.proprties", "testcase5.selectVendor"));
		prodPage.quantity.clear();
		prodPage.quantity.sendKeys( prop.getProperty("addproduct.proprties", "testcase15.quantity"));
		prodPage.pricePerUnit.clear();
		prodPage.pricePerUnit.sendKeys( prop.getProperty("addproduct.proprties", "testcase15.pricePerUnit"));
		prodPage.saveButton.click();
		String actualErrorMessage = prodPage.getValidationMessage(prodPage.pricePerUnit);
		Assert.assertEquals(actualErrorMessage, prop.getProperty("addproduct.proprties", "priceNumeric.error.message"),
				"messages not matches");
	}
	
	/*
	 * Test Case description: Verify all filed blank */
	@Test
	public void product_TC016() throws Exception {
		prodPage = new AddProductPage(driver);
		prodPage.preConditionMethod();
		prodPage.saveButton.click();
		String actualErrorMessage = prodPage.getValidationMessage(prodPage.productName);
		Assert.assertEquals(actualErrorMessage, prop.getProperty("addproduct.proprties", "txtToNumericFiled.error.message"),
				"messages not matches");
	}
	
	/*
	 * Test Case description: Verify two mandatory fields blank */
	@Test
	public void product_017() throws Exception {
		prodPage = new AddProductPage(driver);
		prodPage.preConditionMethod();
		prodPage.productName.sendKeys(prop.getProperty("addproduct.proprties", "testcase1.productName"));
		prodPage.quantity.clear();
		prodPage.quantity.sendKeys(prop.getProperty("addproduct.proprties", "testcase1.quantity"));
		prodPage.saveButton.click();
		String actualErrorMesg=prodPage.getValidationMessage(prodPage.selectCategory);
		Assert.assertEquals(actualErrorMesg, prop.getProperty("addproduct.proprties", "error.message"), "Messages not matches");
		
	}
	/*
	 * Test Case description: Verify save button functionality */
	@Test
	public void product_020() throws Exception {
		prodPage = new AddProductPage(driver);
		prodPage.preConditionMethod();
		prodPage.addProduct();
		prodPage.verifyThatProductIsAddedWithExistingProductNameMessage();
		ExtentManager.logTestwithPassed("add button functionality working......");
	}
	/*
	 * Test Case description: Verify cancel button functionality */
	@Test(enabled = false)
	public void product_022() throws Exception {
	
	}
}
	


