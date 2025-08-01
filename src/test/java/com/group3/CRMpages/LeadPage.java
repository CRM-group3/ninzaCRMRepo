package com.group3.CRMpages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.group3.CRMbasics.BasePage;
import com.group3.CRMlogs.Logs;

public class LeadPage extends BasePage{

	public LeadPage(WebDriver driver) {
		super(driver);
	}
	
	//@FindBy(xpath="//a[normalize-space()='Leads']")
	public @FindBy(xpath="//a[@href='/leads']")
	WebElement leads;
	
	public void clickLead() {
		leads.click();
	}
		
	public @FindBy(xpath="//span[normalize-space()='Create Lead']")
	WebElement createLeadButton;
	
	public void clickCreateLead() {
		//createLeadButton.click();
		clickbutton(createLeadButton, "Leads link");
	}
		

	public @FindBy(xpath="//input[@name='leadId']")
	WebElement leadId;
	
	public @FindBy(xpath="//input[@name='leadStatus']") //mandatory
	WebElement leadStatus;
	
	public @FindBy(xpath="//input[@name='name']") //mandatory
	WebElement leadName;
	
	public @FindBy(xpath="//input[@name='rating']")
	WebElement leadRating;
	
	public @FindBy(xpath="//input[@name='company']") //mandatory
	WebElement leadCompany;
	
	public @FindBy(xpath="//input[@name='assignedTo']")
	WebElement assignedTo;
	
	public @FindBy(xpath="//input[@name='leadSource']") //mandatory
	WebElement leadSource;
	
	public @FindBy(xpath="//input[@name='address']")
	WebElement leadAddress;
	
	public @FindBy(xpath="//input[@name='industry']") //mandatory
	WebElement leadIndustry;
	
	public @FindBy(xpath="//input[@name='city']")
	WebElement leadCity;
	
	public @FindBy(xpath="//input[@name='annualRevenue']")
	WebElement annualRevenue;
	
	public @FindBy(xpath="//input[@name='country']")
	WebElement leadCountry;
	
	public @FindBy(xpath="//input[@name='noOfEmployees']")
	WebElement noOfEmployees;
	
	public @FindBy(xpath="//input[@name='postalCode']")
	WebElement postalCode;
	
	public @FindBy(xpath="//input[@name='phone']") //phone
	WebElement phone;
	
	public @FindBy(xpath="//input[@name='website']")
	WebElement website;
	
	public @FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	public @FindBy(xpath="//input[@name='secondaryEmail']")
	WebElement secondaryEmail;
	
	public @FindBy(xpath="//input[@name='description']")
	WebElement description;
	
	public @FindBy(xpath="//button[normalize-space(text())='Create Lead']")		
	WebElement submitCreateLeadButton;
	
	public void submitCreateLead() 
	{
		//submitCreateLeadButton.click();
		clickbutton(submitCreateLeadButton,"Save Button");
	}
	
	//lookup
	
	public @FindBy(xpath="//input[@type='text' and @readonly and @required and @style='flex: 1 1 0%; margin-right: 10px;']\n"
			+ "")
		WebElement campaignTextField;  //mandatory
	
	public @FindBy(xpath="//button[contains(@style, 'background-color: green')]")
	WebElement greenPlusButton;
	
	public void clickgreenPlusButton() 
	{
		//submitCreateLeadButton.click();
		clickbutton(greenPlusButton,"campaign lookup Button");
	}
	
	
	public @FindBy(id="campaign-table")
	WebElement campaignLookupTable;
	
	public @FindBy(xpath="//select[@id='search-criteria']")
	WebElement campaignLookupSearchDD;
	
	public @FindBy(xpath="//select[@id='search-input']")
	WebElement campaignLookupSearchInputTB;
			
		
			

	
	
	
	
	public void searchAndSelectFirstMatchingCampaign(WebDriver driver, String campaignNameToSearch) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Step 1: Select "Campaign Name" from the dropdown
	    Select searchDropdown = new Select(driver.findElement(By.id("search-criteria")));
	    searchDropdown.selectByValue("campaignName");

	    // Step 2: Enter the campaign name into the search input
	    WebElement searchInput = driver.findElement(By.id("search-input"));
	    searchInput.clear();
	    searchInput.sendKeys(campaignNameToSearch);
	    

	    // Step 3: Wait for at least one row with matching campaign name to appear
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//table[@id='campaign-table']//tbody/tr[td[2][text()='" + campaignNameToSearch + "']]")
	    ));

	    // Step 4: Click the first matching "Select" button
	    WebElement firstSelectButton = driver.findElement(By.xpath(
	        "(//table[@id='campaign-table']//tbody/tr[td[2][text()='" + campaignNameToSearch + "']]//button[contains(@class, 'select-btn')])[1]"
	    ));

	    wait.until(ExpectedConditions.elementToBeClickable(firstSelectButton));
	    firstSelectButton.click();

	    System.out.println("Clicked first available Select button for campaign name: " + campaignNameToSearch);
	}
	
	
	
	public String captureToastifyTopRightMessage() {
	    String containerSelector = "div.Toastify__toast-container--top-right";
	    String toastBodySelector = containerSelector + " div.Toastify__toast-body";

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    try {
	        // Wait for the container to be present (if needed)
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(containerSelector)));

	        // Wait for the toast message inside container
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(toastBodySelector)));

	        // Extract the toast message text with JS
	        String message = (String) js.executeScript(
	            "return document.querySelector('" + toastBodySelector + "')?.innerText || '';"
	        );

	        Logs.info("Toastify message: " + message);
	        return message;

	    } catch (Exception e) {
	        Logs.warn("Toastify message not found or disappeared too quickly.");
	        return "";
	    }
	}


	
	
}





