package com.group3.CRMtests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.group3.CRMbasics.BaseTest;
import com.group3.CRMpages.CampaignPage;
import com.group3.CRMpages.LoginPage;
import com.group3.CRMutilities.PropertiesFile;
import com.group3.CRMutilities.ScreenShots;

public class CampaignTest extends BaseTest{

	WebDriver driver;
	PropertiesFile prop;
	ScreenShots screenshot = new ScreenShots();
	CampaignPage campaignPage = new CampaignPage(driver);
	LoginPage loginPage = new LoginPage(driver);
	
	
	@BeforeTest
	public void doLogin() {
		
		driver = getDriver();
		loginPage.enterintoUsername();
		loginPage.enterintoPassword();
		loginPage.clickSignIn();
	}
	
	@Test
	public void CampaignTC_001() throws InterruptedException {
		
		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		
//		Thread.sleep(2000);
	//	camp.continueToSite.click();
	//	Thread.sleep(3000);
		campaignPage.campaigns.click();
	//	Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Create Campaign']")));
//		element.click();
		
		campaignPage.clickOnCreateCampaign();
	//	camp.createCampaign.click();
	//	camp.campaignName.sendKeys("SpringSale25");
	//	camp.targetSize.sendKeys("50");
	//	camp.create_Campaign.click();
		
	}

	
	
	
}
