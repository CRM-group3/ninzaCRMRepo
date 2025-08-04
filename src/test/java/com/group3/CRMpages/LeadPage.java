package com.group3.CRMpages;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.group3.CRMbasics.*;
import com.group3.CRMlistners.ExtentManager;
import com.group3.CRMlogs.Logs;
import com.github.javafaker.Faker;

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
	
	public @FindBy(xpath="//textarea[@name='address']")
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
	
	public @FindBy(xpath="//textarea[@name='description']")
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
	
	
	// View Leads Page
	
	public @FindBy(xpath="//select[@class='form-control']")
	WebElement searchDDViewLeads;
	
	public @FindBy(xpath="//input[@placeholder='Search by Lead Id']")
	WebElement searcByLeadIdTB;
	
	public @FindBy(xpath="//input[@placeholder='Search by Lead Name']")
	WebElement searcByLeadNameTB;
	
	
	//update Lead page
	
	public @FindBy(xpath="//h3[text()='Update Lead']")
	WebElement updateLeadHeader;
	
	
	
	
	
			
			
	
	
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

	public boolean openLeadsPage() {
		BasePage basepage = new BasePage(driver);
		Logs.info("Navigating to Leads page...");
		
		try {
	        Logs.info("Clicking on Leads menu...");
	        ExtentManager.logTestInfo("Clicking on Leads menu...");
	        waitForElement(leads, Duration.ofSeconds(100));
	        clickLead();  // this already wraps the WebElement click

	        basepage.waitForElement(createLeadButton, Duration.ofSeconds(10));

	        boolean isVisible = createLeadButton.isDisplayed();

	        if (isVisible) {
	            Logs.info("Leads page opened successfully.");
	            ExtentManager.logTestInfo("Leads page opened successfully.");
	        } else {
	            Logs.error("Create Lead button not visible. Failed to open Leads page.");
	            ExtentManager.logTestwithFailed("Create Lead button not visible. Failed to open Leads page.");
	        }

	        return isVisible;

	    } catch (Exception e) {
	        Logs.error("Exception while opening Leads page: " + e.getMessage());
	        ExtentManager.logTestfailwithException(e);
	        return false;
	    }

	}
	
	public boolean openCreateLeadPage() throws InterruptedException {
		
		BasePage basepage = new BasePage(driver);
		Logs.info("Navigating to Leads page...");
	    ExtentManager.logTestInfo("Navigating to Leads page...");
	    waitForElement(leads, Duration.ofSeconds(100));
	    clickLead();  // menu click
	    basepage.waitForElement(createLeadButton, Duration.ofSeconds(10));

	    Logs.info("Clicking on Create Lead button...");
	    ExtentManager.logTestInfo("Clicking on Create Lead button...");

	    clickCreateLead();  // create button
	    basepage.waitForElement(leadId, Duration.ofSeconds(10));

	    boolean isVisible = leadId.isDisplayed();

	    if (isVisible) {
	        Logs.info("Create Lead page opened successfully.");
	        ExtentManager.logTestInfo("Create Lead page opened successfully.");
	    } else {
	        Logs.error("Create Lead page failed to open.");
	        ExtentManager.logTestwithFailed("Create Lead page failed to open.");
	    }

	    return isVisible;
		

	}
	
	public String enterDataReqdFields(String campaignName)
	{
		
		Faker faker = new Faker();

        String lName = faker.name().fullName(); // e.g. "John Doe"
        String email = faker.internet().emailAddress(); // e.g. "john.doe@example.com"
        String phoneNumber = faker.phoneNumber().cellPhone(); // e.g. "(123) 456-7890"
        String company = faker.company().name(); // e.g. "Acme Corp"
        String address = faker.address().fullAddress(); // e.g. "123 Elm St, Gotham City"
        //String source = faker.team().sport();
        
        leadName.sendKeys(lName);
		leadStatus.sendKeys("New");
		leadCompany.sendKeys(company);
		leadSource.sendKeys("Campaign:TvAds");
		leadIndustry.sendKeys("Railways");
		phone.sendKeys(phoneNumber);
		
		String mainWindow = driver.getWindowHandle();
		
		clickgreenPlusButton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(driver -> driver.getWindowHandles().size() > 1);

		// Switch to the new window
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle);

				waitForElement(campaignLookupTable, Duration.ofSeconds(3000));
				searchAndSelectFirstMatchingCampaign(driver, campaignName);

				break;
			}
		}	
					
		driver.switchTo().window(mainWindow);
		//String campaignName =lp.campaignTextField.getText();
		submitCreateLead();	
		
        System.out.println("Name: " + lName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Company: " + company);
        System.out.println("Address: " + address);
        
        return lName;
        		
		
	}
	
	public String enterDataAllFields(String campaignName) throws InterruptedException
	{
		
		Faker faker = new Faker();

        String lName = faker.name().fullName(); // e.g. "John Doe"
        String email1 = faker.internet().emailAddress(); // e.g. "john.doe@example.com"
        String email2 = faker.internet().emailAddress();
        String phoneNumber = faker.phoneNumber().cellPhone(); // e.g. "(123) 456-7890"
        String company = faker.company().name(); // e.g. "Acme Corp"
        String address = faker.address().fullAddress(); // e.g. "123 Elm St, Gotham City"
        String city = faker.address().city();
        String country = faker.address().country();
        String zipCode = faker.address().zipCode();
        String websiteURLe = faker.company().url();        
        
        leadName.sendKeys(lName);
		leadStatus.sendKeys("New");
		leadCompany.sendKeys(company);
		leadSource.sendKeys("Campaign:TvAds");
		leadIndustry.sendKeys("Railways");
		phone.sendKeys(phoneNumber);
		//non mandatory fields
		leadRating.sendKeys("4");				
		assignedTo.sendKeys("Dev Team1");
		Thread.sleep(500);
		leadAddress.sendKeys(address);		
		leadCity.sendKeys(city);
		annualRevenue.sendKeys("300000000000");
		leadCountry.sendKeys(country);
		noOfEmployees.sendKeys("10000");
		postalCode.sendKeys(zipCode);
		website.sendKeys(websiteURLe);
		secondaryEmail.sendKeys(email2);
		description.sendKeys("This is a test account for Aerospace Networks");
		email.sendKeys(email1);	
		
		String mainWindow = driver.getWindowHandle();		
		clickgreenPlusButton();		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(driver -> driver.getWindowHandles().size() > 1);
		// Switch to the new window
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle);

				waitForElement(campaignLookupTable, Duration.ofSeconds(3000));
				searchAndSelectFirstMatchingCampaign(driver, campaignName);

				break;
			}
		}						
		driver.switchTo().window(mainWindow);
		//String campaignName =lp.campaignTextField.getText();
		submitCreateLead();	
		
        System.out.println("Name: " + lName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Company: " + company);
        System.out.println("Address: " + address);
        
        return lName;
        		
		
	}
	
	public void reqFieldLeftBlank(String fieldToLeaveBlank, String campaignName)
	{
		Faker faker = new Faker();

        String lName = faker.name().fullName(); // e.g. "John Doe"
        String email = faker.internet().emailAddress(); // e.g. "john.doe@example.com"
        String phoneNumber = faker.phoneNumber().cellPhone(); // e.g. "(123) 456-7890"
        String company = faker.company().name(); // e.g. "Acme Corp"
        String address = faker.address().fullAddress(); // e.g. "123 Elm St, Gotham City"
        //String source = faker.team().sport();
        
        if (fieldToLeaveBlank.equals("LeadName"))
        {
        	leadStatus.sendKeys("New");
    		leadCompany.sendKeys(company);
    		leadSource.sendKeys("Campaign:TvAds");
    		leadIndustry.sendKeys("Railways");
    		phone.sendKeys(phoneNumber);
    		selectValueCampaignLookup(campaignName);
    		
        }else if(fieldToLeaveBlank.equals("Status"))
        {
        	leadName.sendKeys(lName);
    		//leadStatus.sendKeys("New");
    		leadCompany.sendKeys(company);
    		leadSource.sendKeys("Campaign:TvAds");
    		leadIndustry.sendKeys("Railways");
    		phone.sendKeys(phoneNumber);
    		selectValueCampaignLookup(campaignName);
        	
        }else if(fieldToLeaveBlank.equals("Company"))
        {
        	leadName.sendKeys(lName);
    		leadStatus.sendKeys("New");
    		//leadCompany.sendKeys(company);
    		leadSource.sendKeys("Campaign:TvAds");
    		leadIndustry.sendKeys("Railways");
    		phone.sendKeys(phoneNumber);
    		selectValueCampaignLookup(campaignName);
        	
        }else if(fieldToLeaveBlank.equals("Source"))
        {
        	leadName.sendKeys(lName);
    		leadStatus.sendKeys("New");
    		leadCompany.sendKeys(company);
    		//leadSource.sendKeys("Campaign:TvAds");
    		leadIndustry.sendKeys("Railways");
    		phone.sendKeys(phoneNumber);
    		selectValueCampaignLookup(campaignName);
        	
        }
        else if(fieldToLeaveBlank.equals("Industry"))
        {
        	leadName.sendKeys(lName);
    		leadStatus.sendKeys("New");
    		leadCompany.sendKeys(company);
    		leadSource.sendKeys("Campaign:TvAds");
    		//leadIndustry.sendKeys("Railways");
    		phone.sendKeys(phoneNumber);
    		selectValueCampaignLookup(campaignName);
        	
        }else if(fieldToLeaveBlank.equals("Phone"))
        {
        	leadName.sendKeys(lName);
    		leadStatus.sendKeys("New");
    		leadCompany.sendKeys(company);
    		leadSource.sendKeys("Campaign:TvAds");
    		leadIndustry.sendKeys("Railways");
    		//phone.sendKeys(phoneNumber);
    		selectValueCampaignLookup(campaignName);
        	
        }else if(fieldToLeaveBlank.equals("CampaignName"))
        {
        	leadName.sendKeys(lName);
    		leadStatus.sendKeys("New");
    		leadCompany.sendKeys(company);
    		leadSource.sendKeys("Campaign:TvAds");
    		leadIndustry.sendKeys("Railways");
    		phone.sendKeys(phoneNumber);
        	
        }
 
		submitCreateLead();	
		
        System.out.println("Name: " + lName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Company: " + company);
        System.out.println("Address: " + address);       
 
	}
	
	public void selectValueCampaignLookup(String campaignName)
	{
		String mainWindow = driver.getWindowHandle();
		
		clickgreenPlusButton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(driver -> driver.getWindowHandles().size() > 1);

		// Switch to the new window
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle);

				waitForElement(campaignLookupTable, Duration.ofSeconds(3000));
				searchAndSelectFirstMatchingCampaign(driver, campaignName);

				break;
			}
		}	
					
		driver.switchTo().window(mainWindow);
		
	}
	
	
	 public  Map<String, String> validateEmailInputs(WebDriver driver,WebElement emailInput, List<String> inputValues)
	 {
		 	Faker faker = new Faker();
		 	Map<String, String> resultMap = new LinkedHashMap<>(); // preserve order

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        for (String value : inputValues) {
	            // Clear field and enter test input
	            emailInput.clear();
	            emailInput.sendKeys(value);
	            
	            String lName = faker.name().fullName(); // e.g. "John Doe"
	           // String email = faker.internet().emailAddress(); // e.g. "john.doe@example.com"
	            String phoneNumber = faker.phoneNumber().cellPhone(); // e.g. "(123) 456-7890"
	            String company = faker.company().name(); // e.g. "Acme Corp"
	            //String address = faker.address().fullAddress();
	            
//	            leadName.sendKeys(lName);
//	    		leadStatus.sendKeys("New");
//	    		leadCompany.sendKeys(company);
//	    		leadSource.sendKeys("Campaign:TvAds");
//	    		leadIndustry.sendKeys("Railways");
//	    		phone.sendKeys(phoneNumber);

	            // Trigger blur to force validation
	            emailInput.sendKeys(Keys.TAB);

	            // Get browser's validation message
	            String validationMessage = (String) js.executeScript(
	                "return arguments[0].validationMessage;", emailInput);

	            resultMap.put(value, validationMessage);
	        }

	        return resultMap;
	    }

	    public void printValidationResults(Map<String, String> results) {
	        System.out.println("\nValidation Results:");
	        for (Map.Entry<String, String> entry : results.entrySet()) {
	            String input = entry.getKey();
	            String message = entry.getValue();
	            System.out.printf("prompt displayed is: "+ message);
	            //System.out.printf("Input: %-25s => Message: %s\n", "\"" + input + "\"", message.isEmpty() ? "[Valid]" : message);
	        }
	    }
	    
	    
	    public String chkDefaultEntries_RatingEmpRev(String campaignName) throws InterruptedException
		{
			
			Faker faker = new Faker();

	        String lName = faker.name().fullName(); // e.g. "John Doe"
	        String email1 = faker.internet().emailAddress(); // e.g. "john.doe@example.com"
	        String email2 = faker.internet().emailAddress();
	        String phoneNumber = faker.phoneNumber().cellPhone(); // e.g. "(123) 456-7890"
	        String company = faker.company().name(); // e.g. "Acme Corp"
	        String address = faker.address().fullAddress(); // e.g. "123 Elm St, Gotham City"
	        String city = faker.address().city();
	        String country = faker.address().country();
	        String zipCode = faker.address().zipCode();
	        String websiteURLe = faker.company().url();        
	        
	        leadName.sendKeys(lName);
			leadStatus.sendKeys("New");
			leadCompany.sendKeys(company);
			leadSource.sendKeys("Campaign:TvAds");
			leadIndustry.sendKeys("Railways");
			phone.sendKeys(phoneNumber);
			selectValueCampaignLookup(campaignName);
			
			//non mandatory fields - fields have default values
			//leadRating.sendKeys("4");		// defaults to 0 			
			//annualRevenue.sendKeys("300000000000");	 // defaults to 0		
			//noOfEmployees.sendKeys("10000"); // defaults to 1
			
			// non-mandatory fields
//			leadCountry.sendKeys(country);
//			assignedTo.sendKeys("Dev Team1");
//			Thread.sleep(500);
//			leadAddress.sendKeys(address);		
//			leadCity.sendKeys(city);
//			postalCode.sendKeys(zipCode);
//			website.sendKeys(websiteURLe);
//			secondaryEmail.sendKeys(email2);
//			description.sendKeys("This is a test account for Aerospace Networks");
//			email.sendKeys(email1);	
			
			
			submitCreateLead();	
			waitForElement(leads, Duration.ofSeconds(1000));
			//Thread.sleep(400);
			
			String msg = captureToastifyTopRightMessage();
			
			
			
	        System.out.println("Name: " + lName);
	        System.out.println("Email: " + email);
	        System.out.println("Phone: " + phoneNumber);
	        System.out.println("Company: " + company);
	        System.out.println("Address: " + address);
	        
	        return lName;
	        		
			
		}
	    
	    
	    
	    public void searchLeadTableEditLeadByName(String leadNameToSearch) {
	        try {
	            // Wait for table to be visible
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//div[@class='table-wrapper']//table")));

	            // Get all table rows
	            List<WebElement> rows = driver.findElements(By.xpath("//div[@class='table-wrapper']//table//tbody//tr"));

	            boolean leadFound = false;

	            for (WebElement row : rows) {
	                // Get the Lead Name from the second column (td[2])
	                String leadName = row.findElement(By.xpath("./td[2]")).getText().trim();

	                if (leadName.equalsIgnoreCase(leadNameToSearch)) {
	                    // Click the "Edit" icon in the Actions column (td[8] → <a class='edit'>)
	                    WebElement editButton = row.findElement(By.xpath("./td[8]/a[contains(@class, 'edit')]"));
	                    editButton.click();
	                    System.out.println("Navigated to Edit page for lead: " + leadName);
	                    leadFound = true;
	                    break;
	                }
	            }

	            if (!leadFound) {
	                System.out.println("Lead with name '" + leadNameToSearch + "' not found.");
	            }

	        } catch (Exception e) {
	            System.out.println("Error while trying to edit lead: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    
	    public void checkWebsiteFieldValidation(WebDriver driver, WebElement websiteInput) throws InterruptedException {
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // List of website test inputs and descriptions
	        List<Map<String, String>> websiteTests = new ArrayList<>();

	        websiteTests.add(Map.of("input", "", "desc", "Empty value"));
	        websiteTests.add(Map.of("input", "notAWebsite", "desc", "Invalid URL - no scheme"));
	        websiteTests.add(Map.of("input", "http://valid.com", "desc", "Valid URL - HTTP"));
	        websiteTests.add(Map.of("input", "https://secure.site", "desc", "Valid URL - HTTPS"));
	        websiteTests.add(Map.of("input", "www.missingprotocol.com", "desc", "Missing scheme"));
	        websiteTests.add(Map.of("input", "ftp://example.com", "desc", "Non-HTTP scheme"));
	        websiteTests.add(Map.of("input", "http:/broken.com", "desc", "Broken scheme"));
	        websiteTests.add(Map.of("input", "http://", "desc", "Scheme only"));
	        websiteTests.add(Map.of("input", "12345", "desc", "Numeric input"));

	        System.out.println("Website Field Validation Results:");
	        System.out.println("--------------------------------------------------------");

	        for (Map<String, String> test : websiteTests) {
	            String input = test.get("input");
	            String desc = test.get("desc");

	            // Clear the field and enter test value
	            websiteInput.clear();
	            websiteInput.sendKeys(input);

	            // Force form submission attempt
	            websiteInput.submit();  // or trigger the form's submit button if available

	            // Give browser time to process validation
	            Thread.sleep(500);

	            // Get validation message from browser
	            String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", websiteInput);

	            System.out.printf("Test: %-30s | Input: %-25s | Message: %s%n", desc, input, validationMsg);
	        }
	    }

	    
	    
	    
	 
	
}





