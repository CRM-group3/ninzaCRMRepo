package com.group3.CRMtests;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.group3.CRMbasics.BaseTest;
import com.group3.CRMlistners.ExtentManager;
import com.group3.CRMlogs.Logs;
import com.group3.CRMpages.OpportunityPage;


public class OpportunityTest extends BaseTest{
	
	
	OpportunityPage oppo;
	@Test public void opportunity() throws InterruptedException 
	{
	 ExtentManager.logTestInfo("Test case 1 :Opening opportunity Page , form loads correctly"); 
	Logs.info("OPening opportunity Page"); 
	oppo=new OpportunityPage(driver); 
	basepage.waitForElement(oppo.opportunity, Duration.ofSeconds(2000)); 
	oppo.clickOpportunity(); 
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	WebElement header = wait.until(ExpectedConditions .visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Opportunities')]"))); 
	Assert.assertTrue(driver.getCurrentUrl().contains("/opportunities"), "Failed to navigate to Opportunities page"); 
	
	}
	
	@Test
	public void createoppo() throws InterruptedException
	{
		 ExtentManager.logTestInfo("Test case 2 :Opening opportunity Page"); 
			Logs.info("OPening opportunity Page");
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		oppo.createopportunity();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	       WebElement header = wait.until(ExpectedConditions
	         .visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Opportunities')]")));
	   
	   Assert.assertTrue(driver.getCurrentUrl().contains("/opportunities"),
		        "Failed to navigate to Opportunities page");
	   
	   driverClose();
	   
	}
	
	@Test
	public void oppoIdAutogeneration() throws InterruptedException
	{
		 ExtentManager.logTestInfo("Test case 3 :Check Opportunity id is auto generated"); 
		Logs.info("OPening opportunity Page");
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		oppo.createopportunity();
		oppo.checkoppoid();
	}
	
	
	@Test
	public void opponamecheck() throws InterruptedException
	{
		 ExtentManager.logTestInfo("Test case 4 :Verify opportunity name is mandatory"); 
			Logs.info("OPening opportunity Page");
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		oppo.createopportunity();
		oppo.opponamecheck();
	}
	
	@Test
	public void amountcheck() throws InterruptedException
	{
		 ExtentManager.logTestInfo("Test case 5 :Verify amount is mandatory"); 
		Logs.info("OPening opportunity Page");
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		Thread.sleep(2000);
		oppo.createopportunity();
		Thread.sleep(2000);
		oppo.amountcheck();
	}
	
	@Test
	public void businesstypecheck() throws InterruptedException
	{
		 ExtentManager.logTestInfo("Test case 6 :Verify business type is mandatory"); 
			Logs.info("OPening opportunity Page");
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		Thread.sleep(2000);
		oppo.createopportunity();
		Thread.sleep(2000);
		oppo.businesstypecheck();
	}
	
	@Test
	public void nextstage() throws InterruptedException
	{
		 ExtentManager.logTestInfo("Test case 7 :Verify next step is mandatory"); 
			Logs.info("OPening opportunity Page");
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		Thread.sleep(2000);
		oppo.createopportunity();
		Thread.sleep(2000);
		oppo.nextstep();
	}
	
	@Test
	public void salestage() throws InterruptedException
	{
		 ExtentManager.logTestInfo("Test case 8 :Verify sales stage is mandatory"); 
			Logs.info("OPening opportunity Page");
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		Thread.sleep(2000);
		oppo.createopportunity();
		Thread.sleep(2000);
		oppo.checksalesstage();
	}
	
	@Test
	public void checkLeadMadatory() throws InterruptedException
	{
		ExtentManager.logTestInfo("Test case 9 :Verify lead field is mandatory"); 
		Logs.info("OPening opportunity Page");
	oppo=new OpportunityPage(driver);
	Thread.sleep(2000);
	oppo.clickOpportunity();
	Thread.sleep(2000);
	oppo.createopportunity();
	Thread.sleep(2000);
	oppo.checkLead();
	}

	@Test
	public void probablityCheck() throws InterruptedException
	{
		 ExtentManager.logTestInfo("Test case 10  :Verify probability field is mandatory and defaults to 0"); 
			Logs.info("OPening opportunity Page");
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		Thread.sleep(2000);
		oppo.createopportunity();
		Thread.sleep(2000);
		oppo.optionalProbability();
		
	}
	
	@Test
	public void probablityValidation() throws InterruptedException
	{
	ExtentManager.logTestInfo("Test case 11  :Verify probablity values is between 0 and 100 "); 
	Logs.info("OPening opportunity Page");
	oppo=new OpportunityPage(driver);
	Thread.sleep(2000);
	oppo.clickOpportunity();
	Thread.sleep(2000);
	oppo.createopportunity();
	Thread.sleep(2000);
	oppo.probablityValidation();
	}
	
	@Test
	public void dateCheck() throws InterruptedException
	{
		ExtentManager.logTestInfo("Test case 12  :Verify expected close date is valid date "); 
		Logs.info("OPening opportunity Page");
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		Thread.sleep(2000);
		oppo.createopportunity();
		Thread.sleep(2000);
		oppo.checkClosedate();
	}
	
	@Test
	public void saveAllfields() throws InterruptedException
	{
		ExtentManager.logTestInfo("Test case 13  :Check form is save with all valid fields"); 
		Logs.info("OPening opportunity Page");
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		Thread.sleep(2000);
		oppo.createopportunity();
		Thread.sleep(2000);
		oppo.saveWithallfields();
	}
	
	@Test
	public void saveWithmandatory() throws InterruptedException
	{
		ExtentManager.logTestInfo("Test case 14  :Check form is save with all mandatory fields "); 
		Logs.info("OPening opportunity Page");
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		Thread.sleep(2000);
		oppo.createopportunity();
		Thread.sleep(2000);
		
	}
}

