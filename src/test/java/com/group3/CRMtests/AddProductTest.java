package com.group3.CRMtests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	PropertiesFile prop= new PropertiesFile();

	/*
	 * verify system generated auto
product ID and unique */
	@Test
	public void product_TC001() throws Exception {
		
		prodPage = new AddProductPage(driver);
		prodPage.preConditionMethod();
		basePage.waitForVisibilty(prodPage.productName, Duration.ofSeconds(2000), "Product Name");
		String uniqueProductName1 =AddProductPage.generateUniqueProductName("Laptop");

		//basePage.elementSendText(prodPage.productName,prop.getProperty("addproduct.proprties", "testcase1.productName") , "addproduct.proprties");
		prodPage.productName.sendKeys(uniqueProductName1);
		basePage.elementSendText(prodPage.quantity, prop.getProperty("addproduct.proprties", "testcase1.quantity"), "addproduct.proprties");
		basePage.elementSendText(prodPage.pricePerUnit, prop.getProperty("addproduct.proprties", "testcase1.pricePerUnit"), "addproduct.proprties");
		basePage.selectByVisibleTextWebElement(prodPage.selectCategory, prop.getProperty("addproduct.proprties", "testcase1.selectCategory"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(
		    By.xpath("//select[@name='vendorId']/option[@value='VID_004']")));
		basePage.selectByValueWebElement(prodPage.selectVendor, prop.getProperty("addproduct.proprties","testcase1.selectVendor"));
		//basePage.selectByIndex(prodPage.selectVendor, Integer.parseInt(prop.getProperty("addproduct.proprties","testcase1.selectVendor")));
		basePage.clickbutton(prodPage.saveButton, "Save");
		
		// Wait for the product table to be visible
		wait.until(ExpectedConditions.visibilityOf(prodPage.productTable));

		try {
		    // Locate the search input box (update locator if different)
			wait.until(ExpectedConditions.presenceOfElementLocated(
				    By.xpath("//select[@class='form-control']//option[@value='productName']")));
				basePage.selectByValueWebElement(prodPage.searchForProdect, "productName");
				//basePage.elementSendText(prodPage.addTextToSearchBox, prop.getProperty("addproduct.proprties", "testcase1.productName"), "addproduct.proprties");
				prodPage.addTextToSearchBox.sendKeys(uniqueProductName1);

		    // Wait until the filtered row appears
		    wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//table//tr[td[contains(text(),'" + uniqueProductName1 + "')]]")));

		    // Locate the filtered row
		    WebElement row = driver.findElement(By.xpath("//table//tr[td[contains(text(),'" + uniqueProductName1 + "')]]"));

		    // Get the Product ID cell (assuming first column)
		    WebElement productIdCell = row.findElement(By.xpath("./td[1]"));

		    // Extract and trim the product ID text
		    String generatedProductId = productIdCell.getText().trim();

		    // Validate Product ID
		    if (generatedProductId != null && !generatedProductId.isEmpty()) {
		        ExtentManager.logTestwithPassed("System generated Product ID: " + generatedProductId);
		        Assert.assertFalse(generatedProductId.isBlank(), "Product ID is blank");
		    } else {
		        ExtentManager.logTestwithFailed("Product ID is missing");
		        Assert.fail("Product ID was not generated");
		    }

		} catch (Exception e) {
		    ExtentManager.logTestwithFailed("Could not locate the product row: " + e.getMessage());
		    Assert.fail("Product row not found");
		}

	}
	/*
	 * product ID field is read only and not accept any input*/
	
	@Test
	public void product_TC003() throws Exception {
		prodPage= new AddProductPage(driver);
		prodPage.preConditionMethod();
		prodPage.verifyProductIdReadOnly(prodPage.productIdFiled, "Product ID");
		prodPage.verifyFieldDoesNotAcceptInput(prodPage.productIdFiled, "Product ID");
		
	}
	
	/*
	 * verify product name is blank*/
	@Test
	public void product_TC005() throws Exception {
		prodPage = new AddProductPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prodPage.preConditionMethod();
		prodPage.pricePerUnit.sendKeys(prop.getProperty("addproduct.proprties", "testcase5.pricePerUnit"));
		prodPage.quantity.sendKeys(prop.getProperty("addproduct.proprties", "testcase5.quantity"));
		basePage.selectByVisibleTextWebElement(prodPage.selectCategory,
				prop.getProperty("addproduct.proprties", "testcase1.selectCategory"));
		wait.until(ExpectedConditions.presenceOfElementLocated(
		    By.xpath("//select[@name='vendorId']/option[@value='VID_006']")));
		basePage.selectByValueWebElement(prodPage.selectVendor, prop.getProperty("addproduct.proprties","testcase5.selectVendor"));
		prodPage.saveButton.click();
		prodPage.getValidationMessage(prodPage.productName);
		
	}
	
	/*
	 * verify Select Category is blank*/
	@Test
	public void product_TC006() throws Exception {
		prodPage = new AddProductPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prodPage.preConditionMethod();
		String uniqueProductName =AddProductPage.generateUniqueProductName("keyboard");
		prodPage.productName.sendKeys(uniqueProductName);
		prodPage.pricePerUnit.sendKeys(prop.getProperty("addproduct.proprties", "testcase5.pricePerUnit"));
		prodPage.quantity.sendKeys(prop.getProperty("addproduct.proprties", "testcase5.quantity"));
		wait.until(ExpectedConditions.presenceOfElementLocated(
		    By.xpath("//select[@name='vendorId']/option[@value='VID_006']")));
		basePage.selectByValueWebElement(prodPage.selectVendor, prop.getProperty("addproduct.proprties","testcase5.selectVendor"));
		prodPage.saveButton.click();
		String actualErrorMessage=prodPage.getValidationMessage(prodPage.selectCategory);
		assertEquals(actualErrorMessage,prop.getProperty("addproduct.proprties", "error.message"), "messages should be matches");
		System.out.println(prop.getProperty("addproduct.proprties", "error.message"));
	}
	
	
	

}
