/*package com.group3.CRMpages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.group3.CRMbasics.BasePage;

public class QuotePage extends BasePage{

	public QuotePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Quotes']")
	WebElement quotes;
	
	public void clickQuotes() {
		waitForElement(quotes, Duration.ofSeconds(3));
		quotes.click();
	}
	
	
	@FindBy(xpath="//span[normalize-space()='Create Quote']")
	WebElement createQuotesButton;
	
	public void clickCreateQuote() {
		waitForElement(quotes, Duration.ofSeconds(3));
		createQuotesButton.click();
	}
		

	@FindBy(xpath="//input[@name='subject']")
	WebElement subject;
	
	public void sendKeysToSubject(String str) {
		subject.sendKeys(str);
	}
	
	@FindBy(xpath="//input[@name='validTill']")
	WebElement validTill;
	
	public void sendKeysToValidTill(String str) {
		validTill.sendKeys(str);
	}
	
	@FindBy(xpath="//input[@name='quoteStage']")
	WebElement quoteStage;
	
	public void sendKeysToQuoteStage(String str) {
		quoteStage.sendKeys(str);
	}
	
	@FindBy(xpath="(//button[@class='action-button'])[position()=1]")
	WebElement opportunity;
	
	
	public void clickOpportunity() {
		opportunity.click();
	}
	
	@FindBy(xpath="//button[contains(@onclick, \"selectOpportunity('OPP00001\")]")
	WebElement opportunitySelectButton;
	
	public void switchOpportunityWindow(WebDriver driver) throws Exception {
		String parentWindow = driver.getWindowHandle();
		
		for(String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		Thread.sleep(2000);
		opportunitySelectButton.click();
		driver.switchTo().window(parentWindow);	
	}
	

	@FindBy(xpath="(//button[@class='action-button'])[position()=2]")
	WebElement contact;
	
	public void clickContact() {
		contact.click();
	}
	
	@FindBy(xpath="//button[contains(@onclick, \"selectContact('CON00001\")]")
	WebElement contactSelectButton;
	
	
	public void switchContactWindow(WebDriver driver) throws Exception {
		String parentWindow = driver.getWindowHandle();
		
		for(String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		Thread.sleep(2000);
		contactSelectButton.click();
		driver.switchTo().window(parentWindow);	
	}
	
	
	@FindBy(xpath="(//textarea[@name='address'])[1]")
	WebElement billingAddress;
	
	public void sendKeysToBillingAddress(String str) {
		billingAddress.sendKeys(str);
	}
	
	@FindBy(xpath="(//textarea[@name='address'])[2]")
	WebElement shippingAddress;
	
	public void sendKeysToShippingAddress(String str) {
		shippingAddress.sendKeys(str);
	}
	
	
	@FindBy(xpath="(//input[@name='poBox'])[position()=1]")
	WebElement billingPOBox;
	
	
	public void sendKeysToBillingPOBox(String str) {
		billingPOBox.sendKeys(str);
	}
	
	@FindBy(xpath="(//input[@name='poBox'])[position()=2]")
	WebElement shippingPOBox;
	
	public void sendKeysToShippingPOBox(String str) {
		shippingPOBox.sendKeys(str);
	}
	
	
	@FindBy(xpath="(//input[@name='city'])[position()=1]")
	WebElement billingCity;
	
	public void sendKeysToBillingCity(String str) {
		billingCity.sendKeys(str);
	}
	
	
	@FindBy(xpath="(//input[@name='city'])[position()=2]")
	WebElement shippingCity;
	
	public void sendKeysToshippingCity(String str) {
		shippingCity.sendKeys(str);
	}
	
	
	
	@FindBy(xpath="(//input[@name='state'])[position()=1]")
	WebElement billingState;
	
	public void sendKeysTobillingState(String str) {
		billingState.sendKeys(str);
	}
	
	
	
	@FindBy(xpath="(//input[@name='state'])[position()=2]")
	WebElement shippingState;
	
	public void sendKeysToshippingState(String str) {
		shippingState.sendKeys(str);
	}
	
	
	@FindBy(xpath="(//input[@name='postalCode'])[position()=1]")
	WebElement billingPostalCode;
	
	public void sendKeysTobillingPostalCode(String str) {
		billingPostalCode.sendKeys(str);
	}
	
	
	@FindBy(xpath="(//input[@name='postalCode'])[position()=2]")
	WebElement shippingPostalCode;
	
	public void sendKeysToshippingPostalCode(String str) {
		shippingPostalCode.sendKeys(str);
	}
	
	
	@FindBy(xpath="(//input[@name='country'])[position()=1]")
	WebElement biilingCountry;
	
	public void sendKeysTobiilingCountry(String str) {
		biilingCountry.sendKeys(str);
	}
	
	
	@FindBy(xpath="(//input[@name='country'])[position()=2]")
	WebElement shippingCountry;
	
	public void sendKeysToshippingCountry(String str) {
		shippingCountry.sendKeys(str);
	}
	
	
	@FindBy(xpath="(//button[@class='action-button'])[position()=3]")
	WebElement addProduct;
	
	
	public void clickAddProduct() {
		addProduct.click();
	}
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchProductByIDField;
	
	public void sendKeysToProductSearch() {
		shippingCountry.sendKeys("IM_PROD_024");
	}
	
	@FindBy(xpath="")
	WebElement productSelectButton;
	
	public void switchProducttWindow(WebDriver driver) throws Exception {
		String parentWindow = driver.getWindowHandle();
		
		for(String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		Thread.sleep(2000);
		searchProductByIDField.sendKeys("IM_PROD_024");
		driver.switchTo().window(parentWindow);	
	}
	
	
	@FindBy(xpath="(//input[@value='$0.00'])[1]")
	WebElement totalAmount;
	
	@FindBy(xpath="//input[@placeholder='Enter discount']")
	WebElement discount;
	
	@FindBy(xpath="//input[@placeholder='Enter shipping charges']")
	WebElement shippingCharges;
	
	@FindBy(xpath="(//input[@value='$0.00'])[2]")
	WebElement grandAmount;
	
	@FindBy(xpath="//button[normalize-space()='Create Quote']")
	WebElement submitCreateQuoteButton;
	
	public void submitCreateQuote() {
		submitCreateQuoteButton.click();
	}
	
	
} */
