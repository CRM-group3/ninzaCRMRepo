package com.group3.CRMtests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.group3.CRMbasics.BaseTest;
import com.group3.CRMlistners.ExtentManager;
import com.group3.CRMlogs.Logs;

import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMutilities.ScreenShots;


import com.group3.CRMutilities.Excel;

import com.group3.CRMpages.LeadPage;



public class LeadTest extends BaseTest{
	//WebDriver driver;
	PropertiesFile prop;
	ScreenShots screensht = new ScreenShots();
	


	
	//public int openLeadsPage() throws InterruptedException //returns 0 if successful and 1 if not

	@Test
	public void openLeadsPageTest() //returns 0 if successful and 1 if not

	{
		
		ExtentManager.logTestInfo("Opening Lead Page");
		Logs.info("OPening Lead Page");
		LeadPage lp = new LeadPage(driver);
		Assert.assertTrue(lp.openLeadsPage(), "Failed to open Leads Page");
	}
	
	
	
	@Test
	public void openCreateLeadPageTest() throws Exception  
	{
		
		ExtentManager.logTestInfo("Opening Lead Page");
		Logs.info("OPening Lead Page");
		LeadPage leadPage = new LeadPage(driver);
	    boolean isOpened = leadPage.openCreateLeadPage();
	    Assert.assertTrue(isOpened, "Create Lead page did not open successfully");

	}
	
	@Test(enabled=true)
	@Parameters({"campaignName"})	
	public void saveWithMandatoryFields(@Optional("Roshal") String campaignName) throws Exception
	{
		
			LeadPage lp = new LeadPage(driver);
		    boolean isOpened = lp.openCreateLeadPage();
		    Assert.assertTrue(isOpened, "Create Lead page did not open successfully");
		    String leadName = lp.enterDataReqdFields(campaignName);		    		
			Thread.sleep(500); 
			String toast = lp.captureToastifyTopRightMessage();
			System.out.println("Toast Msg"+toast);
			Logs.info("Toast Msg"+toast);
			ExtentManager.logTestInfo("Toast Msg"+toast);			
			Assert.assertEquals(toast,"Leads "+ leadName+" Successfully Added","Error while adding a lead");
								
	}
	
	@Test
	@Parameters({"campaignName"})
	public void saveWithAllFields(@Optional("Roshal") String campaignName) throws Exception
	{
		LeadPage lp = new LeadPage(driver);
	    boolean isOpened = lp.openCreateLeadPage();
	    Assert.assertTrue(isOpened, "Create Lead page did not open successfully");
	    
	    String leadName = lp.enterDataAllFields(campaignName);			
		Thread.sleep(500); 
		String toast = lp.captureToastifyTopRightMessage();
		System.out.println("Toast Msg"+toast);
		Logs.info("Toast Msg"+toast);
		ExtentManager.logTestInfo("Toast Msg"+toast);			
		Assert.assertEquals(toast,"Lead "+ leadName+" Successfully Added","Error while adding a lead");
							
	}
	
	@Test(enabled=false)
	public void chkPromptMsgsWhenReqdFieldsLeftBlank() throws InterruptedException
	{
	
		LeadPage leadPage = new LeadPage(driver);
	    boolean isOpened = leadPage.openCreateLeadPage();
	    Assert.assertTrue(isOpened, "Create Lead page did not open successfully");
		//ExtentManager.logTestInfo("opened CreateLead Page");
		//Logs.info("opened CreateLead Page");
        String filePath = prop.getProperty("inputfilepath.properties", "LeadTestDataFilePath");
        String sheetName = "Sheet1";
        String columnName = "FieldsInCreateLeadPage";
        int headerRow = 0;

        List<String> fields = Excel.getColumnValues(filePath, sheetName, columnName, headerRow);
        
        for (String val : fields) {
            System.out.println("Field value: " + val);
                       
        }				
	}
	
	@Test
	@Parameters({"campaignName"})
	public void reqdField_LeadName(@Optional("Roshal") String campaignName) throws Exception
	{
		
		LeadPage lp = new LeadPage(driver);
	    boolean isOpened = lp.openCreateLeadPage();
	    Assert.assertTrue(isOpened, "Create Lead page did not open successfully");
	    
	    lp.reqFieldLeftBlank("LeadName", campaignName);	
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    String promptMsg = (String) js.executeScript("return arguments[0].validationMessage;",lp.leadName);
	    System.out.println("Pattern Validation Message: " + promptMsg);
	    Assert.assertEquals(promptMsg,"Please fill out this field.","prompt to fill out lead name not shown");

	} 
	
	
	@Test
	@Parameters({"campaignName"})
	public void reqdField_Status(@Optional("Roshal") String campaignName) throws Exception
	{
		
		LeadPage lp = new LeadPage(driver);
	    boolean isOpened = lp.openCreateLeadPage();
	    Assert.assertTrue(isOpened, "Create Lead page did not open successfully");
	    
	    lp.reqFieldLeftBlank("Status",campaignName);	
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    String promptMsg = (String) js.executeScript("return arguments[0].validationMessage;",lp.leadStatus);
	    System.out.println("Pattern Validation Message: " + promptMsg);
	    Assert.assertEquals(promptMsg,"Please fill out this field.","prompt to fill out lead status not shown");

	} 
	
	@Test
	@Parameters({"campaignName"})
	public void reqdField_Company(@Optional("Roshal") String campaignName) throws Exception
	{
		
		LeadPage lp = new LeadPage(driver);
	    boolean isOpened = lp.openCreateLeadPage();
	    Assert.assertTrue(isOpened, "Create Lead page did not open successfully");
	    
	    lp.reqFieldLeftBlank("Company",campaignName);	
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    String promptMsg = (String) js.executeScript("return arguments[0].validationMessage;",lp.leadCompany);
	    System.out.println("Pattern Validation Message: " + promptMsg);
	    Assert.assertEquals(promptMsg,"Please fill out this field.","prompt to fill out lead company not shown");

	} 
	
	@Test
	@Parameters({"campaignName"})
	public void reqdField_Source(@Optional("Roshal") String campaignName) throws Exception
	{
		
		LeadPage lp = new LeadPage(driver);
	    boolean isOpened = lp.openCreateLeadPage();
	    Assert.assertTrue(isOpened, "Create Lead page did not open successfully");
	    
	    lp.reqFieldLeftBlank("Source",campaignName);	
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    String promptMsg = (String) js.executeScript("return arguments[0].validationMessage;",lp.leadSource);
	    System.out.println("Pattern Validation Message: " + promptMsg);
	    Assert.assertEquals(promptMsg,"Please fill out this field.","prompt to fill out lead source not shown");

	} 
	
	@Test
	@Parameters({"campaignName"})
	public void reqdField_Industry(@Optional("Roshal") String campaignName) throws Exception
	{
		
		LeadPage lp = new LeadPage(driver);
	    boolean isOpened = lp.openCreateLeadPage();
	    Assert.assertTrue(isOpened, "Create Lead page did not open successfully");
	    
	    lp.reqFieldLeftBlank("Industry",campaignName);	
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    String promptMsg = (String) js.executeScript("return arguments[0].validationMessage;",lp.leadIndustry);
	    System.out.println("Pattern Validation Message: " + promptMsg);
	    Assert.assertEquals(promptMsg,"Please fill out this field.","prompt to fill out lead industry not shown");

	} 
	
	
	@Test
	@Parameters({"campaignName"})
	public void reqdField_Phone(@Optional("Roshal") String campaignName) throws Exception
	{
		
		LeadPage lp = new LeadPage(driver);
	    boolean isOpened = lp.openCreateLeadPage();
	    Assert.assertTrue(isOpened, "Create Lead page did not open successfully");
	    
	    lp.reqFieldLeftBlank("Campaign",campaignName);	
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    String promptMsg = (String) js.executeScript("return arguments[0].validationMessage;",lp.campaignTextField);
	    System.out.println("Pattern Validation Message: " + promptMsg);
	    Assert.assertEquals(promptMsg,"Please fill out this field.","prompt to fill out campaign TextField not shown");

	} 
	
	@Test
	public void testPrimaryEmailFieldValidations() throws Exception {
	    //WebElement emailInput = driver.findElement(By.name("email"));
		
		LeadPage lp = new LeadPage(driver);
	    boolean isOpened = lp.openCreateLeadPage();
	    Assert.assertTrue(isOpened, "Create Lead page did not open successfully");

	    List<String> testInputs = Arrays.asList(
	        "",                // empty
	        "plainaddress",    // missing '@'
	        "user@.com",       // domain issue
	        "user@domain",     // no TLD
	        "user@domain.com"  // valid
	    );

	    Map<String, String> results = lp.validateEmailInputs(driver, lp.email, testInputs);
	    lp.printValidationResults(results);
	}
	
	
	@Test
	public void testSecondaryEmailFieldValidations() throws Exception {
	    //WebElement emailInput = driver.findElement(By.name("email"));
		
		LeadPage lp = new LeadPage(driver);
	    boolean isOpened = lp.openCreateLeadPage();
	    Assert.assertTrue(isOpened, "Create Lead page did not open successfully");

	    List<String> testInputs = Arrays.asList(
	        "",                // empty
	        "plainaddress",    // missing '@'
	        "user@.com",       // domain issue
	        "user@domain",     // no TLD
	        "user@domain.com"  // valid
	    );

	    Map<String, String> results = lp.validateEmailInputs(driver, lp.secondaryEmail, testInputs);
	    lp.printValidationResults(results);
	}
	    
	@Test
	@Parameters({"campaignName"})
	public void checkDefaultValues_RatingEmpRev(@Optional("Roshal") String campaignName) throws InterruptedException
	{
		LeadPage lp = new LeadPage(driver);
	    boolean isOpened = lp.openCreateLeadPage();
	    Assert.assertTrue(isOpened, "Create Lead page did not open successfully");
	    String lname = lp.chkDefaultEntries_RatingEmpRev(campaignName);
	    lp.searchLeadTableEditLeadByName(lname);
	    Thread.sleep(2000);
	    String lRating=lp.getText(lp.leadRating);
	    Assert.assertEquals(lRating, 0, "Default value in rating is not 0");
	   
	    String annualRev=lp.getText(lp.annualRevenue);
	    Assert.assertEquals(annualRev, 0, "Default value in anuual revenue is not 0");
	    
	    String numOfEmp=lp.getText(lp.noOfEmployees);
	    Assert.assertEquals(numOfEmp, 1, "Default value in num of employees is not 1");
	       
	    
	}
	
}	
	


//	@Test
//	public void test() {
//		System.out.println("I am in a test");
//	}
//	
//		
//}

