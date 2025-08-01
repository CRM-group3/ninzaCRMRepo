package com.group3.CRMtests;

import com.group3.CRMbasics.BaseTest;
import com.group3.CRMlistners.ExtentManager;
import com.group3.CRMlogs.Logs;
import com.group3.CRMpages.AddContactsPage;
import com.group3.CRMutilities.PropertiesFile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

       
	    
	    public class ContactsTest extends BaseTest {
	    	
	    	@Test(priority=0)
	    	public void clickContacts() throws Throwable {
	    	    
	    		AddContactsPage contactPage = new AddContactsPage(driver);
	    	    contactPage.clickOnContacts();
	    	    Thread.sleep(3000);
	    	    driver.quit(); 
	    	}
	    	
	    	 @Test(priority=1)
		    public void clickCreateContactButton() throws  InterruptedException {

	    		AddContactsPage contactPage = new AddContactsPage(driver);
			    contactPage.clickOnCreateContact();
			    Thread.sleep(3000);
			    driver.quit(); 
			   
	    	 }
	    	 
	    	 @Test(priority=2)    	 
	    	 public void createContactWithMandatoryFields() throws InterruptedException {
	    	       
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterOrganization("Test Org");
	    	        Thread.sleep(2000);
	    	        contactPage.enterTitle("QAEngineer");
	    	        Thread.sleep(2000);
	    	        contactPage.enterContactName("TMS");
	    	        Thread.sleep(2000);
	    	        contactPage.enterMobile("9346789998");
	    	        Thread.sleep(2000);

	    	        // Select campaign using lookup
	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    		 
//	    	
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
//	    	        String actualMessage = contactPage.getSuccessMessage();
//	    	        Assert.assertEquals(actualMessage, "Contact TMS created successfully");
	    	    }
	    	 
	    	 
	    	}
			    	
	    	  
	    	

    	
	    	
	    

		
//	     	