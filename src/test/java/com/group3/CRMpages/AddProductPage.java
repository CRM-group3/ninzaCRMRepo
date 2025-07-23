package com.group3.CRMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {
	WebDriver driver;
	public  AddProductPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()=\"Products\"]")
	public WebElement productsPage;

	
	

}
