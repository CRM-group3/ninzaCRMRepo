package com.group3.CRMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.group3.CRMbasics.BasePage;

public class AddContactsPage extends BasePage{

	protected ExtentTest test;

	public AddContactsPage(WebDriver driver, ExtentTest test) {
		super(driver);
	
		PageFactory.initElements(driver, this);
		this.test = test;
	}
	
	
	



	
//	public static void main(String[] args) {
//		
//       
//	}

}
