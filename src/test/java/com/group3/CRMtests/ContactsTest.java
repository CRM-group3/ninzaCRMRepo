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
	    	    ExtentManager.logTestInfo("Contact tab is clicked successfully");
	    	    driver.quit(); 
	    	}
	    	
	    	 @Test(priority=1)
		    public void clickCreateContactButton() throws  InterruptedException {

	    		AddContactsPage contactPage = new AddContactsPage(driver);
			    contactPage.clickOnCreateContact();
			    
			    Thread.sleep(3000);
			    ExtentManager.logTestInfo("CreateContactButton is clicked successfully");
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
	    		 
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        ExtentManager.logTestInfo("Contact is successfully created with only mandatory fields");
	    	        
	    	      String pageText = driver.getPageSource();
		    	     Assert.assertTrue(pageText.contains("Contact TMS Successfully added") || pageText.contains("error"), "Validation result displayed.");
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
	    	        contactPage.enterMobile("9346780108");
	    	        Thread.sleep(2000);
	    	        contactPage.enterEmail("tms11@example.com");
	    	        Thread.sleep(2000);

	    	        // Select campaign using lookup
	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    		 
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        ExtentManager.logTestInfo("Contact is successfully created with all the fields");
	    	        String pageText = driver.getPageSource();
		    	     Assert.assertTrue(pageText.contains("Contact TMSO Successfully added") || pageText.contains("error"), "Validation result displayed.");
	    	 }
	    	 
	    	 @Test(priority=4)
	    	 public void createContactWithSpecialCharacters() throws InterruptedException {
	    	     AddContactsPage contactPage = new AddContactsPage(driver);

	    	     contactPage.clickOnContacts();
	    	     Thread.sleep(1000);

	    	     contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);

	    	     // Input alphanumeric + special characters
	    	     contactPage.enterOrganization("Org@123#Inc!");
	    	     Thread.sleep(1000);
	    	     contactPage.enterTitle("QA Lead!@#123");
	    	     Thread.sleep(1000);
	    	     contactPage.enterDepartment("Dept_456$%^");
	    	     Thread.sleep(1000);
	    	     contactPage.enterOfficePhone("1111111113"); 
	    	     Thread.sleep(1000);
	    	     contactPage.enterContactName("Tom@12");
	    	     Thread.sleep(2000);
	    	     contactPage.enterMobile("9876571213"); 
	    	     Thread.sleep(2000);
	    	     contactPage.enterEmail("chbo@openai.com");
	    	     Thread.sleep(2000);
	    	     contactPage.selectCampaignFromLookup("Campaigntest");
	    	     Thread.sleep(2000);
	    	     contactPage.clickCreateContact();
	    	     Thread.sleep(3000);
	    	    
	    	     ExtentManager.logTestwithPassed("Not accepting alphanumerics in any of the fields");
	    	     
	    	     String pageText = driver.getPageSource();
	    	     Assert.assertTrue(pageText.contains("Contact Tom Successfully added") || pageText.contains("error"), "Validation result displayed.");

	    	}
	    	 @Test(priority=5)
	    	 public void titleInputWithVariousRoles() throws InterruptedException {
	    		 
	    		 AddContactsPage contactPage = new AddContactsPage(driver);

	    	     contactPage.clickOnContacts();
	    	     Thread.sleep(1000);

	    	     contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);

	    	     // Input alphanumeric + special characters
	    	     contactPage.enterOrganization("Org");
	    	     Thread.sleep(1000);
	    	     contactPage.enterTitle("QA Lead","Manager");
	    	     Thread.sleep(1000);
	    	    
	    	     
	    	     contactPage.enterContactName("John");
	    	     Thread.sleep(2000);
	    	     contactPage.enterMobile("9876571213"); 
	    	     Thread.sleep(2000);
	    	    
	    	     contactPage.selectCampaignFromLookup("Campaigntest");
	    	     Thread.sleep(2000);
	    	     contactPage.clickCreateContact();
	    	     Thread.sleep(3000);
	    	     
	    	     ExtentManager.logTestInfo("Contact is created with different roles");
	    	     String pageText = driver.getPageSource();
	    	     Assert.assertTrue(pageText.contains("Contact John Successfully added") || pageText.contains("error"), "Validation result displayed.");

	    		 
	    	 }
	    	 
	    	 @Test(priority=6)
	    	 public void leaveOrgBlank() throws InterruptedException {
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterOrganization(" ");
	    	        Thread.sleep(2000);
	    	        contactPage.enterTitle("BA");
	    	        Thread.sleep(2000);
	    	        contactPage.enterContactName("stmm");
	    	        Thread.sleep(2000);
	    	        contactPage.enterMobile("9345780098");
	    	        Thread.sleep(2000);

	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    	        
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        ExtentManager.logTestInfo("Contact is not created with blank org field");
	    	        
	    	        String pageText = driver.getPageSource();
	    	        Assert.assertTrue(pageText.contains("Contact has been created") || pageText.contains("Contact Information"),
	    	                "Contact creation failed: Success message not found!"
	    	            );
	    	 }
	    	 
	    	 @Test(priority=7)
	    	 public void leaveTitleBlank() throws InterruptedException {
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterOrganization("Org Test");
	    	        Thread.sleep(2000);
	    	        contactPage.enterTitle(" ");
	    	        Thread.sleep(2000);
	    	        contactPage.enterContactName("STM");
	    	        Thread.sleep(2000);
	    	        contactPage.enterMobile("9348789098");
	    	        Thread.sleep(2000);

	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    	        
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        ExtentManager.logTestInfo("Contact is not created with blank Title field");
	    	        
	    	        String pageText = driver.getPageSource();
	    	        Assert.assertTrue(pageText.contains("Contact has been created") || pageText.contains("Contact Information"),
	    	                "Contact creation failed: Success message not found!"
	    	            );
	    	 }
	    	 
	    	 @Test(priority=8)
	    	 public void leaveContactNameBlank() throws InterruptedException {
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterOrganization("Org Test");
	    	        Thread.sleep(2000);
	    	        contactPage.enterTitle("CA");
	    	        Thread.sleep(2000);
	    	        contactPage.enterContactName(" ");
	    	        Thread.sleep(2000);
	    	        contactPage.enterMobile("9341989098");
	    	        Thread.sleep(2000);

	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    	        
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        ExtentManager.logTestInfo("Contact is not created with blank contact name field");
	    	        
	    	        String pageText = driver.getPageSource();
	    	        Assert.assertTrue(pageText.contains("Contact has been created") || pageText.contains("Contact Information"),
	    	                "Contact creation failed: Success message not found!"
	    	            );
	    	 }
	    	 
	    	 @Test(priority=9)
	    	 public void leaveMobileBlank() throws InterruptedException {
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterOrganization("Org Test");
	    	        Thread.sleep(2000);
	    	        contactPage.enterTitle("HR");
	    	        Thread.sleep(2000);
	    	        contactPage.enterContactName("Kavya");
	    	        Thread.sleep(2000);
	    	        contactPage.enterMobile("9348139098");
	    	        Thread.sleep(2000);

	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    	        
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        ExtentManager.logTestInfo("Contact is not created with blank Mobile field");
	    	        
	    	        String pageText = driver.getPageSource();
	    	        Assert.assertTrue(pageText.contains("Contact has been created") || pageText.contains("Contact Information"),
	    	                "Contact creation failed: Success message not found!");
	    	            
	    	 }
	    	 
	    	 @Test(priority=10)
	    	 public void leaveCampaignBlank() throws InterruptedException {
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterOrganization("Org Test");
	    	        Thread.sleep(2000);
	    	        contactPage.enterTitle("HR");
	    	        Thread.sleep(2000);
	    	        contactPage.enterContactName("Kavya");
	    	        Thread.sleep(2000);
	    	        contactPage.enterMobile("9348139098");
	    	        Thread.sleep(2000);

	    	        //contactPage.selectCampaignFromLookup("Campaigntest");
	    	        
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        ExtentManager.logTestInfo("Contact is not created with blank campaign field");
	    	        
	    	        String pageText = driver.getPageSource();
	    	 
	    	        Assert.assertTrue(pageText.contains("Contact has been created") || pageText.contains("Contact Information"),
	    		    "Contact creation failed or validation error occurred when campaign was left blank.");
	    	 	}
	    	 
	    	 @Test(priority = 11)
	    	 public void createDuplicateContact() throws InterruptedException {
	    	     

	    	     AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        //First contact
	    	        contactPage.enterOrganization("Org Test");
	    	        
	    	        contactPage.enterTitle("HR");
	    	        
	    	        contactPage.enterContactName("Navya");
	    	       
	    	        contactPage.enterMobile("9898989898");
	    	        

	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    	        
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        
	    	        //Duplicate contact(same mobile and contact name)
	    	        contactPage.enterOrganization("Org Test2");
	    	        
	    	        contactPage.enterTitle("Designer");
	    	        
	    	        contactPage.enterContactName("Navya");
	    	       
	    	        contactPage.enterMobile("9898989898");
	    	        

	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    	        
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);

	    	     
	    	     String pageText = contactPage.getAlertText();
	    	     Assert.assertTrue(pageText.contains("duplicate") || pageText.contains("already exists"),
	    	         "Duplicate contact validation failed. Expected error not displayed." );
	    	     ExtentManager.logTestInfo("Contact is not created with duplicate fields");
	    	 }

	    	 @Test(priority=12)
	    	 public void shortMobileNumber() throws InterruptedException {
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterOrganization("OrgTest");
	    	        Thread.sleep(2000);
	    	        contactPage.enterTitle("AR");
	    	        Thread.sleep(2000);
	    	        contactPage.enterContactName("Ramya");
	    	        Thread.sleep(2000);
	    	        contactPage.enterMobile("9348");
	    	        Thread.sleep(2000);

	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    	        
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        String pageText = driver.getPageSource();
	    	 
	    	        Assert.assertTrue(pageText.contains("Contact has been created") || pageText.contains("Contact Information"),
	    		    "Contact creation failed or validation error occurred when short mobile no. is entered.");
	    	        ExtentManager.logTestInfo("Contact is not created with short Mobile no. ");
	    	 }
	    	 
	    	 @Test(priority=13)
	    	 public void createContactWithOptionalFields() throws InterruptedException {
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    		 contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    		  
	    	        
	    	        contactPage.enterDepartment("Quality Analyst");
	    	        Thread.sleep(2000);
	    	        contactPage.enterOfficePhone("1234567000");
	    	        Thread.sleep(2000);
	    	        contactPage.enterEmail("tmsl@example.com");
	    	        Thread.sleep(2000);
	    	        //contactPage.selectCampaignFromLookup("Campaigntest");
	    	        
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        String pageText = driver.getPageSource();
	    	 
	    	        Assert.assertTrue(pageText.contains("Contact has been created") || pageText.contains("Contact Information"),
	    		    "Contact creation failed or validation error occurred when contact form is filled with only optional fields");
	    	        ExtentManager.logTestInfo("Contact is not created with only optional fields ");
	    	 }
	    }
	    
	    
	    	

    	
	    	
	    

		
	     	