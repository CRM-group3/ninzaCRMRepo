package com.group3.CRMpages;

import java.time.Duration;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
//	@FindBy(xpath = "//*[@id='content']/div[2]/div[1]/div/div[1]/div/div[2]/button/span")
	WebElement createContact;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]/div/table/tbody/tr[1]/td[1]")
	//*[@id="content"]/div[2]/div[1]/div/table/tbody/tr[1]/td[1]
	WebElement contactID;
	
	@FindBy(xpath="//*[@name='organizationName']")
	public WebElement organization;
	
	 @FindBy(xpath = "//input[@name='title']")
	public WebElement titleField;
	
	
	@FindBy(xpath = "//*[@name='department']")
	public WebElement departmentField;
	
	@FindBy(xpath = "//input[@type='tel']")
	public WebElement officePhoneField;
	
	@FindBy(xpath = "//*[@name='contactName']")
	public WebElement contactNameField;
	
	@FindBy(xpath = "//input[@name='mobile']")
	public WebElement mobileField;
	
	@FindBy(xpath = "//*[@name='email']")
	public WebElement emailField;
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	public WebElement campaignLookupButton;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement createContactSaveButton;
	
	@FindBy (xpath="(//button[@class='select-btn'][normalize-space()='Select'])[1]")
	WebElement selectButton;
	
//	@FindBy(xpath ="//div[contains(text(), 'Successfully')]")
//	private WebElement alertMsg;
	
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
	
	

	public String getGeneratedContactId() {
	    return contactID.getText();
	}
	
	public void enterOrganization(String orgName) {
        organization.sendKeys(orgName);
		
////		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////		    WebElement orgField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("organizationName")));
////		    orgField.clear();
//		    orgField.sendKeys(orgName);
		}

   

    public void enterTitle(String title) {
        titleField.sendKeys(title);
    }
    
    public void enterTitle(String string1, String string2) {
		titleField.sendKeys(string1,string2);
		
	}

    public void enterDepartment(String dept) {
        departmentField.sendKeys(dept);
    }
    
    public void enterOfficePhone(String phone) {
      officePhoneField.sendKeys(phone);
    }
    
    public void enterContactName(String name) {
        contactNameField.sendKeys(name);
    }

    public void enterMobile(String number) {
        mobileField.sendKeys(number);
    }
    
    public void enterEmail(String email) {
       emailField.sendKeys(email);
    }
    
    public String getAlertText() {
        return driver.getPageSource(); 
    }
    
//	public boolean isFieldValid(WebElement element) {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		boolean isValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", element);
//        System.out.println("Valid: " + isValid);
//		return isValid;
//    }

	// Returns the validation message shown by the browser if the field is invalid.
	public String getValidationMessage(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 String tooltipMessage = (String) js.executeScript("return arguments[0].validationMessage;", element);
		 System.out.println("Tooltip Message: " + tooltipMessage);
		return tooltipMessage;
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
	  }
  


