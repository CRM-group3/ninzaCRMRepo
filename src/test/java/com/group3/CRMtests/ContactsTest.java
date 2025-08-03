package com.group3.CRMtests;

import com.group3.CRMbasics.BaseTest;
import com.group3.CRMlistners.ExtentManager;
import com.group3.CRMlogs.Logs;
import com.group3.CRMpages.AddContactsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

       
	    public class ContactsTest extends BaseTest {
	    	
	    	@Test(priority=0)
	    	public void clickContacts() throws Throwable {
	    	    
	    		AddContactsPage contactPage = new AddContactsPage(driver);
	    	    contactPage.clickOnContacts();
	    	   
	    	    Thread.sleep(3000);
	    	    
	    	    Assert.assertTrue(driver.getCurrentUrl().contains("/contacts"), "Contacts URL not loaded.");

	    	    ExtentManager.logTestInfo("Contact tab is clicked successfully");
	    	    driver.quit(); 
	    	}
	    	
	    	
	    	@Test(priority=1)
		    public void clickCreateContactButton() throws  InterruptedException {

	    		AddContactsPage contactPage = new AddContactsPage(driver);
			    contactPage.clickOnCreateContact();
			    
			    Thread.sleep(3000);
			    
//			    String pageSource = driver.getPageSource();
//			    Assert.assertTrue(pageSource.contains("Create New Contact"), 
//			        "Create Contact form heading not found.");
//			    ExtentManager.logTestInfo("CreateContactButton is clicked successfully");
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
	    	        contactPage.enterMobile("2346789098");
	    	        Thread.sleep(2000);

	    	        // Select campaign using lookup
	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    		 
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        String pageText = driver.getPageSource();
	    	        Assert.assertTrue(pageText.contains("Contact TMS Successfully Added"),
	    	        	    "Success message for contact creation not displayed.");
	    	        Logs.info("Contact created successfully and success message verified.");
	    	        ExtentManager.logTestInfo("Contact created successfully and success message verified.");

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

	    	        
	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    		 
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        String pageText = driver.getPageSource();
	    	        Assert.assertTrue(pageText.contains("Contact TMSO Successfully Added"),
	    	        	    "Success message for contact creation not displayed.");
	    	        Logs.info("Contact created successfully and success message verified.");
	    	        ExtentManager.logTestInfo("Contact created successfully and success message verified.");

	    	 }
	    	 
	    	 @Test(priority=4)
	    	 public void createContactWithSpecialCharacters() throws InterruptedException {
	    	     AddContactsPage contactPage = new AddContactsPage(driver);

	    	     contactPage.clickOnContacts();
	    	     Thread.sleep(1000);

	    	     contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);

	    	     
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
	    	     contactPage.enterMobile("9879951213"); 
	    	     Thread.sleep(2000);
	    	     contactPage.enterEmail("chbo@openai.com");
	    	     Thread.sleep(2000);
	    	     contactPage.selectCampaignFromLookup("Campaigntest");
	    	     Thread.sleep(2000);
	    	     contactPage.clickCreateContact();
	    	     Thread.sleep(3000);
	    	    
//	    	     	String pageText = driver.getPageSource();
//	    	        Assert.assertTrue(pageText.contains("Contact Tom Successfully Added"),
//	    	        	    "Success message for contact creation not displayed.");
//	    	        Logs.info("Contact created successfully and success message verified.");
//	    	        ExtentManager.logTestInfo("Contact created successfully and success message verified.");

	    	}
	    	 @Test(priority=5)
	    	 public void titleInputWithVariousRoles() throws InterruptedException {
	    		 
	    		 AddContactsPage contactPage = new AddContactsPage(driver);

	    	     contactPage.clickOnContacts();
	    	     Thread.sleep(1000);

	    	     contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);

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
    	     
	    	     
	    	     String pageText = driver.getPageSource();
	    	        Assert.assertTrue(pageText.contains("Contact John Successfully Added"),
	    	        	    "Success message for contact creation not displayed.");
	    	        Logs.info("Contact created successfully and success message verified.");
	    	        ExtentManager.logTestInfo("Contact created successfully and success message verified.");

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
	    	        
	    	        JavascriptExecutor js = (JavascriptExecutor) driver;
	    			String patternMessage = (String) js.executeScript(
	    					"return arguments[0].validationMessage;", contactPage.organization);

	    			System.out.println("Pattern Validation Message: " + patternMessage);

	    			Assert.assertEquals(patternMessage, "Please fill out this field.");
	    			Logs.info("check org field Empty Alert message");
	    			ExtentManager.logTestInfo("check org field Empty Alert message");
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
	    	 
	    	  JavascriptExecutor js = (JavascriptExecutor) driver;
  			String patternMessage = (String) js.executeScript(
  					"return arguments[0].validationMessage;", contactPage.titleField);

  			System.out.println("Pattern Validation Message: " + patternMessage);

  			Assert.assertEquals(patternMessage, "Please fill out this field.");
  			Logs.info("check title field Empty Alert message");
  			ExtentManager.logTestInfo("check title field Empty Alert message");
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
	    	        contactPage.enterMobile("9341009098");
	    	        Thread.sleep(2000);

	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    	        
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        JavascriptExecutor js = (JavascriptExecutor) driver;
	      			String patternMessage = (String) js.executeScript(
	      					"return arguments[0].validationMessage;", contactPage.contactNameField);

	      			System.out.println("Pattern Validation Message: " + patternMessage);

	      			Assert.assertEquals(patternMessage, "Please fill out this field.");
	      			Logs.info("check contactname field Empty Alert message");
	      			ExtentManager.logTestInfo("check contact field Empty Alert message");
	    	        
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
	    	        contactPage.enterMobile(" ");
	    	        Thread.sleep(2000);

	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    	        
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	       
	    	        JavascriptExecutor js = (JavascriptExecutor) driver;
	      			String patternMessage = (String) js.executeScript(
	      					"return arguments[0].validationMessage;", contactPage.mobileField);

	      			System.out.println("Pattern Validation Message: " + patternMessage);

	      			Assert.assertEquals(patternMessage, "Please fill out this field.");
	      			Logs.info("check mobile field Empty Alert message");
	      			ExtentManager.logTestInfo("check mobile field Empty Alert message");
	    	        
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
	    	        
	    	      //div[@class='Toastify__toast Toastify__toast--error']
	    	        
	    	        WebElement campaignErrorMsg = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--error']")); 
	    	        String actualMsg = campaignErrorMsg.getText();

	    	        Assert.assertTrue(actualMsg.contains("Please select a campaign before submitting."),
	    	        	    "Expected error message for missing campaign is not displayed.");

	    	        Logs.info("Validation for missing campaign field verified.");
	    	        ExtentManager.logTestInfo("Validation for missing campaign field verified.");
	    	    }
    	       
//	    	 @Test(priority = 11)
//	    	 public void createDuplicateContact() throws InterruptedException {
//	    	     
//
//	    	     AddContactsPage contactPage = new AddContactsPage(driver);
//	    		 contactPage.clickOnContacts();
//	    		 Thread.sleep(2000);
//	    	        contactPage.clickOnCreateContact();
//	    	        Thread.sleep(2000);
//	    	        
//	    	        //First contact
//	    	        contactPage.enterOrganization("OrgTest");
//	    	        Thread.sleep(2000);
//	    	        contactPage.enterTitle("HR");
//	    	        Thread.sleep(2000);
//	    	        contactPage.enterContactName("Navya");
//	    	        Thread.sleep(2000);
//	    	        contactPage.enterMobile("9898989898");
//	    	        Thread.sleep(2000);
//
//	    	        contactPage.selectCampaignFromLookup("Campaigntest");
//	    	        Thread.sleep(3000);
//	    	        contactPage.clickCreateContact();
//	    	        
//	    	        Thread.sleep(3000);
//	    	        
////	    	        contactPage.clickOnContacts();
////		    		 Thread.sleep(2000);
//	    	        contactPage.clickOnCreateContact();
//	    	        Thread.sleep(2000);
//
//	    	        //Duplicate contact(same mobile and contact name)
//	    	        contactPage.enterOrganization("OrgTest2");
//	    	        Thread.sleep(2000);
//	    	        contactPage.enterTitle("Designer");
//	    	        Thread.sleep(2000);
//	    	        contactPage.enterContactName("Navya");
//	    	        Thread.sleep(2000);
//	    	        contactPage.enterMobile("9898989898");
//	    	        Thread.sleep(2000);
//
//	    	        contactPage.selectCampaignFromLookup("Campaigntest");
//	    	        Thread.sleep(2000);
//	    	        contactPage.clickCreateContact();
//	    	        Thread.sleep(2000);
//	    	        
//	    	        String pageText = driver.getPageSource();
//	    	        
//	    	        
////	    	        WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Mobile: 9898989898 already exists')]"));
////	    	        Assert.assertTrue(errorMsg.isDisplayed(), "Duplicate contact error not displayed.");
//	    	        Assert.assertTrue(pageText.contains("Mobile: 9898989898 already exists"),
//	    	        	    "Success message for contact creation not displayed.");
//	    	        Logs.info("Contact is not created and failure message verified.");
//	    	        ExtentManager.logTestInfo("Contact is not created and failure message verified.");
//	    	     
//	    	 }
	    	 
	    	 @Test(priority=11)
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
	    	        Assert.assertTrue(pageText.contains("Mobile Number must be 10 digits and should contain only digits"),
	    	        	    "Success message for contact creation not displayed.");
	    	        Logs.info("Contact is not created and failure message verified.");
	    	        ExtentManager.logTestInfo("Contact is not created and failure message verified.");
	    	     
	    	        }
  	 
	    	 @Test(priority=12)
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
	    	      
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        JavascriptExecutor js = (JavascriptExecutor) driver;
	    	        String validationMsg = (String) js.executeScript(
	    	                "return arguments[0].validationMessage;", contactPage.contactNameField);

	    	        System.out.println("Validation Message: " + validationMsg);

	    	        // Assertion
	    	        Assert.assertEquals(validationMsg, "Please fill out this field.", 
	    	                "Expected validation message not shown for missing Contact Name");

	    	        Logs.info("Validation for empty Contact Name field verified.");
	    	        ExtentManager.logTestInfo("Validation for empty Contact Name field verified.");
	    	    }
	    	 

	    	 @Test(priority=13)
	    	 public void createContactWithInvalidEmail() throws InterruptedException {
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    		 contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    		  
	    	        contactPage.enterDepartment("Quality Test");
	    	        Thread.sleep(2000);
	    	        contactPage.enterOfficePhone("1230067000");
	    	        Thread.sleep(2000);
	    	        contactPage.enterEmail("@#@example.com");
	    	        Thread.sleep(2000);
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        JavascriptExecutor js = (JavascriptExecutor) driver;
	    	        String validationMsg = (String) js.executeScript(
	    	                "return arguments[0].validationMessage;", contactPage.emailField);

	    	        System.out.println("Validation Message: " + validationMsg);

	    	      //div[@class='error-message']
    	       
	    	        WebElement campaignErrorMsg = driver.findElement(By.xpath("//div[@class='error-message']")); 
	    	        String actualMsg = campaignErrorMsg.getText();
	    	        
	    	        Assert.assertTrue(actualMsg.contains("Please enter a valid email address"),
	    	        	    "Expected error message for missing campaign is not displayed.");
	    	        
//	    	        Assert.assertEquals(validationMsg, "Please fill out this field", 
//	    	                "Expected validation message not shown for missing Contact Name");

	    	        Logs.info("Validation for invalid email field verified.");
	    	        ExtentManager.logTestInfo("Validation for invalid email field verified.");
	    	    }
	    	        
	    	        
	    	 @Test(priority = 14)
	    	 public void verifyContactIdIsAutoGeneratedAndUnique() throws InterruptedException {
	    	     AddContactsPage contactPage = new AddContactsPage(driver);
	    	     contactPage.clickOnContacts();
	    	     Thread.sleep(2000);
	    	     contactPage.clickOnCreateContact();
	    	     Thread.sleep(2000);

	    	     contactPage.enterOrganization("Test Org");
	    	     contactPage.enterTitle("QA Tester");
	    	     contactPage.enterDepartment("QA");
	    	     contactPage.enterOfficePhone("1234567890");
	    	     contactPage.enterContactName("JohnAuto");
	    	     contactPage.enterMobile("9876588210");
	    	     contactPage.enterEmail("john.auto@exampl.com");

	    	     contactPage.selectCampaignFromLookup("Campaigntest");

	    	     contactPage.clickCreateContact();
	    	     Thread.sleep(3000);

	    	     String contactId = contactPage.getGeneratedContactId();  
	    	     System.out.println("Generated Contact ID: " + contactId);

	    	     Assert.assertNotNull(contactId, "Contact ID is null.");
	    	     Assert.assertFalse(contactId.trim().isEmpty(), "Contact ID is empty.");
	    	     Logs.info("Contact ID is generated: " + contactId);
	    	     ExtentManager.logTestInfo("Contact ID is auto-generated: " + contactId);

	    	     driver.quit();
	    	 }
	    	 
//	    	 @Test(priority = 16)
//	    	 public void verifyCampaignLookupIsPopulated() throws InterruptedException {
//	    	     AddContactsPage contactPage = new AddContactsPage(driver);
//
//	    	     contactPage.clickOnContacts();
//	    	     Thread.sleep(2000);
//
//	    	     contactPage.clickOnCreateContact();
//	    	     Thread.sleep(2000);
//
//	    	     // Click on Campaign Lookup
//	    	     contactPage.selectCampaignFromLookup("Campaigntest"); // You should implement this in your Page class
//	    	    // Thread.sleep(4000);  // Wait for lookup to open
//	    	     new WebDriverWait(driver, Duration.ofSeconds(10))
//	    	     .until(ExpectedConditions.presenceOfElementLocated(By.id("campaign-table")));
//	    	     // Switch to new window if lookup opens in popup
//	    	     String parentWindow = driver.getWindowHandle();
//	    	     for (String handle : driver.getWindowHandles()) {
//	    	         if (!handle.equals(parentWindow)) {
//	    	             driver.switchTo().window(handle);
//	    	             break;
//	    	         }
//	    	     }
//	    	  
//	    	     // Wait and fetch campaign list elements
//	    	     List<WebElement> campaignList = driver.findElements(By.xpath("//table[@id='campaign-table']//tr"));  // Update locator
//	    	     
//	    	    
//	    	     
//	    	     // Validate campaign list is not empty
//	    	     Assert.assertTrue(campaignList.size() > 1, "Campaign list is empty or not populated.");
//	    	     Logs.info("Campaign lookup is populated with " + (campaignList.size() - 1) + " entries.");
//	    	     ExtentManager.logTestInfo("Campaign lookup shows " + (campaignList.size() - 1) + " campaigns.");
//
//	    	     // Close popup and switch back
//	    	     driver.close();
//	    	     driver.switchTo().window(parentWindow);
//	    	     
//	    	}
	    	 @Test(priority=15)
	    	 public void createContactWithvalidDept() throws InterruptedException {
	    	       
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterOrganization("Testing");
	    	        Thread.sleep(2000);
	    	        contactPage.enterTitle("QAEng");
	    	        Thread.sleep(2000);
	    	        contactPage.enterDepartment("IT");
	    	        Thread.sleep(2000);
	    	        contactPage.enterContactName("RRYN");
	    	        Thread.sleep(2000);
	    	        contactPage.enterMobile("2346449098");
	    	        Thread.sleep(2000);

	    	        // Select campaign using lookup
	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    		 
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        String pageText = driver.getPageSource();
	    	        Assert.assertTrue(pageText.contains("Contact RRYN Successfully Added"),
	    	        	    "Success message for contact creation not displayed.");
	    	        Logs.info("Contact created successfully and success message verified.");
	    	        ExtentManager.logTestInfo("Contact created successfully and success message verified.");

    	    }
	    	 
	    	 @Test(priority=16)
	    	 public void createContactWithvalidEmailFormat() throws InterruptedException {
	    	       
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterOrganization("Testings");
	    	        Thread.sleep(2000);
	    	        contactPage.enterTitle("QAEngn");
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterContactName("RBYN");
	    	        Thread.sleep(2000);
	    	        contactPage.enterMobile("2366449198");
	    	        Thread.sleep(2000);
	    	        contactPage.enterEmail("robin@yahoo.com");
	    	        Thread.sleep(2000);

	    	        // Select campaign using lookup
	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    		 
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        String pageText = driver.getPageSource();
	    	        Assert.assertTrue(pageText.contains("Contact RBYN Successfully Added"),
	    	        	    "Success message for contact creation not displayed.");
	    	        Logs.info("Contact created successfully and success message verified.");
	    	        ExtentManager.logTestInfo("Contact created successfully and success message verified.");

    	    }
	    	 
	    	 @Test(priority=17)
	    	 public void createContactWithvalidMobile() throws InterruptedException {
	    	       
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterOrganization("Testings");
	    	        Thread.sleep(2000);
	    	        contactPage.enterTitle("QAEngn");
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterContactName("RBYSN");
	    	        Thread.sleep(2000);
	    	        contactPage.enterMobile("2367449198");
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    		 
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        String pageText = driver.getPageSource();
	    	        Assert.assertTrue(pageText.contains("Contact RBYSN Successfully Added"),
	    	        	    "Success message for contact creation not displayed.");
	    	        Logs.info("Contact created successfully and success message verified.");
	    	        ExtentManager.logTestInfo("Contact created successfully and success message verified.");

    	    }
	    	 
	    	 @Test(priority=18)
	    	 public void createContactWithvalidOffice() throws InterruptedException {
	    	       
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterOrganization("Testings");
	    	        Thread.sleep(2000);
	    	        contactPage.enterTitle("QAEngn");
	    	        Thread.sleep(2000);
	    	        contactPage.enterOfficePhone("7767449198");
	    	        Thread.sleep(2000);
	    	        contactPage.enterContactName("RBYLN");
	    	        Thread.sleep(2000);
	    	        contactPage.enterMobile("2360449198");
	    	        Thread.sleep(2000);

	    	        contactPage.selectCampaignFromLookup("Campaigntest");
	    		 
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        String pageText = driver.getPageSource();
	    	        Assert.assertTrue(pageText.contains("Contact RBYLN Successfully Added"),
	    	        	    "Success message for contact creation not displayed.");
	    	        Logs.info("Contact created successfully and success message verified.");
	    	        ExtentManager.logTestInfo("Contact created successfully and success message verified.");

    	    }
	    	 
	    	 @Test(priority=19)
	    	 public void createContactWithAllFieldsBlank() throws InterruptedException {
	    	 
	    		 AddContactsPage contactPage = new AddContactsPage(driver);
	    		 contactPage.clickOnContacts();
	    		 Thread.sleep(2000);
	    	        contactPage.clickOnCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        contactPage.enterOrganization(" ");
	    	        Thread.sleep(2000);
	    	        contactPage.enterTitle(" ");
	    	        Thread.sleep(2000);
	    	        contactPage.enterDepartment(" ");
	    	        Thread.sleep(2000);
	    	        contactPage.enterOfficePhone(" ");
	    	        Thread.sleep(2000);
	    	        contactPage.enterContactName(" ");
	    	        Thread.sleep(2000);
	    	        contactPage.enterMobile(" ");
	    	        Thread.sleep(2000);
	    	        contactPage.enterEmail(" ");
	    	        Thread.sleep(2000);

	    	        
	    	        //contactPage.selectCampaignFromLookup("Campaigntest");
	    		 
	    	        contactPage.clickCreateContact();
	    	        Thread.sleep(2000);
	    	        
	    	        JavascriptExecutor js = (JavascriptExecutor) driver;
	    	        String validationMsg = (String) js.executeScript(
	    	                "return arguments[0].validationMessage;", contactPage.contactNameField);

	    	        System.out.println("Validation Message: " + validationMsg);

	    	        // Assertion
	    	        Assert.assertEquals(validationMsg, "Please fill out this field.", 
	    	                "Expected validation message not shown for missing Contact Name");

	    	        Logs.info("Validation for empty Contact Name field verified.");
	    	        ExtentManager.logTestInfo("Validation for empty Contact Name field verified.");
	    	    }
	    	 
	    } 
	    	 
	    	


	    
	    	        

  	     
	    
	    	

    	
	    	
	    

		
	     	