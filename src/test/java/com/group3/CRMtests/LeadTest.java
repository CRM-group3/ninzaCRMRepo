package com.group3.CRMtests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.group3.CRMbasics.BasePage;
import com.group3.CRMbasics.BaseTest;
import com.group3.CRMlistners.ExtentManager;
import com.group3.CRMlogs.Logs;
import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMutilities.ScreenShots;
import com.group3.CRMpages.LeadPage;


public class LeadTest extends BaseTest{
	
	
	public int openLeadsPage() throws InterruptedException //returns 0 if successful and 1 if not
	{
		
		ExtentManager.logTestInfo("Opening Lead Page");
		Logs.info("OPening Lead Page");
		LeadPage lp = new LeadPage(driver);			
		basepage.waitForElement(lp.leads,Duration.ofSeconds(1000));
		lp.clickLead();
		basepage.waitForElement(lp.createLeadButton,Duration.ofSeconds(1000));
		if(lp.createLeadButton.isDisplayed())
		{
			System.out.println("success opening Leads page");
			Logs.info("success opening Leads page");
			ExtentManager.logTestInfo("success opening Leads page");
			return 0;
		} else
		{
			System.out.println("Error opening leads page");
			Logs.info("Error opening leads page");
			ExtentManager.logTestInfo("Error opening leads page");
			return 1;
	
		}	
	}
	
	
	@Test(enabled=false)
	public int openCreateLeadPage() throws InterruptedException //returns 0 if successful and 1 if not
	{
		
		ExtentManager.logTestInfo("Opening Lead Page");
		Logs.info("OPening Lead Page");
		LeadPage lp = new LeadPage(driver);			
		basepage.waitForElement(lp.leads,Duration.ofSeconds(1000));
		lp.clickLead();
		basepage.waitForElement(lp.createLeadButton,Duration.ofSeconds(1000));
		lp.clickCreateLead();
		basepage.waitForElement(lp.leadId,Duration.ofSeconds(1000));
		if(lp.leadId.isDisplayed())
		{
			System.out.println("createLeadPageOpens");
			Logs.info("createLeadPageOpens");
			ExtentManager.logTestInfo("createLeadPageOpens");
			return 0;
		} else
		{
			System.out.println("Error opening create lead page");
			Logs.info("Error opening create lead page");
			ExtentManager.logTestInfo("Error opening create lead page");
			return 1;
	
		}	

	}
	
	@Test
	@Parameters({"campaignName"})
	public void saveWithMandatoryFields() throws Exception
	{
		if(openCreateLeadPage()==0)
		{
			String leadName = "Ding Dong";
			LeadPage lp = new LeadPage(driver);	
			lp.leadName.sendKeys(leadName);
			lp.leadStatus.sendKeys("New");
			lp.leadCompany.sendKeys("CooChooTrains");
			lp.leadSource.sendKeys("Campaign:TvAds");
			lp.leadIndustry.sendKeys("Railways");
			lp.phone.sendKeys("5106667777");
//			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			WebElement plusButton = driver.findElement(By.xpath("//button[.//svg[contains(@class, 'fa-plus')]]"));
//			js.executeScript("arguments[0].click();", plusButton);
			String mainWindow = driver.getWindowHandle();
			
			lp.clickgreenPlusButton();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(driver -> driver.getWindowHandles().size() > 1);

			// Switch to the new window
			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(mainWindow)) {
					driver.switchTo().window(windowHandle);

					basepage.waitForElement(lp.campaignLookupTable, Duration.ofSeconds(3000));
					lp.searchAndSelectFirstMatchingCampaign(driver, "Roshal");

					break;
				}
			}		
			
			driver.switchTo().window(mainWindow);
			//String campaignName =lp.campaignTextField.getText();
			lp.submitCreateLead();			
			Thread.sleep(500); 
			String toast = lp.captureToastifyTopRightMessage();
			System.out.println("Toast Msg"+toast);
			Logs.info("Toast Msg"+toast);
			ExtentManager.logTestInfo("Toast Msg"+toast);			
			Assert.assertEquals(toast,"Lead "+ leadName+" Successfully Added","Error while adding a lead");
			
		}					
		
	}
	
	@Test
	public void chkPromptMsgsWhenReqdFieldsLeftBlank() throws InterruptedException
	{
		if(openCreateLeadPage()==0)
		{
			
			
			
		}
		
	}
	
	
	
}