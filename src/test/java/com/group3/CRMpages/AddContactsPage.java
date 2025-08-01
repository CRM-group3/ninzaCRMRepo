package com.group3.CRMpages;

import java.time.Duration;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.group3.CRMbasics.BasePage;
import org.openqa.selenium.support.ui.Select;

public class AddContactsPage extends BasePage{
	
	public AddContactsPage(WebDriver driver) {
		
		super(driver);
	}
	
	
	@FindBy(xpath="//a[@href='/contacts' and text()='Contacts']")
	WebElement contacts;

	
	@FindBy(xpath="//button[@class='btn btn-info']")
	WebElement createContact;
	
	@FindBy(xpath="input[@name='contactId']")
	WebElement contactID;
	
	@FindBy(xpath="//*[@name='organizationName']")
	WebElement organization;
	
	@FindBy(xpath = "//input[@name='title']")
	WebElement titleField;
	
	
	@FindBy(xpath = "//*[@name='department']")
	WebElement dept;
	
	@FindBy(xpath = "//input[@type='tel']")
	WebElement officePh;
	
	@FindBy(xpath = "//*[@name='contactName']")
	WebElement contactNameField;
	
	@FindBy(xpath = "//input[@name='mobile']")
	WebElement mobileField;
	
	@FindBy(xpath = "//*[@name='email']")
	WebElement email;
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement campaignLookupButton;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement createContactSaveButton;
	
	@FindBy (xpath="(//button[@class='select-btn'][normalize-space()='Select'])[1]")
	WebElement selectButton;
	
	public boolean clickOnContacts() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(contacts));
	        contacts.click();
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public boolean clickOnCreateContact() {
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOf(createContact));
		        createContact.click();
		        return true;
		    } catch (Exception e) {
		        e.printStackTrace();
		        return false;
		    }
		}
	public void enterOrganization(String orgName) {
        organization.sendKeys(orgName);
    }

    public void enterTitle(String title) {
        titleField.sendKeys(title);
    }

    public void enterContactName(String name) {
        contactNameField.sendKeys(name);
    }

    public void enterMobile(String number) {
        mobileField.sendKeys(number);
    }

	

    public void selectCampaignFromLookup(String campaignName) {
		
		String mainWindow = driver.getWindowHandle();
	    campaignLookupButton.click(); // click the lookup icon/button

	    // Switch to the new campaign window
	    Set<String> allWindows = driver.getWindowHandles();
	    for (String window : allWindows) {
	        if (!window.equals(mainWindow)) {
	            driver.switchTo().window(window);
	            break;
	        
	        }
	    }
	        	   
	    
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    // Locate the select button next to the given campaign name
	    WebElement selectBtn = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("(//button[@class='select-btn'][normalize-space()='Select'])[1]")));

	    selectBtn.click();

	    // Switch back to main window
	    driver.switchTo().window(mainWindow);
	}             	   
	        
	    
	  
	  public void clickCreateContact() {
		  createContactSaveButton.click();
	    }
	  
//	  public String getSuccessMessage() {
//	        try {
//	            return new WebDriverWait(driver, Duration.ofSeconds(10))
//	                .until(ExpectedConditions.visibilityOf(successMessage))
//	                .getText();
//	        } catch (Exception e) {
//	            return null;
//	        }
	    //}
	  
	  public String generateUniqueContactId() {
		    return "CID_" + UUID.randomUUID().toString().substring(0, 8); // Shortened UUID
		}

}
  


