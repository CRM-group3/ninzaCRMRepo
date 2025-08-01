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
	    	        contactPage.enterMobile("9346789098");
	    	        Thread.sleep(2000);

	    	        // Select campaign using lookup
	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    		 
//	    	
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
//	    	        String actualMessage = contactPage.getSuccessMessage();
//	    	        Assert.assertEquals(actualMessage, "Contact TMS created successfully");
	    	    }
	    	 @Test(priority=3)
	    	 public void createContactWithAllFields() throws InterruptedException {
	    	 
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterOrganization("Test Org");
	    	        Thread.sleep(2000);
	    	        contactPage.enterTitle("QAEngineer");
	    	        Thread.sleep(2000);
	    	        contactPage.enterDepartment("Quality Assurance");
	    	        Thread.sleep(2000);
	    	        contactPage.enterOfficePhone("1234567890");
	    	        Thread.sleep(2000);
	    	        contactPage.enterContactName("TMSO");
	    	        Thread.sleep(2000);
	    	        contactPage.enterMobile("9346789108");
	    	        Thread.sleep(2000);
	    	        contactPage.enterEmail("tms1@example.com");
	    	        Thread.sleep(2000);

	    	        // Select campaign using lookup
	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    		 
//	    	
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	 }
	    	 
	    	 @Test(priority=4)
	    	 public void createContactWithSpecialCharacters() throws InterruptedException {
	    	     AddContactsPage contactPage = new AddContactsPage(driver);

	    	     contactPage.clickOnContacts();
	    	     Thread.sleep(1000);

	    	     contactPage.clickCreateContact();
	    	     Thread.sleep(1000);

	    	     // Input alphanumeric + special characters
	    	     contactPage.enterOrganization("Org@123#Inc!");
	    	     Thread.sleep(2000);
	    	     contactPage.enterTitle("QA Lead!@#123");
	    	     Thread.sleep(2000);
	    	     contactPage.enterDepartment("Dept_456$%^");
	    	     Thread.sleep(2000);
	    	     contactPage.enterOfficePhone("1234567890@#"); 
	    	     Thread.sleep(2000);
	    	     contactPage.enterContactName("Sowmya@123!");
	    	     Thread.sleep(2000);
	    	     contactPage.enterMobile("98765!@#"); 
	    	     Thread.sleep(2000);
	    	     contactPage.enterEmail("crm@openai.com");
	    	     Thread.sleep(2000);
	    	     contactPage.selectCampaignFromLookup("Campaigntest");
	    	     Thread.sleep(2000);
	    	     contactPage.clickCreateContact();
	    	     Thread.sleep(3000);
	    	}
			    	
	    }	  
	    	

    	
	    	
	    

		
//	     	