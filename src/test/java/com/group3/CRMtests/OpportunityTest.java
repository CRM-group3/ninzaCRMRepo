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
	 ExtentManager.logTestInfo("Opening opportunity Page"); 
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
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		oppo.createopportunity();
		oppo.checkoppoid();
	}
	
	
	@Test
	public void opponamecheck() throws InterruptedException
	{
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		oppo.createopportunity();
		oppo.opponamecheck();
	}
	
	@Test
	public void amountcheck() throws InterruptedException
	{
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
		oppo=new OpportunityPage(driver);
		Thread.sleep(2000);
		oppo.clickOpportunity();
		Thread.sleep(2000);
		oppo.createopportunity();
		Thread.sleep(2000);
		oppo.checksalesstage();
	}

	
		
}
