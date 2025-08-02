package com.group3.CRMpages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.group3.CRMbasics.BasePage;
import com.group3.CRMlogs.Logs;

public class CampaignPage extends BasePage {
	
WebDriver driver;
	
	public CampaignPage(WebDriver driver) {
		
		super(driver);  // explicitly call BasePage(WebDriver)
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='btn btn-info']//span[text()='Create Campaign']")
	public WebElement createCampaign;
	
	@FindBy(xpath = "//button[@id='proceed-button']")
	public WebElement continueToSite;
	
	@FindBy(linkText = "Create Account")
	public WebElement createAccount;
	
	@FindBy(linkText = "Forgot password?")
	public WebElement forgotPassword;
	
	@FindBy(xpath = "//a[text()='Campaigns']")
	public WebElement campaigns;
	
//	@FindBy(xpath = "//span[normalize-space()='Create Campaign']")
//	@FindBy(xpath = "//span[text()='Create Campaign']")
	
	@FindBy(xpath = "//input[@name='campaignId']")
	public WebElement campaignId;
	
	@FindBy(xpath = "//input[@name='campaignName']")
	public WebElement campaignName;
	
	@FindBy(xpath = "//input[@name='campaignStatus']")
	public WebElement campaignStatus;
	
	@FindBy(xpath = "//input[@name='targetSize']")
	public WebElement targetSize;
	
	@FindBy(xpath = "//input[@name='expectedCloseDate']")
	public WebElement expectedClosedDate;
	
	@FindBy(xpath = "//input[@name='targetAudience']")
	public WebElement targetAudience;
	
	@FindBy(xpath = "//textarea[@name='description']")
	public WebElement description;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	public WebElement create_Campaign;
	
	@FindBy(xpath = "(//a[@class='edit']")
//	@FindBy(xpath = "(//a[@class='edit']/i)[1]")
	public WebElement editIcon;
	
	@FindBy(xpath = "(//a[@class='edit']/i)[1]")
	public WebElement editIcon2;
	
	@FindBy(xpath = "//a[@class='delete']")
	public WebElement deleteIcon;
	
	@FindBy(xpath = "//button[text()='Update Campaign']")
	public WebElement updateCampaign;
	
//	@FindBy(xpath = "div[@class='Toastify__toast Toastify__toast--success']")
//	public WebElement ActSuccessmsg;
	
	public String expSuccessMsg = "Campaign SaveEarth Successfully Added";
	public String expValue = "Auto Generated";
	public String expErrorMsg = "Campaign name should be unique";
	public String successMsg = "Campaign SaveResources Successfully Added";
	
	public void clickOnCreateCampaign() throws InterruptedException {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info']//span[text()='Create Campaign']")));
		element.click();
//		BasePage.waitForElement(createCampaign, (5));

	}
	
	public void verifyThatUserIsAbleToAccessCreateCampaignForm() {
		waitForElement(createCampaign, Duration.ofSeconds(10)) ;
			if(createCampaign.isDisplayed()) {
				createCampaign.click();
				Logs.info("User is able to access 'Create Campaign' form");
			}
	}
	
	
	public boolean verifyCampaignIsCreated() {
		boolean isCreated = false;
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//div[@class='Toastify__toast-body']")));

		String toastText = toast.getText();
		System.out.println(toastText);
		isCreated = true;
		
		return isCreated;
		
	}
	
	public void clickOnEditIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement editIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='edit']")));
	//	waitForVisibilty()
		editIcon.click();
		
	}
	
	public boolean verifyThatCampaignIDIsReadOnly() {
		
		boolean isReadOnly = false;
//		String actualValue = campaignId.getAttribute("required value");
//		Assert.assertEquals(actualValue, "expValue");
//		
		WebElement campaignId = driver.findElement(By.name("campaignId"));
		String readonlyAttr = campaignId.getAttribute("readonly");
		Assert.assertTrue("true".equals(readonlyAttr),
		    "Campaign ID field should be readonly but got: " + readonlyAttr);
		
		isReadOnly = true;
		
		return isReadOnly;
	}
	
	public boolean verifyThatCreatedCampaignIsVisibleInTheList() {
		boolean isVisible = false;

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement createdCampaign = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='tr']/td[text()='ABCD']")));
//	
//		String expCampaign = "ABCD";
//		if(createdCampaign.isDisplayed()) {
//			createdCampaign.getText();
//			Assert.assertEquals(createdCampaign, expCampaign);
//			isVisible = true;
//		}
//		return isVisible;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement createdCampaignHeader = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table table-striped table-hover']//th[2]")));
	
		String expCampaign = "SavePlanet";
		if(createdCampaignHeader.isDisplayed()) {
			String actCampaign = createdCampaignHeader.getText();
			System.out.println(actCampaign);
			Assert.assertEquals(createdCampaignHeader, expCampaign);
			isVisible = true;
		}
		return isVisible;
		
	}

	// Returns whether the input element is valid based on HTML5 validation.
	public boolean isFieldValid(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean isValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", element);
        System.out.println("Valid: " + isValid);
		return isValid;
    }

	// Returns the validation message shown by the browser if the field is invalid.
	public String getValidationMessage(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 String tooltipMessage = (String) js.executeScript("return arguments[0].validationMessage;", element);
		 System.out.println("Tooltip Message: " + tooltipMessage);
		return tooltipMessage;
    }
	
	
	public void verifyCreatedCampaignNameIsAlphaNumeric() {
		
		waitForElement(editIcon2, Duration.ofSeconds(20));
		editIcon2.click();
		String entered = campaignName.getAttribute("Testing");
		
	}
	
	public void verifyThatStatusDropdownIsDisplayed() {
		
		waitForElement(campaignStatus, Duration.ofSeconds(5));
		if(campaignStatus.isDisplayed())
			campaignStatus.click();
		
		List<WebElement> elems = driver.findElements(By.name("campaignStatus"));
	    if (elems.isEmpty()) {
	       System.out.print("Campaign Status dropdown is missing from the UI");
	    }
		
	}
	
	public boolean verifyThatCampaignIsCreatedWithExistingCampaignName() {
		
		boolean isCreatedVerified = false;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//div[@class='Toastify__toast-body']")));

		String toastText = toast.getText();
		System.out.println(toastText);
		isCreatedVerified = true;
		
		return isCreatedVerified;
	}
	
	public void verifyThatStatusIsUpdatableAfterCreationOfACampaign() {
		
		WebElement createdCampaign = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody/tr[1]/td[2]"));
		waitForElement(createdCampaign, Duration.ofSeconds(10));
		String cellValue = createdCampaign.getText();
		if(cellValue.equals("SaveWater")) {
			editIcon2.click();
			waitForElement(campaignStatus, Duration.ofSeconds(10));
			campaignStatus.sendKeys("Active");
			updateCampaign.click();
			System.out.println("Campaign status is updated");
		}
		
		
	}
	
	
	

}
