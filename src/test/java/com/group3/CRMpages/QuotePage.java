package com.group3.CRMpages;

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
		quotes.click();
	}
	
	
	@FindBy(xpath="//span[normalize-space()='Create Quote']")
	WebElement createQuotesButton;
	
	public void clickCreateQuote() {
		createQuotesButton.click();
	}
		

	@FindBy(xpath="//input[@name='subject']")
	WebElement subject;
	
	@FindBy(xpath="//input[@name='validTill']")
	WebElement validTill;
	
	@FindBy(xpath="//input[@name='quoteStage']")
	WebElement quoteStage;
	
	@FindBy(xpath="(//button[@class='action-button'])[position()=1]")
	WebElement opportunity;
	
	
	public void clickOpportunity() {
		opportunity.click();
	}
	
	
	@FindBy(xpath="(//button[@class='action-button'])[position()=2]")
	WebElement contact;
	
	
	public void clickContact() {
		contact.click();
	}
	
	
	@FindBy(xpath="(//textarea[@name='address'])[1]")
	WebElement biilingAddress;
	
	@FindBy(xpath="(//textarea[@name='address'])[2]")
	WebElement shippingAddress;
	
	
	@FindBy(xpath="(//input[@name='poBox'])[position()=1]")
	WebElement biilingPOBox;
	
	@FindBy(xpath="(//input[@name='poBox'])[position()=2]")
	WebElement shippingPOBox;
	
	
	@FindBy(xpath="(//input[@name='city'])[position()=1]")
	WebElement biilingCity;
	
	@FindBy(xpath="(//input[@name='city'])[position()=2]")
	WebElement shippingCity;
	
	@FindBy(xpath="(//input[@name='state'])[position()=1]")
	WebElement biilingState;
	
	@FindBy(xpath="(//input[@name='state'])[position()=2]")
	WebElement shippingState;
	
	@FindBy(xpath="(//input[@name='postalCode'])[position()=1]")
	WebElement biilingPostalCode;
	
	@FindBy(xpath="(//input[@name='postalCode'])[position()=2]")
	WebElement shippingPostalCode;
	
	@FindBy(xpath="(//input[@name='country'])[position()=1]")
	WebElement biilingCountry;
	
	@FindBy(xpath="(//input[@name='country'])[position()=2]")
	WebElement shippingCountry;
	
	@FindBy(xpath="(//button[@class='action-button'])[position()=3]")
	WebElement addProduct;
	
	
	public void clickAddProduct() {
		addProduct.click();
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
	
	
}
