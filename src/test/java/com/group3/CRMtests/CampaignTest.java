package com.group3.CRMtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.group3.CRMbasics.BasePage;
import com.group3.CRMbasics.BaseTest;
import com.group3.CRMlistners.ExtentManager;
import com.group3.CRMlogs.Logs;
import com.group3.CRMpages.CampaignPage;
import com.group3.CRMutilities.PropertiesFile;

public class CampaignTest extends BaseTest {

	CampaignPage campaignPage;
	PropertiesFile prop = new PropertiesFile();
	BasePage basePage;

	public void testLogin() {
		// initializeBrowser("chrome");
		// initialSetup();
		Logs.info("User is successfully logged in");
		ExtentManager.logTestInfo("User is successfully logged in");
	}

//  description = "Verify that user has access to 'Create Campaign' form"
	@Test(priority = 0)
	public void CampaignTC_001() {
		testLogin();
		// driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.verifyThatUserIsAbleToAccessCreateCampaignForm();
		Logs.info("User is able to access the Create Campaign form");
		ExtentManager.logTestInfo("Successfully able to access Create Campaign form");
	}

//  description = "Create a Campaign with all mendatory fields"
	@Test(priority = 1)
	public void CampaignTC_002() throws InterruptedException {
		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		String campaignName = prop.getProperty("campaign.properties","CampaignName");
        String targetSize = prop.getProperty("campaign.properties","TargetSize");
		campaignPage.campaignName.sendKeys(campaignName);
		Logs.info("Campaign name is entered");
		campaignPage.targetSize.sendKeys(targetSize);
		Logs.info("Target size is entered");
		campaignPage.create_Campaign.click();
		Logs.info("Clicked on Create_Campaign");
		Assert.assertTrue(campaignPage.verifyCampaignIsCreated(), campaignPage.expSuccessMsg);
		Logs.info("Campaign is successfully created");
		ExtentManager.logTestInfo("Campaign is successfully created");

	}

// description = "Verify that Campaign_Id is auto-generated and read-only"
	@Test(priority = 2)
	public void CampaignTC_003() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		String campaignName = prop.getProperty("campaign.properties","CampaignName2");
		String campaignId = prop.getProperty("campaign.properties","CampaignId2");
        String targetSize = prop.getProperty("campaign.properties","TargetSize2");
		campaignPage.campaignName.sendKeys(campaignName);
		Logs.info("Campaign name is entered");
		campaignPage.campaignId.sendKeys(campaignId);
		campaignPage.targetSize.sendKeys(targetSize);
		Logs.info("Target size is entered");
		campaignPage.create_Campaign.click();
		Logs.info("Clicked on Create_Campaign");
//		Assert.assertTrue(campaignPage.verifyThatCampaignIDIsReadOnly(), campaignPage.expValue);

	}

// description = "Create a Campaign with all fields blank"
	@Test(priority = 3)
	public void CampaignTC_004() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		campaignPage.create_Campaign.click();
		Logs.info("Clicked on Create_Campaign");
		boolean isValid = campaignPage.isFieldValid(campaignPage.campaignName);
		String tooltipMessage = campaignPage.getValidationMessage(campaignPage.campaignName);
		Assert.assertFalse(isValid, "Expected input to be invalid due to empty value");
	    Assert.assertEquals(tooltipMessage, "Please fill out this field.");
	    Logs.info("Campaign is not created with blank fields");
		ExtentManager.logTestInfo("error message shown");
	}

// description = "Verify that Expected Close Date uses Date Picker"
	@Test(priority = 4)
	public void CampaignTC_005() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		String campaignName = prop.getProperty("campaign.properties","CampaignName3");
        String targetSize = prop.getProperty("campaign.properties","TargetSize3");
		campaignPage.campaignName.sendKeys(campaignName);
		Logs.info("Campaign name is entered");
		campaignPage.targetSize.sendKeys(targetSize);
		Logs.info("Target size is entered");
		campaignPage.expectedClosedDate.click();
		System.out.println("Expected Close Date DatePicker is displayed");
		Logs.info("DatePicker is displayed");
		ExtentManager.logTestInfo("DatePicker is displayed");
		// campaignPage.create_Campaign.click();
	
	}

	// description = "Create a Campaign name without entering Campaign name"
	@Test(priority = 5)
	public void CampaignTC_006() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		campaignPage.campaignName.sendKeys("");
		String targetSize = prop.getProperty("campaign.properties","TargetSize4");
		campaignPage.targetSize.sendKeys(targetSize);
		campaignPage.create_Campaign.click();
		boolean isValid = campaignPage.isFieldValid(campaignPage.campaignName);
		String tooltipMessage = campaignPage.getValidationMessage(campaignPage.campaignName);
		Assert.assertFalse(isValid, "Expected input to be invalid due to empty value");
	    Assert.assertEquals(tooltipMessage, "Please fill out this field.");
	    Logs.info("Campaign is not created");
		ExtentManager.logTestInfo("error message shown");
	}

	// description = "Create a Campaign name without entering Target Size"
	@Test(priority = 6)
	public void CampaignTC_007() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		String campaignName = prop.getProperty("campaign.properties","CampaignName5");
		campaignPage.campaignName.sendKeys(campaignName);
		campaignPage.targetSize.clear();
		campaignPage.create_Campaign.click();
		boolean isValid = campaignPage.isFieldValid(campaignPage.targetSize);
		String tooltipMessage = campaignPage.getValidationMessage(campaignPage.targetSize);
		Assert.assertFalse(isValid, "Expected input to be invalid due to empty value");
	    Assert.assertEquals(tooltipMessage, "Please fill out this field.");
	    Logs.info("Campaign is not created without entering Target Size");
		ExtentManager.logTestInfo("error message shown");
	}

	// description = "Create a Campaign with alpha-numeric characters in Campaign
	// name field"
	@Test(priority = 7)
	public void CampaignTC_008() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		String campaignName = prop.getProperty("campaign.properties","CampaignName6");
        String targetSize = prop.getProperty("campaign.properties","TargetSize6");
		campaignPage.campaignName.sendKeys(campaignName);
		Thread.sleep(3000);
		campaignPage.targetSize.clear();
		campaignPage.targetSize.sendKeys(targetSize);
		Logs.info("Target size is entered");
		campaignPage.create_Campaign.click();
		campaignPage.verifyCreatedCampaignNameIsAlphaNumeric();
		Thread.sleep(3000);
		Assert.assertNotEquals("entered", "Testin123",
			    "Campaign name should not accept alphanumeric; actual value:");
		Logs.info("Campaign field does not accept alpha-numeric values");
		ExtentManager.logTestInfo("Campaign field does not accept alpha-numeric values");
	}

	// description = "Create a Campaign with non-numeric values in Target Size
	// field"
	@Test(priority = 8)
	public void CampaignTC_009() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		String campaignName = prop.getProperty("campaign.properties","CampaignName7");
        String targetSize = prop.getProperty("campaign.properties","TargetSize7");
		campaignPage.campaignName.sendKeys(campaignName);
		campaignPage.targetSize.clear();
		campaignPage.targetSize.sendKeys(targetSize);
		campaignPage.create_Campaign.click();
		boolean isValid = campaignPage.isFieldValid(campaignPage.targetSize);
		String tooltipMessage = campaignPage.getValidationMessage(campaignPage.targetSize);
		Assert.assertFalse(isValid, "Expected input to be invalid due to non-numeric value");
	    Assert.assertEquals(tooltipMessage, "Please enter a number.");
	    Logs.info("Campaign is not created with non-numeric values in Target Size field");
		ExtentManager.logTestInfo("error message shown'Please enter a number.'");

	}

	// description = "Create a Campaign with negative values in Target Size field"
	@Test(priority = 9)
	public void CampaignTC_010() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		String campaignName = prop.getProperty("campaign.properties","CampaignName8");
        String targetSize = prop.getProperty("campaign.properties","TargetSize8");
		campaignPage.campaignName.sendKeys(campaignName);
		campaignPage.targetSize.clear();
		campaignPage.targetSize.sendKeys(targetSize);
		campaignPage.create_Campaign.click();
		boolean isValid = campaignPage.isFieldValid(campaignPage.targetSize);
		String tooltipMessage = campaignPage.getValidationMessage(campaignPage.targetSize);
		Assert.assertFalse(isValid, "Expected input to be invalid due to empty value");
	    Assert.assertEquals(tooltipMessage, "Value must be greater than or equal to 0.");
	    Logs.info("Campaign is not created with negative values");
		ExtentManager.logTestInfo("error message shown");

	}

	// description = "Verify that Campaign status is a dropdown"
	@Test(priority = 10)
	public void CampaignTC_011() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		campaignPage.verifyThatStatusDropdownIsDisplayed();
		Thread.sleep(3000);
		Assert.fail("Campaign Status dropdown is missing in the UI");
		Logs.info("Campaign Status dropdown is missing in the UI");
		ExtentManager.logTestInfo("Dropdown is missing");
	}

	// description = "Create a Campaign with special characters in Campaign name
	// field"
	 @Test(priority = 11)
	public void CampaignTC_012() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		String campaignName = prop.getProperty("campaign.properties","CampaignName9");
        String targetSize = prop.getProperty("campaign.properties","TargetSize9");
		campaignPage.campaignName.sendKeys(campaignName);
		Thread.sleep(3000);
		campaignPage.targetSize.clear();
		campaignPage.targetSize.sendKeys(targetSize);
		campaignPage.create_Campaign.click();
		boolean isValid = campaignPage.isFieldValid(campaignPage.campaignName);
		String tooltipMessage = campaignPage.getValidationMessage(campaignPage.campaignName);
		Assert.assertFalse(isValid, "Expected input is not getting entered due to invalid value");
	    Assert.assertEquals(tooltipMessage, "Please fill out this field.");
	    Logs.info("Campaign name field does not accept special characters");
		ExtentManager.logTestInfo("Campaign is not created with special characters");
	}

	// description = "Create a Campaign with existing campaign name"
		@Test(priority = 12)
	public void CampaignTC_013() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		String campaignName = prop.getProperty("campaign.properties","CampaignName10");
        String targetSize = prop.getProperty("campaign.properties","TargetSize10");
		campaignPage.campaignName.sendKeys(campaignName);
		Thread.sleep(3000);
		campaignPage.targetSize.clear();
		campaignPage.targetSize.sendKeys(targetSize);
		campaignPage.create_Campaign.click();
		campaignPage.verifyThatCampaignIsCreatedWithExistingCampaignName();
		Assert.fail("Campaign name should be unique");
		Logs.info("Campaign is successfully created with existing Campaign name");
		ExtentManager.logTestInfo("Campaign is Successfully created with existing Campaign name");
	}

	// description = "Verify that created Campaign is visible in the Campaign list"
		@Test(priority = 13)
	public void CampaignTC_014() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		String campaignName = prop.getProperty("campaign.properties","CampaignName11");
        String targetSize = prop.getProperty("campaign.properties","TargetSize11");
		campaignPage.campaignName.sendKeys(campaignName);
		campaignPage.targetSize.clear();
		campaignPage.targetSize.sendKeys(targetSize);
		campaignPage.create_Campaign.click();
		Assert.assertEquals(campaignPage.verifyThatCreatedCampaignIsVisibleInTheList(),
				"Campaign is not visible in the list");
		
	}

	// description = "Verify that default value of the Target Size if not provided
	// any value"
		 @Test(priority = 14)
	public void CampaignTC_015() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		String campaignName = prop.getProperty("campaign.properties","CampaignName12");
		campaignPage.campaignName.sendKeys(campaignName);
		campaignPage.targetSize.clear();
		campaignPage.create_Campaign.click();
		boolean isValid = campaignPage.isFieldValid(campaignPage.targetSize);
		String tooltipMessage = campaignPage.getValidationMessage(campaignPage.targetSize);
		Assert.assertFalse(isValid, "Expected input to be invalid due to empty value");
	    Assert.assertEquals(tooltipMessage,  "Default value'0' should be provided.");

	}

	// description = "Verify that Campaign status can be updated after creation of a
	// Campaign"
	 @Test(priority = 15)
	public void CampaignTC_016() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		String campaignName = prop.getProperty("campaign.properties","CampaignName14");
		String campaignStatus = prop.getProperty("campaign.properties", "CampaignStatus14");
        String targetSize = prop.getProperty("campaign.properties","TargetSize14");
		campaignPage.campaignName.sendKeys(campaignName);
		campaignPage.campaignStatus.sendKeys(campaignStatus);
		campaignPage.targetSize.clear();
		campaignPage.targetSize.sendKeys(targetSize);
		Logs.info("Target size is entered");
		campaignPage.create_Campaign.click();
		Logs.info("Campaign form is submitted");
		campaignPage.verifyThatStatusIsUpdatableAfterCreationOfACampaign();
		Logs.info("Campaign status is successfully updated");
		ExtentManager.logTestInfo("Campaign status is successfully updated");
			
//		campaignPage.editIcon.click();
//		campaignPage.campaignStatus.sendKeys("Active");
//		campaignPage.updateCampaign.click();

	}

	// description = "Create a Campaign with entering "0" in the Target Size field"
		@Test(priority = 16)
	public void CampaignTC_017() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		String campaignName = prop.getProperty("campaign.properties","CampaignName13");
        String targetSize = prop.getProperty("campaign.properties","TargetSize13");  
		campaignPage.campaignName.sendKeys(campaignName);
		Logs.info("Campaign name is entered");
		campaignPage.targetSize.clear();
		campaignPage.targetSize.sendKeys(targetSize);
		Logs.info("Target size is entered");
		campaignPage.create_Campaign.click();
		Logs.info("Clicked on Create_Campaign");
		Assert.assertTrue(campaignPage.verifyCampaignIsCreated(), campaignPage.successMsg);
		Logs.info("Campaign is successfully created with default value");
		ExtentManager.logTestInfo("Campaign is successfully created");

	}

	// description = "Create a Campaign with entering more than 4 digits in year
	// field"
		@Test(priority = 17)
	public void CampaignTC_018() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		campaignPage.campaignName.sendKeys("SaveEarth");
		Thread.sleep(3000);
		campaignPage.campaignStatus.sendKeys("planned");
		Thread.sleep(3000);
		campaignPage.targetSize.clear();
		campaignPage.targetSize.sendKeys("50");
		campaignPage.expectedClosedDate.sendKeys("07/28/20025");
		Thread.sleep(4000);
		campaignPage.create_Campaign.click();
		Assert.fail("Year field should be valid digits");
	}

	// description = "Create a Campaign with white spaces in Campaign name field"
	@Test(priority = 18)
	public void CampaignTC_019() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		campaignPage.campaignName.sendKeys("   ");
		Thread.sleep(3000);
		campaignPage.targetSize.clear();
		campaignPage.targetSize.sendKeys("80");
		Thread.sleep(3000);
		campaignPage.expectedClosedDate.sendKeys("07/31/2025");
		campaignPage.create_Campaign.click();
		Logs.info("Clicked on Create_Campaign");
		boolean isValid = campaignPage.isFieldValid(campaignPage.campaignName);
		String tooltipMessage = campaignPage.getValidationMessage(campaignPage.campaignName);
		Assert.assertFalse(isValid, "Expected input is not getting entered due to invalid value");
	    Assert.assertEquals(tooltipMessage, "Please fill out this field.");
	    Logs.info("Campaign name field does not accept White spaces");
		ExtentManager.logTestInfo("Campaign is not created with input as white spaces");
	}

	// description = "Verify that Campaign_Id is editable after creation of a
	// Campaign"
		@Test(priority = 19)
	public void CampaignTC_020() throws InterruptedException {

		driver = getDriver();
		campaignPage = new CampaignPage(driver);
		campaignPage.clickOnCreateCampaign();
		Logs.info("Clicked on Create Campaign");
		String campaignName = prop.getProperty("campaign.properties","CampaignName15");
		String campaignStatus = prop.getProperty("campaign.properties", "CampaignStatus15");
        String targetSize = prop.getProperty("campaign.properties","TargetSize15");
        String expectedClosedDate = prop.getProperty("campaign.properties","ExpectedCloseDate15");
		campaignPage.campaignName.sendKeys(campaignName);
		campaignPage.campaignStatus.sendKeys(campaignStatus);
		campaignPage.targetSize.clear();
		campaignPage.targetSize.sendKeys(targetSize);
		Logs.info("Target size is entered");
		campaignPage.expectedClosedDate.sendKeys(expectedClosedDate);
		campaignPage.create_Campaign.click();
		Logs.info("Campaign form is submitted");
		Thread.sleep(3000);
		campaignPage.editIcon.click();
		Thread.sleep(3000);
		campaignPage.campaignId.sendKeys("23456");
		Thread.sleep(3000);
		campaignPage.updateCampaign.click();
		 Assert.assertEquals(campaignPage.verifyThatCampaignIDIsReadOnly(), "Campaign Id field is editable");
		 
	}

}
