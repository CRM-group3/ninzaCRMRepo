package com.group3.CRMtests;

import com.group3.CRMbasics.BaseTest;
import com.group3.CRMlistners.ExtentManager;
import com.group3.CRMpages.AddContactsPage;
import com.group3.CRMpages.LoginPage;
import com.group3.CRMutilities.PropertiesFile;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
	import com.aventstack.extentreports.ExtentTest;

	    
	    public class ContactsTest extends BaseTest {

		 PropertiesFile prop = new PropertiesFile(); 
		   
		    @Test(priority=1)
		    public void clickContacts() throws InterruptedException {
		    	
		    	AddContactsPage contactPage = new AddContactsPage(getDriver(), testlog);
		        
		        try {
		            boolean clicked = contactPage.clickOnContacts(getDriver());
		            if (clicked) {
		                System.out.println("Contacts tab clicked successfully.");
		            } else {
		                System.out.println("Failed to click Contacts tab.");
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        Thread.sleep(3000);
		     driver.quit();
		    }
		    
//		    @Test(priority = 2)
//		    public void clickCreateContactButton() throws  InterruptedException {
//		    	
//		        AddContactsPage contactPage = new AddContactsPage(getDriver(), testlog);
//		    	try {
//		            boolean clicked = contactPage.clickOnCreateContact(getDriver());
//		            if (clicked) {
//		                
//		                testlog.pass("Create Contact button clicked successfully.");
//		            } else {
//		                
//		                testlog.fail("Failed to click Create Contact button.");
//		            }
//		        } catch (Exception e) {
//		            e.printStackTrace();
//		            testlog.fail("Exception occurred: " + e.getMessage());
//		        }
//
//		        Thread.sleep(3000);
//		        driver.quit();
//		    }
	    }


	


